package entity;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Fireball extends Entity{
	
	Player player;
	Boss boss;
	Image fireball;
	//int damage;
	String direction;
	
	
	public Fireball(int x,int y,Player player,Boss boss,double speed,int wh,int damage,int max,String direction) {
		this.x=x;
		this.y=y;
		this.player=player;
		this.boss=boss;
		this.speed=speed;
		this.wh=wh;
		this.damage=damage;
		this.direction=direction;
	}
	
	public void update() {
		
		if(direction=="up") {
			//x = player.x;
			y -= speed;
			
		}
		else if(direction=="down") {
			//x = player.x;
			y += speed;
			
		}
		else if(direction=="left") {
			x -= speed;
		}
			//y = player.y;
			
		else if(direction=="right") {
			 x += speed;
			//y = player.y;
		}
		
		Rectangle range = new Rectangle(x,y,wh,wh);
		if(player.playerHit.intersects(range)) {
			player.health-=damage;
			boss.fireballList.remove(this);
		} else if(x < 0 || x > boss.pg.worldX ||y < 0 || y > boss.pg.worldY){
		boss.fireballList.remove(this);
		}
	}
		
		
		public void draw(Graphics g) {
			fireball = new ImageIcon("Images/fireball.png").getImage();
			g.drawImage(fireball, x, y, wh, wh, null);
		}
		
		
	
		
				
	}


