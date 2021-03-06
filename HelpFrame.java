import javax.swing.*; 
 import javax.swing.event.*; 
 import javax.swing.text.*; 
 import javax.swing.text.html.*; 
 import javax.swing.border.*; 
 import javax.swing.colorchooser.*; 
 import javax.swing.filechooser.*; 
 import javax.accessibility.*;
 import java.awt.*; 
 import java.awt.event.*; 
 import java.beans.*; 
 import java.util.*; 
 import java.io.*; 
 import java.applet.*; 
 import java.net.*; 

 public class HelpFrame extends JFrame { 
  
     JEditorPane html; 
     public HelpFrame() { 
	setVisible(true);
	setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	int width=400;int height=400;
        Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
        int x=(screen.width-width)/2;
        int y=(screen.height-height)/2;
        setBounds(x,y,width,height);
         try { 
 	    URL url = null; 
 	    String path = null; 
 	    try { 
 		path = "/resources/HelpTopics.html"; 
 		url = getClass().getResource(path); 
             } catch (Exception e) { 
 		System.err.println("Failed to open " + path); 
 		url = null; 
             } 
 	     
             if(url != null) { 
                 html = new JEditorPane(url); 
                 html.setEditable(false); 
                 html.addHyperlinkListener(createHyperLinkListener()); 
  
 		JScrollPane scroller = new JScrollPane(); 
 		JViewport vp = scroller.getViewport(); 
 		vp.add(html); 
                 this.add(scroller, BorderLayout.CENTER); 
             } 
         } catch (MalformedURLException e) { 
             System.out.println("Malformed URL: " + e); 
         } catch (IOException e) { 
             System.out.println("IOException: " + e); 
         } 
     } 
  
     public HyperlinkListener createHyperLinkListener() { 
 	return new HyperlinkListener() { 
 	    public void hyperlinkUpdate(HyperlinkEvent e) { 
 		if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) { 
 		    if (e instanceof HTMLFrameHyperlinkEvent) { 
 			((HTMLDocument)html.getDocument()).processHTMLFrameHyperlinkEvent( 
 			    (HTMLFrameHyperlinkEvent)e); 
 		    } else { 
 			try { 
 			    html.setPage(e.getURL()); 
 			} catch (IOException ioe) { 
 			    System.out.println("IOE: " + ioe); 
 			} 
 		    } 
 		} 
 	    } 
 	}; 
     } 
      
     void updateDragEnabled(boolean dragEnabled) { 
         html.setDragEnabled(dragEnabled); 
     } 
      
 } 
 