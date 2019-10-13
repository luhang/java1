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
      //DOMの準備をする
      DocumentBuilderFactory dbf
         = DocumentBuilderFactory.newInstance();
      DocumentBuilder db
         = dbf.newDocumentBuilder();

      //文書を新規作成する
      Document doc = db.newDocument();

      //ルート要素を追加する
      Element root = doc.createElement("果物リスト");
      doc.appendChild(root);

      //要素を追加する
      Element fruit = doc.createElement("果物");
      root.appendChild(fruit);

      Element elm1 = doc.createElement("名前");
      Text txt1 = doc.createTextNode("みかん");
      elm1.appendChild(txt1);
      fruit.appendChild(elm1);

      Element elm2 = doc.createElement("仕入先");
      Text txt2 = doc.createTextNode("青山商店");
      elm2.appendChild(txt2);
      fruit.appendChild(elm2);

      //文書を書き出す
      TransformerFactory tff
         = TransformerFactory.newInstance();
      Transformer tf
         = tff.newTransformer();
      tf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
      tf.transform(new DOMSource(doc), new StreamResult("result.xml"));
      System.out.println("result.xmlに出力しました。");
   }
}
