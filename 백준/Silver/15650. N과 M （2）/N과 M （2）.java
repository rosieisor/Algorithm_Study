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

        backTracking(0, 1);
    }

    public static void backTracking(int pick, int start) {
        if (pick == M) {
            for(int num : selected) {
                System.out.print(num + " ");
            }

            System.out.println();
            
            return;
        }

        for(int i=start; i<=N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                selected[pick] = i;
                backTracking(pick + 1, i);
                visited[i] = false;
            }
        }
    }
}