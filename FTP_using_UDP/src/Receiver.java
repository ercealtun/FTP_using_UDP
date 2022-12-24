import java.io.FileOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

class Receiver {
    static public void main(String[] args) {
        DatagramSocket socket;
        try {
            socket = new DatagramSocket(1234);
            byte[] buffer = new byte[4096];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            FileOutputStream fileOutputStream = new FileOutputStream("received_file.txt");
            while(true){
                socket.receive(packet);
                fileOutputStream.write(packet.getData(), 0, packet.getLength());
                if (packet.getLength() < 4096) { break; }
            }
            fileOutputStream.close();
            socket.close();
            System.out.println("File is successfully received");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}