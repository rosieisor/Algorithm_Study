import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<Character, Integer> map = new HashMap<>();
        
        String split = br.readLine().toLowerCase();

        int max = 0;
        for(int i=0; i<split.length(); i++) {
            if (map.get(split.charAt(i)) == null) {
                map.put(split.charAt(i), 1);
            } else {
                map.put(split.charAt(i), map.get(split.charAt(i)) + 1);
            }
            max = Math.max(map.get(split.charAt(i)), max);
        }

        int count = 0;
        String maxKey = "";
        for(char key : map.keySet()) {
            if (map.get(key) == max) {
                count++;
                maxKey = String.valueOf(key);
            }
        }

        
        
        System.out.println((count > 1) ? "?" : maxKey.toUpperCase());
    }
}