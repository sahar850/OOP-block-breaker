import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.io.Reader;
/**
 * Created by Sahar on 30/06/2016.
 */
public class LevelSpecificationReader {
    /**
     *
     * @param reader the object that reads from file
     * @return the level
     * @throws Exception when something is wrong in the reading
     */
    public List<LevelInformation> fromReader(java.io.Reader reader) throws Exception {
        Level levelinfo = null; BlocksFromSymbolsFactory blockFactory = null; BufferedImage image;
        ArrayList<LevelInformation> levelinfolist = new ArrayList<LevelInformation>();
        ArrayList<Velocity> velocity = new ArrayList<Velocity>();
        ArrayList<Block> blockList = new ArrayList<Block>();
        java.io.BufferedReader lineReader = new java.io.BufferedReader(reader); String line = null;
        ColorsParser colorsParser = new ColorsParser();
        String temp; int startx; int starty; Block block;
        try {
            line = lineReader.readLine();
        } catch (Exception e) { System.out.println("can't read from file"); }
        while (line != null) { if (line.startsWith("START_LEVEL")) {
                levelinfo = new Level();
            }
            if (line.startsWith("level_name")) { String[] split = line.trim().split(":");
                levelinfo.setlevelName(split[1]);
            }
            if (line.startsWith("background")) { temp = line.substring("background:".length());
                temp = temp.replace(")", "");
                if (temp.startsWith("image(")) { temp = temp.substring("image(".length());
                    try {
                        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream(temp);
                        image = ImageIO.read(is);
                        Background background = new Background(image);
                        levelinfo.setBackground(background);
                    } catch (Exception e) { System.out.println("can't find image"); }
                }
                if (temp.startsWith("color(")) {
                    Color color = colorsParser.colorFromString(temp);
                    if (color == null) { throw new Exception("can't find color");
                    } else {
                        Background background = new Background(color);
                        levelinfo.setBackground(background);
                    }
                }
            }
            if (line.startsWith("paddle_speed:")) { temp = line.substring("paddle_speed:".length());
                try {
                    if (Integer.parseInt(temp) <= 0) { throw new Exception("invalid paddle speed value");
                    } else { levelinfo.setpaddleSpeed(Integer.parseInt(temp)); }
                } catch (Exception e) {
                    System.out.println("can't find paddle speed");
                }
            }
            if (line.startsWith("paddle_width:")) { temp = line.substring("paddle_width:".length());
                try { if (Integer.parseInt(temp) <= 0) { throw new Exception("invalid paddle width value");
                    } else {
                        levelinfo.setpaddleWidth(Integer.parseInt(temp));
                    }
                } catch (Exception e) {
                    System.out.println("can't find paddle width");
                }
            }
            if (line.startsWith("block_definitions:")) { temp = line.substring("block_definitions:".length());
                try {

                    Reader blockReader = new InputStreamReader(ClassLoader.getSystemClassLoader().
                            getResourceAsStream(temp));
                    blockFactory = BlocksDefinitionReader.fromReader(blockReader);
                } catch (Exception e) { System.out.println("can't find blockList definitions");
                }
            }
            if (line.startsWith("blocks_start_x:")) { temp = line.substring("blocks_start_x:".length());
                try {
                    if (Integer.parseInt(temp) <= 0) { throw new Exception("invalid blocks start x value");
                    } else {
                        levelinfo.setBlocksStartX(Integer.parseInt(temp));
                    }
                } catch (Exception e) { System.out.println("can't find blocks start x");
                }
            }
            if (line.startsWith("blocks_start_y:")) { temp = line.substring("blocks_start_y:".length());
                try {
                    if (Integer.parseInt(temp) <= 0) { throw new Exception("invalid blocks start y value");
                    } else {
                        levelinfo.setBlocksStartY(Integer.parseInt(temp));
                    }
                } catch (Exception e) { System.out.println("can't find blocks start y"); }
            }
            if (line.startsWith("row_height:")) { temp = line.substring("row_height:".length());
                try {
                    if (Integer.parseInt(temp) <= 0) { throw new Exception("invalid row height value");
                    } else {
                        levelinfo.setRowHeight(Integer.parseInt(temp));
                    }
                } catch (Exception e) { System.out.println("can't find row height");
                }
            }
            if (line.startsWith("num_blocks:")) { temp = line.substring("num_blocks:".length());
                try {
                    if (Integer.parseInt(temp) <= 0) { throw new Exception("invalid num blocks value");
                    } else {
                        levelinfo.setnumberOfBlocksToRemove(Integer.parseInt(temp));
                    }
                } catch (Exception e) {
                    System.out.println("cannot find num blocks");
                }
            }
            if (line.startsWith("ball_velocities:")) { temp = line.substring("ball_velocities:".length());
                String[] split = temp.split(" ");
                for (int i = 0; i < split.length; i++) {
                    String[] ats = split[i].split(",");
                    if (ats.length != 2) { throw new Exception("invalid ball velocities");
                    }
                    Velocity v = Velocity.fromAngleAndSpeed(Integer.parseInt(ats[0]), Integer.parseInt(ats[1]));
                    velocity.add(v);
                }
                levelinfo.setnumberOfBalls(velocity.size());
                levelinfo.setinitialBallVelocities(velocity);
            }
            if (line.startsWith("START_BLOCKS")) {
                try {
                    line = lineReader.readLine();
                } catch (Exception e) {
                    System.out.println("can't read file");
                }
                startx = levelinfo.getBlocksStartX();
                starty = levelinfo.getBlocksStartY();
                while (!(line.startsWith("END_BLOCKS"))) {
                    String[] symbols = line.split("");
                    for (int i = 1; i < symbols.length; i++) {
                        if (blockFactory.isBlockSymbol(symbols[i])) {
                            block = blockFactory.getBlock(symbols[i], startx, starty); blockList.add(block);
                            startx = startx + (int) block.getCollisionRectangle().getWidth();
                        } else {
                            if (blockFactory.isSpaceSymbol(symbols[i])) {
                                startx = startx + blockFactory.getSpaceWidth(symbols[i]);
                            }
                        }
                    }
                    try {
                        line = lineReader.readLine();
                    } catch (Exception e) { System.out.println("can't read file");
                    }
                    starty = starty + levelinfo.getRowHeight(); startx = levelinfo.getBlocksStartX();
                }
                levelinfo.setblocks(blockList);
            }
            if (line.startsWith("END_LEVEL")) { levelinfolist.add(levelinfo); levelinfo = null;
                velocity = new ArrayList<Velocity>(); blockList = new ArrayList<Block>();
            }
            try {
                line = lineReader.readLine();
            } catch (Exception e) {
                System.out.println("can't read file");
            }
        }
        return levelinfolist;
    }
}
