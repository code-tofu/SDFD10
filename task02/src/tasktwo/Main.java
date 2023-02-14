package tasktwo;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Main{

    public static void main(String[] args) {
        if(args.length == 1){
            String dirname = args[0];
            System.out.println("\nOpening Corpus Directory: " + dirname);
            File dirRepo = new File(dirname);

            ArrayList<File> repoFiles = new ArrayList<>();
            System.out.println("Files for Processing:");
            for(File corpusText : dirRepo.listFiles()){
                System.out.println(corpusText);
                repoFiles.add(corpusText);
            } 
            //System.out.println(repoFiles);

            ArrayList<String> allWords = new ArrayList<>();
            for(File corpusText : repoFiles){
                readCorpus(allWords,corpusText);
            }
            System.out.println(allWords);
            

            Map<Map<String , Integer>,Integer> nextWordDist = new HashMap<>();







        } else {
            System.out.println("Usage: <directory_name>");
            System.exit(1);
        }
    }

    // Input for readCorpus{
    // Assume wouldn't is wouldnt,and is a word unique from would i.e. ignore contractions
    // Assume "strip all punctions from a word", and "-" implies that right-and-three-quarters is one word
    public static String[] punc = new String[]{".",",",":","!","?","-","(",")","{","}","\'","\"","/","’","…","“"};
    public static int puncSize = punc.length;
    // Assume number is not a word
    public static String[] num = new String[]{"1","2","3","4","5","6","7","8","9","0"};
    public static int numSize = num.length;
    //}

    public static void readCorpus(ArrayList<String> allWords,  File f){

        try{
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                line = line.toLowerCase();
                if(line.isEmpty()) continue;
                for(int i = 0; i < puncSize;i++ ){
                    line = line.replace(punc[i], "");
                }
                for(int i = 0; i < numSize;i++){
                    line = line.replace(num[i], "");
                }
                String[] words = line.split("\\s+");
                for(String word : words){
                    allWords.add(word);
                }
            }

            br.close();
            fr.close();
        } catch(IOException IOerr){
            IOerr.printStackTrace();
        }

    }




}
// dirname: C:\Users\ftc_b\GIT\TFIP\SDFD10\day10_sdf_assets-main\sdf_assessment_assets\task02\seuss
//end of class
// C:\\Users\\ftc_b\\GIT\\TFIP\\SDFD10\\day10_sdf_assets-main\\sdf_assessment_assets\\task02\\seuss\\cat_in_the_hat.txt
// "C:\\Users\\ftc_b\\GIT\\TFIP\\SDFD10\\day10_sdf_assets-main\\sdf_assessment_assets\\task02\\seuss\\fox_in_socks.txt";
// "C:\\Users\\ftc_b\\GIT\\TFIP\\SDFD10\\day10_sdf_assets-main\\sdf_assessment_assets\\task02\\seuss\\happy_birthday_to_you.txt";
// "C:\\Users\\ftc_b\\GIT\\TFIP\\SDFD10\\day10_sdf_assets-main\\sdf_assessment_assets\\task02\\seuss\\oh_the_places_youll_go.txt";

//problem strings
// But you…You - becomes you you
//You'll be on y our way up! - spelling error

// code for testing
// Path p = Paths.get(test);
// File testFile = p.toFile();
// readCorpus(allWords,testFile);
// public static final String  test = "C:\\Users\\ftc_b\\GIT\\TFIP\\SDFD10\\day10_sdf_assets-main\\sdf_assessment_assets\\task02\\seuss\\happy_birthday_to_you - Copy.txt";