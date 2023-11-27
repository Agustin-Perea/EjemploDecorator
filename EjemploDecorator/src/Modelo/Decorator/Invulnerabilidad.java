package Modelo.Decorator;

public class Invulnerabilidad extends PersonajeConEfectoDecorator{

	public Invulnerabilidad(IAlterable personaje) {
		super(personaje);

	}


	@Override
	public void recibirDanio(int daño, int dañoAdicional) {
		personaje.recibirDanio(0,dañoAdicional);
	}

	@Override
	public String toString() {
		return super.toString() + " Inulnerable";
	}
}
