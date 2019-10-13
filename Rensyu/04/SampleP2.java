import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.input.*;
import javafx.event.*;
import javafx.scene.image.*;

public class SampleP2 extends Application
{
   private Label lb;
   private CheckBox ch;
   private Image im;
   private ImageView iv;

   public static void main(String[] args)
   {
      launch(args);
   }
   public void start(Stage stage)throws Exception
   {
      //�R���g���[���̍쐬
      lb = new Label("�Ԃł��B");
      ch = new CheckBox("�摜�̕\��");
            
      im = new Image(getClass().getResourceAsStream("car.jpg"));
      iv = new ImageView(im);
     
      //�y�C���̍쐬
      BorderPane bp = new BorderPane();

      //�y�C���ւ̒ǉ�
      bp.setCenter(lb);
      bp.setBottom(ch);
      
      //�C�x���g�n���h���̓o�^
      ch.setOnAction(new SampleEventHandler());

      //�V�[���̍쐬
      Scene sc = new Scene(bp, 300, 200);
      
      //�X�e�[�W�ւ̒ǉ�
      stage.setScene(sc);

      //�X�e�[�W�̕\��
      stage.setTitle("�T���v��");
      stage.show();
   }
   //�C�x���g�n���h���N���X
   class SampleEventHandler implements EventHandler<ActionEvent>
   {
      public void handle(ActionEvent e)
      {
         CheckBox tmp = (CheckBox)e.getSource();
         if(tmp.isSelected() == true){
            lb.setGraphic(iv);
         }
         else if(tmp.isSelected() == false){
            lb.setGraphic(null);;
         }
      }
   }
}
