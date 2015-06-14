import java.util.Vector;
import java.awt.Color;
public class Transition2 extends Transition1{
    
    public Transition2(State s, Button[][]g, Button l, MazeFrame f){
	super(s,g,l,f);
	System.out.println("Constructor : state : "+s.returnX()+" "+s.returnY());
    }

    public Vector<Button> returnTransitionS(){

	System.out.println("This is transition 2 huhaaa");
	State state=getState();
	Button[][]graph=getGraph();
	Vector<Button> movesMade=state.returnMovesMade();

	Button lastLocation;
	movesMade.trimToSize();


	if (movesMade.capacity()>1){
	    lastLocation=movesMade.elementAt(movesMade.capacity()-2);
	}
	else 
	    lastLocation=new Button(0,Color.RED, 1,1, "m");
	
	int size=graph.length;
	int num=state.returnNum();
	int i=state.returnX();
	int j=state.returnY();
	Vector <Button> transitionS=new Vector <Button>(0);
	int lastI=lastLocation.returnX();
	int lastJ=lastLocation.returnY();
	

	System.out.println(size+" "+num+" "+i+" "+j+" "+lastI+" "+lastJ);
	if (num<(size-j) && (lastI!=i) ){
	    //System.out.println("added 1 TRANSITION2");
	    transitionS.add(graph[i] [j+num]);
	}
	else if(num<(size-j) && (lastI==i)){
	    if ((j>lastJ && j<(j+num) )||(j>(j+num) && j<lastJ))
		transitionS.add(graph[i][j+num]);
	}
	
	if (num<(size-i) && lastJ!=j){
	    transitionS.add(graph[i+num][j]);
	    // System.out.println("2 TRANSITION2");
	}
	else if(num<(size-i) && lastJ==j){
	    if ((i>lastI && i<(i+num))|| (i>(i+num) && i<lastI))
		transitionS.add(graph[i+num][j]);
	}

	if (j>=num && lastI!=i){
	    transitionS.add(graph[i][j-num]);
	    //System.out.println("3 TRANSITION2");
	}
	else if(j>=num && lastI==i){
	    if ((j>lastJ  && j<(j-num) )||(j>(j-num) && j<lastJ))
		transitionS.add(graph[i][j-num]);
	}
	
	if (i>=num && lastJ!=j){
	    transitionS.add(graph[i-num][j]);
	    // System.out.println("4 TRANSITION2");
	}
	else if(i>=num && lastJ==j){
	    if ((i>lastI && i<(i-num))|| (i>(i-num) && i<lastI))
		transitionS.add(graph[i-num][j]);
	}


	//System.out.println("SIze is "+ transitionS.capacity());
	return transitionS;
    }
}


	
