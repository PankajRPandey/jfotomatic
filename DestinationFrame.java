
// Source File Name:   DestinationFrame.java

import java.awt.Color;
import javax.swing.JInternalFrame;

public class DestinationFrame extends JInternalFrame
    implements Constants
{

    public DestinationFrame(String s, user_intf user_intf)
    {
        super(s, true, true, true, true);
        elementColor = Constants.DEFAULT_ELEMENT_COLOR;
        elementType = 101;
        theApp = user_intf;
    }

    public Color getElementColor()
    {
        return elementColor;
    }

    public int getElementType()
    {
        return elementType;
    }

    private user_intf theApp;
    private Color elementColor;
    private int elementType;
}