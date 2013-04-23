package ioniancupcake.common.helper;

import ioniancupcake.common.lib.Reference;
import ioniancupcake.common.main.MineFluence;

import java.util.logging.Level;
import java.util.logging.Logger;

import cpw.mods.fml.common.FMLLog;

public class LogHelper
{
    private static Logger mfLogger = Logger.getLogger(Reference.MOD_ID);

    public static void init() {

        mfLogger.setParent(FMLLog.getLogger());
    }

    public static void log(Level logLevel, String message) {

        mfLogger.log(logLevel, message);
    }
    
    public static void debugLog(String message) {
        if(MineFluence.isDebug)
        {
            mfLogger.log(Level.INFO, message);
        }
    }
    
    public static void debugLog(Object message) {
        if(MineFluence.isDebug){
            if(message != null) {
            mfLogger.log(Level.INFO, message.toString());
            }
            else{
                mfLogger.log(Level.INFO, "null");
            }
        }
    }
    
    public static void log(Level logLevel, Object message) {

        mfLogger.log(logLevel, message.toString());
    }
}
