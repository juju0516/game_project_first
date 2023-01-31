package spawners;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;

import entity.Player;
import items.Items;
import main.PanelGame;

public class ItemSpawner extends Thread{
	PanelGame pg;
	int interval;
	Items item;
	Player player;
	CopyOnWriteArrayList<Items> itemList = new CopyOnWriteArrayList<>();
	Random random = new Random();
	public int randomX,randomY;
	public int maxItems;
	int randomItem;
	
	public ItemSpawner(PanelGame pg, int interval, int maxItems, Player player) {
		this.pg=pg;
		this.interval=interval;
		this.maxItems=maxItems;
		//this.item=item;
		this.player=player;
	}

	
	
	@Override
	public void run() {
		while(true) {
			while(maxItems>pg.itemList.size()) {
			randomX = random.nextInt(pg.worldX + 1);
			randomY = random.nextInt(pg.worldY + 1);
			randomItem = random.nextInt(5+1);//3 is number of items 
			try {
				sleep(random.nextInt(interval + 1));
			} catch (Exception e) {
				
			}
			
			item = new Items(randomX, randomY, player, randomItem,pg);
			pg.itemList.add(item);
			}
			
			
		
		}
	
	}
	
	
	

}
