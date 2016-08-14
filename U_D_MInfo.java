package U_D_M;
	import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.ResultSet;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

  public class U_D_MInfo 
	{
	
	 private JInternalFrame jfrmMain;
	 private DesktopPane jdtpParent;
	 private Container con;
	 
	 private JLabel jlblTopic;
	 
	 private JComboBox jcboshow;
	 private static final String msg[] = {"显示可用信息","显示全部信息"};
	 
	 private JLabel jlblname;
	 
	 private DefaultListModel <String>dlmUniveristy;
	 private JList <String> jlstUniveristy;
	 private JScrollPane  jscpUniveristy;
	 private JLabel jlblUniveristy;
	 
	 private DefaultListModel <String>dlmDepartment;
	 private JList <String> jlstDepartment;
	 private JScrollPane  jscpDepartment;
	 private JLabel jlblDepartment;
	 
	 private DefaultListModel <String>dlmMajor;
	 private JList <String> jlstMajor;
	 private JScrollPane  jscpMajor;
	 private JLabel jlblMajor;
	 
	 private JLabel jlblSelectname;
	 private JTextField jtflSelectname;
	 
	 private ButtonGroup bgIsused;
	 private JRadioButton [] jrdbIsused;
	 
	 private JButton jbtnExit;
	 private JButton jbtnAdd;
	 private JButton jbtnModify;
	 
	 private static final int ADD = 1;
	 private static final int MODIFY = 2;
	 
	 private static final int CQ=1;
	 private static final int QC=0;
	 
	 private static final int Univeristy=0;
	 private static final int Department=1;
	 private static final int Major=2;
	 
	 private static int ZH;
	 
	 private String oldselectname;
	 private JLabel jlblnumber;
	 
	 public U_D_MInfo()
	 {
		 this(null,null,null);
	 }
	 
	 public U_D_MInfo(DesktopPane jdtpPane, String userId, String userName)
	 {
		 jdtpParent = jdtpPane;
		   interFrame();
		   reinterFrame();
		   dealAction();
	 }
	 
	 
	 private void interFrame()
	 {
		  Font normalFont = new Font("宋体",Font.PLAIN,15);
		 
		   jfrmMain = new JInternalFrame("微信码科技信息管理系统-院校系管理",false,true,false,true);
		   con = jfrmMain.getContentPane();
		   con.setLayout(null);
		   jfrmMain.setSize(7908/15, 6792/15);
		   jfrmMain.setLocation(600, 200);
		   
		   jlblTopic = new JLabel(" 院校、系、专业管理");
		   jlblTopic.setFont(new Font("隶书",Font.PLAIN,26));
		   jlblTopic.setForeground(Color.BLUE);
		   jlblTopic.setBounds(1794/15, 0,4104/15, 444/15);
		   con.add(jlblTopic);
		   
		   jcboshow = new JComboBox(msg);
		   jcboshow.setFont(normalFont);
		   jcboshow.setBounds(240/15, 720/15, 4572/15, 436/15);
		   con.add(jcboshow);
		   
		   jlblname = new JLabel("操作员：  张浩");
		   jlblname.setFont(normalFont);
		   jlblname.setBounds(5520/15, 600/15, 1920/15, 240/15);
		   con.add(jlblname);
		   
		   dlmUniveristy = new DefaultListModel<String>();
		   jlstUniveristy = new JList<String>( dlmUniveristy);
		   jscpUniveristy =new JScrollPane (jlstUniveristy);
		   jscpUniveristy.setBounds(240/15, 1320/15, 2412/15, 2928/15);
		   jscpUniveristy.setBorder(new TitledBorder(null,"院校列表",TitledBorder.TOP,TitledBorder.TOP,new Font("宋体",Font.PLAIN,15),Color.black));
		   con.add(jscpUniveristy);
		   jlblUniveristy = new JLabel("共有0个院校");
		   jlblUniveristy.setFont(normalFont);
		   jlblUniveristy.setBounds(240/15, 4320/15, 2280/15, 240/15);
		   con.add(jlblUniveristy);
		   
		   dlmDepartment = new DefaultListModel<String>();
		   jlstDepartment = new JList<String>( dlmDepartment);
		   jscpDepartment =new JScrollPane (jlstDepartment);
		   jscpDepartment.setBounds(2640/15, 1320/15, 2412/15, 2928/15);
		   jscpDepartment.setBorder(new TitledBorder(null,"院系列表",TitledBorder.TOP,TitledBorder.TOP,new Font("宋体",Font.PLAIN,15),Color.black));
		   con.add(jscpDepartment);
		   jlblDepartment = new JLabel("共有0个院系");
		   jlblDepartment.setFont(normalFont);
		   jlblDepartment.setBounds(2640/15, 4320/15, 2280/15, 240/15);
		   con.add(jlblDepartment);
		   
		   dlmMajor = new DefaultListModel<String>();
		   jlstMajor  = new JList<String>( dlmMajor );
		   jscpMajor  =new JScrollPane (jlstMajor );
		   jscpMajor .setBounds(5040/15, 1320/15, 2412/15, 2928/15);
		   jscpMajor .setBorder(new TitledBorder(null,"专业列表",TitledBorder.TOP,TitledBorder.TOP,new Font("宋体",Font.PLAIN,15),Color.black));
		   con.add(jscpMajor );
		   jlblMajor= new JLabel("共有0个专业");
		   jlblMajor.setFont(normalFont);
		   jlblMajor.setBounds(5040/15, 4320/15, 2280/15, 240/15);
		   con.add(jlblMajor);
		   
		   jlblSelectname= new JLabel("专业:");
		   jlblSelectname.setFont(normalFont);
		   jlblSelectname.setBounds(240/15, 4920/15, 720/15, 420/15);
		   con.add(jlblSelectname);
		   
		   jtflSelectname =new JTextField();
		   jtflSelectname.setFont(normalFont);
		   jtflSelectname.setBounds(840/15, 4854/15, 3972/15, 372/15);
		   con.add(jtflSelectname);
		   
		   jrdbIsused = new JRadioButton[2];
		   jrdbIsused[0]=new JRadioButton("可用");
		   jrdbIsused[0].setFont(normalFont);
		   jrdbIsused[0].setBounds(5040/15, 4920/15, 852/15, 252/15);
		   con.add(jrdbIsused[0]);
		   jrdbIsused[1]=new JRadioButton("不可用");
		   jrdbIsused[1].setFont(normalFont);
		   jrdbIsused[1].setBounds(6480/15, 4920/15, 1092/15, 252/15);
		   con.add(jrdbIsused[1]);
		   bgIsused = new ButtonGroup();
		   bgIsused.add(jrdbIsused[0]);
		   bgIsused.add(jrdbIsused[1]);
		   
		   jbtnExit = new JButton("退出");
		   jbtnExit.setFont(normalFont);
		   jbtnExit.setBounds(6360/15, 5520/15, 1092/15, 492/15);
		   con.add(jbtnExit);
		   
		   jbtnAdd = new JButton("添加");
		   jbtnAdd.setFont(normalFont);
		   jbtnAdd.setBounds(240/15, 5520/15, 1092/15, 492/15);
		   con.add(jbtnAdd);
		   
		   
		   jbtnModify = new JButton("修改");
		   jbtnModify.setFont(normalFont);
		   jbtnModify.setBounds(1320/15, 5520/15, 1092/15, 492/15);
		   con.add(jbtnModify);
		   
		   jlblnumber = new JLabel();
		   jlblnumber.setFont(normalFont);
		   jlblnumber.setBounds(0, 0, 0, 0);
		   con.add(jlblnumber);
		   
		   jfrmMain.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
		   jfrmMain.setVisible(true);
		   jdtpParent.add(jfrmMain);
	 } 
	 
	 private void reinterFrame()
	 {
		 try 
	    {
		 initUse();
		 setState(CQ);
		 setListState();
		 clickonUniveristy();
	    } catch (Exception e)
			{
				e.printStackTrace();
			}
		
	 }
	 
	 private void ShowMessge(JInternalFrame jfrmMain ,String mess)
	 {
	        JOptionPane.showConfirmDialog(jfrmMain, mess,"系统温馨提示",JOptionPane.OK_OPTION)	 ;
	 }
	 
	 
	 private void countU()
	 {
		 String LS = String.valueOf(this.dlmUniveristy.getSize());
		 this.jlblUniveristy.setText("共有"+LS+"个院校");
	 }
	 
	 private void countD()
	 {
		 String LS = String.valueOf(this.dlmDepartment.getSize());
		 this.jlblDepartment.setText("共有"+LS+"个院系");
	 }
	 
	 private void countM()
	 {
		 String LS = String.valueOf(this.dlmMajor.getSize());
		 this.jlblMajor.setText("共有"+LS+"个专业");
	 }
	 
	 private void initUse()
	 {
		 
		 try {
			  initU_D_MUse(dlmUniveristy,jlstUniveristy,"RIGHT (U_D_Mid,4)='0000' ");
			  initDepartmentUse();
			  initMajorUse();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	 }
	 private void initAll()
	 {
		 
		 try {
			  initU_D_MAll(dlmUniveristy,jlstUniveristy,"RIGHT (U_D_Mid,4)='0000' ");
			  initDepartmentAll();
			  initMajorAll();
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
	 }
	 
	 private void initDepartmentUse()throws Exception
	 {
		 countD();
		 if (jlstUniveristy.getSelectedIndex() !=-1 )
		 {    
			 String nimei = jlstUniveristy.getSelectedValue().substring(0, 0+2);
			 initU_D_MUse(dlmDepartment,jlstDepartment,
					 "LEFT(U_D_Mid,2) = '" +nimei+ "' AND MID(U_D_Mid, 3, 2) <> '00' AND RIGHT(U_D_Mid, 2) = '00'");
			
		 }
	 }
	 
	 
	 private void initMajorUse()throws Exception
	 {
		 countM();
		 if (jlstDepartment.getSelectedIndex() !=-1 )
		 {    
			 String nimei = jlstDepartment.getSelectedValue().substring(0, 0+4);
			 initU_D_MUse(dlmMajor,jlstMajor,
					 "LEFT(U_D_Mid,4) = '" +nimei+ "'  AND RIGHT(U_D_Mid, 2) <> '00'");
			
		 }
		 else 
			 dlmMajor.removeAllElements();
	 }
	 
	 private void initU_D_MUse(DefaultListModel<String> dlstList , JList <String> jlstList , String condition )throws Exception
	 {
		 countU();
		 dlstList.removeAllElements();
		 ResultSet rs=null;
		 
		 String SQLString =
				 "SELECT  U_D_Mid, U_D_Mname, U_D_Mstate " + 
				 "FROM SYS_XTGL_YXXZYXX" +
				 " WHERE " + condition+ "AND U_D_Mstate = 0 "+
				 " ORDER BY U_D_Mid " ;
		 MECData  dat = new MECData("SYS_XTGL_YXXZYXX");
		
		 String name ;
		 String id;
		// int status;
			 
		 try 
		 {
			dat.connectionDatabase();
			
			rs = dat.select(SQLString);
			while(rs.next())
			{
				id = rs.getString("U_D_Mid");
				name = rs.getString("U_D_Mname");
				//status = rs.getInt("U_D_Mstate");
				dlstList.addElement(id+"  "+name);
			}
			if(dlstList.getSize()>0)
				jlstList.setSelectedIndex(0) ;
			dat.disconnection();
			
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		 
	 }
	 private void initDepartmentAll()throws Exception
	 {
		 if (jlstUniveristy.getSelectedIndex() !=-1 )
		 {    
			 countD();
			 String nimei = jlstUniveristy.getSelectedValue().substring(0, 0+2);
			 initU_D_MUse(dlmDepartment,jlstDepartment,
					 "LEFT(U_D_Mid,2) = '" +nimei+ "' AND MID(U_D_Mid, 3, 2) <> '00' AND RIGHT(U_D_Mid, 2) = '00'");
		 }
	 }
	 
	 
	 private void initMajorAll()throws Exception
	 {
		 countM();
		 if (jlstDepartment.getSelectedIndex() !=-1 )
		 {    
			 String nimei = jlstDepartment.getSelectedValue().substring(0, 0+4);
			 initU_D_MUse(dlmMajor,jlstMajor,
					 "LEFT(U_D_Mid,4) = '" +nimei+ "'  AND RIGHT(U_D_Mid, 2) <> '00'");
			 
		 }
		 else 
			 dlmMajor.removeAllElements();
	 }
	 
	 private void initU_D_MAll(DefaultListModel<String> dlstList , JList <String> jlstList , String condition )throws Exception
	 {
		 countU();
		 dlstList.removeAllElements();
		 ResultSet rs=null;
		 
		 String SQLString =
				 "SELECT  U_D_Mid, U_D_Mname, U_D_Mstate " + 
				 "FROM SYS_XTGL_YXXZYXX" +
				 " WHERE " + condition+ 
				 " ORDER BY U_D_Mid " ;
		 MECData  dat = new MECData("SYS_XTGL_YXXZYXX");
		
		 String name ;
		 String id;
		 
		 try 
		 {
			dat.connectionDatabase();
			rs = dat.select(SQLString);
			while(rs.next())
			{
				id = rs.getString("U_D_Mid");
				name = rs.getString("U_D_Mname");
				dlstList.addElement(id+"  "+name);
			}
			if(dlstList.getSize()>0)
				jlstList.setSelectedIndex(0) ;
			dat.disconnection();

		} catch (Exception e) {
		
			e.printStackTrace();
		}
		 
	 }
	 
	 private void showInfo(String id )throws Exception
	 {
		 ResultSet rs =null;
		 String SQLString = 
				 "SELECT U_D_Mname , U_D_Mstate,U_D_Mid "+
		         "FROM SYS_XTGL_YXXZYXX"+
				 " WHERE U_D_Mid = '" + id + "' " ;
		 MECData dat = new MECData("SYS_XTGL_YXXZYXX"); 
		 try 
		 {
			 dat.connectionDatabase();
			rs = dat.select(SQLString);

			 String name =null;
			 int status ;
			 String myid;
			
			while(rs.next())
			{
				name = rs.getString("U_D_Mname");
				status = rs.getInt("U_D_Mstate");
				myid = rs.getString("U_D_Mid");
				
				this.jtflSelectname.setText(name);
				this.jrdbIsused[status].setSelected(true);
				this.jlblnumber.setText(myid);
			}
			dat.disconnection();
		} catch (Exception e) {

			e.printStackTrace();
		} 
	 }
	 
	 private void cleanInfo()
	 {
		 this.jtflSelectname.setText("");
		 
	 }
	 
	 private void clickonUniveristy()
	 {
		 if (jlstUniveristy.isEnabled())
		 {  
			 try
			 {  
			 {
				initDepartmentUse();
				initMajorUse();
				//initDepartmentAll();
				//initMajorAll();
			 }
				 this.jlblSelectname.setText("院校：");
				 String id =null;
				 id = this.jlstUniveristy.getSelectedValue();
				 if(id != null)
				 {
					 id = id.substring(0, 0+6);
					 showInfo(id);
				 }
				 else
					 cleanInfo();
				     setListState();
			 } catch (Exception e) 
			 {
				e.printStackTrace();
			 }
			 
			
		 }
	 }
	 
	 private void clickonDepartment()
	 {
		 if(jlstDepartment.isEnabled())
		 {
			 try { 
			 {
				   initMajorUse();
				  // initMajorAll();
				   this.jlblSelectname.setText("院系：");
					 String id = null ;
					 id = this.jlstDepartment.getSelectedValue();
					 if(id != null)
					 {
						 id =id.substring(0,0+ 6);
						 showInfo(id);
					 }
					 else
						 cleanInfo();
					     setListState();
			 }
			} catch (Exception e)
			 {
				e.printStackTrace();
			}
		 }
		
	 }
	 
	 private void clickonMajor()
	 {  try
	    {
		 if(jlstMajor.isEnabled())
		 {
		 this.jlblSelectname.setText("专业：");
		 String id =null ;
		 id = this.jlstMajor.getSelectedValue();
		 if(id != null)
		   {
		 	 id =id.substring(0,0+ 6);
		 	 showInfo(id);
		   }
		 else
			 cleanInfo();
		     setListState();
         }
	    } catch (Exception e)
	 {
		e.printStackTrace();
	}
	 }
    
	
	 
	 public boolean checkNameSure()
	 {
		     boolean legal = true;
			 String str = null;
			 str = jtflSelectname.getText();

			 String mes ="[\u4E00-\u9FF5]+";

				if(str.equals(""))
				{
					 ShowMessge(jfrmMain, "此处不能为空");
					legal = false;
				}
			
				else if(str.matches(mes) == false)
				{
					ShowMessge(jfrmMain, "院校、系、专业名字只能是汉字！");
					legal = false;
				}
			
		    setState(CQ);
			return legal;

	 }

	 
	 private void showInservalue(String inservalue,int  type)
	 {
		 try
		 {
		 if(type == Univeristy)
		 {
			 this.dlmUniveristy.addElement(inservalue);
			 this.jlstUniveristy.setSelectedValue(inservalue, true);
			 initDepartmentUse();
			 initMajorUse();
			 initDepartmentAll();
			 initMajorAll();
			 setListState();
		 }
		 else if (type == Department)
		 {
			  this.dlmDepartment.addElement(inservalue);
			  this.jlstDepartment.setSelectedValue(inservalue, true);
			  initMajorUse();
			  initMajorAll();
			  setListState();
		 }
		 else if(type == Major)
		 {
			  this.dlmMajor.addElement(inservalue);
			  this.jlstMajor.setSelectedValue(inservalue, true);
		 }
		 } catch (Exception e) 
	     {
			
			e.printStackTrace();
		 }
	 }
	 
	 private void inserInfo(int type)
	 {
		 String condition = null;
		 if(type == Univeristy)
		 {
			 condition = "";
			 
		 }
		 else if(type == Department)
		 {
			 condition = this.jlstUniveristy.getSelectedValue().substring(0, 0+2);
		 }
		 else
		 {
			 condition = this.jlstDepartment.getSelectedValue().substring(0, 0+4);
		 }
		 
		 try {
			String newid = getnewid(condition,type);
			String name = this.jtflSelectname.getText();
			int isUsed = jrdbIsused[0].isSelected() ? 0 : 1;
			String SQLString = 
					"INSERT INTO SYS_XTGL_YXXZYXX(U_D_Mid, U_D_Mname, U_D_Mstate) VALUES('" + newid+"','"+name+"',"+isUsed+")";
			
			MECData dat = new MECData("SYS_XTGL_YXXZYXX");
			dat.connectionDatabase();
			dat.update(SQLString);
			dat.disconnection();
			
			
			String inservalue = newid +"  "+name;
			showInservalue(inservalue,type);
			jtflSelectname.setText(name);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	 }
	 
	 private String getnewid(String condition,int type)throws Exception
	 {
		 ResultSet rs=null;
		 String SQLString =null;
		 String newid = null;
		 String[] conditionArray =
			 {
				 "SELECT COUNT(*) AS DSH  FROM SYS_XTGL_YXXZYXX WHERE RIGHT(U_D_Mid,4) = '0000'",
				 "SELECT COUNT(*) AS DSH  FROM SYS_XTGL_YXXZYXX WHERE LEFT(U_D_Mid,2) = '##' AND MID(U_D_Mid,3,2) <>'00' AND RIGHT(U_D_Mid,2) = '00'",
				 "SELECT COUNT(*) AS DSH  FROM SYS_XTGL_YXXZYXX WHERE LEFT(U_D_Mid,4) ='####' AND RIGHT(U_D_Mid,2)<>'00'"
			 };    
		 MECData dat =new MECData("SYS_XTGL_YXXZYXX");
		 
		 if(type==Univeristy)
		 {
			 SQLString = conditionArray[type];
		 }
		 else if (type==Department)
		 {
			 SQLString = conditionArray[type].replaceFirst("##", condition);
		 }
		 else if(type == Major)
		 {
			 SQLString = conditionArray[type].replaceFirst("####", condition);
		 }
		 
	  try {
		     dat.connectionDatabase();
			 
			 int count =0;
			 rs= dat.select(SQLString);
			 if(rs.next())
			 {
				 count = rs.getInt("DSH");
			 }
			 count++;
			
			 String what = String.valueOf(count+100).substring(1);
			 
			 if(type == Univeristy)
			 {
				 newid = what+"0000";
			 }
			 else if(type == Department)
			 {
				 newid = condition+what+"00";
			 }
			 else
			 {
				 newid = condition+what;
			 }
			 dat.disconnection();
		  } catch (Exception e) {
			
			e.printStackTrace();
		  }
	     return newid;
		 
	 }
	 
	 private void inserModify()
	 {
		  String id = jlblnumber.getText();
		  String name = jtflSelectname.getText();
		  int isUsed = this.jrdbIsused[0].isSelected() ? 0:1 ;
		  
		  String SQLString = 
				  "UPDATE SYS_XTGL_YXXZYXX SET U_D_Mname = '"+ name+"',U_D_Mstate ="+isUsed +" WHERE U_D_Mid ='"+id+"'";
		  

		  try {
			   MECData dat =new MECData("SYS_XTGL_YXXZYXX");
			   dat.connectionDatabase();
			   dat.update(SQLString);
			   dat.disconnection();
			   
			     
  		       if(jcboshow.getSelectedIndex()==0)
  		       {
  		    	   initUse();
  		       }
  		       else
  		       {
  		    	   initAll();
  		       }
				 jtflSelectname.setText(name);
				
		      } catch (Exception e) {
			
			e.printStackTrace();
		}
		  
	 }

	 private void quiteWindonws()
	 {
		 jfrmMain.dispose();
	 }
	 
	 
	 private void dealAction()
	 {
		 
		 jbtnModify.addActionListener
		 (
				 new ActionListener()
				 {
					public void actionPerformed(ActionEvent e) 
					{
							
						if(jbtnModify.getText().equals("修改"))
						{
							 
							 int isUsed = jrdbIsused[0].isSelected() ? 0 :1;
								
							oldselectname = jtflSelectname.getText();
							
							jbtnAdd.setText("确定");
							jbtnModify.setText("取消");
							
							ZH=1;
							setState(QC);
							 //ZH=1;
							if(isUsed==1)
							{
								jtflSelectname.setEnabled(false);
								jrdbIsused[0].setEnabled(false);
								jrdbIsused[1].setEnabled(false);
								jbtnAdd.setEnabled(false);
							}
							
							jtflSelectname.requestFocus();
							jtflSelectname.setSelectionStart(0);
							jtflSelectname.setSelectionEnd(jtflSelectname.getText().length());
							
						}
						else
						{
							jtflSelectname.setText(oldselectname);
							
							jbtnAdd.setText("添加");
							jbtnModify.setText("修改");
							jbtnAdd.setEnabled(true);
							setState(CQ);
						}
					}
					 
				 }
				 
		 );
		 
		 jbtnAdd.addActionListener
		 (
				 new ActionListener()
				 {
					public void actionPerformed(ActionEvent e)
					{
						if(jbtnAdd.getText().equals("添加"))
						{
							
							oldselectname = jtflSelectname.getText();
							setState(QC);
							ZH = 0;
							
							jbtnAdd.setText("确定");
							jbtnModify.setText("取消");
							jrdbIsused[1].setEnabled(false);
							jtflSelectname.requestFocus();
							jtflSelectname.setSelectionStart(0);
							jtflSelectname.setSelectionEnd(jtflSelectname.getText().length());
						}
						else
						{
							if(ZH == 0)
							{
								if(jlblSelectname.getText().equals("院校："))
								{
									if(checkNameSure())
									inserInfo(Univeristy);
									jtflSelectname.setText(oldselectname);
								}
								else if(jlblSelectname.getText().equals("院系："))
								{
									if(checkNameSure())
									inserInfo(Department);
									jtflSelectname.setText(oldselectname);
								}
								else if(jlblSelectname.getText().equals("专业："))
								{
									if(checkNameSure())
									inserInfo(Major);
									jtflSelectname.setText(oldselectname);
								}
							}
							else
							{
								if(checkNameSure());
								inserModify();
								jtflSelectname.setText(oldselectname);
							}
							jbtnAdd.setText("添加");
							jbtnModify.setText("修改");
							//jtflSelectname.setText(oldselectname);
							setState(CQ);
						}
					}
					 
				 }
		 );
		 
		 
		 
		 jbtnExit.addActionListener
		 (
			 new ActionListener()
			 {
				public void actionPerformed(ActionEvent e) 
				{
					int a = JOptionPane.showConfirmDialog(jfrmMain, "你确定吗？","系统温馨提示",JOptionPane.YES_NO_CANCEL_OPTION);
					if(a==0)
					{
						quiteWindonws();
					}
					
				}
				 
			 }
		 );
 
		 jcboshow.addActionListener
		 (
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e) 
					{

					}
					
				}
		 );
		 
		 jcboshow.addItemListener
		 (
				 new ItemListener()
				 {
					public void itemStateChanged(ItemEvent e)
					{
						if(jcboshow.getSelectedIndex() == 1)
						{
							initAll();
						}
						else
						{
							initUse();
						}
					}
					 
				 }
		 );
		 
		 jlstUniveristy.addMouseListener
		 (
				 new MouseListener()
				 {
					public void mouseClicked(MouseEvent e)
					{
						clickonUniveristy();
					}
					public void mousePressed(MouseEvent e) {}
					public void mouseReleased(MouseEvent e) {}
					public void mouseEntered(MouseEvent e) {}
					public void mouseExited(MouseEvent e) {}
					 
				 }
		 );
		 
		 jlstUniveristy.addListSelectionListener
		 (
			   new ListSelectionListener()
			   {
				public void valueChanged(ListSelectionEvent e) 
				{
					clickonUniveristy();
				}
				   
			   }
		 );
		 
		 
		 jlstDepartment.addMouseListener
		 (
				 new MouseListener()
				 {
					public void mouseClicked(MouseEvent e) 
					{
						clickonDepartment();
					}
					public void mousePressed(MouseEvent e) {}
					public void mouseReleased(MouseEvent e) {}
					public void mouseEntered(MouseEvent e) {}
					public void mouseExited(MouseEvent e) {}
					 
				 }
		 );
		 
		 jlstDepartment.addListSelectionListener
		 (
			   new ListSelectionListener()
			   {
				public void valueChanged(ListSelectionEvent e) 
				{
					clickonDepartment();
				}
				   
			   }
		 );
		 
		 jlstMajor.addMouseListener
		 (
				 new MouseListener()
				 {
					public void mouseClicked(MouseEvent e) 
					{
						clickonMajor();
					}
					public void mousePressed(MouseEvent e) {}
					public void mouseReleased(MouseEvent e) {}
					public void mouseEntered(MouseEvent e) {}
					public void mouseExited(MouseEvent e) {}
					 
				 }
		 );
		 jlstMajor.addListSelectionListener
		 (
			   new ListSelectionListener()
			   {
				public void valueChanged(ListSelectionEvent e) 
				{
					clickonMajor();
				}
				   
			   }
		 );
		 
	 }
	 
	 private void setState(int type)
	 {
		 boolean state = type ==CQ;
		 this.jlstUniveristy.setEnabled(state);
		 this.jlstDepartment.setEnabled(state);
		 this.jlstMajor.setEnabled(state);
		 this.jcboshow.setEnabled(state);
		 
		 this.jrdbIsused[0].setEnabled(!state);
		 this.jrdbIsused[1].setEnabled(!state);
		 this.jtflSelectname.setEnabled(!state);
		 
	 }
	 
	 private void setListState()
	 {
		 if (this.dlmUniveristy.getSize()==0)
		 {
			 this.jlblUniveristy.setEnabled(true);
			 this.jlstUniveristy.setEnabled(true);
			 this.jlblDepartment.setEnabled(false);
			 this.jlstDepartment.setEnabled(false);
			 this.jlblMajor.setEnabled(false);
			 this.jlstMajor.setEnabled(false);
			 //this.jbtnModify.setEnabled(false);
		 }
		 else if(this.dlmDepartment.getSize()==0)
		 {
			 this.jlblUniveristy.setEnabled(true);
			 this.jlstUniveristy.setEnabled(true);
			 this.jlblDepartment.setEnabled(true);
			 this.jlstDepartment.setEnabled(true);
			 this.jlblMajor.setEnabled(false);
			 this.jlstMajor.setEnabled(false);
		 }
		 else
		 {
			 this.jlblUniveristy.setEnabled(true);
			 this.jlstUniveristy.setEnabled(true);
			 this.jlblDepartment.setEnabled(true);
			 this.jlstDepartment.setEnabled(true);
			 this.jlblMajor.setEnabled(true);
			 this.jlstMajor.setEnabled(true);
			
		 }
	 }
	 

	}


