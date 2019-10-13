import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.input.*;
import javafx.event.*;
import javafx.geometry.*;

public class Sample9 extends Application
{
   private Label lb;
   private CheckBox ch1, ch2;

   public static void main(String[] args)
   {
      launch(args);
   }
   public void start(Stage stage)throws Exception
   {
      //�R���g���[���̍쐬
      lb = new Label("��������Ⴂ�܂��B");
      ch1 = new CheckBox("��");
      ch2 = new CheckBox("�g���b�N");

      //�y�C���̍쐬
      BorderPane bp = new BorderPane();
      HBox hb = new HBox();

      //�y�C���ւ̒ǉ�
      hb.getChildren().add(ch1);
      hb.getChildren().add(ch2);
      hb.setAlignment(Pos.CENTER);

      bp.setTop(lb);
      bp.setCenter(hb);

      //�C�x���g�n���h���̓o�^
      ch1.setOnAction(new SampleEventHandler());
      ch2.setOnAction(new SampleEventHandler());

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
         CheckBox tmp = (CheckBox) e.getSource();
         if(tmp.isSelected() == true){
            lb.setText(tmp.getText() + "��I�т܂����B");
         }
         else if(tmp.isSelected() == false){
            lb.setText(tmp.getText() + "����߂܂����B");
         }
      }
   }
}
