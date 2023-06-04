import java.util.Scanner;

class Power {
    public static long power(int base , int exp){
        long answer = 1;
        for(int i=0; i < exp; i++){
            answer *= base;
        }
        return answer;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int base = sc.nextInt();
        int exp = sc.nextInt();

        System.out.println(power(base, exp));
    }   
}
