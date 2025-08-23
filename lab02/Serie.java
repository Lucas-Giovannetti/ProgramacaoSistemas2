import java.util.List;
import java.util.ArrayList;

public class Serie extends Midia {
    private List<Temporada> temporadas;

    public Serie(String nome){
        super("Titulo: " + nome);
        temporadas = new ArrayList<>();
    }

    public void adicionar(Temporada tp) {
        temporadas.add(tp);
    }

    public long getDuracao(){
        long duracao = 0;
        for (int i = 0; i < temporadas.size(); i++) {
            duracao += temporadas.get(i).getDuracao();
        }
        return duracao;
    }

    public String info(){
        return "Serie: " + super.info() + "; Duração: " + getDuracao();
    }
}   