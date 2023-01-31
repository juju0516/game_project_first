package spawners;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import entity.Boss;
import entity.Player;
import main.PanelGame;

public class BossSpawner extends Thread {
	PanelGame panelGame;
	int interval;
	int maxBoss;
	Boss boss;

	List<Boss> totalBossList;
	Player player;
	int randomX, randomY;
	Random random = new Random();
	int maxX;
	int maxY;
	int enemyType = 3;
	int needForBoss = 10;

	public BossSpawner(PanelGame panelGame, int interval, int maxBoss, Player player) {
		this.panelGame = panelGame;
		this.interval = interval;
		this.maxBoss = maxBoss;
		this.player = player;
		this.totalBossList = new ArrayList<>();
		// this.enemy2List = new ArrayList<>();
		maxX = panelGame.worldX;
		maxY = panelGame.worldY;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(10);
			} catch (Exception e) {
				// TODO: handle exception
			}
			while (maxBoss > totalBossList.size()) {
				try {
					Thread.sleep(10);
				} catch (Exception e) {
					// TODO: handle exception
				}
				if(panelGame.mobskilled>needForBoss){
					//System.out.println("should be boss ");
					panelGame.mobskilled=0;
					panelGame.bossAlive=true;
				randomX = random.nextInt(maxX + 1);
				randomY = random.nextInt(maxY + 1);
				int bossChooser = random.nextInt(enemyType) + 1;
				//int bossChooser = 2; //debugger
				
				switch (bossChooser) {
				case 1:
					boss = new Boss(panelGame, randomX, randomY, 50000-panelGame.bossDiff, 1, 50, 250, player, "Images/boss1.gif");
					boss.bossEffect =1;
					panelGame.bossList.add(boss);
					break;
				case 2:
					boss = new Boss(panelGame, randomX, randomY, 30000-panelGame.bossDiff, 2, 100, 200, player, "Images/boss2.gif");
					boss.bossEffect =2;
					panelGame.bossList.add(boss);
					
					break;
				
				case 3:
					boss = new Boss(panelGame, randomX, randomY, 40000-panelGame.bossDiff, 1.5, 70, 220, player, "Images/boss.gif");
					boss.bossEffect =3;
					panelGame.bossList.add(boss);
					break;
				}

				totalBossList = panelGame.bossList;
				
				
			}
			}
		}
	}

}
