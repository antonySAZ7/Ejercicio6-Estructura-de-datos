import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
// Esta clase es para hacer pruebas unitarias
public class PrincipalTest {

    @Test
    void testAgregarPokemonUsuario(){
        Map<String, Pokemon> pokemontipoMap = new HashMap<>();
        Pokemon bulbasaur = new Pokemon("Bulbasaur", "1", "Grass", "Poison", "Seed Pokémon", "0.7", "6.9", "Overgrow", "1", "No");
        pokemontipoMap.put(bulbasaur.getName(), bulbasaur);

        Set<Pokemon> pokemonesPropio = new LinkedHashSet<>();
        pokemonesPropio.add(pokemontipoMap.get("Bulbasaur"));
        assertEquals(1, pokemonesPropio.size(), "La coleccion del usuario deberia teniene un pokemon");
        pokemonesPropio.add(pokemontipoMap.get("Bulbasaur"));
        assertEquals(1, pokemonesPropio.size(), "La coleccion del usuario deberia tener solo un pokemon, no deberia duplicarse");

    }

    @Test
    void testBuscarPokemon(){
        Map<String, Pokemon> pokemontipoMap = new HashMap<>();
        Pokemon charmander = new Pokemon("Charmander", "4", "Fire", "", "Lizard Pokémon", "0.6", "8.5", "Blaze", "1", "No");
        pokemontipoMap.put(charmander.getName(), charmander);

        Pokemon encontrado = pokemontipoMap.get("Charmander");
        assertNotNull(encontrado, "El pokemon Charmander deberia existir en la base de datos");
        assertEquals("Charmander", encontrado.getName(), "El nombre del pokemon deberia ser Charmander");
        assertEquals("Fire", encontrado.getType1(), "El tipo del pokemon deberia ser Fire");

    }

}