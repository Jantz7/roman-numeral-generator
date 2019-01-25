package com.antoniouj.romannumeralgenerator.service;

import com.antoniouj.romannumeralgenerator.exception.GenerateRomanNumeralFailedException;

public interface RomanNumeralGeneratorService {

    /**
     * Generate the roman numeral value of the passed in number
     *
     * @param number to generate roman numeral from
     * @return String of roman numeral value generated
     * @throws GenerateRomanNumeralFailedException when unable to generate number
     */
    String generate(int number) throws GenerateRomanNumeralFailedException;
}
