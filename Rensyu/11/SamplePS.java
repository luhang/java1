import java.io.*;
import java.net.*;

public class SamplePS
{
   public static void main(String[] args)
   {
      SamplePS sm = new SamplePS();

      if(args.length != 1){
         System.out.println("�p�����[�^�̐����Ⴂ�܂��B");
         System.exit(1);
      }

      try{
         ServerSocket ss = new ServerSocket(Integer.parseInt(args[0]));

         System.out.println("�ҋ@���܂��B");
         while(true){
            Socket sc = ss.accept();
            System.out.println("�悤�����B");
                   
            PrintWriter pw = new PrintWriter
               (new BufferedWriter
               (new OutputStreamWriter(sc.getOutputStream())));
            pw.println("������̓T�[�o�ł��B");
            pw.flush();
            pw.close();

            sc.close();
         }
      }
      catch(Exception e){
         e.printStackTrace();
      }
   }
}
