import java.io.*;

public class Sample2
{
   public static void main(String[] args)
   {
      if(args.length != 2){
         System.out.println("�p�����[�^�̐����Ⴂ�܂��B");
         System.exit(1);
      }

      try{
         File fl1 = new File(args[0]);
         File fl2 = new File(args[1]);

         System.out.println("�ύX�O�̃t�@�C������" + fl1.getName() + "�ł��B");

         boolean res = fl1.renameTo(fl2);
         if(res == true){
            System.out.println("�t�@�C������ύX���܂����B");
            System.out.println("�ύX��̃t�@�C������" + fl2.getName() + "�ł��B");
         }
         else{
            System.out.println("�t�@�C������ύX�ł��܂���ł����B");
         }
      }
      catch(Exception e){
         e.printStackTrace();
      }
   }
}
