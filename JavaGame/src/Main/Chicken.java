package Main;

public class Chicken {
	
	//Variables**********************************************
	boolean visible = false;
	public int missleX = 0;
	public int missleY = 0;
	
	//Constructor********************************************
	public Chicken(int x, int y){
		missleX = x;
		missleY = y;
		visible = true;
		
	}
	
	//Methods************************************************
	public void move(){
		if(missleX < Game.toon.getXLocation())
			missleX++;
		else
			missleX--;
		if(missleY < Game.toon.getYLocation())
			missleY++;
		else 
			missleY--;
	}
	public boolean checkCollision(int x, int y){
		if(missleX > (x-7) && missleX < (x+7) &&  missleY > (y-7) && missleY < (y+7))
			return true;
		else
			return false;
	}
	
}
