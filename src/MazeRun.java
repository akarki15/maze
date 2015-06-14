public class MazeRun {

	public static void main(String[] args) {
		MazeFrame frame = new MazeFrame();
		String gameFile = System.getProperty("user.dir") + "/src/GameData.dat";
		frame.init(gameFile, "G1", 7);
	}
}
