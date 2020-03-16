package server.main;

import java.util.ArrayList;

import server.classes.MainServer;
import server.gui.ServerGUI;
import server.objects.Player;
import server.objects.Question;

public class Server extends MainServer {
	private ArrayList<Question> questions;
	private ArrayList<Player> players;
	private ServerGUI gui;
	
	public Server(int port) {
		super(port);
		questions = new ArrayList<Question>();
		players = new ArrayList<Player>();
	}
	
	/**
	 * Eine neue Verbindung verarbeiten:
	 * Wenn ein neuer Nutzer kommt: Player erstellen & WELCOMEBACK-Nachricht
	 * sonst Willkomensnachricht
	 */
	public void processNewConnection(String pClientIP, int pClientPort) {
		boolean newPlayer = true;
		for(Player player: players) {
			if(player.getIp().equals(pClientIP)) {
				send(pClientIP, pClientPort, "WELCOMEBACK:" + player.getName() + ":" + player.getPoints());
				newPlayer = false;
				break;
			}
		}
		if(newPlayer) {
			players.add(new Player(pClientIP,pClientIP, 0));
			send(pClientIP, pClientPort, "WELCOME:" + pClientIP + ":0");
		}
	}
	
	public void processMessage(String pClientIP, int pClientPort, String pMessage) {
		
		// Dem Nutzer einen neuen Namen vergeben
		if (pMessage.startsWith("CHANGENAME:")) {
			String name = pMessage.split(":")[1];
			for(Player player:players) {
				if(player.getIp().equals(pClientIP)) {
					player.setName(name);
					break;
				}
			}
		}
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
