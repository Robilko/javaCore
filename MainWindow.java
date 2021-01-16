package lesson7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {
    private static final int WIN_WIDTH = 500;
    private static final int WIN_HEIGHT = 555;
    private static final int WIN_POSX = 650;
    private static final int WIN_POSY = 250;

    private Settings settingsWindow;
    private GameMap gameMap;

    MainWindow() {
        setSize(WIN_WIDTH, WIN_HEIGHT);
        setLocation(WIN_POSX, WIN_POSY);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("Игра КРЕСТИКИ-НОЛИКИ");
        settingsWindow = new Settings(this);
        gameMap = new GameMap();

        JButton btnStart = new JButton("Начало игры");
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settingsWindow.setVisible(true);
            }
        });

        JButton btnExit = new JButton("Выход из игры");
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JPanel panelButtons = new JPanel();
        panelButtons.setLayout(new GridLayout(1, 2));
        panelButtons.add(btnStart);
        panelButtons.add(btnExit);

        add(panelButtons, BorderLayout.SOUTH);
        add(gameMap);
        setVisible(true);
    }

    void startNewGame(int mode, int fieldSizeX, int fieldSizeY, int winLength) {
        gameMap.startNewGame(mode, fieldSizeX, fieldSizeY, winLength);
    }

}
