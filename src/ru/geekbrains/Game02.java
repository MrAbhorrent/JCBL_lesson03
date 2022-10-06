package ru.geekbrains;

import java.util.Random;
import java.util.Scanner;

public class Game02 {

    public static final String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

    public static String userAnswer, guessWord;
    public static String maskGuessed = "";
    public static int Array_Size;
    public static boolean UserVictory = false;


    public static void main(String[] args) {

        System.out.println("Компьютер загадал слово, попробуйте его отгадать.");
        Scanner scanner = new Scanner(System.in);
        Array_Size = words.length;
        guessWord = words[getRandomNumber(Array_Size)];
        do {
            maskGuessed = "";
            System.out.print("Введите слово: ");
            userAnswer = scanner.nextLine();
            if (compareTwoWords(userAnswer, guessWord)) {
                System.out.println("Поздравляем вы угадали слово");
                UserVictory = true;
            } else {
                System.out.println(printGuessWord(guessWord, maskGuessed));
            }
        } while (!UserVictory);
    }

    // Печатаем загаданное слово
    private static String printGuessWord(String Str, String maskStr) {
        StringBuilder outputStr = new StringBuilder();
        int lengthStr = Str.length();
        for (int i = 0; i < 15; i++) {
            if (i < lengthStr) {
                if (maskStr.charAt(i) == '1') {
                    outputStr.append(Str.charAt(i));
                } else {
                    outputStr.append("*");
                }
            } else {
                outputStr.append("*");
            }
        }
        return outputStr.toString();
    }

    // Возвращаем случайное число в заданном диапазоне
    public static int getRandomNumber(int TopBorder) {
        Random random = new Random();
        return random.nextInt(TopBorder);
    }

    // Сравниваем два слова посимвольно
    public static boolean compareTwoWords(String FirstWord, String SecondWord) {
        int CountGuessed = 0;
        boolean compareResult = false;
        int lengthFirstWord = FirstWord.length();
        int lengthSecondWord  = SecondWord.length();
        // Цикл посимвольного сравнения будет по длине более короткого слова
        int MaxLength = Math.min(lengthFirstWord, lengthSecondWord);
        for (int i = 0; i < MaxLength; i++) {
            if (FirstWord.charAt(i) == SecondWord.charAt(i)) {
                CountGuessed++;
                maskGuessed += 1;
            } else {
                maskGuessed += 0;
            }
        }
        if ((lengthFirstWord == lengthSecondWord) && (CountGuessed == MaxLength)) {
            compareResult = true;
        }
        return compareResult;
    }
}
