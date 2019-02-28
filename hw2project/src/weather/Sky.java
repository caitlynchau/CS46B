package weather;

import java.util.ArrayList;
/**
 * Sky class aggregates clouds
 * @author Caitlyn Chau
 * CS 46B HW2
 */
public class Sky {
	private ArrayList<Cloud> clouds;
	

	/**
	 * Sky constructor initializes ArrayList of clouds with 100
	 */
	public Sky() {
		clouds = new ArrayList<Cloud>(100);
	}

	/**
	 * add method adds a cloud to clouds ArrayList
	 * @param c - cloud
	 * @return true
	 */
	public boolean add(Cloud c) {
		clouds.add(c);
		return true;
	}

	/**
	 * getMeanHeight method traverses through all clouds in ArrayList and returns the average height
	 * @return average height
	 */
	public float getMeanHeight() {
		float sum = 0;
		int i = 0;
		for (Cloud c : clouds) {
			sum += c.getHeight();
			i++;
		}
		return sum / i;
	}

	/**
	 * Main method
	 * @param args - argument
	 */
	public static void main(String[] args) {
		StratusCloud strat = new StratusCloud(100, 1000);
		if (!strat.rain().startsWith("It is raining"))
			System.out.println("Bad StratusCloud::rain");
		CumulusCloud cumu = new CumulusCloud(200, 2000);
		if (!cumu.rain().startsWith("It is raining"))
			System.out.println("Bad CumulusCloud::rain");
		CirrusCloud cirr = new CirrusCloud(300,3000);
		if (!cirr.rain().startsWith("I cannot make"))
			System.out.println("Bad CirrusCloud::rain");
		Sky sky = new Sky();
		sky.add(strat);
		sky.add(cumu);
		sky.add(cirr);
		float mean = sky.getMeanHeight();
		if (mean < 1799 || mean > 1801)
			System.out.println("Bad mean height: expected 1800, saw " + mean);
		System.out.println("Everything (else) is ok");
	}

}
