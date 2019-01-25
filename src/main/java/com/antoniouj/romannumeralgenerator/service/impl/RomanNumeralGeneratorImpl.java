package com.antoniouj.romannumeralgenerator.service.impl;

import com.antoniouj.romannumeralgenerator.exception.GenerateRomanNumeralFailedException;
import com.antoniouj.romannumeralgenerator.service.RomanNumeralGeneratorService;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.IntStream;

@Service
public class RomanNumeralGeneratorImpl implements RomanNumeralGeneratorService {

    /**
     *  LinkedHashMap containing the mapping between the numbers and roman numerals
     */
    private final LinkedHashMap<Integer, String> integerToRomanNumberMapper = new LinkedHashMap<Integer, String>() {{
        put(1000, "M");
        put(900, "CM");
        put(500, "D");
        put(400, "CD");
        put(100, "C");
        put(90, "XC");
        put(50, "L");
        put(40, "XL");
        put(10, "X");
        put(9, "IX");
        put(5, "V");
        put(4, "IV");
        put(1, "I");
    }};

    /**
     * Generate roman numeral from number passed in by using integerToRomanNumberMapper to map the number
     * to the corresponding numeral values required
     *
     * @param number to generate roman numeral from
     * @return String of roman numeral value generated
     * @throws GenerateRomanNumeralFailedException when number is out of range
     */
    @Override
    public String generate(int number) throws GenerateRomanNumeralFailedException {

        // Validates number within range specified otherwise throws GenerateRomanNumeralFailedException
        if (number >= 1 && number <= 3999) {

            // Initialises StringBuilder to append roman numerals to
            StringBuilder romanNumeral = new StringBuilder();

            // Iterates over the integerToRomanNumberMapper LinkedHashMap
            for (Map.Entry<Integer, String> entry : integerToRomanNumberMapper.entrySet()) {

                // Checks how many times the LinkedHashMap key divides into the number
                int timesDivided = number / entry.getKey();

                // If previous value is 0, do not append value to StringBuilder
                if (timesDivided != 0) {

                    // for times number was divided by key, append roman numeral to StringBuilder
                    IntStream.range(0, timesDivided).forEach(i -> romanNumeral.append(entry.getValue()));

                    // remove key from number
                    number = number - (entry.getKey() * timesDivided);
                }
            }

            // Collects the StringBuilder into a String and returns the value
            return romanNumeral.toString();
        } else {
            throw new GenerateRomanNumeralFailedException("Could not generate roman numeral as number : " + number + " is not between 1 and 3999");
        }
    }
}
