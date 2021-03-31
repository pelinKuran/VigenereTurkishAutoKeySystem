import javax.swing.*;

public class open {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName()); //Gives the same component structure with the user's OS. Must work with try/catch.
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Vigenere obj = new Vigenere();
                obj.setVisible(true); //shows the form. Works in the thread.
            }
        });

    }
}
