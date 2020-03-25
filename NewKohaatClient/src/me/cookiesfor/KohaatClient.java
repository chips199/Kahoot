package me.cookiesfor;

public class KohaatClient extends Client {
    String ip, name;
    int port, points;
    GUI_Client gui;

    public KohaatClient(String ip, int port, String name, GUI_Client gui) {
        super(ip, port);

        this.ip = ip;
        this.port = port;
        this.name = name;
        this.gui = gui;

        //Aktualisierung des Namens
        this.send("CHANGENAME:" + name);
    }

    public void processMessage(String message) {

        if (message.startsWith("WELCOME")) {
            System.out.println("Connection successful.");
        }

        if (message.startsWith("SENDANSWERS")) {

            String[] parameter = message.split(":");
            gui.newAnswers(parameter[1], parameter[2], parameter[3], parameter[4]);
        }

        if(message.startsWith("SENDPOINTS")) {

            String[] parameter = message.split(":");
            this.points = Integer.getInteger(parameter[1]);

            gui.newStatus(this.name, this.points);
        }
    }

    public void sendAnswer(String ans) {
        this.send("SENDANSWER:" + ans);
    }
}