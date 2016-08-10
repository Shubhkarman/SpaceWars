package javagame;

import java.util.Random;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Play extends BasicGameState{
	
	Image alien,ship,shot;
	float shipX,shipY,shotX,shotY,alienX,alienY;
	boolean shoot=false,quit=false;
	int score=0;
//	Animation shooting,aliencoming;
//	int[] duration={1,1};	
	
	Image[] aliens = new Image[50];
	int aliens_num=0;
	float[] aliensX=new float[50];
	float[] aliensY=new float[50];
	
	public Play(int state){
		
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
		
		alien=new Image("res/alien.gif");	// image object... image inputed by drag and drop
		ship=new Image("res/ship.gif");
		shot=new Image("res/shot.gif");
		
		shipX=420;shipY=600;
		shotX=shipX;shotY=shipY-10;
		alienX=0;alienY=0;
		
		for(int i=0;i<50;i++){
			aliens[i]=new Image("res/alien.gif");
		}
		
		aliens_num=1;
		for(int i=0;i<50;i++){
			aliensY[i]=(int)(Math.random()*200);
			aliensX[i]=-(int)(Math.random()*500);		// TO CREATE TIME DIFFRENCE JUST START THEM A LITTLE BACK
			/***
			 * THAT WAS SOME NIGGA BANGING SHIT RIGHT THERE MAN... 
			*/
		}
		
		//Image[] shooti={new Image("res/shot.gif"),new Image("res/shot.gif")};
		
		//shooting =new Animation(shooti,duration,false);		//use these images and for this time
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
		// this is the method that actually draws stuff
		g.drawImage(ship,shipX,shipY);
		g.drawString("Score:  "+String.valueOf(score), 750, 0);
		if(shoot){
			//shooting.draw(shotX, shotY--);
			g.drawImage(shot, shotX, shotY--);
		}
		
		if(aliens_num>0){
			for(int i=0;i<aliens_num;i++){
				if(aliens[i]!=null){
					g.drawImage(aliens[i], aliensX[i], aliensY[i]);
					aliensX[i]+=0.1;
//					if(aliensX[i]==800){		//<<--- NOT WORKING -??????????-??????-????-??-?
//						g.drawString("GAME OVER", 500, 500);
//					}
					/**
					 * BHAII RENDER CHALTA HAI BHAI...!!!!
					 * RENDER MAI KUCH BHI CHANGE TOH RENDER CHANGE
					 */
					
					if(((shotX>aliensX[i])&&(shotX<aliensX[i]+30))&&((shotY>aliensY[i])&&(shotY<aliensY[i]+30))){
						
						aliens[i]=null;
						aliensX[i]=0; 
						aliensY[i]=0;
						score++;
					}
				}
				
			}
			
		}
		
		
		if(aliens_num<=score){	/// if all killed		<<-----
			aliens_num*=2;
		}
		else if(aliens_num<2*score){
			aliens_num++;		//risky move... makes it error prone
		}
		else if(score!=0){
			g.drawString("GAME OVER\n SCORE: "+String.valueOf(score), 500, 500);
		}
		if(quit){
			g.drawString("Resume (r)", 250, 100);
			g.drawString("Main Menu (m)", 250, 150);
			g.drawString("Quit (q)", 250, 200);
		}
		
	}
	public void update(GameContainer gc, StateBasedGame sbg,int delta)throws SlickException {
		// updates screen... therefore animation
		Input input =gc.getInput();
		
		if(input.isKeyDown(Input.KEY_LEFT)){
			shipX -= 1;
			if(shipX==0)
				shipX+=1;
		} 	// keyboard left movement
		if(input.isKeyDown(Input.KEY_RIGHT)){
			shipX += 1;
			if(shipX==810)
				shipX-=1;
		} 	// keyboard right movement
		
		if(input.isKeyDown(Input.KEY_SPACE)){
			shotX=shipX+10; 
			shotY=shipY-10; 
			shoot=true;
		}
		
		if(input.isKeyDown(Input.KEY_ESCAPE)){quit=true;}
		if(quit){
			if(input.isKeyDown(Input.KEY_R)){quit=false;}
			if(input.isKeyDown(Input.KEY_M)){sbg.enterState(0);}
			if(input.isKeyDown(Input.KEY_Q)){System.exit(0);}
		}
		
		
		//aliens!!!\\
		
		
	}
	
	public int getID(){
		return 1;// play returns 1
	}

}
