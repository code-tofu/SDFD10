package tasktwo;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main{

    // Inputs for readCorpus method !!See README for Assumptions!!{
    public static String[] punc = new String[]{".",",",":","!","?","-","(",")","{","}","\'","\"","/","’","“",";"};
    public static int puncSize = punc.length;
    public static String[] num = new String[]{"1","2","3","4","5","6","7","8","9","0"};
    public static int numSize = num.length;
    //}

    public static void main(String[] args) {
        if(args.length == 1){
            String dirname = args[0];
            System.out.println("\nOpening Corpus Directory: " + dirname);
            File dirRepo = new File(dirname);

            //Populate list of files to be read
            ArrayList<File> repoFiles = new ArrayList<>();
            System.out.println("Files for Processing:");
            for(File corpusText : dirRepo.listFiles()){
                System.out.println(corpusText);
                repoFiles.add(corpusText);
            } 

            //Populate All Words Table from each corpusttext in repo
            Map <String, Wordtable> allWordsTable = new HashMap<>();
            for(File corpusText : repoFiles){
                ArrayList<String> textWords = new ArrayList<>();
                readCorpus(textWords,corpusText);
                int size = textWords.size();
                for(int i = 0 ; i < (size-1) ; i++){
                    if (!allWordsTable.containsKey(textWords.get(i))){
                        Wordtable newWordTable = new Wordtable(textWords.get(i));
                        allWordsTable.put(textWords.get(i),newWordTable);
                        newWordTable.putNextWord(textWords.get(i+1));
                    } else {
                        allWordsTable.get(textWords.get(i)).putNextWord(textWords.get(i+1));
                    }
                }
            }

            //Print out all probabilites
            for (String outerkey : allWordsTable.keySet()) {
                Wordtable innerObj= allWordsTable.get(outerkey);
                System.out.println(outerkey);
                double total = (double)innerObj.gettotalNextWords();
                Map<String,Integer> innerWordTable = innerObj.getNextWordTable();
                for (String innerentry : innerWordTable.keySet()) {
                    System.out.printf("\t %s %.3f\n" 
                    ,innerentry,(innerWordTable.get(innerentry) /total));
                }
            }

        } else {
            System.out.println("Usage: <directory_name>");
            System.exit(1);
        }
    }


    public static void readCorpus(ArrayList<String> textWords,  File f){

        try{
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                line = line.toLowerCase();
                line = line.replace("…"," "); //to remove “…” U+2026 
                if(line.isEmpty()) continue;
                for(int i = 0; i < puncSize;i++ ){
                    line = line.replace(punc[i], "");
                }
                for(int i = 0; i < numSize;i++){
                    line = line.replace(num[i], "");
                }
                String[] words = line.split("\\s+");
                for(String word : words){
                    textWords.add(word);
                }
            }
            br.close();
            fr.close();
        } catch(IOException IOerr){
            IOerr.printStackTrace();
        }

    }

//end of class
}
