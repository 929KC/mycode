package com.bit.generic;

class Message<T> {
    private T message;

    public T getMessage() {
        return message;
    }

    public void setMessage(T message) {
        this.message = message;
    }

    public static void main(String[] args) {
        Message<Student> m1 =new Message<>();
        m1.setMessage(new Student());
        Message<Teacher> m2 = new Message<>();
        m2.setMessage(new Teacher());

    }

    public  static  void fun(Message<? super  Student> tmp){
        System.out.println(tmp.getMessage());
    }
}