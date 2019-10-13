import java.io.*;
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.event.*;
import javafx.collections.*;

public class Sample10 extends Application
{
   private ListView<String> lv;
   private Button bt;
   private ObservableList<String> ol;

   public static void main(String[] args)
   {
      launch(args);
   }
   public void start(Stage stage)throws Exception
   {
      //�R���g���[���̍쐬
      File fl = new File(".");
      File[] fls = fl.listFiles(new SampleFileFilter());
      String[] st = new String[fls.length];
      for(int i=0; i<fls.length; i++){
         st[i] = fls[i].getName();
      }
      ol = FXCollections.observableArrayList(st);

      lv = new ListView<String>(ol);
      bt = new Button("�N��");

      //�y�C���̍쐬
      BorderPane bp = new BorderPane();

      //�y�C���ւ̒ǉ�
      bp.setCenter(lv);
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
         try{
            java.awt.Desktop dp = java.awt.Desktop.getDesktop();
            dp.open(new File(lv.getSelectionModel().getSelectedItem()));
         }
         catch(IOException ex){
            System.out.println("�N���ł��܂���ł����B");
         }
      }
   }

   //�t�B���^�N���X
   class SampleFileFilter implements FileFilter
   {
      public boolean accept(File f)
      {
         if(f.isFile()){
            return true;
         }
         return false;
      }
   }
}
