import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
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

    public List<String> buscaLargura(String nomeVerticeInicial) {
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

        Queue<String> fila = new LinkedList<>();
        visitado.put(nomeVerticeInicial, true);
        fila.add(nomeVerticeInicial);

        while (!fila.isEmpty()) {
            String nomeVerticeAtual = fila.poll();
            ordemDeVisita.add(nomeVerticeAtual);

            for (String nomeVizinho : listasDeAdjacencia.get(nomeVerticeAtual)) {
                if (!visitado.get(nomeVizinho)) {
                    visitado.put(nomeVizinho, true);
                    fila.add(nomeVizinho);
                }
            }
        }

        return ordemDeVisita;
    }

    public List<String> caminhoMinimo(String nomeVerticeInicial, String nomeVerticeFinal) {
        List<String> caminho = new ArrayList<>();
        if (nomeVerticeInicial == null || nomeVerticeFinal == null) {
            return caminho;
        }
        if (!listasDeAdjacencia.containsKey(nomeVerticeInicial) || !listasDeAdjacencia.containsKey(nomeVerticeFinal)) {
            return caminho;
        }

        Map<String, Boolean> visitado = new HashMap<>();
        Map<String, String> anterior = new HashMap<>();

        for (String nomeVertice : listasDeAdjacencia.keySet()) {
            visitado.put(nomeVertice, false);
            anterior.put(nomeVertice, null);
        }

        Queue<String> fila = new LinkedList<>();
        visitado.put(nomeVerticeInicial, true);
        fila.add(nomeVerticeInicial);

        while (!fila.isEmpty()) {
            String nomeVerticeAtual = fila.poll();
            if (nomeVerticeAtual.equals(nomeVerticeFinal)) {
                break;
            }
            for (String nomeVizinho : listasDeAdjacencia.get(nomeVerticeAtual)) {
                if (!visitado.get(nomeVizinho)) {
                    visitado.put(nomeVizinho, true);
                    anterior.put(nomeVizinho, nomeVerticeAtual);
                    fila.add(nomeVizinho);
                }
            }
        }

        if (!visitado.get(nomeVerticeFinal)) {
            return caminho;
        }

        String nomeAtual = nomeVerticeFinal;
        while (nomeAtual != null) {
            caminho.add(0, nomeAtual);
            nomeAtual = anterior.get(nomeAtual);
        }

        return caminho;
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
