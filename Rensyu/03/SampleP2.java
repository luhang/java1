import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.input.*;
import javafx.event.*;

public class SampleP2 extends Application
{
   private Button bt;

   public static void main(String[] args)
   {
      launch(args);
   }
   public void start(Stage stage)throws Exception
   {
      //�R���g���[���̍쐬
      bt = new Button("�悤�����B");

      //�y�C���̍쐬
      BorderPane bp = new BorderPane();

      //�y�C���ւ̒ǉ�
      bp.setCenter(bt);

      //�C�x���g�n���h���̓o�^
      bt.addEventHandler(MouseEvent.MOUSE_ENTERED, new SampleEventHandler());
      bt.addEventHandler(MouseEvent.MOUSE_EXITED, new SampleEventHandler());

      //�V�[���̍쐬
      Scene sc = new Scene(bp, 300, 200);

      //�X�e�[�W�ւ̒ǉ�
      stage.setScene(sc);

      //�X�e�[�W�̕\��
      stage.setTitle("�T���v��");
      stage.show();
   }

   //�C�x���g�n���h���N���X
   class SampleEventHandler implements EventHandler<MouseEvent>
   {
      public void handle(MouseEvent e)
      {
         if(e.getEventType() == MouseEvent.MOUSE_ENTERED){
            bt.setText("��������Ⴂ�܂��B");
         }
         else if(e.getEventType() == MouseEvent.MOUSE_EXITED){
            bt.setText("�悤�����B");
         }
      }
   }
}
