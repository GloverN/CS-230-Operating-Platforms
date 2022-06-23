package com.gamingroom;

/**
 * Application start-up program
 * 
 * @author coce@snhu.edu
 */
public class ProgramDriver {
	
	/**
	 * The one-and-only main() method
	 * 
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		
		GameService service = GameService.getInstance();
		
		System.out.println("\nAbout to test initializing game data...");
		
		// initialize with some game data
		Game game1 = service.addGame("Game #1");
		System.out.println(game1);
		Game game2 = service.addGame("Game #2");
		System.out.println(game2);
		game1.addTeam("Strikers").addPlayer("James");
		game1.addTeam("Strikers").addPlayer("James");
		game1.addTeam("Strikers").addPlayer("John");
		game1.addTeam("Warriors").addPlayer("John");
		game1.addTeam("Warriors").addPlayer("Jacob");
		game1.addTeam("Warriors").addPlayer("Jingleheimer");
		
		// use another class to prove there is only one instance
		SingletonTester tester = new SingletonTester();
		tester.testSingleton();
	}
}
