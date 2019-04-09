package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        String fileName;
        String line = "";
        String flag = "";
        int[][] matr;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        do{
            System.out.println("Введите имя файла для ввода матрицы");
            fileName = (br.readLine()).trim();
            matr = IO.inpMatr(fileName);
            if(matr != null){
                System.out.println("Матрица введена успешно");
                IntellectMatr imatr = new IntellectMatr(matr);
                System.out.println("Введена матрица:");
                imatr.putMatr();
                System.out.println("Вектор, i-ый элемент которого равен произведению положительных элементов i-го столбца матрицы");
                IO.putArr(imatr.getColumnProductVector());
                System.out.println("Заменияем на 0 все элементы матрицы, модуль которых меньше 8");
                new IntellectMatr(imatr.toMakeZero(8)).putMatr();
                System.out.println("--- Дополнительные задания ---");
                System.out.println("Номер строки, сумма элементов которой больше 150");
                System.out.println(imatr.getRowSumAbove(150));
                System.out.println("Удалить строки матрицы, сумма элементов в которых больше 50");
                new IntellectMatr(imatr.deleteRowSumUnder(50)).putMatr();
                System.out.println("Введите имя для вывода матрицы");
                fileName = (br.readLine()).trim();
                if(IO.outMatr(fileName,imatr.getMatr()))
                    System.out.println("Успешный вывод!");
            }



            System.out.println("Продолжить ?:Да - <Enter>, Нет - <n>");
            flag = br.readLine().trim();
        } while (!flag.equals("n"));

    }
}
