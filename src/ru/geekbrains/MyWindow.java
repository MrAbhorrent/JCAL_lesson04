package ru.geekbrains;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyWindow extends JFrame {

    public static final String myWindowTitle= "Тестовое окно";
    private int myWindowWidth = 800;
    private int myWindowHeight = 450;
    private int gridRows = 2;
    Color[] defaultColor = { Color.LIGHT_GRAY, Color.CYAN, Color.DARK_GRAY, Color.WHITE};
    //JButton[] jButtons;


    // Создаем окно
    public MyWindow() {
        setTitle(myWindowTitle);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, this.myWindowWidth, this.myWindowHeight);
        setVisible(true);
        setLayout(new GridLayout(gridRows, 1));
        JPanel[] jPanels = new JPanel[gridRows];
        for (int i = 0; i < gridRows; i++) {
            jPanels[i] = new JPanel();
            jPanels[i].setBackground(defaultColor[i]);
            add(jPanels[i]);
        }
        // Настраиваем содержимое панелей
        // Панель чата
        jPanels[0].setLayout(new BorderLayout());
        JTextArea jTextArea = new JTextArea();
        JScrollPane jScrollPane = new JScrollPane(jTextArea);
        jPanels[0].add(jScrollPane);

        // Панель сообщения
        jPanels[1].setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.8f;

        JTextField jTextField = new JTextField();
        jPanels[1].add(jTextField, c);

        JButton jButton = new JButton("Отправить");
        jButton.addActionListener(e -> {
            System.out.println(jTextField.getText());
            jTextArea.setText(jTextArea.getText() + jTextField.getText() + "\n");
            jTextField.setText("");
        });
        jPanels[1].add(jButton, c);

        /*for (JPanel panel : jPanels){
            setContentPane(panel);
        }*/

    }

    public int getMyWindowWidth() {
        return myWindowWidth;
    }

    public void setMyWindowWidth(int myWindowWidth) {
        this.myWindowWidth = myWindowWidth;
    }

    public int getMyWindowHeight() {
        return myWindowHeight;
    }

    public void setMyWindowHeight(int myWindowHeight) {
        this.myWindowHeight = myWindowHeight;
    }
}

