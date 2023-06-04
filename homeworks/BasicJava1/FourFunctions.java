import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

class FourFunctions{
    public static int secondMax(int[] numbers ){
        int prevMax = numbers[0];
        int max = numbers[0];

        for(int i=0; i < numbers.length; i++){
            if(numbers[i] > max){
                //prevMax = max;
                max = numbers[i];
            }
        }
        prevMax = Integer.MIN_VALUE;
        for(int i=0; i < numbers.length; i++){
            if(numbers[i] != max && numbers[i] > prevMax){
                prevMax = numbers[i];
            }
        }
        if(prevMax == Integer.MIN_VALUE){
            prevMax = max;
        }
        return prevMax;
    }

    public static int secondMin(int[] numbers ){
        int prevMin = Integer.MAX_VALUE;
        int min = numbers[0];
        //boolean assigned = false;
        for(int i=0; i < numbers.length; i++){
            if(numbers[i] < min){
                //prevMin = min;
                min = numbers[i];
            }
        }

        for(int i=0; i < numbers.length; i++){
            if(numbers[i]!=min && numbers[i] < prevMin){
                prevMin = numbers[i];
            }
        }
        if(prevMin == Integer.MAX_VALUE){
            prevMin = min;
        }
        return prevMin;
    }
    /**
     * Accepts an array of integers as a parameter, and returns the average of the numbers as a double.
     * @param arr
     * @return
     */
    public static double average(int [] arr){
        double sum = 0;
        for(int i=0; i < arr.length; i++){
            sum += arr[i];
        }
        return sum/arr.length;
    }

    public static double median(int[] arr){
        // int mincount = 0;
        // int maxcount = 0;
        // int max2 = secondMax(arr);
        // int min2 = secondMin(arr);
        // for(int n:arr){
        //     if( n < max2 && n > min2){
        //         return n;
            
        //     }else if(n==min2){
        //         mincount += 1;
        //     }else if(n==max2){
        //         maxcount += 1;
        //     }
        // }
        // if(mincount >= maxcount){
        //     return min2;
        // }
        // else{
        //     return max2;
        // }
        Arrays.sort(arr);
        return arr[2];
        //return min2 ;
    }

    public static int mode(int[] arr){
        HashMap<Integer, Integer> freMap = new HashMap<>();
        for(int i=0; i < arr.length; i++){
            int key = arr[i];
            if(freMap.containsKey(arr[i])){
                freMap.put(key, freMap.get(key)+1);
            }else{
                freMap.put(key, 1);
            }
        }
        //return 0;
        int maxval = arr[0];
        for(Integer k: freMap.keySet()){
            if(freMap.get(k) > freMap.get(maxval)){
                maxval = k;
            }
        }
        return maxval;

        

    }
    public static double stddev(int[] arr){
        double mean = average(arr);
        double sum = 0;
        for(int n:arr){
            sum += (n-mean) * (n-mean);
        }

        return Math.sqrt(sum/(arr.length-1));
    }
    public static void main(String args[]){
        //System.out.print("Hello World! ");

        // int arr[] = new int[5];
        // for(int i=0; i < 5; i++){
        //     arr[i] = (int)(Math.random()*40 - 20);
        //     System.out.print(arr[i] + " ");
        // }
        // System.out.println();
        // System.out.print()

        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        int arr[] = new int[5];
        for(int i=0; i < 5; i++){
            arr[i] = sc.nextInt();
        }
        if(choice == 1){
            System.out.printf("%.2f\n", average(arr));
        }else if(choice == 2){
            System.out.printf("%.2f\n", median(arr));
        }else if(choice == 3){
            System.out.printf("%.2f\n", stddev(arr));
        }else{
            System.out.println(mode(arr));
        }
        sc.close();
    }
}