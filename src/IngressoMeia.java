
import java.util.Date;

public class IngressoMeia extends Ingresso {
    private double preco;

    public IngressoMeia(String filme, String sala, Date horario, double preco) {
        super(filme, sala, horario);
        this.preco = preco;
    }

    public double getPreco() {
        return preco / 2;
    }
}