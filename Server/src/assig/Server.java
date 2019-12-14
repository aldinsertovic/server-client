package assig;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {

        try {
            
            ServerSocket ss = new ServerSocket(90);
while(true){
            System.out.println("Pokreni clienta.");
            Socket socket = ss.accept();
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            System.out.println("Klijent odgovara: ");
            System.out.println(br.readLine());
            
            os.write("Unesi operande\r\n".getBytes());

            System.out.println("Operandi su:");
            String operandi = br.readLine();
            System.out.println(operandi);
            int op1 = Integer.parseInt(operandi.split(",")[0]);
            int op2 = Integer.parseInt(operandi.split(",")[1]);
            String rezultat = "";

           
                    
            rezultat = String.valueOf(op1 + op2);
              

            os.write((rezultat + "\r\n").getBytes());}
        } catch (Exception exc) {
            System.out.println(exc);
        }
    }
}
