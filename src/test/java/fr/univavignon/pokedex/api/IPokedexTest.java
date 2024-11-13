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
        pokedex.addPokemon(new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56.0));
        assertEquals(1, pokedex.size());
    }

    @Test
    public void testAddPokemon() {
        int index = pokedex.addPokemon(new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56.0));
        assertEquals(0, index);
    }

    @Test
    public void testGetPokemon() throws PokedexException {
        pokedex.addPokemon(new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56.0));
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
        pokedex.addPokemon(new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56.0));
        List<Pokemon> pokemons = pokedex.getPokemons();
        assertEquals(1, pokemons.size());
    }

    @Test
    public void testGetPokemonsWithOrder() {
        pokedex.addPokemon(new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56.0));
        pokedex.addPokemon(new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100.0));
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
        Pokemon pokemon1 = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56.0);
        Pokemon pokemon2 = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100.0);

        // Test NAME comparator
        assertTrue(PokemonComparators.NAME.compare(pokemon2, pokemon1) < 0, "Expected Aquali to be less than Bulbizarre by name");
        assertTrue(PokemonComparators.NAME.compare(pokemon1, pokemon2) > 0, "Expected Bulbizarre to be greater than Aquali by name");
        assertEquals(0, PokemonComparators.NAME.compare(pokemon1, pokemon1), "Expected same Pokemon names to be equal");

        // Test INDEX comparator
        assertTrue(PokemonComparators.INDEX.compare(pokemon1, pokemon2) < 0, "Expected index 0 to be less than index 133");
        assertTrue(PokemonComparators.INDEX.compare(pokemon2, pokemon1) > 0, "Expected index 133 to be greater than index 0");
        assertEquals(0, PokemonComparators.INDEX.compare(pokemon1, pokemon1), "Expected same Pokemon indices to be equal");

        // Test CP comparator
        assertTrue(PokemonComparators.CP.compare(pokemon1, pokemon2) < 0, "Expected CP 613 to be less than CP 2729");
        assertTrue(PokemonComparators.CP.compare(pokemon2, pokemon1) > 0, "Expected CP 2729 to be greater than CP 613");
        assertEquals(0, PokemonComparators.CP.compare(pokemon1, pokemon1), "Expected same Pokemon CPs to be equal");
    }

    @Test
    public void testPokemonGetters() {
        Pokemon pokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56.0);
        assertEquals(64, pokemon.getHp());
        assertEquals(4000, pokemon.getDust());
        assertEquals(4, pokemon.getCandy());
        assertEquals(56.0, pokemon.getIv());
    }
}