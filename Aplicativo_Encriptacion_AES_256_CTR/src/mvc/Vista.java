package mvc;

import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class Vista {

	public JFrame ventana;
	protected JPanel panelTexto;
	protected JPanel panelContrasena;
	protected JPanel panelResultado;
	protected JPanel panelBotones;

	JButton decrypt;
	JButton encrypt;

	private JTextField contrasena;
	private JTextPane resultado;
	private JTextPane texto;

	private JLabel textoLabel;
	private JLabel resultadoLabel;
	private JLabel contrasenaLabel;

	public JTextField getContrasena() {
		return contrasena;
	}

	public JTextPane getResultado() {
		return resultado;
	}

	public void setResultado(JTextPane resultado) {
		this.resultado = resultado;
	}

	public JTextPane getTexto() {
		return texto;
	}

	public Vista() {
		panelTexto();
		panelContrasena();
		panelResultado();
		panelBotones();
		ventanaPrincipal();

	}

	public void ventanaSecundaria() {
		ventana.setVisible(true);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void ventanaPrincipal() {

		ventana = new JFrame();
		ventana.setVisible(true);
		ventana.setLayout(null);
		ventana.add(panelTexto);
		ventana.add(panelContrasena);
		ventana.add(panelResultado);
		ventana.add(panelBotones);
		panelTexto.setBounds(40, 40, 480, 80);
		panelContrasena.setBounds(40, 130, 340, 20);
		panelResultado.setBounds(40, 160, 480, 80);
		panelBotones.setBounds(110, 260, 230, 30);

		ventana.setSize(550, 340);
		ventana.setResizable(false);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	private void panelTexto() {

		panelTexto = new JPanel();
		panelTexto.setLayout(new BoxLayout(panelTexto, BoxLayout.LINE_AXIS));
		texto = new JTextPane();
		textoLabel = new JLabel("Texto: ");
		panelTexto.add(textoLabel);
		panelTexto.add(texto);

	}

	private void panelContrasena() {

		panelContrasena = new JPanel();
		panelContrasena.setLayout(new BoxLayout(panelContrasena, BoxLayout.LINE_AXIS));
		contrasena = new JTextField();
		contrasenaLabel = new JLabel("Contraseña: ");
		panelContrasena.add(contrasenaLabel);
		panelContrasena.add(contrasena);

	}

	private void panelResultado() {

		panelResultado = new JPanel();
		panelResultado.setLayout(new BoxLayout(panelResultado, BoxLayout.LINE_AXIS));
		resultado = new JTextPane();
		resultadoLabel = new JLabel("Resultado: ");
		panelResultado.add(resultadoLabel);
		panelResultado.add(resultado);

	}

	private void panelBotones() {

		panelBotones = new JPanel();
		panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.LINE_AXIS));
		decrypt = new JButton("Desencriptar");
		encrypt = new JButton("Encriptar");
		panelBotones.add(encrypt);
		panelBotones.add(decrypt);

	}

	public void asignarOyentes(Controlador c) {
		decrypt.addActionListener((ActionListener) c);
		encrypt.addActionListener((ActionListener) c);
	}

}
