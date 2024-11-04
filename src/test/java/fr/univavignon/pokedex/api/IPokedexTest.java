package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class IPokedexTest {
    private IPokedex pokedex;

    @BeforeEach
    public void setUp() {
        pokedex = Mockito.mock(IPokedex.class);
    }

    @Test
    public void testAddPokemon() {
        // Configure mock behavior
        Pokemon pokemon = new Pokemon(0, "Bulbizarre", 613, 64, 4000, 4, 126, 126, 90, 56);
        Mockito.when(pokedex.addPokemon(pokemon)).thenReturn(0);

        // Test the method
        int index = pokedex.addPokemon(pokemon);
        assertEquals(0, index);
    }

    @Test
    public void testPokedexException() {
        String errorMessage = "This is a test error message";
        PokedexException exception = new PokedexException(errorMessage);

        assertNotNull(exception);
        assertEquals(errorMessage, exception.getMessage());
    }

    @Test
    public void testPokemonTrainerConstructorAndGetters() {
        // Create a PokemonTrainer instance
        String trainerName = "Ash";
        Team team = Team.VALOR;
        IPokedex trainerPokedex = Mockito.mock(IPokedex.class);

        PokemonTrainer trainer = new PokemonTrainer(trainerName, team, trainerPokedex);

        // Test the getters
        assertEquals(trainerName, trainer.getName());
        assertEquals(team, trainer.getTeam());
        assertEquals(trainerPokedex, trainer.getPokedex());
    }

    @Test
    public void testPokemonComparators() {
        // Create Pokemon instances
        Pokemon pokemon1 = new Pokemon(1, "Bulbasaur", 49, 49, 45, 300, 60, 4000, 3, 56.0);
        Pokemon pokemon2 = new Pokemon(2, "Ivysaur", 62, 63, 60, 400, 80, 5000, 5, 70.0);

        // Test NAME comparator
        assertTrue(PokemonComparators.NAME.compare(pokemon1, pokemon2) < 0);
        assertTrue(PokemonComparators.NAME.compare(pokemon2, pokemon1) > 0);
        assertEquals(0, PokemonComparators.NAME.compare(pokemon1, pokemon1));

        // Test INDEX comparator
        assertTrue(PokemonComparators.INDEX.compare(pokemon1, pokemon2) < 0);
        assertTrue(PokemonComparators.INDEX.compare(pokemon2, pokemon1) > 0);
        assertEquals(0, PokemonComparators.INDEX.compare(pokemon1, pokemon1));

        // Test CP comparator
        assertTrue(PokemonComparators.CP.compare(pokemon1, pokemon2) < 0);
        assertTrue(PokemonComparators.CP.compare(pokemon2, pokemon1) > 0);
        assertEquals(0, PokemonComparators.CP.compare(pokemon1, pokemon1));
    }
}