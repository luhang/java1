import java.util.*;
import java.io.*;
import java.net.*;

public class Sample5S
{
   public static final int PORT = 10000;

   public static void main(String[] args)
   {
      Sample5S sm = new Sample5S();

      try{
         ServerSocket ss = new ServerSocket(PORT);

         System.out.println("�ҋ@���܂��B");
         while(true){
            try{
               Socket sc = ss.accept();
               System.out.println("�悤�����B");
                   
               Client cl = new Client(sc);
               cl.start();
            }
            catch(Exception e){
               e.printStackTrace();
               break;
            }
         }
      }
      catch(Exception e){
         e.printStackTrace();
      }
   }
}

class Client extends Thread
{
   private Socket sc;
   private BufferedReader br;
   private PrintWriter pw;

   public Client(Socket s)
   {
      sc = s;
   }
   public void run()
   {
      try{
         br = new BufferedReader
            (new InputStreamReader(sc.getInputStream()));
         pw = new PrintWriter
            (new BufferedWriter(new OutputStreamWriter(sc.getOutputStream())));
      }
      catch(Exception e){
         e.printStackTrace();
      }

      while(true){
         try{ 
            String str = br.readLine();
            pw.println("�T�[�o:�u" + str + "�v�ł��ˁB");
            pw.flush();
         }
         catch(Exception e){
            try{
               br.close();
               pw.close();
               sc.close();
               System.out.println("���悤�Ȃ�B");
               break;
             }
             catch(Exception ex){
                ex.printStackTrace();
            }
         }
      }
   }
}
