import java.util.Scanner;
import java.lang.Math;

// A Classe funciona como o "Molde" para a criação dos objetos
public class CicloObjeto {
    
    //Atributos que guardam o estado do objeto na memória RAM
    double aCO, bCO, cCO, deltaCO;

    //Permite criar objeto vazio
    public CicloObjeto() {
}

    //Construtor para objeto que vai utilizar
    // THIS: Comando de criação do construtor, garante o estado inicial ao objeto (new)
    //Fornece argumentos para essa inicialização e diferencia o que é do objeto (this) do que é parâmetro
    public CicloObjeto(int aCO, int bCO,int cCO){
        this.aCO = aCO;
        this.bCO = bCO;
        this.cCO = cCO;
        this.deltaCO = (bCO*bCO) - 4*aCO;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("digite o valor de a: ");
        int a = scan.nextInt();

        System.out.print("digite o valor de b: "); 
        int b = scan.nextInt();    

        System.err.print("Digite o valor de c: ");
        int c =scan.nextInt();

        System.out.print("digite o valor de a para o constructor: ");
        int aCO_in = scan.nextInt();

        System.out.print("digite o valor de b para o constructor: "); 
        int bCO_in = scan.nextInt();    

        System.err.print("Digite o valor de c para o constructor: ");
        int cCO_in =scan.nextInt();
        
        //NEW: Aloca um espaço exclusivo na memória RAM, separando este objeto de outros
        CicloObjeto deltaObjeto = new CicloObjeto();
        
        //PARÂMETROS: O contato de entrada. O método delta recebe o que precisa (int) para trabalhar
        double d = deltaObjeto.delta(a, b, c);

        //Novo NEW: Criando uma funcionalidade que processa dados variantes
        CicloObjeto equacacao2GrauObjeto = new CicloObjeto();
        equacacao2GrauObjeto.equacao2GrauInst(a, b, d);

        //THIS/CONSTRUTOR: Aqui o NEW usa o construtor para definir o estado inicial com argumentos específicos
        CicloObjeto equacao2GrauObjetoConstr = new CicloObjeto(aCO_in, bCO_in, cCO_in);
        equacao2GrauObjetoConstr.equacao2GrauConstr();

        scan.close();
    }

    //O método entrega o que é necessário para rodar (int a, b, c) e processa os dados variantes
    public double delta(int a, int b, int c){
        int deltaCalc = (b*b - (4*a*c));
        System.err.println("Delta é = " + deltaCalc);
        return deltaCalc;
    }

    //Funcionalidade que se resume em um método aliado à classe para processar a equação
    public void equacao2GrauInst(int a, int b, double deltaCalc){
        if (deltaCalc>=0){
            double x1 = (-b + Math.sqrt(deltaCalc)) / (2*a);
            double x2 = (-b - Math.sqrt(deltaCalc)) / (2*a);

            System.err.printf("O x1 da equação é: %f %nO x2 da equação é: %f %n", x1, x2);
        }
            else{
                System.err.printf("Não existem resultados reais para essa equação %n");
            }  
    }

    //Método que utiliza o estado interno (THIS) salvo anteriormente na memória
    public void equacao2GrauConstr(){
        System.err.println("O delta com constructor é: " + deltaCO);
        if(deltaCO >= 0){
            double x1 = (-bCO + Math.sqrt(deltaCO)) / (2*aCO);
            double x2 = (-bCO - Math.sqrt(deltaCO)) / (2*aCO);    
            
        System.err.printf("O x1 da equação usando constructor é: %f %nO x2 da equação usando constructor é: %f %n", x1, x2);
        }
    }
}