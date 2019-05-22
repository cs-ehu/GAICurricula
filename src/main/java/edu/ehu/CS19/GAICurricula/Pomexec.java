package edu.ehu.CS19.GAICurricula;

import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.xml.xquery.XQException;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Pomexec {

	private JFrame frmHtmlpom;
	private JLabel lblPreview;
	private JTextField pomField;
	private JTextField htmlField;
	private JTextField fileHTMLField;

	/**
	 * Lanza la aplicación.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pomexec window = new Pomexec();
					window.frmHtmlpom.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Crea la aplicació.
	 */
	public Pomexec() {
		initialize();
	}

	/**
	 * Inicializa todos los contenidos de la ventana de la aplicación.
	 */
	private void initialize() {
		XQueryMethods xqm = new XQueryMethods();
		
		//Inicialización de la ventana de la aplicación
		frameInit();
		
		//Inicialización de las etiquetas de la aplicación
		labelsInit();
		
		//Inicialización de los campos de texto de la aplicación
		pomTextFieldInit();
		htmlTextFieldInit();
		fileHTMLTextField();
		
		//Inicialización de los botones de la aplicación
		btnExaminarPomInit(xqm);
		btnProcesarPomInit(xqm);
		btnCancelarInit();
		btnExaminarHTMLInit();
		btnAyudaInit();
	}

	/**
	 * Inicializa la ventana inicial y los eventos de cierre de la aplicación.
	 */
	public void frameInit() {
		frmHtmlpom = new JFrame();
		frmHtmlpom.setIconImage(Toolkit.getDefaultToolkit().getImage(System.getProperty("user.dir") + "\\imgs\\app.png"));
		frmHtmlpom.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				int confirmed = JOptionPane.showConfirmDialog(null, 
						"¿Estás seguro de que quieres salir?", "Salir del programa",
						JOptionPane.YES_NO_OPTION);
	
				if (confirmed == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
			@Override
			public void windowOpened(WindowEvent arg0) {
				JOptionPane.showMessageDialog(null, "¡Bienvenido! antes de continuar, recuerde borrar todos los atributos de la etiqueta project. \n -Software creado por: @FosterGun");
			}
		});
	
		frmHtmlpom.setTitle("HTMLPom");
		frmHtmlpom.setResizable(false);
		frmHtmlpom.setBounds(100, 100, 800, 900);
		frmHtmlpom.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmHtmlpom.getContentPane().setLayout(null);
	}

	/**
	 * Inicializa las etiquetas de texto de la aplicación para informar al usuario.
	 */
	public void labelsInit() {
		JLabel lblRutaDeDestino = new JLabel("Ruta de destino del POM");
		lblRutaDeDestino.setBounds(43, 24, 263, 14);
		frmHtmlpom.getContentPane().add(lblRutaDeDestino);
		
		JLabel lblRutaDeDestino_1 = new JLabel("Ruta de destino del fichero HTML que se va a crear");
		lblRutaDeDestino_1.setBounds(43, 88, 348, 14);
		frmHtmlpom.getContentPane().add(lblRutaDeDestino_1);
		
		JLabel lblNombreDelFichero = new JLabel("Nombre del fichero HTML deseado");
		lblNombreDelFichero.setBounds(43, 145, 348, 14);
		frmHtmlpom.getContentPane().add(lblNombreDelFichero);
	}

	/**
	 * Inicializa el campo de texto correspondiente a elegir la ruta del pom de un proyecto del usuario.
	 */
	public void pomTextFieldInit() {
		pomField = new JTextField();
		pomField.setColumns(10);
		pomField.setBounds(43, 49, 254, 20);
		frmHtmlpom.getContentPane().add(pomField);
	}

	/**
	 * Inicializa un campo de texto y sugiere una ruta para el fichero html a generar en este.
	 */
	public void htmlTextFieldInit() {
		htmlField = new JTextField();
		htmlField.setText(System.getProperty("user.home") + "\\Desktop");
		htmlField.setColumns(10);
		htmlField.setBounds(43, 113, 254, 20);
		frmHtmlpom.getContentPane().add(htmlField);
	}
	
	/**
	 * Inicializa un campo de texto y sugiere el nombre del fichero html a generar en este.
	 */
	public void fileHTMLTextField() {
		fileHTMLField = new JTextField();
		fileHTMLField.setText("pomHTML.html");
		fileHTMLField.setColumns(10);
		fileHTMLField.setBounds(43, 170, 166, 20);
		frmHtmlpom.getContentPane().add(fileHTMLField);
	}
	
	/**
	 * Inicializa un campo que contendr� la previsualizaci�n del fichero pom en formato HTML.
	 */
	public void htmlPreviewInit() {
		lblPreview = new JLabel("Ruta de destino del POM");
		lblPreview.setBounds(72, 240, 300, 300);
		lblPreview.setText("HOLA");
		frmHtmlpom.getContentPane().add(lblPreview);
	}

	/**
	 * Inicializa el botón examinar correspondiente a la elección de la ruta del pom y modifica su campo de texto correspondiente cuando se elige la ruta.
	 */
	public void btnExaminarPomInit(XQueryMethods xqm) {
		JButton btnExaminarPom = new JButton("Examinar...");
		btnExaminarPom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser FilechoosePOM = new JFileChooser();
				int retval = FilechoosePOM.showOpenDialog(frmHtmlpom);
				if (retval == JFileChooser.APPROVE_OPTION) {
					File filePOM = FilechoosePOM.getSelectedFile();
					pomField.setText(filePOM.getPath());
				}
				try {
					String preview = xqm.generaXQPOM(pomField.getText().toString(), htmlField.getText().toString() + "\\" + fileHTMLField.getText().toString());
					lblPreview.setText(preview);
				} catch (XQException | IOException e1) {
					JOptionPane.showMessageDialog(null,
							"Error en la previsualizacion",
							"Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnExaminarPom.setBounds(307, 49, 101, 21);
		frmHtmlpom.getContentPane().add(btnExaminarPom);
	}

	/**
	 * Inicializa el botón para procesar el pom de un proyecto y trata el pom después de validar los campos de texto necesarios de la aplicación.
	 * 
	 * @param xqm La lógica utilizada para procesar el pom.
	 */
	public void btnProcesarPomInit(XQueryMethods xqm) {
		JButton btnProcesarPom = new JButton("Procesar POM");
		btnProcesarPom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(pomField.getText().isEmpty() || htmlField.getText().isEmpty() || fileHTMLField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null,
							"El usuario debe rellenar todos los campos para poder \nproducir el HTML con la información del POM.",
							"Rellene todos los campos",
							JOptionPane.WARNING_MESSAGE);
				} else {
					if(!fileHTMLField.getText().endsWith(".html")) {
						JOptionPane.showMessageDialog(null,
								"El nombre de fichero HTML que se va a producir debe tener \nuna extensión adecuada.",
								"Rellene el campo del fichero a generar adecuadamente",
								JOptionPane.WARNING_MESSAGE);
					} else {
						try {
							
							int confirmed = JOptionPane.showConfirmDialog(null, 
									"¡El fichero HTML ha sido generado con éxito! \n¿Desea verlo? si presiona sí se le abrirá.", "¡Archivo HTML generado!",
									JOptionPane.YES_NO_OPTION);
	
							if (confirmed == JOptionPane.YES_OPTION) {
								Desktop desktop = Desktop.getDesktop();
								File file = new File(htmlField.getText().toString() + "//" + fileHTMLField.getText().toString());
								if(file.exists()) desktop.open(file);
							}
						} catch(IOException ex2) {
							JOptionPane.showMessageDialog(null,
									"No se ha generado el fichero HTML. \nEl usuario debe rellenar todos los campos adecuadamente.",
									"Error",
									JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			}
		});
		btnProcesarPom.setBounds(72, 220, 137, 23);
		frmHtmlpom.getContentPane().add(btnProcesarPom);
	}

	/**
	 * Inicializa el botón cancelar de la aplicación y controla su evento de salida de la aplicación a partir de él.
	 */
	public void btnCancelarInit() {
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int confirmed = JOptionPane.showConfirmDialog(null, 
						"¿Estás seguro de que quieres salir?", "Salir del programa",
						JOptionPane.YES_NO_OPTION);
	
				if (confirmed == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		btnCancelar.setBounds(219, 220, 137, 23);
		frmHtmlpom.getContentPane().add(btnCancelar);
	}

	/**
	 * Inicializa el botón examinar correspondiente a la elección de la ruta del html a generar y modifica su campo de texto correspondiente cuando se elige la ruta.
	 */
	public void btnExaminarHTMLInit() {
		JButton btnExaminarHTML = new JButton("Examinar...");
		btnExaminarHTML.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser FilechooseHTML = new JFileChooser();
				FilechooseHTML.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int retval = FilechooseHTML.showOpenDialog(frmHtmlpom);
				if (retval == JFileChooser.APPROVE_OPTION) {
					File filePOM = FilechooseHTML.getSelectedFile();
					htmlField.setText(filePOM.getPath());
				}
			}
		});
		btnExaminarHTML.setBounds(307, 113, 101, 21);
		frmHtmlpom.getContentPane().add(btnExaminarHTML);
	}

	/**
	 * Inicializa el botón de ayuda de la aplicación y muestra información de ayuda si se realiza click.
	 */
	public void btnAyudaInit() {
		JButton btnAyuda = new JButton("?");
		btnAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Para utilizar el programa borre antes todos los atributos de la etiqueta project del pom.");
			}
		});
		btnAyuda.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnAyuda.setBounds(388, 228, 46, 32);
		frmHtmlpom.getContentPane().add(btnAyuda);
	}
}
