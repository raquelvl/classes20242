import java.util.Scanner;

public class UsaConta {

    public static void main(String[] args) throws Exception {

        Agencia ag = new Agencia(1, "ufpb-rio-tinto");

//        Scanner scanner = new Scanner(System.in);
//
//        criaContaNaAgencia(scanner, ag);

        ContaCorrente conta = new ContaCorrente(1, "Raquel", "000111", 2);
        conta.depositar(10);
        try {
            conta.sacar(1);
        } catch(Exception ex) {
            System.err.println(ex.getMessage());
        }

//        System.out.println(conta.toString());
    }

    private static void criaContaNaAgencia(Scanner scanner, Agencia ag) {
        System.out.println("informe o nome do titular");
        String titular = scanner.nextLine();

        System.out.println("informe o cpf do titular");
        String cpf = scanner.nextLine();

        try {
            ag.adicionarConta(titular, cpf);
            System.out.println("isso vai rodar???");
        } catch(Exception ex) {
            System.err.println("Sinto muito, ocorreu o seguinte erro ao tentar criar sua conta corrente:\n" + ex.getMessage());
            criaContaNaAgencia(scanner, ag);
        }
    }
}
