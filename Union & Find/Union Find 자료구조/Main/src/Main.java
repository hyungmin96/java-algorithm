public class Main {
    public static void main(String[] args) throws Exception {
        
        int arr[] = new int[9];
        for(int i = 1; i < arr.length; i ++)
            arr[i] = i;

            unionParent(arr, 1, 2); // 최초의 정점들의 상태에서 1번 정점과 2번 정점을 연결
            unionParent(arr, 2, 3); // 위와 같다.
            unionParent(arr, 3, 4);
            unionParent(arr, 5, 6);
            unionParent(arr, 6, 7);
            unionParent(arr, 7, 8);
            unionParent(arr, 1, 7);
            System.out.println(findParent(arr, 1, 3));

    }

    public static void unionParent(int[] arr, int a, int b){
        if(a < b) 
            arr[b] = a;
        else
            arr[a] = b;
    }

    public static int getParent(int[] arr, int a){
        if(a == arr[a]) return a;
        return getParent(arr, arr[a]);
    }

    public static int findParent(int[] arr, int a, int b){
        if(getParent(arr, a) != getParent(arr, b))
            return 0;
        else
            return 1;
    }

}
