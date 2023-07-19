package org.example.thread;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousCloseException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SocketChannel;

public class NIOBlocked implements Runnable {
    private final SocketChannel sc;

    public NIOBlocked(SocketChannel sc) {
        this.sc = sc;
    }

    @Override
    public void run() {
        try {
            System.out.println("waiting for read() in" + this);
            sc.read(ByteBuffer.allocate(1));
        } catch (AsynchronousCloseException e) {
            System.out.println("AsynchronousCloseException");
        } catch (ClosedChannelException e) {
            System.out.println("ClosedChannelException");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Exiting NIOBlocked.run()" + this);
    }
}
