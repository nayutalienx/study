package com.company;

public class MatrProc {

    public static void putMatr(short[][] matr){
        if(matr==null) return;
        for(int i = 0; i < matr.length;i++){
            for(int j = 0; j < matr[0].length;j++){
                System.out.printf("%4d", matr[i][j]);
            }
            System.out.println();
        }
    }

    public static void putArr(short X[], int n){
        if(X==null) return;
        for(int i = 0; i<X.length;i++){
            if((i!=0) && (i%n == 0)) System.out.println();
            System.out.printf("%4d",X[i]);
        }
        System.out.println();
    }

    public static short[] matrToArr(short[][] matr){
        short[] arr = new short[matr.length * matr[0].length];
        int k = 0;
        for(int i = 0; i< matr.length;i++){
            for(int j =0; j< matr[0].length;j++){
                arr[k] = matr[i][j];
                k = k+1;
            }
        }
        return arr;
    }




        public static short[][] myPersonalFunction(short[][] m1, short[][] m2){
        if((m1==null)||(m2==null)||(m1.length!=m2.length)||(m1[0].length!=m2[0].length)) return null;
        short[][] m = new short[m1.length][m1[0].length];
        for(int i = 0; i < m.length; i++){
            for(int j = 0; j < m[0].length; j++){
                m[i][j] = (short)((byte)(~(m1[i][j]))&((byte)(~(m2[i][j]))));
            }
        }
        return m;
        }
}
