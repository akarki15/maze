import java.awt.Color;
import java.awt.*;
import java.awt.Graphics;
import java.util.Vector;

/* Stores the current button as well as how we got there */
public class State extends Button {
	private Vector<Button> moves;

	public State(int n, int a, int b, Color c, String t) {
		super(n, c, a, b, t);
		moves = new Vector<Button>(0);

	}

	public State(Button l) {
		super(l.returnNum(), l.getColor(), l.returnX(), l.returnY(), l
				.returnType());
		moves = new Vector<Button>(0);
	}

	public State(Button l, Vector<Button> loc) {
		super(l.returnNum(), l.getColor(), l.returnX(), l.returnY(), l
				.returnType());
		moves = loc;
	}

	/*
	 * public void setBeenHere(){ beenHere=true; }
	 * 
	 * public boolean getBeenHere(){ return beenHere; }
	 */

	/*
	 * public void enableIt(){ System.out.println("Enabled");
	 * this.setEnabled(true); c=originalColor; repaint(); } public void
	 * disableIt(){ System.out.println("DISABLED"); this.setEnabled(false);
	 * c=Color.GRAY; repaint(); }
	 */

	public int returnLastX() {
		return (moves.lastElement().returnX());
	}

	public int returnLastY() {
		return (moves.lastElement().returnY());
	}

	public void addMovesMade(Button l) {
		System.out.println("moves Made" + this.returnNum());
		moves.add(l);
	}

	public void addMovesMade(Vector<Button> l) {
		moves = l;
	}

	public Vector<Button> returnMovesMade() {
		return moves;
	}
	/*
	 * public void paintComponent(Graphics g){ System.out.println(returnNum());
	 * Color c=getColor(); super.paintComponent(g);//have to keep this
	 * setBackground(c); System.out.println(c); g.setColor(Color.BLACK);
	 * //g.setFont(new Font("serif", Font.BOLD, 20));
	 * g.drawString(("hey"+returnNum()),30,50);
	 * 
	 * }
	 */

}
