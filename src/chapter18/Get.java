package chapter18;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Page;

public class Get extends HttpServlet
{
  public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    PrintWriter out = response.getWriter();

    Page.header(out);

    Cookie[] cookies = request.getCookies();
    if (cookies != null)
    {
      for (Cookie cookie : cookies)
      {
        out.println("<p>"+cookie.getName()+" : "+cookie.getValue()+"</p>");
      }
    }

    Page.footer(out);
  }
}