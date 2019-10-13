import mybeans.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Sample4 extends HttpServlet
{
   public void doGet(HttpServletRequest request,
                     HttpServletResponse response)
   throws ServletException
   {
      try{
         //�T�[�u���b�g�R���e�L�X�g�̎擾
         ServletContext sc = getServletContext();

         //Bean�̍쐬
         CarDBBean cb = new CarDBBean();

         //���N�G�X�g�ɐݒ�
         request.setAttribute("cb", cb);

         //���N�G�X�g�̓]��
         sc.getRequestDispatcher("/Sample4.jsp")
           .forward(request, response);
      }
      catch(Exception e){    
         e.printStackTrace();
      }
   } 
}
