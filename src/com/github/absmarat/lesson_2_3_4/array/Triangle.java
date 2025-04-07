package com.github.absmarat.lesson_2_3_4.array;

public class Triangle {
    public static void main(String[] args) {
        boolean isAscendingSort = true;
        String triangle = (create(48, 57, isAscendingSort));
        print(triangle);

        isAscendingSort = false;
        triangle = (create(105, 47, isAscendingSort));
        print(triangle);

        isAscendingSort = false;
        triangle = (create(65, 74, isAscendingSort));
        print(triangle);
    }

    private static String create(int startPoint, int endPoint, boolean isAscendingSort) {
        if (startPoint > endPoint) {
            System.out.println("Ошибка: левая граница (" + startPoint + ") > правой (" + endPoint + ")");
        }

        int count = 1;
        int space = endPoint - startPoint;
        StringBuilder triangle = new StringBuilder();
        if (isAscendingSort) {
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
