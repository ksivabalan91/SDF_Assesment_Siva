package task;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException{

        List<String> data = new LinkedList<>();
        String filename = "cat_in_the_hat.txt";
        Set<String> wordSet = new HashSet<>();
        List<Words> words = new ArrayList<>();

        if(args.length>0){filename = args[0];}

        // read file and store in string list
        data = readFile(filename);
        // remove duplicates
        for(String i : data){wordSet.add(i);} 

        for(String i: wordSet){
            int counter =0;
            for(String j : data){
                if(i.equals(j)){
                    counter++;
                }
            }
            double freq = ((double) counter) / ((double)data.size());
            Words key = new Words(i, freq);
            words.add(key);
        }    

        words.sort(Comparator.comparing(e->e.getFreq()));

        for(int i=0,j=words.size(); i<10;i++,j--){
            System.out.printf("%d. "+words.get(j-1).getKey()+"\t %.4f\n",i+1,words.get(j-1).getFreq());
        }
        
    }

    public static List<String> readFile(String readFile) throws IOException{
        List<String> tempList = new LinkedList<String>();

        FileReader fr = new FileReader(readFile);
        BufferedReader br = new BufferedReader(fr);
        String line = "";
        Boolean exit = true;
        

        while((line=br.readLine())!=null){
            String lineArr[];
            line = line.replace(".", " ");
            line = line.replace(",", " ");
            line = line.replace(":", " ");
            line = line.replace(";", " ");
            line = line.replace("!", " ");
            line = line.replace("?", " ");
            line = line.replace("-", " ");
            line = line.replace("(", " ");
            line = line.replace(")", " ");
            line = line.replace("{", " ");
            line = line.replace("}", " ");
            line = line.replace("'", " ");
            line = line.replace("\"", " ");
            lineArr = line.split(" ",0);

            for(String i: lineArr){
                if(!i.equals("")){
                    tempList.add(i.toLowerCase().trim());                
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
        // System.out.println("File read");
        return tempList;        
    }
    
}
