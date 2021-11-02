import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main {

    static class Student implements Comparable<Student>{

        int height, weight;

        public Student(int height, int weight){
            this.height = height;
            this.weight = weight;
        }

        @Override
        public int compareTo(Main.Student o) {
            if(this.height > o.height){
                return -1;
            }else if(this.weight > o.weight){
                return 1;
            }else if(this.height == o.height && this.weight > o.weight){
                return 1;
            }else if(this.weight == o.weight && this.height > o.height){
                return 1;
            }
            return 1;
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Student[] arr = new Student[n];
        for(int i = 0; i < n; i ++){
            StringTokenizer stz = new StringTokenizer(br.readLine(), " ");
            arr[i] = new Student(Integer.parseInt(stz.nextToken()), Integer.parseInt(stz.nextToken()));
        }

        Arrays.sort(arr);

        System.out.println(solution(arr));
    }

    public static int solution(Student[] arr){
        
        int answer = 1;
        
        for(int i = arr.length - 1; i > 0 ; i --){
            boolean isNonePass = false;
            for(int j = i - 1; j >= 0; j --){
                if(arr[j].weight > arr[i].weight){
                    isNonePass = true;
                    break;
                }
            }
            if(!isNonePass) answer ++;
        }

        return answer;
    }
}
