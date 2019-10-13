import mybeans.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SampleP3 extends HttpServlet
{
   public void doGet(HttpServletRequest request,
                     HttpServletResponse response)
   throws ServletException
   {
      try{
         //�t�H�[���f�[�^�̎擾
         String carname = request.getParameter("cars");
         
         //Bean�̍쐬
         CarBean cb = new CarBean();
         cb.setCarname(carname);
         cb.makeCardata();
      
         //���N�G�X�g�ɐݒ�
         request.setAttribute("cb", cb);

         //�T�[�u���b�g�R���e�L�X�g�̎擾
         ServletContext sc = getServletContext();

         //���N�G�X�g�̓]��
         if(carname.length() == 0){
            sc.getRequestDispatcher("/error.html")
              .forward(request, response);
         }
         else if(carname.equals("�^�N�V�[")){
            sc.getRequestDispatcher("/SampleP3T.jsp")
              .forward(request, response);
         }
         else{
            sc.getRequestDispatcher("/SampleP3.jsp")
              .forward(request, response);
         }
      }
      catch(Exception e){    
         e.printStackTrace();
      } 
   } 
}
