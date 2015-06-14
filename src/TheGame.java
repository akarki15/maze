import javax.swing.JTextArea;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Vector;

public class TheGame {

	MazeFrame frame;
	Button[][] graph;
	String gameType;
	State state;
	int winX;

	public TheGame(MazeFrame f, Button[][] g, String s, State st, int x) {
		winX = x;
		graph = g;
		frame = f;
		gameType = s;
		state = st;

		System.out.println("*********************************" + gameType);
	}

	public String gameT() {
		return gameType;
	}

	public void switchGame1() {
		frame.makeInvisible();

		frame.init("GameData.dat", "G1", 7);
	}

	public void switchGame2() {
		frame.makeInvisible();
		frame.init("GameData2.dat", "G2", 8);
	}

	public void everyTime(Button gridPosition) {

		if ((gridPosition.returnX() == winX)
				&& (gridPosition.returnY() == winX))
			winInfo();
		System.out.println("Everytiime!! game" + gameType);
		System.out.println(graph[0][0].returnNum() + "  "
				+ gridPosition.returnNum());

		Transition1 trans;
		if (gameType.equals("G1")) {
			trans = new Transition1(state, graph, gridPosition, frame);
		} else
			// (gameType.equals("G2"))
			trans = new Transition2(state, graph, gridPosition, frame);
		trans.makeTransition();

	}

	private void winInfo() {
		JOptionPane.showMessageDialog(null, "You did it!", "You win",
				JOptionPane.ERROR_MESSAGE);
	}

	public Vector<Button> returnTransition(State s) {
		Transition1 trans;
		if (gameType.equals("G1")) {
			trans = new Transition1(s, graph, null, frame);
		} else
			// (gameType.equals("G2"))
			trans = new Transition2(s, graph, null, frame);
		return trans.returnTransitionS();
	}

	public void solveThis() {
		// movesMade=new Vector <Location>(0);

		Solver so = new Solver(graph, this, winX, winX);
		Vector<State> solution = so.returnSolution();
		JFrame solutionF = new JFrame();
		solutionF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		String s = "";
		for (int i = 0; i < solution.capacity(); i++) {
			s = s + " " + (solution.elementAt(i).returnX()) + ","
					+ (solution.elementAt(i).returnX());
			s = s + "\n";
		}
		JTextArea a = new JTextArea(s);
		solutionF.add(a);
		solutionF.setSize(300, 300);
		solutionF.setVisible(true);

		// AnimateSolution ss=new AnimateSolution(solution, 3);
	}

}
