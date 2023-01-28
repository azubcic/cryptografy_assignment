package model;

public class VigenereCipher implements CipherInterface {

    private String message;
    private String keyWord;

    public VigenereCipher() {

    }

    public VigenereCipher(String message, String keyWord) {
        this.message = message;
        this.keyWord = keyWord;
    }

    @Override
    public String encrypt() {
        StringBuilder result = new StringBuilder();
        String messageUpper = message.toUpperCase();
        String keyWordUpper = removeNumbersFromString(keyWord).toUpperCase();
        for (int i = 0, j = 0; i < messageUpper.length(); i++)
        {
            char c = messageUpper.charAt(i);
            if (c < 'A' || c > 'Z')
                continue;
            result.append((char) ((c + keyWordUpper.charAt(j) - 2 * 'A') % 26 + 'A'));
            j = ++j % keyWordUpper.length();
        }
        return result.toString();
    }

    @Override
    public String decrypt() {
        StringBuilder result = new StringBuilder();
        String messageUpper = message.toUpperCase();
        String keyWordUpper = removeNumbersFromString(keyWord).toUpperCase();
        for (int i = 0, j = 0; i < messageUpper.length(); i++) {
            char c = messageUpper.charAt(i);
            if (c < 'A' || c > 'Z')
                continue;
            result.append((char) ((c - keyWordUpper.charAt(j) + 26) % 26 + 'A'));
            j = ++j % keyWordUpper.length();
        }
        return result.toString();
    }

    public static String removeNumbersFromString(String inputString) {
        // Create a StringBuilder object
        StringBuilder sb = new StringBuilder();

        // Traverse through the string
        for (int i = 0; i < inputString.length(); i++) {

            // Check if the character is a number
            if (!Character.isDigit(inputString.charAt(i))) {
                // Append the character to the StringBuilder
                sb.append(inputString.charAt(i));
            }
        }

        // Return the string without numbers
        return sb.toString();
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }
}
