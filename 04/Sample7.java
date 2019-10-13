import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import javafx.scene.image.*;

public class Sample7 extends Application
{
   private Label[] lb = new Label[3];
   private Image im;

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
      im = new Image(getClass().getResourceAsStream("car.jpg"));
     
      //�R���g���[���̐ݒ�
      lb[0].setGraphic(new ImageView(im));
      lb[1].setGraphic(new ImageView(im));
      lb[1].setContentDisplay(ContentDisplay.RIGHT);
      lb[2].setBackground(new Background
                         (new BackgroundFill(Color.WHITE, null, null)));

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
