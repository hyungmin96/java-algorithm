
import java.io.*;

public class App {

    static int n;
    static int[] ch;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        ch = new int[n + 1];
        solution(1);
    }

    public static void solution(int l){
        if(l == n + 1){
            StringBuilder sb = new StringBuilder();
            for(int i = 1; i <= n; i ++)
                if(ch[i] == 1)
                    sb.append(i + " ");
            if(sb.toString().length() > 0) System.out.println(sb.toString());
        }else{
            ch[l] = 1;
            solution(l + 1);
            ch[l] = 0;
            solution(l + 1);
        }
    }

}
