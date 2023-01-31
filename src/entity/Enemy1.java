package entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

import main.PanelGame;

public class Enemy1 extends Entity {
	Player player;
	Image mainEnemy1;
	String pictureURL;
	public Rectangle enemyHit1;
	Rectangle playerHit;
	public int health;
	public int enemyX,enemyY;

	public Enemy1(PanelGame pg, int x, int y, int health, double speed, int damage,int wh,Player player,String pictureURL) {
		this.pg = pg;
		this.x = x;
		this.y = y;
		this.health = health;
		this.speed = speed;
		this.damage = damage;
		this.player = player;
		this.wh = wh;
		this.pictureURL=pictureURL;
		
	}
	public void update(Player player) {
		
//		if(player.direction=="left") {
//			right();
//		}
//		else if(player.direction=="right") {
//			left();
//		}
//		else if(player.direction=="up") {
//			down();
//		}
//		else if(player.direction=="down") {
//			up();
//		}
//		else {
			if(player.x>x) {
				right();
			}
			 if(player.x<x){
				left();
			}
			 if(player.y>y) {
				down();
			}
			 if(player.y<y) {
				up();
			}
			 enemyHit1 = new Rectangle(x, y, wh, wh);
			 playerHit = new Rectangle(player.x, player.y,player.wh-20,player.wh);
			 if(playerHit.intersects(enemyHit1)&&pg.invincible==false) {
				 player.health-=damage;
			 }
			 
				
		}
	
//	}

			
		
		
	

	

	public void draw(Graphics g) {
//		g.setColor(Color.red);
//		g.fillOval(x, y, wh / 2 + wh, wh / 2 + wh);
		try {
			mainEnemy1 = new ImageIcon(pictureURL).getImage();
		} catch (Exception e) {
			
		}
		g.drawImage(mainEnemy1, x, y, wh,wh, null);
		
		g.drawRect(x, y, wh / 2 + wh, wh / 2 + wh);
		g.setColor(Color.red);
		g.fillRect(x - 10, y + 30, 50, 10);
		g.setColor(Color.green);
		g.fillRect(x - 10, y + 30, health/100, 10);
	}

}
