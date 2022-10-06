package ru.geekbrains;

public class Task1 {

    public static void main(String[] args) {

        // 1. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
        System.out.println("Задание 4");
        int lengthArray = 5;
        int[][] sampleArray4 = new int[lengthArray][lengthArray];
        for (int i = 0; i < lengthArray; i++) {
            sampleArray4[i][i] = 1;
            sampleArray4[i][lengthArray - 1 - i] = 1;
        }
        printTwoDimentionArray(sampleArray4);
        System.out.println("===");
    }

    //
    private static void printTwoDimentionArray(int[][] array) {
        System.out.println("[");
        for (int[] ints : array) {
            System.out.print("[ " + ints[0]);
            for (int j = 1; j < ints.length; j++) {
                System.out.printf(", %4d", ints[j]);
            }
            System.out.println("]");
        }
        System.out.println("]");
    }

}
