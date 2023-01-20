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
        char[] msg = message.toCharArray();
        int msgLen = msg.length;
        char[] key = keyWord.toCharArray();
        char encryptedMsg[] = new char[msgLen];
        for(int i = 0; i < msgLen; ++i)
            encryptedMsg[i] = (char) (((msg[i] + key[i]) % 26) + 'A');
        return encryptedMsg.toString();
    }

    @Override
    public String decrypt() {
        char[] msg = message.toCharArray();
        int msgLen = msg.length;
        char[] key = keyWord.toCharArray();
        char decryptedMsg[] = new char[msgLen];
        for(int i = 0; i < msgLen; ++i)
            decryptedMsg[i] = (char)((((decryptedMsg[i] - key[i]) + 26) % 26) + 'A');
        return decryptedMsg.toString();
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }
}
