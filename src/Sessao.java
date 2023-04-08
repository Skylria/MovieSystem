import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Sessao {
    private String filme;
    private String sala;
    private Date horario;
    private List<Ingresso> ingressos = new ArrayList<>();

    public Sessao(String filme, String sala, Date horario) {
        this.filme = filme;
        this.sala = sala;
        this.horario = horario;
    }

    public String getFilme() {
        return filme;
    }

    public void setFilme(String filme) {
        this.filme = filme;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public Date getHorario() {
        return horario;
    }

    public void setHorario(Date horario) {
        this.horario = horario;
    }

    public List<Ingresso> getIngressos() {
        return ingressos;
    }

    public void addIngresso(Ingresso ingresso) {
        ingressos.add(ingresso);
    }

    public boolean isLotada() {
    int capacidadeSala = 50; 
    return ingressos.size() >= capacidadeSala;
}

public void venderIngressos(int quantidade) {
    int ingressosDisponiveis = 50 - ingressos.size(); 
    if (quantidade > ingressosDisponiveis) {
        System.out.println("Não há ingressos suficientes disponíveis para venda.");
    } else {
        for (int i = 0; i < quantidade; i++) {
            Ingresso ingresso = new IngressoInteiro(filme, sala, horario, 20.0); 
            ingressos.add(ingresso);
        }
        System.out.println("Venda realizada com sucesso!");
    }
}

    public String getIngressosDisponiveis() {
    int capacidadeSala = 50;
    int ingressosDisponiveis = capacidadeSala - ingressos.size();
    return "Ingressos disponíveis: " + ingressosDisponiveis;
}
}
