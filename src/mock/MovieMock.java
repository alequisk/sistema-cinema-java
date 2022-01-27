package mock;

import Models.Movie;

import java.util.ArrayList;
import java.util.Random;

public class MovieMock {
    private final Random rnd = new Random();
    private final ArrayList<Integer> ages;
    private final ArrayList<String> movies;

    public MovieMock() {
        // List of ages mock
        ages = new ArrayList<>();
        ages.add(0);
        ages.add(10);
        ages.add(12);
        ages.add(14);
        ages.add(16);
        ages.add(18);

        // List of movies names
        movies = new ArrayList<>();
        movies.add("Capitão América: O Primeiro Vingador");
        movies.add("Capitã Marvel");
        movies.add("Homem de Ferro");
        movies.add("O Incrível Hulk");
        movies.add("Homem de Ferro 2");
        movies.add("Thor");
        movies.add("Os Vingadores");
        movies.add("Homem de Ferro 3");
        movies.add("Thor: O Mundo Sombrio");
        movies.add("Capitão América 2 - O Soldado Invernal");
        movies.add("Guardiões da Galáxia");
        movies.add("Guardiões da Galáxia Vol. 2");
        movies.add("Vingadores: Era de Ultron");
        movies.add("Homem-Formiga");
        movies.add("Capitão América: Guerra Civil");
        movies.add("Viúva Negra (excluindo cena pós-créditos)");
        movies.add("Homem-Aranha: De Volta ao Lar");
        movies.add("Doutor Estranho");
        movies.add("Pantera Negra");
        movies.add("Thor: Ragnarok");
        movies.add("Homem-Formiga e a Vespa");
        movies.add("Vingadores: Guerra Infinita");
        movies.add("Vingadores: Ultimato");
        movies.add("WandaVision");
        movies.add("Falcão e o Soldado Invernal");
        movies.add("Homem-Aranha: Longe de Casa");
        movies.add("Homem-Aranha: Sem Volta para Casa");
        movies.add("Eternos");
        movies.add("Shang-Chi e a Lenda dos Dez Anéis");
        movies.add("Gavião Arqueiro ");
    }

    public Movie generate() {
        int ageIndex = rnd.nextInt(ages.size());
        int movieIndex = rnd.nextInt(movies.size());
        Integer age = ages.get(ageIndex);
        return new Movie(movies.get(movieIndex), age != 0, age);
    }


}
