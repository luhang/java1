import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class Sample3 extends Application
{
   private Button[][] bt = new Button[6][3];

   public static void main(String[] args)
   {
      launch(args);
   }
   public void start(Stage stage)throws Exception
   {
      //�R���g���[���̍쐬
      for(int i=0; i<bt.length; i++){
         for(int j=0; j<bt[i].length; j++){
            bt[i][j] = new Button(Integer.toString(i) + Integer.toString(j));
         }
      }

      //�y�C���̍쐬
      GridPane gp = new GridPane();

      //�y�C���ւ̒ǉ�
      for(int i=0; i<bt.length; i++){
         for(int j=0; j<bt[i].length; j++){
            gp.add(bt[i][j], i, j);
         }
      }

      //�V�[���̍쐬
      Scene sc = new Scene(gp, 300, 200);

      //�X�e�[�W�ւ̒ǉ�
      stage.setScene(sc);

      //�X�e�[�W�̕\��
      stage.setTitle("�T���v��");
      stage.show();
   }
}
