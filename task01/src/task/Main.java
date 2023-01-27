package task;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException{

        List<String> data = new LinkedList<>();
        String filename = "cat_in_the_hat.txt";

        if(args.length>0){filename = args[0];}

        data = readFile(filename);

        for(String i : data){
            
        }
        System.out.println(data.toString());

        
    }

    public static List<String> readFile(String readFile) throws IOException{
        List<String> tempList = new LinkedList<String>();

        FileReader fr = new FileReader(readFile);
        BufferedReader br = new BufferedReader(fr);
        String line = "";
        Boolean exit = true;
        

        while((line=br.readLine())!=null){
            String lineArr[];
            // line = line.replace("\uFEFF", "");
            line = line.replace("?", " ");
            line = line.replace(".", " ");
            line = line.replace(",", " ");
            line = line.replace("'", " ");
            line = line.replace("!", " ");
            line = line.replace(";", " ");
            line = line.replace("-", " ");
            lineArr = line.split(" ",0);

            for(String i: lineArr){
                if(!i.equals("")){
                    tempList.add(i.trim());                
                }
            }            
        }
        while(exit){
           exit = tempList.remove(" ");
        }
        exit=true;
        while(exit){
           exit = tempList.remove("");
        }

        br.close();
        fr.close();

        System.out.println("File read");

        return tempList;        
    }
    
}
