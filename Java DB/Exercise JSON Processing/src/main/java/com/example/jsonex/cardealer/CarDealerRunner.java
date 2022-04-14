package com.example.jsonex.cardealer;

import com.example.jsonex.cardealer.entities.customer.Customer;
import com.example.jsonex.cardealer.services.CustomerService;
import com.example.jsonex.cardealer.services.SeedService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.util.List;

@Component
public class CarDealerRunner implements CommandLineRunner {
    private final SeedService seedService;
    private final CustomerService customerService;

    private final Gson gson;

    @Autowired
    public CarDealerRunner(SeedService seedService, CustomerService customerService) {
        this.seedService = seedService;
        this.customerService = customerService;
        this.gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
    }

    @Override
    public void run(String... args) throws Exception {

//        this.seedService.seedSuppliers();
//        this.seedService.seedParts();
//        this.seedService.seedCars();
//        this.seedService.seedCustomers();
//        this.seedService.seedSales();


        List<Customer> customers = customerService.getOrderedCustomers();

        String json = gson.toJson(customers);

        System.out.println(json);
    }
}
