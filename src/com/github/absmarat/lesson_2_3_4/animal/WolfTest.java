package com.github.absmarat.lesson_2_3_4.animal;

public class WolfTest {
    public static void main(String[] args) {
        Wolf wolfOne = new Wolf();
        wolfOne.setGender("самец");
        wolfOne.setName("Вася");
        wolfOne.setWeight(20.6F);
        wolfOne.setAge(10);
        wolfOne.setColor("белый");
        System.out.println("Пол: " + wolfOne.getGender());
        System.out.println("Кличка: " + wolfOne.getName());
        System.out.println("Вес: " + wolfOne.getWeight());
        System.out.println("Возраст: " + wolfOne.getAge());
        System.out.println("Окрас: " + wolfOne.getColor());
        wolfOne.go();
        wolfOne.sit();
        wolfOne.run();
        wolfOne.howl();
        wolfOne.hunt();
    }
}