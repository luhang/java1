import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.input.*;
import javafx.scene.text.*;
import javafx.event.*;
import javafx.geometry.*;

public class SampleP3 extends Application
{
   private Label lb;
   private RadioButton rb1, rb2, rb3;
   private ToggleGroup tg;

   public static void main(String[] args)
   {
      launch(args);
   }
   public void start(Stage stage)throws Exception
   {
      //コントロールの作成
      lb  = new Label("Hello!");
      lb.setFont(Font.font("Serif", FontWeight.NORMAL, 24));
      rb1 = new RadioButton("普通");
      rb2 = new RadioButton("太字");
      rb3 = new RadioButton("イタリック");
      tg  = new ToggleGroup();

      //トグルグループへの追加
      rb1.setToggleGroup(tg);
      rb2.setToggleGroup(tg);
      rb3.setToggleGroup(tg);
      
      rb1.setSelected(true);

      //ペインの作成
      BorderPane bp = new BorderPane();
      HBox hb = new HBox();

      //ペインへの追加
      hb.getChildren().add(rb1);
      hb.getChildren().add(rb2);
      hb.getChildren().add(rb3);
      hb.setAlignment(Pos.CENTER);

      bp.setTop(lb);
      bp.setCenter(hb);
      
      //イベントハンドラの登録
      rb1.setOnAction(new SampleEventHandler());
      rb2.setOnAction(new SampleEventHandler());
      rb3.setOnAction(new SampleEventHandler());

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
         RadioButton tmp = (RadioButton) e.getSource();
         if(tmp == rb1)
            lb.setFont(Font.font("Serif", FontWeight.NORMAL, 24));
         else if(tmp == rb2)
            lb.setFont(Font.font("Serif", FontWeight.BOLD, 24));
         else if(tmp == rb3)
            lb.setFont(Font.font("Serif", FontPosture.ITALIC, 24));
      }
   }
}
