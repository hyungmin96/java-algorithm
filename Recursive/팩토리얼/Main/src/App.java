import java.util.*;
import java.io.*;

public class App {

    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(recursive(n));
    }

    public static int recursive(int n){
        if(n == 0)
            return 1;
        else{
            return n * recursive(n - 1);
        }
    }
}
