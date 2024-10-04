/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author ADMIN
 */
@WebServlet(urlPatterns = {"/oregaction"})
public class oregaction extends HttpServlet {

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
       List<String> ms = new ArrayList<String>();
        PrintWriter out = response.getWriter();
        ServletContext sc=request.getSession().getServletContext();
	        String finalimage = "";
	        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
	        List<String> m = new ArrayList<String>();
	        File savedFile;
	       
	        if (!isMultipart) 
	        {
	        	
	            System.out.println("File Not Uploaded");
	        } 
	        else 
	        {
	            FileItemFactory factory = new DiskFileItemFactory();
	            ServletFileUpload upload = new ServletFileUpload(factory);
	            List items = null;

	            try 
	            {
	                items = upload.parseRequest(request);
	                
	            } 
	           	catch (FileUploadException e)
	           	{
	                e.printStackTrace();
	            }
	            Iterator itr = items.iterator();
	            while (itr.hasNext()) {
	                List<String> al = new ArrayList<String>();

	                String sss = "";
	                FileItem item = (FileItem) itr.next();
	                String value = "";
	                String a[];
	                if (item.isFormField()) 
	                {
	                    String name = item.getFieldName();
	                    value = item.getString();
	                    al.add(value);
	                    for (int i = 0; i < al.size(); i++) 
	                    {
	                        sss += al.get(i);
	                        System.out.println("is this image" + sss);  
	                    }

	                    a = sss.split("-");
	                    for (int i = 0; i < a.length; i++) {

	                        String am = a[i];
	                        System.out.println("aaaaaaaaaaaaaaaa" + a[i]);
	                        m.add(a[i]);
	                    }
	                } 
	                else
	                {
	                	String itemName = item.getName();
	                

	                    String reg = "[.*]";
	                    String replacingtext = "";
	                    
	                    Pattern pattern = Pattern.compile(reg);
	                    Matcher matcher = pattern.matcher(itemName);
	                    StringBuffer buffer = new StringBuffer();

	                    while (matcher.find()) 
	                    {
	                        matcher.appendReplacement(buffer, replacingtext);
	                    }
	                    int IndexOf = itemName.indexOf(".");
	                    int Indexf = itemName.indexOf(".");
	                    String domainName = itemName.substring(IndexOf);


	                    finalimage = buffer.toString() + domainName;
	                    System.out.println("Final Image===" + finalimage);
	                    ms.add(finalimage);
	                    ms.get(0);
	                  String  fn=ms.get(0);
	                  System.out.println("trying to put all in store");
	                   savedFile = new File(sc.getRealPath("profile")+"\\"+finalimage);
	                try 
	                    {
                                item.write(savedFile);
                            }
                            catch(Exception e){
                                
                            }
                        }
	            }
	        
	        }
		try 
		{   
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con=DriverManager.getConnection("jdbc:mysql://localhost/Proxy","root","root");    
                    PreparedStatement ps=con.prepareStatement("insert into oreg(profile,id,user,pass,email,dob,gender,mobile,location)values('"+ms.get(0)+"','"+m.get(0)+"','"+m.get(1)+"','"+m.get(2)+"','"+m.get(3)+"','"+m.get(4)+"','"+m.get(5)+"','"+m.get(6)+"','"+m.get(7)+"')");
                    System.out.println(ps);
                    ps.executeUpdate();
                    System.out.println(ps);
                    out.println("<script>"); 			
                    out.println("alert(\"Data Owner Register Succesfully\")");
                    out.println("</script>");

                    RequestDispatcher rd=request.getRequestDispatcher("owner.jsp");
                    rd.include(request,response);		
		}
                catch(Exception e){
                    out.println("<script>"); 			
                    out.println("alert(\"Please Try Again..\")");
                    out.println("</script>");

                    RequestDispatcher rd=request.getRequestDispatcher("oreg.jsp");
                    rd.include(request,response);
                }
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
