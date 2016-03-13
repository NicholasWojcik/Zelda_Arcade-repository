package Models;

import Main.Game;

public class Chicken {
	
	//Variables**********************************************
	boolean visible = false;
	private int chickenX = 0;
	private int chickenY = 0;
	
	//Constructor********************************************
	public Chicken(int x, int y){
		chickenX = x;
		chickenY = y;
		visible = true;
	}
	
	//Getters and setters************************************
	public int getX(){
		return chickenX;
	}
	public int getY(){
		return chickenY;
	}
	public void setX(int x){
		chickenX = x;
	}
	public void setY(int y){
		chickenY = y;
	}
	
	//Methods************************************************
	public void move(){
		if(chickenX < Game.toon.getXLocation())
			chickenX++;
		else
			chickenX--;
		if(chickenY < Game.toon.getYLocation())
			chickenY++;
		else 
			chickenY--;
	}
	public boolean checkCollision(int x, int y){
		if(chickenX > (x-7) && chickenX < (x+7) &&  chickenY > (y-7) && chickenY < (y+7))
			return true;
		else
			return false;
	}
	
}
