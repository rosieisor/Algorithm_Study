import java.util.*;
import java.io.*;

class Main {
    static int N;
    static boolean[] visited;
    static int result = 0;
    static List<List<Integer>> graph;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        
        N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);

        graph = new ArrayList<>();

        // 친구 관계 초기화
        for(int i=0; i<N; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++) {
            str = br.readLine().split(" ");
            
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);

            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        for(int i=0; i<N; i++) {
            visited = new boolean[N];
            
            dfs(i, 0);

            if (result == 1) {
                break;
            }
        }

        System.out.print(result);
    }

    private static void dfs(int start, int count) {
        if (count == 4) {
            result = 1;
            return;
        }
        
        visited[start] = true;

        for(int node : graph.get(start)) {
            if (!visited[node]) {
                dfs(node, count + 1);
            }
        }

        visited[start] = false;
    }
}