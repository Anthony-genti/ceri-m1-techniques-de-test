package fr.univavignon.pokedex.api;

public class PokemonMetadata {
	private final int index;
	private final String name;
	private final int attack;
	private final int defense;
	private final int stamina;

	public PokemonMetadata(int index, String name, int attack, int defense, int stamina) {
		this.index = index;
		this.name = name;
		this.attack = attack;
		this.defense = defense;
		this.stamina = stamina;
	}

	public int getIndex() {
		return index;
	}

	public String getName() {
		return name;
	}

	public int getAttack() {
		return attack;
	}

	public int getDefense() {
		return defense;
	}

	public int getStamina() {
		return stamina;
	}
}