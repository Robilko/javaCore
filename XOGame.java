package lesson3;

import java.util.Random;
import java.util.Scanner;

public class XOGame {

    public static char[][] map;
    public static final char HUMAN_DOT = 'X';
    public static final char PC_DOT = 'O';
    public static final char EMPTY_DOT = '_';
    public static final Scanner SCANNER = new Scanner(System.in);
    public static final Random RANDOM = new Random();
    public  static int mapSize;
    public  static int scoreToWin = 4;

    public static void initMap() {
        mapSize = 5;

        map = new char[mapSize][mapSize];

        for (int y = 0; y < mapSize; y++) {
            for (int x = 0; x < mapSize; x++) {
                map[y][x] = EMPTY_DOT;
            }
        }
    }

    public static void printMap() {
        for (char[] y : map){
            for (char x : y) {
                System.out.print("|" + x);
            }
            System.out.print("| \n");
        }
        System.out.println();
    }

    public static void humanTurn() {
        int x, y;

        do {
            System.out.println(" Введите координаты вашего хода: ");
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        } while (!isValidCell(y, x) || !isEmptyCell(y, x));
        map[y][x] = HUMAN_DOT;
    }

    public static void uiTurn() {
        int x = -1, y = -1;
        boolean userWin = false;
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                if (isEmptyCell(i, j)) {
                    map[i][j] = HUMAN_DOT;
                    if (checkWin(HUMAN_DOT)) {
                        x = j;
                        y = i;
                        userWin = true;
                    }
                    map[i][j] = EMPTY_DOT;
                }
            }
        }
        if (!userWin) {
            do {
                x = RANDOM.nextInt(mapSize);
                y = RANDOM.nextInt(mapSize);
            } while (!isEmptyCell(y, x));
        }
        map[y][x] = PC_DOT;
    }

    public static boolean isValidCell(int y, int x) {
        return (x >= 0 && x < mapSize && y >= 0 && y < mapSize );
    }

    public static boolean isEmptyCell(int y, int x) {
        return map[y][x] == EMPTY_DOT;
    }

    public static boolean checkLine(int x1, int y1, int x2, int y2, char someChar) {
        for (int i = 0; i < scoreToWin; i++) {
            if (map[x1 + i * x2][y1 + i * y2] != someChar) return false;
        }
        return true;
    }

    public static boolean checkWin(char someChar) {
        for (int i = 0; i < scoreToWin; i++) {
            //проверяем строки
            if (checkLine(i, 0, 0, 1, someChar)) return true;
            if (checkLine(i + 1, 0, 0, 1, someChar)) return true;
            //проверяем столбцы
            if (checkLine(0, i, 1, 0, someChar)) return true;
            if (checkLine(0, i + 1, 1, 0, someChar)) return true;
        }
        //проверяем диагонали
        if (checkLine(0, 0, 1, 1, someChar) || checkLine(1, 1, 1, 1, someChar) || checkLine(0, 1, 1, 1, someChar) || checkLine(1, 0, 1 ,1, someChar)) return true;
        if (checkLine(0, mapSize - 1, 1, -1, someChar) || checkLine(1, mapSize - 2, 1, -1, someChar) || checkLine(0, mapSize - 2, 1, -1, someChar) || checkLine(1, mapSize - 1, 1, -1, someChar)) return true;

        return false;
    }


    public static boolean mapIsFull() {
        for (int y = 0; y < mapSize; y++) {
            for (int x = 0; x < mapSize; x++) {
                if (map[y][x] == EMPTY_DOT) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        initMap();
        printMap();

        while (true) {
            humanTurn();
            printMap();
            if(checkWin(HUMAN_DOT)) {
                System.out.println("Поздравляю, Вы победили!!!");
                break;
            }
            if(mapIsFull()) {
                System.out.println("НИЧЬЯ!");
                break;
            }

            uiTurn();
            printMap();
            if(checkWin(PC_DOT)) {
                System.out.println("Победил компьютер !  (((((((");
                break;
            }
            if (mapIsFull()) {
                System.out.println("НИЧЬЯ!");
                break;
            }
        }
    }
}

//    Полностью разобраться с кодом, попробовать переписать с нуля;                                  +
//        * Усовершенствовать метод проверки победы (через циклы);                                   +
//        ** Расширить поле до 5х5 и в качестве условий победы установить серию равной 4.            +
//        *** Проработать базовый искусственный интеллект, чтобы он мог блокировать ходы игрока