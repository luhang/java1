import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.input.*;
import javafx.event.*;

public class SampleP2 extends Application
{
   private Label lb;
   private Button bt;

   public static void main(String[] args)
   {
      launch(args);
   }
   public void start(Stage stage)throws Exception
   {
      //コントロールの作成
      lb = new Label("いらっしゃいませ。");
      bt = new Button("購入");
      
      //ペインの作成
      BorderPane bp = new BorderPane();

      //ペインへの追加
      bp.setTop(lb);
      bp.setCenter(bt);
      
      //イベントハンドラの登録
      bt.setOnAction(new SampleEventHandler());

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
         Alert al = new Alert(Alert.AlertType.INFORMATION);
         al.setTitle("購入"); 
         al.getDialogPane().setHeaderText("大変ありがとうございました。");
         al.show();
      }
   }
}
