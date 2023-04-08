

import java.util.Date;


public class IngressoInteiro extends Ingresso {
    private double preco;

    public IngressoInteiro(String filme, String sala, Date horario, double preco) {
        super(filme, sala, horario);
        this.preco = preco;
    }

    public double getPreco() {
        return preco;
    }
}
