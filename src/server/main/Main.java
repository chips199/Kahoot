package server.main;

import server.gui.ServerGUI;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Controller controller = new Controller();
		ServerGUI serverGUI = new ServerGUI(controller);
	}

}
