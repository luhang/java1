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
         //�t�H�[���f�[�^�̎擾
         String name = request.getParameter("name");

         //�R���e���c�^�C�v�̐ݒ�
         response.setContentType("text/html; charset=UTF-8");

         //HTML�����̏����o��
         PrintWriter pw = response.getWriter();
         if(name.length() != 0){
            pw.println("<!DOCTYPE html><html>\n" +
                       "<head><title>\n" + name + "</title></head>\n" +
                       "<body><div style=\"text-align: center;\">\n" +
                       "<h2>�悤����</h2>\n" +
                       name + "����A��������Ⴂ�܂��B<br/>\n" +
                       "</div></body>\n" +
                      "</html>\n");
          }
          else{
             pw.println("<html>\n" +
                        "<head><title>�G���[</title></head>\n" +
                        "<body><div style=\"text-align: center;\">\n" +
                        "<h2>�G���[</h2>\n" +
                        "���͂��Ă��������B<br/>\n" +
                        "</div></body>\n" +
                        "</html>\n");
          }
       }
       catch(Exception e){
          e.printStackTrace();
       }
   } 
}
