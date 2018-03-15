package com.grafika;

import java.awt.*;
import java.awt.event.*;
import java.awt.Point;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Container;
import java.util.ArrayList;

public class Rysowanie extends Canvas
{
    private CheckboxGroup cbg = new CheckboxGroup();
    private Panel panel = new Panel(new GridLayout(8,1));
    private MyCanvas canvas = new MyCanvas();

    private ArrayList<Kreska> kreski = new ArrayList<>();

    private int canvas_width = 800, canvas_height = 600;

    private Point start = new Point();
    private Point end = new Point();
    private Color color;
    private boolean drawing = false;

    private Rysowanie()
    {
        init();
    }

    class MyCanvas extends Canvas
    {
        private MyCanvas()
        {
            setBackground (Color.WHITE);
            setSize(canvas_width, canvas_height);
        }
        @Override
        public void paint(Graphics g)
        {
            if(drawing)
            {
                g.setColor(Color.LIGHT_GRAY);
                g.drawLine((int)start.getX(), (int)start.getY(), (int)end.getX(), (int)end.getY());
            }

            for(Kreska k : kreski)
            {
                g.setColor(k.kolor);
                g.drawLine((int)k.poczatek.getX(), (int)k.poczatek.getY(), (int)k.koniec.getX(), (int)k.koniec.getY());
            }
        }
    }


    private void init()
    {
        Frame main_frame = new Frame("Rysowanie");
        main_frame.setSize(canvas_width, canvas_height);
        main_frame.setResizable(false);

        main_frame.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent windowEvent)
            {
                System.exit(0);
            }
        });

        MouseMotionListener MouseMotionList = new MouseMotionAdapter()
        {
            @Override
            public void mouseDragged(MouseEvent e)
            {
                end = e.getPoint();
                canvas.repaint();
            }
        };

        MouseListener MouseList = new MouseAdapter()
        {
            @Override
            public void mousePressed(MouseEvent e)
            {
                start = e.getPoint();
                drawing = true;
            }

            @Override
            public void mouseReleased(MouseEvent e)
            {
                drawing = false;
                end = e.getPoint();

                if(end.getX() < canvas_width - 80 && end.getX() > 0 && end.getY() < canvas_height - 30 && end.getY() > 0)
                {
                    Checkbox kolor = cbg.getSelectedCheckbox();

                    if(kolor.getLabel().equals("Red"))
                        color = Color.RED;
                    if(kolor.getLabel().equals("Green"))
                        color = Color.GREEN;
                    if(kolor.getLabel().equals("Blue"))
                        color = Color.BLUE;
                    if(kolor.getLabel().equals("Gray"))
                        color = Color.GRAY;
                    if(kolor.getLabel().equals("Magenta"))
                        color = Color.MAGENTA;
                    if(kolor.getLabel().equals("Orange"))
                        color = Color.ORANGE;
                    if(kolor.getLabel().equals("Cyan"))
                        color = Color.CYAN;
                    if(kolor.getLabel().equals("Yellow"))
                        color = Color.YELLOW;

                    kreski.add(new Kreska(start, end, color));

                    canvas.repaint();
                }
                canvas.repaint();
            }
        };

        KeyAdapter KeyList = new KeyAdapter()
        {
            @Override
            public void keyPressed(KeyEvent e)
            {
                switch(e.getKeyCode())
                {
                    case KeyEvent.VK_BACK_SPACE:
                        kreski.clear();
                        break;
                    case KeyEvent.VK_F:
                        if(kreski.size() > 0)
                            kreski.remove(0);
                        break;
                    case KeyEvent.VK_L:
                        if(kreski.size() > 0)
                            kreski.remove(kreski.size() - 1);
                        break;
                    case KeyEvent.VK_B:
                        if(kreski.size() > 0)
                            kreski.remove(kreski.size() - 1);
                        break;
                }
                canvas.repaint();
            }
        };


        Graphics graphics = canvas.getGraphics();

        canvas.addKeyListener(KeyList);
        canvas.addMouseListener(MouseList);
        canvas.addMouseMotionListener(MouseMotionList);

        Checkbox red = new Checkbox("Red", cbg, true);
        Checkbox green = new Checkbox("Green", cbg, false);
        Checkbox blue = new Checkbox("Blue", cbg, false);
        Checkbox gray = new Checkbox("Gray", cbg, false);
        Checkbox magenta = new Checkbox("Magenta", cbg, false);
        Checkbox orange = new Checkbox("Orange", cbg, false);
        Checkbox cyan = new Checkbox("Cyan", cbg, false);
        Checkbox yellow = new Checkbox("Yellow", cbg, false);

        panel.add(red);
        panel.add(green);
        panel.add(blue);
        panel.add(gray);
        panel.add(magenta);
        panel.add(orange);
        panel.add(cyan);
        panel.add(yellow);

        main_frame.add(panel, BorderLayout.WEST);
        main_frame.add(canvas, BorderLayout.CENTER);
        main_frame.setVisible(true);
    }

    public static void main(String[] args)
    {
        Rysowanie rysunek = new Rysowanie();
    }

}
