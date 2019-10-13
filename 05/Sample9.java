import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.canvas.*;

public class Sample9 extends Application
{
   private Canvas cv;

   public static void main(String[] args)
   {
      launch(args);
   }
   public void start(Stage stage)throws Exception
   {
      //コントロールの作成
      cv = new Canvas(300, 200);

      //コントロールの設定
      GraphicsContext gc = cv.getGraphicsContext2D();

      for(int i=0; i<100; i++){
         int r = (int) (Math.random() * 256);
         int g = (int) (Math.random() * 256);
         int b = (int) (Math.random() * 256);

         double x = Math.random() * 300;
         double y = Math.random() * 200;

         gc.setFill(Color.rgb(r, g, b, 1.0));
         gc.fillOval(x, y, 10, 10);   
      }

      //ペインの作成
      BorderPane bp = new BorderPane();

      //ペインへの追加
      bp.setCenter(cv);
      
      //シーンの作成
      Scene sc = new Scene(bp, 300, 200);
      
      //ステージへの追加
      stage.setScene(sc);

      //ステージの表示
      stage.setTitle("サンプル");
      stage.show();
   }
}
