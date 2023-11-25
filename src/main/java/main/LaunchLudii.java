package main;

import app.StartDesktopApp;
import manager.ai.AIRegistry;
import ludii_python_ai.LudiiPythonAI;

import game.Game;
import other.GameLoader;

/**
 * The main method of this launches the Ludii application with its GUI, and registers
 * the example AIs from this project such that they are available inside the GUI.
 *
 * @author Dennis Soemers
 */
public class LaunchLudii
{
	
	/**
	 * The main method
	 * @param args
	 */
    
	public static void main(final String[] args)
	{
                if (!AIRegistry.registerAI("UTCpy", () -> {return new LudiiPythonAI();}, (game) -> {return new LudiiPythonAI().supportsGame(game);}))
			System.err.println("WARNING! Failed to register AI because one with that name already existed!");
                
                final Game game = GameLoader.loadGameFromName("Chess.lud");
                
		// Run Ludii
		StartDesktopApp.main(new String[0]);
	}

}
