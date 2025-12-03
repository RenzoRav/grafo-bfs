import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Grafo {

    private Map<String, Set<String>> listasDeAdjacencia;

    public Grafo() {
        this.listasDeAdjacencia = new HashMap<>();
    }

    public void adicionarVertice(String nomeVertice) {
        if (nomeVertice == null) {
            return;
        }
        if (!listasDeAdjacencia.containsKey(nomeVertice)) {
            listasDeAdjacencia.put(nomeVertice, new HashSet<>());
        }
    }

    public void adicionarAresta(String nomeVerticeOrigem, String nomeVerticeDestino) {
        if (nomeVerticeOrigem == null || nomeVerticeDestino == null) {
            return;
        }
        adicionarVertice(nomeVerticeOrigem);
        adicionarVertice(nomeVerticeDestino);
        listasDeAdjacencia.get(nomeVerticeOrigem).add(nomeVerticeDestino);
        listasDeAdjacencia.get(nomeVerticeDestino).add(nomeVerticeOrigem);
    }

    public void removerVertice(String nomeVertice) {
        if (nomeVertice == null) {
            return;
        }
        if (!listasDeAdjacencia.containsKey(nomeVertice)) {
            return;
        }
        for (String nomeOutroVertice : listasDeAdjacencia.keySet()) {
            listasDeAdjacencia.get(nomeOutroVertice).remove(nomeVertice);
        }
        listasDeAdjacencia.remove(nomeVertice);
    }

    public void removerAresta(String nomeVerticeOrigem, String nomeVerticeDestino) {
        if (nomeVerticeOrigem == null || nomeVerticeDestino == null) {
            return;
        }
        if (listasDeAdjacencia.containsKey(nomeVerticeOrigem)) {
            listasDeAdjacencia.get(nomeVerticeOrigem).remove(nomeVerticeDestino);
        }
        if (listasDeAdjacencia.containsKey(nomeVerticeDestino)) {
            listasDeAdjacencia.get(nomeVerticeDestino).remove(nomeVerticeOrigem);
        }
    }

    public Set<String> obterVertices() {
        return listasDeAdjacencia.keySet();
    }

    public Set<String> obterVizinhos(String nomeVertice) {
        if (!listasDeAdjacencia.containsKey(nomeVertice)) {
            return new HashSet<>();
        }
        return new HashSet<>(listasDeAdjacencia.get(nomeVertice));
    }

    public List<String> buscaProfundidade(String nomeVerticeInicial) {
        List<String> ordemDeVisita = new ArrayList<>();
        if (nomeVerticeInicial == null) {
            return ordemDeVisita;
        }
        if (!listasDeAdjacencia.containsKey(nomeVerticeInicial)) {
            return ordemDeVisita;
        }

        Map<String, Boolean> visitado = new HashMap<>();
        for (String nomeVertice : listasDeAdjacencia.keySet()) {
            visitado.put(nomeVertice, false);
        }

        dfs(nomeVerticeInicial, visitado, ordemDeVisita);
        return ordemDeVisita;
    }

    private void dfs(String nomeVerticeAtual, Map<String, Boolean> visitado, List<String> ordemDeVisita) {
        visitado.put(nomeVerticeAtual, true);
        ordemDeVisita.add(nomeVerticeAtual);

        for (String nomeVizinho : listasDeAdjacencia.get(nomeVerticeAtual)) {
            if (!visitado.get(nomeVizinho)) {
                dfs(nomeVizinho, visitado, ordemDeVisita);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder construtor = new StringBuilder();
        for (String nomeVertice : listasDeAdjacencia.keySet()) {
            construtor.append(nomeVertice);
            construtor.append(" -> ");
            construtor.append(listasDeAdjacencia.get(nomeVertice));
            construtor.append(System.lineSeparator());
        }
        return construtor.toString();
    }
}
