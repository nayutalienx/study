 

public class StringProcessLib {
    public static int compSubStr(String s, String p){
        if(s.length() < p.length()) throw new RuntimeException();
        int result = 0;
        int start = 0;
        int step = p.length();
        while (start <= s.length() - p.length()){
            if(s.substring(start, start+step).equals(p)){
                result++;
                start++;
            }
            start++;
        }
        return result;
    }
    public static String compareAndCreateStr(String s1, String s2){
        StringBuilder result = new StringBuilder();
        if(s1.compareTo(s2) < 0){
            result.append(s2);
            result.append(" ");
            result.append(s1);
        } else {
            result.append(s1);
            result.append(" ");
            result.append(s2);
        }
        return result.toString();
    }
}
