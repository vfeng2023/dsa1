import java.util.Scanner;
class MinMax {
    public static int secondMax(int[] numbers ){
        int prevMax = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i=0; i < numbers.length; i++){
            if(numbers[i] > max){
                prevMax = max;
                max = numbers[i];
            }
        }
        return prevMax;
    }

    public static int secondMin(int[] numbers ){
        int prevMin = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i=0; i < numbers.length; i++){
            if(numbers[i] < min){
                prevMin = min;
                min = numbers[i];
            }
        }
        return prevMin;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int arr[] = new int[size];
        for(int i=0; i < arr.length; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(secondMax(arr));
        System.out.println(secondMin(arr));
    }
}
