import java.io.*;
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.input.*;
import javafx.scene.web.*;
import javafx.event.*;

public class Sample1 extends Application
{
   private TextField tf;
   private WebView wv;
   private Button bt;

   public static void main(String[] args)
   {
      launch(args);
   }
   public void start(Stage stage)throws Exception
   {
      //�R���g���[���̍쐬
      tf = new TextField();
      wv = new WebView();
      bt = new Button("�Ǎ�");

      //�y�C���̍쐬
      BorderPane bp = new BorderPane();
      VBox vb = new VBox();
 
      //�y�C���ւ̒ǉ�
      vb.getChildren().addAll(bt, tf);

      bp.setTop(vb);
      bp.setCenter(wv);
      
      //�C�x���g�n���h���̓o�^
      bt.setOnAction(new SampleEventHandler());

      //�V�[���̍쐬
      Scene sc = new Scene(bp, 600, 600);
      
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
         try{
            WebEngine we = wv.getEngine();
            we.load(tf.getText());
         }
         catch(Exception ex){
            ex.printStackTrace();
         }
      }
   }
}
