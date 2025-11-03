import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);

        Map<String, Integer> map = new HashMap<>();

        for(int i=0; i<N; i++){
            map.put(br.readLine(), 1);
        }

        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();

        for(int i=0; i<M; i++) {
            String name = br.readLine();
            if (map.get(name) != null) {
                list.add(name);
            }
        }

        Collections.sort(list);

        sb.append(list.size()+"\n");
        
        for(String s : list) {
            sb.append(s + "\n");
        }

        System.out.print(sb.toString());
    }
}