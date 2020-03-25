package client;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GUI_Client extends JFrame implements ActionListener
{
    private JLabel ipInputLabel, ipPortInputLabel, ipNameInputLabel, namePointsLabel, errorLog;
    private JTextField ipInput, portInput, nameInput;
    private JButton connect, ans0, ans1, ans2, ans3;
    private boolean sent;
    private KohaatClient kohaatClient;

    public GUI_Client()
    {
        super("Kohaat Client");
        setSize (1000, 1000);
        setLocation (100,100);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);

        sent = false;

        ipInputLabel = new JLabel ("IP des Servers:");
        ipInputLabel.setBounds(30,20,150,20);
        add(ipInputLabel);

        ipPortInputLabel = new JLabel ("Port des Servers:");
        ipPortInputLabel.setBounds(30,60,150,20);
        add(ipPortInputLabel);

        ipNameInputLabel = new JLabel ("Dein Name:");
        ipNameInputLabel.setBounds(30,100,150,20);
        add(ipNameInputLabel);

        namePointsLabel = new JLabel ("");
        namePointsLabel.setBounds(5,5,400,20);
        add(namePointsLabel);
        namePointsLabel.setVisible(false);

        errorLog = new JLabel ("");
        errorLog.setBounds(200,150,500,20);
        add(errorLog);
        errorLog.setVisible(true);

        ipInput = new JTextField();
        ipInput.setBounds(200,20,200,20);
        add(ipInput);

        portInput = new JTextField();
        portInput.setBounds(200,60,200,20);
        add(portInput);

        nameInput = new JTextField();
        nameInput.setBounds(200,100,200,20);
        add(nameInput);

        connect = new JButton("Connect");
        connect.setBounds(30,150,150,40);
        add (connect);
        connect.addActionListener(this);

        ans0 = new JButton("Waiting...");
        ans0.setBounds(30,50,400,60);
        ans0.setBackground(Color.GREEN);
        add (ans0);
        ans0.addActionListener(this);
        ans0.setVisible(false);

        ans1 = new JButton("Waiting...");
        ans1.setBounds(500,50,400,60);
        ans1.setBackground(Color.RED);
        add (ans1);
        ans1.addActionListener(this);
        ans1.setVisible(false);

        ans2 = new JButton("Waiting...");
        ans2.setBounds(30,200,400,60);
        ans2.setBackground(Color.YELLOW);
        add (ans2);
        ans2.addActionListener(this);
        ans2.setVisible(false);

        ans3 = new JButton("Waiting...");
        ans3.setBounds(500,200,400,60);
        ans3.setBackground(Color.BLUE);
        add (ans3);
        ans3.addActionListener(this);
        ans3.setVisible(false);

        setVisible (true);
    }

    public void actionPerformed(ActionEvent ev){
        if (ev.getSource() == connect) {

            try {

                kohaatClient = new KohaatClient(ipInput.getText(), Integer.valueOf(portInput.getText()), nameInput.getText(), this);

                errorLog.setVisible(false);
                ipInputLabel.setVisible(false);
                ipPortInputLabel.setVisible(false);
                ipNameInputLabel.setVisible(false);

                ipInput.setVisible(false);
                portInput.setVisible(false);
                nameInput.setVisible(false);

                connect.setVisible(false);

                namePointsLabel.setVisible(true);
                ans0.setVisible(true);
                ans1.setVisible(true);
                ans2.setVisible(true);
                ans3.setVisible(true);

            } catch(NullPointerException e) {

                ipInput.setText("");
                portInput.setText("");

                System.out.println(e.getMessage());
                e.printStackTrace();
                errorLog.setText("An error occured while establishing your connection.");
            }

        } else {
            if(sent) return;
            sent = true;

            if(ev.getSource() == ans0) {
                kohaatClient.sendAnswer(ans0.getText());

            } else if(ev.getSource() == ans1) {
                kohaatClient.sendAnswer(ans1.getText());

            } else if(ev.getSource() == ans2) {
                kohaatClient.sendAnswer(ans2.getText());

            } else if(ev.getSource() == ans3) {
                kohaatClient.sendAnswer(ans3.getText());
            }
        }
    }

    public void newAnswers(String newAns0, String newAns1, String newAns2, String newAns3) {

        sent = false;

        ans0.setText(newAns0);
        ans1.setText(newAns1);
        ans2.setText(newAns2);
        ans3.setText(newAns3);

    }

    public void newStatus(String name, int points) {

        namePointsLabel.setText("Player: " + name + "Current Points: " + points);
    }
}