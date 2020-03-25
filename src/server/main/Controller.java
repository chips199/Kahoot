package server.main;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

import server.gui.AddQuestionGUI;
import server.gui.ControllerGUI;
import server.gui.ServerGUI;
import server.objects.Player;
import server.objects.Question;

public class Controller {
	private ArrayList<Question> questions;
	private ArrayList<Player> players;
	private ServerGUI gui;
	private ControllerGUI controllerGUI;
	private Server server;
	private Question currentQuestion;
	private long startQuestionTime;
	private int serverPort;
	
	public Controller () {
		questions = new ArrayList<Question>();
		players = new ArrayList<Player>();
	}
	
	/**
	 * Methode um das Quiz zu starten
	 */
	public void startQuiz(ControllerGUI controllerGUI) {
		this.controllerGUI = controllerGUI;
		for(Question question: questions) {
			currentQuestion = question;
			String [] mixedAnswers = mixAnswers(question.getAnswer());
			controllerGUI.setQuestion(question.getQuestion());
			server.sendToAll("SENDANSWERS:" + mixedAnswers[0] + ":" + mixedAnswers[1] + ":" + mixedAnswers[2] + ":" + mixedAnswers[3]);
			startQuestionTime = System.currentTimeMillis();
			
			do {
				int remainingTime = 10 - (int) ((System.currentTimeMillis() - startQuestionTime) / 1000);
				controllerGUI.setRemainingTime(remainingTime);
				try {
					Thread.sleep(10);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} while (startQuestionTime + 10000 >= System.currentTimeMillis() || checkEveryoneHasAnswered());
			sendPointsToEach();
		}
		rangliste();
	}
	
	/**
	 * Überprüft ob jeder auf die Frage geantwortet hat.
	 * @return boolean
	 */
	public boolean checkEveryoneHasAnswered() {
		
		return false;
	}
	
	public boolean checkAnswer(String [] answers, String answer) {
		return answer.equals(answers[0]);
	}
	
	/**
	 * Mischt das Array durch
	 * @param answers
	 * @return
	 */
	public String [] mixAnswers(String [] answers) {
		 String tmp;
		 int rand;
		 Random r = new Random();
		   for(int i =0; i < answers.length; i++){
		     rand = r.nextInt(answers.length);
		     tmp = answers[i]; 
		     answers[i] = answers[rand]; 
		     answers[rand] =tmp;
		   }
		return answers;
	}
	
	/**
	 * Sendet den aktuellen Punktestand an die jeweiligen Spieler
	 */
	public void sendPointsToEach() {
		for(Player player: players) {
			server.send(player.getIp(), player.getPort(), "SENDPOINTS:" + player.getPoints());
		}
	}
	
	/**
	 * Getter und Setter-Methoden der Instanzvariable
	 */
	public boolean addPlayer(Player player) {
		return players.add(player);
	}
	
	public ArrayList<Player> getPlayers(){
		return players;
	}
	
	public boolean addQuestion(Question question) {
		return questions.add(question);
	}
	
	public ArrayList<Question> getQuestions(){
		return questions;
	}
	
	public void setStartQuestionTime (long startQuestionTime) {
		this.startQuestionTime = startQuestionTime;
	}
	
	public long getStartQuestionTime () {
		return startQuestionTime;
	}

	public void setPort(int port) {
		// TODO Auto-generated method stub
		this.serverPort = port;
	}
	public ControllerGUI getControllerGUI() {
		return controllerGUI;
	}
	public void setControllerGUI(ControllerGUI controllerGUI) {
		this.controllerGUI = controllerGUI;
	}
	public Question getCurrentQuestion() {
		return currentQuestion;
	}
	public void setCurrentQuestion(Question question) {
		this.currentQuestion = currentQuestion;
	}
	
	/**
	 * Ausgabe vom Spieler, der den ersten Platz erreicht hat.
	 */
	public void rangliste() {
		Player ersterPlatz = new Player("", "", 0, -10);
		for(Player player: players) {
			if(player.getPoints()>ersterPlatz.getPoints()) {
				ersterPlatz = player;
			}
		}
		JOptionPane.showMessageDialog(null, ersterPlatz.getName() + " ist mit " + ersterPlatz.getPoints() + " auf dem ersten Platz.", "Info", JOptionPane.INFORMATION_MESSAGE); 
	}
	
	public void startServer() {
		// TODO Auto-generated method stub
		server = new Server(serverPort, this);
	}
}
