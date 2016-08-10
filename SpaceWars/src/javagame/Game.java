package javagame;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Game extends StateBasedGame{
	
	public static final String gamename= "SpaceWars!";
	public static final int menu =0;	  	 /// numbers to reference later... 0 for menu and
	public static final int play =1;		/// 1 for play
	
	public Game(String gamename){		  //Constructor 
		super(gamename);			     //print on top of window
		this.addState(new Menu(menu));  //making states(screens)
		this.addState(new Play(play));
	}
	
	public void initStatesList(GameContainer gc) throws SlickException{	//abstract class frm StateBAsedGame, info about screen
		this.getState(menu).init(gc, this);   //intialise(init) states
		this.getState(play).init(gc, this);
		this.enterState(menu); 				 // start with menu state first
	}
	
	public static void main(String[] args) {
		AppGameContainer appgc;
		try{
			appgc=new AppGameContainer(new Game(gamename));		// making container(window) and giving it new game object
			appgc.setDisplayMode(840, 640, false); 		// length breadth and fullscreen
			appgc.start();
		}catch(SlickException e){
			e.printStackTrace();
		}

	}

}
