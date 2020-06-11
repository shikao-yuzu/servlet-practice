package bean;

public class Customer implements java.io.Serializable
{
  private int    id;
  private String login;
  private String password;

  public int getId()
  {
    return this.id;
  }

  public String getLogin()
  {
    return this.login;
  }

  public String getPassword()
  {
    return this.password;
  }

  public void setId(int id)
  {
    this.id = id;
  }

  public void setLogin(String login)
  {
    this.login = login;
  }

  public void setPassword(String password)
  {
    this.password = password;
  }
}
