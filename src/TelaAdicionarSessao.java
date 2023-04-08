import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaAdicionarSessao {
    private JFrame frame;
    private JPanel panel;
    private JComboBox<String> filmesComboBox;
    private JComboBox<String> salasComboBox;
    private JTextField horarioTextField;

    public TelaAdicionarSessao(ArrayList<Filme> filmes, ArrayList<Sala> salas, ArrayList<Sessao> sessoes) {
        frame = new JFrame("Adicionar sessão");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel filmeLabel = new JLabel("Filme:");
        filmesComboBox = new JComboBox<>();
        for (Filme filme : filmes) {
            filmesComboBox.addItem(filme.getNome());
        }
        JPanel filmePanel = new JPanel();
        filmePanel.add(filmeLabel);
        filmePanel.add(filmesComboBox);
        panel.add(filmePanel);

        JLabel salaLabel = new JLabel("Sala:");
        salasComboBox = new JComboBox<>();
        for (Sala sala : salas) {
            salasComboBox.addItem(sala.getNome());
        }
        JPanel salaPanel = new JPanel();
        salaPanel.add(salaLabel);
        salaPanel.add(salasComboBox);
        panel.add(salaPanel);

        JLabel horarioLabel = new JLabel("Horário:");
        horarioTextField = new JTextField();
        JPanel horarioPanel = new JPanel();
        horarioPanel.add(horarioLabel);
        horarioPanel.add(horarioTextField);
        panel.add(horarioPanel);

        JButton adicionarButton = new JButton("Adicionar");
        adicionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String filmeSelecionado = (String) filmesComboBox.getSelectedItem();
                String salaSelecionada = (String) salasComboBox.getSelectedItem();
                Date horario = new Date(horarioTextField.getText()); // ou outra forma de converter para Date

                Filme filme = null;
                for (Filme f : filmes) {
                    if (f.getNome().equals(filmeSelecionado)) {
                        filme = f;
                        break;
                    }
                }

                Sala sala = null;
                for (Sala s : salas) {
                    if (s.getNome().equals(salaSelecionada)) {
                        sala = s;
                        break;
                    }
                }

                if (filme != null && sala != null) {
                    Sessao sessao = new Sessao(filme, sala, horario);
                    sessoes.add(sessao);
                    // Ou chamar outro método para adicionar a sessão em algum lugar
                    frame.dispose();
                } else {
                    // Mostrar mensagem de erro caso não tenha sido possível encontrar o filme ou a sala
                }
            }
        });
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(adicionarButton);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(buttonPanel);

        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }
}

