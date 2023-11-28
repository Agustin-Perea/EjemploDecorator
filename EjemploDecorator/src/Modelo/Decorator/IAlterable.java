package Modelo.Decorator;

import java.awt.image.BufferedImage;

import Modelo.Posicion;

public interface IAlterable {
	
	public void atacar(IAlterable enemigo);
	public void recibirDanio(int daño,int dañoAdicional);
	public void desplazarse(int desplazamiento);
	
	
	public void usarHabilidad(IAlterable alterable, String nombreHabilidad);
	
	public int getVida();
	public int getAtaque();
	public int getVelocidad();
	public Posicion getPosicion();
	
	public String toString();
	
	
	///visuales
	
	public void loadAnimations();
	public int[] getAnimationSpriteAmount();
	public void getImages();
	
	public BufferedImage getAllSprites();

	public BufferedImage[][] getAnimations();

	public void loadAnimationsSpriteAmount();
	public void alterarse(String nombreHabilidad);
	
}
