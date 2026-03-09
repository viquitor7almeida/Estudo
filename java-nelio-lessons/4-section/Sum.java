import java.util.Scanner;

public class Sum{
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);

        System.out.printf("informe um número: ");
        double x = sc.nextDouble();

        System.out.printf("informe outro número: ");
        double y = sc.nextDouble();

        double sum = (x + y);
        System.out.printf("a soma é: %.2f%n ",sum);

        sc.close();
    }
}