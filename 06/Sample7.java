import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Sample7 extends HttpServlet
{
   public void doGet(HttpServletRequest request,
                     HttpServletResponse response)
   throws ServletException
   {
      try{
         //コンテンツタイプの設定
         response.setContentType("text/html; charset=UTF-8");

         //HTML文書の書き出し
         PrintWriter pw = response.getWriter();
         pw.println("お選びください。<br/>\n" +
                    "<br/>\n" +
                    "<a href=\"../car1.html\">乗用車</a><br/>\n" +
                    "<a href=\"../car2.html\">トラック</a><br/>\n" +
                    "<a href=\"../car3.html\">オープンカー</a><br/>\n");
       }
       catch(Exception e){    
          e.printStackTrace();
       }
   } 
}
