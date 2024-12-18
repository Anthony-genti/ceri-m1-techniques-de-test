package fr.univavignon.pokedex.api;

/**
 * Trainer POJO.
 * 
 * @author fv
 */
public class PokemonTrainer {

	/** Trainer name. **/
	private final String name;

	/** Trainer team. **/
	private final Team team;
	
	/** Trainer pokedex. **/
	private final IPokedex pokedex;
	
	/**
	 * Default constructor.
	 * 
	 * @param name Trainer name.
	 * @param team Trainer team.
	 * @param pokedex Trainer pokedex.
	 */
	public PokemonTrainer(final String name, final Team team, final IPokedex pokedex) {
		this.name = name;
		this.team = team;
		this.pokedex = pokedex;
	}

	/**
	 * Returns the IV (Individual Value) of the Pokemon.
	 *
	 * @return IV of the Pokemon.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the team of the trainer.
	 *
	 * @return Team of the trainer.
	 */
	public Team getTeam() {
		return team;
	}

	/**
	 * Returns the Pokedex of the trainer.
	 *
	 * @return Pokedex of the trainer.
	 */
	public IPokedex getPokedex() {
		return pokedex;
	}
	
}
