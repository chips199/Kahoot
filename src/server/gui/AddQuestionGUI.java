package server.gui;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JButton;

public class AddQuestionGUI extends JPanel {
	private JTextField textField;
	private JTextField textField_rightAnswer;
	private JTextField textField_wrongAnswer1;
	private JTextField textField_wrongAnswer2;
	private JTextField textField_wrongAnswer3;

	/**
	 * Create the panel.
	 */
	public AddQuestionGUI() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Frage:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.anchor = GridBagConstraints.NORTH;
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Richtige Antwort:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textField_rightAnswer = new JTextField();
		GridBagConstraints gbc_textField_rightAnswer = new GridBagConstraints();
		gbc_textField_rightAnswer.insets = new Insets(0, 0, 5, 0);
		gbc_textField_rightAnswer.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_rightAnswer.gridx = 1;
		gbc_textField_rightAnswer.gridy = 1;
		add(textField_rightAnswer, gbc_textField_rightAnswer);
		textField_rightAnswer.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("1. Falsche Antwort:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		textField_wrongAnswer1 = new JTextField();
		GridBagConstraints gbc_textField_wrongAnswer1 = new GridBagConstraints();
		gbc_textField_wrongAnswer1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_wrongAnswer1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_wrongAnswer1.gridx = 1;
		gbc_textField_wrongAnswer1.gridy = 2;
		add(textField_wrongAnswer1, gbc_textField_wrongAnswer1);
		textField_wrongAnswer1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("2. Falsche Antwort:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		textField_wrongAnswer2 = new JTextField();
		GridBagConstraints gbc_textField_wrongAnswer2 = new GridBagConstraints();
		gbc_textField_wrongAnswer2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_wrongAnswer2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_wrongAnswer2.gridx = 1;
		gbc_textField_wrongAnswer2.gridy = 3;
		add(textField_wrongAnswer2, gbc_textField_wrongAnswer2);
		textField_wrongAnswer2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("3. Falsche Antwort:");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 4;
		add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		textField_wrongAnswer3 = new JTextField();
		GridBagConstraints gbc_textField_wrongAnswer3 = new GridBagConstraints();
		gbc_textField_wrongAnswer3.insets = new Insets(0, 0, 5, 0);
		gbc_textField_wrongAnswer3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_wrongAnswer3.gridx = 1;
		gbc_textField_wrongAnswer3.gridy = 4;
		add(textField_wrongAnswer3, gbc_textField_wrongAnswer3);
		textField_wrongAnswer3.setColumns(10);
		
		JButton btnAddQuestion = new JButton("Frage hinzuf\u00FCgen");
		GridBagConstraints gbc_btnAddQuestion = new GridBagConstraints();
		gbc_btnAddQuestion.insets = new Insets(0, 0, 5, 0);
		gbc_btnAddQuestion.fill = GridBagConstraints.VERTICAL;
		gbc_btnAddQuestion.gridx = 1;
		gbc_btnAddQuestion.gridy = 5;
		add(btnAddQuestion, gbc_btnAddQuestion);
		
		JButton btnForward = new JButton("Weiter");
		GridBagConstraints gbc_btnForward = new GridBagConstraints();
		gbc_btnForward.gridx = 1;
		gbc_btnForward.gridy = 6;
		add(btnForward, gbc_btnForward);

	}

}
