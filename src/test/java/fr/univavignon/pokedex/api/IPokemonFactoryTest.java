package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class IPokemonFactoryTest {
    private IPokemonFactory factory;

    @BeforeEach
    public void setUp() {
        factory = Mockito.mock(IPokemonFactory.class);
    }

    @Test
    public void testCreatePokemon() {
        // Configure mock behavior
        Mockito.when(factory.createPokemon(0, 613, 64, 4000, 4)).thenReturn(new Pokemon(0, "Bulbizarre", 613, 64, 4000, 4, 126, 126, 90, 56));
        Mockito.when(factory.createPokemon(133, 2729, 202, 5000, 4)).thenReturn(new Pokemon(133, "Aquali", 2729, 202, 5000, 4, 186, 168, 260, 100));

        // Test the method
        Pokemon pokemon1 = factory.createPokemon(0, 613, 64, 4000, 4);
        assertNotNull(pokemon1);
        assertEquals("Bulbizarre", pokemon1.getName());

        Pokemon pokemon2 = factory.createPokemon(133, 2729, 202, 5000, 4);
        assertNotNull(pokemon2);
        assertEquals("Aquali", pokemon2.getName());
    }
}