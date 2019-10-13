import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.input.*;
import javafx.event.*;

public class SampleP2 extends Application
{
   private Button bt;

   public static void main(String[] args)
   {
      launch(args);
   }
   public void start(Stage stage)throws Exception
   {
      //コントロールの作成
      bt = new Button("ようこそ。");

      //ペインの作成
      BorderPane bp = new BorderPane();

      //ペインへの追加
      bp.setCenter(bt);

      //イベントハンドラの登録
      bt.addEventHandler(MouseEvent.MOUSE_ENTERED, new SampleEventHandler());
      bt.addEventHandler(MouseEvent.MOUSE_EXITED, new SampleEventHandler());

      //シーンの作成
      Scene sc = new Scene(bp, 300, 200);

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
            bt.setText("いらっしゃいませ。");
         }
         else if(e.getEventType() == MouseEvent.MOUSE_EXITED){
            bt.setText("ようこそ。");
         }
      }
   }
}
