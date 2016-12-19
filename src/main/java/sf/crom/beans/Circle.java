package sf.crom.beans;

public class Circle {
	int circleID;
	public Circle(int circleID, String name) {
		super();
		this.circleID = circleID;
		this.name = name;
	}
	public int getCircleID() {
		return circleID;
	}
	public void setCircleID(int circleID) {
		this.circleID = circleID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	String name;

}
