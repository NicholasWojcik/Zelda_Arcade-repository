package Main;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.imageio.ImageIO;

public class Player {
	
	//Variables**************************************************
	public int health = 5;
	public int level = 1;
	public static int score = 0;
	public int xLoc = 60;
	public int yLoc = 60;
	
	//Image Variables********************************************
	BufferedImage sprite = null;
	BufferedImage gameOver = null;
	BufferedImage ghost = null;
	BufferedImage tomb = null;
	ImageObserver observer;
	
	//Objects****************************************************
	GameOver go = new GameOver();

	//Constructor************************************************
	Player(){
	}

	//Getters & Setters******************************************
	int getXLocation(){
		return xLoc;
	}
	int getYLocation(){
		return yLoc;
	}
	public static String getScore(){
		return Integer.toString(score);
	}
	public void incrementScore(){
		score++;
	}
	void changeLocation(int direction){
		if(direction == 1 && yLoc > 14)
			yLoc = yLoc - 3;
		if(direction == 2 && xLoc > 15)
			xLoc = xLoc - 3;
		if(direction == 3 && yLoc < 248)
			yLoc = yLoc + 3;;
		if(direction == 4 && xLoc < 350)
			xLoc = xLoc + 3;
	}
	
	//Methods****************************************************
	//Methods****************************************************
	public void render(Graphics g) throws URISyntaxException{
		Graphics2D g2 = (Graphics2D) g;
		//BasicStroke bs1 = new BasicStroke(12, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
		//g2.setStroke(bs1);
		//g2.drawLine(this.getXLoc(), this.getYLoc(), this.getXLoc(), this.getYLoc());
		if(Game.direction == 1){
			try {
				sprite = ImageIO.read(new File(getClass().getResource("linkleft.png").toURI()));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else if(Game.direction == 3){
			try {
				sprite = ImageIO.read(new File(getClass().getResource("linkright.png").toURI()));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else if(Game.direction == 4){
			try {
				sprite = ImageIO.read(new File(getClass().getResource("linkdown.png").toURI()));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else if(Game.direction == 2){
			try {
				sprite = ImageIO.read(new File(getClass().getResource("linkup.png").toURI()));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		g2.drawImage(sprite, this.getXLocation()-7, this.getYLocation()-5, observer);
	}
	public void renderLost(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		try {
			gameOver = ImageIO.read(new File(getClass().getResource("gameover.png").toURI()));
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
		try {
			ghost = ImageIO.read(new File(getClass().getResource("ghost.png").toURI()));
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
		try {
			tomb = ImageIO.read(new File(getClass().getResource("tomb.png").toURI()));
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
		g2.drawImage(gameOver, go.getX(), go.getY(), observer);
		g2.drawImage(tomb, go.getTombX(), go.getTombY(), observer);
		g2.drawImage(ghost, this.getXLocation()-7, this.getYLocation()-5, observer);
		if(this.getXLocation() > 200 && this.getYLocation() > 200 && this.getYLocation() < 220 && this.getXLocation() < 220){
			this.score = 0;
			go.resetBanner();
			Game.lost = false;
		}
		go.move();
	}
}