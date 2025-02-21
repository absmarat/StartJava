package com.github.absmarat.lesson_2_3_4.calculator;

public class Calculator {
    
    private int firstNumber;
    private int secondNumber;
    private char operation;
    
    public void setFirstNumber(int firstNumber) {
        this.firstNumber = firstNumber;
    }
    
    public void setSecondNumber(int secondNumber) {
        this.secondNumber = secondNumber;
    }
    
    public void setOperation(char operation) {
        this.operation = operation;
    }

    public void calculate() {
        double result = 0;
        switch (operation) {
            case '+':
                result = firstNumber + secondNumber;
                break;
            case '-':
                result = firstNumber - secondNumber;
                break;
            case '*':
                result = firstNumber * secondNumber;
                break;
            case '/':
                if (secondNumber == 0) {
                    System.out.println("Ошибка: деление на ноль запрещено!");
                    return;
                }
                result = firstNumber / secondNumber;
            case '^':
                result = 1;
                if (secondNumber < 0) {
                    for (int i = secondNumber; i < 0; i++) {
                        result *= firstNumber;
                    }
                    result = 1 / result;
                } else {
                    for (int i = 1; i <= secondNumber; i++) {
                        result *= firstNumber;
                    }
                }
                break;
            case '%':
                result = firstNumber % secondNumber;
                break;
            default:
                System.out.println("Ошибка! Операция " + operation + " не поддерживается.");
                return;
        }
        System.out.println("Результат вычисления: " + result); 
    }
}