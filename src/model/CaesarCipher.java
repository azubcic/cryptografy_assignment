package model;

public class CaesarCipher implements CipherInterface {

    private String message;
    private int shiftKey;
    public final String ALPHA = "abcdefghijklmnopqrstuvwxyz";

    public CaesarCipher() {

    }

    public CaesarCipher(String message, int shiftKey) {
        this.message = message;
        this.shiftKey = shiftKey;
    }

    @Override
    public String encrypt() {
        message = message.toLowerCase();
        String cipherText = "";
        for (int ii = 0; ii < message.length(); ii++) {
            int charPosition = ALPHA.indexOf(message.charAt(ii));
            int keyVal = (shiftKey + charPosition) % 26;
            char replaceVal = ALPHA.charAt(keyVal);
            cipherText += replaceVal;
        }
        return cipherText;
    }

    @Override
    public String decrypt() {
        message = message.toLowerCase();
        String decryptedMessage = "";
        for (int ii = 0; ii < message.length(); ii++) {
            int charPosition = ALPHA.indexOf(message.charAt(ii));
            int keyVal = (charPosition - shiftKey) % 26;
            if (keyVal < 0) {
                keyVal = ALPHA.length() + keyVal;
            }
            char replaceVal = ALPHA.charAt(keyVal);
            decryptedMessage += replaceVal;
        }
        return decryptedMessage;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setShiftKey(int shiftKey) {
        this.shiftKey = shiftKey;
    }
}
