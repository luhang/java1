import java.io.*;
import java.util.regex.*;
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.input.*;
import javafx.event.*;

public class Sample9 extends Application
{
   private Label lb;
   private TextArea ta;
   private TextField tf;
   private Button bt1, bt2;
   private Matcher mt;

   public static void main(String[] args)
   {
      launch(args);
   }
   public void start(Stage stage)throws Exception
   {
      //�R���g���[���̍쐬
      lb = new Label("���͂��Ă��������B");
      ta = new TextArea();
      tf = new TextField();
      bt1 = new Button("����");
      bt2 = new Button("����");

      //�y�C���̍쐬
      BorderPane bp = new BorderPane();
      HBox hb = new HBox();

      //�y�C���ւ̒ǉ�
      hb.getChildren().add(tf);
      hb.getChildren().add(bt1);
      hb.getChildren().add(bt2);

      bp.setTop(lb);
      bp.setCenter(ta);
      bp.setBottom(hb);
      
      //�C�x���g�n���h���̓o�^
      bt1.setOnAction(new SampleEventHandler());
      bt2.setOnAction(new SampleEventHandler());

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
         try{
            if(e.getSource() == bt1){
               Pattern pn = Pattern.compile(tf.getText());
               mt = pn.matcher(ta.getText());
               if(mt.find() != false){
                  ta.selectRange(mt.start(), mt.end());
               }
               else{
                  ta.home();
               }
            }
            else if(e.getSource() == bt2){
               if(mt.find() != false && mt.pattern().pattern()
               	                            .equals(tf.getText())){
                  ta.selectRange(mt.start(), mt.end());
               }
            }
         }
         catch(Exception ex){
            ex.printStackTrace();
         }
      }
   }
}
