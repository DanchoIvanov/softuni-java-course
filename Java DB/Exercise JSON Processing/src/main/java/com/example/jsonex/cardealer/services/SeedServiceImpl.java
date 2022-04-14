package com.example.jsonex.cardealer.services;

import com.example.jsonex.cardealer.entities.car.Car;
import com.example.jsonex.cardealer.entities.car.CarImportDTO;
import com.example.jsonex.cardealer.entities.customer.Customer;
import com.example.jsonex.cardealer.entities.customer.CustomerImportDTO;
import com.example.jsonex.cardealer.entities.part.Part;
import com.example.jsonex.cardealer.entities.part.PartImportDTO;
import com.example.jsonex.cardealer.entities.sale.Sale;
import com.example.jsonex.cardealer.entities.sale.SaleDiscount;
import com.example.jsonex.cardealer.entities.supplier.Supplier;
import com.example.jsonex.cardealer.entities.supplier.SupplierImportDTO;
import com.example.jsonex.cardealer.repositories.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class SeedServiceImpl implements SeedService {

    private static final Path SUPPLIERS_JSON_PATH =
            Path.of("src","main","resources","suppliers.json");

    private static final Path CARS_JSON_PATH =
            Path.of("src","main","resources","cars.json");

    private static final Path PARTS_JSON_PATH =
            Path.of("src","main","resources","parts.json");

    private static final Path CUSTOMERS_JSON_PATH =
            Path.of("src","main","resources","customers.json");

    private final CarRepository carRepository;
    private final CustomerRepository customerRepository;
    private final PartRepository partRepository;
    private final SaleRepository saleRepository;
    private final SupplierRepository supplierRepository;

    private final ModelMapper modelMapper;
    private final Gson gson;

    private Set<Integer> soldCarIds;
    private SaleDiscount saleDiscount;

    @Autowired
    public SeedServiceImpl(CarRepository carRepository, CustomerRepository customerRepository,
                           PartRepository partRepository, SaleRepository saleRepository,
                           SupplierRepository supplierRepository) {
        this.carRepository = carRepository;
        this.customerRepository = customerRepository;
        this.partRepository = partRepository;
        this.saleRepository = saleRepository;
        this.supplierRepository = supplierRepository;

        this.modelMapper = new ModelMapper();
        this.gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        this.soldCarIds = new HashSet<>();
        this.saleDiscount = new SaleDiscount();
    }


    @Override
    public void seedSuppliers() throws FileNotFoundException {
        FileReader fileReader = new FileReader(SUPPLIERS_JSON_PATH.toAbsolutePath().toString());
        SupplierImportDTO[] supplierImportDTOS = this.gson.fromJson(fileReader, SupplierImportDTO[].class);

        List<Supplier> suppliers = Arrays.stream(supplierImportDTOS)
                .map(importDTO -> this.modelMapper.map(importDTO, Supplier.class))
                .collect(Collectors.toList());

        this.supplierRepository.saveAll(suppliers);
    }

    @Override
    public void seedParts() throws FileNotFoundException {
        FileReader fileReader = new FileReader(PARTS_JSON_PATH.toAbsolutePath().toString());
        PartImportDTO[] partImportDTOS = this.gson.fromJson(fileReader, PartImportDTO[].class);

        List<Part> parts = Arrays.stream(partImportDTOS)
                .map(importDTO -> this.modelMapper.map(importDTO, Part.class))
                .map(this::setRandomSupplier)
                .collect(Collectors.toList());

        this.partRepository.saveAll(parts);
    }

    private Part setRandomSupplier(Part part) {
        Supplier supplier = getRandomSupplier().get();

        part.setSupplier(supplier);

        return part;

    }

    private Optional<Supplier> getRandomSupplier() {
        long supplierCount = this.supplierRepository.count();

        int randomSupplierId = new Random().nextInt((int) supplierCount) + 1;

        return this.supplierRepository.findById(randomSupplierId);
    }

    @Override
    public void seedCars() throws FileNotFoundException {
        FileReader fileReader = new FileReader(CARS_JSON_PATH.toAbsolutePath().toString());

        CarImportDTO[] carImportDTOS = this.gson.fromJson(fileReader, CarImportDTO[].class);

        List<Car> cars = Arrays.stream(carImportDTOS)
                .map(importDTO -> this.modelMapper.map(importDTO, Car.class))
                .map(this::set3to5RandomParts)
                .collect(Collectors.toList());

        carRepository.saveAll(cars);
    }

    private Car set3to5RandomParts(Car car) {

        int partsCount = new Random().nextInt(3, 5 + 1);

        HashSet<Part> parts = new HashSet<>();

        for (int i = 0; i < partsCount; i++) {
            Part part = getRandomPart().get();
            parts.add(part);
        }

        car.setParts(parts);
        return car;
    }

    private Optional<Part> getRandomPart() {

        long partsCount = this.partRepository.count();

        int randomPartId = new Random().nextInt(1, ((int) partsCount + 1));

        return partRepository.findById(randomPartId);

    }

    @Override
    public void seedCustomers() throws FileNotFoundException {
        FileReader fileReader = new FileReader(CUSTOMERS_JSON_PATH.toAbsolutePath().toString());
        CustomerImportDTO[] customerImportDTOS = this.gson.fromJson(fileReader, CustomerImportDTO[].class);

        List<Customer> customers = Arrays.stream(customerImportDTOS)
                .map(importDTO -> this.modelMapper.map(importDTO, Customer.class))
                .collect(Collectors.toList());

        this.customerRepository.saveAll(customers);
    }

    @Override
    public void seedSales() {

        int numberOfSalas = new Random().nextInt(30, 101);

        for (int i = 0; i < numberOfSalas; i++) {
            Sale sale = new Sale();
            sale.setCar(this.getRandomCar().get());
            sale.setCustomer(this.getRandomCustomer().get());
            sale.setDiscount(saleDiscount.getRandomDiscount());
            this.saleRepository.save(sale);
        }
    }


    private Optional<Customer> getRandomCustomer() {
        long customerCount = this.customerRepository.count();

        int randomCustomerId = new Random().nextInt((int)customerCount) + 1;

        return this.customerRepository.findById(randomCustomerId);
    }

    private Optional<Car> getRandomCar() {

        long carCount = this.carRepository.count();

        int randomCarId = 0;

        soldCarIds.add(randomCarId);

        while (soldCarIds.contains(randomCarId)) {
            randomCarId = new Random().nextInt((int) carCount) + 1;
        }

        soldCarIds.add(randomCarId);

        return this.carRepository.findById(randomCarId);
    }
}
