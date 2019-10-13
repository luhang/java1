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

   private ArrayList<Shape> shapeList;    //�}�`���X�g
   private int currentShape;              //�I��}�`
   private Color currentColor;            //�I��F
   private double x1, x2, y1, y2;         //�`�撆�̍��W

   public static void main(String[] args)
   {
      launch(args);
   }
   public void start(Stage stage)throws Exception
   {
      //�R���g���[���̍쐬�E�ݒ�
      cv = new Canvas(600, 340);
      mb = new MenuBar();
      cp = new ColorPicker();
      tb = new ToolBar();

      mn[0] = new Menu("�t�@�C��");
      mn[1] = new Menu("�ݒ�");
      mn[2] = new Menu("�}�`");

      mi[0] = new MenuItem("�J��");
      mi[1] = new MenuItem("�ۑ�");

      rmi[0] = new RadioMenuItem("�l�p�`");
      rmi[1] = new RadioMenuItem("�ȉ~");
      rmi[2] = new RadioMenuItem("����");

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

      //�y�C���̍쐬
      BorderPane bp = new BorderPane();

      //�y�C���ւ̒ǉ�
      bp.setTop(mb);
      bp.setCenter(cv);
      bp.setBottom(tb);
      
      //�C�x���g�n���h���̓o�^
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

      //������������
      shapeList = new ArrayList<Shape>();
      currentShape = Shape.RECT;
      currentColor = Color.BLUE;
      cp.setValue(currentColor);
      rmi[0].setSelected(true);
      x1=-1; y1=-1; x2=-1; y2=-1;

      //�V�[���̍쐬
      Scene sc = new Scene(bp, 600, 400);

      //�X�e�[�W�ւ̒ǉ�
      stage.setScene(sc);

      //�X�e�[�W�̕\��
      stage.setTitle("�T���v��");
      stage.show();
   }

   //�C�x���g�n���h���N���X
   class SampleEventHandler implements EventHandler<ActionEvent>
   {
      public void handle(ActionEvent e)
      {
         if(e.getSource() == mi[0]){
            try{
               FileChooser fc = new FileChooser();
              fc.getExtensionFilters().add(
                 new FileChooser.ExtensionFilter("�O���t�B�b�N�t�@�C��", "*.g"));
               File flo = fc.showOpenDialog(new Stage());
               if(flo != null){
                  //�t�@�C����ǂݍ���
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
               //�}�`�I�u�W�F�N�g�����X�g������o��
               Shape  sh = (Shape) shapeList.get(i);
               //�}�`�I�u�W�F�N�g���g�ɂ���ĕ`�悷��
               sh.draw(gc);
            }
         }
         else if(e.getSource() == mi[1]){ 
            try{
              FileChooser fc = new FileChooser();
              fc.getExtensionFilters().add(
                 new FileChooser.ExtensionFilter("�O���t�B�b�N�t�@�C��", "*.g"));
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
         //�l�p�`�ɐݒ肷��
         else if(e.getSource() == rmi[0]){
            currentShape = Shape.RECT;
         }
         //�ȉ~�ɐݒ肷��
         else if(e.getSource() == rmi[1]){
            currentShape = Shape.OVAL;
         }
         //�����ɐݒ肷��
         else if(e.getSource() == rmi[2]){
            currentShape = Shape.LINE;
         }
         //�F�̑I����ʂ�\������
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
            //�`�撆�̍��W���L�^����
            x1 = e.getX();
            y1 = e.getY();
         }
         else if(e.getEventType() == MouseEvent.MOUSE_RELEASED){
            x2 = e.getX(); y2 = e.getY();
            //�}�`���쐬���Ȃ��Ƃ�
            if(x1 < 0  || y1 < 0 || (x1 == x2 && y1 == y2))
               return;
            //�}�`�I�u�W�F�N�g���쐬����
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
            //�}�`�I�u�W�F�N�g�̐F��ݒ肷��
            double r = currentColor.getRed();
            double g = currentColor.getGreen();
            double b = currentColor.getBlue();
            sh.setColor(r, g, b);

            //�}�`�I�u�W�F�N�g�̍��W��ݒ肷��
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

            //�}�`�I�u�W�F�N�g�����X�g�����ɒǉ�����
            shapeList.add(sh);

            //�}�`��`�悷��
            GraphicsContext gc = cv.getGraphicsContext2D();
            sh.draw(gc);
         }
      }
   }
}
