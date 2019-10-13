import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.input.*;
import javafx.event.*;

public class Sample5 extends Application
{
   private Label lb;

   public static void main(String[] args)
   {
      launch(args);
   }
   public void start(Stage stage)throws Exception
   {
      //�R���g���[���̍쐬
      lb = new Label("��������Ⴂ�܂��B");

      //�y�C���̍쐬
      BorderPane bp = new BorderPane();

      //�y�C���ւ̒ǉ�
      bp.setTop(lb);

      //�V�[���̍쐬
      Scene sc = new Scene(bp, 300, 200);
      
      //�C�x���g�n���h���̓o�^
      sc.addEventHandler(MouseEvent.MOUSE_CLICKED, new SampleEventHandler());

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
         lb.setText("���w�����肪�Ƃ��������܂��B");
      }
   }
}
