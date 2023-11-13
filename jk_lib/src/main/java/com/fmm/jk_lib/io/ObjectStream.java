package com.fmm.jk_lib.io;

import com.fmm.jk_lib.jutlis.LogUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 对象的读写流
 */
public class ObjectStream {


    public static void main(String[] args) {
        objectInputStreamTest();
    }


    public static void objectOutputStreamTest(){
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("objectOOS.txt"));
            Dog dog = new Dog("旺财",8);
            oos.writeObject(dog);
            oos.flush();
            oos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void objectInputStreamTest(){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("objectOOS.txt"));

            Dog d = (Dog) ois.readObject();
            LogUtils.d(d.toString());
        } catch (IOException | ClassNotFoundException e) {

        }
    }
}
