package learn_java_swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by bruce.ge on 2016/12/11.
 */
public class SwingHighlightDemo {
    private JFrame mainFrame;

    private JLabel methodStartLable;

    private JLabel methodEndLable;

    private JLabel methodErrorPart;

    private JLabel errorMessageLable;

    private JButton okButton;

    private JPanel jPanel;

    public SwingHighlightDemo(String methodName, Integer start, Integer end, String errorText) {
        mainFrame = new JFrame("parse error");
        this.errorMessageLable = new JLabel(errorText);
        this.jPanel = new JPanel();
        if (start != null && end != null) {
            String methodStart = methodName.substring(0, start);
            String errorPart = methodName.substring(start, end);
            String methodEnd = methodName.substring(end);
            this.methodStartLable = new JLabel(methodStart);
            this.methodEndLable = new JLabel(methodEnd);
            this.methodErrorPart = new JLabel(errorPart);
            this.methodErrorPart.setOpaque(true);
            this.methodErrorPart.setForeground(Color.BLUE);
            this.jPanel.add(methodStartLable);
            this.jPanel.add(methodErrorPart);
            this.jPanel.add(methodEndLable);

        } else {
            this.methodStartLable = new JLabel(methodName);
            this.jPanel.add(methodStartLable);
        }
        this.jPanel.setSize(200,50);
        this.jPanel.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
        mainFrame.add(jPanel);
        okButton = new JButton("OK");
        mainFrame.add(errorMessageLable);
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.dispose();
            }
        });
        okButton.setSize(50, 50);
        mainFrame.add(okButton);
        mainFrame.setSize(400, 200);
        mainFrame.setLayout(new GridLayout(3, 1));
        mainFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingHighlightDemo findBy = new SwingHighlightDemo("findBy", 1, 3, "shall add property of bean after by");
    }
}
