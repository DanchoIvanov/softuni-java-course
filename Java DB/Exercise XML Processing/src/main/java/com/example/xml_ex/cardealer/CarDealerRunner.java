package com.example.xml_ex.cardealer;

import com.example.xml_ex.cardealer.services.CustomerService;
import com.example.xml_ex.cardealer.services.SeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CarDealerRunner implements CommandLineRunner {
    private final SeedService seedService;
    private final CustomerService customerService;


    @Autowired
    public CarDealerRunner(SeedService seedService, CustomerService customerService) {
        this.seedService = seedService;
        this.customerService = customerService;

    }

    @Override
    public void run(String... args) throws Exception {

//        this.seedService.seedSuppliers();
//        this.seedService.seedParts();
//        this.seedService.seedCars();
//        this.seedService.seedCustomers();
//        this.seedService.seedSales();


    }
}
