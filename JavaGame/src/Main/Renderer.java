package Main;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Renderer extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//Image Variables*****************************************
	private BufferedImage bomb = null;
	private BufferedImage chicken = null;
	private BufferedImage deku = null;
	private BufferedImage creeper = null;
	private ImageObserver observer;
	
	//Constructor*********************************************
	public Renderer(){
		try {
			deku = ImageIO.read(new File(getClass().getResource("splash4.png").toURI()));
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
	}

	//Methods*************************************************
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		
		//Structures*******************************************************
		ArrayList<Bomb> bombs = Game.getDuds();
		ArrayList<Chicken> chickens = Game.getList();
		//*****************************************************************
		try {
			bomb = ImageIO.read(new File(getClass().getResource("bomb.png").toURI()));
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
		try {
			chicken = ImageIO.read(new File(getClass().getResource("chicken.gif").toURI()));
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
		try {
			creeper = ImageIO.read(new File(getClass().getResource("creeper.png").toURI()));
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(deku, -6, -5, observer);
		Game.game.render(g);

		
		BasicStroke bs2 = new BasicStroke(1);
		g2.setStroke(bs2);
		Rectangle rect = new Rectangle(9,9,351,252);
		g2.draw(rect);
		g2.setFont(new java.awt.Font("AR BONNIE", java.awt.Font.BOLD, 50));
		g2.drawString("Score", 370, 50);
		if(Integer.parseInt(Player.getScore()) > 99){
			g2.setFont(new java.awt.Font("AR BONNIE", java.awt.Font.BOLD, 75));
			g2.drawString(Player.getScore(), 375, 155);
		}
		else{
			g2.setFont(new java.awt.Font("AR BONNIE", java.awt.Font.BOLD, 100));
			g2.drawString(Player.getScore(), 375, 155);
		}

		
		//Extracts enemy objects and paints them to the screen**************
		for(int w = 0; w < chickens.size(); w++){
			Chicken m = (Chicken)chickens.get(w);
			if((w+1)%11 == 0)
				g2.drawImage(creeper, m.getX()-3, m.getY()-3, observer);
			else
				g2.drawImage(chicken, m.getX()-3, m.getY()-3, observer);
		}
		for(int w = 0; w < bombs.size(); w++){
			Bomb m = (Bomb)bombs.get(w);
			
			g2.drawImage(bomb, m.getX()-5, m.getY()-3, observer);
		}
		//******************************************************************
	}
}
