package Main;

public class Bomb {
	
	//Variables******************************************
	public int bombX = 0;
	public int bombY = 0;
	
	//Constructor****************************************
	public Bomb(int x, int y){
		bombX = x;
		bombY = y;
	}
	
	//Getters and setters********************************
	public int getX(){
		return bombX;
	}
	public int getY(){
		return bombY;
	}
	public void setX(int x){
		bombX = x;
	}
	public void setY(int y){
		bombY = y;
	}
	
	//Methods********************************************
	public boolean checkCollision(int x, int y){
		if(bombX > (x-7) && bombX < (x+7) &&  bombY > (y-7) && bombY < (y+7))
			return true;
		else
			return false;
	}
}