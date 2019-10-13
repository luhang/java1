import java.time.*;
import java.time.format.*;
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.input.*;
import javafx.event.*;
import javafx.collections.*;
import javafx.beans.value.*;

public class SampleP1 extends Application
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
      ObservableList<String> ol = FXCollections.observableArrayList();

      DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy/MM/dd");
      LocalDateTime t = LocalDateTime.now();

      for(int i=0; i<50; i++){
         ol.add(df.format(t.plusDays(i)));
      }

      lv.setItems(ol);

      //ペインの作成
      BorderPane bp = new BorderPane();

      //ペインへの追加
      bp.setTop(lb);
      bp.setCenter(lv);
      
      //イベントハンドラの登録
     lv.getSelectionModel().selectedItemProperty().addListener(new SampleChangeListener());

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
