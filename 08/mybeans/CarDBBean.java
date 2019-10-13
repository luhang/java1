package mybeans;
import java.util.*;
import java.io.*;
import java.sql.*;

public class CarDBBean implements Serializable
{
   private ArrayList<String> colname;
   private ArrayList<ArrayList> data;

   public CarDBBean()
   {
      try{
         //�ڑ��̏���
         String url = "jdbc:derby:cardb;create=true";
         String usr = "";
         String pw = "";

         //�f�[�^�x�[�X�ւ̐ڑ�
         Connection cn = DriverManager.getConnection(url, usr, pw);

         //�₢���킹�̏���
         DatabaseMetaData dm = cn.getMetaData();
         ResultSet tb = dm.getTables(null, null, "�ԕ\", null);

         Statement st = cn.createStatement();

         String qry1 = "CREATE TABLE �ԕ\(�ԍ� int, ���O varchar(50))";
         String[] qry2 = {"INSERT INTO �ԕ\ VALUES (2, '��p��')",
                          "INSERT INTO �ԕ\ VALUES (3, '�I�[�v���J�[')",
                          "INSERT INTO �ԕ\ VALUES (4, '�g���b�N')"};
         String qry3 = "SELECT * FROM �ԕ\";

         if(!tb.next()){
            st.executeUpdate(qry1);
            for(int i=0; i<qry2.length; i++){
               st.executeUpdate(qry2[i]);
            }
         }

         //�₢���킹
         ResultSet rs = st.executeQuery(qry3);

         //�񐔂̎擾
         ResultSetMetaData rm = rs.getMetaData();
         int cnum = rm.getColumnCount();
         colname = new ArrayList<String>(cnum);

         //�񖼂̎擾
         for(int i=1; i<=cnum; i++){
            colname.add(rm.getColumnName(i).toString());
         }

         //�s�̎擾
         data = new ArrayList<ArrayList>(); 
         while(rs.next()){
            ArrayList<String> rowdata = new ArrayList<String>();
            for(int i=1; i<=cnum; i++){
                rowdata.add(rs.getObject(i).toString());
            }
            data.add(rowdata);
          }

          //�ڑ��̃N���[�Y
          rs.close();
          st.close();
          cn.close();
       }
       catch(Exception e){
          e.printStackTrace();
       }
   }  
   public ArrayList getData() 
   {
      return data;
   }
   public ArrayList getColname() 
   {
      return colname;
   }
}
