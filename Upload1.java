/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import algo.CipherHelper;
import clo.SimpleFTPClient;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


/**
 *
 * @author ADMIN
 */
@WebServlet(urlPatterns = {"/Upload1"})
public class Upload1 extends HttpServlet {

  String fna="";
    String fdo="",content="";
     String b1,b2,b3;
    
    int hashh;
     static String wordcon="";

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, InterruptedException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session=request.getSession();
        hashh=0;
        long startTime = System.nanoTime();

        TimeUnit.SECONDS.sleep(5);

        // ... the code being measured ends ...

     List<String> ms = new ArrayList<String>();
        String finalimage = "";
        boolean isMultipart = ServletFileUpload.isMultipartContent(
                request);
        List<String> m = new ArrayList<String>();
        File savedFile;
        
        if (!isMultipart) {
           float dummy=(float)Math.log(0)+1;
           
        } else {
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            List items = null;

            try {
                items = upload.parseRequest(request);
                //System.out.println("items: "+items);
            } catch (FileUploadException e) {
                e.printStackTrace();
            }
            Iterator itr = items.iterator();
            while (itr.hasNext()) {
                List<String> al = new ArrayList<String>();

                String sss = "";
                FileItem item = (FileItem) itr.next();
                String value = "";
                String a[];
                if (item.isFormField()) {
                    String name = item.getFieldName();
                    //System.out.println("name: "+name+'\n');
                    value = item.getString();
                    // System.out.println("value: "+value);
                    al.add(value);
                    for (int i = 0; i < al.size(); i++) {
                        sss += al.get(i);
                        System.out.println("is thios image" + sss);

     //System.out.println("the value sixcwe"+m.size());
                    }

                    a = sss.split("-");
                    for (int i = 0; i < a.length; i++) 
                    {

                        String am = a[i];
                        System.out.println("aaaaaaaaaaaaaaaa" + a[i]);
                        m.add(a[i]);
                    }
                } else {
                    
                    String itemName = item.getName();

                    String reg = "[.*]";
                    String replacingtext = "";
                    Pattern pattern = Pattern.compile(reg);
                    Matcher matcher = pattern.matcher(itemName);
                    StringBuffer buffer = new StringBuffer();

                    while (matcher.find()) {
                        matcher.appendReplacement(buffer, replacingtext);
                    }
                    int IndexOf = itemName.indexOf(".");
                    int Indexf = itemName.indexOf(".");
                    String domainName = itemName.substring(IndexOf);
                    
                    finalimage = buffer.toString() + domainName;
                    
                    System.out.println("hi..... " +domainName);
                    System.out.println("Final Image===" + finalimage);
                    ms.add(finalimage);
                    fna=buffer.toString();
                    fdo=domainName;
                    savedFile = new File("C:\\files\\" + finalimage);
                    try 
	                    {
	                    	item.write(savedFile);	                    	
	                    	
                    CipherHelper c= new CipherHelper();
                     File path = new File("C:\\files\\" + finalimage);
                     File path1 = new File("C:\\files\\enc\\" + finalimage);
                     
                   		
                    BufferedReader br= null;
                    
                    String sCurrentLine;
                    StringBuilder b= new StringBuilder();       
                    StringBuilder bb= new StringBuilder(); 
                    br = new BufferedReader(new FileReader("C:\\files\\" + finalimage));
                    while ((sCurrentLine = br.readLine()) != null) 
                    {    
                         bb.append(sCurrentLine);
                         String myAppContext = sCurrentLine;
                    }
                    String rep = bb.toString().replaceAll("( )+", " ");
                    content=rep;
                    String enc=c.cipher(m.get(1),content);                      
                    String renc=c.cipher(m.get(1),enc);
                    PrintWriter writer = new PrintWriter("C:\\files\\enc\\"+finalimage, "UTF-8");
                    writer.println(enc);
                    writer.close(); 
                    PrintWriter writer1 = new PrintWriter("C:\\files\\enc\\renc\\"+finalimage, "UTF-8");
                    writer1.println(renc);
                    writer1.close(); 
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
                    try
                    {
                    SimpleFTPClient client=new SimpleFTPClient();
	                    	client.setHost("ftp.drivehq.com");
	                    	client.setUser("cvsathyavani1999@gmail.com");
	                    	client.setPassword("21011999sathyavani!@");
	                    	client.setRemoteFile(finalimage);
	                    	boolean log= client.connect(); 
	                    	if(log)
	                    	{  
	                	    try 
	                            {
	                            	System.out.println("this is log true block");
	                            	FileOutputStream fos = new FileOutputStream(new  File(item.getName()));
	                            	byte b[] = new byte[1024];
	                            	int c=0;
	                            	InputStream is = item.getInputStream();
	                            	while((c=is.read(b)) != 0)
	                            	{	
	                            		fos.write(b, 0, c);
	                            	}
	                            	fos.close();                	    	
	                            }
	                	    	catch(Exception e){
	                            System.out.println("this is log false block    "+e);
	                            }
	                         if (client.uploadFile(new File(item.getName())))
	                            {
	                                System.out.println("This is a true block");
	                                
	                            }
	                    	}
	                    } 
	                    catch (Exception e) 
	                    {
							e.printStackTrace();
						}
                    
                
            }
        }
        PreparedStatement ps,ps1; 
        System.out.println("completed.....");
	try {            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proxy","root","root");
            ps=con.prepareStatement("insert into upload (id,user,email,mobile,keyword,tkey,skey,file)values('" + m.get(0)+ "','" + m.get(1) + "','" + m.get(2) + "','" + m.get(3)+ "','" + m.get(4) + "','"+m.get(5)+"','"+m.get(6)+"','" + ms.get(0) + "')");
             System.out.println(ps);
             session.setAttribute("filename",ms.get(0));
           
            ps.executeUpdate();
            System.out.println(ps);
        content="";
        out.println("<script>"
				+"alert('File uploaded successfully')"
				+"</script>");
		RequestDispatcher rd=request.getRequestDispatcher("upload.jsp");
		rd.include(request, response); 
	}
	catch(Exception e){
            out.println("<script>"
				+"alert('Please Try Again')"
				+"</script>");
		RequestDispatcher rd=request.getRequestDispatcher("upload.jsp");
		rd.include(request, response); 
        }
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
      try {
          processRequest(request, response);
      } catch (InterruptedException ex) {
          Logger.getLogger(Upload1.class.getName()).log(Level.SEVERE, null, ex);
      }
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
      try {
          processRequest(request, response);
      } catch (InterruptedException ex) {
          Logger.getLogger(Upload1.class.getName()).log(Level.SEVERE, null, ex);
      }
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
