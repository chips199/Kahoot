package server.gui;

import java.awt.BorderLayout;
import java.awt.Dialog.ModalityType;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class ServerGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServerGUI frame = new ServerGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ServerGUI() {
		
		getContentPane().add(new AddQuestionGUI());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setVisible(true);
		
		class T1 extends Thread {
			public void run() {
				PortInputGUI portInput = new PortInputGUI();
				portInput.setModal(true);
				portInput.setModalityType(ModalityType.TOOLKIT_MODAL);
				portInput.setAlwaysOnTop(true);
			}
		}
		T1 t1 = new T1();
		t1.start();
		
		
	}

}
