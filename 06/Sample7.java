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
         //�R���e���c�^�C�v�̐ݒ�
         response.setContentType("text/html; charset=UTF-8");

         //HTML�����̏����o��
         PrintWriter pw = response.getWriter();
         pw.println("���I�т��������B<br/>\n" +
                    "<br/>\n" +
                    "<a href=\"../car1.html\">��p��</a><br/>\n" +
                    "<a href=\"../car2.html\">�g���b�N</a><br/>\n" +
                    "<a href=\"../car3.html\">�I�[�v���J�[</a><br/>\n");
       }
       catch(Exception e){    
          e.printStackTrace();
       }
   } 
}
