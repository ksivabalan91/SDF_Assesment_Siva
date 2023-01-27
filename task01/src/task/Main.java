package task;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException{

        List<String> data = new LinkedList<>();
        List<String> wordsList = new LinkedList<>();
        List<Double> wordCount = new LinkedList<>();
        String filename = "cat_in_the_hat.txt";
        Set<String> words = new HashSet<>();
        Map<String,Double> wordCountMap = new HashMap<>();


        if(args.length>0){filename = args[0];}

        // read file and store in string list
        data = readFile(filename);
        // remove duplicates
        for(String i : data){words.add(i);} 
    

        for(String i: words){
            int counter =0;
            for(String j : data){
                if(i.equals(j)){
                    counter++;
                }
            }
            double freq = ((double) counter) / ((double)data.size());
            wordsList.add(i);
            wordCount.add(freq);
            wordCountMap.put(i, freq);
        }    
        System.out.println(wordsList);
        System.out.println(wordCount);

        List<Map.Entry<String,Double>> list = new ArrayList<>(wordCountMap.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Double>>() {
            
        })


        // System.out.println(wordCountMap.toString());
        // System.out.println(words.toString());

        
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

        System.out.println("File read");

        return tempList;        
    }
    
}
