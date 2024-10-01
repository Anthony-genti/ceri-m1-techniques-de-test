package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class IPokedexFactoryTest {
    private IPokedexFactory factory;

    @BeforeEach
    public void setUp() {
        factory = Mockito.mock(IPokedexFactory.class);
    }

    @Test
    public void testCreatePokedex() {
        // Configure mock behavior
        IPokedex pokedex = Mockito.mock(IPokedex.class);
        Mockito.when(factory.createPokedex(Mockito.any(), Mockito.any())).thenReturn(pokedex);

        // Test the method
        IPokedex createdPokedex = factory.createPokedex(Mockito.mock(IPokemonMetadataProvider.class), Mockito.mock(IPokemonFactory.class));
        assertNotNull(createdPokedex);
    }
}