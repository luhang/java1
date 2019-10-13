import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;

public class Sample6 extends HttpServlet
{
   public void doGet(HttpServletRequest request,
                     HttpServletResponse response)
   throws ServletException
   {
      try{
         //�R���e���c�^�C�v�̐ݒ�
         response.setContentType("text/html; charset=UTF-8");
        
         //�����o��
         PrintWriter pw = response.getWriter();

         StreamSource in = new StreamSource("http://localhost:8080/YJKSample10/Sample.xml");
         StreamSource ss = new StreamSource("http://localhost:8080/YJKSample10/Sample2.xsl");
         StreamResult out = new StreamResult(pw);

         TransformerFactory tff = TransformerFactory.newInstance();
         Transformer tf = tff.newTransformer(ss);
         tf.transform(in, out);

       }
       catch(Exception e){    
          e.printStackTrace();
       }
   } 
}
