import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.input.*;
import javafx.event.*;

public class SampleP2 extends Application
{
   private Label lb;
   private Button bt;

   public static void main(String[] args)
   {
      launch(args);
   }
   public void start(Stage stage)throws Exception
   {
      //�R���g���[���̍쐬
      lb = new Label("��������Ⴂ�܂��B");
      bt = new Button("�w��");
      
      //�y�C���̍쐬
      BorderPane bp = new BorderPane();

      //�y�C���ւ̒ǉ�
      bp.setTop(lb);
      bp.setCenter(bt);
      
      //�C�x���g�n���h���̓o�^
      bt.setOnAction(new SampleEventHandler());

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
         Alert al = new Alert(Alert.AlertType.INFORMATION);
         al.setTitle("�w��"); 
         al.getDialogPane().setHeaderText("��ς��肪�Ƃ��������܂����B");
         al.show();
      }
   }
}
