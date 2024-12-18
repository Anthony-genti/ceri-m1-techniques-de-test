package fr.univavignon.pokedex.api;

/**
 * An IPokemonMetadataProvider aims to provide PokemonMetadata
 * for a given pokemon index.
 * 
 * @author fv
 */
public interface IPokemonMetadataProvider {

	/**
	 * Retrieves and returns the metadata for the Pokemon denoted by the given <code>index</code>.
	 *
	 * @param index Index of the Pokemon to retrieve metadata for.
	 * @return Metadata of the Pokemon denoted by the given index.
	 * @throws PokedexException If the given <code>index</code> is not valid.
	 */
	PokemonMetadata getPokemonMetadata(int index) throws PokedexException;
}
