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
    public  static int mapSizeX, mapSizeY;

    public static void initMap() {
        mapSizeX = 5;
        mapSizeY = 5;

        map = new char[mapSizeY][mapSizeX];

        for (int y = 0; y < mapSizeY; y++) {
            for (int x = 0; x < mapSizeX; x++) {
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
        int x, y;
        do {
            x = RANDOM.nextInt(mapSizeX);
            y = RANDOM.nextInt(mapSizeY);
        } while (!isEmptyCell(y, x));
        map[y][x] = PC_DOT;
    }

    public static boolean isValidCell(int y, int x) {
        return (x >= 0 && x < mapSizeX && y >= 0 && y < mapSizeY );
    }

    public static boolean isEmptyCell(int y, int x) {
        return map[y][x] == EMPTY_DOT;
    }

    public static boolean checkWin(char someChar) {
        int scoreToWin = 4;
        //Проверка выигрышных комбинаций по диагонали:

        //проверка центральных диагоналей
        int diagScore1 = 0;
        int diagScore2 = 0;
        for (int y = 0, x = 4; y < mapSizeY; y++, x--) {
            if(map[y][y] == someChar) {
                diagScore1++;
                if(diagScore1 == scoreToWin) return true;
            }
            if(map[y][x] == someChar) {
                diagScore2++;
                if(diagScore2 == scoreToWin) return true;
            }
        }

        //Проверка второстепенных диагоналей
        diagScore1 = 0;
        diagScore2 = 0;
        for(int y = 0, x = 1; y < 4; y++, x++) {
            if(map[y][x] == someChar) {
                diagScore1++;
                if(diagScore1 == scoreToWin) return true;
            }
            if(map[x][y] == someChar) {
                diagScore2++;
                if(diagScore2 == scoreToWin) return true;
            }
        }

        diagScore1 = 0;
        diagScore2 = 0;
        for(int y = 4, x = 1; y > 0; y--, x++) {
            if (map[y][x] == someChar) {
                diagScore1++;
                if(diagScore1 == scoreToWin) return true;
            }
            if (map[y - 1][x - 1] == someChar) {
                diagScore2++;
                if (diagScore2 == scoreToWin) return true;
            }
        }


        // Проверка выигрышной комбинации по горизонтали или вертикали
        for (int y = 0; y < mapSizeY; y++) {
            int gorizontalScore = 0;
            int verticalScore = 0;
            for (int x = 0; x < mapSizeX; x++) {
                if(map[y][x] == someChar) {
                    gorizontalScore++;
                    if(gorizontalScore == scoreToWin) return true;
                }
                if(map[x][y] == someChar) {
                    verticalScore++;
                    if(verticalScore == mapSizeX) return true;
                }
            }
        }
        return false;
    }


    public static boolean mapIsFull() {
        for (int y = 0; y < mapSizeY; y++) {
            for (int x = 0; x < mapSizeX; x++) {
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