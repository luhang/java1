import java.util.*;
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.control.cell.*;
import javafx.collections.*;
import javafx.beans.value.*;
import javafx.beans.property.*;

public class Sample3 extends Application
{
   private Label lb;
   private TableView<RowData> tv;

   public static void main(String[] args)
   {
      launch(args);
   }
   public void start(Stage stage)throws Exception
   {
      //�R���g���[���̍쐬
      lb = new Label("��������Ⴂ�܂��B");
      tv = new TableView<RowData>();
      
      //�R���g���[���̐ݒ�
      TableColumn<RowData, String> tc1 = new TableColumn<RowData, String>("�Ԗ�");
      TableColumn<RowData, String> tc2 = new TableColumn<RowData, String>("���i");
      TableColumn<RowData, String> tc3 = new TableColumn<RowData, String>("����");

      tc1.setCellValueFactory(new PropertyValueFactory<RowData, String>("name"));
      tc2.setCellValueFactory(new PropertyValueFactory<RowData, String>("price"));
      tc3.setCellValueFactory(new PropertyValueFactory<RowData, String>("date"));

      ObservableList<RowData> ol = FXCollections.observableArrayList();
      ol.add(new RowData("��p��", 1200,"10-01"));
      ol.add(new RowData("�g���b�N", 2400,"10-05"));
      ol.add(new RowData("�I�[�v���J�[", 3600,"10-06"));
      ol.add(new RowData("�^�N�V�[", 2500,"10-10"));
      ol.add(new RowData("�X�|�[�c�J�[", 2600,"10-11"));
      ol.add(new RowData("�~�j�J�[", 300,"10-12"));
      ol.add(new RowData("���]��", 800,"10-15"));
      ol.add(new RowData("�O�֎�", 600,"10-18"));
      ol.add(new RowData("��s�@", 15000,"10-19"));
      ol.add(new RowData("��p��", 1200,"10-01"));
      ol.add(new RowData("�w���R�v�^�[", 3500,"10-21"));

      tv.getColumns().add(tc1);
      tv.getColumns().add(tc2);
      tv.getColumns().add(tc3);

      tv.setItems(ol);

      //�y�C���̍쐬
      BorderPane bp = new BorderPane();

      //�y�C���ւ̒ǉ�
      bp.setTop(lb);
      bp.setCenter(tv);

      //�V�[���̍쐬
      Scene sc = new Scene(bp, 300, 200);

      //�X�e�[�W�ւ̒ǉ�
      stage.setScene(sc);

      //�X�e�[�W�̕\��
      stage.setTitle("�T���v��");
      stage.show();
   }

   public class RowData
   {
      private final SimpleStringProperty name;
      private final SimpleIntegerProperty price;
      private final SimpleStringProperty date;

      public RowData(String n, Integer p, String d)
      {
         this.name = new SimpleStringProperty(n);
         this.price = new SimpleIntegerProperty(p);
         this.date = new SimpleStringProperty(d);
      }
       public StringProperty nameProperty(){return name;}
       public IntegerProperty priceProperty(){return price;}
       public StringProperty dateProperty(){return date;}
   }
}
