import javax.servlet.*;
import javax.servlet.http.*;

public class Sample5 extends HttpServlet
{
   public void doGet(HttpServletRequest request,
                     HttpServletResponse response)
   throws ServletException
   {
      try{
         //�t�H�[���f�[�^�̎擾
         String carname = request.getParameter("cars");

         //�T�[�u���b�g�R���e�L�X�g�̎擾
         ServletContext sc = getServletContext();

         //���N�G�X�g�̓]��
         if(carname.length() != 0){
            sc.getRequestDispatcher("/thanks.html")
              .forward(request, response);
         }
         else{
            sc.getRequestDispatcher("/error.html")
              .forward(request, response);
         }
      }
      catch(Exception e){    
         e.printStackTrace();
      }
   } 
}
