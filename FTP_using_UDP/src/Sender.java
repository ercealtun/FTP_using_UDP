import java.io.FileInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

class Sender {
    static public void main(String[] args) {
        DatagramSocket socket;
        try {
            socket = new DatagramSocket();
            InetAddress inetAddress = InetAddress.getByName("localhost");
            String fileName = "to_be_send_file.txt";
            FileInputStream fileInputStream = new FileInputStream(fileName);
            byte[] buffer = new byte[4096];
            int bytesRead;
            while((bytesRead = fileInputStream.read(buffer)) != -1){
                DatagramPacket packet = new DatagramPacket(buffer, bytesRead, inetAddress, 1234);
                socket.send(packet);
            }
            fileInputStream.close();
            socket.close();
            System.out.println("File is successfully sent");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}