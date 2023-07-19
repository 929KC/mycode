package org.example.thread;


public class SerialNumberGenerator {
    private static volatile int serialNumber;
    public static int nextSerialNumber(){
        return serialNumber++;
    }
}
