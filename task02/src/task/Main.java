package task;

import java.io.Console;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        Boolean exit = true;
        Console cons = System.console();
        Math operation = new Math();  

        System.out.println("Welcome.");

        while(exit){
            String line = cons.readLine("> ");

            if(line.contentEquals("exit")){
                exit = false;
                System.out.println("Bye bye");
                continue;
            }
            String output = operation.calculate(line);
            System.out.println(output);

        }   
    }
    
}
