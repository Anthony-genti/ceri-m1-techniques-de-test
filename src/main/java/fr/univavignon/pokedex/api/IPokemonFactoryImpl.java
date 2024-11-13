package fr.univavignon.pokedex.api;

public class IPokemonFactoryImpl implements IPokemonFactory {
    private final IPokemonMetadataProvider metadataProvider;

    public IPokemonFactoryImpl(IPokemonMetadataProvider metadataProvider) {
        this.metadataProvider = metadataProvider;
    }

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        try {
            PokemonMetadata metadata = metadataProvider.getPokemonMetadata(index);
            return new Pokemon(index, metadata.getName(), metadata.getAttack(), metadata.getDefense(), metadata.getStamina(), cp, hp, dust, candy, calculateIv(metadata));
        } catch (PokedexException e) {
            e.printStackTrace();
            return null;
        }
    }

    private double calculateIv(PokemonMetadata metadata) {
        // Implement IV calculation logic here
        return 0.0;
    }
}