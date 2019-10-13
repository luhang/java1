import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;

public class Sample5 extends Application
{
   private Label[] lb = new Label[3];

   public static void main(String[] args)
   {
      launch(args);
   }
   public void start(Stage stage)throws Exception
   {
      //�R���g���[���̍쐬
      for(int i=0; i<lb.length; i++){ 
         lb[i] = new Label("��" + i + "�͂������ł����H");
      }

      //�R���g���[���̐ݒ�
      lb[0].setTextFill(Color.BLACK);
      lb[1].setTextFill(Color.BLUE);
      lb[2].setTextFill(Color.RED);

      //�y�C���̍쐬
      BorderPane bp = new BorderPane();
      VBox vb = new VBox();

      //�y�C���ւ̒ǉ�
      for(int i=0; i<lb.length; i++){
         vb.getChildren().add(lb[i]);
      }
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
