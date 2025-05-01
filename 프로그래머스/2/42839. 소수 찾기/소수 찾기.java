import java.util.*;

class Solution {
    
    static boolean[] visited;
    static Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        int answer = 0;
        
        visited = new boolean[numbers.length()];
        dfs("", numbers);
        
        for(int n : set) {
            if (!check(n)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    public boolean check(int num) {
        if (num < 2) {
            return true;
        }
        
        for(int i=2; i<num; i++) {
            if (num % i == 0) {
                return true;
            }
        }
        
        return false;
    }
    
    public void dfs(String str, String numbers) {
        
        if (str.length() > numbers.length()) {
            return;
        }
        
        for(int i=0; i<numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                set.add(Integer.parseInt(str + numbers.charAt(i)));
                dfs(str + numbers.charAt(i), numbers);
                visited[i] = false;
            }
        }
    }
}