import java.time.LocalDate;
import java.util.Objects;

public class ContaCorrente {

    private int numeroDaConta;
    private String titular;
    private String cpf;
    private int agencia;
    private double saldo;
    private LocalDate dataDeCriacao;

    public ContaCorrente(int numero) {
        numeroDaConta = numero;
        saldo = 0;
        dataDeCriacao = LocalDate.now();
    }

    public ContaCorrente(int numeroDaConta, String titular, String cpf, int agencia) {
        this.numeroDaConta = numeroDaConta;
        this.titular = titular;
        this.cpf = cpf;
        this.agencia = agencia;
        saldo = 0;
        dataDeCriacao = LocalDate.now();
    }

    public int getNumeroDaConta() {
        return numeroDaConta;
    }

    public String getTitular() {
        return titular;
    }

    public String getCpf() {
        return cpf;
    }

    public int getAgencia() {
        return agencia;
    }

    public double getSaldo() {
        return saldo;
    }

    public LocalDate getDataDeCriacao() {
        return dataDeCriacao;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double depositar(double valor) {
        if(valor > 0)
            saldo += valor;
        return saldo;
    }

    public double sacar(double valor) {
        if(valor <= saldo)
            saldo -= valor;

        return valor;
    }

    public double transferir(ContaCorrente contaDestino, double valor) {
        this.sacar(valor);
        contaDestino.depositar(valor);
        return saldo;
    }

    @Override
    public String toString() {
        return "ContaCorrente{" +
                "numeroDaConta=" + numeroDaConta +
                ", titular='" + titular + '\'' +
                ", cpf='" + cpf + '\'' +
                ", agencia=" + agencia +
                ", saldo=" + saldo +
                ", dataDeCriacao=" + dataDeCriacao +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ContaCorrente that)) return false;
        return numeroDaConta == that.numeroDaConta && agencia == that.agencia && Objects.equals(cpf, that.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroDaConta, cpf, agencia);
    }
}
