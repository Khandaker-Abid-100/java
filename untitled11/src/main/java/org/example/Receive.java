package org.example;
import java.util.concurrent.BlockingQueue;
public class Receive {
    private int ws;

    private int b = 0;
    private BlockingQueue<p> nq;
    private BlockingQueue<Integer> ac;

    public Receive(int ws, BlockingQueue<p> nq, BlockingQueue<Integer> ac) {
        this.ws = ws;
        this.nq = nq;
        this.ac = ac;
    }
}