import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.*;

class ContaCorrenteTest {
    ContaCorrente conta;

    @BeforeEach
    void setUp() throws Exception {
        conta = new ContaCorrente(1, "Raquel Lopes", "00011122233344", 2);
    }

    @Test
    void getNumeroDaConta() {
        assertEquals(1, conta.getNumeroDaConta());
    }

    @Test
    void getTitular() {
        assertEquals("Raquel Lopes", conta.getTitular());
    }

    @Test
    void getCpf() {
    }

    @Test
    void getAgencia() {
    }

    @Test
    void getSaldo() {
        assertEquals(0.0, conta.getSaldo());
    }

    @Test
    void getDataDeCriacao() {
    }

    @Test
    void setTitular() {
    }

    @Test
    void depositar() throws Exception {
        conta.depositar(9.98);
        assertEquals(9.98, conta.getSaldo());
        conta.depositar(0.01);
        assertEquals(9.99, conta.getSaldo(), 0.001);
    }

    @Test
    void depositarUmCentavo() throws Exception {
        conta.depositar(0.01);
        assertEquals(0.01, conta.getSaldo());
    }

    @Test
    void depositarValorNegativo() {
        try {
            conta.depositar(-2.98);
            fail("Deveria lançar excecao ao depositar valor negativo.");
        } catch (Exception exception) {
            assertEquals("Valor deve ser maior que zero.", exception.getMessage());
        }
    }

    @Test
    void depositarValorNegativo2() {
        Exception exception = assertThrows(Exception.class, () -> conta.depositar(-4.79));
        assertEquals("Valor deve ser maior que zero.", exception.getMessage());
    }



    @Test
    void sacar() throws Exception {
        conta.depositar(1.01);
        conta.sacar(0.01);
        assertEquals(1.00, conta.getSaldo());
    }

    @Test
    void sacarSaldoInsuficiente() throws Exception {
        Exception exception = assertThrows(Exception.class, () -> conta.sacar(0.01));
        assertEquals("Saldo insuficiente.", exception.getMessage());
    }

    @Test
    void sacarValorNegativo() throws Exception {
        Exception exception = assertThrows(Exception.class, () -> conta.sacar(-0.01));
        assertEquals("Valor deve ser maior que zero.", exception.getMessage());
    }

    @Test
    void transferir() {
    }

    @Test
    void testToString() {
    }

    @Test
    void testEquals() {
    }
}