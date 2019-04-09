 

public class Sentence {
    private final static int MAX_NUM_OF_WORDS = 4;
    private String sourceStr;
    private String[] words;
    private int counter;

    public String getSourceStr() {
        return sourceStr;
    }

    public void setSourceStr(String sourceStr) {
        this.sourceStr = sourceStr.trim();
        if(sourceStr==""){
            words=null;
            counter=0;
        } else {
            splitIntoWords();
        }
    }

    public String[] getWords() {
        return words;
    }

    public void setWords(String[] words) {
        this.words = words;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public Sentence(){
        sourceStr="";
        words=null;
        counter=0;
    }
    public Sentence(String str){
        setSourceStr(str);
    }

    public String toString(){
        return sourceStr;
    }

    private void splitIntoWords(){
        words=new String[MAX_NUM_OF_WORDS];
        int start, end;
        counter = 0;
        start=0;
        end = sourceStr.indexOf(" ");
        try {


            while (end > 0) {
                words[counter] = sourceStr.substring(start, end);
                counter++;
                while (sourceStr.charAt(end) == ' ') end++;
                start = end;
                end = sourceStr.indexOf(" ", start);
            }
            words[counter] = sourceStr.substring(start);
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("В предложении слишком много слов, лишнее придется обрезать: \n"+e);
            System.out.println();
            counter--;
        }
        counter++;
    }
    public String[] getWordsByFirstCharacter(char character){
        String[] result = new String[MAX_NUM_OF_WORDS];
        int counter = 0;
        for(int i=0;i<words.length;i++){
            if(words[i].charAt(0)==character){
                result[counter]=words[i];
                counter++;
            }
        }
        return result;
    }
    public String getByFirstLastCharacter(char firstChar, char secondChar){
        StringBuilder result = new StringBuilder();
        for(int i = 0; i<words.length;i++){
            if(words[i].charAt(0) == firstChar && words[i].charAt(words[i].length() - 1) == secondChar){
                result.append(words[i]);
                result.append(" ");

            }
        }
        return result.toString();
    }

}
