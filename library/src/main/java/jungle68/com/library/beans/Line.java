package jungle68.com.library.beans;

/**
 * @Describe
 * @Author Jungle68
 * @Date 2015/6/29
 * @Contact master.jungle68@gmail.com
 */

public class Line {
    private float startX;
    private float endX;
    private float startY;
    private float endY;

    public Line() {
    }

    public Line(float startX, float endX, float startY, float endY) {
        this.startX = startX;
        this.endX = endX;
        this.startY = startY;
        this.endY = endY;
    }

    public float getStartX() {
        return startX;
    }

    public void setStartX(float startX) {
        this.startX = startX;
    }

    public float getEndX() {
        return endX;
    }

    public void setEndX(float endX) {
        this.endX = endX;
    }

    public float getStartY() {
        return startY;
    }

    public void setStartY(float startY) {
        this.startY = startY;
    }

    public float getEndY() {
        return endY;
    }

    public void setEndY(float endY) {
        this.endY = endY;
    }


    @Override
    public String toString() {
        return "Line{" +
                "startX=" + startX +
                ", endX=" + endX +
                ", startY=" + startY +
                ", endY=" + endY +
                '}';
    }
}
