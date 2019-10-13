import java.io.*;
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.image.*;

public class Sample7 extends Application
{
   private TitledPane[] tp;
   private Image[] im;
   private ImageView[] iv;
   private Accordion ac;

   public static void main(String[] args)
   {
      launch(args);
   }
   public void start(Stage stage)throws Exception
   {
      //�R���g���[���̍쐬
      File fl = new File(".");
      File[] fls = fl.listFiles(new SampleFileFilter());

      im = new Image[fls.length];
      iv = new ImageView[fls.length];
      tp = new TitledPane[fls.length];
      ac = new Accordion();

      for(int i=0; i<fls.length; i++){
         im[i] = new Image(getClass().getResourceAsStream(fls[i].getName()));
         iv[i] = new ImageView(im[i]);
         tp[i] = new TitledPane(fls[i].getName(), iv[i]);
      }

      //�y�C���̍쐬
      BorderPane bp = new BorderPane();

      //�y�C���ւ̒ǉ�
      ac.getPanes().addAll(tp);
      bp.setCenter(ac);

      //�V�[���̍쐬
      Scene sc = new Scene(bp, 300, 200);

      //�X�e�[�W�ւ̒ǉ�
      stage.setScene(sc);

      //�X�e�[�W�̕\��
      stage.setTitle("�T���v��");
      stage.show();
   }

   //�t�B���^�N���X
   class SampleFileFilter implements FilenameFilter
   {
      public boolean accept(File f, String n)
      {
         if(n.toLowerCase().endsWith(".jpg")){
            return true;
         }
         return false;
      }
   }
}
