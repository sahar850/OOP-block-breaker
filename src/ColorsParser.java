/**
 * Created by Sahar on 30/06/2016.
 */
import java.awt.Color;

/**
 */
public class ColorsParser {
    /**
     *
     * @param s a string with the info from the file
     * @return the color chosen
     */
    public Color colorFromString(String s) {
        String str;
        str = s.substring("color(".length());
        str = str.replace(")", "");
        if (str.startsWith("RGB")) {
            str = str.replace("RGB", "");
            str = str.replace("(", "");
            String[] split = str.split(",");
            if (!(split.length == 3)) {
                System.out.println("cannot find color values");
                return null;
            }
            int r = Integer.parseInt(split[0]);
            int g = Integer.parseInt(split[1]);
            int b = Integer.parseInt(split[2]);
            return new Color(r, g, b);
        } else {
            if (str.equals("green")) {
                return Color.green;
            } else {
                if (str.equals("cyan")) {
                    return Color.cyan;
                } else {
                    if (str.equals("blue")) {
                        return Color.blue;
                    } else {
                        if (str.equals("gray")) {
                            return Color.gray;
                        } else  {
                            if (str.equals("darkGray")) {
                                return Color.DARK_GRAY;
                            } else {
                            if (str.equals("lightGray")) {
                                return Color.lightGray;
                            } else {
                            if (str.equals("black")) {
                                return Color.black;
                            } else {
                                if (str.equals("white")) {
                                    return Color.white;
                                } else {
                                    if (str.equals("pink")) {
                                        return Color.pink;
                                    } else {
                                        if (str.equals("orange")) {
                                            return Color.orange;
                                        } else {
                                            if (str.equals("magenta")) {
                                                return Color.magenta;
                                            } else {
                                                if (str.equals("red")) {
                                                    return Color.red;
                                                } else {
                                                    if (str.equals("yellow")) {
                                                        return Color.yellow;
                                                    }   else {
                                                                System.out.println("cannot find color");
                                                                return null;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

        }
    }
}
