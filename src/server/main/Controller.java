package server.main;

import java.util.ArrayList;

import server.gui.ServerGUI;
import server.objects.Player;
import server.objects.Question;

public class Controller {
	private ArrayList<Question> questions;
	private ArrayList<Player> players;
	private ServerGUI gui;
	private Server server;
	private long startQuestionTime;
	private int serverPort;
	
	public Controller () {
		questions = new ArrayList<Question>();
		players = new ArrayList<Player>();
	}
	
	/**
	 * Methode um das Quiz zu starten
	 */
	public void startQuiz() {
		for(Question question: questions) {
			String [] mixedAnswers = mixAnswers(question.getAnswer());
			server.sendToAll("SENDANSWERS:" + mixedAnswers[0] + ":" + mixedAnswers[1] + ":" + mixedAnswers[2] + ":" + mixedAnswers[3]);
			startQuestionTime = System.currentTimeMillis();
			do {
				try {
					Thread.sleep(10);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} while (startQuestionTime + 10000 >= System.currentTimeMillis() || everyoneHasAnswered());
			sendPointsToEach();
		}
	}
	
	/**
	 * Überprüft ob jeder auf die Frage geantwortet hat.
	 * @return boolean
	 */
	public boolean everyoneHasAnswered() {
		
		return false;
	}
	
	public boolean checkAnswer(int answer) {
		return true;
	}
	
	public String [] mixAnswers(String [] answers) {
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

	public void startServer() {
		// TODO Auto-generated method stub
		server = new Server(serverPort, this);
	}
}
