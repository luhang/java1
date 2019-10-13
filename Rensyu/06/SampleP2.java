import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SampleP2 extends HttpServlet
{
   public void doGet(HttpServletRequest request,
                     HttpServletResponse response)
   throws ServletException
   {
      try{
         //フォームデータの取得
         String carname = request.getParameter("cars");
      
         //コンテンツタイプの設定
         response.setContentType("text/html; charset=UTF-8");

         //HTML文書の書き出し
         PrintWriter pw = response.getWriter();
         if(carname.length() == 0){
             pw.println("<!DOCTYPE html><html>\n" +
                        "<head><title>エラー</title></head>\n" +
                        "<body><div style=\"text-align: center;\">\n" +
                        "<h2>エラー</h2>\n" +
                        "入力してください。<br/>\n" +
                        "</div></body>\n" +
                        "</html>\n");
          }
         else if(carname.equals("タクシー")){
            pw.println("<!DOCTYPE html><html>\n" +
                       "<head><title>\n" + carname + "</title></head>\n" +
                       "<body><div style=\"text-align: center;\">\n" +
                       "<h2>\n" +  carname + "</h2>\n" +
                       carname + "をお買い上げいただくことはできません。<br/>\n" +
                       "</div></body>\n" +
                       "</html>\n");
          }
          else {
            pw.println("<!DOCTYPE html><html>\n" +
                       "<head><title>\n" + carname + "</title></head>\n" +
                       "<body><div style=\"text-align: center;\">\n" +
                       "<h2>\n" +  carname + "</h2>\n" +
                       carname + "のお買い上げありがとうございました。<br/>\n" +
                       "</div></body>\n" +
                       "</html>\n");
          }
       }
       catch(Exception e){    
          e.printStackTrace();
       }
   } 
}
