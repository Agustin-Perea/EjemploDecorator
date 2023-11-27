package Modelo;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import Modelo.Decorator.IAlterable;
import Modelo.Decorator.Quemadura;

public class Mago extends Personaje {

	public Mago() {
		this.vida = 200;
		this.ataque = 50;
		this.alcance = 1000;
		this.velocidad = 80;
		this.posicion = new Posicion();
		
		this.mana = 100;
	}
	public Mago(Posicion posicion) {
		this.vida = 200;
		this.ataque = 50;
		this.alcance = 1000;
		this.velocidad = 80;
		this.posicion = posicion;
		this.mana = 100;
	}
	@Override
	public void atacar(IAlterable enemigo) {
		if(Atacable(enemigo))
			enemigo.recibirDanio(ataque, 0);

	}
	public void habilidadFuego(IAlterable enemigo) {
		if(Atacable(enemigo) && this.mana > 20) {
			enemigo.recibirDanio(ataque, 0);
			//enemigo = new Quemadura(enemigo); no hay referencia
		    this.mana-=20;
		}

	}
	
	@Override
	public void usarHabilidad(IAlterable alterable, String nombreHabilidad) {
		
		
		switch(nombreHabilidad) {
			case "QUEMAR":
					if(this.mana>=30) this.mana-=30;
					
					break;
			case "DEBILIDAD":
					if(this.mana>=50) this.mana-=50;
					break;
		}
		
		
	}
	@Override
	public String toString() {
		return "Tipo: Mago" + super.toString();
	}


	
	///Visuales
	
		public void loadAnimations() {
			this.animations = new BufferedImage[6][4];
			for(int i=0; i<animations.length;i++) 
				for(int j=0; j<animations[i].length;j++) {
					animations[i][j]= allSprites.getSubimage(j*17,i*17, 17,17);
				}
		}
		@Override
		public void loadAnimationsSpriteAmount() {//mejor load
			int animationsSpriteAmount[] = {3,3,3,3,3,3};
			this.animationsSpriteAmount = animationsSpriteAmount;
		}
		
		public void getImages() {
			InputStream is = getClass().getResourceAsStream("/mago.png");//se supone que llama al personaje.getImages()
			try {
				allSprites = ImageIO.read(is);
				//loadAnimations();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}

	

}
