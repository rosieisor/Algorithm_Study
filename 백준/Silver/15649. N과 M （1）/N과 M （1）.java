import java.util.*;
import java.io.*;

class Main {
    static int N;
    static int M;
    static int[] selected;
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");

        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);

        selected = new int[M];
        visited = new boolean[N+1];

        dfs(0);
    }

    public static void dfs(int pick) {
        if (pick == M) {
            for(int n : selected) {
                System.out.print(n + " ");
            }

            System.out.println();

            return;
        }

        for(int i=1; i<=N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                selected[pick] = i;
                dfs(pick + 1);
                visited[i] = false;
            }
        }
    }
}