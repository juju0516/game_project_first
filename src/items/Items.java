package items;

import java.awt.Graphics;
import java.awt.Image;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;

import entity.Player;
import main.PanelGame;

public class Items {
	// burger is hp, steak is dmg+, coffee is speed+, pizza is attackspeed+

	public int randomX, randomY;
	int max = 1000;
	Player player;
	PanelGame pg;
	int type;
	Image itemImage,buffImage;
	String itemPictureURL,buffImageURL;
	public int wh = 40;
	int effType;
	double prevSpeed;
	public boolean triggered=false;

	public Items(int randomX, int randomY, Player player, int type,PanelGame pg) {
		this.randomX = randomX;
		this.randomY = randomY;
		this.player = player;
		this.type = type;
		this.pg = pg;
	}

	public void update() {
		//System.out.println(type);
		switch (type) {
		case 1: {
			itemPictureURL = "Images/burger.png";
			buffImageURL = "Images/AtkGain.png";
			effType = 1;
			break;

		}
		case 2: {
			itemPictureURL = "Images/choco.png";
			effType = 2;
			break;
		}
		case 3: {
			itemPictureURL = "Images/steak.png";
			effType = 3;
			break;
		}
		case 4: {
			itemPictureURL = "Images/pizza.png";
			effType = 4;
			break;
		}
		case 5:{
			itemPictureURL = "Images/cookies.png";
			effType = 5;
			break;
		}
		}

	}

	public void Effect() {
		switch (effType) {
		case 1: {
			Timer timer = new Timer();
			gainHP();
			System.out.println("hpUp");
			timer.schedule(new TimerTask() {
				@Override
				public void run() {

				}
			}, 5000);
			break;
		}
		case 2: {
			System.out.println("speedUp");
			Timer timer = new Timer();
			prevSpeed = player.speed;
			speedBoost();
			timer.schedule(new TimerTask() {
				@Override
				public void run() {

					player.speed = prevSpeed;
				}
			}, 5000);
			break;

		}
		case 3: {
			System.out.println("dmgup");
			Timer timer = new Timer();
			damageUp();
			timer.schedule(new TimerTask() {
				@Override
				public void run() {

					player.damage = 3000;
				}
			}, 5000);
			System.out.println("dmg complete");
			break;
		}
		case 4:{
			System.out.println("attackSpeedUp");
			Timer timer = new Timer();
			attackSpeed();
			timer.schedule(new TimerTask() {
				@Override
				public void run() {
					
					pg.maxBullets = 1;
				}
			}, 5000);
		
			break;
		}
		case 5:{
			System.out.println("invincible");
			Timer timer = new Timer();
			invincible();
			timer.schedule(new TimerTask() {
				
				@Override
				public void run() {
					pg.invincible=false;
					
				}
			}, 5000);
			break;
		}

		}
	}

	public void gainHP() {
		player.health += 1000;

	}

	public void speedBoost() {
		player.speed = 8;

	}

	public void damageUp() {
		player.damage = 5000;

	}

	public void attackSpeed() {
		try {
			pg.maxBullets = 3;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void invincible() {
		try {
			pg.invincible=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void draw(Graphics g) {
		try {
			itemImage = new ImageIcon(itemPictureURL).getImage();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			g.drawImage(itemImage, randomX, randomY, wh, wh, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(triggered) {
			try {
				buffImage = new ImageIcon(buffImageURL).getImage();
				g.drawImage(buffImage, player.x, player.y+20, wh, wh, null);
				System.out.println("damage buff");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
