import java.awt.Color;
import java.awt.*;
import java.awt.Graphics; 
import java.util.Vector;
public class State1 extends Location{
    private Vector <Location> moves;
   
   
   
   
    public State1(int n, int a, int b, Color c,String t){
	super(n,c,a,b, t);
	moves=new Vector<Location>(0);

    }
    public State1(Location l){
	super (l.returnNum(), l.getColor(), l.returnX(), l.returnY(), l.returnType());
	moves=new Vector<Location>(0);
    }
    public State1(Location l, Vector<Location> loc){
	super (l.returnNum(), l.getColor(), l.returnX(), l.returnY(), l.returnType());
	moves=loc;
    }

/*
    public void setBeenHere(){
	beenHere=true;
    }

    public boolean getBeenHere(){
	return beenHere;
    }

*/
    
  
 
    /*
    public void enableIt(){
	System.out.println("Enabled");
	this.setEnabled(true);
	c=originalColor;
	repaint();
    }
    public void disableIt(){
	System.out.println("DISABLED");
	this.setEnabled(false);
	c=Color.GRAY;
	repaint();
    }
    */

    public int returnLastX(){
	return (moves.lastElement().returnX());
    }

    public int returnLastY(){
	return (moves.lastElement().returnY());
    }


    public void addMovesMade(Location l){
	System.out.println("moves Made" +this.returnNum() );
	moves.add(l);
    }
    public void addMovesMade(Vector <Location> l){
      moves=l;
    }

    public Vector <Location> returnMovesMade(){
	return moves;
    }
    /*
    public void paintComponent(Graphics g){
	System.out.println(returnNum());
	Color c=getColor();
	super.paintComponent(g);//have to keep this
	setBackground(c);
	System.out.println(c);
	g.setColor(Color.BLACK);
	//g.setFont(new Font("serif", Font.BOLD, 20));
	g.drawString(("hey"+returnNum()),30,50);

    }

    */
    
}

