import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, Pokemon> pokemons = inicializarPokemonsPlayer1();

        Pokemon pokemonPlayer1 = seleccionarPokemon(scanner, pokemons);

        Pokemon pokemonMaquina = seleccionarPokemonMaquina(pokemons);


        batallaPokemon(pokemonPlayer1, pokemonMaquina);


    }

    private static void batallaPokemon(Pokemon pokemonPlayer1, Pokemon pokemonMaquina){
        System.out.println();
        System.out.println("========== INICIO DE LA BATALLA ==========");
        System.out.println("Player 1: " + pokemonPlayer1.getNombre());
        System.out.println("Rival: " + pokemonMaquina.getNombre());
        System.out.println("==========================================");

        String turno = "player1";

        Scanner scanner = new Scanner(System.in);

        while (pokemonPlayer1.hayVida() && pokemonMaquina.hayVida()){

            if (turno.equals("player1")) {

                Ataque ataqueElegido = elegirAtaque(scanner, pokemonPlayer1);

                System.out.println(
                        pokemonPlayer1.getNombre() +
                                " usa " +
                                ataqueElegido.getNombre() + "!"
                );

                pokemonMaquina.recibirDaño(ataqueElegido.getDaño());

                turno = "maquina";
            }else {

                Random random = new Random();

                int opcionAtaque = random.nextInt(2) + 1;

                Ataque ataqueMaquina;

                if (opcionAtaque == 1) {
                    ataqueMaquina = pokemonMaquina.getAtaque1();
                } else {
                    ataqueMaquina = pokemonMaquina.getAtaque2();
                }

                System.out.println(
                        pokemonMaquina.getNombre() +
                                "rival usa " +
                                ataqueMaquina.getNombre() + "!"
                );

                pokemonPlayer1.recibirDaño(ataqueMaquina.getDaño());

                turno = "player1";
            }
        }
        System.out.println("========== final DE LA BATALLA ==========");


    }

    private static Ataque elegirAtaque(Scanner scanner, Pokemon pokemon) {

        System.out.println();
        System.out.println("Elige un ataque:");
        System.out.println("1. " + pokemon.getAtaque1().getNombre());
        System.out.println("2. " + pokemon.getAtaque2().getNombre());

        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                return pokemon.getAtaque1();

            case 2:
                return pokemon.getAtaque2();

            default:
                System.out.println("Opción no válida. Elige de nuevo.");
                return elegirAtaque(scanner, pokemon);
        }
    }

    private static Pokemon seleccionarPokemonMaquina(
            HashMap<Integer, Pokemon> pokemons) {

        Random random = new Random();

        int opcion = random.nextInt(3) + 1;

        Pokemon pokemon = pokemons.get(opcion);

        System.out.println("Tu rival ha elegido a " + pokemon.getNombre());

        return pokemon;
    }
    private static Pokemon seleccionarPokemon(
            Scanner scanner,
            HashMap<Integer, Pokemon> pokemons) {

        System.out.println("Elige tu Pokémon:");
        System.out.println("1. Charmander");
        System.out.println("2. Wartortle");
        System.out.println("3. Bulbasaur");

        int opcion = scanner.nextInt();

        Pokemon pokemon = pokemons.get(opcion);

        if (pokemon != null) {
            System.out.println("Has elegido a " + pokemon.getNombre());
            return pokemon;
        }

        System.out.println("Opción no válida");
        return null;
    }
    private static HashMap<Integer, Pokemon> inicializarPokemonsPlayer1() {

        HashMap<Integer, Pokemon> pokemons = new HashMap<>();

        Pokemon charmander = new Pokemon(
                "Charmander",
                new Ataque("Ascuas", 10),
                new Ataque("Arañazo", 8),
                40
        );

        Pokemon wartortle = new Pokemon(
                "Wartortle",
                new Ataque("Pistola Agua", 10),
                new Ataque("Placaje", 8),
                40
        );

        Pokemon bulbasaur = new Pokemon(
                "Bulbasaur",
                new Ataque("Látigo Cepa", 10),
                new Ataque("Placaje", 8),
                40
        );

        pokemons.put(1, charmander);
        pokemons.put(2, wartortle);
        pokemons.put(3, bulbasaur);

        return pokemons;
    }
}
