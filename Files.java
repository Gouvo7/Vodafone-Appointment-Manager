package omadaready;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author gouvo
 */

public class Files {
    
    private DateTimeFormatter dtf,dtfm,dtfy;
    private LocalDateTime now;
    public String day,month,year,path;
    private File theDir,monthDir;
    public String user;
    
    
    public Files(){
        
    }

    public String getPath(){
        return path;
    }
    
    public void prepare(){
        dtf = DateTimeFormatter.ofPattern("dd_MM_yyyy");
        dtfm = DateTimeFormatter.ofPattern("MM");
        dtfy = DateTimeFormatter.ofPattern("yyyy");
        now = LocalDateTime.now();
        day = dtf.format(now);
        month = dtfm.format(now);
        year = dtfy.format(now);
        user = System.getProperty("user.name");
        if (month.equals("01")){
            month = "January";
        }else if (month.equals("02")){
            month = "February";
        }else if (month.equals("03")){
            month = "March";
        }else if (month.equals("04")){
            month = "April";
        }else if (month.equals("05")){
            month = "May";
        }else if (month.equals("06")){
            month = "June";
        }else if (month.equals("07")){
            month = "July";
        }else if (month.equals("08")){
            month = "August";
        }else if (month.equals("09")){
            month = "September";
        }else if (month.equals("10")){
            month = "October";
        }else if (month.equals("11")){
            month = "Novemmber";
        }else if (month.equals("12")){
            month = "December";
        }
        theDir = new File("C:\\Users\\"+user+"\\Documents\\#omadaReady");
        monthDir = new File("C:\\Users\\"+user+"\\Documents\\#omadaReady\\" + month + " " + year);
        

        
        if (!theDir.exists()){
            theDir.mkdirs();
        }
        if (!monthDir.exists()){
            monthDir.mkdirs();
        }
        
            File todayDir = new File("C:\\Users\\"+user+"\\Documents\\#omadaReady\\" + month + " " + year+"\\"+day+".txt");
        
        try {
            if (!todayDir.exists())
                todayDir.createNewFile();

        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        path = todayDir.toString();
    }
    
    public void writeToFile(String path, String name, String phone, String serv, String pricew, String pricet) throws IOException{
            FileWriter myWriter = new FileWriter(path, true);
            BufferedWriter bufferedWriter = new BufferedWriter(myWriter);
            bufferedWriter.write(name+"-"+phone+"-"+serv+"-"+pricew+"-"+pricet);
            bufferedWriter.newLine();
            bufferedWriter.close();
            myWriter.close();
           // myWriter.write(name+","+phone+","+serv+","+pricew+","+pricet);
    }
}
    

