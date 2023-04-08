//import java.util.ArrayList;
//import java.util.List;
//
//public class GerenciadorSessoes {
//    private List<Sessao> sessoes = new ArrayList<>();
//
//    public void adicionarSessao(Sessao sessao) {
//        sessoes.add(sessao);
//    }
//
//    public void removerSessao(Sessao sessao) {
//        sessoes.remove(sessao);
//    }
//
//    public Sessao buscarSessao(String filme, String sala) {
//        for (Sessao sessao : sessoes) {
//            if (sessao.getFilme().equals(filme) && sessao.getSala().equals(sala)) {
//                return sessao;
//            }
//        }
//        return null;
//    }
//
//}


import java.util.ArrayList;
import java.util.List;

public class GerenciadorSessoes {
    private List<Sessao> sessoes = new ArrayList<>();

    public void adicionarSessao(Sessao sessao) {
        sessoes.add(sessao);
    }

    public void removerSessao(Sessao sessao) {
        sessoes.remove(sessao);
    }

    public Sessao buscarSessao(String filme, String sala) throws IllegalArgumentException, SessaoNaoEncontradaException {
        if (filme == null || sala == null) {
            throw new IllegalArgumentException("Os parâmetros 'filme' e 'sala' não podem ser nulos.");
        }

        for (Sessao sessao : sessoes) {
            if (sessao.getFilme().equals(filme) && sessao.getSala().equals(sala)) {
                return sessao;
            }
        }

        throw new SessaoNaoEncontradaException("Sessão não encontrada.");
    }

    public List<Sessao> listarSessoesDisponiveis() {
        List<Sessao> sessoesDisponiveis = new ArrayList<>();
        for (Sessao sessao : sessoes) {
            if (!sessao.isLotada()) {
                sessoesDisponiveis.add(sessao);
            }
        }
        return sessoesDisponiveis;
    }

    public void venderIngressos(Sessao sessao, int quantidade) throws SessaoLotadaException {
        sessao.venderIngressos(quantidade);
    }
}
