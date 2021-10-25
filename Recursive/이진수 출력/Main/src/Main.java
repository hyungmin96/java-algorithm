import java.util.*;
import java.io.*;

public class Main {

    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        solution(n);
        System.out.println(sb.toString());
    }

    public static void solution(int n) {
        if (n == 0) {
            return;
        } else {
            solution(n / 2);
            sb.append(n % 2);
        }
    }
}
