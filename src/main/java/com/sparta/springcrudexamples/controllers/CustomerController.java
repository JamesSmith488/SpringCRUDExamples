package com.sparta.springcrudexamples.controllers;

import com.sparta.springcrudexamples.entities.CustomersEntity;
import com.sparta.springcrudexamples.repositories.CustomersRepository;
import com.sparta.springcrudexamples.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CustomerController {

    private final CustomersRepository customersRepository;
    private final CustomerService customerService = new CustomerService();

    @Autowired
    public CustomerController(CustomersRepository customersRepository) {
        this.customersRepository = customersRepository;
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "index";
    }

    @GetMapping("/customers")
    public String getAllCustomers(Model model) {
        model.addAttribute("customers", customersRepository.findAll());
        return "customers";
    }

    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable("id") String id) {
        CustomersEntity customersEntity = customersRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Customer ID: " + id));
        customersRepository.delete(customersEntity);
        return "index";
    }

    @GetMapping("/edit/{id}")
    public String editcustomer(@PathVariable("id") String id, Model model) {
        CustomersEntity customersEntity = customersRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Customer ID: " + id));
        model.addAttribute("customer", customersEntity);
        return "edit-customer";
    }

    @PostMapping("/update-customer/{id}")
    public String updateCustomer(@ModelAttribute("customer") CustomersEntity updatedCustomer,
                                 @PathVariable("id") String id) {
        CustomersEntity customersEntity = customersRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Customer ID: " + id));
        customerService.update(updatedCustomer, customersEntity);
        customersRepository.save(customersEntity);
        return "index";
    }

    @GetMapping("/add-customer")
    public String addCustomer(Model model) {
        CustomersEntity customersEntity = new CustomersEntity();
        model.addAttribute("customer", customersEntity);
        return "add-customer";
    }

    @PostMapping("/save-customer")
    public String saveCustomer(@ModelAttribute("customer") CustomersEntity customersEntity) {
        customersRepository.save(customersEntity);
        return "saved-customer";
    }

    @GetMapping("/search-customer")
    public String searchCustomer() {
        return "search-customer";
    }

    @PostMapping("/search-results")
    public String searchResults(@ModelAttribute("customerName") String name, Model model) {
        List<CustomersEntity> foundCustomers = new ArrayList<>();
        for (CustomersEntity customersEntity: customersRepository.findAll()){
            if (customersEntity.getContactName().toLowerCase().contains(name.toLowerCase())) {
                foundCustomers.add(customersEntity);
            }
        }
        model.addAttribute("searchResults", foundCustomers);
        return "search-results";
    }

    @GetMapping("/access-denied")
    public String accessDenied() {
        return "access-denied";
    }

}