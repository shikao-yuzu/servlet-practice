package bean;

public class Item implements java.io.Serializable
{
  private Product product;
  private int     count;

  public Product getProduct()
  {
    return this.product;
  }

  public int getCount()
  {
    return this.count;
  }

  public void setProduct(Product product)
  {
    this.product = product;
  }

  public void setCount(int count)
  {
    this.count = count;
  }
}
