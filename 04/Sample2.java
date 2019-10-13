import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class Sample2 extends Application
{
   private Button[] bt = new Button[10];

   public static void main(String[] args)
   {
      launch(args);
   }
   public void start(Stage stage)throws Exception
   {
      //コントロールの作成
      for(int i=0; i<bt.length; i++){
         bt[i] = new Button(Integer.toString(i));
      }

      //ペインの作成
      FlowPane fp = new FlowPane();

      //ペインへの追加
      for(int i=0; i<bt.length; i++){
         fp.getChildren().add(bt[i]);
      }

      //シーンの作成
      Scene sc = new Scene(fp, 300, 100);

      //ステージへの追加
      stage.setScene(sc);

      //ステージの表示
      stage.setTitle("サンプル");
      stage.show();
   }
}
