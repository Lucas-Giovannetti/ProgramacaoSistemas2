import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class AppStreaming{
    private static Scanner sca = new Scanner(System.in);
    private static List<Midia> midias = new ArrayList<>();
    public static void main (String[] args){
       int opcao = 5;       
        
	    while (opcao != 0) {
            System.out.println("(1) Adicionar novo Filme.");
            System.out.println("(2) Adicionar nova Série.");
            System.out.println("(3) Listar todas as mídias.");
            System.out.println("(4) Sair.");
		    opcao = sca.nextInt();
		switch (opcao) {
		case 1: 
            adicionarFilme();
            break;
		case 2:
			adicionarSerie();
            break;
		case 3:
			listarMidias();
            break;
		case 4:
			break;
		default: System.out.println ("Resposta inválida");
			break;
		}
    }
}

 private static void adicionarFilme() {
        System.out.println("Título do filme: ");
        String titulo = sca.next();
        System.out.println("Duração: ");
        int duracao = sca.nextInt();

        Filme f = new Filme(titulo, duracao);
        midias.add(f);
    }
    private static void adicionarSerie() {
        System.out.println("Título da série: ");
        String titulo = sca.next();

        Serie s = new Serie(titulo);

        for (int i = 0; i < 2; i++) {
            Temporada t = new Temporada(i);
            for (int j = 0; j < 2; j++) {
                System.out.println("Episódio " + (j + 1) + " à Temporada " + (i + 1));
                System.out.print("  Título do episódio: ");
                String tituloEpisodio = sca.nextLine();
                System.out.print("  Duração do episódio: ");
                int duracaoEpisodio = sca.nextInt();
                sca.nextLine();

                Episodio e = new Episodio(tituloEpisodio, duracaoEpisodio);
                t.adicionar(e);
            }
            s.adicionar(t);
        }

        midias.add(s);
        System.out.println("Série adicionada com sucesso!");
    }

    private static void listarMidias() {
        if (midias.isEmpty()) {
            System.out.println("Nenhuma mídia cadastrada.");
        } else {
            for (Midia midia : midias) {
                System.out.println(midia.toString());
            }
        }
    }
}