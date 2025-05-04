class Solution {
    
    static int temp;
    static int answer;
    static boolean[] visited;
    
    public int solution(String begin, String target, String[] words) {
        
        boolean exist = false;
        
        for(int i=0; i<words.length; i++) {
            if (words[i].equals(target)) {
                exist = true;
            }
        }
        
        if (!exist) {
            return 0;
        }
        
        temp = 0;
        answer = words.length;
        
        visited = new boolean[words.length];
        
        dfs(begin, target, words);
        
        return answer;
    }
    
    public void dfs(String begin, String target, String[] words) {
        
        if (begin.equals(target)) {
            answer = Math.min(answer, temp);
            return;
        }
        
        for(int i=0; i<words.length; i++) {
            if (!visited[i] && compare(begin, words[i])) {
                visited[i] = true;
                temp++;
                dfs(words[i], target, words);
                visited[i] = false;
                temp--;
            }
        }
        
        
    }
    
    public boolean compare(String str1, String str2) {
        int result = 0;
        
        for(int i=0; i<str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                result++;
            }
        }
        
        if (result > 1) {
            return false;
        } else {
            return true;
        }
    }
}