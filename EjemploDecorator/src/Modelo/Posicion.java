package Modelo;

public class Posicion {
	private float x;
	
	
	public Posicion() {
		this.x = 0f;
	}
	public Posicion(float x){
		this.x = x;
	}
	
	public void setPosicionX(float x){
		this.x = x;
	}
	public float getX(){
		return this.x;
	}
}
