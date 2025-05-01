import java.util.*;

class Solution {
    
    static char[] strArray = {'A', 'E', 'I', 'O', 'U'};
    static char[] selected;
    static List<String> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    
    public int solution(String word) {
        
        for(int j=1; j<=strArray.length; j++) {
            selected = new char[j];
            backTracking(0, j, word);
        }
        
        Collections.sort(list);
        
        return list.indexOf(word) + 1;
    }
    
    public void backTracking(int pick, int count, String word) {
        if (pick == count) {
            sb.setLength(0);
            
            for(char c : selected) {
                sb.append(c);
            }
            
            list.add(sb.toString());
            
            return;
        }
        
        for(int i=0; i<strArray.length; i++) {
            selected[pick] = strArray[i];
            backTracking(pick + 1, count, word);
        }
    }
}