import java.io.*;
import java.net.*;
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.input.*;
import javafx.event.*;

public class SamplePC extends Application
{
   private Label lb1, lb2;
   private TextField tf1, tf2;
   private TextArea ta;
   private Button bt;

   public static void main(String[] args)
   {
      launch(args);
   }
   public void start(Stage stage)throws Exception
   {
      try{
         //�R���g���[���̍쐬
         lb1 = new Label("�z�X�g");
         lb2 = new Label("�|�[�g");
         tf1 = new TextField();
         tf2 = new TextField();
         ta = new TextArea();
         bt = new Button("�ڑ�");

         //�y�C���̍쐬
         GridPane gp = new GridPane();
         BorderPane bp = new BorderPane();

         //�y�C���ւ̒ǉ�
         gp.add(lb1, 0, 0);
         gp.add(lb2, 0, 1);
         gp.add(tf1, 1, 0);
         gp.add(tf2, 1, 1);
         bp.setTop(gp);
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
            InetAddress ia = InetAddress.getByName(tf1.getText());
            String host = ia.getHostName();   
            int port = Integer.parseInt(tf2.getText());

            Socket sc = new Socket(host, port);
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
