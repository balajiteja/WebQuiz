package WQ;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class AmzTest {

    public static class Point {

	public double x;

	public double y;

    }

    public static Point[] closestk(Point myList[], int k) {
	// first i will store the
	int i = 0;
	Point[] p = new Point[myList.length];
	Map<Point, Double> pointMap = new HashMap<Point, Double>();

	while (i < myList.length) {
	    pointMap.put(myList[i], distance(myList[i].x, myList[i].y));
	}
	Map<Point, Double> treeMap = new TreeMap<Point, Double>(
		new ValueComparator(pointMap));
	int j = 0;
	for (Point point : treeMap.keySet()) {
	    if (j == k) {
		p[j] = point;
		j++;
	    }
	}

	return p;

    }

    // function to return the distance of a point
    private static double distance(double x, double y) {

	return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));

    }

    private static class ValueComparator implements Comparator<Point> {

	Map<Point, Double> map;

	public ValueComparator(Map<Point, Double> map) {
	    this.map = map;
	}

	@Override
	public int compare(Point keyA, Point keyB) {

	    Double valueA = map.get(keyA);
	    Double valueB = map.get(keyB);

	    return valueB.compareTo(valueA);

	}

    }
}
