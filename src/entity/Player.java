package entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import main.PanelGame;

public class Player extends Entity{
	KeyHandler keyH;
	public String direction;
	Image mainCharLeftMoving, mainCharRightMoving,mainCharIdle;
	ImageIcon charPicMovingLeft,charPicIdle,charPicMovingRight;
	File charImg = new File("Images/mainCharPlaceholder.jpg");
	public int playerX,playerY;
	public Rectangle playerHit;
	//public int health;
	public int chrChoice;
	public String firedirection;
	
	
	
	public Player(int x, int y, int wh, double speed, KeyHandler keyH,int health,PanelGame pg,int damage,int chrChoice) {
		this.x = x;
		this.y = y;
		this.wh = wh;
		this.speed = speed;
		this.keyH = keyH;
		this.health = health;
		this.pg = pg;
		this.damage=damage;
		this.chrChoice=chrChoice;
		switch(chrChoice){
		case 1: charPicMovingLeft = new ImageIcon("Images/CharacterImages/blueWitch/movingWitchLeft.gif");
		charPicIdle = new ImageIcon("Images/CharacterImages/blueWitch/idleWitch.gif");
		charPicMovingRight = new ImageIcon("Images/CharacterImages/blueWitch/movingWitchRight.gif");
		break;
		
		case 2:
			charPicMovingLeft = new ImageIcon("Images/CharacterImages/RedHood/runningLeft.gif");
			charPicIdle = new ImageIcon("Images/CharacterImages/RedHood/idle.gif");
			charPicMovingRight = new ImageIcon("Images/CharacterImages/RedHood/runningRight.gif");
			break;
		case 3:
			charPicMovingLeft = new ImageIcon("Images/CharacterImages/warrior/left.gif");
			charPicIdle = new ImageIcon("Images/CharacterImages/warrior/idle.gif");
			charPicMovingRight = new ImageIcon("Images/CharacterImages/warrior/right.gif");
			break;
		}
	
	}
	public void update() {
		if(keyH.leftPressed) {
			left();
			firedirection = "left";
			direction="left";
		}
		if(keyH.rightPressed) {
			right();
			firedirection = "right";
			direction="right";
		}
		 if(keyH.upPressed) {
			up();
			firedirection = "up";
		}
		if(keyH.downPressed) {
			down();
			firedirection = "down";
		}
//		else{
//			direction = null;
//		}
		playerX=x;
		playerY=y;
		playerHit = new Rectangle(playerX,playerY,wh,wh);
		
	}
		
	
	public void draw(Graphics g) {		
//		g.setColor(Color.orange);
//		g.fillRect(x, y, wh,wh);

		try {
			//mainCharLeft = ImageIO.read(charImg);
		 mainCharLeftMoving = charPicMovingLeft.getImage();
		 mainCharRightMoving = charPicMovingRight.getImage();
		 mainCharIdle = charPicIdle.getImage();
			if(keyH.moving&&direction=="left") {
				g.drawImage(mainCharLeftMoving, x, y,wh,wh, null);
			}else if(keyH.moving&&direction=="right") {
				g.drawImage(mainCharRightMoving, x, y,wh,wh, null);
			}else {
				g.drawImage(mainCharIdle, x, y,wh,wh, null);
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		//g.drawImage(mainCharLeftMoving, x, y,wh,wh, null);
		
		//health bar
		g.setColor(Color.red);
		g.fillRect(x-50, y+80, 50, 10);
		g.setColor(Color.green);
		g.fillRect(x-50, y+80, health/100, 10);
//		mainCharLeft.flush();
	}
		


}
