import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException{ 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);

        int[] arr = new int[N];

        for(int i=0; i<N; i++) {
            arr[i] = i;
        }

        for(int i=0; i<M; i++) {
            str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]) - 1;
            int b = Integer.parseInt(str[1]) - 1;

            int temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }

        for(int i=0; i<N; i++) {
            System.out.print((arr[i] + 1) + " ");
        }
    }
}