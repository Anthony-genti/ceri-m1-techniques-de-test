package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IPokemonMetadataProviderTest {
    private IPokemonMetadataProvider provider;

    @BeforeEach
    public void setUp() {
        provider = new IPokemonMetadataProviderImpl();
    }

    @Test
    public void testGetPokemonMetadata() throws PokedexException {
        // Use valid indices for the test cases
        PokemonMetadata metadata1 = provider.getPokemonMetadata(0); // Assuming 0 is a valid index
        assertNotNull(metadata1);
        assertEquals("Bulbizarre", metadata1.getName());

        PokemonMetadata metadata2 = provider.getPokemonMetadata(133); // Assuming 133 is a valid index
        assertNotNull(metadata2);
        assertEquals("Aquali", metadata2.getName());
    }

    @Test
    public void testGetPokemonMetadataInvalidIndex() {
        // Use an invalid index for the test case
        int invalidIndex = -1; // Assuming -1 is an invalid index
        assertThrows(PokedexException.class, () -> provider.getPokemonMetadata(invalidIndex));
    }
}