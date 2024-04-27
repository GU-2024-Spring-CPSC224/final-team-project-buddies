package edu.gonzaga;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class horse extends JLabel {

    private static final long serialVersionUID = 1L;
	private static final int BORDER_GAP = 3;
	private static final Border UNHELD_BORDER = BorderFactory
			.createEmptyBorder(BORDER_GAP, BORDER_GAP, BORDER_GAP, BORDER_GAP);

	private static final Border HELD_BORDER = BorderFactory
			.createCompoundBorder(BorderFactory.createEmptyBorder(BORDER_GAP,
					12, BORDER_GAP, 12), BorderFactory.createLineBorder(
					Color.YELLOW, BORDER_GAP));

	private static final float STROKE_WIDTH = 3f;

	private static final int SML_GAP = 1;
				
	private static final int OVAL_RADIUS = 10;
	private static final int OUT_FRAME = 60;

	private static final int ARC = 9;


	private Random random = new Random();

	private Icon icon;

	private char value;

	private horseState state;

	private final char[] values = { '1', '2', '3', '4', '5', '6' };

	public horse(controlCenter controller) 
	{

		super();
		this.state = horseState.UNCHARGED;
		this.addMouseListener(controller);
	}

	public void roll() 
	{

		if (this.state == horseState.UNCHARGED) {

			value = (char) values[random.nextInt(6)];
			this.repaint();
		}
	}


	@Override
	public Icon getIcon() 
	{
		return icon;
	}
	@Override
	public void setIcon(Icon icon) 
	{
		this.icon = icon;
	}

	public void setValue(int value) 
	{
		this.value = (char) value;
		this.repaint();
	}

}
