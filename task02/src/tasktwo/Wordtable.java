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
        return "Wordtable[" + nextWordTable + "] Total:" + Integer.toString(this.totalNextWords()) + "\n";
    }

    public int totalNextWords(){
        int total = 0;
        for (var entry : nextWordTable.entrySet()) {
            total += entry.getValue();
        }
        return total;
    }

    
}
//end of class
//thisWord=" + thisWord + ", nextWordTable=" +