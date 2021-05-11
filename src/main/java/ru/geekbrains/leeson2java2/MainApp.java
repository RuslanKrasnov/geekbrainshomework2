package ru.geekbrains.leeson2java2;

public class MainApp {

    public static void main(String[] args) {

        String[][] arr = {
                {"11", "11", "11", "11"},
                {"11", "11", "11", "11"},
                {"11", "11", "11", "11"},
                {"11", "11", "11", "11"}
        };
        try {
            System.out.println("Сумма элементов массива равна: " + sumOfArray(arr));
        } catch (MyArraySizeException e) {
            System.out.println("Массив недопустимого размера. Должен быть 4х4.");
        } catch (MyArrayDataException e) {
            System.out.println("Не все элементы массива числа!");
        }
    }

    public static int sumOfArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (!(array.length == 4) || !(array[i].length == 4)) {
                throw new MyArraySizeException();
            } else {
                for (int j = 0; j < array[i].length; j++) {
                    try {
                        sum = sum + Integer.parseInt(array[i][j]);
                    } catch (NumberFormatException e) {
                        throw new MyArrayDataException("В ячейке с индексами " + i + " и " + j + " указано нечисловое значение!");
                    }
                }
            }
        }
        return sum;
    }

}
