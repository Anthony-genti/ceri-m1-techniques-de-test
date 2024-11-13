package fr.univavignon.pokedex.api;

import fr.univavignon.pokedex.api.IPokemonMetadataProvider;
import fr.univavignon.pokedex.api.PokemonMetadata;
import fr.univavignon.pokedex.api.PokedexException;

import java.util.HashMap;
import java.util.Map;

public class IPokemonMetadataProviderImpl implements IPokemonMetadataProvider {

    private static final Map<Integer, PokemonMetadata> POKEMON_METADATA = new HashMap<>();

    static {
        // Example data, you should replace this with actual Pokémon data
        POKEMON_METADATA.put(0, new PokemonMetadata(0, "Bulbizarre", 126, 126, 90));
        POKEMON_METADATA.put(133, new PokemonMetadata(133, "Aquali", 186, 168, 260));
        // Add more Pokémon metadata as needed
    }

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        if (!POKEMON_METADATA.containsKey(index)) {
            throw new PokedexException("Invalid Pokemon index");
        }
        return POKEMON_METADATA.get(index);
    }
}