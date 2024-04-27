package edu.gonzaga;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.Color;
import java.awt.Dialog.ModalityType;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class controlUihelper extends JFrame {

	private static final long serialVersionUID = 1L;
	private horse[] horses = new horse[7];

    // operation buttons
	private JButton buy = new JButton("buy");
	private JButton pass = new JButton("pass");
	private controlCenter controller;

	private ArrayList<JLabel> player1ScoreLabels = new ArrayList<JLabel>();
	private ArrayList<JLabel> player1Scores = new ArrayList<JLabel>();

    private ArrayList<JLabel> player2ScoreLabels = new ArrayList<JLabel>();
	private ArrayList<JLabel> player2Scores = new ArrayList<JLabel>();
    
    private ArrayList<JLabel> player3ScoreLabels = new ArrayList<JLabel>();
	private ArrayList<JLabel> player3Scores = new ArrayList<JLabel>();

	private JLabel winnerTitle = new JLabel("Winner: ");

    
}
