/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URLEncoder;
import java.net.http.*;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;

/**
 *
 * @author Rifas
 */
public class dashboard extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet dashboard</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='alert alert-success' style='margin-left:5px;margin-right:5px;margin-top:10px;margin-bottom:0px;' role='alert'>Welcome, "+request.getParameter("Name")+"</div>");
            FileReader fr = new FileReader("D:\\Documents\\Java Projects\\Stock\\web\\landing.html");
             int i;    
            while((i=fr.read())!=-1)   
                out.print((char)i);    
            mukulNeedsData(response);
            out.println("</body>");
            out.println("</html>");
        } 
    catch(Exception e){
    
}
finally {
            out.close();
        }
    }

    public static void mukulNeedsData(HttpServletResponse res)
            throws ServletException, IOException{
        String host = "https://alphavantage.co";
    	String charset = "UTF-8";
    	// Headers for a request
        PrintWriter out = res.getWriter();
    	String x_rapidapi_host = "alphavantage.co";
    	String x_rapidapi_key = "MCAF9B429I44328U";//Type here your key
    	// Params
    	String s = "IBM";
  // Format query for preventing encoding problems
    	String query = String.format("s=%s", URLEncoder.encode(s, charset));
        HttpResponse <JsonNode> response = (HttpResponse <JsonNode>) Unirest.get(host + "?" + query)
    	.header("x-rapidapi-host", x_rapidapi_host)
    	.header("x-rapidapi-key", x_rapidapi_key)
    	.asJson();
  	/*out.println(response.getStatus());
    	out.println(response.getHeaders().get("Content-Type"));*/
        // Host, charset and headers vars should be the same
    	String i = "tt0110912";
  // Format query for preventing encoding problems
    	query = String.format("i=%s",URLEncoder.encode(i, charset));   	 
    	// Json response
    	response = (HttpResponse <JsonNode>) Unirest.get(host + "?" + query)
    	.header("x-api-host", x_rapidapi_host)
    	.header("x-api-key", x_rapidapi_key)
    	.asJson();
  //Prettifying
  out.print(response);
    /*	Gson gson = new GsonBuilder().setPrettyPrinting().create();
    	JsonParser jp = new JsonParser();
    	JsonElement je = jp.parse(response.body().toString());
    	String prettyJsonString = gson.toJson(je);
    	out.println(prettyJsonString);*/
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
