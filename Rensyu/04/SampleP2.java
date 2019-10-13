import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.input.*;
import javafx.event.*;
import javafx.scene.image.*;

public class SampleP2 extends Application
{
   private Label lb;
   private CheckBox ch;
   private Image im;
   private ImageView iv;

   public static void main(String[] args)
   {
      launch(args);
   }
   public void start(Stage stage)throws Exception
   {
      //コントロールの作成
      lb = new Label("車です。");
      ch = new CheckBox("画像の表示");
            
      im = new Image(getClass().getResourceAsStream("car.jpg"));
      iv = new ImageView(im);
     
      //ペインの作成
      BorderPane bp = new BorderPane();

      //ペインへの追加
      bp.setCenter(lb);
      bp.setBottom(ch);
      
      //イベントハンドラの登録
      ch.setOnAction(new SampleEventHandler());

      //シーンの作成
      Scene sc = new Scene(bp, 300, 200);
      
      //ステージへの追加
      stage.setScene(sc);

      //ステージの表示
      stage.setTitle("サンプル");
      stage.show();
   }
   //イベントハンドラクラス
   class SampleEventHandler implements EventHandler<ActionEvent>
   {
      public void handle(ActionEvent e)
      {
         CheckBox tmp = (CheckBox)e.getSource();
         if(tmp.isSelected() == true){
            lb.setGraphic(iv);
         }
         else if(tmp.isSelected() == false){
            lb.setGraphic(null);;
         }
      }
   }
}
