import java.time.*;
import java.time.format.*;
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.input.*;
import javafx.scene.control.cell.*;
import javafx.collections.*;
import javafx.beans.value.*;
import javafx.beans.property.*;

public class Sample4 extends Application
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
      TableColumn<RowData, String> tc1 = new TableColumn<RowData, String>("���t");
      TableColumn<RowData, String> tc2 = new TableColumn<RowData, String>("�c��");

      tc1.setCellValueFactory(new PropertyValueFactory<RowData, String>("date"));
      tc2.setCellValueFactory(new PropertyValueFactory<RowData, String>("business"));

      ObservableList<RowData> ol = FXCollections.observableArrayList();
      for(int i=0; i<50; i++){
         ol.add(new RowData(i));
      }

      tv.getColumns().add(tc1);
      tv.getColumns().add(tc2);

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
      private final SimpleStringProperty date;
      private final SimpleStringProperty business;

      public RowData(int row)
      {
         DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy/MM/dd");
         LocalDateTime t = LocalDateTime.now();
         LocalDateTime d = t.plusDays(row);

         this.date = new SimpleStringProperty(df.format(d));

         if(d.getDayOfWeek() == DayOfWeek.SUNDAY)
            this.business = new SimpleStringProperty("�x�Ɠ��ł��B");
         else
            this.business = new SimpleStringProperty("�c�Ɠ��ł��B");

       }
       public StringProperty dateProperty(){return date;}
       public StringProperty businessProperty(){return business;}
   }
}
