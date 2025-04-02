class Solution {
    
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        int[][] dp = new int[n][m];
        
        dp[0][0] = 1;
        
        for(int i=0; i<puddles.length; i++) {
            int x = puddles[i][1] - 1;
            int y = puddles[i][0] - 1;
            
            dp[x][y] = -1;
        }
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if ((i == 0 && j == 0) || dp[i][j] == -1) {
                    continue;
                }
                
                // 왼쪽에서 오는 값 그대로 가져오기
                if (i == 0) {
                    if (dp[i][j-1] != -1) {
                        dp[i][j] = dp[i][j-1];
                    }
                    
                // 위에서 오는 값 그대로 가져오기
                } else if (j == 0) {
                    if (dp[i-1][j] != -1) {
                        dp[i][j] = dp[i-1][j];
                    }
                    
                } else {
                    // 왼쪽에 물에 잠긴 지역이 있을 경우
                    if (dp[i][j-1] == -1 && dp[i-1][j] != -1) {
                        dp[i][j] = dp[i-1][j];
                    } 
                    
                    // 위쪽에 물에 잠긴 지역이 있을 경우
                    if (dp[i][j-1] != -1 && dp[i-1][j] == -1) {
                        dp[i][j] = dp[i][j-1];
                    }
                    
                    if (dp[i][j-1] != -1 && dp[i-1][j] != -1) {
                        dp[i][j] = (dp[i][j-1] + dp[i-1][j]) % 1000000007;
                    }
                }
            }
        }
        return dp[n-1][m-1];
    }
}