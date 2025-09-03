package org.example;

import java.util.Scanner;

public class GetMultiplicationTable {

    public static boolean compareNumbers(int num1, int num2) {
        return num1 <= num2;
    }

    public static boolean isInRange(int number) {
        return number >= 1 && number <= 1000;
    }

    public static boolean checkRange(int num1, int num2) {
        return isInRange(num1) && isInRange(num2);
    }

    public static String validateAndGenerateTable(int startNumber, int endNumber) {
        if (!checkRange(startNumber, endNumber)) {
            return "error：数字必须在1到1000范围内";
        }
        if (!compareNumbers(startNumber, endNumber)) {
            return "error：startNumber必须小于等于endNumber";
        }
        return generateMultiplicationTable(startNumber, endNumber);
    }

    public static String generateMultiplicationTable(int startRow, int endRow) {
        StringBuilder table = new StringBuilder();
        for (int row = startRow; row <= endRow; row++) {
            table.append(generateSingleLine(row, startRow)).append("\n");
        }
        return table.toString();
    }

    public static String generateSingleLine(int row, int startRow) {
        StringBuilder line = new StringBuilder();
        for (int col = startRow; col <= row; col++) {
            line.append(col).append("x").append(row).append("=")
                    .append(col * row).append("\t");
        }
        return line.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("startNumber: ");
        int startNumber = scanner.nextInt();

        System.out.print("endNumber: ");
        int endNumber = scanner.nextInt();

        String result = validateAndGenerateTable(startNumber, endNumber);
        System.out.println(result);

    }
}