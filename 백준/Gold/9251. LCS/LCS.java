import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        String str2 = br.readLine();

        int max = Integer.MIN_VALUE;
        
        int[][] dp = new int[str2.length() + 1][str1.length() + 1];

        for(int i=1; i<=str2.length(); i++) {
            for(int j=1; j<=str1.length(); j++) {
                if (str2.charAt(i-1) == str1.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }

                max = Math.max(max, dp[i][j]);
            }
        }

        System.out.print(max);
    }
}