package com.kc.thread2;

public class LoginServlet {
    private static String userNameRef;
    private static String passWordRef;

     public static void doPost(String userName, String passWord) {
        try {
            userNameRef = userName;
            if (userNameRef.equals("a")) {
                Thread.sleep(5000);
            }
            passWordRef = passWord;
            System.out.println("userName:" + userNameRef + "," + "passWord:" + passWord);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}

