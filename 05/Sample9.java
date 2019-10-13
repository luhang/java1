import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.canvas.*;

public class Sample9 extends Application
{
   private Canvas cv;

   public static void main(String[] args)
   {
      launch(args);
   }
   public void start(Stage stage)throws Exception
   {
      //�R���g���[���̍쐬
      cv = new Canvas(300, 200);

      //�R���g���[���̐ݒ�
      GraphicsContext gc = cv.getGraphicsContext2D();

      for(int i=0; i<100; i++){
         int r = (int) (Math.random() * 256);
         int g = (int) (Math.random() * 256);
         int b = (int) (Math.random() * 256);

         double x = Math.random() * 300;
         double y = Math.random() * 200;

         gc.setFill(Color.rgb(r, g, b, 1.0));
         gc.fillOval(x, y, 10, 10);   
      }

      //�y�C���̍쐬
      BorderPane bp = new BorderPane();

      //�y�C���ւ̒ǉ�
      bp.setCenter(cv);
      
      //�V�[���̍쐬
      Scene sc = new Scene(bp, 300, 200);
      
      //�X�e�[�W�ւ̒ǉ�
      stage.setScene(sc);

      //�X�e�[�W�̕\��
      stage.setTitle("�T���v��");
      stage.show();
   }
}
