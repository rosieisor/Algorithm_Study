import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{ 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Map<Integer, Integer> map = new HashMap<>();

        String[] arr = br.readLine().split(" ");
        
        for(int i=0; i<N; i++) {
            int data = Integer.parseInt(arr[i]);
            if (map.get(data) == null) {
                map.put(data, 1);
            } else {
                map.put(data, map.get(data) + 1);
            }
        }

        int index = Integer.parseInt(br.readLine());

        if (map.get(index) == null) {
            System.out.print("0");
        } else {
            System.out.print(map.get(index));
        }
    }
}