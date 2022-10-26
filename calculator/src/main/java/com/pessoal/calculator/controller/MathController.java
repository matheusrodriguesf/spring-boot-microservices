package com.pessoal.calculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.pessoal.calculator.exception.UnsuportedMathOperationException;

@RestController
public class MathController {

    @GetMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
        validateInput(numberOne, numberTwo);
        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }

    @GetMapping("/subtraction/{numberOne}/{numberTwo}")
    public Double subtraction(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
        validateInput(numberOne, numberTwo);
        return convertToDouble(numberOne) - convertToDouble(numberTwo);
    }

    @GetMapping("/multiplication/{numberOne}/{numberTwo}")
    public Double multiplication(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
        validateInput(numberOne, numberTwo);
        return convertToDouble(numberOne) * convertToDouble(numberTwo);
    }

    @GetMapping("/division/{numberOne}/{numberTwo}")
    public Double division(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
        validateInput(numberOne, numberTwo);
        if(numberTwo.equals("0")) {
            throw new UnsuportedMathOperationException("Division by zero is not allowed");
        }
        return convertToDouble(numberOne) / convertToDouble(numberTwo);
    }

    @GetMapping("/mean/{numberOne}/{numberTwo}")
    public Double mean(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
        validateInput(numberOne, numberTwo);
        return (convertToDouble(numberOne) + convertToDouble(numberTwo)) / 2;
    }

    @GetMapping("/square-root/{number}")
    public Double squareRoot(@PathVariable("number") String number) {
        validateInput(number);
        return Math.sqrt(convertToDouble(number));
    }

    private void validateInput(String number){
        if(!isNumeric(number)) {
            throw new UnsuportedMathOperationException("Please set a numeric value");
        }
    }

    private void validateInput(String numberOne, String numberTwo) {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsuportedMathOperationException("Please set a numeric value!");
        }
    }

    private boolean isNumeric(String strNumber) {
        if (strNumber == null) {
            return false;
        }
        var number = strNumber.replaceAll(",", ".");
        return number.matches("[-+]?[\\d]*\\.?[\\d]+");
    }

    private Double convertToDouble(String strNumber) {
        if (strNumber == null) {
            return 0D;
        }
        var number = strNumber.replaceAll(",", ".");
        if (isNumeric(number)) {
            return Double.parseDouble(number);
        }
        return 0D;
    }
}
