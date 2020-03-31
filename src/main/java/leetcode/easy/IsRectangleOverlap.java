package leetcode.easy;

/**
 * @Author long
 * @Date 2020/3/18 10:19
 * @Title 836. 矩形重叠
 * @Description //TODO
 **/

public class IsRectangleOverlap {

    //检查区域
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return (Math.min(rec1[2], rec2[2]) > Math.max(rec1[0], rec2[0]) &&
                Math.min(rec1[3], rec2[3]) > Math.max(rec1[1], rec2[1]));
    }


    //反向求解，点不重合满足的条件,检查位置
    public boolean isRectangleOverlapII(int[] rec1, int[] rec2) {
        if (rec2[0] >= rec1[2] || rec2[1] >= rec1[3] || rec2[2] <= rec1[0] || rec2[3] <= rec1[1]) {
            return false;
        }
        return true;
    }


    //错误解，未考虑两点在边上的情形
    public boolean isRectangleOverlapI(int[] rec1, int[] rec2) {
        Dot leftTop = new Dot(rec2[0], rec2[3]);
        Dot leftBottom = new Dot(rec2[0], rec2[1]);
        Dot rightTop = new Dot(rec2[2], rec2[3]);
        Dot rightBottom = new Dot(rec2[2], rec2[1]);
        return checkDot(rec1, leftTop) || checkDot(rec1, leftBottom) || checkDot(rec1, rightTop) || checkDot(rec1, rightBottom);
    }

    public boolean checkDot(int[] rec, Dot dot) {
        if (dot.x > rec[0] && dot.x < rec[2] && dot.y > rec[1] && dot.y < rec[3]) {
            return true;
        }
        return false;
    }


    class Dot {
        public int x;
        public int y;

        public Dot(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
