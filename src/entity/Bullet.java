package entity;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;



public class Bullet extends Entity{
	
	Player player;
	Image bulletImage;
	String pictureURL;
	Enemy1 enemy;
	Rectangle bullet;
	String fireDirection;
	Rectangle bulletHit;
	public int wh;
	
	public Bullet(int x, int y, int health, double speed, int damage,int wh,Player player,String pictureURL,String fireDirection,Enemy1 enemy) {		
		this.x = x;
		this.y = y;
		this.health = health;
		this.speed = speed;
		this.damage = damage;
		this.player = player;
		this.wh = wh;
		this.pictureURL=pictureURL;
		this.fireDirection=fireDirection;
		this.enemy=enemy;
		
		
	}
	
	public void update(Player player) {
//		if(direction=="up") {
//			up();
//		}
//		if(direction=="down") {
//			down();
//		}
//		if(direction=="left") {
//			left();
//		}
//		if(direction=="right") {
//			right();
//		}
		
		
		if(fireDirection=="up") {
			//x = player.x;
			y -= speed;
			
		}
		else if(fireDirection=="down") {
			//x = player.x;
			y += speed;
			
		}
		else if(fireDirection=="left") {
			x -= speed;
		}
			//y = player.y;
			
		else if(fireDirection=="right") {
			 x += speed;
			//y = player.y;
		}
		
			
			
		
	}
	
	public void draw(Graphics g) {
		try {
			bulletImage = new ImageIcon(pictureURL).getImage();
		} catch (Exception e) {
			// TODO: handle exception
		}
		g.drawImage(bulletImage, x, y,wh,wh, pg);
	}
		

}
