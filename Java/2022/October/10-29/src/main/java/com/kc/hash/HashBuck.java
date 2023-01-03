package com.kc.hash;

public class HashBuck {
    public Node [] array ;
    public int size;
    private static final  int CAPACITY  = 5;

    public HashBuck(Node[] array, int size) {
        this.array = new Node[CAPACITY];
        this.size = 0;
    }

    static class Node{
        public  int key;
        public  int value;
        public Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public void put(int key, int value) {

    }

    public  int get(int key) {

    }


}
