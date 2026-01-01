package org.example;//package org.example;
//
//public class Main {
//    public static void main(String[] args) {
//        System.out.println("Hello world!");
//    }
//}
//import java.util.*;
//import java.util.concurrent.*;
//
//class Packet {
//    int sequenceNumber;
//    boolean acknowledged;
//    public Packet(int seqNum) {
//        this.sequenceNumber = seqNum;
//        this.acknowledged = false;
//    }
//}
//
//class SlidingWindow {
//    int windowSize;
//    Queue<Packet> window;
//
//    public SlidingWindow(int size) {
//        this.windowSize = size;
//        this.window = new LinkedList<>();
//    }
//
//    public void addPacket(Packet p) {
//        if (window.size() < windowSize) {
//            window.add(p);
//        }
//    }
//
//    public void slideWindow() {
//        while (!window.isEmpty() && window.peek().acknowledged) {
//            window.poll();
//        }
//    }
//}
//
//class Sender {
//    int sequenceNumber = 0;
//    SlidingWindow slidingWindow;
//    int packetSize;
//    double packetLossRate;
//
//    public Sender(int windowSize, int packetSize, double packetLossRate) {
//        this.slidingWindow = new SlidingWindow(windowSize);
//        this.packetSize = packetSize;
//        this.packetLossRate = packetLossRate;
//    }
//
//    public void sendPackets(Receiver receiver) {
//        while (sequenceNumber < 100) { // Sending 100 packets for example
//            Packet packet = new Packet(sequenceNumber++);
//            slidingWindow.addPacket(packet);
//            if (Math.random() > packetLossRate) { // Simulating packet loss
//                receiver.receivePacket(packet);
//            }
//        }
//    }
//}
//
//class Receiver {
//    Set<Integer> receivedPackets = new HashSet<>();
//    public void receivePacket(Packet packet) {
//        // Simulate delay
//        try {
//            Thread.sleep((long)(Math.random() * 100));
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("Received packet with sequence: " + packet.sequenceNumber);
//        packet.acknowledged = true;
//        receivedPackets.add(packet.sequenceNumber);
//    }
//}
//
//public class Main {
//    public static void main(String[] args) {
//        int windowSize = 5;
//        int packetSize = 512; // In bytes
//        double packetLossRate = 0.1; // 10% packet loss
//        Sender sender = new Sender(windowSize, packetSize, packetLossRate);
//        Receiver receiver = new Receiver();
//
//        sender.sendPackets(receiver);
//    }
////}
//import java.util.*;
//import java.util.concurrent.*;
//
//class Packet {
//    int seqNum;
//    String data;
//
//    public Packet(int seqNum, String data) {
//        this.seqNum = seqNum;
//        this.data = data;
//    }
//}
//
//class Sender implements Runnable {
//    private final int windowSize;
//    private final Map<Integer, Packet> window = new HashMap<>();
//    private final Timer timer = new Timer();
//    private int base = 0;
//    private int nextSeqNum = 0;
//    private final BlockingQueue<Packet> networkQueue;
//    private final BlockingQueue<Integer> ackQueue;
//
//    public Sender(int windowSize, BlockingQueue<Packet> networkQueue, BlockingQueue<Integer> ackQueue) {
//        this.windowSize = windowSize;
//        this.networkQueue = networkQueue;
//        this.ackQueue = ackQueue;
//    }
//
//    public void send(Packet packet) throws InterruptedException {
//        if (nextSeqNum < base + windowSize) {
//            window.put(nextSeqNum, packet);
//            System.out.println("Sender: Sent packet " + nextSeqNum);
//            networkQueue.put(packet);
//            startTimer(packet.seqNum);
//            nextSeqNum++;
//        }
//    }
//
//    private void startTimer(int seqNum) {
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                if (window.containsKey(seqNum)) {
//                    System.out.println("Sender: Timeout for packet " + seqNum + ". Retransmitting...");
//                    try {
//                        networkQueue.put(window.get(seqNum));
//                    } catch (InterruptedException e) {
//                        Thread.currentThread().interrupt();
//                    }
//                    startTimer(seqNum);
//                }
//            }
//        }, 3000);
//    }
//
//    public void receiveAck(int ackNum) {
//        if (ackNum >= base && ackNum < base + windowSize) {
//            System.out.println("Sender: Acknowledgment received for packet " + ackNum);
//            window.remove(ackNum);
//            if (ackNum == base) {
//                base++;
//                while (!window.containsKey(base) && base < nextSeqNum) {
//                    base++;
//                }
//            }
//        }
//    }
//
//    @Override
//    public void run() {
//        while (true) {
//            try {
//                Integer ackNum = ackQueue.take();
//                receiveAck(ackNum);
//            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
//                break;
//            }
//        }
//    }
//}
//
//class Receiver implements Runnable {
//    private final int windowSize;
//    private final Map<Integer, Packet> window = new HashMap<>();
//    private int base = 0;
//    private final BlockingQueue<Packet> networkQueue;
//    private final BlockingQueue<Integer> ackQueue;
//
//    public Receiver(int windowSize, BlockingQueue<Packet> networkQueue, BlockingQueue<Integer> ackQueue) {
//        this.windowSize = windowSize;
//        this.networkQueue = networkQueue;
//        this.ackQueue = ackQueue;
//    }
//
//    public void receive(Packet packet) throws InterruptedException {
//        if (packet.seqNum >= base && packet.seqNum < base + windowSize) {
//            System.out.println("Receiver: Received packet " + packet.seqNum);
//            window.put(packet.seqNum, packet);
//            if (packet.seqNum == base) {
//                deliverPackets();
//            }
//            ackQueue.put(packet.seqNum);
//        } else {
//            System.out.println("Receiver: Packet " + packet.seqNum + " is out of order. Ignoring.");
//        }
//    }
//
//    private void deliverPackets() {
//        while (window.containsKey(base)) {
//            System.out.println("Receiver: Delivering packet " + base);
//            window.remove(base);
//            base++;
//        }
//    }
//
//    @Override
//    public void run() {
//        while (true) {
//            try {
//                Packet packet = networkQueue.take();
//                if (Math.random() > 0.2) {  // Simulate packet loss with a 20% chance
//                    receive(packet);
//                } else {
//                    System.out.println("Receiver: Packet " + packet.seqNum + " lost in network.");
//                }
//            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
//                break;
//            }
//        }
//    }
//    public class Main {
//        public static void main(String[] args) throws InterruptedException {
//            int windowSize = 4;
//
//            // Shared queues for network simulation
//            BlockingQueue<Packet> networkQueue = new LinkedBlockingQueue<>();
//            BlockingQueue<Integer> ackQueue = new LinkedBlockingQueue<>();
//
//            Sender sender = new Sender(windowSize, networkQueue, ackQueue);
//            Receiver receiver = new Receiver(windowSize, networkQueue, ackQueue);
//
//            Thread senderThread = new Thread(sender);
//            Thread receiverThread = new Thread(receiver);
//
//            senderThread.start();
//            receiverThread.start();
//
//            // Simulate sending packets
//            for (int i = 0; i < 10; i++) {
//                sender.send(new Packet(i, "Data" + i));
//                Thread.sleep(1000);  // Delay between packet sends
//            }
//
//            senderThread.join();
//            receiverThread.join();
//        }
//    }
//
//}

//****************************************2nd code
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Timer;
//import java.util.TimerTask;
//
//class Packet {
//    int seqNum;
//    String data;
//
//    public Packet(int seqNum, String data) {
//        this.seqNum = seqNum;
//        this.data = data;
//    }
//}
//
//class Sender {
//    private final int windowSize;
//    private final Map<Integer, Packet> window = new HashMap<>();
//    private final Timer timer = new Timer();
//    private int base = 0;
//    private int nextSeqNum = 0;
//
//    public Sender(int windowSize) {
//        this.windowSize = windowSize;
//    }
//
//    public void send(Packet packet) {
//        if (nextSeqNum < base + windowSize) {
//            window.put(nextSeqNum, packet);
//            System.out.println("Sender: Sent packet " + nextSeqNum);
//            startTimer(packet.seqNum);
//            nextSeqNum++;
//        } else {
//            System.out.println("Sender: Window is full. Cannot send packet " + packet.seqNum);
//        }
//    }
//
//    private void startTimer(int seqNum) {
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                if (window.containsKey(seqNum)) {
//                    System.out.println("Sender: Timeout for packet " + seqNum + ". Retransmitting...");
//                    send(window.get(seqNum));
//                }
//            }
//        }, 2000);
//    }
//
//    public void receiveAck(int ackNum) {
//        if (ackNum >= base && ackNum < base + windowSize) {
//            System.out.println("Sender: Acknowledgment received for packet " + ackNum);
//            window.remove(ackNum);
//            if (ackNum == base) {
//                base++;
//                while (!window.containsKey(base) && base < nextSeqNum) {
//                    base++;
//                }
//            }
//        }
//    }
//}
//
//class Receiver {
//    private final int windowSize;
//    private final Map<Integer, Packet> window = new HashMap<>();
//    private int base = 0;
//
//    public Receiver(int windowSize) {
//        this.windowSize = windowSize;
//    }
//
//    public void receive(Packet packet, Sender sender) {
//        if (packet.seqNum >= base && packet.seqNum < base + windowSize) {
//            System.out.println("Receiver: Received packet " + packet.seqNum);
//            window.put(packet.seqNum, packet);
//            if (packet.seqNum == base) {
//                deliverPackets();
//            }
//            sender.receiveAck(packet.seqNum);
//        } else {
//            System.out.println("Receiver: Packet " + packet.seqNum + " is out of order. Ignoring.");
//        }
//    }
//
//    private void deliverPackets() {
//        while (window.containsKey(base)) {
//            System.out.println("Receiver: Delivering packet " + base);
//            window.remove(base);
//            base++;
//        }
//    }
//}
//
//public class Main{
//    public static void main(String[] args) {
//        Sender sender = new Sender(4);
//        Receiver receiver = new Receiver(4);
//
//        // Simulating sending packets
//        for (int i = 0; i < 10; i++) {
//            sender.send(new Packet(i, "Data" + i));
//        }
//
//        // Simulating receiving packets
//        receiver.receive(new Packet(0, "Data0"), sender);
//        receiver.receive(new Packet(1, "Data1"), sender);
//        receiver.receive(new Packet(2, "Data2"), sender);
//        receiver.receive(new Packet(3, "Data3"), sender);
//
//        // Simulate packet 4 being lost, requiring retransmission
//        receiver.receive(new Packet(5, "Data5"), sender);
//    }
//}
// Simplify code


//new code
//import java.util.*;
//import java.util.concurrent.*;
//
//class Packet {
//    int seqNum;
//    String data;
//
//    public Packet(int seqNum, String data) {
//        this.seqNum = seqNum;
//        this.data = data;
//    }
//}
//
//class Sender implements Runnable {
//    private final int windowSize;
//    private final Map<Integer, Packet> window = new HashMap<>();
//    private int base = 0, nextSeqNum = 0;
//    private final BlockingQueue<Packet> networkQueue;
//    private final BlockingQueue<Integer> ackQueue;
//    private final Timer timer = new Timer();
//
//    public Sender(int windowSize, BlockingQueue<Packet> networkQueue, BlockingQueue<Integer> ackQueue) {
//        this.windowSize = windowSize;
//        this.networkQueue = networkQueue;
//        this.ackQueue = ackQueue;
//    }
//
//    public void sendPacket(int seqNum, String data) throws InterruptedException {
//        Packet packet = new Packet(seqNum, data);
//        window.put(seqNum, packet);
//        networkQueue.put(packet);
//        System.out.println("Sender: Sent packet " + seqNum);
//        startTimer(seqNum);
//        nextSeqNum++;
//    }
//
//    private void startTimer(int seqNum) {
//        timer.schedule(new TimerTask() {
//            public void run() {
//                if (window.containsKey(seqNum)) {
//                    try {
//                        networkQueue.put(window.get(seqNum));
//                        System.out.println("Sender: Timeout, retransmitting packet " + seqNum);
//                    } catch (InterruptedException ignored) {}
//                    startTimer(seqNum); // Restart timer
//                }
//            }
//        }, 3000);
//    }
//
//    public void processAck(int ackNum) {
//        if (window.containsKey(ackNum)) {
//            System.out.println("Sender: Ack received for packet " + ackNum);
//            window.remove(ackNum);
//            if (ackNum == base) {
//                while (!window.containsKey(++base)) {} // Slide base window
//            }
//        }
//    }
//
//    public void run() {
//        try {
//            while (true) processAck(ackQueue.take());
//        } catch (InterruptedException ignored) {}
//    }
//}
//
//class Receiver implements Runnable {
//    private final int windowSize;
//    private final Map<Integer, Packet> window = new HashMap<>();
//    private int base = 0;
//    private final BlockingQueue<Packet> networkQueue;
//    private final BlockingQueue<Integer> ackQueue;
//
//    public Receiver(int windowSize, BlockingQueue<Packet> networkQueue, BlockingQueue<Integer> ackQueue) {
//        this.windowSize = windowSize;
//        this.networkQueue = networkQueue;
//        this.ackQueue = ackQueue;
//    }
//
//    public void receivePacket(Packet packet) throws InterruptedException {
//        if (packet.seqNum >= base && packet.seqNum < base + windowSize) {
//            System.out.println("Receiver: Received packet " + packet.seqNum);
//            window.put(packet.seqNum, packet);
//            if (packet.seqNum == base) deliverPackets();
//            ackQueue.put(packet.seqNum);
//        }
//    }
//
//    private void deliverPackets() {
//        while (window.containsKey(base)) {
//            System.out.println("Receiver: Delivering packet " + base);
//            window.remove(base++);
//        }
//    }
//
//    public void run() {
//        try {
//            while (true) {
//                Packet packet = networkQueue.take();
//                if (Math.random() > 0.2) receivePacket(packet); // Simulate 20% packet loss
//                else System.out.println("Receiver: Packet " + packet.seqNum + " lost");
//            }
//        } catch (InterruptedException ignored) {}
//    }
//}
//
//public class Main {
//    public static void main(String[] args) throws InterruptedException {
//        int windowSize = 4;
//        BlockingQueue<Packet> networkQueue = new LinkedBlockingQueue<>();
//        BlockingQueue<Integer> ackQueue = new LinkedBlockingQueue<>();
//
//        Sender sender = new Sender(windowSize, networkQueue, ackQueue);
//        Receiver receiver = new Receiver(windowSize, networkQueue, ackQueue);
//
//        new Thread(sender).start();
//        new Thread(receiver).start();
//
//        for (int i = 0; i < 10; i++) {
//            sender.sendPacket(i, "Data" + i);
//            Thread.sleep(1000); // Delay between packet sends
//        }
//    }
//}
import java.util.*; // Importing necessary utility classes
import java.util.concurrent.*; // Importing concurrency classes for BlockingQueue

// Represents a data packet with a sequence number and data content
class Packet {
    int seqNum; // Unique identifier for each packet
    String data; // Data content of the packet

    // Constructor to create a packet with a given sequence number and data
    public Packet(int seqNum, String data) {
        this.seqNum = seqNum;
        this.data = data;
    }
}

// Simulates the sender in the Selective Repeat protocol
class Sender implements Runnable {
    private final int windowSize; // Size of the sliding window
    private final Map<Integer, Packet> window = new HashMap<>(); // Map to store packets in the window
    private int base = 0, nextSeqNum = 0; // Base is the first packet in the window; nextSeqNum is the next packet to be sent
    private final BlockingQueue<Packet> networkQueue; // Queue for sending packets to the receiver
    private final BlockingQueue<Integer> ackQueue; // Queue for receiving acknowledgments
    private final Timer timer = new Timer(); // Timer to handle packet retransmissions

    // Constructor initializes window size, network queue, and acknowledgment queue
    public Sender(int windowSize, BlockingQueue<Packet> networkQueue, BlockingQueue<Integer> ackQueue) {
        this.windowSize = windowSize;
        this.networkQueue = networkQueue;
        this.ackQueue = ackQueue;
    }

    // Method to send a packet with a specific sequence number and data
    public void sendPacket(int seqNum, String data) throws InterruptedException {
        Packet packet = new Packet(seqNum, data); // Create a new packet
        window.put(seqNum, packet); // Add packet to the sender's window
        networkQueue.put(packet); // Place the packet in the network queue to send it to the receiver
        System.out.println("Sender: Sent packet " + seqNum);
        startTimer(seqNum); // Start a timer for the packet to handle potential retransmission
        nextSeqNum++;
    }

    // Starts a timer for a packet, resending it if no acknowledgment is received within 3 seconds
    private void startTimer(int seqNum) {
        timer.schedule(new TimerTask() {
            public void run() {
                if (window.containsKey(seqNum)) { // Check if packet still needs acknowledgment
                    try {
                        networkQueue.put(window.get(seqNum)); // Retransmit packet if no acknowledgment
                        System.out.println("Sender: Timeout, retransmitting packet " + seqNum);
                    } catch (InterruptedException ignored) {}
                    startTimer(seqNum); // Restart the timer for further retransmissions if needed
                }
            }
        }, 3000); // Timeout interval set to 3 seconds
    }

    // Processes an acknowledgment and slides the window if possible
    public void processAck(int ackNum) {
        if (window.containsKey(ackNum)) { // If acknowledgment is within the window
            System.out.println("Sender: Ack received for packet " + ackNum);
            window.remove(ackNum); // Remove acknowledged packet from the window
            if (ackNum == base) { // If acknowledgment is for the base packet, slide the window
                while (!window.containsKey(++base)) {} // Move base to the next unacknowledged packet
            }
        }
    }

    // The main logic for the Sender that runs in a separate thread
    public void run() {
        try {
            while (true) processAck(ackQueue.take()); // Continuously wait for acknowledgments and process them
        } catch (InterruptedException ignored) {}
    }
}

// Simulates the receiver in the Selective Repeat protocol
class Receiver implements Runnable {
    private final int windowSize; // Size of the receiver's sliding window
    private final Map<Integer, Packet> window = new HashMap<>(); // Buffer for out-of-order packets
    private int base = 0; // Expected sequence number of the next packet
    private final BlockingQueue<Packet> networkQueue; // Queue to receive packets from sender
    private final BlockingQueue<Integer> ackQueue; // Queue to send acknowledgments to sender

    // Constructor initializes window size, network queue, and acknowledgment queue
    public Receiver(int windowSize, BlockingQueue<Packet> networkQueue, BlockingQueue<Integer> ackQueue) {
        this.windowSize = windowSize;
        this.networkQueue = networkQueue;
        this.ackQueue = ackQueue;
    }

    // Receives a packet, stores it in the window, and sends acknowledgment
    public void receivePacket(Packet packet) throws InterruptedException {
        if (packet.seqNum >= base && packet.seqNum < base + windowSize) { // Accept packet if it fits in the window
            System.out.println("Receiver: Received packet " + packet.seqNum);
            window.put(packet.seqNum, packet); // Store packet in the window buffer
            if (packet.seqNum == base) deliverPackets(); // Deliver packets in order starting from base
            ackQueue.put(packet.seqNum); // Send acknowledgment for the packet
        }
    }

    // Delivers packets in order starting from the base sequence number
    private void deliverPackets() {
        while (window.containsKey(base)) { // Check if the next in-order packet is available
            System.out.println("Receiver: Delivering packet " + base);
            window.remove(base++); // Deliver and remove packet, then move base to the next
        }
    }

    // Main logic for the Receiver that runs in a separate thread
    public void run() {
        try {
            while (true) {
                Packet packet = networkQueue.take(); // Wait for a packet from the sender
                if (Math.random() > 0.2) receivePacket(packet); // 80% chance to process the packet (simulating 20% loss)
                else System.out.println("Receiver: Packet " + packet.seqNum + " lost"); // Simulate packet loss
            }
        } catch (InterruptedException ignored) {}
    }
}

// Main class to set up and run the network simulation
public class Main {
    public static void main(String[] args) throws InterruptedException {
        int windowSize = 4; // Define the window size for both sender and receiver

        // Shared queues for network simulation
        BlockingQueue<Packet> networkQueue = new LinkedBlockingQueue<>(); // Queue for packets
        BlockingQueue<Integer> ackQueue = new LinkedBlockingQueue<>(); // Queue for acknowledgments

        // Initialize sender and receiver with queues and window size
        Sender sender = new Sender(windowSize, networkQueue, ackQueue);
        Receiver receiver = new Receiver(windowSize, networkQueue, ackQueue);

        // Start the sender and receiver as separate threads
        new Thread(sender).start();
        new Thread(receiver).start();

        // Simulate sending packets
        for (int i = 0; i < 10; i++) { // Send 10 packets in total
            sender.sendPacket(i, "Data" + i); // Send each packet with sequence number and data
            Thread.sleep(1000); // Delay between sending each packet
        }
    }
}