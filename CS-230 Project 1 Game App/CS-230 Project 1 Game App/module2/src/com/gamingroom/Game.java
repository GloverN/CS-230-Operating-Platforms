package com.gamingroom;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;


/**
 * A simple class to hold information about a game
 * 
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a game is
 * created.
 * </p>
 * 
 * @author coce@snhu.edu
 *
 */
public class Game extends Entity{
	private static List<Team> teams = new ArrayList<Team>();
	
	/**
	 * Constructor with an identifier and name
	 */
	public Game(long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Team addTeam(String name) {
		// a local team instance
		Team team = null;
		
		/**
		 * I'm using this iterator pattern even though the only list structure
		 * being used is the ArrayList because this method can actively change
		 * the size of the list and because the type of list used to store the
		 * teams could change. If it is changed, this method will still work
		 * as long as the structure used is iterable.
		 */
		// creates an iterator for the game's list of teams
		Iterator<Team> itr = teams.iterator();
		
		// while there are teams in the list, loop through them
		while(itr.hasNext()) {
			Team temp = itr.next();
			
			// if the team is found, set the local team instance equal to it
			if (name.equals(temp.getName())) {
				team = temp;
				System.out.println(name + " is already in the game.");
			}
		}
		
		// if not found, make a new team instance and add to list of teams
		if (team == null) {
			GameService serv = GameService.getInstance();
			team = new Team(serv.getNextTeamId(), name);
			teams.add(team);
		}
		
		// return the new/existing team instance to the caller
		return team;
	}
	
	@Override
	public String toString() {
		
		return "Game [id=" + id + ", name=" + name + "]";
	}

}
