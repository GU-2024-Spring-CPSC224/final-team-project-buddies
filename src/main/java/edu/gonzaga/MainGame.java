package edu.gonzaga;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGame {
    private JFrame frame;
    private JPanel panel;
    private JButton startButton;
    private JButton resetButton;
    private JLabel[] horses;
    
    JTextField playerNames = new JTextField();

    public MainGame() {
        frame = new JFrame("Horse Racing Game");
        panel = new JPanel();
        startButton = new JButton("Start Race");
        resetButton = new JButton("Reset Race");
        horses = new JLabel[5];

        for (int i = 0; i < horses.length; i++) {
            horses[i] = new JLabel("Horse " + (i + 1));
            horses[i].setBounds(10, (i * 50) + 30, 80, 30);
            panel.add(horses[i]);
        }

        startButton.setBounds(100, 300, 100, 30);
        resetButton.setBounds(210, 300, 100, 30);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: Implement race start logic
            }
        });

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: Implement race reset logic
            }
        });

        panel.setLayout(null);
        panel.add(startButton);
        panel.add(resetButton);

        frame.add(panel);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new MainGame();
    }
}