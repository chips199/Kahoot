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
			System.out.println("Port:" + pClientPort);
			controller.addPlayer(new Player(pClientIP, pClientIP, pClientPort, 0));
			send(pClientIP, pClientPort, "WELCOME:" + pClientIP + ":0");
		}
		//controller.getControllerGUI().showRangliste();
	}
	
	public void processMessage(String pClientIP, int pClientPort, String pMessage) {
		System.out.println("Port2" + pClientPort);
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
			String answer = pMessage.split(":")[1];
			if(controller.checkAnswer(controller.getCurrentQuestion().getAnswer(), answer) && currentTimeStamp - controller.getStartQuestionTime() <= 10000) {
				for(Player player:controller.getPlayers()) {
					if(player.getIp().equals(pClientIP)) {
						if(player.getPort() != 0) {
							player.setPoints((int) (player.getPoints() + currentTimeStamp - controller.getStartQuestionTime()));
							System.out.println(player.getPoints());
						}
					}
				}
			}
		}
		
	}
	public void processClosedConnection(String pClientIP, int pClientPort) {
		for(Player player:controller.getPlayers()) {
			if(player.getIp().equals(pClientIP)) {
				player.setPort(0);
				break;
			}
		}
	}
}
