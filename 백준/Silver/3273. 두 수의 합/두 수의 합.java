import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];

        String[] split = br.readLine().split(" ");
        for(int i=0; i<n; i++) {
            a[i] = Integer.parseInt(split[i]);
        }

        int x = Integer.parseInt(br.readLine());

        Arrays.sort(a);

        int left = 0;
        int right = a.length - 1;

        int result = 0;

        while(left < right) {
            int sum = a[left] + a[right];
            if (sum == x) {
                left++;
                right--;
                result++;
            } else if (sum > x) {
                right--;
            } else {
                left++;
            }
        }

        System.out.println(result);
    }
}