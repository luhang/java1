import java.io.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import javax.xml.transform.dom.*;
import org.w3c.dom.*;

public class SampleP1
{
   public static void main(String[] args) throws Exception
   {
      //DOM�̏���������
      DocumentBuilderFactory dbf
         = DocumentBuilderFactory.newInstance();
      DocumentBuilder db
         = dbf.newDocumentBuilder();

      //������ǂݍ���
      Document doc
         = db.parse(new FileInputStream("Sample.xml"));

      //������V�K�쐬����
      Document doc2 = db.newDocument();

      //���[�g�v�f��ǉ�����
      Element root = doc2.createElement("��");
      doc2.appendChild(root);

      //�v�f�����o��
      NodeList lst = doc.getElementsByTagName("price");

      for(int i=0; i<lst.getLength(); i++){
         Node n = lst.item(i);
         for(Node ch = n.getFirstChild();
                  ch != null;
                  ch = ch.getNextSibling()){

            Element elm = doc2.createElement("���i");
            Text txt = doc2.createTextNode(ch.getNodeValue());
            elm.appendChild(txt);
            root.appendChild(elm);
         }
      }

      //�����������o��
      TransformerFactory tff
         = TransformerFactory.newInstance();
      Transformer tf
         = tff.newTransformer();
      tf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
      tf.transform(new DOMSource(doc2), new StreamResult("result.xml"));
      System.out.println("result.xml�ɏo�͂��܂����B");
   }
}
