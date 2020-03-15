package server.main;

import java.util.ArrayList;

import server.gui.ServerGUI;
import server.objects.Player;
import server.objects.Question;

public class Server {
	private ArrayList<Question> questions;
	private ArrayList<Player> players;
	private ServerGUI gui;
	
	public Server() {
		questions = new ArrayList<Question>();
		players = new ArrayList<Player>();
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
}
