import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

public class Vigenere extends JFrame {

    private JTextField plainField;
    private JTextField keyField;
    private JTextField EncryptedText;
    private JTextField DecryptedText;
    private JButton encryptButton;
    private JButton decryptButton;
    private JPanel Panel1;
    static int plainIndex,keyIndex,val,i,k,j;
    static String encVal="", decVal="",holder="";
    static char [] alphabet = {'A','B','C', 'Ç','D','E','F','G','Ğ','H','I','İ','J','K','L','M','N','O','Ö','P','R','S','Ş','T','U','Ü','V','Y','Z'};
    static String key, plainText;

    public Vigenere(){
        add(Panel1);
        setSize(880,400);
        setTitle("Vigenere AutoKey System - Turkish");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //when clicked on close, deletes the form from the RAM.
        encryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { //action listener.
                key = keyField.getText().toUpperCase();
                plainText = plainField.getText().toUpperCase();
                for(i = 0; i<plainText.length(); i++){
                    key+=plainText.charAt(i);
                }
                for (i = 0, k = 0; i < plainText.length() && k < key.length(); i++, k++) {
                    for (int j = 0; j < 29; j++) {
                        if (plainText.charAt(i) == alphabet[j]) {
                            plainIndex = j;
                        }
                        if (key.charAt(k) == alphabet[j]) {
                            keyIndex = j;
                        }
                    }
                    val = (plainIndex + keyIndex) % 29;
                    encVal += alphabet[val];


                }
              holder = encVal;
              EncryptedText.setText(encVal);
              encVal = ""; //cleared encVal to prevent encrypted value to concatenate when continuously clicking on encrypt button.

            }
        });
        decryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(i=0,k=0; i<holder.length()&&k<key.length(); i++,k++){
                    for(j=0; j<29; j++){
                        if(holder.charAt(i)==alphabet[j]){
                            plainIndex = j;
                        }
                        if(key.charAt(k)==alphabet[j]){
                            keyIndex = j;
                        }
                    }
                    val=(plainIndex-keyIndex+29)%29;
                    decVal+=alphabet[val];

                }
                DecryptedText.setText(decVal);

                decVal=""; //cleared var decVal to prevent encrypted value to concatenate when continuously clicking on encrypt button.
            }
        });
    }
}
