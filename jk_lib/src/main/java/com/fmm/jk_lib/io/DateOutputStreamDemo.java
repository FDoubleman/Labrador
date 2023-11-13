package com.fmm.jk_lib.io;

import com.fmm.jk_lib.jutlis.LogUtils;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @Des:DateOutputStream 使用
 * @date:2023 11 10 17:00
 */
public class DateOutputStreamDemo {


    /**
     * 对电脑中的文件 /Users/fmm/myproject/text/dps.txt 进行写入内容
     */
    public static void dateOutputStreamTest(){
        LogUtils.d("dateOutputStreamTest  run ");
        File file = new File("/Users/fmm/myproject/text/dps.txt");
        DataOutputStream dps = null;
        try {
             dps = new DataOutputStream(
                    new BufferedOutputStream(
                    new FileOutputStream(file)
            ));
//            dps.writeBytes("---新的开始---------------");
//            dps.write("hello io ".getBytes(StandardCharsets.UTF_8));
//            dps.writeBoolean(true);
//            dps.writeByte(100);
            dps.writeChar('a');
            dps.writeDouble(99999999);
//            dps.writeFloat(99999999.99999f);
            //dps.writeUTF("-----结束--------------------");

            dps.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                if(dps!=null){
                    dps.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void gptWriteDemo(){
        try {
            // 在 Java 中，可以使用 FileOutputStream 的构造函数中的第二个参数来指定是否启用追加模式。
            // 将追加模式设置为 true，以确保在文件末尾添加新数据而不覆盖先前的内容。
            // 创建 DataOutputStream 与 FileOutputStream 相结合
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("dataFile.txt",true));

            // 写入不同类型的数据
            dataOutputStream.writeInt(42);
            dataOutputStream.writeDouble(3.14);
            dataOutputStream.writeUTF("Hello, World!");

            // 关闭 DataOutputStream
            dataOutputStream.close();

            System.out.println("Data has been written to the file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void gptReadDemo(){
        try {
            // 创建 DataInputStream 与 FileInputStream 相结合
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream("dataFile.txt"));

            // 读取不同类型的数据
            int intValue = dataInputStream.readInt();
            double doubleValue = dataInputStream.readDouble();
            String stringValue = dataInputStream.readUTF();

            // 关闭 DataInputStream
            dataInputStream.close();

            // 打印读取的数据
            System.out.println("Read int: " + intValue);
            System.out.println("Read double: " + doubleValue);
            System.out.println("Read string: " + stringValue);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
