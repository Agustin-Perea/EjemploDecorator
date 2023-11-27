package Vista;

import Modelo.Guerrero;
import Modelo.Mago;
import Modelo.Posicion;
import Modelo.Decorator.Debilidad;
import Modelo.Decorator.IAlterable;
import Modelo.Decorator.Invulnerabilidad;
import Modelo.Decorator.Quemadura;

public class mainConsola {

	public static void main(String[] args) {

		IAlterable guerrero = new Guerrero();
		IAlterable mago = new Mago(new Posicion(guerrero.getPosicion().getX() + 768));
		
		System.out.println(mago.toString());
		System.out.println(guerrero.toString());
		
		mago.atacar(guerrero);
		guerrero.desplazarse(guerrero.getVelocidad());
		System.out.println("\nEl mago ataca al Guerrrero, el Guerrero se mueve\nAl Finalizar el turno:");
		System.out.println(mago.toString());
		System.out.println(guerrero.toString());
		
		
		System.out.println("\nEl mago usa una habilidad que quema al guerrero, el Guerrero se mueve\nAl Finalizar el turno:");
		mago.usarHabilidad(guerrero,"QUEMAR");
		guerrero = new Quemadura(guerrero,40);
		guerrero.desplazarse(guerrero.getVelocidad());
		System.out.println(mago.toString());
		System.out.println(guerrero.toString());
	
		System.out.println("\nEl mago usa una habilidad que infringe debilidad al guerrero, el Guerrero se mueve\nAl Finalizar el turno:");
		mago.usarHabilidad(guerrero,"DEBILIDAD");
		guerrero = new Debilidad(guerrero);
		guerrero.desplazarse(guerrero.getVelocidad());
		System.out.println(mago.toString());
		System.out.println(guerrero.toString());
		
		System.out.println("\nEl mago ataca, el Guerrero usa invulnerabilidad y se mueve\nAl Finalizar el turno:");
		mago.atacar(guerrero);
		guerrero.usarHabilidad(guerrero, "INVULNERABILIDAD");
		guerrero = new Invulnerabilidad(guerrero);
		guerrero.desplazarse(guerrero.getVelocidad());
		System.out.println(mago.toString());
		System.out.println(guerrero.toString());
		
		System.out.println("\nEl mago ataca, el Guerrero se mueve y ataca al mago infringiendole debilidad\nAl Finalizar el turno:");
		mago.atacar(guerrero);
		guerrero.desplazarse(guerrero.getVelocidad());
		guerrero.atacar(mago);
		mago = new Debilidad(mago);
		System.out.println(mago.toString());
		System.out.println(guerrero.toString());
		
		System.out.println("\nEl mago se mueve y ataca, el Guerrero ataca al mago\nAl Finalizar el turno:");
		mago.desplazarse(mago.getVelocidad());
		mago.atacar(guerrero);
		guerrero.desplazarse(guerrero.getVelocidad());
		guerrero.atacar(mago);
		System.out.println(mago.toString());
		System.out.println(guerrero.toString());
	}

}
