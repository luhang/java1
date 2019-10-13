import java.net.*;
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.input.*;
import javafx.event.*;

public class Sample3 extends Application
{
   private Label lb1, lb2, lb3;
   private TextField tf1, tf2, tf3;
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
         lb1 = new Label("���͂��Ă��������B");
         lb2 = new Label("�z�X�g��");
         lb3 = new Label("IP�A�h���X");
         tf1 = new TextField();    
         tf2 = new TextField(); 
         tf3 = new TextField(); 
         bt = new Button("����");

         //�y�C���̍쐬
         BorderPane bp = new BorderPane();
         VBox vb = new VBox();

         //�y�C���ւ̒ǉ�
         vb.getChildren().add(lb1);
         vb.getChildren().add(tf1);
         vb.getChildren().add(lb2);
         vb.getChildren().add(tf2);
         vb.getChildren().add(lb3);
         vb.getChildren().add(tf3);

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
            tf2.setText(ia.getHostName());    
            tf3.setText(ia.getHostAddress());
         }
         catch(Exception ex){
            ex.printStackTrace();
         }
      }
   }
}
