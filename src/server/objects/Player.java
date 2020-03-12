package server.objects;

public class Player {
	private String name;
	private String ip;
	private int points;
	
	public Player(String name, String ip, int points) {
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
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
}
