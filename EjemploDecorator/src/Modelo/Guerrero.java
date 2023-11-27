package Modelo;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import Modelo.Decorator.IAlterable;

public class Guerrero extends Personaje {

	public Guerrero() {
		this.vida = 500;
		this.ataque = 100;
		this.alcance = 250;
		this.velocidad = 150;
		this.posicion = new Posicion();
		
		this.mana = 50;
	}

	@Override
	public void atacar(IAlterable enemigo) {
		if(Atacable(enemigo))
			enemigo.recibirDanio(ataque, 0);
		
	}
	
	@Override
	public String toString() {
		return "Tipo: Guerrero" + super.toString();
	}
	
	@Override
	public void usarHabilidad(IAlterable alterable, String nombreHabilidad) {
		if(nombreHabilidad=="INVULNERABILIDAD"&& this.mana >= 50) {
			this.mana-=50;
		}
	}
	
	
	///Visuales
	
	public void loadAnimations() {
		this.animations = new BufferedImage[12][6];
		for(int i=0; i<animations.length;i++) 
			for(int j=0; j<animations[i].length;j++) {
				animations[i][j]= allSprites.getSubimage(j*17,i*17, 17,17);
			}
		
		
	}
	@Override
	public void loadAnimationsSpriteAmount() {//mejor load
		int animationsSpriteAmount[] = {3,1,1,3,5,1};
		this.animationsSpriteAmount = animationsSpriteAmount;
	}
	@Override
	public void getImages() {
		InputStream is = getClass().getResourceAsStream("/guerrero.png");//se supone que llama al personaje.getImages()
		try {
			allSprites = ImageIO.read(is);
			//loadAnimations();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}


}
