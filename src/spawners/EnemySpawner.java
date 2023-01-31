package spawners;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import entity.Enemy1;
import entity.Enemy2;
import entity.Player;
import main.PanelGame;

public class EnemySpawner extends Thread{
	PanelGame panelGame;
	int interval;
	int maxEnemies;
	Enemy1 enemy1;
	Enemy2 enemy2;
	List<Enemy1>totalEnemyList;
	Player player;
	int randomX,randomY;
	Random random = new Random();
	int maxX ;
	int maxY ;
	int enemyType = 2;
	
	
	public EnemySpawner(PanelGame panelGame, int interval, int maxEnemies,Player player) {
		this.panelGame = panelGame;
		this.interval = interval;
		this.maxEnemies = maxEnemies;
		this.player = player;
		this.totalEnemyList = new ArrayList<>();
		//this.enemy2List = new ArrayList<>();
		 maxX = panelGame.worldX;
		 maxY = panelGame.worldY;
	}

	
	@Override
	public void run() {
		while(true) {
			while(maxEnemies>totalEnemyList.size()) {
				randomX = random.nextInt(maxX + 1);
				randomY = random.nextInt(maxY + 1);
				int enemyChooser = random.nextInt(2) + 1;
				//System.out.println(enemyChooser);
				switch (enemyChooser) {
				case 1: 
					enemy1 = new Enemy1(panelGame, randomX, randomY, 5000, 1, 5,100, player,"Images/dino.jpg");
					panelGame.enemyList.add(enemy1);
					break;
				case 2:enemy1 = new Enemy1(panelGame, randomX, randomY, 3000, 2, 10,80, player,"Images/astronaut.png");
				panelGame.enemyList.add(enemy1);
				break;
				}

				
				
				totalEnemyList = panelGame.enemyList;
				
				
				
				try {
					Thread.sleep(interval);
				} catch (Exception e) {
					
				}
			}
			
		}
		
	}

}
