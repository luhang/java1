import java.io.*;
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.input.*;
import javafx.event.*;

public class Sample6 extends Application
{
   private Label lb1, lb2;
   private TextField tf1, tf2;
   private Button bt;

   public static void main(String[] args)
   {
      launch(args);
   }
   public void start(Stage stage)throws Exception
   {
      //�R���|�[�l���g�̍쐬
      lb1 = new Label("���Ԗڂ̃f�[�^��ǂݍ��݂܂����H�i1�`5�j");
      lb2 = new Label("�f�[�^:");

      tf1 = new TextField("1");
      tf2 = new TextField();

      bt = new Button("�Ǎ�");

      //�y�C���̍쐬
      BorderPane bp = new BorderPane();
      VBox vb = new VBox();

      //�y�C���ւ̒ǉ�
      vb.getChildren().add(lb1);
      vb.getChildren().add(tf1);
      vb.getChildren().add(lb2);
      vb.getChildren().add(tf2);

      bp.setCenter(vb);
      bp.setBottom(bt);
      
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
         fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("�o�C�i���t�@�C��", "*.bin"));
         File fl = fc.showOpenDialog(new Stage());
         try{
            if(fl != null){
               RandomAccessFile raf =
                 new RandomAccessFile(fl, "r");
               int pos =Integer.parseInt(tf1.getText());
               raf.seek(pos-1);
               int num = raf.read();
               tf2.setText((Integer.valueOf(num)).toString());
               raf.close();
            }
         }
         catch(Exception ex){
               ex.printStackTrace();
         }
      }
   }
}
