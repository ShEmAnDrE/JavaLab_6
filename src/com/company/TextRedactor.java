package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class TextRedactor extends JFrame {
    private JPanel panel = new JPanel();
    private JTextArea textArea;
    private JMenuBar menuBar = new JMenuBar();

    public JMenu createColorMenu() {
        JMenu menu = new JMenu("Цвет");
        JMenuItem itemBlue = new JMenuItem("Синий");
        JMenuItem itemRed = new JMenuItem("Красный");
        JMenuItem itemBlack = new JMenuItem("Черный");

        itemBlue.setForeground(Color.BLUE);
        itemRed.setForeground(Color.RED);
        itemBlack.setForeground(Color.BLACK);

        itemBlue.addActionListener(e -> {
            textArea.setForeground(Color.BLUE);
        });
        itemRed.addActionListener(e -> {
            textArea.setForeground(Color.RED);
        });
        itemBlack.addActionListener(e -> {
            textArea.setForeground(Color.BLACK);
        });

        menu.add(itemBlue);
        menu.add(itemRed);
        menu.add(itemBlack);
        return menu;
    }

    public JMenu createFontMenu() {
        JMenu menu = new JMenu("Шрифт");
        JMenuItem itemTimesNewRoman = new JMenuItem("Times New Roman");
        JMenuItem itemMSSansSerif = new JMenuItem("MS Sans Serif");
        JMenuItem itemCourierNew = new JMenuItem("Courier New");

        itemTimesNewRoman.setFont(new Font("Times New Roman", Font.PLAIN,14));
        itemMSSansSerif.setFont(new Font("MS Sans Serif", Font.PLAIN,14));
        itemCourierNew.setFont(new Font("Courier New", Font.PLAIN,14));

        itemTimesNewRoman.addActionListener(e -> {
            textArea.setFont(new Font("Times New Roman", textArea.getFont().getStyle(), textArea.getFont().getSize()));
        });
        itemMSSansSerif.addActionListener(e -> {
            textArea.setFont(new Font("MS Sans Serif", textArea.getFont().getStyle(), textArea.getFont().getSize()));
        });
        itemCourierNew.addActionListener(e -> {
            textArea.setFont(new Font("Courier New", textArea.getFont().getStyle(), textArea.getFont().getSize()));
        });

        menu.add(itemTimesNewRoman);
        menu.add(itemMSSansSerif);
        menu.add(itemCourierNew);
        return menu;
    }
    
    public JMenu createStyleMenu() {
        JMenu menu = new JMenu("Стиль");
        JMenuItem itemItalic = new JMenuItem("Курсив");
        JMenuItem itemPlain = new JMenuItem("Обычный");
        JMenuItem itemBold = new JMenuItem("Жирный");

        itemItalic.setFont(new Font(itemItalic.getFont().getFontName(), Font.ITALIC, 14));
        itemPlain.setFont(new Font(itemItalic.getFont().getFontName(), Font.PLAIN,14));
        itemBold.setFont(new Font(itemItalic.getFont().getFontName(), Font.BOLD,14));

        itemItalic.addActionListener(e -> {
            textArea.setFont(new Font(textArea.getFont().getFontName(), Font.ITALIC, textArea.getFont().getSize()));
        });
        itemPlain.addActionListener(e -> {
            textArea.setFont(new Font(textArea.getFont().getFontName(), Font.PLAIN, textArea.getFont().getSize()));
        });
        itemBold.addActionListener(e -> {
            textArea.setFont(new Font(textArea.getFont().getFontName(), Font.BOLD, textArea.getFont().getSize()));
        });

        menu.add(itemItalic);
        menu.add(itemPlain);
        menu.add(itemBold);
        return menu;
    }

    public JMenu createSizeMenu() {
        JMenu menu = new JMenu("Размер шрифта");

        JSlider jSlider = new JSlider(JSlider.VERTICAL,0,100,25);
        jSlider.setMajorTickSpacing(10);
        jSlider.setMinorTickSpacing(2);
        jSlider.setPaintTicks(true);
        jSlider.setPaintLabels(true);

        jSlider.addChangeListener(e -> {
            textArea.setFont(new Font(textArea.getFont().getFontName(),textArea.getFont().getStyle(),jSlider.getValue()));
        });

        menu.add(jSlider);
        return menu;
    }

    public TextRedactor() {
        super ("Text Redactor");
        setSize(650, 500);
        setContentPane(panel);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel.setLayout(new GridLayout());

        menuBar.add(createColorMenu());
        menuBar.add(createFontMenu());
        menuBar.add(createStyleMenu());
        menuBar.add(createSizeMenu());
        menuBar.add(Box.createHorizontalGlue());
        setJMenuBar(menuBar);

        textArea = new JTextArea();
        textArea.setFont(new Font("Serif",Font.PLAIN,25));
        add(textArea);

        JScrollPane jScrollPane = new JScrollPane(textArea);
        add(jScrollPane);
    }
}
