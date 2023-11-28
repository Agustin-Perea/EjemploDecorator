package Modelo.Decorator;

import java.awt.image.BufferedImage;

public class Quemadura extends PersonajeConEfectoDecorator {
	int daño;
	public Quemadura(IAlterable personaje,int daño) {
		super(personaje);
		this.daño = daño;
	}
	
	@Override
	public void atacar(IAlterable enemigo) {
		this.personaje.atacar(enemigo);
		this.personaje.recibirDanio(0, this.daño);
	}

	@Override
	public void recibirDanio(int daño, int dañoAdicional) {
		this.personaje.recibirDanio(daño, dañoAdicional);
	}

	@Override
	public void desplazarse(int desplazamiento) {
		this.personaje.desplazarse(desplazamiento);
		this.personaje.recibirDanio(0, this.daño);
	}
	@Override
	public String toString() {
		return super.toString() + " Quemado";
	}
	
	
	
	///visuales


		private int animationsSpriteAmount[] = {3,1,1,3,5,0};
		
		@Override
		public void getImages() {
			this.personaje.getImages();
			this.allSprites = personaje.getAllSprites();
		}
		@Override
		public void loadAnimations() {
			super.loadAnimations();
			for(int i=0; i<animations.length-6;i++) 
				for(int j=0; j<animations[i].length;j++) {
					animations[i][j]= allSprites.getSubimage(j*17,(i+6)*17, 17,17);
				}
		
		}
		@Override
		public int[] getAnimationSpriteAmount() {
			return animationsSpriteAmount;
		}
}
