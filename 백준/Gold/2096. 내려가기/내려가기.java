import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][3];
        int[][] minDp = new int[N][3];
        int[][] maxDp = new int[N][3];

        for(int i=0; i<N; i++) {
            Arrays.fill(minDp[i], Integer.MAX_VALUE);
        }

        for(int i=0; i<N; i++) {
            String[] split = br.readLine().split(" "); 
            
            for(int j=0; j<split.length; j++) {
                arr[i][j] = Integer.parseInt(split[j]);
                
                if (i == 0) {
                    minDp[i][j] = Integer.parseInt(split[j]);
                    maxDp[i][j] = Integer.parseInt(split[j]);
                }
            }
        }

        for(int i=0; i<N-1; i++) {
            for(int j=0; j<3; j++) {
                minDp[i+1][j] = Math.min(minDp[i+1][j], minDp[i][j] + arr[i+1][j]);
                maxDp[i+1][j] = Math.max(maxDp[i+1][j], maxDp[i][j] + arr[i+1][j]);
                
                if (j == 0) {
                    minDp[i+1][j+1] = Math.min(minDp[i+1][j+1], minDp[i][j] + arr[i+1][j+1]);

                    maxDp[i+1][j+1] = Math.max(maxDp[i+1][j+1], maxDp[i][j] + arr[i+1][j+1]);
                } else if (j == 1) {
                    minDp[i+1][j+1] = Math.min(minDp[i+1][j+1], minDp[i][j] + arr[i+1][j+1]);
                    minDp[i+1][j-1] = Math.min(minDp[i+1][j-1], minDp[i][j] + arr[i+1][j-1]);

                    maxDp[i+1][j+1] = Math.max(maxDp[i+1][j+1], maxDp[i][j] + arr[i+1][j+1]);
                    maxDp[i+1][j-1] = Math.max(maxDp[i+1][j-1], maxDp[i][j] + arr[i+1][j-1]);
                } else {
                    minDp[i+1][j-1] = Math.min(minDp[i+1][j-1], minDp[i][j] + arr[i+1][j-1]);
                    
                    maxDp[i+1][j-1] = Math.max(maxDp[i+1][j-1], maxDp[i][j] + arr[i+1][j-1]);
                }
            }
        }

        System.out.print(Math.max(Math.max(maxDp[N-1][0], maxDp[N-1][1]), maxDp[N-1][2]) + " ");
        System.out.print(Math.min(Math.min(minDp[N-1][0], minDp[N-1][1]), minDp[N-1][2]));
    }
}