import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.input.*;
import javafx.scene.text.*;
import javafx.event.*;
import javafx.geometry.*;

public class SampleP3 extends Application
{
   private Label lb;
   private RadioButton rb1, rb2, rb3;
   private ToggleGroup tg;

   public static void main(String[] args)
   {
      launch(args);
   }
   public void start(Stage stage)throws Exception
   {
      //�R���g���[���̍쐬
      lb  = new Label("Hello!");
      lb.setFont(Font.font("Serif", FontWeight.NORMAL, 24));
      rb1 = new RadioButton("����");
      rb2 = new RadioButton("����");
      rb3 = new RadioButton("�C�^���b�N");
      tg  = new ToggleGroup();

      //�g�O���O���[�v�ւ̒ǉ�
      rb1.setToggleGroup(tg);
      rb2.setToggleGroup(tg);
      rb3.setToggleGroup(tg);
      
      rb1.setSelected(true);

      //�y�C���̍쐬
      BorderPane bp = new BorderPane();
      HBox hb = new HBox();

      //�y�C���ւ̒ǉ�
      hb.getChildren().add(rb1);
      hb.getChildren().add(rb2);
      hb.getChildren().add(rb3);
      hb.setAlignment(Pos.CENTER);

      bp.setTop(lb);
      bp.setCenter(hb);
      
      //�C�x���g�n���h���̓o�^
      rb1.setOnAction(new SampleEventHandler());
      rb2.setOnAction(new SampleEventHandler());
      rb3.setOnAction(new SampleEventHandler());

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
         if(tmp == rb1)
            lb.setFont(Font.font("Serif", FontWeight.NORMAL, 24));
         else if(tmp == rb2)
            lb.setFont(Font.font("Serif", FontWeight.BOLD, 24));
         else if(tmp == rb3)
            lb.setFont(Font.font("Serif", FontPosture.ITALIC, 24));
      }
   }
}
