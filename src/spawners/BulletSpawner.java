package spawners;

import entity.Bullet;
import entity.Enemy1;
import entity.Entity;
import entity.KeyHandler;
import entity.Player;
import main.PanelGame;


public class BulletSpawner extends Thread{
	PanelGame pg;
	
	int maxBullets;
	KeyHandler keyH;
	Bullet bullet;
	Player player;
	int reloadTime;
	int x,y;
	String direction;
	int interval;
	Enemy1 enemy;
	String URL;
	
	public BulletSpawner(PanelGame pg, int maxBullets, KeyHandler keyH, Bullet bullet, Player player,int reloadTime,int interval,Enemy1 enemy) {
		this.pg = pg;
		this.maxBullets = maxBullets;
		this.keyH = keyH;
		this.bullet = bullet;
		this.player = player;
		this.reloadTime=reloadTime;
		this.interval=interval;
		this.enemy=enemy;
		switch(pg.getChr) {
		case 1:	URL = "Images/snowball.png";break;
		case 2: URL = "Images/fireball.png";break;
		case 3: if(player.direction=="left") {
			URL = "Images/axeLeft.png";break;
		}else {
			URL = "Images/axe.png";break;
		}
		
		}
		
		
		
	}
	
	@Override
	public void run() {
		while(true) {
		while(pg.maxBullets>pg.bulletList.size()) {
			try {
				Thread.sleep(reloadTime);
			} catch (Exception e) {
				
			}
			
			if(keyH.spacePressed) {
//				if(player.direction!=null) {
//					direction=player.direction;
//				}
				pg.bulletList.add(new Bullet(player.playerX, player.playerY+30, 1, 10, 3000, 30, player,URL,player.firedirection,enemy));
				try {
					Thread.sleep(interval);
				} catch (Exception e) {
					// TODO: handle exception
				}
				keyH.spacePressed = false;
			}
			
		}
		}
		//System.out.println("nope");
	}

}
