package com.antoniouj.romannumeralgenerator;

import com.antoniouj.romannumeralgenerator.exception.GenerateRomanNumeralFailedException;
import com.antoniouj.romannumeralgenerator.service.RomanNumeralGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RomanNumeralGeneratorApplication implements CommandLineRunner {

    @Autowired
    private RomanNumeralGeneratorService romanNumeralGeneratorService;

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(RomanNumeralGeneratorApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

    @Override
    public void run(String... args) {

        // Call the RomanNumeralGeneratorService and print out value when successful.
        // When unsuccessful, print out the GenerateRomanNumeralFailedException message.
        try {
            System.out.println(romanNumeralGeneratorService.generate(2000));
        } catch (GenerateRomanNumeralFailedException e) {
            System.out.print(e.getMessage());
        }
    }
}
