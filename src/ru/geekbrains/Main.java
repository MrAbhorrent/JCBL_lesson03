package ru.geekbrains;

import java.util.Random;
import java.util.Scanner;

public class Main {

    private static final String msgForExit = "Повторить игру еще раз? 1 – да / 0 – нет";
    private static final String txtCongratulation = "Поздравляем вы угадали число.";
    private static final String txtUnidentifiedValue = "Вы ввели не определенное значение";
    public static boolean flagEndGame;
    public static int TopBorder = 9;
    public static int AttemptCount = 3;
    public static int AnswerNumber;

    public static void main(String[] args) {

        // Написать программу, которая загадывает случайное число от 0 до 9 и пользователю дается 3 попытки угадать это число. При каждой попытке компьютер должен сообщить, больше ли
        // указанное пользователем число, чем загаданное, или меньше. После победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).
        flagEndGame = false;

        while (true) {
            System.out.println("Уважаемый пользователь, программа загадает случайное число от 0 до 9\nУ вас будет три попытки угадать это число.");
            int tempCount = 0;
            int randomNumber = getRandomNumber(TopBorder);
            do {
                if (tempCount < AttemptCount) {
                    System.out.print("Введите число от 0 до " + TopBorder + " : ");
                    // получаем у пользователя введеное число
                    AnswerNumber = getUserAnswer();
                } else {
                    System.out.println("Количество предоставленных попыток закончилось");
                    break;
                }
                tempCount++;
                if (AnswerNumber == randomNumber) {
                    //
                    flagEndGame = true;
                    System.out.println(txtCongratulation);
                } else {
                    System.out.println("\t- вы не угадали. Осталось попыток: " + (AttemptCount - tempCount));
                }
            } while (!flagEndGame) ;

            System.out.println(msgForExit);
            int AnswerUser1 = getUserAnswer();

            switch (AnswerUser1) {
                case 0:
                    return;
                case 1:
                    break;
                default:
                    System.out.println(txtUnidentifiedValue);
            }
        }
    }

    // Возвращаем случайное число в заданном диапазоне
    public static int getRandomNumber(int BorderNumber) {
        Random random = new Random();
        return random.nextInt(BorderNumber);
    }

    public static int getUserAnswer() {
        int userAnswer = -1;
        Scanner scanner = new Scanner(System.in);
        try {
            userAnswer = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Вы ввели не число");
            e.printStackTrace();
        }
        scanner.close();
        return userAnswer;
    }
}
