import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.input.*;
import javafx.event.*;

public class Sample6 extends Application
{
   private Label lb;

   public static void main(String[] args)
   {
      launch(args);
   }
   public void start(Stage stage)throws Exception
   {
      //コントロールの作成
      lb = new Label("いらっしゃいませ。");
      
      //ペインの作成
      BorderPane bp = new BorderPane();

      //ペインへの追加
      bp.setTop(lb);

      //シーンの作成
      Scene sc = new Scene(bp, 300, 200);
      
      //イベントハンドラの登録
      sc.addEventHandler(MouseEvent.MOUSE_ENTERED, new SampleEventHandler());
      sc.addEventHandler(MouseEvent.MOUSE_EXITED, new SampleEventHandler());

      //ステージへの追加
      stage.setScene(sc);

      //ステージの表示
      stage.setTitle("サンプル");
      stage.show();
   }

   //イベントハンドラクラス
   class SampleEventHandler implements EventHandler<MouseEvent>
   {
      public void handle(MouseEvent e)
      {
         if(e.getEventType() == MouseEvent.MOUSE_ENTERED){
            lb.setText("いらっしゃいませ。");
         }
         else if(e.getEventType() == MouseEvent.MOUSE_EXITED)
         {
            lb.setText("ようこそ。");
         }
      }
   }
}
