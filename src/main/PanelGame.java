package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import entity.Boss;
import entity.Bullet;
import entity.Enemy1;
import entity.Entity;
import entity.KeyHandler;
import entity.Player;
import items.Items;
import spawners.BossSpawner;
import spawners.BulletSpawner;
import spawners.EnemySpawner;
import spawners.ItemSpawner;
import spawners.SpikeSpawner;
import traps.SpikeTrap;

public class PanelGame extends JPanel implements Runnable {
	boolean gamePlay = false;
	Frame frame;
	Thread gamePlayer, enemySpawner, bulletSpawner, bossSpawner, itemSpawner, spikeSpawner;
	public int worldX = 1500;
	public int worldY = 1000;
	public CopyOnWriteArrayList<Enemy1> enemyList = new CopyOnWriteArrayList<>();
	public CopyOnWriteArrayList<Bullet> bulletList = new CopyOnWriteArrayList<>();
	public CopyOnWriteArrayList<Boss> bossList = new CopyOnWriteArrayList<>();
	public CopyOnWriteArrayList<Items> itemList = new CopyOnWriteArrayList<>();
	public CopyOnWriteArrayList<SpikeTrap> spikeList = new CopyOnWriteArrayList<>();
	EndGame endscreen;

	Player player;
	KeyHandler keyH = new KeyHandler();
	int playerX, playerY;
	Enemy1 enemy1;
	SpikeTrap spike;
	Rectangle playerHit, bulletHit, enemyHit1;
	public int mobskilled = 0;
	public int totalmobsKilled = 0;
	public boolean bossAlive = false;
	public int maxBullets = 1;
	public boolean invincible = false;
	// public boolean invincible = true;//debugger
	ImageIcon getMap = null;
	public int getChr;
	Image background;
	boolean end;
	int playerHealth;
	int playerSpeed;
	public int bossDiff;

	public void update() {
		player.update();
		playerX = player.playerX;
		playerY = player.playerY;
		//System.out.println(player.health);

		// System.out.println(mobskilled);
		if (bossAlive) {
			enemyList.removeAll(enemyList);
		}

		for (Boss boss : bossList) {
			boss.update();
			if (boss.health < 1) {
				bossList.remove(boss);
				bossAlive = false;
			}
			if (boss.bossEffect == 2) {

			}

		}
		for (Enemy1 enemy : enemyList) {
			enemy.update(player);
			enemyHit1 = new Rectangle(enemy.x, enemy.y, enemy.wh, enemy.wh);
			if (enemy.health < 1) {
				enemyList.remove(enemy);
				++mobskilled;
				++totalmobsKilled;
			}
		}

		for (Items item : itemList) {
			Rectangle playerHit = new Rectangle(playerX, playerY, player.wh, player.wh);
			Rectangle itemRec = new Rectangle(item.randomX, item.randomY, item.wh, item.wh);
			item.update();
			if (playerHit.intersects(itemRec)) {
				item.Effect();
				itemList.remove(item);
			}

		}

		for (Bullet bullet : bulletList) {
			bullet.update(player);
			if (bullet.x < 0 || bullet.x > worldX || bullet.y < 0 || bullet.y > worldY) {
				bulletList.remove(bullet);
				// System.out.println(bulletList.size());
			}
			for (int i = 0; i < enemyList.size(); i++) {
				Enemy1 enemy = enemyList.get(i);
				bulletHit = new Rectangle(bullet.x, bullet.y, bullet.wh, bullet.wh);
				Rectangle enemyHit = new Rectangle(enemy.x, enemy.y, enemy.wh, enemy.wh);
				if (bulletHit.intersects(enemyHit)) {
					bulletList.remove(bullet);
					enemy.health -= player.damage;
				}
			}
			for (int i = 0; i < bossList.size(); i++) {
				Boss boss = bossList.get(i);
				bulletHit = new Rectangle(bullet.x, bullet.y, bullet.wh, bullet.wh);
				Rectangle bossHit = new Rectangle(boss.x, boss.y, boss.wh, boss.wh);
				if (bulletHit.intersects(bossHit)) {
					bulletList.remove(bullet);
					boss.health -= player.damage;
				}
			}
		}
		for (SpikeTrap spike : spikeList) {
			spike.update();
		}

		if (player.health < 1) {
			end = true;
			frame.dispose();

			endscreen = new EndGame(frame.dif, frame.chr, frame.map,frame);
		}

	}

	public void gameStart() {
		gamePlayer = new Thread(this);
		gamePlayer.start();
	}

	public void enemySpawn() {
		enemySpawner = new EnemySpawner(this, 1000, 10, player);
		enemySpawner.start();
	}

	public void bulletSpawn() {
		Bullet bullet = new Bullet(playerX, playerY, 1, 5, 3000, 15, player, "Images/snowball.png", "left", enemy1);
		bulletSpawner = new BulletSpawner(this, maxBullets, keyH, bullet, player, 100, 50, enemy1);
		bulletSpawner.start();
	}

	public void bossSpawn() {
		// Boss boss = new Boss(this, playerX, playerX, 1, 5, 3000, 15, player,
		// "Images/snowball.png");
		bossSpawner = new BossSpawner(this, 50, 1, player);
		bossSpawner.start();
	}

	public void itemSpawn() {
		itemSpawner = new ItemSpawner(this, 1000, 3, player);
		itemSpawner.start();
	}

	public void spikeSpawn() {
		spikeSpawner = new SpikeSpawner(this, 10000, spike, player, 3);
		spikeSpawner.start();
	}

	public PanelGame(Frame frame) {
		// this.setBackground(Color.white);
		this.frame = frame;
		System.out.println(frame.map.mapDec);
		switch (frame.map.mapDec) {
		case 1: {
			getMap = frame.map.img1;
			System.out.println(getMap.toString()+"a");
			break;

		}
		case 2: {
			getMap = frame.map.img2;
			System.out.println(getMap.toString()+"b");
			break;
		}
		case 3: {
			getMap = frame.map.img3;
			System.out.println(getMap.toString()+"c");
			break;
		}
		}
		background = getMap.getImage();
		switch(frame.dif.difficulty) {
		case 1:playerHealth=15000;playerSpeed =5;bossDiff=5000;break;
		case 2: playerHealth=10000;playerSpeed =4;bossDiff=3000;break;
		case 3:playerHealth=5000;playerSpeed =3;bossDiff=0;break;
		}
		switch(frame.chr.chosenCard) {
		case 1:getChr=1; break;
		case 2:getChr=2;break;
		case 3:getChr=3;break;
		}
		setPreferredSize(new Dimension(worldX, worldY));
		setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);

		player = new Player(500, 500, 100, playerSpeed, keyH, playerHealth, this, 3000,getChr);
		gameStart();
		enemySpawn();
		bossSpawn();
		bulletSpawn();
		itemSpawn();
		spikeSpawn();

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(background, 0, 0, worldX, worldY, null);
		player.draw(g);
		for (Enemy1 enemy1 : enemyList) {
			enemy1.draw(g);
		}
		for (Bullet bullet : bulletList) {
			bullet.draw(g);
		}
		for (Boss boss : bossList) {
			boss.draw(g);
		}
		for (Items item : itemList) {
			item.draw(g);
		}
		for (SpikeTrap spike : spikeList) {
			spike.draw(g);
		}
	}

	@Override
	public void run() {
		end = false;
		double drawInterval = 1000000000 / 100;
		double nextDrawTime = System.nanoTime() + drawInterval;

		while (gamePlayer != null && end == false) {
			update();
			repaint();
			try {
				double remainingTime = nextDrawTime - System.nanoTime();
				remainingTime = remainingTime / 1000000;
				if (remainingTime < 0) {
					remainingTime = 0;
				}
				Thread.sleep((long) (remainingTime));
				nextDrawTime += drawInterval;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
