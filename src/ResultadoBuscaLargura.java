import java.util.List;
import java.util.Map;

public class ResultadoBuscaLargura {

    private List<String> ordemVisita;
    private Map<String, Integer> distancia;
    private Map<String, String> anterior;

    public List<String> obterOrdemVisita() {
        return ordemVisita;
    }

    public void definirOrdemVisita(List<String> ordemVisita) {
        this.ordemVisita = ordemVisita;
    }

    public Map<String, Integer> obterDistancia() {
        return distancia;
    }

    public void definirDistancia(Map<String, Integer> distancia) {
        this.distancia = distancia;
    }

    public Map<String, String> obterAnterior() {
        return anterior;
    }

    public void definirAnterior(Map<String, String> anterior) {
        this.anterior = anterior;
    }
}
