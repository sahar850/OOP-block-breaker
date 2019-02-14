import javax.imageio.ImageIO;
import java.awt.Image;
import java.awt.Color;
import java.io.InputStream;
import java.util.Map;
import java.util.TreeMap;
/**
 * Created by Sahar on 30/06/2016.
 */

/**
 * this method read the file and creating levels.
 */
public class BlocksDefinitionReader {
    /**
     *
     * @param reader the reader of the file
     * @return levels
     * @throws Exception if the file is curated or missing
     */
    public static BlocksFromSymbolsFactory fromReader(java.io.Reader reader) throws Exception {
        java.io.BufferedReader linereader = new java.io.BufferedReader(reader);
        BlocksFromSymbolsFactory blockfactory = new BlocksFromSymbolsFactory();
        String line = null; String temp; int colorNum; String[] split; BlockFileGenerator blocktype;
        Integer defaultHeight = null; Integer defaultWidth = null; Integer defaultHits = null; Color defaultColor;
        Color defaultStroke = null; Image defaultImage; Map<Integer, Color> mapColor = new TreeMap<Integer, Color>();
        Map<Integer, Image> mapImage = new TreeMap<Integer, Image>(); String symbol = null; Integer height = null;
        Integer width = null; Integer hitPoints = null; Color color = null; Color stroke = null; Image image;
        Map<Integer, Color>  mapcolor = new TreeMap<Integer, Color>(); Map<Integer, Image> mapimage = new
        TreeMap<Integer, Image>(); ColorsParser colorsParser = new ColorsParser(); try { line = linereader.readLine();
        } catch (Exception e) { System.out.println("can't read blocks definition file"); }
        while (line != null) {
            if (line.startsWith("default")) { split = line.split(" "); for (int i = 0; i < split.length; i++) {
                    if (split[i].startsWith("height:")) {
                        temp = split[i].substring("height:".length()); defaultHeight = Integer.parseInt(temp);
                    }
                    if (split[i].startsWith("width:")) {
                        temp = split[i].substring("width:".length()); defaultWidth = Integer.parseInt(temp);
                    }
                    if (split[i].startsWith("hit_points:")) {
                        temp = split[i].substring("hit_points:".length()); defaultHits = Integer.parseInt(temp);
                    }
                    if (split[i].startsWith("fill:")) {
                        temp = split[i].substring("fill:".length()); if (temp.startsWith("image(")) {
                            temp = temp.substring("image(".length()); temp = temp.replace(")", "");
                          try { InputStream inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream(temp);
                                defaultImage = ImageIO.read(inputStream); mapImage.put(1, defaultImage);
                            } catch (Exception e) { System.out.println("can't load image"); }
                        } else {
                        temp = split[i].substring("fill:".length()); defaultColor = colorsParser.colorFromString(temp);
                            if (color == null) { throw new Exception("can't load color");
                            } else { mapColor.put(1, defaultColor); }
                        }
                    }
                if (split[i].startsWith("fill-")) { temp = split[i].substring("fill-".length(), "fill-".length()
                        + 1); colorNum = Integer.parseInt(temp); temp = split[i].substring("fill-x:".length());
                    if (temp.startsWith("image(")) {
                            temp = temp.substring("image(".length()); temp = temp.replace(")", "");
                            try { InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream(temp);
                                defaultImage = ImageIO.read(is); mapImage.put(colorNum, defaultImage);
                            } catch (Exception e) { System.out.println("can't load image"); }
                        } else {
           temp = split[i].substring("fill-x:".length()); defaultColor = colorsParser.colorFromString(temp);
                            if (color == null) { throw new Exception("can't load color");
                            } else { mapColor.put(colorNum, defaultColor);
                            }
                        }
                    }
                    if (split[i].startsWith("stroke:")) {
                    temp = split[i].substring("stroke:".length()); defaultStroke = colorsParser.colorFromString(temp);
                        if (defaultStroke == null) { throw new Exception("can't load color");
                        }
                    }
                }
            }
            if (line.startsWith("bdef")) {
                split = line.split(" "); for (int i = 0; i < split.length; i++) {
                    if (split[i].startsWith("symbol:")) {
                        temp = split[i].substring("symbol:".length()); symbol = temp;
                    }
                    if (split[i].startsWith("height:")) {
                        temp = split[i].substring("height:".length()); height = Integer.parseInt(temp);
                    }
                    if (split[i].startsWith("width:")) {
                        temp = split[i].substring("width:".length()); width = Integer.parseInt(temp);
                    }
                    if (split[i].startsWith("fill:")) {
                        temp = split[i].substring("fill:".length());
                        if (temp.startsWith("image(")) {
                            temp = temp.substring("image(".length()); temp = temp.replace(")", "");
                            try { InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream(temp);
                                image = ImageIO.read(is); mapimage.put(1, image);
                            } catch (Exception e) { System.out.println("can't load image"); }
                        } else {
                            temp = split[i].substring("fill:".length()); color = colorsParser.colorFromString(temp);
                            if (color == null) { throw new Exception("can't load color");
                            } else { mapcolor.put(1, color); }
                        }
                    }
                    if (split[i].startsWith("fill-")) {
                        temp = split[i].substring("fill-".length(), "fill-".length() + 1);
                        colorNum = Integer.parseInt(temp); temp = split[i].substring("fill-x:".length());
                        if (temp.startsWith("image(")) {
                            temp = temp.substring("image(".length()); temp = temp.replace(")", "");
                        try { InputStream inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream(temp);
                                image = ImageIO.read(inputStream); mapimage.put(colorNum, image);
                            } catch (Exception e) {
                                System.out.println("can't load image");
                        }
                        } else {
                            temp = split[i].substring("fill-x:".length()); color = colorsParser.colorFromString(temp);
                            if (color == null) { throw new Exception("can't load color");
                            } else { mapcolor.put(colorNum, color);
                            }
                        }
                    }
                    if (split[i].startsWith("stroke:")) {
                        temp = split[i].substring("stroke:".length()); stroke = colorsParser.colorFromString(temp);
                        if (stroke == null) { throw new Exception("can't load color");
                        }
                    }
                    if (split[i].startsWith("hit_points:")) {
                        temp = split[i].substring("hit_points:".length()); hitPoints = Integer.parseInt(temp);
                    }
                }
                if ((height == null) && (defaultHeight != null)) {
                    height = defaultHeight;
                }
                if ((width == null) && (defaultWidth != null)) {
                    width = defaultWidth;
                }
                if ((hitPoints == null) && (defaultHits != null)) {
                    hitPoints = defaultHits;
                }
                if ((mapcolor == null) && (mapColor != null)) {
                    mapcolor = mapColor;
                }
                if ((mapimage == null) && (mapImage != null)) {
                    mapimage = mapImage;
                }
                if ((stroke == null) && (defaultStroke != null)) {
                    stroke = defaultStroke;
                }
                if (symbol == null) { throw new Exception("can't find block symbol");
                }
                if ((height == null) || (width == null) || (hitPoints == null) || (mapcolor == null)
                        || (mapimage == null)) {
                    throw new Exception("something from the block details are missing");
                }
                blocktype = new BlockFileGenerator(width, height, hitPoints, mapcolor, mapimage, stroke);
                blockfactory.setBlock(symbol, blocktype); height = null; width = null; hitPoints = null;
                mapcolor = new TreeMap<Integer, Color>(); mapimage = new TreeMap<Integer, Image>();
                color = null; stroke = null; image = null;
            }
            if (line.startsWith("sdef")) {
                split = line.split(" "); for (int i = 0; i < split.length; i++) {
                    if (split[i].startsWith("symbol:")) {
                        temp = split[i].substring("symbol:".length()); symbol = temp;
                    }
                    if (split[i].startsWith("width:")) {
                        temp = split[i].substring("width:".length()); width = Integer.parseInt(temp);
                    }
                }
                if ((width == null) || (symbol == null)) { throw new Exception("can't find sdef"); }
                blockfactory.setSpaceWidth(symbol, width); symbol = null; width = null;
            }
            try { line = linereader.readLine();
            } catch (Exception e) { System.out.println("can't read blocks definition file"); }
        } return blockfactory;
    }
}