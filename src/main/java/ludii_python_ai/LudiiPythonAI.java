package ludii_python_ai;

import game.Game;
import other.AI;
import other.context.Context;
import other.move.Move;
import py4j.GatewayServer;


/**
 * Example Java wrapper for a Ludii AI implemented in Python
 *
 * @author Dennis Soemers
 */

public class LudiiPythonAI extends AI
{
	
	//-------------------------------------------------------------------------
	
	/** Our player index */
	protected int player = -1;
        GatewayServer server;
        Ludii_AI ai;
	
	public LudiiPythonAI()
	{
		this.friendlyName = "UCT_py";
	}
	
	//-------------------------------------------------------------------------

	@Override
	public Move selectAction
	(
		final Game game, 
		final Context context, 
		final double maxSeconds,
		final int maxIterations,
		final int maxDepth
	)
	{
                //TODO
		return (Move) ai.select_action(game, context, maxSeconds, maxIterations, maxDepth);
	}
	
	@Override
	public void initAI(final Game game, final int playerID)
	{
		this.player = playerID;
                server = new GatewayServer();
                server.start();
                System.out.println("Gateway Server Started");
                ai = (Ludii_AI) server.getPythonServerEntryPoint(new Class[] { Ludii_AI.class });
                try {
                    ai.init_ai(game, playerID);
                } catch (Exception e) {
                    e.printStackTrace();
                }
	}
	
	//-------------------------------------------------------------------------

}
