
import java.util.Random;

public class App {

    public static int randomPrimeGenerator() {
        int num = 0;
        Random rand = new Random(); 
        num = rand.nextInt(100) + 1;

        while (!isPrime(num)) {          
            num = rand.nextInt(1000) + 1;
        }
        return num; 
    }

    
    private static boolean isPrime(int inputNum){
        if (inputNum <= 3 || inputNum % 2 == 0) 
            return inputNum == 2 || inputNum == 3; //this returns false if number is <=1 & true if number = 2 or 3
        int divisor = 3;
        while ((divisor <= Math.sqrt(inputNum)) && (inputNum % divisor != 0)) 
            divisor += 2; //iterates through all possible divisors
        return inputNum % divisor != 0; //returns true/false
    }
    
    private static double getGcd(double n1, double n2){
        
        double gcd = 1;

        for (int i = 1; i <= n1 && i <= n2; ++i) {

        // check if i perfectly divides both n1 and n2
        if (n1 % i == 0 && n2 % i == 0)
        {
            gcd = i;
        }
            
        }

        return gcd;
    }
    
    private static String encrypt(String message,double p, double q, double n,double e){
        
        
        String e_message = "";
        
        for(int i=0;i<message.length();i++){
            char c = message.charAt(i);
            double ec = Math.pow((double)c,e);
            ec = ec%n;
            e_message += (char)ec;
        }
        
        return e_message;
    }
    private static String decrypt(String e_message, double p, double q, double d,double n){
        
        String d_message = "";
        for(int i=0;i<e_message.length();i++){
            char c = e_message.charAt(i);
            double dc = Math.pow(c,d);
            dc = dc%n;
            d_message+=(char)dc;
        }
        return d_message;
        
    }
    public static void main(String[] args) throws Exception {

        double p = 11;
        double q = 13;
        double n = p * q;
        double count=2;
        double totient = (p-1)*(q-1);
        double e = 7;
        double d = 223;
        System.out.println(encrypt("RASTAMAN",p,q,n,e));
        System.out.println(decrypt("ENCRYPTION",p,q,d,n));        
        
    }
}
