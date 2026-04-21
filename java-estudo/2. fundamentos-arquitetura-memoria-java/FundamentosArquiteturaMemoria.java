/**
 * 1. O PONTO DE PARTIDA (JVM E MAIN)
 * O método public static void main(String[] args) é a porta de entrada.
 * A JVM não lê o código; ela busca por essa "assinatura" específica no Bytecode.
 * Arquitetura: É um método estático para que possa ser chamado antes da alocação
 * de qualquer objeto no Heap.
 */
public class FundamentosArquiteturaMemoria {

    // 3. O MODIFICADOR STATIC (ESCOPO DE CLASSE)
    // Alocação: Vive no Metaspace (fora do Heap comum).
    // Compartilhamento: Variáveis estáticas são compartilhadas por todas as instâncias.
    // Uso Ideal: Constantes e métodos utilitários sem estado (Stateless).
    public static final double PI = 3.14159;

    // 2. VISIBILIDADE E ENCAPSULAMENTO (MODIFICADORES)
    // Private: Restringe o estado ao escopo da classe (Encapsulamento puro).
    private String segredo = "Dados sensíveis";

    public static void main(String[] args) {

        // 4. GESTÃO DE MEMÓRIA (STACK VS HEAP) & 5. TIPOS DE RETORNO E DADOS

        // Primitivos: Alta performance, ocupam a Stack.
        int idade = 25;

        // Referência (Pessoa p): Fica na Stack (apontando para o Heap).
        // Objeto (new Pessoa()): Fica no Heap (onde os objetos reais residem).
        Pessoa p = new Pessoa();

        // Objetos (Wrappers): Vivem no Heap, permitem nulos, custam mais processamento.
        Integer score = null;

        // Executando métodos para demonstrar conceitos
        exemploEarlyReturn(10);
        demonstrarErros();
    }

    /**
     * 7. REGRAS DE OURO (BEST PRACTICES) - EARLY RETURN
     * Em métodos com retorno, use o return o quanto antes para evitar else desnecessários.
     */
    public static String exemploEarlyReturn(int valor) {
        if (valor < 0) return "Invalido"; // Early return: sai antes sem precisar de else
        if (valor == 0) return "Zero";

        return "Positivo";
    }

    /**
     * 8. ERROS COMUNS
     */
    public static void demonstrarErros() {
        // NullPointerException: Acesso via referência na Stack que aponta para null no Heap.
        try {
            String texto = null;
            texto.toUpperCase();
        } catch (NullPointerException e) { System.out.println("Erro: NPE"); }

        // StackOverflowError: Excesso de métodos empilhados (recursão infinita).
        // recursaoInfinita();

        // OutOfMemoryError: O Heap está cheio e o GC não consegue liberar espaço.
        // List<byte[]> lista = new ArrayList<>();
        // while(true) { lista.add(new byte[1000000]); }
    }
}

/**
 * 2. VISIBILIDADE E ENCAPSULAMENTO
 */
class Pessoa {
    // Encapsulamento: Atributos sempre private.
    private String nome;

    // Default (Package): Permite colaboração entre classes do mesmo pacote.
    void metodoPacote() {}

    // Protected: Focado em extensibilidade via herança.
    protected void paraFilhos() {}

    // Public: Define a interface pública da sua API.
    public String getNome() { return nome; }
}

/**
 * 6. JAVA CHEAT SHEET - ONDE AS COISAS FICAM?
 * [Variavel Local]: Stack
 * [Objeto]: Heap
 * [Referência]: Stack
 * [Constante/Static]: Metaspace
 * * MODIFICADORES DE ACESSO:
 * public: Classe(S), Pacote(S), Subclasse(S), Geral(S)
 * protected: Classe(S), Pacote(S), Subclasse(S), Geral(N)
 * default: Classe(S), Pacote(S), Subclasse(N), Geral(N)
 * private: Classe(S), Pacote(N), Subclasse(N), Geral(N)
 */
