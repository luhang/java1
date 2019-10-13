import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import javafx.scene.image.*;

public class Sample7 extends Application
{
   private Label[] lb = new Label[3];
   private Image im;

   public static void main(String[] args)
   {
      launch(args);
   }
   public void start(Stage stage)throws Exception
   {
      //コントロールの作成
      for(int i=0; i<lb.length; i++){ 
         lb[i] = new Label("車" + i + "はいかがですか？");
      }
      im = new Image(getClass().getResourceAsStream("car.jpg"));
     
      //コントロールの設定
      lb[0].setGraphic(new ImageView(im));
      lb[1].setGraphic(new ImageView(im));
      lb[1].setContentDisplay(ContentDisplay.RIGHT);
      lb[2].setBackground(new Background
                         (new BackgroundFill(Color.WHITE, null, null)));

      //ペインの作成
      BorderPane bp = new BorderPane();
      VBox vb = new VBox();

       //ペインへの追加
      for(int i=0; i<lb.length; i++){
         vb.getChildren().add(lb[i]);
      }
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
