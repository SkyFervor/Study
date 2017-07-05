package question.ccf;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test2 {
	public static List<Window> windows = new ArrayList<Window>();
	public static int maxLevel = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		for (int i = 0; i < n; i++) {
			Window window = new Window(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
			window.setLevel(maxLevel);
			maxLevel++;

			windows.add(window);
		}

		List<int[]> coords = new ArrayList<int[]>();
		for (int i = 0; i < m; i++) {
			int[] coord = new int[2];
			coord[0] = sc.nextInt();
			coord[1] = sc.nextInt();

			coords.add(coord);
		}
		sc.close();

		for (int[] coord : coords) {
			int topside = click(coord);

			if (topside != 0)
				System.out.println(topside);
			else
				System.out.println("IGNORED");
		}
	}

	public static int click(int[] coord) {
		List<Integer> inWindows = new ArrayList<Integer>();
		for (int i = 0; i < windows.size(); i++) {
			Window window = windows.get(i);
			if (window.isIn(coord[0], coord[1]))
				inWindows.add(i);
		}

		int topside = 0;
		for (Integer in : inWindows)
			if (windows.get(in).getLevel() > windows.get(topside).getLevel())
				topside = in;

		if (!inWindows.isEmpty()) {
			Window window = windows.get(topside);
			window.setLevel(maxLevel);
			maxLevel++;

			return window.getId();
		} else
			return 0;
	}
}

class Window {
	private static int maxId = 1;
	private int id;
	private int x1, y1;
	private int x2, y2;
	private int level = 0;

	public Window(int x1, int y1, int x2, int y2) {
		id = maxId;
		maxId++;

		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the level
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * @param level
	 *        the level to set
	 */
	public void setLevel(int level) {
		this.level = level;
	}

	public boolean isIn(int x, int y) {
		if (x1 <= x && x <= x2)
			if (y1 <= y && y <= y2)
				return true;

		return false;
	}
}