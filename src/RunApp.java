import model.AtbashCipher;
import model.CaesarCipher;
import model.VigenereCipher;
import view.MainFrame;

import javax.swing.*;

public class RunApp {
    public static void main(String[] args) {
//        System.out.println("========== Caesar ==========");
//        CaesarCipher cc = new CaesarCipher("neki tekst s razmakom od pet koraka", 5);
//        String encryptedMessage = cc.encrypt();
//        System.out.println(encryptedMessage);
//        cc.setMessage(encryptedMessage);
//        String decryptedMessage = cc.decrypt();
//        System.out.println(decryptedMessage);
//        System.out.println();
//
//        System.out.println("========== Vigenere ==========");
//        VigenereCipher vc = new VigenereCipher();
//        vc.setMessage("test za vignere cipher");
//        vc.setKeyWord("KRIPTOgrafija232132");
//        encryptedMessage = vc.encrypt();
//        System.out.println(encryptedMessage);
//        vc.setMessage(encryptedMessage);
//        decryptedMessage = vc.decrypt();
//        System.out.println(decryptedMessage);
//        System.out.println();
//
//        System.out.println("========== Atbash ==========");
//        AtbashCipher ac = new AtbashCipher();
//        ac.setMessage("atbash test je u tijeku");
//        encryptedMessage = ac.encrypt();
//        System.out.println(encryptedMessage);
//        ac.setMessage(encryptedMessage);
//        decryptedMessage = ac.decrypt();
//        System.out.println(decryptedMessage);
//        System.out.println();


        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MainFrame();
                } catch (UnsupportedLookAndFeelException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (InstantiationException e) {
                    throw new RuntimeException(e);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}
