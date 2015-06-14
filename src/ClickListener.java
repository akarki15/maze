import java.awt.event.*;

public class ClickListener implements  ActionListener {
 
  
    Button gridPosition;
    private TheGame game;
    public ClickListener(Button l, TheGame g){
		game=g;
		gridPosition=l;
    }
    
    public void actionPerformed(ActionEvent e){
	
	game.everyTime(gridPosition);
	    
	    

	    }
    
    
}
