package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class IPokedexTest {
    private IPokedex pokedex;

    @BeforeEach
    public void setUp() {
        IPokemonMetadataProvider metadataProvider = new IPokemonMetadataProviderImpl();
        IPokemonFactory pokemonFactory = new IPokemonFactoryImpl(metadataProvider);
        pokedex = new IPokedexImpl(metadataProvider, pokemonFactory);
    }

    @Test
    public void testSize() {
        assertEquals(0, pokedex.size());
        pokedex.addPokemon(new Pokemon(0, "Bulbizarre", 613, 64, 4000, 4, 126, 126, 90, 56));
        assertEquals(1, pokedex.size());
    }

    @Test
    public void testAddPokemon() {
        int index = pokedex.addPokemon(new Pokemon(0, "Bulbizarre", 613, 64, 4000, 4, 126, 126, 90, 56));
        assertEquals(0, index);
    }

    @Test
    public void testGetPokemon() throws PokedexException {
        pokedex.addPokemon(new Pokemon(0, "Bulbizarre", 613, 64, 4000, 4, 126, 126, 90, 56));
        Pokemon pokemon = pokedex.getPokemon(0);
        assertNotNull(pokemon);
        assertEquals("Bulbizarre", pokemon.getName());
    }

    @Test
    public void testGetPokemonInvalidIndex() {
        assertThrows(PokedexException.class, () -> pokedex.getPokemon(1));
    }

    @Test
    public void testGetPokemonNegativeIndex() {
        assertThrows(PokedexException.class, () -> pokedex.getPokemon(-1));
    }

    @Test
    public void testGetPokemons() {
        pokedex.addPokemon(new Pokemon(0, "Bulbizarre", 613, 64, 4000, 4, 126, 126, 90, 56));
        List<Pokemon> pokemons = pokedex.getPokemons();
        assertEquals(1, pokemons.size());
    }

    @Test
    public void testGetPokemonsWithOrder() {
        pokedex.addPokemon(new Pokemon(0, "Bulbizarre", 613, 64, 4000, 4, 126, 126, 90, 56));
        pokedex.addPokemon(new Pokemon(133, "Aquali", 2729, 202, 5000, 4, 186, 168, 260, 100));
        List<Pokemon> pokemons = pokedex.getPokemons(Comparator.comparing(Pokemon::getName));
        assertEquals("Aquali", pokemons.get(0).getName());
        assertEquals("Bulbizarre", pokemons.get(1).getName());
    }

    @Test
    public void testGetPokemonMetadata() throws PokedexException {
        PokemonMetadata metadata = pokedex.getPokemonMetadata(0);
        assertNotNull(metadata);
        assertEquals("Bulbizarre", metadata.getName());
    }

    @Test
    public void testCreatePokemon() {
        Pokemon pokemon = pokedex.createPokemon(0, 613, 64, 4000, 4);
        assertNotNull(pokemon);
        assertEquals("Bulbizarre", pokemon.getName());
    }

    @Test
    public void testPokedexException() {
        String errorMessage = "This is a test error message";
        PokedexException exception = new PokedexException(errorMessage);

        assertNotNull(exception);
        assertEquals(errorMessage, exception.getMessage());
    }

    @Test
    public void testPokemonTrainerConstructorAndGetters() {
        String trainerName = "Ash";
        Team team = Team.VALOR;
        IPokedex trainerPokedex = Mockito.mock(IPokedex.class);

        PokemonTrainer trainer = new PokemonTrainer(trainerName, team, trainerPokedex);

        assertEquals(trainerName, trainer.getName());
        assertEquals(team, trainer.getTeam());
        assertEquals(trainerPokedex, trainer.getPokedex());
    }

    @Test
    public void testPokemonComparators() {
        Pokemon pokemon1 = new Pokemon(0, "Bulbizarre", 126, 126, 90, 300, 613, 4000, 4, 56.0);
        Pokemon pokemon2 = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100.0);

        assertTrue(PokemonComparators.NAME.compare(pokemon1, pokemon2) < 0);
        assertTrue(PokemonComparators.NAME.compare(pokemon2, pokemon1) > 0);
        assertEquals(0, PokemonComparators.NAME.compare(pokemon1, pokemon1));

        assertTrue(PokemonComparators.INDEX.compare(pokemon1, pokemon2) < 0);
        assertTrue(PokemonComparators.INDEX.compare(pokemon2, pokemon1) > 0);
        assertEquals(0, PokemonComparators.INDEX.compare(pokemon1, pokemon1));

        assertTrue(PokemonComparators.CP.compare(pokemon1, pokemon2) < 0);
        assertTrue(PokemonComparators.CP.compare(pokemon2, pokemon1) > 0);
        assertEquals(0, PokemonComparators.CP.compare(pokemon1, pokemon1));
    }

    @Test
    public void testPokemonGetters() {
        Pokemon pokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 300, 613, 4000, 4, 56.0);
        assertEquals(90, pokemon.getHp());
        assertEquals(4000, pokemon.getDust());
        assertEquals(4, pokemon.getCandy());
        assertEquals(56.0, pokemon.getIv());
    }
}