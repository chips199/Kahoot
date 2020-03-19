package server.gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;
import java.util.Random;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ControllerGUI extends JPanel {
	private JTable table;
	private final DefaultTableModel model;

	/**
	 * Create the panel.
	 */
	public ControllerGUI() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JButton btnNewButton = new JButton("Start");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 0;
		add(btnNewButton, gbc_btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Wie hei\u00DFt die Bundepr\u00E4sidentin?");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		add(lblNewLabel, gbc_lblNewLabel);
		
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

}
