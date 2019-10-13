import java.io.*;
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.input.*;
import javafx.event.*;
import javafx.geometry.*;

public class Sample3 extends Application
{
   private Label lb1, lb2, lb3, lb4;
   private Button bt;

   public static void main(String[] args)
   {
      launch(args);
   }
   public void start(Stage stage)throws Exception
   {
      //�R���g���[���̍쐬
      lb1 = new Label("�t�@�C����I�����Ă��������B");
      lb2 = new Label();
      lb3 = new Label();
      lb4 = new Label();
      bt = new Button("�I��");

      //�y�C���̍쐬
      BorderPane bp = new BorderPane();
      VBox vb = new VBox();

      //�y�C���ւ̒ǉ�
      vb.getChildren().add(lb1);
      vb.getChildren().add(lb2);
      vb.getChildren().add(lb3);
      vb.getChildren().add(lb4);

      bp.setTop(lb1);
      bp.setCenter(vb);
      bp.setBottom(bt);
      bp.setAlignment(bt, Pos.CENTER);

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
         FileChooser fc = new FileChooser();
         File fl = fc.showOpenDialog(new Stage());
         if(fl != null){
            lb2.setText("�t�@�C������" + fl.getName() + "�ł��B");
            lb3.setText("��΃p�X��" + fl.getAbsolutePath() + "�ł��B");
            lb4.setText("�T�C�Y��" + fl.length() + "�o�C�g�ł��B");
         }
      }
   }
}
