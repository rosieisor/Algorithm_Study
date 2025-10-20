import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);

        int[][] arr = new int[N][M];

        for(int i=0; i<N; i++) {
            str = br.readLine().split(" ");

            for(int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(str[j]);
            }
        }

        for(int i=0; i<N; i++) {
            str = br.readLine().split(" ");

            for(int j=0; j<M; j++) {
                arr[i][j] += Integer.parseInt(str[j]);
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}