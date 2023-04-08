
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

public class TelaPrincipal extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private DefaultListModel<String> modeloLista;
    private JList<String> listaSessoes;
    private JButton botaoComprar;
    private SimpleDateFormat formatoDataHora = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    public TelaPrincipal() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Cinema");

        modeloLista = new DefaultListModel<String>();
        for (Sessao sessao : SessaoDAO.listarSessoes()) {
            String itemLista = sessao.getFilme() + " - " + sessao.getSala() + " - " + formatoDataHora.format(sessao.getHorario());
            modeloLista.addElement(itemLista);
        }
        listaSessoes = new JList<String>(modeloLista);
        listaSessoes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane painelLista = new JScrollPane(listaSessoes);

        botaoComprar = new JButton("Comprar ingresso");
        botaoComprar.addActionListener(this);

        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        painelBotoes.add(botaoComprar);

        JPanel painelPrincipal = new JPanel(new BorderLayout());
        painelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JLabel labelTitulo = new JLabel("Sessões disponíveis");
        labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        painelPrincipal.add(labelTitulo, BorderLayout.NORTH);
        painelPrincipal.add(painelLista, BorderLayout.CENTER);
        painelPrincipal.add(painelBotoes, BorderLayout.SOUTH);

        getContentPane().add(painelPrincipal);

        pack();
        setLocationRelativeTo(null);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botaoComprar) {
            String itemSelecionado = listaSessoes.getSelectedValue();
            if (itemSelecionado == null) {
                JOptionPane.showMessageDialog(this, "Selecione uma sessão.");
            } else {
                String[] partes = itemSelecionado.split(" - ");
                String filme = partes[0];
                String sala = partes[1];
                Date horario = null;
                try {
                    horario = formatoDataHora.parse(partes[2]);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Erro ao ler horário da sessão.");
                    return;
                }
                Sessao sessao = SessaoDAO.buscarSessao(filme, sala, horario);
                if (sessao == null) {
                    JOptionPane.showMessageDialog(this, "Sessão não encontrada.");
                } else if (sessao.isLotada()) {
                    JOptionPane.showMessageDialog(this, "Sessão lotada.");
                } else {
                    int quantidade = 0;
                    while (quantidade <= 0) {
                        try {
                            quantidade = Integer.parseInt(JOptionPane.showInputDialog(this, "Quantos ingressos deseja comprar?"));
                        } catch (Exception ex) {
                        
                        }
                        if (quantidade <= 0) {
                            JOptionPane.showMessageDialog(this, "Digite um valor válido.");
                        }
                    }
                    sessao.venderIngressos(quantidade);
                    JOptionPane.showMessageDialog(this, "Compra efetuada com sucesso.");

// Atualiza lista de sessões disponíveis
                    modeloLista.clear();
                    for (Sessao s : SessaoDAO.listarSessoes()) {
                        String itemLista = s.getFilme() + " - " + s.getSala() + " - " + formatoDataHora.format(s.getHorario()) + " - " + s.getIngressosDisponiveis() + " ingressos disponíveis";
                        modeloLista.addElement(itemLista);
                    }
                    
                }
            }
        }
    }
}
         
    
    
    


//import java.awt.BorderLayout;
//import java.awt.EventQueue;
//import java.awt.FlowLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import javax.swing.BorderFactory;
//import javax.swing.DefaultListModel;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JList;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.ListSelectionModel;
//import javax.swing.SwingConstants;
//
//public class TelaPrincipal extends JFrame implements ActionListener {
//
//
//private static final long serialVersionUID = 1L;
//private DefaultListModel<String> modeloLista;
//private JList<String> listaSessoes;
//private JButton botaoComprar;
//private SimpleDateFormat formatoDataHora = new SimpleDateFormat("dd/MM/yyyy HH:mm");
//
//public TelaPrincipal() {
//    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    setTitle("Cinema");
//
//    modeloLista = new DefaultListModel<String>();
//    for (Sessao sessao : SessaoDAO.listarSessoes()) {
//        String itemLista = formatarItemLista(sessao);
//        modeloLista.addElement(itemLista);
//    }
//    listaSessoes = new JList<String>(modeloLista);
//    listaSessoes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//    JScrollPane painelLista = new JScrollPane(listaSessoes);
//
//    botaoComprar = new JButton("Comprar ingresso");
//    botaoComprar.addActionListener(this);
//
//    JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.RIGHT));
//    painelBotoes.add(botaoComprar);
//
//    JPanel painelPrincipal = new JPanel(new BorderLayout());
//    painelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
//    JLabel labelTitulo = new JLabel("Sessões disponíveis");
//    labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
//    painelPrincipal.add(labelTitulo, BorderLayout.NORTH);
//    painelPrincipal.add(painelLista, BorderLayout.CENTER);
//    painelPrincipal.add(painelBotoes, BorderLayout.SOUTH);
//
//    getContentPane().add(painelPrincipal);
//
//    pack();
//    setLocationRelativeTo(null);
//}
//
//public void actionPerformed(ActionEvent e) {
//    if (e.getSource() == botaoComprar) {
//        String itemSelecionado = listaSessoes.getSelectedValue();
//        if (itemSelecionado == null) {
//            JOptionPane.showMessageDialog(this, "Selecione uma sessão.");
//        } else {
//            String[] partes = itemSelecionado.split(" - ");
//            String filme = partes[0];
//            String sala = partes[1];
//            Date horario = null;
//            try {
//                horario = formatoDataHora.parse(partes[2]);
//            } catch (Exception ex) {
//                JOptionPane.showMessageDialog(this, "Erro ao ler horário da sessão.");
//                return;
//            }
//            Sessao sessao = SessaoDAO.buscarSessao(filme, sala, horario);
//            if (sessao == null) {
//                JOptionPane.showMessageDialog(this, "Sessão não encontrada.");
//            } else if (sessao.isLotada()) {
//                JOptionPane.showMessageDialog(this, "Sessão lotada.");
//            } else {
//                int quantidade = 0;
//                while (quantidade <= 0) {
//                    try {
//                        quantidade = Integer.parseInt(JOptionPane.showInputDialog(this, "Quantos ingressos deseja comprar?"));
//                    } catch (Exception ex) {
//                        JOptionPane.showMessageDialog(this, "Digite um valor válido.");
//                    }
//                    if (quantidade <= 0) {
//                        JOptionPane.showMessageDialog(this, "Digite um valor válido.");
//                    }
//                }
//                sessao.venderIngressos(quantidade);
//                JOptionPane.showMessageDialog(this, "Compra efetuada com sucesso.");
//
//                // Atualiza lista de sessões disponíveis
//                modeloLista.clear();
//                for (Sessao s : SessaoDAO.listarSessoes()) {
//                    String itemLista = s.getFilme() + " - " + s.getSala() + " - " + formatoDataHora.format(s.getHorario()) + " - " + s.getIngressosDisponiveis() + " ingressos disponíveis";
//                    modeloLista.addElement(itemLista);
//                }
//            }
//        }
//    }
//}
//
//    private String formatarItemLista(Sessao sessao) {
//    return String.format("%s - %s - %s - %d ingressos disponíveis", 
//        sessao.getFilme(), 
//        sessao.getSala(), 
//        formatoDataHora.format(sessao.getHorario()),
//        sessao.getIngressosDisponiveis());
//}
//
//}
