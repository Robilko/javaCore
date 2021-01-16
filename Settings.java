package lesson7;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Settings extends JFrame {
    private static final int WIN_WIDTH = 350;
    private static final int WIN_HEIGHT = 270;

    private static final int MIN_FIELD_LENGTH = 3;
    private static final int MAX_FIELD_LENGTH = 10;
    private static final int MIN_WIN_LENGTH = 3;
    private static final String FIELD_SIZE_PREFIX = "Размер игрового поля: ";
    private static final String WIN_LENGTH_PREFIX = "Выигрышная длинна: ";

    private MainWindow mainWindow;
    private JRadioButton humVsAi;
    private JRadioButton humVsHum;
    private JSlider sliderFieldSize;
    private JSlider sliderWinLength;

    Settings(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        setSize(WIN_WIDTH, WIN_HEIGHT);

        Rectangle gameWindowBounds = mainWindow.getBounds();
        int posX = (int)gameWindowBounds.getCenterX() - WIN_WIDTH / 2;
        int posY = (int)gameWindowBounds.getCenterY() - WIN_HEIGHT / 2;
        setLocation(posX, posY);
        setTitle("Настройки игры");
        setResizable(false);
        setLayout(new GridLayout(10, 1));
        addGameModeSettings();
        addFieldSizeControl();

        JButton btnStartGame = new JButton("Начать новую игру");
        btnStartGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnStartClick();
            }
        });

        add(btnStartGame);


    }

    private void addGameModeSettings() {
        add(new JLabel("Выберите режим игры: "));
        humVsAi = new JRadioButton("Игрок против ИИ", true);
        humVsHum = new JRadioButton("Игрок против игрока");
        ButtonGroup gameMode = new ButtonGroup();
        gameMode.add(humVsAi);
        gameMode.add(humVsHum);
        add(humVsAi);
        add(humVsHum);
    }

    private void addFieldSizeControl() {
        JLabel lblFieldSize = new JLabel(FIELD_SIZE_PREFIX + MIN_FIELD_LENGTH);
        JLabel lblWinLength = new JLabel(WIN_LENGTH_PREFIX + MIN_WIN_LENGTH);

        sliderFieldSize = new JSlider(MIN_FIELD_LENGTH, MAX_FIELD_LENGTH, MIN_FIELD_LENGTH);
        sliderFieldSize.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                lblFieldSize.setText(FIELD_SIZE_PREFIX + sliderFieldSize.getValue());
                sliderWinLength.setMaximum(sliderFieldSize.getValue());
            }
        });

        sliderWinLength = new JSlider(MIN_WIN_LENGTH, MIN_WIN_LENGTH, MIN_WIN_LENGTH);
        sliderWinLength.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                lblWinLength.setText(WIN_LENGTH_PREFIX + sliderWinLength.getValue());
            }
        });

        add(new JLabel("Выберите размер поля: "));
        add(lblFieldSize);
        add(sliderFieldSize);
        add(new JLabel("Выберите выигрушную комбинацию: "));
        add(lblWinLength);
        add(sliderWinLength);
    }

    private void btnStartClick() {
        int gameMode;
        if (humVsAi.isSelected()) {
            gameMode = GameMap.GAME_MODE_HVA;
        } else if (humVsHum.isSelected()) {
            gameMode = GameMap.GAME_MODE_HVH;
        } else {
            throw new RuntimeException("Неизвестный режим игры");
        }

        int fieldSize = sliderFieldSize.getValue();
        int winLength = sliderWinLength.getValue();
        mainWindow.startNewGame(gameMode, fieldSize, fieldSize, winLength);
        setVisible(false);
    }
}
