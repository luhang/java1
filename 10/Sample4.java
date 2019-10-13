import java.sql.*;
import java.io.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import javax.xml.transform.dom.*;
import org.w3c.dom.*;

public class Sample4
{
   public static void main(String[] args)
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

         //DOM�̏���������
         DocumentBuilderFactory dbf
            = DocumentBuilderFactory.newInstance();
         DocumentBuilder db
            = dbf.newDocumentBuilder();

         //������V�K�쐬����
         Document doc = db.newDocument();

         //���[�g�v�f���쐬����
         Element root = doc.createElement("cars");
         doc.appendChild(root);

         //�v�f���쐬����
         while(rs.next()){
            Element car = doc.createElement("car");
            root.appendChild(car);
            for(int i=1; i<=cnum; i++){
               Element elm = doc.createElement(rm.getColumnName(i).toString());
               Text txt = doc.createTextNode(rs.getObject(i).toString());
               elm.appendChild(txt);
               car.appendChild(elm);
            }
         }

         //�����������o��
         TransformerFactory tff
            = TransformerFactory.newInstance();
         Transformer tf
            = tff.newTransformer();
         tf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
         tf.transform(new DOMSource(doc), new StreamResult("result.xml"));
         System.out.println("result.xml�ɏo�͂��܂����B");

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
