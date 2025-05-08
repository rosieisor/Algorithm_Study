import java.util.*;
import java.io.*;

class Main {

    static int n, m;
    static int[][] map;
    static int[][] distance;
    static int[][] move = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        init();

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if (map[i][j] == 2) {
                    bfs(i, j);
                }
            }
        }
        
        print();
    }

    public static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{x, y});
        visited[x][y] = true;

        while(!q.isEmpty()) {
            int[] current = q.poll();

            for(int i=0; i<move.length; i++) {
                int mx = move[i][0] + current[0];
                int my = move[i][1] + current[1];

                if (mx > -1 && my > -1 && mx < n && my < m && map[mx][my] == 1 && !visited[mx][my]) {
                    if (distance[mx][my] != 0) {
                        distance[mx][my] = Math.min(distance[mx][my], distance[current[0]][current[1]] + 1);
                    } else {
                        distance[mx][my] = distance[current[0]][current[1]] + 1;
                    }
                    
                    visited[mx][my] = true;
                    q.offer(new int[]{mx, my});
                }
            }   
        }
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");

        n = Integer.parseInt(split[0]);
        m = Integer.parseInt(split[1]);

        map = new int[n][m];
        distance = new int[n][m];
        visited = new boolean[n][m];

        for(int i=0; i<n; i++) {
            split = br.readLine().split(" ");
            for(int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(split[j]);
            }
        }
    }

    public static void print() {
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if (map[i][j] == 2 || map[i][j] == 0) {
                    System.out.print(0 + " ");
                } else if (map[i][j] != 0 && distance[i][j] == 0) {
                    System.out.print(-1 + " ");
                } else {
                    System.out.print(distance[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}