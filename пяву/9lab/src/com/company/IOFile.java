package com.company;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class IOFile {

    public static boolean outShortRAFile(File file, short[] arr, int pos) throws IOException {
        RandomAccessFile outpFile = null;
        boolean f = true;
        try{

            outpFile = new RandomAccessFile(file,"rw");
            outpFile.seek(pos);
            for(int i=0; i<arr.length;i++){
                outpFile.writeShort(arr[i]);
            }

        } catch (Exception e){ f=false;}
        finally {
            if(outpFile != null) outpFile.close();
        }
        return f;
    }

    public static short[][] inpShortMatrRAFile(File file, int m, int pos) throws IOException{
        RandomAccessFile inpFile = null;
        long toRead;
        short[][] matr = new short[m][m];
        try{

            inpFile = new RandomAccessFile(file, "r");
            inpFile.seek(pos);
            toRead = inpFile.length() - pos + 1;
            M1:{
                for(int i = 0; i<m; i++){
                    for(int j = 0; j<m;j++){
                        matr[i][j] = inpFile.readShort();
                        toRead -= 2;
                        if(toRead <= 0) break M1;
                    }
                }

            }

        } catch (Exception e){ matr = null;}
        finally {
            if(inpFile != null) inpFile.close();
        }
        return matr;
    }

    public static short[] inpShortArrRAFile(File file) throws IOException{
        RandomAccessFile inpFile = null;
        long toRead;
        short[] arr = null;
        try{

            inpFile = new RandomAccessFile(file,"r");
            toRead = inpFile.length();
            arr = new short[ (int)toRead / 2];
            int i = 0;
            while(toRead > 0){
                arr[i] = inpFile.readShort();
                i = i+1;
                toRead -= 2;
            }

        } catch (Exception e){
            arr = null;
        } finally {
            if (inpFile!=null) inpFile.close();
        }
        return arr;
    }



    public static byte[] inputRAFile(File file) throws IOException {
        RandomAccessFile inpFile = null;
        int nextByte;
        int i = 0;
        byte[] arr = null;
        try{

            inpFile = new RandomAccessFile(file,"r");
            arr = new byte[(int)inpFile.length()];
            while((nextByte = inpFile.read()) != -1){
                arr[i] = (byte)nextByte;
                i = i+1;
            }

        } catch (Exception e){ arr = null; }
        finally {
            if(inpFile != null)
                    inpFile.close();
        }
        return arr;
    }

    public static boolean outputRAFile(File file, byte[] arr, int startInd, int num, long position) throws IOException {

        RandomAccessFile outpFile = null;
        boolean f = true;
        int endInd = startInd + num;
        try{

            outpFile = new RandomAccessFile(file,"rw");
            outpFile.seek(position);

            for(int i = startInd; i < endInd; i++) outpFile.write((int)arr[i]);

        } catch (Exception e){
            f = false;
        } finally {
            if(outpFile != null) outpFile.close();
        }
        return f;

    }

}
