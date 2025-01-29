import java.util.ArrayList;
import java.util.List;

public class Agencia {

    private int numero;
    private String nome;
    private List<ContaCorrente> contas = new ArrayList<>();

    public Agencia(int numero, String nome) {
        this.numero = numero;
        this.nome = nome;
    }

    public ContaCorrente adicionarConta(String titular, String cpf) {
        ContaCorrente novaConta = new ContaCorrente(contas.size(), titular, cpf, numero);
        contas.add(novaConta);
        return novaConta;
    }

    public ContaCorrente localizarConta(int numero) {
        for(ContaCorrente conta: contas) {
            if(conta.getNumeroDaConta() == numero)
                return conta;
        }

        return null;
    }


}
