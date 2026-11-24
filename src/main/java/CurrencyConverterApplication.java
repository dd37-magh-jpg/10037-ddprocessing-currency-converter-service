package com.example.currencyconverter;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CurrencyConverterApplication implements ApplicationRunner {

    private final ConversionService conversionService;

    public CurrencyConverterApplication(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    public static void main(String[] args) {
        SpringApplication.run(CurrencyConverterApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) {
        //Double to 10 USD if no --amount argument is provided
        double amount = 10.0;

        if (args.containsOption("amount")){
            String value = args.getOptionValues("amount").get(0);
            amount = Double.parseDouble(value);
        }    

        System.out.println("== Qick curr conv ===")
        System.out.printf("%.2f is %.2f",amount, conversionService.usdToInr(amount));
        System.out.printf("%.2f is %.2f",amount, conversionService.usdToEur(amount));
        
    }
}
