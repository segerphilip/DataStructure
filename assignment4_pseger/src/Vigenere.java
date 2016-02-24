import oracle.jvm.hotspot.jfr.JFROptions;

import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 * Created by philip on 2/17/16.
 * This actually still works even if ints are used as password or message
 * because it would just shift back because values of ints in ascii are
 * less than characters. This was a purposeful inclusion.
 *
 * Errors: Currently, sometimes the decrypt returns a result with some strange characters:
 * input: ATTACKATDAWN
 * decrypted: AT:AC1ATDAW4
 * I can not fully pin down why.
 */
public class Vigenere implements Encryptable {
    private String message;
    private int[] shift;
    private boolean encrypted;

    /**
     * Constructor that checks for a password, transposes the password into a shift[],
     * creates message as an uppercase String without spaces, and sets encrypted to false.
     * @param message   String to be encrypted
     * @param password  String to be used as encryption shift
     */
    public Vigenere(String message, String password) {
        if (password.length() == 0) {
            throw new IllegalArgumentException("You need a password");
        }
        this.shift = new int[password.length()];

        for (int i = 0; i < password.length(); i++) {
            int index = (int)(password.toUpperCase().charAt(i) - 'A');
            this.shift[i] = index;
        }
        this.message = message.toUpperCase().replaceAll("\\s+","");
        this.encrypted = false;
    }

    /**
     * Getters and setters as follows
     */
    public String getMessage() {
        return message;
    }

    public void setMessage(String newMessage) {
        message = newMessage;
    }

    public int[] getShift() {
        return shift;
    }

    public void setShift(String newShift) {
        this.shift = new int[newShift.length()];

        for (int i = 0; i < newShift.length(); i++) {
            int index = (int)(newShift.charAt(i) - 'A');
            this.shift[i] = index;
        }
    }

    public boolean getEncrypted() {
        return encrypted;
    }

//    private because this should not be able to be spoofed by other classes
    private void setEncrypted(boolean isEncrypted) {
        encrypted = isEncrypted;
    }

    /**
     * encrypts the original message to newMessage
     *  uses a counter to loop over the password for the full message
     *  uses a check to loop through the alphabet if the character + password is larger
     *  sets the newMessage to original message, then shows as encrypted
     */
    public void encrypt() {
        int counter = 0;
        String encryptMessage = "";
        for (int i = 0; i < message.length(); i++) {
            if (counter == shift.length) {
                counter = 0;
            }
            int newChar = shift[counter] + (int)(message.charAt(i) - 'A');
            if (newChar / 26 >= 1) {
                newChar = newChar % 26;
            }
            encryptMessage += (char)(newChar + 'A');
            counter++;
        }
        message = encryptMessage;
        encrypted = true;
    }

    /**
     * Takes the encrypted message and decrypts it, opposite of encrypt()
     * @return  decrypted message
     */
//          NOT CURRENTLY WORKING PROPERLY
    public String decrypt() {
        int counter = 0;
        String decryptMessage = "";
        for (int i = 0; i < message.length(); i++) {
            if (counter == shift.length) {
                counter = 0;
            }
            int newChar = (int)(message.charAt(i) - 'A') - shift[counter];
            if (newChar / 26 >= 1) {
                newChar = newChar % 26;
            }
            decryptMessage += (char)(newChar + 'A');
            counter++;
        }
        message = decryptMessage;
        encrypted = false;
        return "THIS";
    }

    public String toString() {
        String shift_print = Arrays.toString(shift);
        if (encrypted == true) {
            return "encrypted message: " + message + "\tpassword shift: " + shift_print;
        }
        return "original message: " + message + "\tpassword shift: " + shift_print;
    }

    public static void main(String[] args) {
// Original testing
//        Vigenere vn1 = new Vigenere("Attack at Dawn", "CAT");
//        System.out.println(vn1);
//        vn1.encrypt();
//        System.out.println(vn1);
//        vn1.decrypt();
//        System.out.println(vn1);

// Gui testing
        String initial_message, initial_password, result;

        int num, again;
        do
        {
            initial_message = JOptionPane.showInputDialog ("What is the message?");
            initial_password = JOptionPane.showInputDialog ("What is the password?");
            Vigenere vn1 = new Vigenere(initial_message, initial_password);
            vn1.encrypt();
            JOptionPane.showMessageDialog (null, vn1.getMessage());
            again = JOptionPane.showConfirmDialog (null, "Do you want it decrypted?");
            JOptionPane.showMessageDialog (null, vn1.decrypt());
        }
        while (again == JOptionPane.YES_OPTION);
    }
}
