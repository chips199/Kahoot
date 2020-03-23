package server.objects;

public class Player {
	private String name;
	private String ip;
	private int port;
	private int points;
	
	public Player(String name, String ip, int port, int points) {
		super();
		this.name = name;
		this.ip = ip;
		this.points = points;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public int compareTo(Player player){
		return ((Integer)this.getPoints()).compareTo((Integer)player.getPoints());
	}
}
