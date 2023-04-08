
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SessaoDAO {

    private static List<Sessao> sessoes = new ArrayList<>();

    public static List<Sessao> listarSessoes() {
        return sessoes;
    }

    public static void adicionarSessao(Sessao sessao) {
        sessoes.add(sessao);
    }

    public static Sessao buscarSessao(String filme, String sala, Date horario) {
        return buscarSessao(filme, sala, horario);
    }

    public static Sessao buscarSessao(String filme, String sala, String horario) {
        for (Sessao sessao : sessoes) {
            if (sessao.getFilme().equals(filme) && sessao.getSala().equals(sala) && sessao.getHorario().equals(horario)) {
                return sessao;
            }
        }
        return null;
    }
}
