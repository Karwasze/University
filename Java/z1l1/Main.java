package com.company;

public class Main {

    private static String[] rzymskie = {
            "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"
    };

    private static int[] arabskie = {
            1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1
    };

    public static void main(String[] args) {

        for (int i = 0; i < args.length; i++) {
            try {
                int x = new Integer(args[i]);
                if (x < 0 || x > 5000) {
                    throw new IllegalArgumentException("liczba " + x + " spoza zakresu 1-4999");
                }
                System.out.print(x + " ");
                for (int j = 0; j < arabskie.length; j++) {
                    while (x >= arabskie[j]) {
                        x -= arabskie[j];
                        System.out.print(rzymskie[j]);
                    }

                }
                System.out.println();
            } catch (NumberFormatException b) {
                System.out.println("Podany napis nie jest liczbą");
            } catch (IllegalArgumentException a) {
                System.out.println("Podana liczba jest spoza zakresu");
            }
        }
    }
}