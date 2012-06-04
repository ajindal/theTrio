package kidgames.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import kidgames.handlers.LevelHandler;

public class LevelServlet extends HttpServlet {

    void handleRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws Exception {
    	
    	String method = request.getMethod();
    	System.out.println("HTTP method: " + method);
    	
    	LevelHandler handler = new LevelHandler();
    	JSONObject returnValue = new JSONObject();
    	if(method != null && method.equals("GET"))
    	{
    		returnValue= handler.doGet(request, response);
    	}
    	if(method != null && method.equals("PUT"))
    	{
    		returnValue = handler.doPut(request, response);
    	}
    	if(method != null && method.equals("POST"))
    	{
    		handler.doPost(request, response);
    	}
    	if(method != null && method.equals("DELETE"))
    	{
    		handler.doDelete(request, response);
    	}
    	
    	response.setContentType("application/json");
    	PrintWriter out = response.getWriter();
    	out.print(returnValue);
    	
    }
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	try {
			handleRequest(request,
			        response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
    }
    
    @Override
    public void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	try {
			handleRequest(request,
			        response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	try {
			handleRequest(request,
			        response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
    }
    
    @Override
    public void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	try {
			handleRequest(request,
			        response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
    }
    
}
