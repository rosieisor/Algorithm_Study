import java.util.*;

class Solution {
    public String solution(String s) {
        List<Integer> list = new ArrayList<>();
        
        String[] split = s.split(" ");
        
        for(int i=0; i<split.length; i++) {
            list.add(Integer.parseInt(split[i]));
        }
        
        Collections.sort(list);
            
        StringBuilder sb = new StringBuilder();
        
        sb.append(list.get(0)).append(" ").append(list.get(list.size()-1));
            
        return sb.toString();
    }
}