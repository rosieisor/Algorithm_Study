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
        int[] arr = new int[N];

        split = br.readLine().split(" ");

        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }

        Arrays.sort(arr);

        backTracking(0, arr);

        System.out.print(sb.toString());
    }

    public static void backTracking(int pick, int[] arr) {
        if (pick == M) {
            for(int i=0; i<selected.length; i++) {
                sb.append(arr[selected[i]] + " ");
            }

            sb.append("\n");
            
            return;
        }

        for(int i=0; i<N; i++) {
            selected[pick] = i;
            backTracking(pick + 1, arr);
        }
    }
}