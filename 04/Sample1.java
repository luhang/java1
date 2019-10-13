import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;

public class Sample1 extends Application
{
   private Button[] bt = new Button[5];

   public static void main(String[] args)
   {
      launch(args);
   }
   public void start(Stage stage)throws Exception
   {
      //�R���g���[���̍쐬
      bt[0] = new Button("Top");
      bt[1] = new Button("Bottom");
      bt[2] = new Button("Center");
      bt[3] = new Button("Left");
      bt[4] = new Button("Right");

      //�y�C���̍쐬
      BorderPane bp = new BorderPane();

      //�y�C���ւ̒ǉ�
      bp.setTop(bt[0]);
      bp.setBottom(bt[1]);
      bp.setCenter(bt[2]);
      bp.setLeft(bt[3]);
      bp.setRight(bt[4]);

      for(int i=0; i<bt.length; i++){
         bp.setAlignment(bt[i], Pos.CENTER);
      }

      //�V�[���̍쐬
      Scene sc = new Scene(bp, 300, 200);

      //�X�e�[�W�ւ̒ǉ�
      stage.setScene(sc);

      //�X�e�[�W�̕\��
      stage.setTitle("�T���v��");
      stage.show();
   }
}
