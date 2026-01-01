package org.example;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
public class Send {
        private  int ws;
        private  Map<Integer, p> window = new HashMap<>();
        private int sf = 0, sn = 0;
        private  BlockingQueue<Integer> ac;
        public Send(int ws, BlockingQueue<Integer> ac) {
            this.ws = ws;
            this.ac = ac;
        }
        public void sendP(int sen, String d) throws InterruptedException {
            p packet = new p(sen, d);
            window.put(sen, packet);
            System.out.println("Sender: Sent packet " + sen);
            sn++;
        }
}



