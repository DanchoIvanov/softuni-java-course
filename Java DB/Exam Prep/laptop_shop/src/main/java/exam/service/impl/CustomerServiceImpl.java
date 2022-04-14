package exam.service.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import exam.model.customer.Customer;
import exam.model.customer.ImportCustomerDTO;
import exam.model.town.Town;
import exam.repository.CustomerRepository;
import exam.repository.TownRepository;
import exam.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Optional;
import java.util.Set;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final Path path = Path.of("src", "main", "resources", "files", "json", "customers.json");

    private final CustomerRepository customerRepository;
    private final TownRepository townRepository;

    private final Gson gson;
    private final ModelMapper modelMapper;
    private final Validator validator;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, TownRepository townRepository) {
        this.customerRepository = customerRepository;
        this.townRepository = townRepository;

        this.gson = new GsonBuilder().create();

        this.modelMapper = new ModelMapper();

        this.modelMapper.addConverter(ctx -> LocalDate.parse(ctx.getSource(), DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                String.class, LocalDate.class);

        this.validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Override
    public boolean areImported() {
        return customerRepository.count() > 0;
    }

    @Override
    public String readCustomersFileContent() throws IOException {
        return Files.readString(path);
    }

    @Override
    public String importCustomers() throws IOException {

        StringBuilder result = new StringBuilder();

        String json = this.readCustomersFileContent();

        ImportCustomerDTO[] customerDTOs = gson.fromJson(json, ImportCustomerDTO[].class);

        Arrays.stream(customerDTOs)
                .map(this::importCustomer)
                .forEach(r -> result.append(r).append(System.lineSeparator()));

        return result.toString().trim();
    }

    private String importCustomer(ImportCustomerDTO importCustomerDTO) {

        Set<ConstraintViolation<ImportCustomerDTO>> constraintViolations = this.validator.validate(importCustomerDTO);

        if (constraintViolations.isEmpty()) {
            Optional<Customer> optionalCustomer = this.customerRepository.findByEmail(importCustomerDTO.getEmail());

            if (optionalCustomer.isEmpty()) {
                Customer customer = this.modelMapper.map(importCustomerDTO, Customer.class);
                Town town = this.townRepository.findByName(importCustomerDTO.getTown().getName());

                customer.setTown(town);
                this.customerRepository.save(customer);

                return String.format("Successfully imported Customer %s %s - %s", customer.getFirstName(),
                        customer.getLastName(), customer.getEmail());
            } else {
                return "Invalid Customer";
            }
        } else {
            return "Invalid Customer";
        }
    }
}
