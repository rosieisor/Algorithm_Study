import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        
        String[] strArray = new String[numbers.length];
        
        int index = 0;
        for(int number : numbers) {
            strArray[index++] = String.valueOf(number);
        }
        
        Arrays.sort(strArray, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        
        if (strArray[0].equals("0")) {
            return "0";
        }
        
        for(String s : strArray) {
            sb.append(s);
        }
        
        return sb.toString();
    }
}