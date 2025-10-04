import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringBuilder sb = new StringBuilder();

        String S = br.readLine();

        int q = Integer.parseInt(br.readLine());

        Map<Character, int[]> map = new HashMap<>();

        for(int i=0; i<26; i++) {
            map.put((char)('a' + i), new int[S.length()]);
        }

        for(int i=0; i<26; i++) {
            int sum = 0;
            int[] arr = map.get((char)('a' + i));
            
            for(int j=0; j<S.length(); j++) {
                if (S.charAt(j) == (char)('a' + i)) {
                    sum += 1;    
                }
                arr[j] = sum;
            }
        }

        for(int i=0; i<q; i++) {
            String[] str = br.readLine().split(" ");

            char a = str[0].charAt(0);
            int start = Integer.parseInt(str[1]);
            int end = Integer.parseInt(str[2]);

            int[] arr = map.get(a);

            if (start > 0) {
                sb.append(arr[end] - arr[start-1]);
            } else {
                sb.append(arr[end]);
            }
            
            sb.append("\n");
        }
        
        System.out.println(sb.toString());
    }
}