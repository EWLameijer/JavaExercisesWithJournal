package codewars;

// from https://www.codewars.com/kata/52685f7382004e774f0001f7/train/java
/*
Write a function, which takes a non-negative integer (seconds) as input and returns the time in a human-readable format (HH:MM:SS)

HH = hours, padded to 2 digits, range: 00 - 99
MM = minutes, padded to 2 digits, range: 00 - 59
SS = seconds, padded to 2 digits, range: 00 - 59
The maximum time never exceeds 359999 (99:59:59)
 */
// Stack overflow: padding with zeroes https://stackoverflow.com/questions/473282/how-can-i-pad-an-integer-with-zeros-on-the-left
public class HumanReadableTime {
    public static String makeReadable(int seconds) {
        int secondsOfMinute = seconds % 60;
        int totalMinutes = seconds / 60;
        int minutesOfHour = totalMinutes % 60;
        int hours = totalMinutes / 60;
        return String.format("%02d:%02d:%02d", hours, minutesOfHour, secondsOfMinute);
    }
}
