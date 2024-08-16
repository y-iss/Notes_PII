package UserInterface;

import java.awt.Color;
import java.awt.Font;
import java.net.URL;
import javax.swing.SwingConstants;

public abstract class FAStyle {
    public static final Color COLOR_BUTTON = Color.WHITE;
    public static final Color COLOR_BUTTON_U = new Color(90, 97, 98);
    public static final Color COLOR_BUTTON_D = new Color(171, 233, 247);
    public static final Color COLOR_INTERFACE = new Color(205, 218, 213);
    public static final Color COLOR_TITLE = Color.BLUE;
    
    public static final Font FONT_NORMAL = new Font("Arial", Font.PLAIN, 10);
    public static final Font FONT_TEXT = new Font("Arial", Font.BOLD | Font.PLAIN, 12);
    public static final Font FONT_TITLE = new Font("Verdana", Font.BOLD, 18);
    public static final Font FONT_BOLD = new Font("JetBrains Mono", Font.BOLD, 14);
    public static final Font FONT_ITALIC = new Font("JetBrains Mono", Font.ITALIC, 14);
    
    public static final int ALIGNMENT_LEFT = SwingConstants.LEFT;
    public static final int ALIGNMENT_RIGHT = SwingConstants.RIGHT;
    public static final int ALIGNMENT_CENTER = SwingConstants.CENTER;

    public static final URL URL_LOGO = FAStyle.class.getResource("/userInterface/Image/logo.png");
}

