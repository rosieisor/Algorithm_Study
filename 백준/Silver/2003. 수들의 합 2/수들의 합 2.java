import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        
        int N = Integer.parseInt(str[0]);
        long M = Long.parseLong(str[1]);

        int[] arr = new int[N];
        long[] dp = new long[N];

        str = br.readLine().split(" ");
        for(int i=0; i<N; i++) {
            int data = Integer.parseInt(str[i]);
            
            arr[i] = data;
            dp[i] = (i == 0) ? data : dp[i-1] + data;
        }

        int result = 0;
        
        for(int i=0; i<N; i++) {
            if (dp[i] == M) {
                result++;
            }
            
            for(int j=0; j<i; j++) {
                if (dp[i] - dp[j] == M) {
                    result++;
                }
            }
        }

        System.out.println(result);
    }
}