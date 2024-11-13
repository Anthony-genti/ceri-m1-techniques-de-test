package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class IPokemonTrainerFactoryTest {
    private IPokemonTrainerFactory factory;

    @BeforeEach
    public void setUp() {
        factory = new IPokemonTrainerFactoryImpl();
    }

    @Test
    public void testCreateTrainer() {
        IPokedexFactory pokedexFactory = new IPokedexFactoryImpl();
        PokemonTrainer trainer = factory.createTrainer("Ash", Team.VALOR, pokedexFactory);
        assertNotNull(trainer);
        assertEquals("Ash", trainer.getName());
        assertEquals(Team.VALOR, trainer.getTeam());
        assertNotNull(trainer.getPokedex());
        assertTrue(trainer.getPokedex() instanceof IPokedexImpl);
    }
}