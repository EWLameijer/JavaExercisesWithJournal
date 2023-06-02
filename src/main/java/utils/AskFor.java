package utils;

import java.util.Scanner;

public class AskFor {
    final private static Scanner in = new Scanner(System.in);

    public static int integer(String question) {
        System.out.print(question);
        return in.nextInt();
    }

    public static String string(String question) {
        System.out.print(question);
        return in.nextLine();
    }
}
