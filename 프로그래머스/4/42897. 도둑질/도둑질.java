class Solution {
    public int solution(int[] money) {
        int[] dp = new int[money.length];
        int[] dp2 = new int[money.length];
        
        // 첫번째 집부터 방문했을 경우
        dp[0] = money[0];
        dp[1] = money[0];
        
        for(int i=2; i<money.length-1; i++) {
            dp[i] = Math.max(dp[i-2] + money[i], dp[i-1]);
        }
        
        // 1부터 시작했을 때
        dp2[0] = 0;
        dp2[1] = money[1];
        
        for(int i=2; i<money.length; i++) {
            dp2[i] = Math.max(dp2[i-1], dp2[i-2] + money[i]);
        }
        
        return Math.max(dp[money.length - 2], dp2[money.length -1]);
    }
}