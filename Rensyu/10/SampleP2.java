import java.io.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import javax.xml.transform.dom.*;
import org.w3c.dom.*;

public class SampleP2
{
   public static void main(String[] args) throws Exception
   {
      //DOM�̏���������
      DocumentBuilderFactory dbf
         = DocumentBuilderFactory.newInstance();
      DocumentBuilder db
         = dbf.newDocumentBuilder();

      //������V�K�쐬����
      Document doc = db.newDocument();

      //���[�g�v�f��ǉ�����
      Element root = doc.createElement("�ʕ����X�g");
      doc.appendChild(root);

      //�v�f��ǉ�����
      Element fruit = doc.createElement("�ʕ�");
      root.appendChild(fruit);

      Element elm1 = doc.createElement("���O");
      Text txt1 = doc.createTextNode("�݂���");
      elm1.appendChild(txt1);
      fruit.appendChild(elm1);

      Element elm2 = doc.createElement("�d����");
      Text txt2 = doc.createTextNode("�R���X");
      elm2.appendChild(txt2);
      fruit.appendChild(elm2);

      //�����������o��
      TransformerFactory tff
         = TransformerFactory.newInstance();
      Transformer tf
         = tff.newTransformer();
      tf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
      tf.transform(new DOMSource(doc), new StreamResult("result.xml"));
      System.out.println("result.xml�ɏo�͂��܂����B");
   }
}
