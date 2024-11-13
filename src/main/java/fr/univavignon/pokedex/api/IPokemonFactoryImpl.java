package fr.univavignon.pokedex.api;

import java.util.Random;


public class IPokemonFactoryImpl implements IPokemonFactory {

    private IPokemonMetadataProvider metadataProvider;

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        // Retrieve the base stats for the Pokémon species
        PokemonMetadata metadata;
        try {
            metadata = metadataProvider.getPokemonMetadata(index);
        } catch (PokedexException e) {
            throw new RuntimeException("Failed to retrieve Pokémon metadata", e);
        }


        Random random = new Random();
        int ivAttack = random.nextInt(16);
        int ivDefense = random.nextInt(16);
        int ivStamina = random.nextInt(16);

        // Calculate the final stats
        int attack = metadata.getAttack() + ivAttack;
        int defense = metadata.getDefense() + ivDefense;
        int stamina = metadata.getStamina() + ivStamina;

        // Calculate IV perfection percentage
        double ivPercentage = ((ivAttack + ivDefense + ivStamina) / 45.0) * 100;

        // Create and return the Pokémon instance
        return new Pokemon(index, metadata.getName(), attack, defense, stamina, cp, hp, dust, candy, ivPercentage);
    }
}