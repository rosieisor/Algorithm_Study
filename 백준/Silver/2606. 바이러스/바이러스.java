import java.util.*;
import java.io.*;

class Main {

    static int result = 0;
    static int N;
    static int[][] graph;
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        graph = new int[N+1][N+1];

        visited = new boolean[N+1];

        for(int i=0; i<M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            graph[x][y] = 1;
            graph[y][x] = 1;
            // graph[x][y] = graph[y][x] = 1;
        }
        
        dfs(1);

        System.out.println(result);
    }

    public static void dfs(int node) {
        visited[node] = true;  // 방문 처리
        
        for(int i=1; i<=N; i++) {
            if (!visited[i] && graph[node][i] == 1) {
                dfs(i);          
                result++;
            }
        }
    }
}