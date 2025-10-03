import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        
        String[] str = br.readLine().split(" ");
        
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);

        str = br.readLine().split(" ");

        int sum = 0;
        int[] dp = new int[N];

        for(int i=0; i<str.length; i++) {
            int num = Integer.parseInt(str[i]);
            sum += num;
            dp[i] = sum; 
        }

        for(int i=0; i<M; i++) {
            str = br.readLine().split(" ");

            int start = Integer.parseInt(str[0]) - 1;
            int end = Integer.parseInt(str[1]) - 1;

            if (start == 0) {
                sb.append((dp[end]) + "\n");
            } else {
                sb.append((dp[end] - dp[start - 1]) + "\n");
            }
        }

        System.out.println(sb.toString());
    }
}