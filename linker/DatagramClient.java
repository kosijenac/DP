package linker;

import java.io.*;
import java.net.*;

public class DatagramClient {
    public static void main(String[] args) {
        String hostname;
        int port = 2018;
        int len = 1024;
        DatagramPacket sPacket, rPacket;
        if (args.length > 0)
            hostname = args[0];
        else
            hostname = "localhost";
        try (DatagramSocket datasocket = new DatagramSocket()) {
            InetAddress ia = InetAddress.getByName(hostname);
            BufferedReader stdinp = new BufferedReader(
                    new InputStreamReader(System.in));
            while (true) {
                try {
                    String echoline = stdinp.readLine();
                    if (echoline.equals("done"))
                        break;
                    byte[] buffer = new byte[echoline.length()];
                    buffer = echoline.getBytes();
                    sPacket = new DatagramPacket(buffer,
                            buffer.length, ia, port);
                    datasocket.send(sPacket);
                    byte[] rbuffer = new byte[len];
                    rPacket = new DatagramPacket(rbuffer,
                            rbuffer.length);
                    datasocket.receive(rPacket);
                    String retstring = new String(rPacket.getData(), 0,
                            rPacket.getLength());
                    System.out.println(retstring);
                } catch (IOException e) {
                    System.err.println(e);
                }
            }
        } catch (UnknownHostException e) {
            System.err.println(e);
        } catch (SocketException se) {
            System.err.println(se);
        }
    }
}
