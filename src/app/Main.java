package app;

import java.util.Random;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Змінні
        int negativeSum = 0; // відємні_ч_сумма
        int evenSum = 0; // парні числа
        int oddSum = 0; // непарні числа
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int sum = 0; //перше відємне число сума
        int count = 0; // к-сть числе після перщого відємного
        boolean foundNegative = false;

        // Створюємо масив з випадковими числами
        int[] random = new Random().ints(20, -100, 101).toArray();

        // Виведення масиву
        System.out.println("Random Array: " + Arrays.toString(random));

        // Обробка масиву
        for (int number : random) {
            if (number < 0) negativeSum += number; // Від'ємні числа
            if (number % 2 == 0) evenSum++;
            else oddSum++;

            if (number < min) min = number;
            if (number > max) max = number;

            // Обчислення після першого від'ємного числа
            if (foundNegative) {
                sum += number;
                count++;
            } else if (number < 0) {
                foundNegative = true;
            }
        }

        // Виведення результатів
        System.out.println(
                //"Array elements: " + Arrays.toString(random) + "\n" +
                        "Sum of negative numbers: " + negativeSum + "\n" +
                        "Sum of even numbers: " + evenSum + "\n" +
                        "Numbers of odd numbers: " + oddSum + "\n" +
                        "Smallest element: " + min + "\n" +
                        "Largest element: " + max + "\n" +
                        (count > 0
                                ? "Середнє арифметичне чисел після першого від'ємного числа: " + String.format("%.2f", (double) sum / count)
                                : "")
        );
    }
}
