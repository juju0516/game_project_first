package traps;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

import entity.Player;
import main.PanelGame;

public class SpikeTrap {
	
	int x;
	int y;
	int wh = 40;
	Player player;
	Image spikes;
	Rectangle spikeHit;
	PanelGame pg;
	public SpikeTrap(int x,int y,Player player,PanelGame pg) {
		this.x=x;
		this.y=y;
		this.player=player;
		this.pg=pg;
	}
	public void update() {
		spikeHit = new Rectangle(x,y,wh,wh);
		if(spikeHit.intersects(player.playerHit)&&pg.invincible==false) {
			player.health-=20;
			System.out.println("spiked");
		}
	}
	
	public void draw(Graphics g) {
		spikes = new ImageIcon("Images/spike.gif").getImage();
		g.drawImage(spikes, x, y,wh,wh,null);
	}
	

}
