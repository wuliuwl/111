
import g.Logic;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;

import javax.swing.*;

public class Game extends JFrame {

    private static final long serialVersionUID = 1L;
    private static final int sx = 50; // 鍒濆瀹藉害
    private static final int sy = 50; // 鍒濆楂樺害
    private static final int w = 10; // 灏忔柟鏍艰竟闀�
    private static final int rw = 600; // 鏂规牸鎬昏竟闀�

    private int row = 60; // 琛�
    private int col = 60; // 鍒�

    private Logic logic;
    private Graphics jg;

    public Game() {
        logic = new Logic(row, col);
        // 璁剧疆鐣岄潰
        setBounds(100, 100, 700, 700);
        setVisible(true);
        setLayout(null);
        setResizable(false);
        setTitle("鐢熷懡娓告垙寮�濮嬪挴!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 璁剧疆鑳屾櫙
        Container p = getContentPane();
        Color rectColor = new Color(0x1368fca);
        p.setBackground(rectColor);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

            jg = this.getGraphics();

    }
    
    public void setGrid(int cx, int cy, Color color) {
        jg.setColor(color);
        jg.fillRect(sx + (cx * w) + 1, sy + (cy * w) + 1, w - 2, w - 2);
    }

    public void drawLine() {
        try {
            // 璁剧疆绾挎潯棰滆壊
            Color cs = new Color(0Xfffffff);
            jg.setColor(cs);
            jg.drawRect(sx, sy, rw, rw);
            for (int i = 1; i < col; i++) {
                jg.drawLine(sx + (i * w), sy, sx + (i * w), sy + rw);
                jg.drawLine(sx, sy + (i * w), sx + rw, sy + (i * w));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void start() {
        // 鍒濆鍖栧湴鍥�
        logic.InitMap();
        for (int i = 0; i < col; i++) {
            for (int j = 0; j<row; j++) {
                if (logic.GetMap().getVertice(i, j) == 1) {
                    setGrid(i, j, Color.PINK);
                }
            }
        }
        // 鏇存柊娓告垙鍖哄煙
        for (int k = 1; k < 5000; k++) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            logic.UpdateNext();
            for (int i = 0; i < col; i++) {
                for (int j = 0; j < row; j++) {
                    if (logic.GetMap().getVertice(i, j) == 1) {
                        setGrid(i, j, Color.PINK);
                    } else {
                        setGrid(i, j, Color.WHITE);
                    }
                }
            }
            setTitle("第"+k+"次变化");
        }
    }
    
    public static void main(String[] args) {
     Game game = new Game();
        game.drawLine();
        game.start();
    }
}
