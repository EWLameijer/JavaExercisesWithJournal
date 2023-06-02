package smallexercises.hexadecimaltooctal;

/*
https://www.w3resource.com/java-exercises/basic/index.php
Write a Java program to convert a hexadecimal to a octal number.
Input Data:
Input a hexadecimal number: 40
Expected Output

Equivalent octal number: 100
** HINT: Check the Java standard library. You're working with whole numbers
here, so Integer (the wrapper class of int,
   as int is a primitive and therefore cannot have any methods) may be of use :)
 */

import utils.AskFor;

import java.util.Scanner;

public class HexadecimalToOctal {
    public static void main(String[] args) {
        String hexadecimalNumber = AskFor.string("Input a hexadecimal number: ");
        int number = Integer.parseInt(hexadecimalNumber, 16);
        System.out.print("Equivalent octal number: " + Integer.toOctalString(number));
    }
}
