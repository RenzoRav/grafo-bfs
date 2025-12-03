import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.BorderFactory;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

public class JanelaAplicacaoGrafo extends JFrame {

    private Grafo grafo;
    private JTextField campoNomeVertice;
    private JTextField campoVerticeOrigem;
    private JTextField campoVerticeDestino;
    private JTextField campoBuscaInicio;
    private JTextArea areaSaida;

    public JanelaAplicacaoGrafo() {
        this.grafo = new Grafo();
        inicializarInterface();
    }

    private void inicializarInterface() {
        setTitle("Aplicacao de Grafos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        JPanel painelPrincipal = new JPanel(new BorderLayout());
        JPanel painelEntradas = new JPanel(new GridLayout(4, 1, 5, 5));
        painelEntradas.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel painelVertice = new JPanel(new GridLayout(1, 3, 5, 5));
        JLabel rotuloVertice = new JLabel("Vertice:");
        campoNomeVertice = new JTextField();
        JButton botaoAdicionarVertice = new JButton("Adicionar Vertice");
        JButton botaoRemoverVertice = new JButton("Remover Vertice");
        JPanel painelBotoesVertice = new JPanel(new GridLayout(1, 2, 5, 5));
        painelBotoesVertice.add(botaoAdicionarVertice);
        painelBotoesVertice.add(botaoRemoverVertice);
        painelVertice.add(rotuloVertice);
        painelVertice.add(campoNomeVertice);
        painelVertice.add(painelBotoesVertice);

        JPanel painelAresta = new JPanel(new GridLayout(2, 3, 5, 5));
        JLabel rotuloOrigem = new JLabel("Origem:");
        JLabel rotuloDestino = new JLabel("Destino:");
        campoVerticeOrigem = new JTextField();
        campoVerticeDestino = new JTextField();
        JButton botaoAdicionarAresta = new JButton("Adicionar Aresta");
        JButton botaoRemoverAresta = new JButton("Remover Aresta");
        painelAresta.add(rotuloOrigem);
        painelAresta.add(campoVerticeOrigem);
        painelAresta.add(botaoAdicionarAresta);
        painelAresta.add(rotuloDestino);
        painelAresta.add(campoVerticeDestino);
        painelAresta.add(botaoRemoverAresta);

        JPanel painelBusca = new JPanel(new GridLayout(1, 3, 5, 5));
        JLabel rotuloBuscaInicio = new JLabel("Inicio DFS:");
        campoBuscaInicio = new JTextField();
        JButton botaoExecutarBusca = new JButton("Executar DFS");
        painelBusca.add(rotuloBuscaInicio);
        painelBusca.add(campoBuscaInicio);
        painelBusca.add(botaoExecutarBusca);

        JPanel painelGrafo = new JPanel(new GridLayout(1, 2, 5, 5));
        JButton botaoExibirGrafo = new JButton("Exibir Grafo");
        JButton botaoCriarExemplo = new JButton("Criar Exemplo de Amigos");
        painelGrafo.add(botaoExibirGrafo);
        painelGrafo.add(botaoCriarExemplo);

        painelEntradas.add(painelVertice);
        painelEntradas.add(painelAresta);
        painelEntradas.add(painelBusca);
        painelEntradas.add(painelGrafo);

        areaSaida = new JTextArea();
        areaSaida.setEditable(false);
        JScrollPane painelRolagem = new JScrollPane(areaSaida);
        painelRolagem.setBorder(BorderFactory.createTitledBorder("Saida"));

        painelPrincipal.add(painelEntradas, BorderLayout.NORTH);
        painelPrincipal.add(painelRolagem, BorderLayout.CENTER);

        setContentPane(painelPrincipal);

        botaoAdicionarVertice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                adicionarVertice();
            }
        });

        botaoRemoverVertice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                removerVertice();
            }
        });

        botaoAdicionarAresta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                adicionarAresta();
            }
        });

        botaoRemoverAresta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                removerAresta();
            }
        });

        botaoExibirGrafo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                exibirGrafo();
            }
        });

        botaoCriarExemplo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                criarExemploDeAmigos();
            }
        });

        botaoExecutarBusca.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                executarBuscaProfundidade();
            }
        });

        setVisible(true);
    }

    private void adicionarTextoSaida(String texto) {
        areaSaida.append(texto + System.lineSeparator());
    }

    private void adicionarVertice() {
        String nome = campoNomeVertice.getText().trim();
        if (nome.isEmpty()) {
            adicionarTextoSaida("Nome do vertice vazio.");
            return;
        }
        grafo.adicionarVertice(nome);
        adicionarTextoSaida("Vertice adicionado: " + nome);
    }

    private void removerVertice() {
        String nome = campoNomeVertice.getText().trim();
        if (nome.isEmpty()) {
            adicionarTextoSaida("Nome do vertice vazio.");
            return;
        }
        grafo.removerVertice(nome);
        adicionarTextoSaida("Vertice removido: " + nome);
    }

    private void adicionarAresta() {
        String origem = campoVerticeOrigem.getText().trim();
        String destino = campoVerticeDestino.getText().trim();
        if (origem.isEmpty() || destino.isEmpty()) {
            adicionarTextoSaida("Nome de vertice de origem ou destino vazio.");
            return;
        }
        grafo.adicionarAresta(origem, destino);
        adicionarTextoSaida("Aresta adicionada entre: " + origem + " e " + destino);
    }

    private void removerAresta() {
        String origem = campoVerticeOrigem.getText().trim();
        String destino = campoVerticeDestino.getText().trim();
        if (origem.isEmpty() || destino.isEmpty()) {
            adicionarTextoSaida("Nome de vertice de origem ou destino vazio.");
            return;
        }
        grafo.removerAresta(origem, destino);
        adicionarTextoSaida("Aresta removida entre: " + origem + " e " + destino);
    }

    private void exibirGrafo() {
        adicionarTextoSaida("Grafo atual:");
        adicionarTextoSaida(grafo.toString());
    }

    private void criarExemploDeAmigos() {
        grafo = new Grafo();
        grafo.adicionarAresta("Ana", "Bruno");
        grafo.adicionarAresta("Ana", "Carla");
        grafo.adicionarAresta("Bruno", "Diego");
        grafo.adicionarAresta("Carla", "Diego");
        grafo.adicionarAresta("Diego", "Elisa");
        adicionarTextoSaida("Grafo de amigos criado.");
        exibirGrafo();
    }

    private void executarBuscaProfundidade() {
    String inicio = campoBuscaInicio.getText().trim();
    if (inicio.isEmpty()) {
        adicionarTextoSaida("Vertice inicial vazio.");
        return;
    }

    List<String> ordemVisita = grafo.buscaProfundidade(inicio);

    adicionarTextoSaida("Ordem de visita da busca em profundidade a partir de " + inicio + ":");
    adicionarTextoSaida(ordemVisita.toString());
    
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new JanelaAplicacaoGrafo());
    }
}
