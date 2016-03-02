package Main;

public class Bomb {
	
	//Variables******************************************
	public int dudX = 0;
	public int dudY = 0;
	
	//Constructor****************************************
	public Bomb(int x, int y){
		dudX = x;
		dudY = y;
	}
	
	//Methods********************************************
	public boolean checkCollision(int x, int y){
		if(dudX > (x-7) && dudX < (x+7) &&  dudY > (y-7) && dudY < (y+7))
			return true;
		else
			return false;
	}
}