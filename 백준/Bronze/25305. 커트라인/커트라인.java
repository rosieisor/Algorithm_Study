import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        
        int N = Integer.parseInt(str[0]);
        int k = Integer.parseInt(str[1]);

        int[] x = new int[N];

        str = br.readLine().split(" ");

        for(int i=0; i<N; i++) {
            x[i] = Integer.parseInt(str[i]);
        }

        Arrays.sort(x);

        System.out.println(x[N - k]);
    }
}