package lesson2;

import java.util.Arrays;

public class Lesson2 {
//  1 Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
//  Написать метод, заменяющий в  принятом массиве 0 на 1, 1 на 0;
    public static int[] arrayOneToNull(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
           if (arr[i] == 0) arr[i] = 1;
           else if (arr[i] == 1) arr[i] = 0;
        }
        return arr;
    }

//  2 Задать пустой целочисленный массив размером 8. Написать метод, который c помощью цикла заполнит
//  его значениями 1 4 7 10 13 16 19 22;
    public static int[] fillValues(int[] arr) {
        int value = 1;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = value;
            value += 3;
        }
        return arr;
    }

//  3 Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ], написать метод, принимающий на вход массив
//  и умножающий числа меньше 6 на 2;
    public static int[] underSixMultiplyTwo(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) arr[i] *= 2;
        }
        return arr;
    }

//  4 Задать одномерный массив. Написать методы поиска в нём минимального и максимального элемента;
    public static int arrayMin(int[] arr) {
        int min = arr[0];
        for(int i : arr) {
            if(i < min) min = i;
        }
        return min;
    }

    public static int arrayMax(int[] arr) {
        int max = arr[0];
        for(int i : arr){
            if(i > max) max = i;
        }
        return max;
    }

//  5 * Создать квадратный целочисленный массив (количество строк и столбцов одинаковое),
//  заполнить его диагональные элементы единицами, используя цикл(ы);

    public static void squareMassive(int size) {
        int[][] arr = new int[size][size];
        for (int i = 0, j = arr[i].length - 1; i < size; i++, j--) {
            arr[i][i] = arr[i][j] = 1;
        }


        for(int i = 0;  i < size; i++) {
            for(int j = 0; j < size; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

//  6 ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true если в массиве есть место, в котором сумма левой и правой части массива равны. Примеры:
//  checkBalance([1, 1, 1, || 2, 1]) → true,
//  checkBalance ([2, 1, 1, 2, 1]) → false,
//  checkBalance ([10, || 1, 2, 3, 4]) → true.
//  Абстрактная граница показана символами ||, эти символы в массив не входят.

    public static boolean checkBalance(int[] arr) {
        int sum1 = 0;
        int sum2 = 0;

        for (int k : arr) {
            sum2 += k;
        }
        for (int i : arr) {
            sum1 += i;
            sum2 = sum2 - i;
            if (sum1 == sum2) return true;
        }
        return false;
    }

//  7 *** Написать метод, которому на вход подаётся одномерный массив и число n (может быть положительным, или отрицательным),
//  при этом метод должен циклически сместить все элементы массива на n позиций.
//  [1,2,3,4,5], -2 => [3,4,5,1,2]
//  [1,2,3,4,5], 2 => [4,5,1,2,3]

    public static int[] arrayOffset(int[] arr, int n){
        int[] tempArr = new int[arr.length];
        int size = arr.length;
        if(n > 0) {
            for (int i = 0; i < size; i++) {
                if (n == size) n = 0;
                tempArr[n] = arr[i];
                n++;
            }
        } else if(n < 0) {
            for (int i = 0; i < size; i++) {
                if ((size + n) == size) n = -size;
                tempArr[size + n] = arr[i];
                n++;
            }
        }
        return tempArr;
    }

//  8 **** Не пользоваться вспомогательным массивом при решении задачи 7.

    public static int[] arrayOffsetPro(int[] arr, int n) {
        int size = arr.length;
        int buffer;
        if (n > 0) {
            for(int i = 0; i < n; i++) {
                buffer = arr[0];
                arr[0] = arr[size - 1];

                for(int j = 1; j < size - 1; j++) {
                    arr[size - j] = arr[size - j - 1];
                }
                arr[1] = buffer;
            }
        } else if(n < 0) {
            for(int i = 0; i > n; i--) {
                buffer = arr[size - 1];
                arr[size - 1] = arr[0];

                for(int j = 1; j < size - 1; j++) {
                    arr[j - 1] = arr[j];
                }
                arr[size - 2] = buffer;
            }
        }
        return arr;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println("Результат задания №1: " + Arrays.toString(arrayOneToNull(arr)));

        int[] arr2 = new int[8];
        System.out.println("Результат задания №2: " + Arrays.toString(fillValues(arr2)));

        int[] arr3 = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("Результат задания №3: " + Arrays.toString(underSixMultiplyTwo(arr3)));

        int[] arr4 = new int[] {10, 2, 3, 4, 5, 6, 7, 8};
        System.out.println("Резульататы задания №4: ");
        System.out.println("Минимальным элементом массива " + Arrays.toString(arr4) + " является: " + arrayMin(arr4));
        System.out.println("Максимальным элементом массива " + Arrays.toString(arr4) + " является: " + arrayMax(arr4));

        System.out.println("Резульатат задания №5: ");
        squareMassive(5); // в метод передается размер квадратного массива


        System.out.println("Резульататы задания №6: ");
        System.out.println(checkBalance(new int[]{1, 1, 1, 2, 1}));
        System.out.println(checkBalance(new int[]{2, 1, 1, 2, 1}));
        System.out.println(checkBalance(new int[]{10, 1, 2, 3, 4}));

        System.out.println("Резульататы задания №7: ");
        System.out.println(Arrays.toString(arrayOffset(new int[] {1, 2, 3, 4, 5}, -2)));
        System.out.println(Arrays.toString(arrayOffset(new int[] {1, 2, 3, 4, 5}, 2)));

        System.out.println("Резульататы задания №8: ");
        System.out.println(Arrays.toString(arrayOffsetPro(new int[] {1, 2, 3, 4, 5}, -2)));
        System.out.println(Arrays.toString(arrayOffsetPro(new int[] {1, 2, 3, 4, 5}, 2)));
    }
}
