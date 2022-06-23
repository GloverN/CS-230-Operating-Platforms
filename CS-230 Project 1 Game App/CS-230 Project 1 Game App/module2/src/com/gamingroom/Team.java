package com.gamingroom;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;


/**
 * A simple class to hold information about a team
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a team is
 * created.
 * </p>
 * @author coce@snhu.edu
 *
 */
public class Team extends Entity{
	private static List<Player> players = new ArrayList<Player>();
	/*
	 * Constructor with an identifier and name
	 */
	public Team(long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Player addPlayer(String name) {
		// a local player instance
		Player player = null;
		
		/**
		 * I'm using this iterator pattern even though the only list structure
		 * being used is the ArrayList because this method can actively change
		 * the size of the list and because the type of list used to store the
		 * players could change. If it is changed, this method will still work
		 * as long as the structure used is iterable.
		 */
		// creates an iterator for the team's list of players
		Iterator<Player> itr = players.iterator();
		
		// while there are players in the list, loop through them
		while(itr.hasNext()) {
			Player temp = itr.next();
			
			// if the player is found, set the local player instance equal to it
			if (name.equals(temp.getName())) {
				player = temp;
				System.out.println(name + " is already on the team.");
			}
		}
		
		// if not found, make a new player instance and add to list of players
		if (player == null) {
			GameService serv = GameService.getInstance();
			player = new Player(serv.getNextPlayerId(), name);
			players.add(player);
		}
		
		// return the new/existing player instance to the caller
		return player;
	}

	@Override
	public String toString() {
		return "Team [id=" + id + ", name=" + name + "]";
	}
}
