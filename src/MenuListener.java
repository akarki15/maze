import java.awt.event.*;
import javax.swing.*;

public class MenuListener implements  ActionListener {
 
    JMenuItem i1;
    JMenuItem i2;
    JMenuItem i3;
    TheGame game;
    public MenuListener(JMenuItem gameItem1, JMenuItem gameItem2, JMenuItem exit, TheGame g){
	i1=gameItem1;
	i2=gameItem2;
	i3=exit;
	game=g;
    }

    public void actionPerformed(ActionEvent event){
	if (event.getSource()==i2)
	    game.switchGame2();
	else if(event.getSource()==i1)
	    game.switchGame1();
	else if (event.getSource()==i3)
	    game.solveThis();
    }

}
