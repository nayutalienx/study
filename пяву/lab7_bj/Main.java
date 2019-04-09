 

import java.io.*;

public class Main {

    public static byte byteProccess(byte b){
        byte result = b;
        byte firstTetrad = (byte)(b & 0xf0);
        if(firstTetrad == (byte)0xf0){
            result = firstTetrad;
        }
        return result;
    }

    public static String byteToString(byte b){
        String str = "";
        for(int i = 1;i<=8;i++){
            str = b < 0 ? str + "1" : str + "0";
            b = (byte)(b<<1);
        }
        return str;
    }

    public static void main(String[] args) throws IOException {

        byte[] engrus = { (byte)0x68,(byte)0x65,(byte)0x6c,(byte)0x6c,(byte)0x6f, (byte)0x20, (byte)0xEF, (byte)0xF0,
                (byte)0xE8,(byte)0xE2,(byte)0xE5,(byte)0xF2};

        FileOutputStream fo = null;
        System.out.println("1.Вывод данных из массива байтов в байтовый поток, связанный с файлом byte1_Мосенков_ИВТ13.txt:");
        for(int i = 0; i<engrus.length;i++){
            System.out.printf("Код: %02x ",engrus[i]);
            System.out.println("Можно интерпретировать как символ: "+(char)engrus[i]+" ");
        }

        try {
            fo = new FileOutputStream("byte1_Мосенков_ИВТ13.txt");
            fo.write(engrus);

        } catch (IOException e) {
            System.out.printf("error: \n"+e);
        }
        finally {
            fo.close();
        }

        System.out.println("2. Ввод данных из байтового потока, связанного с созданным файлом byte1_Мосенков_ИВТ13.txt;\nОбработка вводимых байтов(Сбросить в 0000 вторую тетраду, если первая равна 1111);\nВывод обработанных байтов в байтовый поток, связанный с файлом byte2_Мосенков_ИВТ13.txt:");
        fo = null;
        FileInputStream fi = null;
        byte b = 0;
        int d = 0;
        try {
            fi = new FileInputStream("byte1_Мосенков_ИВТ13.txt");
            fo = new FileOutputStream("byte2_Мосенков_ИВТ13.txt");
            while((d = fi.read()) != -1){
                b = (byte)d;
                System.out.printf(byteToString(b)+" ---> ");
                b = byteProccess(b);
                System.out.println(byteToString(b));
                fo.write(b);
            }
        } catch (IOException e) {
            System.out.println("error:\n"+e);
        } finally {
            if(fi != null) fi.close(); if(fo!=null) fo.close();
        }

        System.out.println("3. Ввод данных из символьного потока связанного с файлом char1_Мосенков_ИВТ13.txt\nОбработка вводимых данных(Заменить Ё,ё на Е,e)\nВывод обработанных данных в символьный поток, связанный файлом char2_Мосенков_ИВТ13.txt");
        char bt = 0;
        d = 0;
        FileReader rfi = null;
        FileWriter rfo = null;
        try{
            rfi = new FileReader("char1_Мосенков_ИВТ13.txt");
            rfo = new FileWriter("char2_Мосенков_ИВТ13.txt");
            while((d = rfi.read()) != -1){
                bt = (char) d;
                System.out.print(bt);
                switch (bt){
                    case 'Ё':
                        bt = 'E';
                        break;

                    case 'ё':
                        bt = 'e';
                        break;
                }
                rfo.write(bt);

            }

        } catch (IOException e){
            System.out.println("\nerror\n"+e);
        } finally {
            if(rfi !=null) rfi.close(); if(rfo != null) rfo.close();
        }


    }
}
