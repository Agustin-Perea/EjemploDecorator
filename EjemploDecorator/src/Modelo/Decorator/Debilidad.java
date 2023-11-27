package Modelo.Decorator;

public class Debilidad extends PersonajeConEfectoDecorator {

	public Debilidad(IAlterable personaje) {
		super(personaje);

	}

	@Override
	public void recibirDanio(int daño, int dañoAdicional) {
		personaje.recibirDanio(daño*2, dañoAdicional);
	}

	@Override
	public void desplazarse(int desplazamiento) {
		personaje.desplazarse(desplazamiento/2);
	}
	@Override
	public String toString() {
		return super.toString() + " Debilitado";
	}
}
