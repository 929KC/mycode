package com.kc.system.io;

import java.io.*;

public class SerializeUtil {
    //序列化,将对象转换成二进制
    public static void saveObject(Object object) throws IOException {
        ObjectOutputStream oos = null;
        OutputStream out = null;
        try{
            out = new FileOutputStream("D:/demo.txt");
            oos = new ObjectOutputStream(out);
            oos.writeObject(object);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            out.close();
            oos.close();
        }
    }
    //反序列化,还原成对象
    public static  Object readObject() throws IOException {
        ObjectInputStream ois = null;
        InputStream is = null;
        try {
            is = new FileInputStream("D:/demo.txt");
            ois = new ObjectInputStream(is);
            Object object = ois.readObject();
            return object;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally{
            is.close();
            ois.close();
        }
        return null;
    }
}
