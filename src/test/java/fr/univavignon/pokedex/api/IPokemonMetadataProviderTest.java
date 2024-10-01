package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class IPokemonMetadataProviderTest {
    private IPokemonMetadataProvider provider;

    @BeforeEach
    public void setUp() {
        provider = Mockito.mock(IPokemonMetadataProvider.class);
    }

    @Test
    public void testGetPokemonMetadata() throws PokedexException {
        // Configure mock behavior
        Mockito.when(provider.getPokemonMetadata(0)).thenReturn(new PokemonMetadata(0, "Bulbizarre", 126, 126, 90));
        Mockito.when(provider.getPokemonMetadata(133)).thenReturn(new PokemonMetadata(133, "Aquali", 186, 168, 260));

        // Test the method
        PokemonMetadata metadata1 = provider.getPokemonMetadata(0);
        assertNotNull(metadata1);
        assertEquals("Bulbizarre", metadata1.getName());

        PokemonMetadata metadata2 = provider.getPokemonMetadata(133);
        assertNotNull(metadata2);
        assertEquals("Aquali", metadata2.getName());
    }
}