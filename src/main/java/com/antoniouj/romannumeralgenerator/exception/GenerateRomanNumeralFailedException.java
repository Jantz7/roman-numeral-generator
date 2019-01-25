package com.antoniouj.romannumeralgenerator.exception;

/**
 *  Custome Exception which is thrown when GenerateRomanNumeral fails
 */
public class GenerateRomanNumeralFailedException extends Exception {
    public GenerateRomanNumeralFailedException(String errorMessage) {
        super(errorMessage);
    }
}
