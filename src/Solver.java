import java.util.Vector;
import java.util.Scanner;
import java.io.*;

public class Solver{
    private int checker=0;
    private int winX;
    private int winY;
    private  Location[][] graph;
    private    TheGame g;
    
    private int startX=0;
    private int startY=0;
    private boolean found=false;
 
    
    public Solver(Location[][] r, TheGame ga, int x, int y){
	graph=r;
	g=ga;
	winX=x-1;
	winY=y-1;
	
    }
    private Vector <State1> solution;
    public Vector <State1> returnSolution(){
	solution=new Vector<State1>(0);
	State1 startState=new State1(graph[startX][startY]);
	//	solution.add(startState);
	
	if (startX==winX && startY==winY) {
	    return solution;
	}
	else {
	    
	    found= returnSolution2(startState);
	}
	System.out.println("found or not??"+found);
	System.out.println("=======================================");
	solution.trimToSize();
	//	for (int i=0;i<solution.capacity();i++){

	//  State1 x=solution.elementAt(i);
	//  System.out.println(x.returnX()+","+x.returnY());
	//	}
	
	return solution;
    }



	/////////////////////////////////////////
    public boolean returnSolution2(State1 state){
	boolean foundIt=false;
	solution.add(state);
     
	
	
	
	//	System.out.println("State -------------"+s.returnX()+","+s.returnY());
	

       	if ((state.returnX()==winX && state.returnY()==winY )){
	    System.out.println("Found it!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
	    foundIt=true;
	    return true;
	}
	


	
	Vector<Location> l=g.returnTransition(state);
	System.out.println("Transitions possible :"+l.capacity());
	if (l.capacity()==0) {
	    System.out.println("Capacity =0, return false");
	    return false;
	}
	for ( int i=0;i<l.capacity();i++){
	    System.out.println("FOR ERROR RRRRRRRRRRRRRRR+"+i);
	    Vector <Location> passLocations=state.returnMovesMade();
	    passLocations.add(state);//State is Location ####################
	    State1 newState=new State1(l.elementAt(i),passLocations);
	    System.out.println("new State "+newState.returnX()+","+newState.returnY()+"     "+winX+","+winY+"   "+newState.returnLastX()+"  "+newState.returnLastY());
	    boolean foundInList=false;
	    solution.trimToSize();
	    for (int j=0;j<solution.capacity();j++){
		//	System.out.println("....."+j);
		State1 tempState=solution.elementAt(j);
		
		
		if(tempState.returnLastX()==newState.returnLastX() && tempState.returnLastY()==newState.returnLastY() && tempState.returnX()==newState.returnX() && tempState.returnY()==newState.returnY()){
		    System.out.println("repeated move"+newState.returnX()+"  . "+newState.returnY());
		    foundInList=true;
		}
	    }
	    
	    if (foundInList==false)
		foundIt= returnSolution2(newState);
	    System.out.println("for loop "+found);	 
	    if (foundIt ==true) 
	     break;
	    
	    System.out.println("CHECKER HERE"+(checker++)+" solution size");
	    for (int k=0;k<solution.capacity();k++){
		System.out.println( solution.elementAt(k).returnNum());
	    }
	  
	    //solution.trimToSize();
	    //if (foundIt ==false)
	    //olution.removeElementAt(solution.capacity());
	    
		
		
	    //}
	}
	    /*
	      System.out.println("RETURNING!!!!!!!!................");
	      solution.trimToSize();
	      if (found==false && solution.capacity()>1)
	      System.out.println("     capacity is "+solution.capacity());
	      solution.removeElementAt(solution.capacity()-1);
	      return found;
	    */
	return foundIt;
    }
}
    







	 
	



