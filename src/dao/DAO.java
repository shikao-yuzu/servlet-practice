package dao;

import java.sql.Connection;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DAO
{
  public static DataSource ds;

  public Connection getConnection()
    throws Exception
  {
    if (ds == null)
    {
      // JNDIを用いてデータソースを取得
      InitialContext ic = new InitialContext();
      DAO.ds = (DataSource)ic.lookup("java:/comp/env/jdbc/book");
    }
    return ds.getConnection();
  }
}
