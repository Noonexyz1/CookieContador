
package com.emergentes;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ContadorServlet", urlPatterns = {"/ContadorServlet"})
public class ContadorServlet extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int contador = 0;
        
        //recuperamos las coockies
        Cookie[] cukis = request.getCookies();
        if (cukis != null) {
            //recorremos las cukies para buscar la cookie que queramos
            for(Cookie c : cukis){
                if (c.getName().equals("visitas")) {
                    contador = Integer.parseInt(c.getValue());
                    
                    
                }
                
            }
            
            
        }
        
        //HACER el CARRITO DEL VIDEO
        
        
        
        contador++;
        
        //guardar en el navegador
        Cookie c = new Cookie("visitas",  Integer.toString(contador));
        c.setMaxAge(60);
        
        response.addCookie(c);
        
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("Visita nro: " + contador);
        
        
    }
   
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
}
