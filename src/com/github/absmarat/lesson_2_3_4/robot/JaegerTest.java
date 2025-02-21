package com.github.absmarat.lesson_2_3_4.robot;

public class JaegerTest {

    public static void main(String[] args) {
        Jaeger robot1 = new Jaeger();
        robot1.setModelName("Багровый Тайфун");
        robot1.setOrigin("Китай");
        robot1.setArming("Плазмотрон");
        robot1.setHeight(76.2F);
        robot1.setWeight(1722F);

        System.out.println("Имя робота: " + robot1.getModelName() + "\n" + 
                "Происхождение: " + robot1.getOrigin() + "\n" + 
                "Вооружение: " + robot1.getArming() + "\n" +
                "Высота в метрах: " + robot1.getHeight() + "\n" +
                "Вес в тоннах: " + robot1.getWeight());
        robot1.run();
        robot1.fly();
        Jaeger robot2 = new Jaeger("Страйкер Эврика", "Австралия", "Нагрудный гранатомёт",
                76.2F, 6650F);
        System.out.println("\nИмя робота: " + robot2.getModelName() + "\n" + 
                "Происхождение: " + robot2.getOrigin() + "\n" + 
                "Вооружение: " + robot2.getArming() + "\n" +
                "Высота в метрах: " + robot2.getHeight() + "\n" +
                "Вес в тоннах: " + robot2.getWeight());
        robot2.run();
    }
}