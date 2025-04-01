class Solution {
    
    static int answer = 0;
    static int[] selected;
    static boolean[] visited;
    
    public int solution(int[] numbers, int target) {
        for(int i=1; i<numbers.length; i++) {
            selected = new int[i];
            visited = new boolean[numbers.length];
            bfs(0, i, 0, numbers, target);
        }
        return answer;
    }
    
    // 백트래킹
    void bfs(int pick, int count, int start, int[] numbers, int target) {
        if (pick == count) {
            cal(numbers, target);
            return;
        }
        
        for(int i=start; i<numbers.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                selected[pick] = i + 1;
                bfs(pick + 1, count, i + 1, numbers, target);
                visited[i] = false;
            }
        }
    }
    
    void cal(int[] numbers, int target) {
        
        int[] copy = new int[numbers.length];
        for(int i=0; i<numbers.length; i++) {
            copy[i] = numbers[i];
        }
        
        for(int i : selected) {
            copy[i-1] *= -1;
        }
        
        int result = 0;
        for(int i=0; i<copy.length; i++) {
            result += copy[i];
        }
        
        if (result == target) {
            answer++;
        }
        
    }
}
