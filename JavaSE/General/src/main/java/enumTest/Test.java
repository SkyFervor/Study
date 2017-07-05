package enumTest;

public enum Test {
	RED(255, 0, 0), GREEN(0, 255, 0), BULE(0, 0, 255), BLACK(0, 0, 0), WHITE(255, 255, 255);

	private int r;
	private int g;
	private int b;

	Test(int r, int g, int b) {
		this.r = r;
		this.g = g;
		this.b = b;
	}

	public int r() {
		return r;
	}

	public int g() {
		return g;
	}

	public int b() {
		return b;
	}

	public int[] rgb() {
		int[] rgb = { r, g, b };
		return rgb;
	}

	public static Test fromValue(int r, int g, int b) {
		for (Test t : Test.values()) {
			if (t.r == r && t.g == g && t.b == b)
				return t;
		}
		return null;
	}
}
