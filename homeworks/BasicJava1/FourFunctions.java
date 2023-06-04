class FourFunctions{
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

    
    public static void main(String args[]){
        System.out.print("Hello World! ");
    }
}