package g;

import Map.Map;
public class Logic {
    private int row;// 琛�
    private int col;// 鍒�
    protected Map lifeMap;
    
    public Logic(int r, int c) {
        row = r;// 琛�
        col = c; // 鍒�
        lifeMap = new Map(row, col);
    }
    public Map GetMap() {
        return lifeMap;
    }
    // 闅忔満鐢熸垚鍦板浘
    
    public void InitMap() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                double x = Math.random();
                if (x > 0.6) {
                    lifeMap.setNewMap(i, j, true);
                } else {
                    lifeMap.setNewMap(i, j, false);
                }
            }
        }
        lifeMap.updateMap();
    }
    // 鏇存柊涓嬩竴浠�
    public void UpdateNext() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int num = lifeMap.getVertice(i - 1, j - 1) + lifeMap.getVertice(i - 1, j)
                        + lifeMap.getVertice(i - 1, j + 1) + lifeMap.getVertice(i, j - 1) + lifeMap.getVertice(i, j + 1)
                        + lifeMap.getVertice(i + 1, j - 1) + lifeMap.getVertice(i + 1, j)
                        + lifeMap.getVertice(i + 1, j + 1);
                // 鍒ゆ柇
                if (lifeMap.getVertice(i, j) == 1){// 鐢�
                    if (num < 2 || num > 3)
                      lifeMap.setNewMap(i, j, false);
                    else
                      lifeMap.setNewMap(i, j, true);
                } else{// 姝�
                    if (num == 3)
                      lifeMap.setNewMap(i, j, true);
                    else{
                      lifeMap.setNewMap(i, j, false);
                        }
                }
            }
        }
        lifeMap.updateMap();
    }

}
