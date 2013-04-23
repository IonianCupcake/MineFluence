package ioniancupcake.common.sounds;

import ioniancupcake.common.helper.LogHelper;
import ioniancupcake.common.lib.Sprites;
import ioniancupcake.common.main.MineFluence;

import java.util.logging.Level;

import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;

public class MFSounds
{
    @ForgeSubscribe
    public void onSound(SoundLoadEvent event)
    {
        try
        {
             String [] soundFiles = {
                     "bacteriablaster1.wav"
                     };
             for (int i = 0; i < soundFiles.length; i++){
                 event.manager.soundPoolSounds.addSound(soundFiles[i], MineFluence.class.getResource(Sprites.MF_SOUNDS + "bacteriablaster" + soundFiles[i]));
             }
       
        }
        catch (Exception e)
        {
            LogHelper.log(Level.WARNING, "A problem occured while loading sounds. Make sure you have MineFluence installed the right way!");
        }
    }
}
