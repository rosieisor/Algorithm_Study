class Solution {
    public int solution(int[][] sizes) {
        int heightMax = 0;
        int widthMax = 0;
        
        for(int i=0; i<sizes.length; i++) {
            if (sizes[i][0] < sizes[i][1]) {
                heightMax = Math.max(sizes[i][1], heightMax);
                widthMax = Math.max(sizes[i][0], widthMax);
            } else {
                heightMax = Math.max(sizes[i][0], heightMax);
                widthMax = Math.max(sizes[i][1], widthMax);
            }
        }
        
        return heightMax * widthMax;
    }
}