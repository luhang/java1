import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class Sample1 extends Application
{
   private Label lb;

   public static void main(String[] args)
   {
      launch(args);
   }
   public void start(Stage stage)throws Exception
   {
      //�R���g���[���̍쐬
      lb = new Label();
      
      //�R���g���[���̐ݒ�
      lb.setText("��������Ⴂ�܂��B");
      
      //�y�C���̍쐬
      BorderPane bp = new BorderPane();  

      //�y�C���ւ̒ǉ�
      bp.setCenter(lb);
      
      //�V�[���̍쐬
      Scene sc = new Scene(bp, 300, 200);
      
      //�X�e�[�W�ւ̒ǉ�
      stage.setScene(sc);

      //�X�e�[�W�̕\��
      stage.setTitle("�T���v��");
      stage.show();
   }
}
