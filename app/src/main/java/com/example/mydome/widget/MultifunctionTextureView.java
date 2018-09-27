package com.example.mydome.widget;

import android.content.Context;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView;

import uk.co.senab.photoview.PhotoViewAttacher;


/**
 * 这个MultifunctionTextureView能放缩和拖拽正在播放的视频
 */
public class MultifunctionTextureView extends TextureView implements TextureView.SurfaceTextureListener, PhotoViewAttacher.OnMatrixChangedListener {

    /**
     * 等比例,最大化区域显示,不裁剪
     */
    public static final int ASPACT_RATIO_INSIDE =  1;
    /**
     * 等比例,裁剪,裁剪区域可以通过拖拽展示\隐藏
     */
    public static final int ASPACT_RATIO_CROPE_MATRIX =  2;
    /**
     * 等比例,最大区域显示,裁剪
     */
    public static final int ASPACT_RATIO_CENTER_CROPE =  3;
    /**
     * 拉伸显示,铺满全屏
     */
    public static final int FILL_WINDOW =  4;

    private PhotoViewAttacher mAttacher;
    protected int mWidth;
    protected int mHeight;
    private int mRatioType = ASPACT_RATIO_INSIDE;

    public MultifunctionTextureView(Context context) {
        super(context);
    }

    public MultifunctionTextureView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MultifunctionTextureView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }



    @Override
    public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {

    }

    @Override
    public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {

    }

    @Override
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
        return false;
    }

    @Override
    public void onSurfaceTextureUpdated(SurfaceTexture surface) {

    }

    @Override
    public void onMatrixChanged(RectF rect) {

    }

//    private void onVideoSizeChange() {
//        Log.i("onVideoSizeChange", String.format("RESULT_VIDEO_SIZE RECEIVED :%d*%d", mWidth, mHeight));
//        if (mWidth == 0 || mHeight == 0) return;
//        if (mAttacher != null){
//            mAttacher.cleanup();
//            mAttacher = null;
//        }
//        if (mRatioType == ASPACT_RATIO_CROPE_MATRIX) {
//            ViewGroup parent = (ViewGroup) getView().getParent();
//            parent.addOnLayoutChangeListener(listener);
//            fixPlayerRatio(getView(), parent.getWidth(), parent.getHeight());
//            this.getLayoutParams().height = ViewGroup.LayoutParams.MATCH_PARENT;
//            this.getLayoutParams().width = ViewGroup.LayoutParams.MATCH_PARENT;
//            mAttacher = new PhotoViewAttacher(this, mWidth, mHeight);
//            mAttacher.setOnLongClickListener(new View.OnLongClickListener() {
//                @Override
//                public boolean onLongClick(View v) {
//                    //                    ...
//                    return false;
//                }
//            });
//            mAttacher.setScaleType(ImageView.ScaleType.CENTER_CROP);
//            mAttacher.setOnMatrixChangeListener(this);
//            mAttacher.update();
//
//        }else {
//            this.setTransform(new Matrix());
//            //            int viewWidth = mSurfaceView.getWidth();
//            //            int viewHeight = mSurfaceView.getHeight();
//            float ratioView = getView().getWidth() * 1.0f/getView().getHeight();
//            float ratio = mWidth * 1.0f/mHeight;
//
//            switch (mRatioType){
//                case ASPACT_RATIO_INSIDE: {
//
//                    if (ratioView - ratio < 0){    // 屏幕比视频的宽高比更小.表示视频是过于宽屏了.
//                        // 宽为基准.
//                        this.getLayoutParams().width = ViewGroup.LayoutParams.MATCH_PARENT;
//                        this.getLayoutParams().height = (int) (getView().getWidth() / ratio + 0.5f);
//                    }else{                          // 视频是竖屏了.
//                        this.getLayoutParams().height = ViewGroup.LayoutParams.MATCH_PARENT;
//                        this.getLayoutParams().width = (int) (getView().getHeight() * ratio + 0.5f);
//                    }
//                }
//                break;
//                case ASPACT_RATIO_CENTER_CROPE: {
//                    // 以更短的为基准
//                    if (ratioView - ratio < 0){    // 屏幕比视频的宽高比更小.表示视频是过于宽屏了.
//                        // 宽为基准.
//                        this.getLayoutParams().height = ViewGroup.LayoutParams.MATCH_PARENT;
//                        this.getLayoutParams().width = (int) (getView().getHeight() * ratio+ 0.5f);
//                    }else{                          // 视频是竖屏了.
//                        this.getLayoutParams().width = ViewGroup.LayoutParams.MATCH_PARENT;
//                        this.getLayoutParams().height = (int) (getView().getWidth() / ratio+ 0.5f);
//                    }
//                }
//                break;
//                case FILL_WINDOW:{
//                    this.getLayoutParams().height = ViewGroup.LayoutParams.MATCH_PARENT;
//                    this.getLayoutParams().width = ViewGroup.LayoutParams.MATCH_PARENT;
//                }
//                break;
//            }
//        }
//        this.requestLayout();
//    }
}
