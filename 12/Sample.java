import java.io.*;
import java.util.*;
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.input.*;
import javafx.scene.paint.*;
import javafx.scene.canvas.*;
import javafx.event.*;

public class Sample extends Application
{
   private MenuBar mb;
   private Menu[] mn = new Menu[3];
   private MenuItem[] mi = new MenuItem[2];
   private RadioMenuItem[] rmi = new RadioMenuItem[3];
   private ToggleGroup tg;
   private ColorPicker cp;
   private Canvas cv;
   private ToolBar tb;

   private ArrayList<Shape> shapeList;    //図形リスト
   private int currentShape;              //選択図形
   private Color currentColor;            //選択色
   private double x1, x2, y1, y2;         //描画中の座標

   public static void main(String[] args)
   {
      launch(args);
   }
   public void start(Stage stage)throws Exception
   {
      //コントロールの作成・設定
      cv = new Canvas(600, 340);
      mb = new MenuBar();
      cp = new ColorPicker();
      tb = new ToolBar();

      mn[0] = new Menu("ファイル");
      mn[1] = new Menu("設定");
      mn[2] = new Menu("図形");

      mi[0] = new MenuItem("開く");
      mi[1] = new MenuItem("保存");

      rmi[0] = new RadioMenuItem("四角形");
      rmi[1] = new RadioMenuItem("楕円");
      rmi[2] = new RadioMenuItem("直線");

      mn[0].getItems().add(mi[0]);
      mn[0].getItems().add(mi[1]);

      mn[1].getItems().add(mn[2]);

      mn[2].getItems().add(rmi[0]);
      mn[2].getItems().add(rmi[1]);
      mn[2].getItems().add(rmi[2]);

      mb.getMenus().add(mn[0]);
      mb.getMenus().add(mn[1]);

      tb.getItems().add(cp);

      tg  = new ToggleGroup();
      rmi[0].setToggleGroup(tg);
      rmi[1].setToggleGroup(tg);
      rmi[2].setToggleGroup(tg);

      //ペインの作成
      BorderPane bp = new BorderPane();

      //ペインへの追加
      bp.setTop(mb);
      bp.setCenter(cv);
      bp.setBottom(tb);
      
      //イベントハンドラの登録
       for(int i=0; i<mi.length; i++)
      {
         mi[i].setOnAction(new SampleEventHandler()); 
      }
       for(int i=0; i<rmi.length; i++)
      {
         rmi[i].setOnAction(new SampleEventHandler()); 
      }
      cp.setOnAction(new SampleEventHandler());

      cv.addEventHandler(MouseEvent.MOUSE_PRESSED, 
         (new SampleMouseEventHandler())); 
      cv.addEventHandler(MouseEvent.MOUSE_RELEASED, 
         (new SampleMouseEventHandler())); 

      //初期化をする
      shapeList = new ArrayList<Shape>();
      currentShape = Shape.RECT;
      currentColor = Color.BLUE;
      cp.setValue(currentColor);
      rmi[0].setSelected(true);
      x1=-1; y1=-1; x2=-1; y2=-1;

      //シーンの作成
      Scene sc = new Scene(bp, 600, 400);

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
         if(e.getSource() == mi[0]){
            try{
               FileChooser fc = new FileChooser();
              fc.getExtensionFilters().add(
                 new FileChooser.ExtensionFilter("グラフィックファイル", "*.g"));
               File flo = fc.showOpenDialog(new Stage());
               if(flo != null){
                  //ファイルを読み込む
                  ObjectInputStream oi 
                     = new ObjectInputStream(new FileInputStream(flo));
                  Shape tmp = null;
                  shapeList.clear();
                  while((tmp = (Shape)oi.readObject()) != null){
                     shapeList.add(tmp);
                  }
                  oi.close();
               }
            }
            catch(Exception ex){
               ex.printStackTrace();
            }
            GraphicsContext gc = cv.getGraphicsContext2D();
            gc.clearRect(0, 0, 600, 340);
            for(int i=0; i < shapeList.size(); i++){
               //図形オブジェクトをリストから取り出す
               Shape  sh = (Shape) shapeList.get(i);
               //図形オブジェクト自身によって描画する
               sh.draw(gc);
            }
         }
         else if(e.getSource() == mi[1]){ 
            try{
              FileChooser fc = new FileChooser();
              fc.getExtensionFilters().add(
                 new FileChooser.ExtensionFilter("グラフィックファイル", "*.g"));
              File fls = fc.showSaveDialog(new Stage());
               if(fls != null){
                  ObjectOutputStream oo 
                     = new ObjectOutputStream(new FileOutputStream(fls));
                  for(int i=0; i<shapeList.size(); i++){ 
                     oo.writeObject(shapeList.get(i));
                  }
                  oo.writeObject(null);
                  oo.close();
               }
            }
            catch(Exception ex){
               ex.printStackTrace();
            }
        }
         //四角形に設定する
         else if(e.getSource() == rmi[0]){
            currentShape = Shape.RECT;
         }
         //楕円に設定する
         else if(e.getSource() == rmi[1]){
            currentShape = Shape.OVAL;
         }
         //直線に設定する
         else if(e.getSource() == rmi[2]){
            currentShape = Shape.LINE;
         }
         //色の選択画面を表示する
         else if(e.getSource() == cp){
            currentColor = cp.getValue();
         }
      }
   }
   class SampleMouseEventHandler implements EventHandler<MouseEvent>
   {
      public void handle(MouseEvent e)
      {
         if(e.getEventType() == MouseEvent.MOUSE_PRESSED){
            //描画中の座標を記録する
            x1 = e.getX();
            y1 = e.getY();
         }
         else if(e.getEventType() == MouseEvent.MOUSE_RELEASED){
            x2 = e.getX(); y2 = e.getY();
            //図形を作成しないとき
            if(x1 < 0  || y1 < 0 || (x1 == x2 && y1 == y2))
               return;
            //図形オブジェクトを作成する
            Shape sh = null;
            if(currentShape == Shape.RECT){
                sh = new Rect();
            }
            else if(currentShape == Shape.OVAL){
                sh = new Oval();
            }
            else if(currentShape == Shape.LINE){
                sh = new Line();
            }
            //図形オブジェクトの色を設定する
            double r = currentColor.getRed();
            double g = currentColor.getGreen();
            double b = currentColor.getBlue();
            sh.setColor(r, g, b);

            //図形オブジェクトの座標を設定する
             if(currentShape != Shape.LINE){
               if(x1 > x2){
                  x2 = x1;
                  x1 = e.getX();
               }
               if(y1 > y2){
                  y2 = y1;
                  y1 = e.getY();
               }
            }
            sh.setStartPoint(x1, y1);
            sh.setEndPoint(x2, y2);

            //図形オブジェクトをリスト末尾に追加する
            shapeList.add(sh);

            //図形を描画する
            GraphicsContext gc = cv.getGraphicsContext2D();
            sh.draw(gc);
         }
      }
   }
}
