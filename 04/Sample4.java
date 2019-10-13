import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;

public class Sample4 extends Application
{
   private Label[] lb = new Label[5];
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
      for(int i=0; i<lb.length; i++){
         lb[i] = new Label(Integer.toString(i));
      }

      //�y�C���̍쐬
      BorderPane bp = new BorderPane();
      HBox hb = new HBox();
      VBox vb = new VBox();

      //�y�C���ւ̒ǉ�
      for(int i=0; i<bt.length; i++){
         hb.getChildren().add(bt[i]);
      }
      for(int i=0; i<lb.length; i++){
         vb.getChildren().add(lb[i]);
      }

      hb.setAlignment(Pos.CENTER);
      vb.setAlignment(Pos.CENTER);

      bp.setTop(hb);
      bp.setCenter(vb);

      //�V�[���̍쐬
      Scene sc = new Scene(bp, 300, 200);
      
      //�X�e�[�W�ւ̒ǉ�
      stage.setScene(sc);

      //�X�e�[�W�̕\��
      stage.setTitle("�T���v��");
      stage.show();
   }
}
