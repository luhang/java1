import java.io.*;
import java.net.*;
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.input.*;
import javafx.event.*;

public class Sample5C extends Application implements Runnable
{
   public static final String HOST = "localhost";
   public static final int PORT = 10000;
	
   private TextField tf;
   private TextArea ta;
   private Button bt;

   private Socket sc;
   private BufferedReader br;
   private PrintWriter pw;
   private StringBuffer sb;

   public static void main(String[] args)
   {
      launch(args);
   }
   public void start(Stage stage)throws Exception
   {
      try{
         InetAddress ia = InetAddress.getLocalHost();

         //�R���|�[�l���g�̍쐬
         tf = new TextField();
         ta = new TextArea();
         bt = new Button("���M");

         //�y�C���̍쐬
         BorderPane bp = new BorderPane();
       
         bp.setTop(tf);
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

      //�ڑ�
      Thread th = new Thread(this);
      th.start();
   }
   public void run()
   {
      try{
         sc = new Socket(HOST, PORT);
         br = new BufferedReader
            (new InputStreamReader(sc.getInputStream()));
         pw = new PrintWriter
            (new BufferedWriter(new OutputStreamWriter(sc.getOutputStream())));
         sb = new StringBuffer();

         while(true){
            try{
               String str = br.readLine();
               sb.append(str + "\n");
               ta.setText(sb.toString());
            }
            catch(Exception e){
               br.close();
               pw.close();
               sc.close();
               break;
            }
         }
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
            String str = tf.getText();
            sb.append(str + "\n");
            pw.println(str);
            pw.flush();
            tf.setText("");
         }
         catch(Exception ex){
            ex.printStackTrace();
         }
      }
   }
}
