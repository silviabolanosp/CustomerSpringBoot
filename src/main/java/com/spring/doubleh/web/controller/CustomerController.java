package com.spring.doubleh.web.controller;

import com.spring.doubleh.persistence.model.Customer;
import com.spring.doubleh.service.CustomerService;
import org.apache.tomcat.util.http.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.Locale;
import java.util.Optional;

@Controller
@RequestMapping("/web")
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @GetMapping("/index")
    public String showHome(final Locale locale, final Model model){
        model.addAttribute("customers", customerService.findAll());
        return "index";
    }

    @GetMapping("/show/{id}")
    public String showCustomer(Model model, @PathVariable long id){
        try{
            Customer customer = customerService.findById(id);
            model.addAttribute("customer", customer);
        } catch(Exception e){
            model.addAttribute("error", e.getLocalizedMessage());
        }
        return "customer";
    }

    @GetMapping("/show")
    public String showCustomer(final Locale locale, final Model model){
        model.addAttribute("customer", new Customer());
        return "customer";
    }
    @GetMapping("/showCreate")
    public String createCustomer(final Locale locale, final Model model){
        model.addAttribute("customer", new Customer());
        return "createCustomer";
    }

    @PostMapping("/update/{id}")
    public String updateCustomer(final Locale locale, final Model model, @ModelAttribute("customer") Customer customer){
        customerService.save(customer);
        model.addAttribute("message", "Save Successful");
        return "redirect:/web/index";
    }

    @PostMapping("/create")
    public String createCustomer(final Locale locale, final Model model, @ModelAttribute("customer") Customer customer){
        customerService.save(customer);
        model.addAttribute("message", "Save Successful");
        return "redirect:/web/index";
    }

    @GetMapping("/delete/{id}")
    public String deleteCustomer(final Locale locale, final Model model, @PathVariable long id){
        try {
            customerService.deleteById(id);
            model.addAttribute("message", "Delete Successful");
        } catch(RuntimeException e){
            model.addAttribute("error", e.getLocalizedMessage());
        }
        return "redirect:/web/index";
    }

}
