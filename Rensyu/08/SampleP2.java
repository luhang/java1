import java.sql.*;

public class SampleP2
{
   public static void main(String[] args)
   {
      if(args.length != 3){
         System.out.println("�p�����[�^�̐����Ⴂ�܂��B");
         System.exit(1);
      }

      try{
         //�ڑ��̏���
         String url = "jdbc:derby:fooddb;create=true";
         String usr = "";
         String pw = "";

         //�f�[�^�x�[�X�ւ̐ڑ�
         Connection cn = DriverManager.getConnection(url, usr, pw);

         //�₢���킹�̏���
         Statement st = cn.createStatement();
         String qry1 = "INSERT INTO �ʕ��\ VALUES (" + args[0] + ", '"
                                                     + args[1] + "','"
                                                     + args[2] + "')";
         String qry2 = "SELECT * FROM �ʕ��\";

         //�₢���킹
         st.executeUpdate(qry1);
         ResultSet rs = st.executeQuery(qry2);

         //�f�[�^�̎擾
         ResultSetMetaData rm = rs.getMetaData();
         int cnum = rm.getColumnCount();

         while(rs.next()){
            for(int i=1; i<=cnum; i++){
               System.out.print(rm.getColumnName(i) +  ":" + rs.getObject(i) + "  ");
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