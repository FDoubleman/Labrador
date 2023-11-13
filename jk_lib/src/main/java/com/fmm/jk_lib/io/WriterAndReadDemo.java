package com.fmm.jk_lib.io;

import com.fmm.jk_lib.jutlis.LogUtils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @Des: 字符流的读写
 */
public class WriterAndReadDemo {


    public static void main(String[] args) {
        readTest();
    }

    public static void writerTest(){

        try {
            // BufferedWriter添加缓存，使得写入更快
            // FileWriter 是对 outputStreamWriter的封装
            BufferedWriter bw = new BufferedWriter(new FileWriter("writerAndRead.txt"));
            // BufferedWriter添加缓存，使得写入更快,但是参数是Writer，因为写入的时候文件因此需要OutputStreamWriter，
            // OutputStreamWriter又需要outStream ，又是针对File。可以使用 FileOutputStream
            BufferedWriter bw2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("writerAndRead.txt"))));

            bw.write("hello io ");
            bw.write("我爱你 中国");
            bw.flush();
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void readTest(){
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("writerAndRead.txt")));
            try {
                String tt = br.readLine();
                LogUtils.d(tt);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
