package com.example.baseproject.ui.fragment.xinshi;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.baseproject.R;
import com.example.baseproject.adapter.MoreAdapter;
import com.example.baseproject.adapter.XinshiAdapter;
import com.example.baseproject.enity.XinshiBean;
import com.example.baseproject.eventbus.MessageEvent;
import com.example.baseproject.mvp.ui.base.BaseFragment;
import com.qmuiteam.qmui.widget.QMUITopBar;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MoreFragment extends BaseFragment {

    @BindView(R.id.mtopbar) QMUITopBar mtopbar;
    @BindView(R.id.recyclerview) RecyclerView recyclerview;
    private List<XinshiBean> xinshiBeans;
    private MoreAdapter moreAdapter;
    @Override
    protected View onCreateView() {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_more, null);
        ButterKnife.bind(this, view);
        xinshiBeans = new ArrayList<>();
        xinshiBeans.add(new XinshiBean("缓解抑郁", "只要不放弃，就永远有希望在", "huanjie.json", R.drawable.huanjieyuyi, "huanjienew.json", 1224));
        xinshiBeans.add(new XinshiBean("婚恋挽回", "爱若如水，就别让爱覆水难收", "hunlianwanhui.json", R.drawable.huanlianwanhui, "hunlianwanhuinew.json", 8575));
        xinshiBeans.add(new XinshiBean("减轻焦虑", "克服焦虑，才能做生活的主人", "jianlue.json", R.drawable.jianqingjiaolue, "jianluenew.json", 6636));
        xinshiBeans.add(new XinshiBean("脱离性瘾", "凡事需有度，成瘾就不好了", "jiantuoxingyin.json", R.drawable.tuolixingyin, "jiantuoxingyinnew.json", 2345));
        xinshiBeans.add(new XinshiBean("改变自卑", "自卑的同时必然伴随着超越的力量", "gaibianzibei.json", R.drawable.gaibianzibei, "gaibianzibeinew.json", 4255));
        xinshiBeans.add(new XinshiBean("脱单攻略", "单身可以是一种选择，但不是被迫选择", "tuodangonglue.json", R.drawable.tuodangonglue, "tuodangongluenew.json", 6554));
        xinshiBeans.add(new XinshiBean("同性恋", "真爱的世界不分性别", "tongxinglian.json", R.drawable.tongxinglian, "tongxingliannew.json", 5535));
        xinshiBeans.add(new XinshiBean("争吵分析", "争吵是分歧，也是提升关系的机遇", "zhengcaofenxi.json", R.drawable.zhengchaofenxi, "zhengcaofenxinew.json", 4635));
        xinshiBeans.add(new XinshiBean("婆媳关系", "念好这本难念的经，是一种处世智慧", "poxiguanxi.json", R.drawable.poxiguanxi, "poxiguanxinew.json", 2689));
        xinshiBeans.add(new XinshiBean("问题小孩", "被视为有问题的小孩可能有巨大的潜能", "wentixiaohai.json", R.drawable.wentixiaohai, "wentixiaohainew.json", 9743));
        xinshiBeans.add(new XinshiBean("父母冲突", "每一个成长中的我们都绕不开父母的关心", "fuwuchongtu.json", R.drawable.fumuchongtu, "fuwuchongtunew.json", 5432));
        xinshiBeans.add(new XinshiBean("胜退小三", "在爱情的争夺中，掌握充分的主动权", "shengtuixiaosan.json", R.drawable.shengtuixiaosan, "fuwuchongtunew.json", 6432));
        setTopbar(mtopbar,"心事圈列表");
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(staggeredGridLayoutManager);
        moreAdapter = new MoreAdapter(xinshiBeans);
        recyclerview.setAdapter(moreAdapter);
        moreAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Bundle bundle=new Bundle();
                first=moreAdapter.getData().get(position).getJingxuan();
                two=moreAdapter.getData().get(position).getNewxuan();
                EventBus.getDefault().postSticky(new MessageEvent(first,two));
                bundle.putSerializable("all",moreAdapter.getData().get(position));
                XinshiDetailFragment xinshiDetailFragment=new XinshiDetailFragment();
                xinshiDetailFragment.setArguments(bundle);
                startFragment(xinshiDetailFragment);
            }
        });
        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
