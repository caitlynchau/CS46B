package weather;

/**
 * Cloud class represents a cloud
 * @author Caitlyn Chau
 * CS 46B HW2
 */
public class Cloud {
	private float top, bottom;
	
	/**
	 * Cloud constructor takes in the top and bottom measurements of a cloud
	 * @param bottom - bottom height
	 * @param top - height
	 */
	public Cloud(float bottom, float top){
		this.bottom = bottom;
		this.top = top;
	}
	
	/**
	 * getHeight method returns the height of the cloud
	 * @return top minus bottom height
	 */
	public float getHeight(){
		return top - bottom;
	}
	
	/**
	 * rain method prints out a message "It is raining"
	 * @return String
	 */
	public String rain(){
		return "It is raining";
	}
}
