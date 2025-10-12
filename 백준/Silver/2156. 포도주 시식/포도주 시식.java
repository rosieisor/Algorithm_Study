import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int[] dp = new int[n];
        
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        if (n  == 1) {
            System.out.print(arr[0]);
            return;
        } else if (n == 2) {
            System.out.print(arr[0] + arr[1]);
            return;
        }
        
        dp[0] = arr[0];
        dp[1] = arr[1] + dp[0];
        dp[2] = Math.max(dp[1], Math.max(arr[0] + arr[2], arr[1] + arr[2]));
        
        for(int i=3; i<n; i++) {
            dp[i] = Math.max(dp[i-1], Math.max(dp[i-3] + arr[i-1] + arr[i], dp[i-2] + arr[i]));
        }

        System.out.print(dp[n-1]);
    }
}