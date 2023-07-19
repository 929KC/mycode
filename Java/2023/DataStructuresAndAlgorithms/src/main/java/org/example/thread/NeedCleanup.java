package org.example.thread;

public class NeedCleanup {
    private final int id;
    public NeedCleanup(int id) {
        this.id = id;
        System.out.println("NeedClean up"+id);
    }

    public void cleanup(){
        System.out.println("clean up"+id);
    }

}
