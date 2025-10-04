import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] str = br.readLine().split(" ");
        
        int N = Integer.parseInt(str[0]);
        int K = Integer.parseInt(str[1]);

        str = br.readLine().split(" ");

        int[] arr = new int[N];
        
        int max = Integer.MIN_VALUE;
        arr[0] = Integer.parseInt(str[0]);

        for(int i=1; i<N; i++) {
            arr[i] = arr[i-1] + Integer.parseInt(str[i]);
        }

        for(int i=K-1; i<N; i++) {
            if (i < K) {
                max = Math.max(max, arr[i]);
            } else {
                max = Math.max(max, arr[i] - arr[i-K]);
            }
        }

        System.out.println(max);
    }
}