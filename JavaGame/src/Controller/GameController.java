package Controller;

import Models.Bomb;
import Models.Chicken;
import Models.Player;
import View.GameView;

public class GameController {
	//Models
	private Bomb bomb;
	private Chicken chicken;
	private Player player;
	
	//View
	GameView view;
	
	//Constructor
	GameController(GameView view){
		this.view = view;
	}
	public void update(GameView view){
		this.view = view;
	}
	
}
