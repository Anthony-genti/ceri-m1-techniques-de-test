package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class IPokedexFactoryTest {
    private IPokedexFactory factory;
    private IPokemonMetadataProvider metadataProvider;
    private IPokemonFactory pokemonFactory;

    @BeforeEach
    public void setUp() {
        factory = new IPokedexFactoryImpl();
        metadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
        pokemonFactory = Mockito.mock(IPokemonFactory.class);
    }

    @Test
    public void testCreatePokedex() {
        IPokedex pokedex = factory.createPokedex(metadataProvider, pokemonFactory);
        assertNotNull(pokedex);
        assertTrue(pokedex instanceof IPokedexImpl);
    }

    @Test
    public void testCreatePokedexWithRealImplementations() {
        IPokemonMetadataProvider realMetadataProvider = new IPokemonMetadataProviderImpl();
        IPokemonFactory realPokemonFactory = new IPokemonFactoryImpl(realMetadataProvider);
        IPokedex pokedex = factory.createPokedex(realMetadataProvider, realPokemonFactory);
        assertNotNull(pokedex);
        assertTrue(pokedex instanceof IPokedexImpl);
    }
}