import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Sample8 extends HttpServlet
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
         pw.println("<!DOCTYPE html><html>\n" +
                    "<head><title>�T���v��</title></head>\n" +
                    "<body><div style=\"text-align: center;\">\n" +
                    "<h2>���߂łƂ��������܂��B</h2>" +
                    "<hr/>\n" +
                    "�F�؂ɐ������܂����B<br/>\n" +
                    "���I�т��������B<br/>\n" +
                    "<br/>\n" +
                    "<a href=\"../car1.html\">��p��</a><br/>\n" +
                    "<a href=\"../car2.html\">�g���b�N</a><br/>\n" +
                    "<a href=\"../car3.html\">�I�[�v���J�[</a><br/>\n" +
                    "</div</body>\n" +
                    "</html>\n");
       }
       catch(Exception e){    
          e.printStackTrace();
       }
   } 
}
