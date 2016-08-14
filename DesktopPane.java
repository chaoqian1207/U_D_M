package U_D_M;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;

public class DesktopPane extends JDesktopPane 
{
	private static final long serialVersionUID = 1L;
	private ImageIcon ico = new ImageIcon("D:\\FeigeDownload\\7.jpg");
	
	public void paintComponent(Graphics g)
	{
	     g.drawImage(ico.getImage(),0,0,this);
	}
}
