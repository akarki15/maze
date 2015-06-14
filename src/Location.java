import java.util.Vector;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.*;
public class Location extends JButton{
    private int x;
    private int y;
    private int num;
    private String type; //s for start, m for mid, e for end
    private Color c;
    private Color oColor;
    private Vector <Location> transitionS;
    

    public Location(int n, Color col, int a, int b, String typ){
	oColor=col;
	x=a;
	y=b;
	type=typ;
	num=n;
	c=col;
      
    }
    public int returnNum(){
	return num;
    }
   
    public void setOriginalColor(){
	c=oColor;
	repaint();
    }
    public String typeButton(){
	return type;
    }
    public int returnX(){return x;}
    public int returnY(){return y;}
    public void setColor(Color col){
	c=col;
	repaint();
    }
    public Color  getColor(){
	return c;
    }
    public String returnType(){
	return type;
    }
    public void enableIt(){
	this.setEnabled(true);
    }
    public void disableIt(){
	this.setEnabled(false);
    }
    public void setAgain(int a,int b, int n){
	x=a;
	y=b;
	num=n;
    }

  
    public void paintComponent(Graphics g){

      
	super.paintComponent(g);
	setBackground(c);

	g.setColor(Color.BLACK);
	g.setFont(new Font("serif", Font.BOLD, 20));
	g.drawString((""+returnNum()),30,50);

    }




}
