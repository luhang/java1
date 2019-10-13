import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;

public class Sample1 extends Application
{
   private Button[] bt = new Button[5];

   public static void main(String[] args)
   {
      launch(args);
   }
   public void start(Stage stage)throws Exception
   {
      //コントロールの作成
      bt[0] = new Button("Top");
      bt[1] = new Button("Bottom");
      bt[2] = new Button("Center");
      bt[3] = new Button("Left");
      bt[4] = new Button("Right");

      //ペインの作成
      BorderPane bp = new BorderPane();

      //ペインへの追加
      bp.setTop(bt[0]);
      bp.setBottom(bt[1]);
      bp.setCenter(bt[2]);
      bp.setLeft(bt[3]);
      bp.setRight(bt[4]);

      for(int i=0; i<bt.length; i++){
         bp.setAlignment(bt[i], Pos.CENTER);
      }

      //シーンの作成
      Scene sc = new Scene(bp, 300, 200);

      //ステージへの追加
      stage.setScene(sc);

      //ステージの表示
      stage.setTitle("サンプル");
      stage.show();
   }
}
