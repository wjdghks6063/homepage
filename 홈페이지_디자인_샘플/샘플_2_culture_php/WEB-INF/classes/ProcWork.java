package cla;
import java.text.*;
import java.io.*; 
import java.util.*;
public class ProcWork{
	//public String notice_dir = "D:/webserver/webapps/ROOT/file_room/";
	public String test(){
		return "aaaaaaaaaaaaa";	
	}	
	

    public boolean chkFileSize(String ff, int size, String dir){
		boolean yn = true;
		File fileSizeLong = new File(dir,ff);
        long fileLength = fileSizeLong.length();
        if(fileLength ==0){
            File dF = new File(dir,ff);
            dF.delete();
            yn= false;

        }
        if(fileLength > 1024 * 1024 * size){
            File dF = new File(dir,ff);
            boolean aa  = dF.delete();
            yn= false;
        }
		return yn;
	}	
	public String replace(String str){
		str = str.replaceAll("\\\'", "\\\\\'");
		return str;
	}	

	public String replace2(String str){
		str = str.replaceAll("-", "");
		return str;
	}
	
	public String checkNull(String sValue){
		String result="";
		if(sValue != null) result = sValue;
		
		return result;
	}
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMdd");
	SimpleDateFormat sdfTwo = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
	public String getToday() {
		java.util.Date d = new java.util.Date();
		return sdf.format(d);
	}	
	public String getToday2() {
		java.util.Date d = new java.util.Date();
		return sdf2.format(d);
	}	
	String getTodayTwo() {
		java.util.Date d = new java.util.Date();
		return sdfTwo.format(d);
	}

	
   /**	���� */
   public int getYear() {
      Calendar cd = new GregorianCalendar(Locale.KOREA);
      int year = cd.get(cd.YEAR);
      return year;
   }	
   /**	�� */
   public int getMonth(){
      Calendar cd = new GregorianCalendar(Locale.KOREA);
      int month = cd.get(cd.MONTH) + 1;
      return month;
   } 
	/**	�� */   
   public int getDay() {
      Calendar cd = new GregorianCalendar(Locale.KOREA);
      int day = cd.get(cd.DAY_OF_MONTH);
      return day;
   } 	
   /**	���� */
   public String getYearString() {
      Calendar cd = new GregorianCalendar(Locale.KOREA);
      int year = cd.get(cd.YEAR);
      return Integer.toString(year);
   }	
   /**	�� */
   public String getMonthString(){
      Calendar cd = new GregorianCalendar(Locale.KOREA);
      int month = cd.get(cd.MONTH) + 1;
		String rs ="";
		if(month < 10) rs = "0"+Integer.toString(month);
		else rs  = Integer.toString(month);

      return rs;
   } 
	/**	�� */   
   public String getDayString() {
      Calendar cd = new GregorianCalendar(Locale.KOREA);
      int day = cd.get(cd.DAY_OF_MONTH);
		String rs ="";
		if(day < 10) rs = "0"+Integer.toString(day);
		else rs  = Integer.toString(day);

      return rs;
   } 	
	public String pageList(int current_page,int totalpage, String list_url){
		int pagenumber;    //ȭ�鿡 ������ ������ �ε�����
		int startpage;     //ȭ�鿡 ������ ���� ������ ��ȣ
		int endpage;       //ȭ�鿡 ������ ������ ������ ��ȣ
		int curpage;       //�̵��ϰ��� �ϴ� ������ ��ȣ
		
		String strList=""; //���ϵ� ������ �ε��� ����Ʈ
		
		pagenumber = 10;   //�� ȭ���� ������ �ε�����
		
		//���� ������ ��ȣ ���ϱ�
		startpage = ((current_page - 1)/ pagenumber) * pagenumber + 1;
		//������ ������ ��ȣ ���ϱ�
		endpage = (((startpage -1) + pagenumber) / pagenumber)*pagenumber;
		//������������ ���� ������ ������ ��ȣ���� ���� ���
		//������������ ������ ������ ��ȣ�� ��
		
		if(totalpage <= endpage)  endpage = totalpage;
					
		//ù��° ������ �ε��� ȭ���� �ƴѰ��
		if(current_page > pagenumber){
			curpage = startpage -1;  //���������� ��ȣ���� 1���� �������� �̵�
			strList = strList +"<a href='"+list_url+"&r_page="+curpage+"'><font color=#666699>[Prev]...</font></a>";
		}
						
		//���������� ��ȣ���� ������ ������ ��ȣ���� ȭ�鿡 ǥ��
		curpage = startpage;
		while(curpage <= endpage){
			if(curpage == current_page){
				strList = strList +"&nbsp;<font color=#003366><b>["+current_page+"]</b></font>&nbsp;";
			} else {
				strList = strList +"<a href='"+list_url+"&r_page="+curpage+"'><font color=#666699>["+curpage+"]</font></a>";
			}
			curpage++;
		}
		//�ڿ� �������� �� �ִ� ���
		if(totalpage > endpage){
			curpage = endpage+1;
			strList = strList + "<a href='"+list_url+"&r_page="+curpage+"'><font color=#666699>...[Next]</font></a>";
		}
		
		return strList;
	}				
}	