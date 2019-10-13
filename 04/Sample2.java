import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class Sample2 extends Application
{
   private Button[] bt = new Button[10];

   public static void main(String[] args)
   {
      launch(args);
   }
   public void start(Stage stage)throws Exception
   {
      //�R���g���[���̍쐬
      for(int i=0; i<bt.length; i++){
         bt[i] = new Button(Integer.toString(i));
      }

      //�y�C���̍쐬
      FlowPane fp = new FlowPane();

      //�y�C���ւ̒ǉ�
      for(int i=0; i<bt.length; i++){
         fp.getChildren().add(bt[i]);
      }

      //�V�[���̍쐬
      Scene sc = new Scene(fp, 300, 100);

      //�X�e�[�W�ւ̒ǉ�
      stage.setScene(sc);

      //�X�e�[�W�̕\��
      stage.setTitle("�T���v��");
      stage.show();
   }
}
