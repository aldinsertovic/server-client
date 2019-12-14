package client;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args)   {
       try{ 
           while(true){
                   Socket socket = new Socket("localhost", 90);
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        os.write("Cekanje korisnika da unese brojeve\r\n".getBytes());
       
        System.out.println(br.readLine());
        Scanner scan = new Scanner(System.in);
       
        System.out.println("Prvi operand:");
        String op1 = scan.nextLine();
        System.out.println("Drugi operand:");
        String op2 = scan.nextLine();
        String poruka = (op1.trim() + "," + op2.trim()) + "\r\n";
        os.write(poruka.getBytes());
        System.out.println("rezultat je:");
        System.out.println(br.readLine());}
       }catch(Exception exc){
           System.out.println("Pokusajte sa operacijom sabiranja." + exc.getMessage());
       }
    }

}
