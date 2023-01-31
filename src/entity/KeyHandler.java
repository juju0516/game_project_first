package entity;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
	
	public boolean upPressed, downPressed, leftPressed, rightPressed,pausePressed,spacePressed;
	public boolean moving = false;
	

	@Override
	public void keyTyped(KeyEvent keyword) /*probably used when key is typed, dunno will be back for it prolly*/{
	}
		

	@Override
	public void keyPressed(KeyEvent keyword) /*e saves the data when the buttons specified below are pressed*/{
		int code = keyword.getKeyCode();
		if(code == KeyEvent.VK_UP) {
			upPressed = true;
			//System.out.println("uppressed");
			moving = true;
		}
		
		if(code == KeyEvent.VK_DOWN) {
			downPressed = true;
			//System.out.println("downPre");
			moving = true;
		}
		
		if(code == KeyEvent.VK_LEFT) {
			leftPressed = true;
			moving = true;
			//System.out.println("leftPre");
		}
		
		if(code == KeyEvent.VK_RIGHT) {
			rightPressed = true;
			moving = true;
			//System.out.println("RightPre");
			
		}
		
		if(code == KeyEvent.VK_P) {
			if(pausePressed==false) {
			pausePressed = true;
			moving = true;
			}
			else if(pausePressed==true) {
				pausePressed = false;
				
			}
			
		}
		if(code ==KeyEvent.VK_SPACE) {
			spacePressed = true;
		}
	}
		
		
		
		
		

	@Override
	public void keyReleased(KeyEvent keyword)/*e saves the data when the buttons specified below are released*/ {
		int code = keyword.getKeyCode();
		if (code == KeyEvent.VK_UP) {
			upPressed = false;
			moving = false;
			//System.out.println("upRe");
		}
		if (code == KeyEvent.VK_DOWN) {
			downPressed = false;
			moving = false;
			//System.out.println("downRE");
		}
		if (code == KeyEvent.VK_LEFT) {
			leftPressed = false;
			moving = false;
			//System.out.println("leftRE");
		}
		if (code == KeyEvent.VK_RIGHT) {
			rightPressed = false;
			moving = false;
			//System.out.println("rightRE");
		}
//		if(code == KeyEvent.VK_SPACE) {
//			spacePressed = false;
//		}
		
		
	}
	

}