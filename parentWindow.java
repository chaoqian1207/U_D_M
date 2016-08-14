package U_D_M;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class parentWindow 
{
	private JFrame jfrmMain;
	private Container cont;
	
	private DesktopPane jdtpBorder;
	private JLabel jlblBackground;
	
	private void initFrame()
	{
		jfrmMain = new JFrame("微易码管理信息系统");
		cont = jfrmMain.getContentPane();
		jfrmMain.setExtendedState(JFrame.MAXIMIZED_BOTH);
		jfrmMain.setVisible(true);
		
		jdtpBorder = new DesktopPane();

		ImageIcon imgiBackground = new ImageIcon("D:\\FeigeDownload\\7.jpg");
		imgiBackground.setImage(imgiBackground.getImage().getScaledInstance(
			jfrmMain.getWidth(), jfrmMain.getHeight(), Image.SCALE_DEFAULT));
		jlblBackground = new JLabel(imgiBackground);
		jlblBackground.setIcon(imgiBackground);
		jlblBackground.setBounds(0, 0, jfrmMain.getWidth(), jfrmMain.getHeight());
		cont.add(jdtpBorder);

		JMenuBar jmubMain;
		JMenu jmnuMenu;
		JMenuItem jmniItem;
		
		jmubMain = new JMenuBar();
		jmnuMenu = new JMenu("系统管理");
		jmniItem = new JMenuItem("院校系管理");
		
		jmnuMenu.add(jmniItem);
		jmubMain.add(jmnuMenu);
		jfrmMain.setJMenuBar(jmubMain);
		
		jmniItem.addActionListener
		(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent arg0) 
				{
					new U_D_MInfo(jdtpBorder, "201507001", "张三疯");
				}
			}
		);
		
		jfrmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jfrmMain.setVisible(true);
		jfrmMain.setResizable(false);
	}
	
	public parentWindow()
	{
		initFrame();
	}
	
	public static void main(String[] arg)
	{
		new parentWindow();
	}
}
