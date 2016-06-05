package wat;

public class Player {
	private String name;
	private String httpSessionId;
	private Tile location;
	
	public Player(String name, String httpSessionId) {
		setName(name);
		setHttpSessionId(httpSessionId);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHttpSessionId() {
		return httpSessionId;
	}
	public void setHttpSessionId(String httpSessionId) {
		this.httpSessionId = httpSessionId;
	}

	public Tile getLocation() {
		return location;
	}

	public void setLocation(Tile location) {
		this.location = location;
	}
	
}
