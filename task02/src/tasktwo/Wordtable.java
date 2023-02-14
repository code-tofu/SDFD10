package tasktwo;

import java.util.HashMap;
import java.util.Map;

public class Wordtable {
    
    String thisWord;
    Map<String,Integer> nextWordTable = new HashMap<>();  

    public Wordtable(String word) {
        this.thisWord = word;
    }

    public void putNextWord(String nextWord){
        if(!this.nextWordTable.containsKey(nextWord)){
            this.nextWordTable.put(nextWord, 1);
        } else {
            this.nextWordTable.put(nextWord, nextWordTable.get(nextWord) + 1); 
        }
    }

    @Override
    public String toString() {
        return this.nextWordTable + "TOTAL:" + Integer.toString(this.gettotalNextWords()) + "\n" ;
    }

    public int gettotalNextWords(){
        int total = 0;
        for (String key : this.nextWordTable.keySet()) {
            total += this.nextWordTable.get(key);
        }
        return total;
    }

    public Map<String, Integer> getNextWordTable() {
        return nextWordTable;
    }

    
}
//end of class
//thisWord=" + thisWord + ", nextWordTable=" +