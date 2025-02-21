package com.github.absmarat.lesson_2_3_4.calculator;

import java.util.Scanner;

public class CalculatorTest {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner console = new Scanner(System.in);
        String answer = "yes";

        while (answer.equals("yes")) {
            System.out.print("Введите первое число: ");
            calculator.setFirstNumber(console.nextInt());

            System.out.print("Введите знак арифметической операции (+, -, *, /, ^, %): ");
            calculator.setOperation(console.next().charAt(0));

            System.out.print("Введите второе число: ");
            calculator.setSecondNumber(console.nextInt());

            calculator.calculate();
            console.nextLine();

            do {
                System.out.print("\nХотите продолжить вычисления? [yes/no]:  ");
                answer = console.nextLine();
            } while (!answer.equals("yes") && !answer.equals("no"));
        }
        console.close();
    }
}