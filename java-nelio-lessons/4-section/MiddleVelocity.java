import java.util.Scanner;

    public class MiddleVelocity{

        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);

            System.out.printf("qual o espaço (x): ");
            double x = sc.nextDouble();

            System.out.printf("qual o tempo (t): ");
            double t = sc.nextDouble();

            double mv = (x/t);
            System.out.printf("The middle velocity is: %.2f m/s%n", mv);

            sc.close();
        }
    }    