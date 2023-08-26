package Listeci;

import javax.swing.*;   

public class Listeci {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LinkedListSwingApp().setVisible(true);
            }
        });
    }
}