import java.sql.*;

public class Sample1
{
   public static void main(String args[])
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

         //�f�[�^�̎擾
         ResultSetMetaData rm = rs.getMetaData();
         int cnum = rm.getColumnCount();
         while(rs.next()){
            for(int i=1; i<=cnum; i++){
                System.out.print(rm.getColumnName(i) +  ":"+ rs.getObject(i) + "  ");
            }
            System.out.println("");
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
}