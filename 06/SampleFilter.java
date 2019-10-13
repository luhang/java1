import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SampleFilter implements Filter 
{
   public void doFilter(ServletRequest request,
                        ServletResponse response,
                        FilterChain chain)
               throws IOException, ServletException
   {
      //�R���e���c�^�C�v�̐ݒ�
      response.setContentType("text/html; charset=UTF-8");

      //HTML�����̏����o��
      PrintWriter pw = response.getWriter();
      pw.println("<!DOCTYPE html><html>\n" +
                 "<head><title>�T���v��</title></head>\n" +
                 "<body><div style=\"text-align: center;\">\n" +
                 "<h2>����ɂ���</h2>" +
                 "<hr/>\n");

      chain.doFilter(request, response);

      pw.println("<hr/>���肪�Ƃ��������܂����B\n" +
                 "</div></body>\n" +
                 "</html>\n");

   }
   public void init(FilterConfig filterConfig){}
   public void destroy(){} 
}
