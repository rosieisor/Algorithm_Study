import java.util.*;

class Solution {
    // 오른쪽 아래 왼쪽 위
    static int[][] move = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    static int[][] count;
    static boolean[][] visited;
    
    public int solution(int[][] maps) {
        int answer = 0;
        
        count = new int[maps.length][maps[0].length];
        count[0][0] = 1;
        
        visited = new boolean[maps.length][maps[0].length];
        
        bfs(0, 0, maps);    
        
        if (count[maps.length-1][maps[0].length-1] == 0) {
            return -1;
        } else {
            return count[maps.length-1][maps[0].length-1];
        }
    }
    
    void bfs(int x, int y, int[][] maps) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            
            for(int i=0; i<move.length; i++) {
                int dx = current[0] + move[i][0];
                int dy = current[1] + move[i][1];
                
                if (dx < maps.length && dy < maps[0].length &&
                        dx > -1 && dy > -1 && maps[dx][dy] == 1 && !visited[dx][dy]) {
                    count[dx][dy] = (count[dx][dy] == 0) ? count[current[0]][current[1]] + 1 
                        : Math.min(count[current[0]][current[1]] + 1, count[dx][dy]);
                    queue.offer(new int[]{dx, dy});
                    
                    visited[dx][dy] = true;
                }
            }
        }
    }
}