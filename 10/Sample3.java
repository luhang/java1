import java.io.*;
import java.util.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import javax.xml.transform.dom.*;
import org.w3c.dom.*;

public class Sample3
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

      //���[�g�v�f���쐬����
      Element root = doc.createElement("�ԃ��X�g");
      doc.appendChild(root);

      //CSV�����̏���������
      BufferedReader br = new BufferedReader(new FileReader("Sample.csv"));

      //CSV�����̃^�C�g���s��ۑ�����
      ArrayList<String> colname = new ArrayList<String>();
      String line = br.readLine();
      StringTokenizer stt = new StringTokenizer(line, ",");
      while(stt.hasMoreTokens()){
         colname.add(stt.nextToken());
      }

      //CSV������ϊ�����
      while((line = br.readLine()) != null){
         StringTokenizer std = new StringTokenizer(line, ",");
         Element car = doc.createElement("��");
         root.appendChild(car);

         for(int i=0; i<colname.size(); i++){
            Element elm = doc.createElement((String)colname.get(i));
            Text txt = doc.createTextNode(std.nextToken());
            elm.appendChild(txt);
            car.appendChild(elm);
         }

      }
      br.close();

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
