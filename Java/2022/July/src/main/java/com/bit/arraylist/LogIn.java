package com.bit.arraylist;

public class LogIn {
    private String userName = "admin";
    private String password = "123456";

    public  void loginInfo(String userName, String password) throws UserNameException, PasswordException {
        if (!this.userName.equals(userName)) {
            throw new UserNameException("用户名错误！");
        }
        if (!this.password.equals(password)) {
            throw new PasswordException("用户名错误！");
        }
        System.out.println("登陆成功");
    }

    public static void main(String[] args) {
        LogIn l=new LogIn();
        try {
            l.loginInfo("ad", "12345");
        } catch (UserNameException e) {
            e.printStackTrace();
        } catch (PasswordException e) {
            e.printStackTrace();
        }
    }
}