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
        IPokedexFactory pokedexFactory = Mockito.mock(IPokedexFactory.class);
        IPokedex pokedex = Mockito.mock(IPokedex.class);
        Mockito.when(pokedexFactory.createPokedex(Mockito.any(), Mockito.any())).thenReturn(pokedex);

        PokemonTrainer trainer = new PokemonTrainer("Ash", Team.VALOR, pokedex);
        Mockito.when(factory.createTrainer("Ash", Team.VALOR, pokedexFactory)).thenReturn(trainer);

        // Test the method
        PokemonTrainer createdTrainer = factory.createTrainer("Ash", Team.VALOR, pokedexFactory);
        assertNotNull(createdTrainer);
        assertEquals("Ash", createdTrainer.getName());
    }
}