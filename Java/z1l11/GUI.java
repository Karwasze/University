package com.strumienie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;

public class GUI {
    private JFrame mainFrame;
    private JEditorPane editorPane;
    private Container topContainer;
    private Container bottomContainer;

    private JLabel location;
    private JLabel name;
    private JLabel readable;
    private JLabel writable;

    private JFileChooser jFileChooser;
    private JButton saveButton;
    private JButton clearButton;
    private JButton chooseButton;
    public File file;
    public File edited;
    public File buffer;
    FileWriter writer;
    FileWriter clearwriter;
    FileReader reader;

    GUI()
    {
        mainFrame = new JFrame("Edytor tekstu");
        mainFrame.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent windowEvent)
            {
                System.exit(0);
            }
        });
        editorPane = new JEditorPane();
        topContainer = new Container();
        bottomContainer = new Container();
        location = new JLabel();
        name = new JLabel();
        readable = new JLabel();
        writable = new JLabel();
        jFileChooser = new JFileChooser();
        saveButton = new JButton("SAVE");
        clearButton = new JButton("CLEAR");
        chooseButton = new JButton("CHOOSE FILE");

        chooseButton.addActionListener(new ChooseFileButtonListener());
        clearButton.addActionListener(new ClearButtonListener());
        saveButton.addActionListener(new SaveButtonListener());
        bottomContainer.setLayout(new FlowLayout());
        bottomContainer.add(chooseButton);
        bottomContainer.add(clearButton);
        bottomContainer.add(saveButton);

        topContainer.setLayout(new BoxLayout(topContainer, 1));
        topContainer.add(name);
        topContainer.add(location);
        topContainer.add(readable);
        topContainer.add(writable);

        mainFrame.setSize(640, 480);
        mainFrame.setLayout(new BorderLayout());
        mainFrame.add(editorPane, BorderLayout.CENTER);
        mainFrame.add(topContainer, BorderLayout.NORTH);
        mainFrame.add(bottomContainer, BorderLayout.SOUTH);
        mainFrame.setVisible(true);

    }

    class ChooseFileButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e)
        {
            int returnVal = jFileChooser.showOpenDialog(mainFrame);
            if (returnVal == JFileChooser.APPROVE_OPTION)
            {
                file = jFileChooser.getSelectedFile();
                name.setText("File name: " + file.getName());
                location.setText("File path: " + file.getAbsolutePath());
                if(file.canRead())
                {
                    readable.setText("File readable");
                }
                else readable.setText("File not readable");

                if(file.canWrite())
                {
                    writable.setText("File writeable");
                }
                else writable.setText("File not writeable");

                try
                {
                    editorPane.setPage(file.toURI().toURL());
                }
                catch (Exception ex)
                {
                    ex.printStackTrace();
                }
            }
        }
    }

    class ClearButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e)
        {
            try
            {
                buffer = new File("buffer");
                edited = new File("textedit");
                clearwriter = new FileWriter(buffer);
                clearwriter.flush();
                clearwriter.write(editorPane.getText());
                clearwriter.close();
                Clearer clearer = new Clearer(4, buffer);
                editorPane.setPage(edited.toURI().toURL());
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }
    }

    class SaveButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e)
        {
            try {
                reader = new FileReader(edited);
                writer = new FileWriter(file);
                writer.flush();
                BufferedReader bufferedReader = new BufferedReader(reader);
                String line;

                while ((line = bufferedReader.readLine()) != null) {
                    writer.write(line);
                    writer.write('\n');
                }
                reader.close();
                writer.close();

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
