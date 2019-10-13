import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SampleP1 extends HttpServlet
{
   public void doGet(HttpServletRequest request,
                     HttpServletResponse response)
   throws ServletException
   {
      try{
         //フォームデータの取得
         String name = request.getParameter("name");

         //コンテンツタイプの設定
         response.setContentType("text/html; charset=UTF-8");

         //HTML文書の書き出し
         PrintWriter pw = response.getWriter();
         if(name.length() != 0){
            pw.println("<!DOCTYPE html><html>\n" +
                       "<head><title>\n" + name + "</title></head>\n" +
                       "<body><div style=\"text-align: center;\">\n" +
                       "<h2>ようこそ</h2>\n" +
                       name + "さん、いらっしゃいませ。<br/>\n" +
                       "</div></body>\n" +
                      "</html>\n");
          }
          else{
             pw.println("<html>\n" +
                        "<head><title>エラー</title></head>\n" +
                        "<body><div style=\"text-align: center;\">\n" +
                        "<h2>エラー</h2>\n" +
                        "入力してください。<br/>\n" +
                        "</div></body>\n" +
                        "</html>\n");
          }
       }
       catch(Exception e){
          e.printStackTrace();
       }
   } 
}
