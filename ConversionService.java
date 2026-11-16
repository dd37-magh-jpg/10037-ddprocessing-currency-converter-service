package com.example.currencyconverter;

import org.springframework.stereotype.Service;

@Service
public class ConversionService {
    
    public double usdToInr(double usd) {
        return usd * 84.50;
    }

    public double usdToEur(double usd) {
        return usd * 0.92;
    }
}