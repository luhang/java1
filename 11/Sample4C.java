import java.io.*;
import java.net.*;
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.input.*;
import javafx.event.*;

public class Sample4C extends Application
{
   public static final String HOST = "localhost";
   public static final int PORT = 10000;

   private TextArea ta;
   private Button bt;

   public static void main(String[] args)
   {
      launch(args);
   }
   public void start(Stage stage)throws Exception
   {
      try{
         InetAddress ia = InetAddress.getLocalHost();

         //�R���g���[���̍쐬
         ta = new TextArea();
         bt = new Button("�ڑ�");

         //�y�C���̍쐬
         BorderPane bp = new BorderPane();

         //�y�C���ւ̒ǉ�
         bp.setCenter(ta);
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
      catch(Exception e){
         e.printStackTrace();
      }
   }

   //�C�x���g�n���h���N���X
   class SampleEventHandler implements EventHandler<ActionEvent>
   {
      public void handle(ActionEvent e)
      {
         try{
            Socket sc = new Socket(HOST, PORT);
            BufferedReader  br = new BufferedReader
                 (new InputStreamReader(sc.getInputStream()));
            String str = br.readLine();
            ta.setText(str);
            br.close();
            sc.close();
         }
         catch(Exception ex){
            ex.printStackTrace();
         }
      }
   }
}
