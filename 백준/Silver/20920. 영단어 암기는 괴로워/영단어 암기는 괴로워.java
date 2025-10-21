import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");

        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);

        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();

        for(int i=0; i<N; i++) {
            String word = br.readLine();

            if (word.length() < M) {
                continue;
            }

            if (map.get(word) == null) {
                list.add(word);    
            }

            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        Collections.sort(list, (o1, o2) -> {
            if (map.get(o1) < map.get(o2)) {
                return 1;
            } else if (map.get(o1) == map.get(o2)) {
                if (o1.length() < o2.length()) {
                    return 1;
                } else if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                }
            } 
            
            return -1;
        });

        StringBuilder sb = new StringBuilder();
        
        for(String s : list) {
            sb.append(s).append("\n");
        }
        
        System.out.println(sb.toString());
    }
}