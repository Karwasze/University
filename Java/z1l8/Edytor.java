package com.grafika;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Edytor extends JFrame{
    BufferedImage image;
    JPanel panel = new JPanel();
    JToolBar toolbar = new JToolBar();
    String[] colors = {"Red", "Green", "Blue", "Choose Color", "Reset"};

    JList list = new JList(colors);
    JLabel label = new JLabel("Coords: ");

    JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, list, panel);
    JScrollPane scrollPane = new JScrollPane(splitPane);

    JButton open = new JButton("Open");
    JButton zoomIn = new JButton("+");
    JButton zoomOut = new JButton("-");
    JButton moveLeft = new JButton("<-");
    JButton moveRight = new JButton("->");
    JButton moveUp = new JButton("^");
    JButton moveDown = new JButton("v");

    JColorChooser colorChooser = new JColorChooser();

    Color color = new Color(0,0,0);
    boolean pick = false;

    public Edytor()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(640, 480);
        panel.setPreferredSize(new Dimension(panel.getWidth(), panel.getHeight()));
        setLayout(new BorderLayout());
        panel.addMouseListener(mouseList);
        //scrollPane.setPreferredSize(new Dimension(panel.getWidth(), panel.getHeight()));

        open.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                JFileChooser fc = new JFileChooser();
                int result = fc.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION)
                {
                    File file = fc.getSelectedFile();
                    try
                    {
                        image = ImageIO.read(file);
                        JLabel picLabel = new JLabel(new ImageIcon(image));
                        panel.add(picLabel);
                        panel.updateUI();
                    } catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        });
        toolbar.add(open);
        toolbar.add(zoomIn);
        toolbar.add(zoomOut);
        toolbar.add(moveLeft);
        toolbar.add(moveRight);
        toolbar.add(moveUp);
        toolbar.add(moveDown);
        add(toolbar, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(label, BorderLayout.SOUTH);

        setVisible(true);
    }

    private MouseListener mouseList = new MouseAdapter()
    {
        @Override
        public void mouseClicked(MouseEvent ev)
        {
            Graphics gr = panel.getGraphics();
            int colorindex = list.getSelectedIndex();
            if (colorindex == 0)
            {
                gr.setColor(Color.RED);
                pick = false;
            }
            if (colorindex == 1)
            {
                gr.setColor(Color.GREEN);
                pick = false;
            }
            if (colorindex == 2)
            {
                gr.setColor(Color.BLUE);
                pick = false;
            }
            if (colorindex == 3)
            {
                if(!pick)
                {
                    pick = true;
                    color = colorChooser.showDialog(null, "Pick a color", null);
                    gr.setColor(color);
                }
                gr.setColor(color);
            }
            if (colorindex == 4)
            {
                pick = false;
                return;
            }
            gr.fillRect(ev.getX(), ev.getY(),1, 1);
        }
    };


    public static void main(String[] args)
    {
        new Edytor();
    }
}