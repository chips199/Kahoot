package server.gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;
import java.awt.Dialog.ModalityType;
import java.util.Random;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import server.main.Controller;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ControllerGUI extends JPanel {
	private JTable table;
	private JLabel lblQuestion;
	private JLabel lblRemainingTime;
	private final DefaultTableModel model;

	private Controller controller;
	
	/**
	 * Create the panel.
	 */
	public ControllerGUI(Controller controller) {
		ControllerGUI controllerGUI = this;
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JButton btnNewButton = new JButton("Start");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				class StartQuizThread extends Thread {
					public void run() {
						controller.startQuiz(controllerGUI);
					}
				}
				StartQuizThread startQuizThread = new StartQuizThread();
				startQuizThread.start();
				
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 0;
		add(btnNewButton, gbc_btnNewButton);
		
		lblRemainingTime = new JLabel("Restliche Zeit: 10s");
		GridBagConstraints gbc_lblRemainingTime = new GridBagConstraints();
		gbc_lblRemainingTime.insets = new Insets(0, 0, 5, 5);
		gbc_lblRemainingTime.gridx = 0;
		gbc_lblRemainingTime.gridy = 0;
		add(lblRemainingTime, gbc_lblRemainingTime);
		
		lblQuestion = new JLabel("");
		lblQuestion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblQuestion = new GridBagConstraints();
		gbc_lblQuestion.insets = new Insets(0, 0, 0, 5);
		gbc_lblQuestion.gridx = 0;
		gbc_lblQuestion.gridy = 1;
		add(lblQuestion, gbc_lblQuestion);
		
		String [][] rowData = new String [10][3];
		rowData[0][0] = "Platz";
		rowData[0][1] = "Name";
		rowData[0][2] = "Punktstand";
		
		model = new DefaultTableModel();
        
        // Die Titel der Spalten setzen
        model.setColumnIdentifiers( new Object[]{ "Platz", "Name", "Punktestand"});
        
        // Das Model mit zufälligen Daten befüllen
        Random random = new Random();
        for( int r = 0; r < 10; r++ ){
            Object[] row = new Object[ model.getColumnCount() ];
            
            for( int c = 0; c < row.length; c++ ){
                row[c] = random.nextInt( 9 ) + 1;
            }
            
            model.addRow( row );
        }
	        
        
		table = new JTable(model);
		table.setEnabled(false);
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 2;
		gbc_table.gridy = 1;
		JScrollPane sp = new JScrollPane(table);
		
		add(sp, gbc_table);

	}

	public void setQuestion(String question) {
		// TODO Auto-generated method stub
		lblQuestion.setText(question);
	}
	
	public void setRemainingTime(int time) {
		String stringTime = "";
		if(time < 10) {
			stringTime = "0" + time;
		} else {
			stringTime = "" + time;
		}
		lblRemainingTime.setText("Restliche Zeit: " + stringTime + "s");
	}

}
