package server.main;


import server.classes.MainServer;
import server.gui.ServerGUI;
import server.objects.Player;

public class Server extends MainServer {
	private Controller controller;
	private ServerGUI gui;
	
	public Server(int port, Controller controller) {
		super(port);
		this.controller = controller;
	}
	
	/**
	 * Eine neue Verbindung verarbeiten:
	 * Wenn ein neuer Nutzer kommt: Player erstellen & WELCOMEBACK-Nachricht
	 * sonst Willkomensnachricht
	 */
	public void processNewConnection(String pClientIP, int pClientPort) {
		boolean newPlayer = true;
		for(Player player: controller.getPlayers()) {
			if(player.getIp().equals(pClientIP)) {
				player.setPort(pClientPort);
				send(pClientIP, pClientPort, "WELCOMEBACK:" + player.getName() + ":" + player.getPoints());
				newPlayer = false;
				break;
			}
		}
		if(newPlayer) {
			controller.addPlayer(new Player(pClientIP,pClientIP, pClientPort, 0));
			send(pClientIP, pClientPort, "WELCOME:" + pClientIP + ":0");
		}
	}
	
	public void processMessage(String pClientIP, int pClientPort, String pMessage) {
		
		// Dem Nutzer einen neuen Namen vergeben
		if (pMessage.startsWith("CHANGENAME:")) {
			String name = pMessage.split(":")[1];
			for(Player player:controller.getPlayers()) {
				if(player.getIp().equals(pClientIP)) {
					player.setName(name);
					break;
				}
			}
		// User antwortet auf Frage
		} else if(pMessage.startsWith("SENDANSWER:")) {
			long currentTimeStamp = System.currentTimeMillis();
			int answer = (int) Integer.valueOf(pMessage.split(":")[1]);
			if(controller.checkAnswer(answer)) {
				for(Player player:controller.getPlayers()) {
					if(player.getIp().equals(pClientIP)) {
						player.setPoints((int) (player.getPoints() + currentTimeStamp - controller.getStartQuestionTime()));
					}
				}
			}
		}
		
	}
}
