import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> list = new ArrayList<>();

        int sum = 0;

        for(int i=0; i<5; i++) {
            int data = Integer.parseInt(br.readLine());
            list.add(data);
            sum += data;
        }

        Collections.sort(list, (o1, o2) -> {
            return o1 - o2;
        });

        System.out.println((sum / 5) + "\n" + list.get(2));
    }
}