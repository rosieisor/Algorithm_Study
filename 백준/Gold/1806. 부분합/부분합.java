import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        
        int N = Integer.parseInt(str[0]);
        long M = Long.parseLong(str[1]);
        
        long[] dp = new long[N];

        str = br.readLine().split(" ");
        
        for(int i=0; i<N; i++) {
            int data = Integer.parseInt(str[i]);
            
            dp[i] = (i == 0) ? data : dp[i-1] + data;
        }
        
        int result = 0;
        
        int left = 0;
        int right = 0;

        while(right < N && dp[right] < M) {
            right++;
        }

        if (right >= N) {
            System.out.println(0);
            return;
        }

        if (right == 0) {
            System.out.println(1);
            return;
        }

        result = right + 1;

        while(left < right && right < N) {
            while (dp[right] - dp[left] >= M) {
                result = Math.min(right - left, result);
                left++;
            }
            
            right++;
        }
        
        System.out.println(result);
    }
}