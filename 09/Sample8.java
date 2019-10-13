import java.io.*;
import java.util.regex.*;
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.input.*;
import javafx.event.*;

public class Sample8 extends Application
{
   private Label lb1, lb2, lb3;
   private TextArea ta;
   private TextField tf1, tf2;
   private Button bt;

   public static void main(String[] args)
   {
      launch(args);
   }
   public void start(Stage stage)throws Exception
   {
      //�R���g���[���̍쐬
      lb1 = new Label("���͂��Ă��������B");
      lb2 = new Label("�u���O");
      lb3 = new Label("�u����");
      ta = new TextArea();

      bt = new Button("�u��");
      tf1 = new TextField();
      tf2 = new TextField();

      //�y�C���̍쐬
      BorderPane bp = new BorderPane();
      HBox hb = new HBox();

      //�y�C���ւ̒ǉ�
      hb.getChildren().add(lb2);
      hb.getChildren().add(tf1);
      hb.getChildren().add(lb3);
      hb.getChildren().add(tf2);
      hb.getChildren().add(bt);

      bp.setTop(lb1);
      bp.setCenter(ta);
      bp.setBottom(hb);

      //�C�x���g�n���h���̓o�^
      bt.setOnAction(new SampleEventHandler());

      //�V�[���̍쐬
      Scene sc = new Scene(bp, 500, 200);

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
         Pattern pn = Pattern.compile(tf1.getText());
         Matcher mt = pn.matcher(ta.getText());
         ta.setText(mt.replaceAll(tf2.getText()));
      }
   }
}
