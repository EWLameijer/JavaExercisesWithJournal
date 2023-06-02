package kattis;

/*
https://open.kattis.com/problems/gandalfsspell
Gandalf's Spell
Today, Gandalf woke up from an awful dream that told him that the hobbit needs to
be mentally prepared for the journey ahead. So, Gandalf decided to create a spell where it would replace
every unique word in a sentence with a unique character. However, Gandalf is cheeky, so he decided to test
the hobbit by seeing whether he can check if this one-to-one mapping from word to character was satisfied given a
 string of characters and a sentence string. Your job is to put yourself in the position of the hobbit, and write
  the code so that it displays "True" if every character in the string maps to words in the sentence in the same order,
  with every unique character consistently mapping to the same unique word and every unique word consistently mapping
  to the same unique character. Otherwise, display "False". Do you think you got what it takes to be the next Hobbit?

Input
Input consists of two strings. The first line will contain the string of alphanumeric characters which will have from
 to
 characters. Then, the second line will contain the sentence string, where every word in the sentence will be
 space-separated, and the words can only contain alphanumeric characters. The sentence will have from
 to
 words and from
 to
 total characters.

Output
Display "True" if each character from the string of characters maps one-to-one to a unique word in the sentence string,
 and that this mapping is in the same order. Otherwise, display "False".

Sample Input 1	Sample Output 1
erf
why they they
False
Sample Input 2	Sample Output 2
abcdabcd
CCPC is the best CCPC is the best
True
Sample Input 3	Sample Output 3
a
The quick brown fox jumps over the lazy dog
False
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class GandalfsSpell {
    private static String capitalizeBool(boolean bool) {
        var rawString = Boolean.toString(bool);
        return rawString.substring(0,1).toUpperCase() + rawString.substring(1);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String chars = in.nextLine();
        String sentence = in.nextLine();
        String[] words = sentence.split(" ");
        boolean answer = match(chars, words);
        System.out.println(capitalizeBool(answer));
    }

    private static boolean match(String chars, String[] words) {
        if (words.length != chars.length()) return false;
        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            char currentChar = chars.charAt(i);
            String currentWord = words[i];
            if (map.containsKey(currentChar)) {
                if (!map.get(currentChar).equals(currentWord)) return false;
            } else {
                // map does not contain the current character; but does it contain the word?
                if (map.containsValue(currentWord)) return false;
                map.put(currentChar, currentWord);
            }
        }
        return true;
    }
}