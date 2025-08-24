import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");

        int X = Integer.parseInt(split[0]);
        int N = Integer.parseInt(split[1]);
        int[] arr = new int[X];
        
        split = br.readLine().split(" ");
        
        for(int i=0; i<split.length; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }

        int result = 0;
        int temp = 0;
        int count = 0;
        
        for(int i=0; i<arr.length; i++) {
            temp += arr[i];

            if (i >= N - 1) {
                if(temp > result) {
                    result = temp;
                    count = 1;
                } else if (temp == result) {
                    count++;
                }
                temp -= arr[i - N + 1];
            }
        }

        if (result == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(result + "\n" + count);
        }
    }
}