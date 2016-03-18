package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import Controller.GameController;

public class GameView extends JFrame implements ActionListener {
	private Timer timer;
	
	public GameView(){
		timer = new Timer(20, this);
		
		this.setTitle("Zelda Arcade");
		this.setSize(500, 300);
		this.setFocusable(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
	}

	public void actionPerformed(ActionEvent e) {
		
	}
}
