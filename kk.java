import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;
import java.io.* ; 

 public class kk {

    public static JFrame win ;
    public static JEditorPane ta ; 
    public static JMenuBar mb ;
    public static JMenu file ;
    public static JScrollPane js ;
    public static JMenuItem nw ;
    public static JMenuItem op ;
    public static JMenuItem sv ;
    public static JMenuItem cl ; 
    public static File f ; 
    public static String txt ; 
    public static String allText ;

    
    public static void  main(String args[]) throws IOException {

     win = new JFrame() ;
     win.setSize(700 , 600)  ;
     win.setTitle("Check Editor ") ;
     Font fn = new Font( Font.SERIF, Font.PLAIN,  16) ;
     ta = new JEditorPane() ;
     ta.setFont(fn) ;
    js = new JScrollPane(ta) ; 
      
     //adding menu 
    mb = new JMenuBar() ;
    file = new JMenu("File") ;
      nw = new JMenuItem("New") ;
      op = new JMenuItem("Open...") ;
      sv = new JMenuItem("Save It ... ") ;

   //adding actions 
      nw.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent ez ) {
      ta.setText("") ; //reset 
      win.setTitle("Khata2 " ) ; //reset 
       

      }

     }) ;  
     //open 
      op.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent ez ) {
     
      JFileChooser jf = new JFileChooser() ;
      jf.showOpenDialog(null) ;      
      f = jf.getSelectedFile();
     String filePath = "Editor "+ f.getAbsolutePath()+ f.getName() ;
      win.setTitle(filePath) ;

       
     txt="" ;//reset 
       try {
        FileReader fr = new FileReader(f)  ;
        BufferedReader br = new BufferedReader(fr) ;
         txt=br.readLine() ;
        while (txt != null ) {
         
         txt=br.readLine() ;
        
      allText= allText + "\n " + txt ;
        } ;
    

       }catch(IOException rar) {
    System.err.println(rar) ; 
     }
     ta.setText(allText) ; 

  

      }

     }) ; 

    //save
     sv.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent ez ) {
       JFileChooser jf = new JFileChooser() ;
      jf.showSaveDialog(null) ;      
      f = jf.getSelectedFile();
     String filePath = "Editor "+ f.getAbsolutePath()+ f.getName() ;
      win.setTitle(filePath) ;
     
        //**** fileWriter basic Code 
     try {
          FileWriter fw = new FileWriter(f , true) ;
          BufferedWriter bw = new BufferedWriter(fw) ;
        
      
       System.out.println("Type What ever you want ") ;
         
       txt = ta.getText() ; 
        
       bw.write("\n " + txt) ;
       bw.close() ;
      


        }catch(IOException eee) {
      System.err.println(eee) ; 
      
      }
      //**end of fileWriter Basic Code 

      }

     }) ; 

     
    file.add(nw) ;
    file.add(op) ;
    file.add(sv) ;
    

    mb.add(file) ;
    //menu packing completed   

    


    win.setJMenuBar(mb) ; 
    win.add(js) ;
     win.setVisible(true) ;
     win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;  
   } }   
