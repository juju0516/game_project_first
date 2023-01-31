package entity;

import main.PanelGame;

public class Entity {
	PanelGame pg;
	public int x;
	public int y;
	public int wh;
	public int health;
	public double speed;
	public int damage; 
	String direction;
	public void left() {
		x-=speed;
	}
	public void right() {
		x+=speed;
	}
	public void up() {
		y-=speed;
	}
	public void down() {
		y+=speed;
	}
	
	
	

}
