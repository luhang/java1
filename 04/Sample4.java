import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;

public class Sample4 extends Application
{
   private Label[] lb = new Label[5];
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
      for(int i=0; i<lb.length; i++){
         lb[i] = new Label(Integer.toString(i));
      }

      //ペインの作成
      BorderPane bp = new BorderPane();
      HBox hb = new HBox();
      VBox vb = new VBox();

      //ペインへの追加
      for(int i=0; i<bt.length; i++){
         hb.getChildren().add(bt[i]);
      }
      for(int i=0; i<lb.length; i++){
         vb.getChildren().add(lb[i]);
      }

      hb.setAlignment(Pos.CENTER);
      vb.setAlignment(Pos.CENTER);

      bp.setTop(hb);
      bp.setCenter(vb);

      //シーンの作成
      Scene sc = new Scene(bp, 300, 200);
      
      //ステージへの追加
      stage.setScene(sc);

      //ステージの表示
      stage.setTitle("サンプル");
      stage.show();
   }
}
