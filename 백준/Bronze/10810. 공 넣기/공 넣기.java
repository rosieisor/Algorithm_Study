import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException{ 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        
        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);

        int[] arr = new int[N+1];

        for(int i=0; i<M; i++) {
            split = br.readLine().split(" ");

            int start = Integer.parseInt(split[0]);
            int end = Integer.parseInt(split[1]);
            int k = Integer.parseInt(split[2]);

            for(int j=start; j<=end; j++) {
                arr[j] = k;
            }
        }

        for(int i=1; i<=N; i++) {
            System.out.print(arr[i] + " ");
        }
        
    }
}