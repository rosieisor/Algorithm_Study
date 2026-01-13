import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);
        
        int[][] arr = new int[N][N];
        int[][] copyArr = new int[N][N];

        for(int i=0; i<N; i++) {
            str = br.readLine().split(" ");

            for(int j=0; j<str.length; j++) {
                arr[i][j] = Integer.parseInt(str[j]);

                if(j == 0) {
                    copyArr[i][j] = arr[i][j];
                } else {
                    copyArr[i][j] = arr[i][j] + copyArr[i][j-1];
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<M; i++) {
            str = br.readLine().split(" ");

            int sum = 0;

            int x1 =  Integer.parseInt(str[0]) - 1;
            int y1 =  Integer.parseInt(str[1]) - 1;
            int x2 =  Integer.parseInt(str[2]) - 1;
            int y2 =  Integer.parseInt(str[3]) - 1;

            for(int j=x1; j<=x2; j++) {
                sum += copyArr[j][y2];
                
                if (y1 > 0) {
                    sum -= copyArr[j][y1 - 1];
                }
            }

            sb.append(sum + "\n");
        }

        System.out.println(sb.toString());
    }
}