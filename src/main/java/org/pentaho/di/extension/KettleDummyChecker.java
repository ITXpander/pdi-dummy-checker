package org.pentaho.di.extension;

import org.pentaho.di.core.exception.KettleException;
import org.pentaho.di.core.extension.ExtensionPoint;
import org.pentaho.di.core.extension.ExtensionPointInterface;
import org.pentaho.di.core.logging.LogChannel;
import org.pentaho.di.core.logging.LogChannelInterface;
import org.pentaho.di.trans.TransMeta;
import org.pentaho.di.ui.spoon.Spoon;

@ExtensionPoint(
        id = "KettleVerifyExtension",
        extensionPointId = "SpoonTransMetaExecutionStart",
        description = "This extension forces a transformation check before execution."
      )
public class KettleDummyChecker implements ExtensionPointInterface {

    private LogChannelInterface log = new LogChannel( this );
    
    @Override
    public void callExtensionPoint(LogChannelInterface log, Object obj) throws KettleException {   
        TransMeta transMeta = (TransMeta) obj;        
        Spoon s = Spoon.getInstance();
        if(s == null)
            return;
        
        s.checkTrans(transMeta);
    }

}
