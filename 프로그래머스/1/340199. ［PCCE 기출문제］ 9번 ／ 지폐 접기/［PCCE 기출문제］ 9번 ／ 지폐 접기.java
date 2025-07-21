// 1. 접을 때 항상 길이가 긴 쪽을 반으로 접기
// 2. 접기 전 길이가 홀수라면 접은 후 소수점 이하는 버리기


class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        
        // bill의 작은 값이 wallet의 작은 값 보다 크거나 bill의 큰 값이 wallet의 큰 값 보다 큰 동안 아래 과정을 반복
        
        int minWallet = (wallet[0] > wallet[1] ? wallet[1] : wallet[0]);
        int maxWallet = (wallet[1] > wallet[0] ? wallet[1] : wallet[0]);
        
        int minBill = (bill[0] > bill[1] ? bill[1] : bill[0]);
        int maxBill = (bill[1] > bill[0] ? bill[1] : bill[0]);
        
        while(minBill > minWallet || maxBill > maxWallet) {
            if (bill[0] > bill[1]) {
                bill[0] /= 2;
            } else {
                bill[1] /= 2;
            }
            
            answer++;
            
            minBill = (bill[0] > bill[1] ? bill[1] : bill[0]);
            maxBill = (bill[1] > bill[0] ? bill[1] : bill[0]);
        }
        
        return answer;
    }
}