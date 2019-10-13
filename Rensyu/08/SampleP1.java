import java.sql.*;

public class SampleP1
{
   public static void main(String[] args)
   {
      try{
         //接続の準備
         String url = "jdbc:derby:fooddb;create=true";
         String usr = "";
         String pw = "";

         //データベースへの接続
         Connection cn = DriverManager.getConnection(url, usr, pw);

         //問い合わせの準備
         DatabaseMetaData dm = cn.getMetaData();
         ResultSet tb = dm.getTables(null, null, "果物表", null);

         Statement st = cn.createStatement();

         String qry1 = "CREATE TABLE 果物表(番号 int, 名前 varchar(50), 取扱店 varchar(50))";
         String[] qry2 = {"INSERT INTO 果物表 VALUES (1,'みかん','青山商店')",
                          "INSERT INTO 果物表 VALUES (2,'りんご','東京市場')",
                          "INSERT INTO 果物表 VALUES (3,'バナナ','鈴木貨物')",
                          "INSERT INTO 果物表 VALUES (4,'いちご','東京市場')",
                          "INSERT INTO 果物表 VALUES (5,'なし','青山商店')",
                          "INSERT INTO 果物表 VALUES (6,'栗','横浜デパート')",
                          "INSERT INTO 果物表 VALUES (7,'モモ','横浜デパート')",
                          "INSERT INTO 果物表 VALUES (8,'びわ','佐藤商店')",
                          "INSERT INTO 果物表 VALUES (9,'柿','青山商店')",
                          "INSERT INTO 果物表 VALUES (10,'スイカ','東京市場')"};
         String qry3 = "SELECT * FROM 果物表";

         if(!tb.next()){
            st.executeUpdate(qry1);
            for(int i=0; i<qry2.length; i++){
               st.executeUpdate(qry2[i]);
            }
         }

         //問い合わせ
         ResultSet rs = st.executeQuery(qry3);

         //データの取得
         ResultSetMetaData rm = rs.getMetaData();
         int cnum = rm.getColumnCount();
         while(rs.next()){
            for(int i=1; i<=cnum; i++){
                System.out.print(rm.getColumnName(i) +  ":"+ rs.getObject(i) + "  ");
            }
            System.out.println("");
         }

         //接続のクローズ
         rs.close();
         st.close();
         cn.close();
      }
      catch(Exception e){
         e.printStackTrace();
      }
   }
}