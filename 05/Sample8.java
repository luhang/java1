import java.util.*;
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.input.*;
import javafx.event.*;

public class Sample8 extends Application
{
   private Label lb;
   private Button bt;

   public static void main(String[] args)
   {
      launch(args);
   }
   public void start(Stage stage)throws Exception
   {
      //�R���|�[�l���g�̍쐬
      lb = new Label();
      bt = new Button();
      
      //�R���|�[�l���g�̐ݒ�
      lb.setText("��������Ⴂ�܂��B");
      bt.setText("�w��");

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
         Alert al1 = new Alert(Alert.AlertType.CONFIRMATION);
         al1.setTitle("�m�F"); 
         al1.getDialogPane().setHeaderText("�{���ɍw�����܂����H");
         Optional<ButtonType> res = al1.showAndWait();

         if(res.get() == ButtonType.OK){
            Alert al2 = new Alert(Alert.AlertType.INFORMATION);
            al2.setTitle("�w��"); 
            al2.getDialogPane().setHeaderText("���w�����肪�Ƃ��������܂����B");
            al2.show();
         }
      }
   }
}
