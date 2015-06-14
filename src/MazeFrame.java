import java.util.Scanner;
import java.io.*;
import java.awt.Color;
import java.awt.*;
import javax.swing.*;

public class MazeFrame {
	private int rowCount;
	private Location[][] graph;

	private String gameType;
	private TheGame game;
	private String fileName;
	private JFrame pane;

	public void init(String f, String gt, int row) {
		rowCount = row;
		fileName = f;
		gameType = gt;		
		graph = new Location[rowCount][rowCount];

		pane = new JFrame();

		plot(f);

		State1 state = new State1(graph[0][0].returnNum(), 0, 0,
				graph[0][0].getColor(), "s");

		game = new TheGame(this, graph, gameType, state, rowCount);
		System.out.println(game.gameT());
		addListen(graph);

		pane.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pane.setJMenuBar(menu());
		Container grid = gridPlot(graph);

		pane.add(grid);

		pane.setSize(600, 600);
		pane.setVisible(true);

	}

	private void addListen(Location[][] graph) {

		for (int i = 0; i < rowCount; i++) {
			for (int j = 0; j < rowCount; j++) {
				Location x = graph[i][j];

				ClickListener click = new ClickListener(x, game);
				x.addActionListener(click);
			}
		}
	}

	public void makeInvisible() {
		pane.setVisible(false);
	}

	public Container gridPlot(Location[][] graph) {
		Container ct = new Container();
		ct.setLayout(new GridLayout(rowCount, rowCount));

		ct.setBackground(Color.BLACK);
		ct.setLayout(new GridLayout(8, 8, 2, 2));
		for (int i = 0; i < rowCount; i++) {
			for (int j = 0; j < rowCount; j++) {
				if (graph[i][j] != null)
					ct.add(graph[i][j]);

			}
		}
		return ct;
	}

	public void plot(String filename) {
		Scanner sc = null;
		try {
			sc = new Scanner(new FileReader(filename));
		} catch (FileNotFoundException ex) {
			System.out.println(ex);
			System.exit(1);
		}

		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph.length; j++) {
				if (sc.hasNextInt()) {
					Color c;
					String type = "m";
					if (i == 0 && j == 0) {
						type = "s";
						c = new Color(228, 56, 43);
					} else if ((i + j) % 2 != 0)
						c = new Color(167, 247, 141);
					else
						c = new Color(106, 213, 249);

					// System.out.println("i :"+ i+" j:  "+j+ c);
					Location x = new Location(sc.nextInt(), c, i, j, type);

					/*
					 * if (i==0 && j==0) x.enableIt(); else x.disableIt();
					 */
					graph[i][j] = x;
					c = Color.BLUE;
				} else if ((i == graph.length - 1) && (j == graph.length - 1)) {
					Location s = new Location(0, Color.YELLOW, i, j, "e");
					// s.setEnabled(false);
					graph[i][j] = s;
				}
			}
		}
	}

	public JMenuBar menu() {
		JMenuBar menubar = new JMenuBar();
		menubar.setLayout(new FlowLayout());
		JMenu gameMenu = new JMenu("Select Game");
		gameMenu.add(new JSeparator());
		JMenu exitMenu = new JMenu("Help");
		exitMenu.add(new JSeparator());
		JMenuItem gameItem1 = new JMenuItem("Maze1");
		JMenuItem gameItem2 = new JMenuItem("Maze1 with no-U-turn rule");
		JMenuItem exitItem = new JMenuItem("Solve");
		JMenuItem exit = new JMenuItem("Solve the maze. ");

		MenuListener listen = new MenuListener(gameItem1, gameItem2, exit, game);
		gameItem1.addActionListener(listen);
		gameItem2.addActionListener(listen);
		exit.addActionListener(listen);

		gameMenu.add(gameItem1);
		gameMenu.add(gameItem2);
		exitMenu.add(exit);
		menubar.add(gameMenu);
		menubar.add(exitMenu);
		return menubar;
	}

}
