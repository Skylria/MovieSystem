
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        
        // Cria algumas sessões de exemplo
        Sessao sessao1 = new Sessao("John Wick 4: Baba Yaga", "Sala A", new Date());
        Sessao sessao2 = new Sessao("Harry Potter e as Reliquias da Morte: Parte 2", "Sala B", new Date());
        Sessao sessao3 = new Sessao("Cinquenta Tons de Cinza", "Sala C", new Date());
        
        // Adiciona as sessões criadas no banco de dados
        SessaoDAO.adicionarSessao(sessao1);
        SessaoDAO.adicionarSessao(sessao2);
        SessaoDAO.adicionarSessao(sessao3);
        
        // Cria e exibe a tela principal
        TelaPrincipal tela = new TelaPrincipal();
        tela.setVisible(true);
    }
}

//import java.awt.EventQueue;
//
//public class Main {
//
//    public static void main(String[] args) {
//        
//        // Cria e exibe a tela principal
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new TelaPrincipal().setVisible(true);
//            }
//        });
//        
//        // Vende 2 ingressos inteiros para a sessão 1
//        Sessao sessao1 = SessaoDAO.buscarSessao("Star Wars: O Despertar da Força", "Sala 1", "10/04/2023 18:00");
//        if (sessao1 != null) {
//            if (sessao1.isLotada()) {
//                System.out.println("A sessão está lotada.");
//            } else {
//                sessao1.venderIngressos(2);
//                System.out.println("Compra de 2 ingressos inteiros para a sessão 1 efetuada com sucesso.");
//            }
//        } else {
//            System.out.println("A sessão não foi encontrada.");
//        }
//        
//        // Vende 3 ingressos de meia-entrada para a sessão 2
//        Sessao sessao2 = SessaoDAO.buscarSessao("Matrix", "Sala 2", "11/04/2023 20:30");
//        if (sessao2 != null) {
//            if (sessao2.isLotada()) {
//                System.out.println("A sessão está lotada.");
//            } else {
//                sessao2.venderIngressos(3);
//                System.out.println("Compra de 3 ingressos de meia-entrada para a sessão 2 efetuada com sucesso.");
//            }
//        } else {
//            System.out.println("A sessão não foi encontrada.");
//        }
//    }
//
//}
