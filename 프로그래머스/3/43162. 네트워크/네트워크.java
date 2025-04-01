import java.util.*;

class Solution {
    
    static List<List<Integer>> list = new ArrayList<>(); 
    
    public int solution(int n, int[][] computers) {
        
        if (n == 1) {
            return 1;
        }
        
        int answer = 0;
        
        // 그래프 초기화
        for(int i=0; i<n; i++) {
            list.add(new ArrayList<>());
        }
        
        for (int i=0; i<n; i++) {
            for (int j=i + 1; j<n; j++) {
                if (computers[i][j] == 1) {
                    list.get(i).add(j);
                    list.get(j).add(i);
                }
            }
        }
        
        for (int i=0; i<n; i++) {
            for (int j=0; j<list.get(i).size(); j++) {
                System.out.print(list.get(i).get(j));
            }
            System.out.println();
        }
        
        boolean[] visited = new boolean[n];
        
        for(int i=0; i<n; i++) {
            if (!visited[i]) {
                bfs(i, visited);
                answer++;
            }
        }
        
        return answer;
    }
    
    void bfs(int node, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        
        while(!queue.isEmpty()) {
            int current = queue.poll();
            visited[current] = true;
            
            for(int i : list.get(current)) {
                if (!visited[i]) {
                    queue.offer(i);
                }
            }
        }
    }
}