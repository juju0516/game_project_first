package entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.swing.ImageIcon;

import main.PanelGame;

public class Boss extends Entity{
	Player player;
	Image mainBoss,healthbar;
	String pictureURL;
	public Rectangle bossHit, rollingBall;
	Rectangle playerHit;
	public int health;
	public int enemyX,enemyY;	
	public int bossEffect;
	public boolean boss2Eff;
	Boss boss = this;
	public String direction;
	
	RotatingObject roller;
	BossExplosion explosion;
	Fireball fireball;
	CopyOnWriteArrayList<BossExplosion> explosionList = new CopyOnWriteArrayList<>();
	CopyOnWriteArrayList<Fireball> fireballList = new CopyOnWriteArrayList<>();
	int z;
			
	
	public Boss(PanelGame pg, int x, int y, int health, double speed, int damage,int wh,Player player,String pictureURL) {
		this.pg = pg;
		this.x = x;
		this.y = y;
		this.health = health;
		this.speed = speed;
		this.damage = damage;
		this.player = player;
		this.wh = wh;
		this.pictureURL=pictureURL;
		roller = new RotatingObject(this, 100);
		z = health/pg.worldX;
		
	}
	

	
	public void update() {
	
		
		
		if(player.x>x) {
			right();
			direction = "right";
		}
		 if(player.x<x){
			left();
			direction = "left";
		}
		 if(player.y>y) {
			down();
			direction = "down";
		}
		 if(player.y<y) {
			up();
			direction = "up";
		}
		
		 bossHit = new Rectangle(x, y, wh, wh);
		 playerHit = new Rectangle(player.x, player.y,player.wh,player.wh);
		 if(playerHit.intersects(bossHit)&&pg.invincible==false) {
			 
			 player.health-=damage;
		 }
		if(bossEffect==1) {
			
			 rollingBall = new Rectangle((int)roller.x,(int)roller.y,roller.wh,roller.wh);
			 if(playerHit.intersects(rollingBall)&&pg.invincible==false) {
				 player.health-=10;
				
				 
			 }
			 roller.update();
		}
		
		if(bossEffect==2) {
			if(!boss2Eff) {
				Timer timer = new Timer();
				timer.schedule(new TimerTask() {
					
					@Override
					public void run() {
						if(fireballList.size()<10) {
						fireball = new Fireball(x, y, player, boss, 7, 20, 15,10,direction);
						fireballList.add(fireball);
						}
						
					}
				}, 5000);
				System.out.println("done");
				boss2Eff=false;
			}
			for (Fireball fireball : fireballList) {
				fireball.update();
			}
		
			}
		
		
		
		
		
		if(bossEffect==3) {
			Timer timer = new Timer();
			timer.schedule(new TimerTask() {
				
				@Override
				public void run() {
					explosionList.add(new BossExplosion(x, y, 10, 200,player));
					speed=2;
					
				}
			}, 5000);
			for (BossExplosion bossExplosion : explosionList) {
				bossExplosion.update();
				if(bossExplosion.done) {
				explosionList.remove(bossExplosion);
				}
				
			}
		}
			
	}
	
	public void draw(Graphics g) {
		try {
			mainBoss = new ImageIcon(pictureURL).getImage();
			healthbar = new ImageIcon("Images/skull.png").getImage();
		} catch (Exception e) {
			
		}
		g.drawImage(healthbar, pg.worldX/2-250, 100, 400, 200, null);
		g.drawImage(mainBoss, x, y, wh,wh, null);
		
		//g.drawRect(x, y, wh / 2 + wh, wh / 2 + wh);
		g.setColor(Color.red);
		g.fillRect(0,100, health/z, 50);
		g.setColor(Color.green);
		g.fillRect(0,100, health/z, 50);
		if(bossEffect==1&&roller!=null){
		roller.draw(g);
		}
		
		if(bossEffect==2) {
			for (Fireball fireball : fireballList) {
				fireball.draw(g);
			}
		}
		
		if(bossEffect==3) {
			for (BossExplosion explosion : explosionList) {
				explosion.draw(g);
			}
			
		}
		
		
	}
	
	
	

}
