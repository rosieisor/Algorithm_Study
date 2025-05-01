class Solution {
    
    static char[] charArray = {'A', 'E', 'I', 'O', 'U'};
    static int count = 0;
    static int answer = 0;
    
    public int solution(String word) {
        
        dfs("", word);
        
        return answer;
    }
    
    public void dfs(String str, String word) {
        
        if (str.length() > 5) {
            return;
        }
        
        if (word.equals(str)) {
            answer = count;
            return;
        }
        
        count++;
        
        for(char c : charArray) {
            dfs(str + c, word);
        }
    }
}