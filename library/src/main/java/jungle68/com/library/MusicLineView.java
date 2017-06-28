package jungle68.com.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;

/**
 * @Describe
 * @Author Jungle68
 * @Date 2017/6/28
 * @Contact master.jungle68@gmail.com
 */

public class MusicLineView extends View implements View.OnClickListener {
    private static final String TAG = "MusicLineView";
    private static final int DEFAULT_LINE_NUMS = 5;
    private static final int DEFAULT_LINE_COLOR = Color.RED;

    /**
     * anim frequency
     */
    private static final int DEFAULT_ANIM_FREQUENCY = 60;

    /**
     * line color
     */
    private int mLineColor;

    /**
     *
     */
    private boolean mAnimIsStart;

    /**
     * min  line  height
     */
    private int mLineMinHeight;

    /**
     * line to line spacing
     */
    private int mLineSpacing;

    /**
     * height for a frame to add
     */
    private int mHeightForFrame;

    private Paint mPaint = new Paint();


    public MusicLineView(Context context) {
        this(context, null);
    }

    public MusicLineView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MusicLineView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MusicLineView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        if (attrs != null) {
            TypedArray array = getContext().obtainStyledAttributes(attrs,
                    R.styleable.MusicLineView);
            mLineColor = array.getColor(R.styleable.MusicLineView_jungle68_line_color, DEFAULT_LINE_COLOR);
            mAnimIsStart = array.getBoolean(R.styleable.MusicLineView_jungle68_line_color, true);
            array.recycle();
        }

        mPaint.setColor(Color.parseColor("#FFF44336"));
        mPaint.setAntiAlias(true); // 抗锯齿
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setDither(true);

        mPaint.setStrokeWidth(dp2px(2f)); // 画笔的粗细
        mLineSpacing = dp2px(10);
        mHeightForFrame = dp2px(9);
        mLineMinHeight = dp2px(20);

        setOnClickListener(this);
        initData();
    }

    private void initData() {
        mStartX = getPaddingLeft();
        mStartY = getPaddingTop();

        List<Line> lines = new ArrayList<>();
        mEndY = mStartY + mShortLineHgt;
        for (int i = 0; i < LINE_ANIM_COUNT; i++) { // 绘制首次的频率画面
            float startY = mEndY - mShortLineHgt * (i + 1) * 1 / 2;
            float startX = mStartX + i * mLintToLineW;
            Line line = new Line(startX, startY, mEndY);
            lines.add(line);
            logT("测试y = " + startY);
        }

        mMaxLineStartY = lines.get(3).startY;

        // 打乱集合顺序
        Line line1 = new Line();
        line1.x = lines.get(0).x;
        line1.startY = lines.get(2).startY;
        line1.startYs = new float[]{line1.startY + mFrameNum * 2, line1.startY + mFrameNum, line1.startY}; // 由小到大
        line1.stopY = lines.get(0).stopY;
        mLines.add(line1);

        Line line2 = new Line();
        line2.x = lines.get(1).x;
        line2.startY = lines.get(1).startY;
        line2.startYs = new float[]{line2.startY - mFrameNum * 2, line2.startY - mFrameNum, line2.startY}; // 由大到小
        line2.stopY = lines.get(1).stopY;
        mLines.add(line2);

        Line line3 = new Line();
        line3.x = lines.get(2).x;
        line3.startY = lines.get(3).startY;
        line3.startYs = new float[]{line3.startY + mFrameNum + mFrameNum * 1 / 2, line3.startY + mFrameNum + mFrameNum * 1 / 4, line3.startY}; // 由小到大
        line3.stopY = lines.get(2).stopY;
        mLines.add(line3);

        Line line4 = new Line();
        line4.x = lines.get(3).x;
        line4.startY = lines.get(0).startY;
        line4.startYs = new float[]{line4.startY - mFrameNum * 2, line4.startY - mFrameNum, line4.startY}; // 由大到小
        line4.stopY = lines.get(3).stopY;
        mLines.add(line4);

    }

    @Override
    public void onClick(View v) {

    }

    private int dp2px(float dpValue) {
        final float scale = getContext().getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
