package Map;

public class Map {
    private int row; // 琛�
    private int col; // 鍒�
    private Boolean oldMap[][];
    private Boolean newMap[][];

    public Map(int r, int c) {
        row=r; // 琛�
        col=c; // 鍒�
        oldMap=new Boolean[row][col];
        newMap=new Boolean[row][col];
    }
    // 鑾峰彇鐐逛俊鎭�
    
    public int getVertice(int i, int j) {
        //瓒呭嚭鑼冨洿璁颁负0
        if (i < 0 || j < 0 || i >= row || j >= col)
          return 0;
        if (oldMap[i][j] == true) {
          return 1;
        } else {
            return 0;
        }
    }
    // 鏇存柊涓嬩竴涓姸鎬�
    
    public void setNewMap(int i, int j, Boolean newVertice) {
        newMap[i][j] = newVertice;
    }
    // 鏇存柊鍥�
    
    public void updateMap() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                oldMap[i][j] = newMap[i][j];
                }
    }
        }
}
