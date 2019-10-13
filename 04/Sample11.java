import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.input.*;
import javafx.event.*;

public class Sample11 extends Application
{
   private Label lb;
   private TextField tf;

   public static void main(String[] args)
   {
      launch(args);
   }
   public void start(Stage stage)throws Exception
   {
      //�R���g���[���̍쐬
      lb = new Label("��������Ⴂ�܂��B");
      tf = new TextField();
      
      //�y�C���̍쐬
      BorderPane bp = new BorderPane();

      //�y�C���ւ̒ǉ�
      bp.setTop(lb);
      bp.setBottom(tf);

      //�C�x���g�n���h���̓o�^
      tf.setOnAction(new SampleEventHandler());

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
         lb.setText(tf.getText() + "�ł��ˁB");
      }
   }
}
