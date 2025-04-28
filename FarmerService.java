package com.example.farmingapp.service;

import com.example.farmingapp.entity.Farmer;
import com.example.farmingapp.repository.FarmerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FarmerService {

    @Autowired
    private FarmerRepository farmerRepository;

    // Method to authenticate the farmer by email and password
    public boolean authenticateFarmer(String email, String password) {
        // Find the farmer by email
        Farmer farmer = farmerRepository.findByEmail(email);

        // Check if farmer exists and password matches
        if (farmer != null && farmer.getPassword().equals(password)) {
            return true;  // Successful authentication
        }
        return false;  // Authentication failed
    }

    // Method to register a new farmer
    public void registerFarmer(Farmer farmer) {
        farmerRepository.save(farmer);  // Save farmer to the database
    }
}
