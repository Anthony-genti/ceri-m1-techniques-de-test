package fr.univavignon.pokedex.api;

public class IPokemonTrainerFactoryImpl implements IPokemonTrainerFactory {

    @Override
    public PokemonTrainer createTrainer(String name, Team team, IPokedexFactory pokedexFactory) {
        // Create a new Pokedex instance using the provided factory
        IPokedex pokedex = pokedexFactory.createPokedex(new IPokemonMetadataProviderImpl(), new IPokemonFactoryImpl());

        // Create and return a new PokemonTrainer instance
        return new PokemonTrainer(name, team, pokedex);
    }
}