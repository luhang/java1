import java.sql.*;

public class SampleP1
{
   public static void main(String[] args)
   {
      try{
         //�ڑ��̏���
         String url = "jdbc:derby:fooddb;create=true";
         String usr = "";
         String pw = "";

         //�f�[�^�x�[�X�ւ̐ڑ�
         Connection cn = DriverManager.getConnection(url, usr, pw);

         //�₢���킹�̏���
         DatabaseMetaData dm = cn.getMetaData();
         ResultSet tb = dm.getTables(null, null, "�ʕ��\", null);

         Statement st = cn.createStatement();

         String qry1 = "CREATE TABLE �ʕ��\(�ԍ� int, ���O varchar(50), �戵�X varchar(50))";
         String[] qry2 = {"INSERT INTO �ʕ��\ VALUES (1,'�݂���','�R���X')",
                          "INSERT INTO �ʕ��\ VALUES (2,'���','�����s��')",
                          "INSERT INTO �ʕ��\ VALUES (3,'�o�i�i','��؉ݕ�')",
                          "INSERT INTO �ʕ��\ VALUES (4,'������','�����s��')",
                          "INSERT INTO �ʕ��\ VALUES (5,'�Ȃ�','�R���X')",
                          "INSERT INTO �ʕ��\ VALUES (6,'�I','���l�f�p�[�g')",
                          "INSERT INTO �ʕ��\ VALUES (7,'����','���l�f�p�[�g')",
                          "INSERT INTO �ʕ��\ VALUES (8,'�т�','�������X')",
                          "INSERT INTO �ʕ��\ VALUES (9,'�`','�R���X')",
                          "INSERT INTO �ʕ��\ VALUES (10,'�X�C�J','�����s��')"};
         String qry3 = "SELECT * FROM �ʕ��\";

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