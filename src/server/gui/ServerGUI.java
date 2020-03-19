package server.gui;

import java.awt.Dialog.ModalityType;
import java.awt.Panel;

import javax.swing.JFrame;
import javax.swing.JPanel;

import server.main.Controller;

public class ServerGUI extends JFrame {

	private Controller controller;


	/**
	 * Create the frame.
	 */
	public ServerGUI(Controller controller) {
		this.controller = controller;
		getContentPane().add(new AddQuestionGUI(this, this.controller));
		setName("Kohaat - Frage hinzufügen");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setVisible(true);
		
		class T1 extends Thread {
			public void run() {
				PortInputGUI portInput = new PortInputGUI(controller);
				portInput.setModal(true);
				portInput.setModalityType(ModalityType.TOOLKIT_MODAL);
				portInput.setAlwaysOnTop(true);
			}
		}
		T1 t1 = new T1();
		t1.start();
		
		
	}

	public void setPanel(JPanel panel, String windowTitle) {
		// TODO Auto-generated method stub
		getContentPane().removeAll();
		getContentPane().add(panel);
		setTitle(windowTitle);
		setVisible(true);
	}

}
