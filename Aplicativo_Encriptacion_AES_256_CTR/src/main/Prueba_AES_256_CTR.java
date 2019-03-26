package main;

import mvc.*;

public class Prueba_AES_256_CTR {

	public void launcher() {
		Vista vista = new Vista();
		Controlador control = new Controlador(vista, new Modelo());
		vista.asignarOyentes(control);

	}

	public static void main(String[] args) {

		Prueba_AES_256_CTR prueba = new Prueba_AES_256_CTR();
		prueba.launcher();
	}

}
