package model;

public class AtbashCipher implements CipherInterface {

    private String message;

    public AtbashCipher(){

    }
    public AtbashCipher(String message) {
        this.message = message;
    }


    @Override
    public String encrypt() {
            // convert plaintext to lowercase
            String messageLower = message.toLowerCase();

            // store encoded string
            String encoded = "";

            // traverse given string
            for (int i = 0; i < messageLower.length(); i++) {

                // get character at position i
                char ch = messageLower.charAt(i);

                // if character lies between a-z
                if (ch >= 'a' && ch <= 'z') {

                    // get its ASCII value
                    int ascii = (int)ch;

                    // convert it to Atbash
                    ascii = 'z' - (ascii - 'a');

                    // convert ASCII value to character
                    char c = (char)ascii;

                    // append to encoded string
                    encoded += c;
                }
                else {
                    // append same character
                    encoded += ch;
                }
            }

            // return encoded string
            return encoded;
        }

    @Override
    public String decrypt() {
        // convert plaintext to lowercase
        String encoded = message.toLowerCase();

        // store decoded string
        String decoded = "";

        // traverse given string
        for (int i = 0; i < encoded.length(); i++) {

            // get character at position i
            char ch = encoded.charAt(i);

            // if character lies between a-z
            if (ch >= 'a' && ch <= 'z') {

                // get its ASCII value
                int ascii = (int)ch;

                // convert it to Atbash
                ascii = 'z' - (ascii - 'a');

                // convert ASCII value to character
                char c = (char)ascii;

                // append to decoded string
                decoded += c;
            }
            else {
                // append same character
                decoded += ch;
            }
        }

        // return decoded string
        return decoded;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
