package Main;

public class GameOver {
	
	//Variables********************************************
	public int gx = 90;
	public int gy = -100;
	public int tombX = 200;
	public int tombY = 200;
	
	//Getters & Setters************************************
	public int getX(){
		return gx;
	}
	public int getY(){
		return gy;
	}
	public int getTombX(){
		return tombX;
	}
	public int getTombY(){
		return tombY;
	}
	public void resetBanner(){
		gy = -100;
	}
	
	//Methods**********************************************
	public void move(){
		if(gy < 85)
			gy++;
	}
}
