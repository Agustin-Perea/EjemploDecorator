package Modelo.Decorator;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import Modelo.Posicion;

public abstract class PersonajeConEfectoDecorator implements IAlterable {
	
	protected IAlterable personaje;
	
	public PersonajeConEfectoDecorator(IAlterable personaje) {
		this.personaje = personaje;
	}
	@Override
	public void usarHabilidad(IAlterable alterable, String nombreHabilidad) {
		this.personaje.usarHabilidad(alterable,nombreHabilidad);
	}
	@Override
	public void atacar(IAlterable enemigo) {
		personaje.atacar(enemigo);
	}

	@Override
	public void recibirDanio(int daño, int dañoAdicional) {
		personaje.recibirDanio(daño,dañoAdicional);
	}

	@Override
	public void desplazarse(int desplazamiento) {
		personaje.desplazarse(desplazamiento);
	}
	@Override
	public int getVida() {
		return personaje.getVida();
	}
	@Override
	public int getAtaque() {
		return personaje.getAtaque();
	}
	@Override
	public Posicion getPosicion() {
		return personaje.getPosicion();
	}
	@Override
	public int getVelocidad() {
		return personaje.getVelocidad();
	}
	
	public String toString() {
		return personaje.toString();
	}
	@Override
	public void alterarse(String nombreHabilidad) {
		this.personaje.alterarse(nombreHabilidad);
	}

	
	///visuales
	
	protected BufferedImage allSprites;
	protected BufferedImage[][] animations;
	protected int animationsSpriteAmount[];
	
	public void loadAnimations() {
		this.personaje.loadAnimations();
		this.animations = this.personaje.getAnimations();
	}
	public int[] getAnimationSpriteAmount() {
		return this.animationsSpriteAmount;
	}
	public void getImages() {
		this.personaje.getImages();
		this.allSprites = personaje.getAllSprites();
	}
	public BufferedImage getAllSprites() {
		return this.allSprites;
	}

	public BufferedImage[][] getAnimations() {
		return this.animations;
	}

	public void loadAnimationsSpriteAmount() {
		personaje.loadAnimationsSpriteAmount();
		this.animationsSpriteAmount = personaje.getAnimationSpriteAmount();
	}
	
}
