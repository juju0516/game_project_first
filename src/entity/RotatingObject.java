package entity;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class RotatingObject extends Entity{
	
	
	double x;
	double y;
	double angle;
	int radius;
	Boss boss;
	Image rollingBall;
	   public RotatingObject(Boss boss, int radius) {
	        this.boss = boss;
	        this.radius = radius;
	        wh =100;
	        // Set the initial angle of rotation to 0
	        this.angle = 0;
	    }
	public void update() {
		 x = boss.x + radius * Math.cos(angle);
	     y = boss.y + radius * Math.sin(angle);
	        // Increment the angle of rotation
	        angle += 0.05;
		
	}
	
	public void draw(Graphics g) {
		rollingBall= new ImageIcon("Images/spikeBall.gif").getImage();
		g.drawImage(rollingBall, (int)x, (int)y,wh,wh, null);
	}

}
