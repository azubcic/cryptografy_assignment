package view;

import model.AtbashCipher;
import model.CaesarCipher;
import model.CipherInterface;
import model.VigenereCipher;

import javax.crypto.Cipher;
import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class MainFrame extends JFrame {

    private JTextArea inputArea, resultArea;
    private JLabel messageLabel, keyLabel, cipherLabel, resultLabel;
    private JScrollPane spInput, spResult;
    private JTextField keyField;
    private JComboBox<CipherInterface> cipherComboBox;
    private ButtonGroup cipherGroup;
    private JRadioButton encryptRadioButton, decryptRadioButton;
    private JButton executeButton, copyButton;

    public MainFrame() throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        super("Cipher App");
        setVisible(true);
        setLocationRelativeTo(null);
        setSize(270, 570);
        setResizable(false);
        setLayout(new GridBagLayout());


        UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        SwingUtilities.updateComponentTreeUI(this);

        initComps();
        layoutComps();
        activateButton();
    }

    private void activateButton() {
        executeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CipherInterface cipher = (CipherInterface) cipherComboBox.getSelectedItem();
                if (!inputArea.getText().isEmpty() && !keyField.getText().isEmpty()) {
                    String message = inputArea.getText();
                    String key = keyField.getText();
                    cipher.setMessage(message);
                    cipher.setKey(key);
                    if (cipherComboBox.getSelectedIndex() == 0) {
                        try {
                            Integer.parseInt(keyField.getText());
                        } catch (NumberFormatException nfe) {
                            JOptionPane.showMessageDialog(new JFrame(), "Key has to be an integer!",
                                    "ERROR: KEY", JOptionPane.ERROR_MESSAGE);
                        }
                        executeAction(cipher);
                    } else if (cipherComboBox.getSelectedIndex() == 1) {
                        if (onlyAlphabets(keyField.getText())) {
                            executeAction(cipher);
                        } else {
                            JOptionPane.showMessageDialog(new JFrame(), "Key has to be alphabetic!",
                                    "ERROR: KEY", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } else if (!inputArea.getText().isEmpty() && cipherComboBox.getSelectedIndex() == 2) {
                    String message = inputArea.getText();
                    cipher.setMessage(message);
                    executeAction(cipher);
                } else {
                    JOptionPane.showMessageDialog(new JFrame(), "Please fill in all boxes needed!",
                            "Fill in all boxes", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        copyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringSelection stringSelection = new StringSelection(resultArea.getText());
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(stringSelection, null);
            }
        });

        cipherComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                keyLabel.setVisible(true);
                keyField.setVisible(true);
                if (cipherComboBox.getSelectedIndex() == 0) {
                    resultArea.setText("");
                    keyField.setText("");
                    keyLabel.setText("Key (number):        ");
                } else if (cipherComboBox.getSelectedIndex() == 1) {
                    keyField.setText("");
                    resultArea.setText("");
                    keyLabel.setText("Key (only alphabet):");
                } else {
                    resultArea.setText("");
                    keyField.setText("");
                    keyLabel.setVisible(false);
                    keyField.setVisible(false);
                }
            }
        });
    }

    private void executeAction(CipherInterface cipher) {
        if (cipherGroup.getSelection() == encryptRadioButton.getModel()) {
            resultArea.setText(cipher.encrypt());
        } else {
            resultArea.setText(cipher.decrypt());
        }
    }

    public static boolean onlyAlphabets(
            String str) {

        // Return false if the string
        // has empty or null
        if (str == null || str == "") {
            return false;
        }

        // Traverse the string from
        // start to end
        for (int i = 0; i < str.length(); i++) {
            // Check if the specified
            // character is not a letter then
            // return false,
            // else return true
            if (!Character
                    .isLetter(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private void layoutComps() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;

        gbc.weightx = 0.1;
        gbc.weighty = 0.1;
        gbc.gridwidth = 2;

        gbc.insets = new Insets(10, 0, 0, 0);
        gbc.gridy++;
        add(cipherLabel, gbc);
        gbc.insets = new Insets(-35, 0, 0, 0);
        gbc.gridy++;
        add(cipherComboBox, gbc);


        gbc.insets = new Insets(50, 0, -5, 165);
        add(messageLabel, gbc);
        gbc.insets = new Insets(5, 0, 0, 0);

        gbc.gridy++;
        add(spInput, gbc);

        gbc.insets = new Insets(20, 0, -5, 115);
        gbc.gridy++;
        add(keyLabel, gbc);
        gbc.insets = new Insets(5, 0, 0, 0);

        gbc.gridy++;
        add(keyField, gbc);

        gbc.insets = new Insets(30, 0, -5, 0);
        gbc.gridwidth = 1;
        gbc.gridy++;
        add(encryptRadioButton, gbc);
        gbc.gridx++;
        add(decryptRadioButton, gbc);
        gbc.insets = new Insets(5, 0, 0, 0);

        gbc.insets = new Insets(30, 0, -5, 175);
        gbc.gridwidth = 2;
        gbc.gridy++;
        gbc.gridx--;
        add(resultLabel, gbc);
        gbc.insets = new Insets(5, 0, 0, 0);

        gbc.gridy++;
        add(spResult, gbc);
        gbc.gridy++;

        gbc.insets = new Insets(-20, 0, -20, 0);
        gbc.gridwidth = 1;
        gbc.weighty++;
        add(executeButton, gbc);
        gbc.gridx++;
        add(copyButton, gbc);
        gbc.insets = new Insets(5, 0, 0, 0);
    }

    private void initComps() {
        inputArea = new JTextArea(5, 20);
        resultArea = new JTextArea(5, 20);

        messageLabel = new JLabel("Message:");
        keyLabel = new JLabel("Key (number):        ");
        cipherLabel = new JLabel("Choose algorithm:");
        resultLabel = new JLabel("Result:");

        spResult = new JScrollPane(resultArea);
        spInput = new JScrollPane(inputArea);

        keyField = new JTextField(20);

        DefaultComboBoxModel<CipherInterface> model = new DefaultComboBoxModel<>();
        model.addElement(new CaesarCipher());
        model.addElement(new VigenereCipher());
        model.addElement(new AtbashCipher());
        cipherComboBox = new JComboBox<>(model);

        cipherGroup = new ButtonGroup();
        encryptRadioButton = new JRadioButton("Encrypt");
        decryptRadioButton = new JRadioButton("Decrypt");
        encryptRadioButton.setSelected(true);
        cipherGroup.add(encryptRadioButton);
        cipherGroup.add(decryptRadioButton);
        executeButton = new JButton("Execute");
        copyButton = new JButton("Copy Result");
        resultArea.setEditable(false);
    }
}
