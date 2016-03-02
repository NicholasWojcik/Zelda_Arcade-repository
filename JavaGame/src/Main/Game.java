package Main;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.Timer;

public class Game implements ActionListener, KeyListener {
	
	//Objects***************************************************************
	public static Game game;
	public Renderer painter;
	Random rand = new Random();
	static Player toon = new Player();
	
	//Structures************************************************************
	static ArrayList<Chicken> missles = new ArrayList<Chicken>();
	static ArrayList<Bomb> duds = new ArrayList<Bomb>();
	
	//Variables*************************************************************
	boolean up = false;
	boolean down = false;
	boolean left = false;
	boolean right = false;
	boolean missle = false;
	static int rotation = 0;
	static boolean lost = false;
	static int direction = 1;
	
	//Main Function*********************************************************
	public static void main(String[] args) {
		game = new Game();
	}
	
	//Constructor***********************************************************
	public Game(){
		Timer timer = new Timer(20, this);
		painter = new Renderer();
		JFrame window = new JFrame("Game Practice");
		
		window.setSize(500, 300);
		window.setFocusable(true);
		window.addKeyListener(this);
		window.setResizable(false);
		window.setDefaultCloseOperation(window.EXIT_ON_CLOSE);
		window.add(painter);
		window.setVisible(true);
		
		timer.start();
	}
	
	//Methods***************************************************************
	public void render(Graphics g){	
		if(lost){
			toon.renderLost(g);
			game.deleteEnemies();
		}
		else{
			try {
				toon.render(g);
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void update(){
		if(left == true){
			toon.changeLocation(2);
			direction = 1;
		}
		if(up == true){
			toon.changeLocation(1);
			direction = 2;
		}
		if(right == true){
			toon.changeLocation(4);
			direction = 3;
		}
		if(down == true){
			toon.changeLocation(3);
			direction = 4;
		}
		
		ArrayList missles = Game.getList();
		for(int w = 0; w < missles.size(); w++){
			Chicken m = (Chicken)missles.get(w);
			m.move();
			if(m.checkCollision(toon.getXLocation(), toon.getYLocation()))
				lost = true;
		}
		ArrayList duds = Game.getDuds();
		for(int w = 0; w < duds.size(); w++){
			Bomb m = (Bomb)duds.get(w);
			if(m.checkCollision(toon.getXLocation(), toon.getYLocation()))
				lost = true;
		}
		System.out.println(Integer.toString(toon.getYLocation())+ " " + Integer.toString(toon.getXLocation()));
		System.out.println(Boolean.toString(right));
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		update();
		painter.repaint();
	}
	public void newEnemy(){

		if(rotation%3 != 0){
			Chicken miss = new Chicken(rand.nextInt(340) + 20,rand.nextInt(235) + 20);
			missles.add(miss);
		}
		else{
			Bomb du = new Bomb(rand.nextInt(340) + 20,rand.nextInt(235) + 20);
			duds.add(du);
		}
		if(!lost)
			toon.incrementScore();
		rotation++;
	}
	public void deleteEnemies(){
		missles.clear();
		duds.clear();
	}
	public static ArrayList getList(){
		return missles;
	}
	public static ArrayList getDuds(){
		return duds;
	}
	@Override
	public void keyPressed(KeyEvent e) {
		int id = e.getKeyCode();
		if(id == KeyEvent.VK_UP)
			up = true;
		else if(id == KeyEvent.VK_DOWN)
			down = true;
		else if(id == KeyEvent.VK_LEFT)
			left = true;
		else if(id == KeyEvent.VK_RIGHT)
			right = true;
		else if(id == KeyEvent.VK_SPACE)
			newEnemy();
	}
	@Override
	public void keyReleased(KeyEvent e) {
		int id = e.getKeyCode();
		if(id == KeyEvent.VK_UP)
			up = false;
		else if(id == KeyEvent.VK_DOWN)
			down = false;
		else if(id == KeyEvent.VK_LEFT)
			left = false;
		else if(id == KeyEvent.VK_RIGHT)
			right = false;
	}
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

}
