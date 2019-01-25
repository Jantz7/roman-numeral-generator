package com.antoniouj.romannumeralgenerator.service.impl;

import com.antoniouj.romannumeralgenerator.exception.GenerateRomanNumeralFailedException;
import com.antoniouj.romannumeralgenerator.service.RomanNumeralGeneratorService;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RomanNumeralGeneratorServiceImplTest {

    private static final int VALID_NUMBER_MIN = 1;
    private static final String VALID_ROMAN_NUMERAL_MIN = "I";
    private static final int VALID_NUMBER_MID = 1999;
    private static final String VALID_ROMAN_NUMERAL_MID = "MCMXCIX";
    private static final int VALID_NUMBER_MAX = 3999;
    private static final String VALID_ROMAN_NUMERAL_MAX = "MMMCMXCIX";
    private static final int INVALID_NUMBER_RANGE = 4000;
    private static final String INVALID_NUMBER_RANGE_MESSAGE = "Could not generate roman numeral as number : " +
            INVALID_NUMBER_RANGE + " is not between 1 and 3999";

    @Autowired
    private RomanNumeralGeneratorService romanNumeralGeneratorService;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void before() {
        romanNumeralGeneratorService = new RomanNumeralGeneratorImpl();
    }

    @Test
    public void testGenerateRomanNumber_validNumberMin() throws GenerateRomanNumeralFailedException {

        String generatedRomanNumeral = romanNumeralGeneratorService.generate(VALID_NUMBER_MIN);

        assertEquals(VALID_ROMAN_NUMERAL_MIN, generatedRomanNumeral);
    }

    @Test
    public void testGenerateRomanNumber_validNumberMid() throws GenerateRomanNumeralFailedException {

        String generatedRomanNumeral = romanNumeralGeneratorService.generate(VALID_NUMBER_MID);

        assertEquals(VALID_ROMAN_NUMERAL_MID, generatedRomanNumeral);
    }

    @Test
    public void testGenerateRomanNumber_validNumberMax() throws GenerateRomanNumeralFailedException {

        String generatedRomanNumeral = romanNumeralGeneratorService.generate(VALID_NUMBER_MAX);

        assertEquals(VALID_ROMAN_NUMERAL_MAX, generatedRomanNumeral);
    }

    @Test
    public void testGenerateRomanNumber_invalidRangeNumber() throws GenerateRomanNumeralFailedException {

        thrown.expect(GenerateRomanNumeralFailedException.class);
        thrown.expectMessage(INVALID_NUMBER_RANGE_MESSAGE);

        romanNumeralGeneratorService.generate(INVALID_NUMBER_RANGE);

    }
}
