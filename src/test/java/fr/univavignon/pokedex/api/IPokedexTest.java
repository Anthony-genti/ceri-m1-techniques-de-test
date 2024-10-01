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
}