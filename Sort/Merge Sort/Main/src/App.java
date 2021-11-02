
import java.io.*;
import java.util.StringTokenizer;
public class App {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // StringTokenizer stz = new StringTokenizer(br.readLine(), " ");
        // int[] arr = new int[stz.countTokens()];
        // int index = 0;
        // while(stz.hasMoreTokens()){
        //     arr[index++] = Integer.parseInt(stz.nextToken());
        // }

        int[] arr = new int[]{ 2, 1, 5, 4, 6, 3, 9, 8};

        solution(0, arr.length - 1, arr);
        for(int item : arr) System.out.print(item + " ");
    }

    public static void solution(int left, int right, int[] arr){
        
        int mid = (right + left) / 2;

        if(left >= right){
            return;
        }else{
            solution(left, mid, arr);
            solution(mid + 1, right, arr);
            merge(left, mid, right, arr);
        }
    }

    public static void merge(int left, int mid, int right, int[] arr){
        
        int p = left;
        int q = mid + 1;
        int temp = p;
        int[] answer = new int[arr.length];

        while(p <= mid && q <= right){
            if(arr[p] < arr[q]){
                answer[temp++] = arr[p++];
            }else{
                answer[temp++] = arr[q++];
            }
        }

        while(p <= mid){
            answer[temp++] = arr[p++];
        }

        while(q <= right){
            answer[temp++] = arr[q++];
        }

        for (int index = left; index < temp; index++) {
            arr[index] = answer[index];
        }
        
    }
}
