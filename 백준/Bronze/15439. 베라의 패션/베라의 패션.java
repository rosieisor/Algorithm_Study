import java.util.*;
import java.io.*;

class Main {
    static int result = 0;
    static int[] selected;
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        selected = new int[2];
        visited = new boolean[N];

        backtracking(0, N);

        System.out.println(result);        
    }

    public static void backtracking(int pick, int size) {
        if (pick == 2) {
            if (selected[0] != selected[1]) {
                result++;
            }
            
            return;
        }

        for(int i=0; i<size; i++) {
            if (!visited[i]) {
                visited[i] = true;
                selected[pick] = i;
                backtracking(pick + 1, size);
                visited[i] = false;
            }
        }
    }
}