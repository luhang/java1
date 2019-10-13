import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.input.*;
import javafx.event.*;
import javafx.collections.*;
import javafx.beans.value.*;

public class Sample2 extends Application
{
   private Label lb;
   private ListView<String> lv;

   public static void main(String[] args)
   {
      launch(args);
   }
   public void start(Stage stage)throws Exception
   {
      //�R���g���[���̍쐬
      lb = new Label("��������Ⴂ�܂��B");
      lv = new ListView<String>();

      //�R���g���[���̐ݒ�
      ObservableList<String> ol = 
         FXCollections.observableArrayList
                     ("��p��", "�g���b�N", "�I�[�v���J�[",
                      "�^�N�V�[", "�X�|�[�c�J�[", "�~�j�J�[",
                      "���]��", "�O�֎�", "�o�C�N",
                      "��s�@", "�w���R�v�^�[", "���P�b�g");
      lv.setItems(ol);

      //�y�C���̍쐬
      BorderPane bp = new BorderPane();

      //�y�C���ւ̒ǉ�
      bp.setTop(lb);
      bp.setCenter(lv);
      
      //�C�x���g�n���h���̓o�^
      lv.getSelectionModel().selectedItemProperty()
           .addListener(new SampleChangeListener());

      //�V�[���̍쐬
      Scene sc = new Scene(bp, 300, 200);
      
      //�X�e�[�W�ւ̒ǉ�
      stage.setScene(sc);

      //�X�e�[�W�̕\��
      stage.setTitle("�T���v��");
      stage.show();
   }

   //�C�x���g�n���h���N���X
   class SampleChangeListener implements ChangeListener<String>
   {
      public void changed(ObservableValue ob, String bs, String as)
      {
         lb.setText(as + "�ł��ˁB");
      }
   }
}
