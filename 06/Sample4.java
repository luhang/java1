import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Sample4 extends HttpServlet
{
   public void doGet(HttpServletRequest request,
                     HttpServletResponse response)
   throws ServletException
   {
      try{
         //�Z�b�V�����̎擾
         HttpSession hs = request.getSession(true);	
         Integer cn = (Integer) hs.getAttribute("count");	
         Date dt = (Date) hs.getAttribute("date");	

         String str1, str2;

         //�񐔂̐ݒ� 
         if(cn == null){
            cn = Integer.valueOf(1);
            dt = new Date();
            str1 = "�͂��߂Ă̂������ł��ˁB";
            str2 = "";
         }
         else{
            cn = Integer.valueOf(cn.intValue() + 1);
            dt = new Date();
            str1 = cn + "��ڂ̂������ł��ˁB";
            str2 = "�i�O��F" + dt + ")";
         }
     
         //�Z�b�V�����̐ݒ�
         hs.setAttribute("count", cn);
         hs.setAttribute("date", dt);

         //�R���e���c�^�C�v�̐ݒ�
         response.setContentType("text/html; charset=UTF-8");

         //HTML�����̏����o��
         PrintWriter pw = response.getWriter();
         pw.println("<!DOCTYPE html><html>\n" +
                    "<head><title>�T���v��</title></head>\n" +
                    "<body><div style=\"text-align: center;\">\n" +
                    "<h2>�悤����</h2>" +
                    "<hr />\n" +
                    str1 + "<br/>\n" +
                    str2 + "<br/>\n" +
                    "���I�т��������B<br/>\n" +
                    "<br/>\n" +
                    "<a href=\"../car1.html\">��p��</a><br/>\n" +
                    "<a href=\"../car2.html\">�g���b�N</a><br/>\n" +
                    "<a href=\"../car3.html\">�I�[�v���J�[</a><br/>\n" +
                    "</div></body>\n" +
                    "</html>\n");
        }
        catch(Exception e){    
          e.printStackTrace();
       }
   } 
}
