import java.util.*;
import java.io.*;

class Main {
    static int N;
    static int M;
    static int[] selected;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");

        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);

        selected = new int[M];

        backTracking(0);

        System.out.print(sb.toString());
    }

    public static void backTracking(int pick) {
        if (pick == M) {
            for(int num : selected) {
                sb.append(num + " ");
            }

            sb.append("\n");
            
            return;
        }

        for(int i=1; i<=N; i++) {
            selected[pick] = i;
            backTracking(pick + 1);
        }
    }
}