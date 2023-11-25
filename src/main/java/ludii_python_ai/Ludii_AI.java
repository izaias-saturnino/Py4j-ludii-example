/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ludii_python_ai;

import game.Game;
import other.context.Context;
import other.move.Move;

public interface Ludii_AI {
    public void init_ai(Game game, int player_id);

    public Move select_action(Game game, Context context, double max_seconds, int max_iterations, int max_depth);
}