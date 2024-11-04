package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class IPokemonFactoryTest {
    private IPokemonFactory factory;

    @BeforeEach
    public void setUp() {
        factory = Mockito.mock(IPokemonFactory.class);
    }

    @Test
    public void testCreatePokemon() {
        // Configure mock behavior
        Mockito.when(factory.createPokemon(0, 613, 64, 4000, 4)).thenReturn(new Pokemon(0, "Bulbizarre", 613, 64, 4000, 4, 126, 126, 90, 56));
        Mockito.when(factory.createPokemon(133, 2729, 202, 5000, 4)).thenReturn(new Pokemon(133, "Aquali", 2729, 202, 5000, 4, 186, 168, 260, 100));

        // Test the method
        Pokemon pokemon1 = factory.createPokemon(0, 613, 64, 4000, 4);
        assertNotNull(pokemon1);
        assertEquals("Bulbizarre", pokemon1.getName());

        Pokemon pokemon2 = factory.createPokemon(133, 2729, 202, 5000, 4);
        assertNotNull(pokemon2);
        assertEquals("Aquali", pokemon2.getName());
    }

    @Test
    public void testPokemonConstructorAndGetters() {
        // Create a Pokemon instance
        int index = 1;
        String name = "Bulbasaur";
        int attack = 49;
        int defense = 49;
        int stamina = 45;
        int cp = 300;
        int hp = 60;
        int dust = 4000;
        int candy = 3;
        double iv = 56.0;

        Pokemon pokemon = new Pokemon(index, name, attack, defense, stamina, cp, hp, dust, candy, iv);

        // Test the getters
        assertEquals(index, pokemon.getIndex());
        assertEquals(name, pokemon.getName());
        assertEquals(attack, pokemon.getAttack());
        assertEquals(defense, pokemon.getDefense());
        assertEquals(stamina, pokemon.getStamina());
        assertEquals(cp, pokemon.getCp());
        assertEquals(hp, pokemon.getHp());
        assertEquals(dust, pokemon.getDust());
        assertEquals(candy, pokemon.getCandy());
        assertEquals(iv, pokemon.getIv(), 0.01);
    }

    @Test
    public void testPokemonTrainerConstructorAndGetters() {
        // Create a PokemonTrainer instance
        String trainerName = "Ash";
        Team team = Team.VALOR;
        IPokedex trainerPokedex = Mockito.mock(IPokedex.class);

        PokemonTrainer trainer = new PokemonTrainer(trainerName, team, trainerPokedex);

        // Test the getters
        assertEquals(trainerName, trainer.getName());
        assertEquals(team, trainer.getTeam());
        assertEquals(trainerPokedex, trainer.getPokedex());
    }
}