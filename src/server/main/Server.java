package server.main;

import java.util.ArrayList;

import server.gui.ServerGUI;
import server.objects.Player;
import server.objects.Question;
import server.objects.Connection;

public class Server {
	private ArrayList<Question> questions;
	private ArrayList<Player> players;
	private ServerGUI gui;
	private Connection con;
	
	public Server(String ip, int port) {
		questions = new ArrayList<Question>();
		players = new ArrayList<Player>();
		con = new Connection(ip, port);
	}
	
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
}
