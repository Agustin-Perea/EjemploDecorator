package Modelo;

import java.awt.image.BufferedImage;

import Modelo.Decorator.IAlterable;

public abstract class Personaje implements IAlterable{
		
	protected int vida;
	protected int ataque;
	protected int alcance;
	protected int velocidad;
	protected Posicion posicion;
	
	protected int mana;
	
	//render
	
	@Override
	public void atacar(IAlterable enemigo) {
		if(Atacable(enemigo))
			enemigo.recibirDanio(ataque, 0);

	}
	
	public void desplazarse(int desplazamiento) {
		this.posicion.setPosicionX(this.posicion.getX() + desplazamiento);
	}
	
	public boolean Atacable(IAlterable enemigo){
		
		return ((enemigo.getPosicion().getX() - this.posicion.getX()) < this.alcance);
	}
	
	public void recibirDanio(int daño,int dañoAdicional){
		this.vida -= daño+dañoAdicional;
		//if(this.vida<1) llamar a muerte, y fin del juego
			
	}
	@Override
	public void usarHabilidad(IAlterable alterable, String nombreHabilidad) {
		
	}

	@Override
	public int getVida() {
		return this.vida;
	}
	@Override
	public int getAtaque() {
		return this.ataque;
	}
	@Override
	public Posicion getPosicion() {
		return this.posicion;
	}	
	@Override
	public int getVelocidad() {
		return this.velocidad;
	}	
	@Override
	public String toString() {
		return ", Vida: "+ this.vida + ", Ataque: "+ this.ataque + ", Posicion: "+ this.posicion.getX() + ", Alcance: "+ this.alcance + ", Velocidad: " + this.velocidad+ ", Mana: " + this.mana;
	}
	
	
	
	///visuales
	
	protected BufferedImage allSprites;
	protected BufferedImage[][] animations;
	protected int animationsSpriteAmount[];
	public void loadAnimations() {
		
	}
	public int[] getAnimationSpriteAmount() {
		return this.animationsSpriteAmount;
	}
	@Override
	public void getImages() {

	}

	public BufferedImage getAllSprites() {
		return allSprites;
	}

	public BufferedImage[][] getAnimations() {
		return animations;
	}
	public void alterarse(String nombreHabilidad) {
		
	}
}
