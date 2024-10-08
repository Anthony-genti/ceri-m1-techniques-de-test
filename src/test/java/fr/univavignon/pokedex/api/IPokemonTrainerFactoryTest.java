package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class IPokemonTrainerFactoryTest {
    private IPokemonTrainerFactory factory;

    @BeforeEach
    public void setUp() {
        factory = Mockito.mock(IPokemonTrainerFactory.class);
    }

    @Test
    public void testCreateTrainer() {
        // Configure mock behavior
        IPokedex pokedex = Mockito.mock(IPokedex.class);
        PokemonTrainer trainer = new PokemonTrainer("Ash",Team.VALOR, pokedex);
        Mockito.when(factory.createTrainer("Ash", Team.VALOR, Mockito.mock(IPokedexFactory.class))).thenReturn(trainer);

        // Test the method
        PokemonTrainer createdTrainer = factory.createTrainer("Ash", Team.VALOR, Mockito.mock(IPokedexFactory.class));
        assertNotNull(createdTrainer);
        assertEquals("Ash", createdTrainer.getName());
    }
}