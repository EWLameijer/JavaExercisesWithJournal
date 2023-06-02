package exercism;

class SqueakyClean {
    static String clean(String identifier) {
        var spacesReplaced = spacesToUnderscores(identifier);
        var ctrlsReplaced = ctrlsToLetters(spacesReplaced);
        var toCamel = kebabToCamel(ctrlsReplaced);
        var toLettersAndUndOnly = removeNonLettersOrUnderscores(toCamel);
        return removeLowerCaseGreekLetters(toLettersAndUndOnly);
    }

    private static String removeLowerCaseGreekLetters(String input) {
        return input.replaceAll("[α-ω]", "");
    }

    private static String removeNonLettersOrUnderscores(String input) {
        StringBuilder result = new StringBuilder();
        for (char ch : input.toCharArray()) {
            if (ch == '_' || Character.isLetter(ch)) result.append(ch);
        }
        return result.toString();
    }

    private static String kebabToCamel(String input) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (currentChar == '-' && i < input.length() - 1) {
                i++;
                result.append(Character.toUpperCase(input.charAt(i)));
            } else result.append(currentChar);
        }
        return result.toString();
    }

    private static String ctrlsToLetters(String input) {
        // from https://stackoverflow.com/questions/9057083/remove-all-control-characters-from-a-java-string
        return input.replaceAll("\\p{Cntrl}", "CTRL");
    }

    private static String spacesToUnderscores(String input) {
        return input.replaceAll(" ", "_");
    }
}
