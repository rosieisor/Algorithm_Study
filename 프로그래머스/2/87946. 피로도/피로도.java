class Solution {
    
    static int[] selected;
    static boolean[] visited;
    static int answer = -1;
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        selected = new int[dungeons.length];
        
        dfs(0, k, dungeons);
        
        return answer;
    }
    
    public void dfs(int pick, int k, int[][] dungeons) {
        if (pick == dungeons.length) {
            check(k, dungeons);
            return;
        }
        
        for(int i=0; i<dungeons.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                selected[pick] = i;
                dfs(pick + 1, k, dungeons);
                visited[i] = false;
            }
        }
    }
    
    public void check(int k, int[][] dungeons) {
        int result = 0;
        
        for(int num : selected) {
            if (k >= dungeons[num][0]) {
                result++;
                k -= dungeons[num][1];
            } else {
                break;
            }
        }
        answer = Math.max(answer, result);
    }
}