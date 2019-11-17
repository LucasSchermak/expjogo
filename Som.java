import java.net.URL;
import javax.swing.*;
import javax.sound.sampled.*;
import java.io.*;

public class Som {

  private static void main(String args[])
  {
    new Som().som();
  }
  
  public void som() 
  {
    try{
    String resource = "./zuul.wav";
    InputStream input = getClass().getResourceAsStream(resource);
    Clip oclip = AudioSystem.getClip();
    AudioInputStream audioInput = AudioSystem.getAudioInputStream(input);
    oClip.open(audioInput);
    
    oClip.loop(Clip.LOOP_CONTINUOUSLY);
    
    SwingUtilities.InvokeLater(new Runnable() { public void run() {} });
    } catch (Exception e) {
    }
  }
}
