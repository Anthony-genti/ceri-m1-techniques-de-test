package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class IPokemonFactoryTest {
    private IPokemonFactory factory;
    private IPokemonMetadataProvider metadataProvider;

    @BeforeEach
    public void setUp() throws PokedexException {
        metadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
        factory = new IPokemonFactoryImpl(metadataProvider);

        // Mock the metadataProvider to return valid metadata for the test cases
        Mockito.when(metadataProvider.getPokemonMetadata(0)).thenReturn(new PokemonMetadata(0, "Bulbizarre", 126, 126, 90));
        Mockito.when(metadataProvider.getPokemonMetadata(133)).thenReturn(new PokemonMetadata(133, "Aquali", 186, 168, 260));
    }

    @Test
    public void testCreatePokemon() throws PokedexException {
        Pokemon pokemon1 = factory.createPokemon(0, 613, 64, 4000, 4);
        assertNotNull(pokemon1);
        assertEquals("Bulbizarre", pokemon1.getName());

        Pokemon pokemon2 = factory.createPokemon(133, 2729, 202, 5000, 4);
        assertNotNull(pokemon2);
        assertEquals("Aquali", pokemon2.getName());
    }
}