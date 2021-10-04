package com.app.clases;
import java.time.LocalDateTime;


import processing.core.PApplet;
import processing.core.PImage;

public class MyPApplet extends PApplet	{

	private static final long serialVersionUID = 1L;
	private String filename = "D:\\Workspace-Eclipse\\ProbandoApplets\\src\\imgs\\caleta-vidal.jpg";
	private PImage loadImage;	
	
	public void setup() {
		size(300, 300);	//set canvas
		background(255);//set canvas color
		stroke(0);//set pen color
		loadImage = loadImage(filename, "jpg");
		loadImage.resize(0, height);//resize image to full height
		image(loadImage, 0, 0);// images and vertices
	}
	
	public void draw() {
		
		
		//print the cirle in the image depended what time is
		/*int hora = LocalDateTime.now().getHour();
		
	    if(hora >= 19)  fill(242, 242, 242);
	    else fill(255, 255, 204);*/
		
		int[] color = sunColorSec(second());
	    fill(color[0], color[1], color[2]);
		ellipse(width/5, height/12, height/10, height/10);
	}
	
	private int[] sunColorSec(float seconds) {
		
		int[] rgb = new int[3];
		float diffFrom30 = Math.abs(seconds - 30);
		
		float ratio = diffFrom30/30;
		
		rgb[0] = (int) (255 * ratio);
		rgb[1] = (int) (255 * ratio);
		rgb[2] = 0;
		
		//for(int num: rgb) System.out.println(num);
		
		return rgb;
	}
}
	