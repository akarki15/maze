import java.awt.event.*;

public class ClickListener implements  ActionListener {
 
  
    Location gridPosition;
    private TheGame game;
    public ClickListener(Location l, TheGame g){
		game=g;
		gridPosition=l;
    }
    
    public void actionPerformed(ActionEvent e){
	
	game.everyTime(gridPosition);
	    
	    

	    }
    
    
}
