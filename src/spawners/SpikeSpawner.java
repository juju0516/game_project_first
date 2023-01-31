package spawners;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


import entity.Player;
import main.PanelGame;
import traps.SpikeTrap;

public class SpikeSpawner extends Thread{
	PanelGame pg;
	int interval;
	SpikeTrap spike;
	Player player;
	int maxSpikes;
	Random random = new Random();
	int randomX,randomY;
	
	
	public SpikeSpawner(PanelGame pg, int interval,SpikeTrap spike,Player player,int maxSpikes) {
		this.pg=pg;
		this.interval=interval;
		this.spike=spike;
		this.player=player;
		this.maxSpikes=maxSpikes;
	}
	
	@Override
	public void run() {
		while(true) {
			while(pg.spikeList.size()<maxSpikes) {
				randomX = random.nextInt(pg.worldX + 1);
				randomY = random.nextInt(pg.worldY + 1);
				try {
					sleep(random.nextInt(interval + 1));
				} catch (Exception e) {
					
				}
				spike = new SpikeTrap(randomX, randomY, player,pg);
				pg.spikeList.add(spike);
				Timer timer = new Timer();
				timer.schedule(new TimerTask() {
					
					@Override
					public void run() {
						pg.spikeList.remove(0);
						for (SpikeTrap k : pg.spikeList) {
							pg.spikeList.add(k);
						}						
					}
				}, 30000);
			}
		}
	}

}
