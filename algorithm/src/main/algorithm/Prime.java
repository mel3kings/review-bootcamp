package algorithm;

public class Prime {
    public static void main(String[] args){
        System.out.println(isPrime(25));
    }

    public static boolean isPrime(int number){
        if(number % 2 ==0 || number ==1 ){
            return false;
        }

        for(int i =3; i <= number * number; i+=2){
            if(number % i == 0){
                return false;
            }
        }

        return true;
    }
}
