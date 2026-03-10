import java.util.*;
import java.io.*;

class Main {
    static int[] selected;
    static boolean[] visited;
    static StringBuilder sb;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        sb = new StringBuilder();
        String[] split;
        
        while(true) {
            split = br.readLine().split(" ");
            
            if (split.length == 0 || split[0].equals("0")) {
                break;
            }
            
            int k = Integer.parseInt(split[0]);

            selected = new int[6];
            visited = new boolean[k];
            
            int[] arr = new int[k];
            
            for(int i=1; i<=k; i++) {
                arr[i-1] = Integer.parseInt(split[i]);
            }
            
            backtracking(0, 0, 6, arr);
            sb.append("\n");
        }
        
        System.out.print(sb.toString());       
    }
    
    public static void backtracking(int start, int pick, int count, int[] arr) {
        if (pick == count) {
            for(int i=0; i<selected.length; i++) {
                sb.append(arr[selected[i]]).append(" ");
            }
            
            sb.append("\n");
            return;
        }
        
        for(int i=start; i<arr.length; i++) {
            if (!visited[i]) {
                visited[i]= true;
                selected[pick] = i;
                backtracking(i+1, pick+1, count, arr);
                visited[i]= false;
            }
        }
    }
}