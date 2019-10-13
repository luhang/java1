import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.input.*;
import javafx.event.*;
import javafx.collections.*;
import javafx.beans.value.*;

public class Sample1 extends Application
{
   private Label lb;
   private ComboBox<String> cb;
   private ObservableList<String> ol;

   public static void main(String[] args)
   {
      launch(args);
   }
   public void start(Stage stage)throws Exception
   {
      //コントロールの作成
      lb = new Label("いらっしゃいませ。");
      cb = new ComboBox<String>();
      
      //コントロールの設定
      ObservableList<String> ol = 
         FXCollections.observableArrayList("乗用車", "トラック", "オープンカー",
                                           "タクシー", "スポーツカー", "ミニカー");
      cb.setItems(ol);

      //ペインの作成
      BorderPane bp = new BorderPane();

      //ペインへの追加
      bp.setTop(lb);
      bp.setCenter(cb);

      //イベントハンドラの登録
      cb.setOnAction(new SampleEventHandler());

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
         ComboBox tmp = (ComboBox) e.getSource();
         String str = tmp.getValue().toString();
         lb.setText(str + "ですね。");
      }
   }
}
