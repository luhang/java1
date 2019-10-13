import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.input.*;
import javafx.event.*;
import javafx.collections.*;
import javafx.beans.value.*;

public class Sample2 extends Application
{
   private Label lb;
   private ListView<String> lv;

   public static void main(String[] args)
   {
      launch(args);
   }
   public void start(Stage stage)throws Exception
   {
      //コントロールの作成
      lb = new Label("いらっしゃいませ。");
      lv = new ListView<String>();

      //コントロールの設定
      ObservableList<String> ol = 
         FXCollections.observableArrayList
                     ("乗用車", "トラック", "オープンカー",
                      "タクシー", "スポーツカー", "ミニカー",
                      "自転車", "三輪車", "バイク",
                      "飛行機", "ヘリコプター", "ロケット");
      lv.setItems(ol);

      //ペインの作成
      BorderPane bp = new BorderPane();

      //ペインへの追加
      bp.setTop(lb);
      bp.setCenter(lv);
      
      //イベントハンドラの登録
      lv.getSelectionModel().selectedItemProperty()
           .addListener(new SampleChangeListener());

      //シーンの作成
      Scene sc = new Scene(bp, 300, 200);
      
      //ステージへの追加
      stage.setScene(sc);

      //ステージの表示
      stage.setTitle("サンプル");
      stage.show();
   }

   //イベントハンドラクラス
   class SampleChangeListener implements ChangeListener<String>
   {
      public void changed(ObservableValue ob, String bs, String as)
      {
         lb.setText(as + "ですね。");
      }
   }
}
