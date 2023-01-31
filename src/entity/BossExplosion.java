package entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class BossExplosion {
	
	int x,y;
	int radius;
	int maxRadius;
	Color color;
	Image explosionImg;
	boolean done = false;
	Player player;
	
	public BossExplosion(int x, int y,int radius, int maxRadius,Player player) {
		this.x=x;
		this.y=y;
		this.radius=radius;
		this.maxRadius=maxRadius;
		this.player = player;
	}
	
	public void update(){
		radius+=1;
		Rectangle explos = new Rectangle(x, y, radius, radius);
		if(explos.intersects(player.playerHit)) {
			player.health-=10;
			System.out.println("ouch explos");
		}
		if(radius>maxRadius) {
			radius = maxRadius;
		    done = true;
		}
		
			
		
	}
	
	public void draw(Graphics g) {
		explosionImg= new ImageIcon("Images/explosion.gif").getImage();
		g.drawImage(explosionImg, x, y, null);
	}

}
