import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.input.*;
import javafx.event.*;
import javafx.collections.*;
import javafx.beans.value.*;

public class Sample1 extends Application
{
   private Label lb;
   private ComboBox<String> cb;
   private ObservableList<String> ol;

   public static void main(String[] args)
   {
      launch(args);
   }
   public void start(Stage stage)throws Exception
   {
      //�R���g���[���̍쐬
      lb = new Label("��������Ⴂ�܂��B");
      cb = new ComboBox<String>();
      
      //�R���g���[���̐ݒ�
      ObservableList<String> ol = 
         FXCollections.observableArrayList("��p��", "�g���b�N", "�I�[�v���J�[",
                                           "�^�N�V�[", "�X�|�[�c�J�[", "�~�j�J�[");
      cb.setItems(ol);

      //�y�C���̍쐬
      BorderPane bp = new BorderPane();

      //�y�C���ւ̒ǉ�
      bp.setTop(lb);
      bp.setCenter(cb);

      //�C�x���g�n���h���̓o�^
      cb.setOnAction(new SampleEventHandler());

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
         ComboBox tmp = (ComboBox) e.getSource();
         String str = tmp.getValue().toString();
         lb.setText(str + "�ł��ˁB");
      }
   }
}
