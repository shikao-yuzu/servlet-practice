package chapter17;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Product;
import tool.Page;

public class CartAdd extends HttpServlet
{
  @SuppressWarnings("unchecked")
  public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    PrintWriter out = response.getWriter();

    Page.header(out);

    // POSTリクエストパラメータの取得
    String name  = request.getParameter("name");
    int    price = Integer.parseInt(request.getParameter("price"));

    // セッションの開始/取得
    HttpSession session = request.getSession();

    // セッション属性の取得
    List<Product> cart = (List<Product>)session.getAttribute("cart");

    if (cart == null) cart = new ArrayList<Product>();

    Product p = new Product();
    p.setName(name);
    p.setPrice(price);
    cart.add(p);

    // セッション属性の保存
    session.setAttribute("cart", cart);

    out.println("カートに商品を追加しました");
    Page.footer(out);
  }
}