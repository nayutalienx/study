package com.company;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Random;

public class RAFileDemo {
    static void p (String s){
        System.out.println(s);
    }

    static void fileInfo(File f){
        p("Имя файла: " + f.getName());
        p("Путь: "+f.getPath());
        p("Абсолютный путь: " + f.getAbsolutePath());
        p("Надкаталог: "+ f.getParent());
        p(f.exists() ? "существует" : "не существует");
        p(f.canWrite() ? "для записи" : "не для записи");
        p(f.canRead() ? "для чтения" : "не для чтения");
        p(f.isDirectory() ? "каталог" : "не каталог");
        p(f.isFile() ? "нормальный файл" : "возможно именованный канал" );
        p(f.isAbsolute() ? "абсолютный" : "не абсолютный");
        p("Последняя модификация файла: "+f.lastModified());
        p("Размер файла: " + f.length() + "байтов");
        System.out.println();
    }

    public static void main(String[] args){
        File f1 = new File("Picture/pic1.png");
        fileInfo(f1);
        File f2 = new File("Picture");
        fileInfo(f2);
        String[] s = f2.list();
        System.out.printf("Список файлов каталога %s: \n",f2.getName());
        for(int i = 0; i < s.length; i++){
            System.out.println(s[i]);
        }

        try {
            byte[] arr = IOFile.inputRAFile(f1);
            if(arr != null) System.out.printf("Информация из файла %s загружена успешно\n",f1.getAbsolutePath());
            File f3 = new File("Picture/pic1_1.png");
            if(IOFile.outputRAFile(f3,arr,0,arr.length,0)){
                System.out.printf("\nКопирование в файл %s произведено успешно\n", f3.getAbsolutePath());
            }
            f3 = new File("Picture/pic1_2.png");
            if(IOFile.outputRAFile(f3,arr,0,arr.length,0)){
                System.out.printf("\nКопирование в файл %s произведено успешно\n", f3.getAbsolutePath());
            } else {
                System.out.printf("\nОшибка вывода в файл %s\n",f3.getAbsolutePath());
            }

            int n = 19000;
            byte[] arr1 = new byte[n];
            for(int i = 0; i < arr1.length; i++){
                arr1[i] = (byte)0xdb;
            }
            if(IOFile.outputRAFile(f3,arr1,0,arr1.length,10500)) {
                System.out.printf("\nВывод помехи в файл %s произведен успешно\n", f3.getAbsolutePath());
            }

            s = f2.list();
            FilenameFilter only = new OnlyExt("jpg");
            String[] sOnly = f2.list(only);
            System.out.printf("Список файлов каталога %s:\n",f2.getName());
            for(int i = 0; i < s.length; i++) System.out.println(s[i]);
            System.out.println("Список файлов только с расширением jpg: ");
            for(int i = 0; i < sOnly.length; i++) System.out.println(sOnly[i]);
        } catch (Exception e){
            System.out.println("Ошибка: " + e.toString());
        } finally {

        }




        System.out.println("--------------------------работа с матрицами----------------------------------");

        int n = 5, m = 5; String t = "short";
        f1 = new File("Matr/matr_"+n+"_"+m+"_"+t+".bin");
        System.out.printf("В файле выводятся %d матриц %dx%d с элементами типа %s\n",n,m,m,t);
        Random r = new Random();
        short[] arr = new short[n*m*m];
        for(int i = 0; i < arr.length; i++){
            arr[i] = (short)(r.nextInt(100));
        }
        try{

            IOFile.outShortRAFile(f1,arr,0);
            for(int i = 0; i < arr.length; i++) arr[i] = 0;
            System.out.printf("Содержимое файла %s, интерпретированное как short-значения:\n",f1.getName());
            arr = IOFile.inpShortArrRAFile(f1);

            MatrProc.putArr(arr,m*m);
            System.out.println("robit");
            short[][] matr1 = IOFile.inpShortMatrRAFile(f1,m,m*m*2*(2-1));
            System.out.println("Введена матрица номер 2:");
            MatrProc.putMatr(matr1);

            short[][] matr2 = IOFile.inpShortMatrRAFile(f1,m,m*m*2*(5-1));
            System.out.println("Введена матрица номер 5:");
            MatrProc.putMatr(matr2);

            System.out.println("~Aij & ~Bij = ");
            matr1 = MatrProc.myPersonalFunction(matr1,matr2);
            MatrProc.putMatr(matr1);
            short[] arr1 = MatrProc.matrToArr(matr1);
            System.out.println("После преобразования матрицы в массив:");
            MatrProc.putArr(arr1,m*m);
            IOFile.outShortRAFile(f1,arr1,m*m*2*(2-1));
            for(int i = 0; i < arr.length; i++){
                arr[i]=0;
            }
            System.out.printf("Новое содержимое файла %s, интерпретированное как short-значения:\n",f1.getName());
            arr = IOFile.inpShortArrRAFile(f1);
            MatrProc.putArr(arr, m*m);

        } catch(Exception e){System.out.println("Ошибка "+e.toString());}

    }
}
