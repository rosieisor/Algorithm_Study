import java.util.*;

class Solution {
    
    static int[] board;
    static List<List<Integer>> graph;
    static boolean[] visited;
    static int max;
    
    public int solution(int n, int[][] edge) {
        max = 0;
        board = new int[n+1];
        visited = new boolean[n+1];
        graph = new ArrayList<>(); 
        
        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int i=0; i<edge.length; i++) {
            graph.get(edge[i][0]).add(edge[i][1]);
            graph.get(edge[i][1]).add(edge[i][0]);
        }
        
        bfs(1);
        
        int answer = 0;
        for(int num : board) {
            if (max == num) {
                answer++;
            }
        }
        
        return answer;
    }
    
    public void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        
        while(!q.isEmpty()) {
            int current = q.poll();
            
            List<Integer> node = graph.get(current);
            
            for(int num : node) {
                if (!visited[num]) {
                    q.offer(num);
                    visited[num] = true;
                    
                    board[num] = (board[num] == 0) ? 
                        board[current] + 1 : Math.min(board[current] +1, board[num]);
                    
                    max = Math.max(max, board[num]);
                }
            }
        }
    }
}