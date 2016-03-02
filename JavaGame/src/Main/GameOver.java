package Main;

public class GameOver {
	
	//Variables********************************************
	private int gx = 90;
	private int gy = -100;
	private int tombX = 200;
	private int tombY = 200;
	
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
