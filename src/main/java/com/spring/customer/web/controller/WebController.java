package com.spring.customer.web.controller;


import com.spring.customer.model.Customer;
import com.spring.customer.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/web")
public class WebController {

    private CustomerService customerService;

    public WebController(CustomerService customerService){
        this.customerService = customerService;
    }


    @GetMapping("/index.html")
    public String showHome(Model model){
        model.addAttribute("customers", customerService.findAll());
        return "index.html";
    }

    @GetMapping("/show/{id}")
    public String showCustomer(Model model, @PathVariable long id){
        try{
            Customer customer = customerService.findById(id);
            model.addAttribute("customer", customer);
        } catch(Exception e){
            model.addAttribute("error", e.getLocalizedMessage());
        }
        return "customer.html";
    }

    @GetMapping("/show")
    public String showCustomer(Model model){

        model.addAttribute("customer", new Customer());

        return "customer.html";
    }
    @GetMapping("/showCreate")
    public String createCustomer(Model model){

        model.addAttribute("customer", new Customer());

        return "createCustomer.html";
    }

    @PostMapping("/update/{id}")
    public String updateCustomer(Model model, @ModelAttribute("customer") Customer customer){
        customerService.save(customer);

        model.addAttribute("message", "Save Successful");

        return "redirect:/web/index.html";
    }

    @PostMapping("/create")
    public String createCustomer(Model model, @ModelAttribute("customer") Customer customer){
        customerService.save(customer);

        model.addAttribute("message", "Save Successful");

        return "redirect:/web/index.html";
    }

    @GetMapping("/delete/{id}")
    public String deleteCustomer(Model model, @PathVariable long id){
        try {
            customerService.deleteById(id);
            model.addAttribute("message", "Delete Successful");
        } catch(RuntimeException e){
            model.addAttribute("error", e.getLocalizedMessage());
        }

        return "redirect:/web/index.html";
    }

}
