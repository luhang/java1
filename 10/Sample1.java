import java.io.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import javax.xml.transform.dom.*;
import org.w3c.dom.*;

public class Sample1
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
