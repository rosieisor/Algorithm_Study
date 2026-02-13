import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String A = br.readLine();
        String B = br.readLine();
        
        int[][] dp = new int[A.length() + 1][B.length() + 1];

        for(int i=1; i<= A.length(); i++) {
            for(int j=1; j<=B.length(); j++) {
                if (A.charAt(i-1) == B.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        
        int i = A.length();
        int j = B.length();

        while(i >= 1 && j >= 1) {
            if (A.charAt(i-1) == B.charAt(j-1)) {
                sb.append(A.charAt(i-1));
                i--;
                j--;
            } else {
                if (dp[i-1][j-1] == dp[i][j]) {
                    i--;
                    j--;
                } else if(dp[i-1][j] > dp[i][j-1]) {
                    i--;
                } else {
                    j--;
                }
            }
        }
        
        System.out.println(dp[A.length()][B.length()]);

        if (dp[A.length()][B.length()] > 0) {
            String result = sb.toString();

            sb.setLength(0);
            
            for(i=result.length()-1; i>=0; i--) {
                sb.append(result.charAt(i));
            }
            
            System.out.println(sb.toString());
        }
    }
}