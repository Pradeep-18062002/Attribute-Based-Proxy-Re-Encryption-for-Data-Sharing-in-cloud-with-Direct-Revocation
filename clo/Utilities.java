package clo;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
/**
 *
 * @author sabari
 */

   public class Utilities {
    public static ResultSet executeSqlQuery(Connection conn,String sql) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            System.out.println(sql);
            pst = (PreparedStatement) conn.prepareStatement(sql);
            rs = pst.executeQuery();
            //System.out.println("xxxxxxxxxxxxxxxxx"+rs.next());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
    public static int updateSqlQuery(Connection conn,String sql) {
        PreparedStatement pst = null;
        int a=0;
        try {
            System.out.println(sql);
            pst = (PreparedStatement) conn.prepareStatement(sql);
            a=pst.executeUpdate();
            //System.out.println("xxxxxxxxxxxxxxxxx"+rs.next());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return a;
    }
    
    public static Date parseDate(String dateStr, String format) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            // sdf.setLenient( false );
            return sdf.parse(dateStr);
        } catch (ParseException pe) {
            pe.printStackTrace();
            return null;
        }
    }

    public static String formatDate(Date date, String format) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }
    public static int generatePin() throws Exception {
        Random generator = new Random();
        generator.setSeed(System.currentTimeMillis());

        int num = generator.nextInt(99999) + 99999;
        if (num < 100000 || num > 999999) {
            num = generator.nextInt(99999) + 99999;
            if (num < 100000 || num > 999999) {
                throw new Exception("Unable to generate PIN at this time..");
            }
        }
        System.out.println(""+num);
        return num;
    }
     public static String encryptString(String str,String key) {
        StringBuffer sb = new StringBuffer(str);

        int lenStr = str.length();
        int lenKey = key.length();

        //
        // For each character in our string, encrypt it...
        for (int i = 0, j = 0; i < lenStr; i++, j++) {
            if (j >= lenKey) {
                j = 0;  // Wrap 'round to beginning of key string.
            }
            //
            // XOR the chars together. Must cast back to char to avoid compile error. 
            //
            sb.setCharAt(i, (char) (str.charAt(i) ^ key.charAt(j)));
        }

        return sb.toString();
    }

    public static String decryptString(String str,String key) {
        //
        // To 'decrypt' the string, simply apply the same technique.
        return encryptString(str,key);
    }

   }
