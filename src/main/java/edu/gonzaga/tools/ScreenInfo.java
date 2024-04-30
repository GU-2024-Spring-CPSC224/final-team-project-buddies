package edu.gonzaga.tools;

import java.awt.*;

public class ScreenInfo 
{
    private static Dimension screenSize;

    public static Dimension getScreenSize()
    {
        if (screenSize==null)
        {
            screenSize=java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        }
        return screenSize;
    }
}