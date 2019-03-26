package mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;

public class Controlador implements ActionListener {

	Vista vista;
	Modelo modelo;

	public Controlador(Vista vista, Modelo modelo) {

		this.vista = vista;
		this.modelo = modelo;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "Desencriptar") {
			try {
				String texto = vista.getTexto().getText();
				String contrasena = vista.getContrasena().getText();
				vista.getResultado().setText(modelo.desencriptar(contrasena, texto));
			} catch (UnsupportedEncodingException e1) {
			}
		} else {

//			try {
//				String texto = vista.getTexto().getText();
//				String contrasena = vista.getContrasena().getText();
////				vista.getResultado().setText(modelo.encriptar(contrasena, texto));
//			} catch (UnsupportedEncodingException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
		}
	}

}
