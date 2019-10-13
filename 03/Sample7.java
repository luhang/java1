import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.input.*;
import javafx.event.*;

public class Sample7 extends Application
{
   private Label lb1, lb2;

   public static void main(String[] args)
   {
      launch(args);
   }
   public void start(Stage stage)throws Exception
   {
      //�R���g���[���̍쐬
      lb1 = new Label("���L�[�ł��I�т��������B");
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
         String str;
         KeyCode k = e.getCode();
         switch(k){
            case UP:
              str = "��"; break;
            case DOWN:
              str = "��"; break;
            case LEFT:
              str = "��"; break;
            case RIGHT:
              str = "�E"; break;
            default:
              str = "���̃L�[";
         }
         lb2.setText(str + "�ł��ˁB");
      }
   }
}
