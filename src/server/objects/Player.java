package server.objects;

public class Player {
	private String name;
	private String ip;
	private int port;
	private long points;
	
	public Player(String name, String ip, int port, int points) {
		super();
		this.name = name;
		this.ip = ip;
		this.port=port;
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
	public long getPoints() {
		return points;
	}
	public void setPoints(long points) {
		this.points = points;
	}
}
