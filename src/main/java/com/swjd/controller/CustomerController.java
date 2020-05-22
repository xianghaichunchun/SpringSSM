package com.swjd.controller;

import com.swjd.bean.Customer;
import com.swjd.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/customerController")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    //能狗跳转到主页面,并且
    @RequestMapping("/toMain")
    public String toMain(Model model){
        List<Customer> list=new ArrayList<>();
        list=customerService.getlist();

        Customer customer=new Customer();
        model.addAttribute("customer",customer);

        model.addAttribute("list",list);

        return "main";
    }
}
