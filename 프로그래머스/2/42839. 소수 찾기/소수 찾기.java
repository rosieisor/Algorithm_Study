import java.util.*;

class Solution {
    
    static boolean[] visited;
    static Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
       
        
        for(int i=1; i<=numbers.length(); i++) {
            visited = new boolean[numbers.length()];
            dfs(0, i, "", numbers.split(""));
        }
            
        return set.size();
    }
    
    static void dfs(int count, int length, String str, String[] numbers) {
        
        if (count == length) {
            int num = Integer.parseInt(str);
            isOdd(num);
            return;
        }
        
        for(int i=0; i<numbers.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(count + 1, length, str + numbers[i], numbers);
                visited[i] = false;
            }
        }
        
    }
    
    static void isOdd(int num) {
        
        boolean even = false;
                
        if (num <= 2) {
            if (num != 2)
                even = true;
        } else {
            for(int i=2; i < num; i++) 
                if(num % i == 0) {
                    even = true;
                    break;
                }
        }
            
        if (even ==  false && num > 1) 
            set.add(num);
    }
}