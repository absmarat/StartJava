package com.github.absmarat.lesson_2_3_4.array;

public class Triangle {
    public static void main(String[] args) {
        int startPoint = 48;
        int endPoint = 57;
        boolean isIncrement = true;
        String triangle = (create(startPoint, endPoint, isIncrement));
        print(triangle);

        startPoint = 47;
        endPoint = 105;
        isIncrement = false;
        triangle = (create(startPoint, endPoint, isIncrement));
        print(triangle);

        startPoint = 65;
        endPoint = 74;
        isIncrement = false;
        triangle = (create(startPoint, endPoint, isIncrement));
        print(triangle);
    }

    private static String create(int startPoint, int endPoint, boolean isIncrement) {
        int count = 1;
        int space = endPoint - startPoint;
        StringBuilder triangle = new StringBuilder();
        if (isIncrement) {
            for (int i = startPoint; i <= endPoint; i++) {
                triangle = triangle.append(" ".repeat(space)).repeat(startPoint, count).append("\n");
                space--;
                count += 2;
                startPoint++;
            }
        } else {
            for (int i = endPoint; i >= startPoint; i--) {
                triangle = triangle.append(" ".repeat(space)).repeat(endPoint, count).append("\n");
                count += 2;
                space--;
                endPoint--;
            }
        }
        return triangle.toString();
    }

    private static void print(String triangle) {
        System.out.println(triangle);
    }
}
