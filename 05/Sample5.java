import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.input.*;
import javafx.event.*;

public class Sample5 extends Application
{
   private Label lb;
   private MenuBar mb;
   private Menu[] mn = new Menu[4];
   private MenuItem[] mi = new MenuItem[7];

   public static void main(String[] args)
   {
      launch(args);
   }
   public void start(Stage stage)throws Exception
   {
      //�R���g���[���̍쐬
      lb = new Label("��������Ⴂ�܂��B");
      mb = new MenuBar();
      
      //�R���g���[���̐ݒ�
      mn[0] = new Menu("���C��1");
      mn[1] = new Menu("���C��2");
      mn[2] = new Menu("�T�u1");
      mn[3] = new Menu("�T�u2");

      mi[0] = new MenuItem("��p��");
      mi[1] = new MenuItem("�g���b�N");
      mi[2] = new MenuItem("�I�[�v���J�[");
      mi[3] = new MenuItem("�^�N�V�[");
      mi[4] = new MenuItem("�X�|�[�c�J�[");
      mi[5] = new MenuItem("�~�j�J�[");
      mi[6] = new SeparatorMenuItem();

      mn[0].getItems().addAll(mi[0], mi[1]);

      mn[2].getItems().addAll(mi[2], mi[3]);

      mn[3].getItems().addAll(mi[4], mi[5]);

      mn[1].getItems().addAll(mn[2]);
      mn[1].getItems().addAll(mi[6], mn[3]);

      mb.getMenus().addAll(mn[0], mn[1]);

      //�y�C���̍쐬
      BorderPane bp = new BorderPane();

      //�y�C���ւ̒ǉ�
      bp.setTop(mb);
      bp.setCenter(lb);

      //�C�x���g�n���h���̓o�^
       for(int i=0; i<mi.length; i++)
      {
         mi[i].setOnAction(new SampleEventHandler()); 
      }

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
         MenuItem tmp =(MenuItem) e.getSource();
         String str = tmp.getText();
         lb.setText(str + "�ł��ˁB");
      }
   }
}
