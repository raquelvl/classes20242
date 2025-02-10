import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

    public ContaCorrente(int numeroDaConta, String titular, String cpf, int agencia) throws Exception {
        this.numeroDaConta = numeroDaConta;

        checaTitular(titular);
        checaCPF(cpf);
        checaAgencia(agencia);

        this.titular = titular;
        this.cpf = cpf;
        this.agencia = agencia;
        saldo = 0;
        dataDeCriacao = LocalDate.now();
    }

    private void checaAgencia(int agencia) throws Exception {
        if(agencia < 0)
            throw new Exception("Agencia deve ser maior que zero.");
    }

    private void checaCPF(String cpf) throws Exception {
        if(cpf == null || cpf.trim().equals(""))
            throw new Exception("CPF deve ser valido.");
    }

    private void checaTitular(String titular) throws Exception {
        if(titular == null || titular.trim().equals(""))
            throw new Exception("Titular deve ser um nome valido.");
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

    public void setTitular(String titular) throws Exception {
        checaTitular(titular);
        this.titular = titular;
    }

    public double depositar(double valor) throws Exception {
        checaValorNegativo(valor);

        saldo += valor;
        return saldo;
    }

    private void checaValorNegativo(double valor) throws Exception {
        if(valor <= 0)
            throw new Exception("Valor deve ser maior que zero.");
    }

    public double sacar(double valor) throws Exception {
        checaValorNegativo(valor);
        isSaldoSuficiente(valor);

        saldo -= valor;
        return valor;
    }

    private void isSaldoSuficiente(double valor) throws Exception {
        if(valor > saldo)
            throw new Exception("Saldo insuficiente.");
    }

    public double transferir(ContaCorrente contaDestino, double valor) throws Exception {
        this.sacar(valor);
        contaDestino.depositar(valor

        );
        return saldo;
    }

    @Override
    public String toString() {
        DateTimeFormatter diaMesAno = DateTimeFormatter.ofPattern("dd/mm/yyyy");
        return "ContaCorrente{" +
                "numeroDaConta=" + numeroDaConta +
                ", titular='" + titular + '\'' +
                ", cpf='" + cpf + '\'' +
                ", agencia=" + agencia +
                ", saldo=" + saldo +
                ", dataDeCriacao=" + dataDeCriacao.format(diaMesAno) +
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