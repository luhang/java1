import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Sample2 extends HttpServlet
{
   public void doGet(HttpServletRequest request,
                     HttpServletResponse response)
   throws ServletException
   {
      try{
         //�t�H�[���f�[�^�̎擾
         String carname = request.getParameter("cars");

         //�R���e���c�^�C�v�̐ݒ�
         response.setContentType("text/html; charset=UTF-8");

         //HTML�����̏����o��
         PrintWriter pw = response.getWriter();
         pw.println("<!DOCTYPE html><html>\n" +
                    "<head><title>\n" + carname + "</title></head>\n" +
                    "<body><div style=\"text-align: center;\">\n" +
                    "<h2>\n" +  carname + "</h2>\n" +
                    carname + "�̂������グ���肪�Ƃ��������܂����B<br/>\n" +
                    "</div></body>\n" +
                    "</html>\n");
       }
       catch(Exception e){
          e.printStackTrace();
       }
   } 
}
