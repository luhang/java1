import java.io.*;

public class Sample1
{
   public static void main(String[] args)
   {
      if(args.length != 1){
         System.out.println("�p�����[�^�̐����Ⴂ�܂��B");
         System.exit(1);
      }

      try{
         File fl = new File(args[0]);
         System.out.println("�t�@�C������" + fl.getName() + "�ł��B");
         System.out.println("��΃p�X��" + fl.getAbsolutePath() + "�ł��B");
         System.out.println("�T�C�Y��" + fl.length() + "�o�C�g�ł��B");
      }   
      catch(Exception e){
         e.printStackTrace();
      }
   }
}
