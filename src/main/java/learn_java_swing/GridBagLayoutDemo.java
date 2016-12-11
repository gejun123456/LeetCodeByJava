package learn_java_swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by bruce.ge on 2016/12/11.
 */
public class GridBagLayoutDemo {
    private JFrame mainFrame;

    private JLabel headerLabel;

    private JLabel statusLabel;

    private JPanel controlPanel;

    private JLabel msglabel;

    public GridBagLayoutDemo() {
        prepareGUI();
    }

    private void prepareGUI() {
        mainFrame = new JFrame("Java SWING Examples");
        mainFrame.setSize(1000, 1000);
        mainFrame.setLayout(new GridLayout(3, 1));
        headerLabel = new JLabel("", JLabel.CENTER);
        statusLabel = new JLabel("", JLabel.CENTER);

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
        mainFrame.setVisible(true);
    }

    public static void main(String[] args) {
        GridBagLayoutDemo gridBagLayoutDemo = new GridBagLayoutDemo();
        gridBagLayoutDemo.showGridBagLayoutDemo();
    }


    private void showGridBagLayoutDemo() {
        headerLabel.setText("Layout in action: GridBagLayOut");

        JPanel panel = new JPanel();
        panel.setBackground(Color.DARK_GRAY);
        panel.setSize(300, 300);
        GridBagLayout layout = new GridBagLayout();

        panel.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.ipadx=40;
        gbc.insets =new Insets(0,0,0,3);
        panel.add(new JButton("Button 1"), gbc);
        gbc.gridx = 2;
        gbc.gridy = 0;
        panel.add(new JButton("Button 2"), gbc);

//        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.fill=GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JButton("Button 3"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(new JButton("Button 4"), gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 2;
        panel.add(new JButton("Button 5"), gbc);

        controlPanel.add(panel);
        mainFrame.setVisible(true);
    }


}
