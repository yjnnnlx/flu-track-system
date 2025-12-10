package com.zl;

import com.zl.frame.LoginFrame;

import javax.swing.*;


public class Index {
    public static void main(String[] args) {
        // Force OptionPane texts to English so dialogs show English title/buttons
        UIManager.put("OptionPane.okButtonText", "OK");
        UIManager.put("OptionPane.yesButtonText", "Yes");
        UIManager.put("OptionPane.noButtonText", "No");
        UIManager.put("OptionPane.cancelButtonText", "Cancel");
        UIManager.put("OptionPane.messageDialogTitle", "Message");
        UIManager.put("OptionPane.inputDialogTitle", "Input");
        UIManager.put("OptionPane.confirmDialogTitle", "Confirm");

        LoginFrame loginFrame = new LoginFrame();
        loginFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        loginFrame.setVisible(true);

    }
}
