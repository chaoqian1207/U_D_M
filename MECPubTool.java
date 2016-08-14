package U_D_M;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

public class MECPubTool 
{
	public static final int showMess(JFrame jfrmMain, String mess, int ackType)
	{
		int userChoose;
		
		userChoose = JOptionPane.showConfirmDialog(jfrmMain, mess, "系统温馨提示", ackType);
		
		return userChoose;
	}
	
	public static final void showMess(JInternalFrame jfrmMain, String mess)
	{
		JOptionPane.showConfirmDialog(jfrmMain, mess, "系统温馨提示", JOptionPane.YES_NO_OPTION);
	}

	public static void showMess(JInternalFrame jfrmMain, String mess) {
		// TODO Auto-generated method stub
		
	}
}