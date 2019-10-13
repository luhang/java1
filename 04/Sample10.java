import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.input.*;
import javafx.event.*;
import javafx.geometry.*;

public class Sample10 extends Application
{
   private Label lb;
   private RadioButton rb1, rb2;
   private ToggleGroup tg;

   public static void main(String[] args)
   {
      launch(args);
   }
   public void start(Stage stage)throws Exception
   {
      //�R���g���[���̍쐬
      lb  = new Label("��������Ⴂ�܂��B");
      rb1 = new RadioButton("��");
      rb2 = new RadioButton("�g���b�N");
      tg  = new ToggleGroup();

      //�g�O���O���[�v�ւ̒ǉ�
      rb1.setToggleGroup(tg);
      rb2.setToggleGroup(tg);

      rb1.setSelected(true);

      //�y�C���̍쐬
      BorderPane bp = new BorderPane();
      HBox hb = new HBox();

      //�y�C���ւ̒ǉ�
      hb.getChildren().add(rb1);
      hb.getChildren().add(rb2);
      hb.setAlignment(Pos.CENTER);

      bp.setTop(lb);
      bp.setCenter(hb);

      //�C�x���g�n���h���̓o�^
      rb1.setOnAction(new SampleEventHandler());
      rb2.setOnAction(new SampleEventHandler());

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
         RadioButton tmp = (RadioButton) e.getSource();
         lb.setText(tmp.getText() + "��I�т܂����B");
      }
   }
}
