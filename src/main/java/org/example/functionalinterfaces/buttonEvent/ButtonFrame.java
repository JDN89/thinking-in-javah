package org.example.functionalinterfaces.buttonEvent;

import javax.swing.*;
import java.awt.event.*;

public class ButtonFrame extends JFrame {

    private ButtonClickListener listener;

    public ButtonFrame() {
        JButton button = new JButton("Click me");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (listener != null) {
                    listener.onButtonClick();
                }
            }
        });
        add(button);
        setSize(200, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void setButtonClickListener(ButtonClickListener listener) {
        this.listener = listener;
    }
}