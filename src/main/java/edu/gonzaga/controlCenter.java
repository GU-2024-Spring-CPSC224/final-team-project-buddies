package edu.gonzaga;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.*;

public class controlCenter implements ActionListener, MouseListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton button = (JButton) e.getSource();
            if ("Start Race".equals(button.getText())) {
                // 在这里添加开始游戏的代码
            } else if ("Reset Race".equals(button.getText())) {
                // 在这里添加重置游戏的代码
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // 在这里添加你的代码
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // 在这里添加你的代码
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // 在这里添加你的代码
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // 在这里添加你的代码
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // 在这里添加你的代码
    }
}
