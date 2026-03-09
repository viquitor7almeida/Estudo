import java.util.Scanner;

public class Difference{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.printf("Calculador de diferença");

        System.out.printf("Digite o valor de A: ");
        double a = sc.nextDouble();

        System.out.printf("Digite o valor de B: ");
        double b = sc.nextDouble();

        System.out.printf("digite o valor de C: ");
        double c = sc.nextDouble();

        System.out.printf("Digite o valor de D: ");
        double d = sc.nextDouble();

        double df = ((a - b * c - d));
        System.out.printf("A diferença é: %.2f%n",df);
    }
}