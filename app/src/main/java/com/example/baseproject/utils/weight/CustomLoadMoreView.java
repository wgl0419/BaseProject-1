package com.example.baseproject.utils.weight;

import com.chad.library.adapter.base.loadmore.LoadMoreView;
import com.example.baseproject.R;

/**
 * Created by Administrator on 2018/7/31/031.
 */

public final class CustomLoadMoreView extends LoadMoreView {


//        @Override public int getLayoutId() {
//            return R.layout.view_load_mor;
//        }
//
//        /**
//         * 如果返回true，数据全部加载完毕后会隐藏加载更多
//         * 如果返回false，数据全部加载完毕后会显示getLoadEndViewId()布局
//         */
//        @Override public boolean isLoadEndGone() {
//            return true;
//        }
//
//        @Override protected int getLoadingViewId() {
//            return R.id.load_more_loading_view;
//        }
//
//        @Override protected int getLoadFailViewId() {
//            return R.id.load_more_load_fail_view;
//        }
//
//        /**
//         * isLoadEndGone()为true，可以返回0
//         * isLoadEndGone()为false，不能返回0
//         */
//        @Override protected int getLoadEndViewId() {
//            return 0;
//        }

    @Override public int getLayoutId() {
        return R.layout.view_load_mor;
    }

    @Override protected int getLoadingViewId() {
        return R.id.load_more_loading_view;
    }

    @Override protected int getLoadFailViewId() {
        return R.id.load_more_load_fail_view;
    }

    @Override protected int getLoadEndViewId() {
        return R.id.load_more_load_end_view;
    }
}
