import java.net.URL;
import javax.swing.*;
import javax.sound.sampled.*;
import java.io.*;

public class Som{
    public void tocarSom(String sound){
    try{
    InputStream input = getClass().getResourceAsStream(sound);
    Clip oClip = AudioSystem.getClip();
    AudioInputStream audioInput = AudioSystem.getAudioInputStream(input);
    oClip.open(audioInput);
    
    if(sound == "Music/zuul.wav") oClip.loop(Clip.LOOP_CONTINUOUSLY);
    else oClip.loop(0);
    
    SwingUtilities.invokeLater(new Runnable() { public void run() {} });
    } catch (Exception e) {}
  }
}
