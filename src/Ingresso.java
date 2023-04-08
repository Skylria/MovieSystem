
import java.util.Date;

public abstract class Ingresso {
    private String filme;
    private String sala;
    private Date horario;

    public Ingresso(String filme, String sala, Date horario) {
    if (filme == null || sala == null || horario == null) {
        throw new IllegalArgumentException("Os parâmetros filme, sala e horário não podem ser nulos");
    }
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

    public abstract double getPreco();
}
