import model.CaesarCipher;
import model.VigenereCipher;

public class RunApp {
    public static void main(String[] args) {
        System.out.println("========== Caesar ==========");
        CaesarCipher cc = new CaesarCipher("matejjeglup", 5);
        String encryptedMessage = cc.encrypt();
        System.out.println(encryptedMessage);
        cc.setMessage(encryptedMessage);
        String decryptedMessage = cc.decrypt();
        System.out.println(decryptedMessage);

        System.out.println("========== Vigenere ==========");
        VigenereCipher vc = new VigenereCipher("matejjejosGluplji", "kriptografija2022");
        encryptedMessage = vc.encrypt();
        System.out.println(encryptedMessage);
        vc.setMessage(encryptedMessage);
        decryptedMessage = vc.decrypt();
        System.out.println(decryptedMessage);
    }
}
