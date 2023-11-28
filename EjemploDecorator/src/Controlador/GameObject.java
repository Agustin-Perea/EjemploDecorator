package Controlador;

import java.awt.image.BufferedImage;

import Modelo.Decorator.Debilidad;
import Modelo.Decorator.IAlterable;
import Modelo.Decorator.Invulnerabilidad;
import Modelo.Decorator.PersonajeConEfectoDecorator;
import Modelo.Decorator.Quemadura;

public class GameObject extends PersonajeConEfectoDecorator {

	private float xDelta = 100;
	private BufferedImage[][] animations;
	private int animTick,animIndex,actualAction, animSpeed =  20;
	private double gamespeed = 1000/Juego.FPS_SET;
	
	private boolean muerto = false;
	
	private int animationsSpriteAmount[];//acorde al actualAction, se deberia inicializar en personaje
	
	public GameObject(IAlterable personaje) {
		super(personaje);
		xDelta = personaje.getPosicion().getX();
		
		getImages();
		loadAnimations();
		loadAnimationSpriteAmount();
		actualAction = 0;

	}

	public void getImages() {
		
		personaje.getImages();
		this.allSprites = personaje.getAllSprites();
	}
	
	public void loadAnimations() {
		personaje.loadAnimations();
		this.animations = personaje.getAnimations();
	}
	public void loadAnimationSpriteAmount() {
		personaje.loadAnimationsSpriteAmount();
		this.animationsSpriteAmount = personaje.getAnimationSpriteAmount();//void
	}
	@Override
	public void atacar(IAlterable enemigo) {
		//render anim
		try {
			actualAction = 2;
			animIndex = 0;
			
			Thread.sleep(((animationsSpriteAmount[actualAction])+1)*80);//x ticks
			
    		personaje.atacar(enemigo);
        	actualAction = 0;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		

	}


	@Override
	public void recibirDanio(int daño, int dañoAdicional) {
		
		//render muerte, hit
		
		try {
			actualAction = 3;
			animIndex = 0;

			Thread.sleep( ((animationsSpriteAmount[actualAction])+1)*80);//x ticks

			personaje.recibirDanio(daño,dañoAdicional);
			if(personaje.getVida()<=0)
				muerte();
			else
				actualAction = 0;
        	
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	public void muerte() {
		
		//render muerte, hit
		
		try {
			actualAction = 5;
			animIndex = 0;

			Thread.sleep( (long) (((animationsSpriteAmount[actualAction])+1)*120));//x ticks
			muerto = true;
        	
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void desplazarse(int desplazamiento) {
		personaje.desplazarse(desplazamiento);
		

		//render anim + desplazamiento de imagen
		try {
			actualAction = 1;
			animIndex = 0;
        	while(xDelta < personaje.getPosicion().getX())
        	{	xDelta += personaje.getVelocidad()/personaje.getVelocidad()*2;
            	Thread.sleep((int)gamespeed);//velocidad mov
        	}
        	actualAction = 0;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@Override
	public void usarHabilidad(IAlterable alterable,String nombreHabilidad) {
		try {
			personaje.usarHabilidad(alterable,nombreHabilidad);
			
			actualAction = 4;
			animIndex = 0;
			Thread.sleep( ((animationsSpriteAmount[actualAction])+1)*160);//x ticks
			//alterable.alterarse(nombreHabilidad);// por alguna razon esta linea hace que tome la altura de la imagen como 102 en vez de 204 y lanza exception al cargar las animaciones
        	
        	actualAction = 0;
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}


	public void alterarse(String nombreEfecto) {
		
		switch(nombreEfecto) {
		case "QUEMAR":
				this.personaje = new Quemadura(personaje, 40);
				break;
		case "DEBILIDAD":
				this.personaje = new Debilidad(personaje);
				break;
		case "INVULNERABILIDAD":
			this.personaje = new Invulnerabilidad(personaje);
			break;
	}
		getImages();
		loadAnimations();
		loadAnimationSpriteAmount();
	}

	public void updateAnimationTick() {
		animTick++;

		if(animTick >= animSpeed && !muerto) {//actualiza animacion por tick
			animTick = 0;
			animIndex++;//getSpriteAmount
			if(animIndex > animationsSpriteAmount[actualAction]) {
				animIndex=0;
			}
				
		}
		
	}
	
	public BufferedImage getActualImage() {
		return animations[actualAction][animIndex];
		
	}


	public float getxDelta() {
		return xDelta;
	}
	

}
