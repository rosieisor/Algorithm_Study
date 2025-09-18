import java.util.*;
import java.io.*;

class Main {
    static int N, M;
    static int[] selected;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");

        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);

        selected = new int[M];

        dfs(0, 1);

        System.out.println(sb.toString());
    }

    public static void dfs(int pick, int start) {
        if (pick == M) {
            for(int num : selected) {
                sb.append(num + " ");
            }

            sb.append("\n");
            
            return;
        }

        for(int i=start; i<=N; i++) {
            selected[pick] = i;
            dfs(pick + 1, i);
        }
    }
}