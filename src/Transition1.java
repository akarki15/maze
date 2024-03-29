import java.util.Vector;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.JOptionPane;

public class Transition1 {

	private Vector<Button> transitionS;

	private State state;
	private Button[][] graph;
	private Button gridPosition;
	private MazeFrame frame;
	boolean correctMove;

	public Transition1(State s, Button[][] loc, Button l, MazeFrame frame) {
		System.out.println("Transition1");
		state = s;
		graph = loc;
		gridPosition = l;

	}

	public void makeTransition() {
		Vector<Button> newLocations = returnTransitionS();
		correctMove = isItCorrect(newLocations);

		int x = gridPosition.returnX();
		int y = gridPosition.returnY();
		System.out.println("!-------------------" + x + ", " + y);
		if (correctMove) {
			graph[x][y].setColor(Color.black);

			// graph[state.returnX()][state.returnY()].disableIt();

			state.setAgain(x, y, gridPosition.returnNum());
			state.addMovesMade(gridPosition);
			System.out.println("State number is " + state.returnNum());
		} else if (!(state.returnX() == 0 && state.returnY() == 0 && x == 0 && y == 0)) {

			errorMove();
		}
	}

	public void errorMove() {

		JOptionPane.showMessageDialog(null,
				"This is not a valid move. Try Again", "Wrong Move",
				JOptionPane.ERROR_MESSAGE);

	}

	public boolean isItCorrect(Vector<Button> newLocations) {
		for (int i = 0; i < newLocations.capacity(); i++) {
			System.out.println("activated "
					+ newLocations.elementAt(i).returnX() + " ,"
					+ newLocations.elementAt(i).returnY());
			if ((newLocations.elementAt(i).returnX() == gridPosition.returnX())
					&& (newLocations.elementAt(i).returnY() == gridPosition
							.returnY()))
				return true;
		}
		return false;
	}

	public State getState() {
		return state;
	}

	public Button[][] getGraph() {
		return graph;
	}

	public Vector<Button> returnTransitionS() {
		System.out.println("This is Transition1  ");
		int size = graph.length;
		int num = state.returnNum();
		int i = state.returnX();
		int j = state.returnY();
		System.out.println("state is " + i + " ," + j);
		Vector<Button> transitionS = new Vector<Button>(0);

		if (num < (size - j)) {
			System.out.println("1:" + i + "," + (j + num));
			transitionS.add(graph[i][j + num]);

		}
		if (num < (size - i)) {
			transitionS.add(graph[i + num][j]);
			System.out.println("2");
		}
		if (j >= num) {
			transitionS.add(graph[i][j - num]);
			System.out.println("3");
		}
		if (i >= num) {
			transitionS.add(graph[i - num][j]);
			System.out.println(" 4");
		}
		transitionS.trimToSize();
		System.out.println("SIze is t2: " + transitionS.capacity());
		return transitionS;
	}
}
