import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class Sample2 extends Application
{
   private Button bt;

   public static void main(String[] args)
   {
      launch(args);
   }
   public void start(Stage stage)throws Exception
   {
      //コントロールの作成
      bt = new Button();
      
      //コントロールの設定
      bt.setText("購入");
      
      //ペインの作成
      BorderPane bp = new BorderPane();

      //ペインへの追加
      bp.setCenter(bt);
      
      //シーンの作成
      Scene sc = new Scene(bp, 300, 200);
      
      //ステージへの追加
      stage.setScene(sc);

      //ステージの表示
      stage.setTitle("サンプル");
      stage.show();
   }
}
