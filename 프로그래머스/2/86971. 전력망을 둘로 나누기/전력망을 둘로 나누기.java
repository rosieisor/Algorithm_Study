import java.util.*;

class Solution {
    static List<List> tree;
    static boolean[] visited;
    
    public int solution(int n, int[][] wires) {
        tree = new ArrayList<>();
        for(int i=0; i<n; i++) {
            tree.add(new ArrayList<>());
        }
        
        for(int i=0; i<wires.length; i++) {
            tree.get(wires[i][0]-1).add(wires[i][1]-1);
            tree.get(wires[i][1]-1).add(wires[i][0]-1);
        }
        
        int answer = n;
        
        for(int i=0; i<wires.length; i++) {
            visited = new boolean[n];
            
            int v1 = wires[i][0] - 1;
            int v2 = wires[i][1] - 1;
            
            tree.get(v1).remove(Integer.valueOf(v2));
            tree.get(v2).remove(Integer.valueOf(v1));
            
            dfs(0);
            
            answer = Math.min(answer, count(n));
            
            tree.get(v1).add(v2);
            tree.get(v2).add(v1);
        }
        
        return answer;
    }
    
    
    public void dfs(int num) {
        if (visited[num]) {
            return;
        }
        
        visited[num] = true;
        
        List<Integer> nodes = tree.get(num);
        for(int n : nodes) {
            if (!visited[n]) {
                dfs(n);
            }
        }
    }
    
    public int count(int n) {
        int visit = 0;
        for(int i=0; i<visited.length; i++) {
            if (visited[i]) {
                visit++;
            }
        }
        
        int notVisit = n - visit;
        
        return Math.abs(visit - notVisit);
    }
}