import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<String> list = new ArrayList<>();

        for(int i=0; i<N; i++) {
            String str = br.readLine();

            if (!list.contains(str)) {
                list.add(str);
            }
        }

        Collections.sort(list, (o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2);
            } else if (o1.length() > o2.length()) {
               return 1;
            } else {
               return -1;
            }
        });

        for(String s : list) {
            System.out.println(s);
        }
    }
}