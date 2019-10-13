import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.input.*;
import javafx.event.*;
import javafx.scene.image.*;

public class Sample6 extends Application
{
   private Label lb;
   private Button[] bt = new Button[3];
   private ToolBar tb;
   private Image im;

   public static void main(String[] args)
   {
      launch(args);
   }
   public void start(Stage stage)throws Exception
   {
      //コントロールの作成
      lb = new Label("いらっしゃいませ。");
      tb = new ToolBar();
      im = new Image(getClass().getResourceAsStream("car.jpg"));

      for(int i=0; i<bt.length; i++){
         bt[i] = new Button(); 
         bt[i].setGraphic(new ImageView(im));
     }

      //コントロールの設定
      for(int i=0; i<bt.length; i++){
         bt[i].setTooltip(new Tooltip((i+1) + "号車")); 
      }

      //ツールバーへの追加
      tb.getItems().addAll(bt[0], bt[1], new Separator(), bt[2]);

      //ペインの作成
      BorderPane bp = new BorderPane();

      //ペインへの追加
      bp.setTop(tb);
      bp.setCenter(lb);

      //イベントハンドラの登録
      for(int i=0; i<bt.length; i++){
         bt[i].setOnAction(new SampleEventHandler()); 
      }

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
         int num = 0;
         Button tmp = (Button) e.getSource();

         if(tmp == bt[0])
             num = 1;
         else if(tmp == bt[1])
             num = 2;
         else if(tmp == bt[2])
             num = 3;

         lb.setText(num + "号車ですね。");
      }
   }
}
