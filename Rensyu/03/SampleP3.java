import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.input.*;
import javafx.event.*;

public class SampleP3 extends Application
{
   private Label lb1, lb2;

   public static void main(String[] args)
   {
      launch(args);
   }
   public void start(Stage stage)throws Exception
   {
      //�R���g���[���̍쐬
      lb1 = new Label("�L�[�������Ă��������B");
      lb2 = new Label();

      //�y�C���̍쐬
      BorderPane bp = new BorderPane();

      //�y�C���ւ̒ǉ�
      bp.setTop(lb1);
      bp.setBottom(lb2);

      //�V�[���̍쐬
      Scene sc = new Scene(bp, 300, 200);

      //�C�x���g�n���h���̓o�^
      sc.setOnKeyPressed(new SampleEventHandler());

      //�X�e�[�W�ւ̒ǉ�
      stage.setScene(sc);

      //�X�e�[�W�̕\��
      stage.setTitle("�T���v��");
      stage.show();
   }
   //�C�x���g�n���h���N���X
   class SampleEventHandler implements EventHandler<KeyEvent>
   {
      public void handle(KeyEvent e)
      {
         KeyCode k = e.getCode();
         lb2.setText(k.toString() + "�ł��ˁB");
      }
   }
}
