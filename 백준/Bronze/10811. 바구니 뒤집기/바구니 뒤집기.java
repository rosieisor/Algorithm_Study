import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException{ 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        
        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);

        int[] arr = new int[N];

        for(int i=0; i<N; i++) {
            arr[i] = i;
        }

        for(int i=0; i<M; i++) {
            split = br.readLine().split(" ");

            int x = Integer.parseInt(split[0])-1;
            int y = Integer.parseInt(split[1])-1;

            int[] temp = new int[y - x + 1];
            int index = 0;
            for(int j=y; j>x-1; j--) {
                temp[index++] = arr[j];
            }

            index = 0;
            for(int j=x; j<=y; j++) {
                arr[j] = temp[index++];
            }
        }

        for(int i=0; i<N; i++) {
            System.out.print((arr[i] + 1) + " ");
        }
        
    }
}