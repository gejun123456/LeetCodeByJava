package learn_java_swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.concurrent.CountDownLatch;

/**
 * Created by bruce.ge on 2016/12/11.
 */
public class SwingControlDemo {
    private JFrame mainFrame;

    private JLabel headerLabel;

    private JLabel statusLabel;

    private JPanel controlPanel;

    private JTextField jTextField;

    private String exitText = "normalExit";

    private static CountDownLatch latch = new CountDownLatch(1);

    public SwingControlDemo() {
        prepareGUI();
    }

    public static void main(String[] args) throws InterruptedException {
        SwingControlDemo swingControlDemo = new SwingControlDemo();
        swingControlDemo.showEventDemo();
        latch.await();
        while (true) {
            Thread.sleep(1000);
            System.out.println(swingControlDemo.getExitText());
        }
    }


    public String getExitText() {
        return exitText;
    }

    private void prepareGUI() {
        mainFrame = new JFrame("parse method");
        mainFrame.setSize(400, 400);
        mainFrame.setLayout(new GridLayout(3, 1));
        headerLabel = new JLabel("", JLabel.CENTER);
        statusLabel = new JLabel("", JLabel.CENTER);
        jTextField = new JTextField("helloman");
        jTextField.setSize(100, 20);

        statusLabel.setSize(350, 100);

        mainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());
        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.add(statusLabel);
        mainFrame.add(jTextField);
        mainFrame.setVisible(true);
    }

    private void showEventDemo() throws InterruptedException {
        headerLabel.setText("Control in action: Button");
        JButton okButton = new JButton("Ok");
        JButton submitButton = new JButton("Submit");
        JButton cancelButton = new JButton("Cancel");
        JButton exitButton = new JButton("exit");

        okButton.setActionCommand("OK");
        submitButton.setActionCommand("Submit");
        cancelButton.setActionCommand("Cancel");
        exitButton.setActionCommand("exit");
        ButtonClickListener listener = new ButtonClickListener();
        okButton.addActionListener(listener);
        submitButton.addActionListener(listener);
        cancelButton.addActionListener(listener);
        exitButton.addActionListener(listener);

        controlPanel.add(okButton);
        controlPanel.add(submitButton);
        controlPanel.add(cancelButton);
        controlPanel.add(exitButton);
        mainFrame.setVisible(true);
    }


    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if (command.equals("OK")) {
                statusLabel.setText("Ok Button clicked.");
            } else if (command.equals("Submit")) {
                statusLabel.setText("Submit Button clicked.");
            } else if (command.equals("Cancel")) {
                statusLabel.setText("Cancel Button clicked.");
            } else {
                exitText = jTextField.getText();
                mainFrame.dispose();
                latch.countDown();
            }
        }
    }
}
