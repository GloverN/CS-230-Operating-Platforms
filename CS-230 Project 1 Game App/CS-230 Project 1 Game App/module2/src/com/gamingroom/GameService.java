package com.gamingroom;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

/**
 * A singleton service for the game engine
 * 
 * @author coce@snhu.edu
 */
public class GameService {

	/**
	 * A list of the active games
	 */
	private static List<Game> games = new ArrayList<Game>();

	/*
	 * Holds the next game, team, and player identifiers
	 */
	private static long nextGameId = 1;
	private static long nextTeamId = 1;
	private static long nextPlayerId = 1;

	/**
	 * The purpose of using the singleton design on the GameService class is so
	 * that there's only one instance of a game active at any one time. That
	 * way resources are not wasted on running multiple unnecessary copies of
	 * games.
	 */
	private static GameService gameService;
	
	private GameService() {
		
	}
	
	public static GameService getInstance() {
		if (gameService == null) {
			gameService = new GameService();
		}
		else {
			System.out.println("Game Service is already open.");
		}
		return gameService;
	}


	/**
	 * Construct a new game instance
	 * 
	 * @param name the unique name of the game
	 * @return the game instance (new or existing)
	 */
	public Game addGame(String name) {

		// a local game instance
		Game game = null;

		/**
		 * I'm using this iterator pattern even though the only list structure
		 * being used is the ArrayList because this method can actively change
		 * the size of the list and because the type of list used to store the
		 * games could change. If it is changed, this method will still work
		 * as long as the structure used is iterable.
		 */
		// creates an iterator for the service's list of games
		Iterator<Game> itr = games.iterator();
		
		// while there are games in the list, loop through them
		while(itr.hasNext()) {
			Game temp = itr.next();
			
			// if the game is found, set the local game instance equal to it
			if (name.equals(temp.getName())) {
				game = temp;
				System.out.println(name + " is already running.");
			}
		}

		// if not found, make a new game instance and add to list of games
		if (game == null) {
			game = new Game(nextGameId++, name);
			games.add(game);
		}

		// return the new/existing game instance to the caller
		return game;
	}

	/**
	 * Returns the game instance at the specified index.
	 * <p>
	 * Scope is package/local for testing purposes.
	 * </p>
	 * @param index index position in the list to return
	 * @return requested game instance
	 */
	Game getGame(int index) {
		return games.get(index);
	}
	
	/**
	 * Returns the game instance with the specified id.
	 * 
	 * @param id unique identifier of game to search for
	 * @return requested game instance
	 */
	public Game getGame(long id) {

		// a local game instance
		Game game = null;

		/**
		 * I'm using this iterator pattern even though the only list structure
		 * being used is the ArrayList because the type of list used to store
		 * the games could change. If it is changed, this method will still
		 * work as long as the structure used is iterable.
		 */
		// creates an iterator for the service's list of games
		Iterator<Game> itr = games.iterator();
		
		// while there are games in the list, loop through them
		while(itr.hasNext()) {
			Game temp = itr.next();
			
			// if a game with a matching id is found, set the local game
			// instance equal to it
			if (id == temp.getId()) {
				game = temp;
			}
		}

		return game;
	}

	/**
	 * Returns the game instance with the specified name.
	 * 
	 * @param name unique name of game to search for
	 * @return requested game instance
	 */
	public Game getGame(String name) {

		// a local game instance
		Game game = null;

		/**
		 * I'm using this iterator pattern even though the only list structure
		 * being used is the ArrayList because the type of list used to store
		 * the games could change. If it is changed, this method will still
		 * work as long as the structure used is iterable.
		 */
		// creates an iterator for the service's list of games
		Iterator<Game> itr = games.iterator();
		
		// while there are games in the list, loop through them
		while(itr.hasNext()) {
			Game temp = itr.next();
			
			// if a game with a matching name is found, set the local game
			// instance equal to it
			if (name.equals(temp.getName())) {
				game = temp;
			}
		}

		return game;
	}

	/**
	 * Returns the number of games currently active
	 * 
	 * @return the number of games currently active
	 */
	public int getGameCount() {
		return games.size();
	}
	
	/*
	 * Returns the next player id number
	 * 
	 * @return the next player id number
	 */
	public long getNextPlayerId() {
		return nextPlayerId++;
	}
	
	/*
	 * Returns the next team id number
	 * 
	 * @return the next team id number
	 */
	public long getNextTeamId() {
		return nextTeamId++;
	}
}
