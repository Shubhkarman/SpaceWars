package javagame;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.lwjgl.input.Mouse;	//Mouse tracker library

public class Menu extends BasicGameState{
	
	String mouse="j";	//can't be empty
	String letsplay="Time to Play the Game!!!";
	String exit="Exit";
	public Menu(int state){
		
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
		
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
		g.drawString(mouse, 750, 0);// y of mouse and game is REVERSE!!!!!
		
		g.drawString(letsplay, 75, 70);
		g.fillRect(300, 70, 20, 20);
		
		g.drawString(exit, 75,150 );
		g.fillRect(150, 150, 20, 20);
		
		Image alien,shot,ship;
		alien=new Image("res/alien.gif");	// image object... image inputed by drag and drop
		ship=new Image("res/ship.gif");
		shot=new Image("res/shot.gif");
		
		g.drawImage(alien, 300, 300);//breadth 35
		g.drawImage(shot, 370, 300);//breadth 10
		g.drawImage(ship, 400, 300);
		
	}
	
	public void update(GameContainer gc, StateBasedGame sbg,int delta)throws SlickException {
		int xpos=Mouse.getX();
		int ypos=Mouse.getY();
		ypos=640-ypos;
		mouse="x: "+xpos+"\ny: " +ypos;
		
		Input input =gc.getInput();
		if((xpos>300 && xpos<320)&&(ypos>70 && ypos<90)){
			if(input.isMouseButtonDown(0)){
				///restart(); or new play();.... <- to enable restart
				sbg.enterState(1);
			}
		}
		if((xpos>150 && xpos<170)&&(ypos>150 && ypos<170)){
			if(input.isMouseButtonDown(0)){
				System.exit(0);
			}
		}
	}
	
	public int getID(){
		return 0;// menu returns 0
	}

}



//package javagame;
//
//import org.newdawn.slick.*;
//import org.newdawn.slick.state.*;
//import org.lwjgl.input.Mouse;	//Mouse tracker library
//
//public class Menu extends BasicGameState{
//	/*
//	Image face;		// new for keyboard.. all other before have been commented
//	int faceX =200;
//	int faceY=200;
//	*/
//	//public String mouse = "No input yet!";	//mouse variable string
//	
//	public Menu(int state){
//		
//	}
//	
//	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
//		//face=new Image("res/nss.png");
//	}
//	
//	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
//		/*// this is the method that actually draws stuff
//		g.drawString("ARE YOU READY TO BLOW SOME HAM!!",50 , 50); //WRITES Txt on screen, arg-> string,x,y.. coordinates 
//		g.drawRect(50, 100, 60, 120); 	// x,y,w,h-> posn(x,y) and width and heigth
//		//g.drawOval(200,130, 130, 80);	// draw oval
//		Image img=new Image("res/nss.png");	// image object... image inputed by drag and drop
//		g.drawImage(img,200,130);	//place image
//		g.drawString(mouse,0 , 250);// print mouse posn at any point
//	*/
//		//g.drawImage(face, faceX, faceY);  	// keyboard
//	
//	
//		// screen change
//		g.fillOval(75, 100, 100, 100);
//		g.drawString("Play Now", 80, 70);
//	
//	}
//	
//	public void update(GameContainer gc, StateBasedGame sbg,int delta)throws SlickException {
//		// updates screen... therefore use for animation 
//		/*int xpos=Mouse.getX();		//takes x coordinate of mouse... java inbuilt
//		int ypos=Mouse.getY();
//		mouse="Mouse posn x: "+xpos+"  y: "+ypos;*/
//		
//		 //keyboard
//		/*Input input =gc.getInput();
//		
//		if(input.isKeyDown(Input.KEY_UP)){faceY -= 1;} 	// keyboard up movement
//		if(input.isKeyDown(Input.KEY_DOWN)){faceY += 1;} 	// keyboard down movement
//		if(input.isKeyDown(Input.KEY_LEFT)){faceX -= 1;} 	// keyboard left movement
//		if(input.isKeyDown(Input.KEY_DOWN)){faceX += 1;} 	// keyboard right movement
//		*/
//		
//		
//		
//		// screen change
//		Input input =gc.getInput();
//		int xpos=Mouse.getX();
//		int ypos=Mouse.getY();
//		if((xpos>75 && xpos<175)&&(ypos>160 && ypos<260)){
//			if(input.isMouseButtonDown(0)){
//				sbg.enterState(1);
//			}
//		
//		}
//	}
//	
//	public int getID(){
//		return 0;// menu returns 0
//	}
//
//}
//