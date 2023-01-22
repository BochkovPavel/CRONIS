import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Задание 1
        int[] arr = {3, 1, 2, 0, 8, 4, 8, 6, 6, 1};
        System.out.println(Arrays.toString(getClosestUpperNumberDec(arr)));
        // Задание 2
        /*
        0110 + 0010 = 1000 = (6 + 2 = 8)
        0011 + 0010 = 0101 = (3 + 2 = 5)
        */
        //Задание 3
        /*
        1) 10 индикаторов переведя в двоичную систему по формуле 2^n-1 - 1  мы получаем 1023 значения
        2) Присваиваем каждой бутылке десятичное значение
        3) Капаем на индикаторы по номера бутылок предвставленным в двоичном заначении
        Например яд был в бутылке нор 5 индикаторы покажут следующее значение:
        0 0 0 0 0 0 0 1 0 1
        Для проверки 1000 бутылок при помощи 10 индикаторов понадобиться 1-на итерация (1 день),
        т.к. по условиям результат мы узнаем через 7-иь дней, понадобиться 7-мь дней
         */

    }
    //Меняем местами Элементы
    private static void swap (int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    //Разворачиваем остаток массива. Деление 2 округляет в меньшую сторону, соответственно добавляем 1
    private static void revers (int[] arr, int start, int end){
        int swapsCount = (end - start + 1) / 2;
        for (int i = 0; i < swapsCount; i++) {
            swap(arr, start +i, end -i);
        }
    }
    // Находим индекс , в котором будем увеличивать число
    private static int getSwapIndexInNum(int[] num){
        for (int i = num.length -1; i >= 1; i--) {
            if (num[i-1] < num[i]) return i-1;
        }
        return -1;
    }
    //Находим индекс, в котором лежит замена для swapValue
    private static int getSwapIndexInSubNum(int[] num, int swapValue){
        for (int i = num.length - 1; i >= 0 ; i--) {
            if (num[i] > swapValue) return i;
        }
        return -1;
    }
    //Решение
    private static int[] getClosestUpperNumberDec(int[] num){
        if (num == null) return null;
        int swapIndexInNum = getSwapIndexInNum(num);
        if (swapIndexInNum == -1) return null;
        int swapIndexInSubNum = getSwapIndexInSubNum(num,num[swapIndexInNum]);
        swap(num, swapIndexInNum, swapIndexInSubNum);
        revers(num, swapIndexInNum + 1, num.length - 1);
        return num;
    }

}
