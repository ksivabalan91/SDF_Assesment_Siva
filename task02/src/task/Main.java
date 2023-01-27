package task;

import java.io.Console;

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
