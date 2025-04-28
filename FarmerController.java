package com.example.farmingapp.controller;

import com.example.farmingapp.entity.Farmer;
import com.example.farmingapp.service.FarmerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FarmerController {

    @Autowired
    private FarmerService farmerService;

    @GetMapping("/farmer/login")
    public String showFarmerLoginPage() {
        return "farmer_login";  // renders farmer_login.html
    }

    @PostMapping("/farmer/login")
    public String loginFarmer(String email, String password) {
        // Your login logic here, possibly redirect to farmer dashboard
        return "farmer_dashboard";  // Redirect to dashboard
    }

    @GetMapping("/farmer/signup")
    public String showFarmerSignupPage() {
        return "farmer_signup";  // renders farmer_signup.html
    }

    @PostMapping("/farmer/signup")
    public String registerFarmer(Farmer farmer) {
        farmerService.registerFarmer(farmer);
        return "farmer_login";  // Redirect to login page after signup
    }
}