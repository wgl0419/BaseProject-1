package com.example.baseproject.ui.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.example.baseproject.MainActivity;
import com.example.baseproject.db.CommentBean;
import com.example.baseproject.db.CommentBeanDao;
import com.example.baseproject.db.CommentController;
import com.example.baseproject.db.GreenDaoManager;
import com.example.baseproject.db.ZhuboBean;
import com.example.baseproject.db.ZhuboBeanDao;
import com.example.baseproject.db.ZhuboController;
import com.example.baseproject.utils.utils.ShareUtils;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;

/**
 * @author Ambrose
 * @date 2019/1/17 7:24 PM
 * @desc
 */
public class WelcomeActivity extends AppCompatActivity {

    private List<CommentBean> commentBeans;
    private List<ZhuboBean> zhuboBeans;
    private CommentController commentController;
    private ZhuboController zhuboController;

    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        commentController = CommentController.getInstance();
        commentBeans = GreenDaoManager.getInstance().getSession().getCommentBeanDao().queryBuilder()
                .offset(0)
                .limit(300)
                .orderAsc(CommentBeanDao.Properties.Id)
                .build()
                .list();
        zhuboController = ZhuboController.getInstance();
        zhuboBeans = GreenDaoManager.getInstance().getSession().getZhuboBeanDao().queryBuilder()
                .offset(0)
                .limit(300)
                .orderAsc(ZhuboBeanDao.Properties.Id)
                .build()
                .list();
        init();
        initt();
        Observable.timer(0, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        if (ShareUtils.getString(ShareUtils.USER_HEAD_URI, "") != "") {
                            Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        } else {
                            Intent intent = new Intent(WelcomeActivity.this, LoginActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                });
    }

    private void init() {
        if (commentBeans.size() == 0) {
            commentController.insert(new CommentBean(null, "对于没有大学时光的我来说，大学时光真的是很美好的呢！", "https://img1.doubanio.com/icon/up4471882-8.jpg", "桃之夭夭", 11, 49, "2019-01-03", "福建师范大学"));
            commentController.insert(new CommentBean(null, "大学时光是人一生中最美好的时光", "https://img3.doubanio.com/icon/up17230404-2.jpg", "美好时光", 4, 41, "2019-01-05", "南京大学"));
            commentController.insert(new CommentBean(null, "大学虽说是进入社会前最后的象牙塔，但也不能浑浑噩噩度日，文章很好共勉！", "https://img3.doubanio.com/icon/up1142805-1.jpg", "777", 5, 171, "2019-01-24", "江西理工大学"));
            commentController.insert(new CommentBean(null, "珍惜大学四年的时光，珍惜它带给你的不一样的经历和体会", "https://img3.doubanio.com/icon/up33191425-6.jpg", "吃货软妹纸", 2, 146, "2019-01-27", "吉林师范大学"));
            commentController.insert(new CommentBean(null, "颓废的大二🐶", "https://img3.doubanio.com/icon/up34617039-5.jpg", "林深鹿", 2, 79, "2019-01-18", "福建师范大学"));
            commentController.insert(new CommentBean(null, "大学生活说短也短，且行且珍惜吧", "https://img3.doubanio.com/icon/up62351295-3.jpg", "星星677", 7, 28, "2019-01-07", "西藏警官高等"));
            commentController.insert(new CommentBean(null, "大学时光确实是最美的时光，青春的记忆", "https://img3.doubanio.com/icon/up64182744-4.jpg", "烟火女子", 5, 22, "2019-01-11", "中南民族大学"));
            commentController.insert(new CommentBean(null, "多少人是大学毕业之后进入社会工作，才开始后悔当初光阴的虚度", "https://img3.doubanio.com/icon/up3745630-4.jpg", "放逐自己任天涯", 9, 105, "2019-01-12", "武汉大学"));
            commentController.insert(new CommentBean(null, "大学时光真的美好 现在上班真的辛苦", "https://img3.doubanio.com/icon/up65655264-2.jpg", "二见钟情", 2, 79, "2019-01-06", "河南科技大学"));
            commentController.insert(new CommentBean(null, "别说大学生活了，现在好后悔当初没有好好享受自己的大学生活呀", "https://img3.doubanio.com/icon/up1120907-2.jpg", "脆竹", 9, 40, "2019-01-21", "山西师范大学"));
            commentController.insert(new CommentBean(null, "怀念大学时光啊！！", "https://img3.doubanio.com/icon/up50952900-5.jpg", "小和尚讲故事", 8, 169, "2019-01-19", "湖南科技大学"));
            commentController.insert(new CommentBean(null, "大学时光值得珍惜", "https://img3.doubanio.com/icon/up66408263-3.jpg", "南笙北稚", 12, 88, "2019-01-09", "延安大学"));
            commentController.insert(new CommentBean(null, "大学时光挺美好的 不过也得看个人选择如何度过 鸡汤共勉吧", "https://img3.doubanio.com/icon/up55293977-1.jpg", "且惜YK", 9, 46, "2019-01-16", "安徽师范大学"));
            commentController.insert(new CommentBean(null, "一样颓废的大三🐶", "https://img3.doubanio.com/icon/up62351295-3.jpg", "星星677", 5, 59, "2019-01-04", "塔里木大学"));
            commentController.insert(new CommentBean(null, "不同的人，不同的环境，感觉大学学到的还是挺多的", "https://img1.doubanio.com/icon/up2680159-7.jpg", "夏目", 3, 166, "2019-01-12", "西华大学"));
            commentController.insert(new CommentBean(null, "赞同", "https://img3.doubanio.com/icon/up3196484-4.jpg", "或许不是你", 11, 32, "2019-01-27", "广西医科大学"));
            commentController.insert(new CommentBean(null, "我还没毕业，所以我要珍惜大学生活，让自己的以后不后悔", "https://img3.doubanio.com/icon/up66408263-3.jpg", "南笙北稚", 8, 73, "2019-01-09", "江西理工大学"));
            commentController.insert(new CommentBean(null, "哈哈，后悔也没有用了，好好过好现在的生活吧。", "https://img3.doubanio.com/icon/up122251431-11.jpg", "行走的荷尔蒙", 10, 120, "2019-01-02", "安徽理工大学"));
            commentController.insert(new CommentBean(null, "说的太对了。", "https://img3.doubanio.com/icon/up53630814-1.jpg", "大耳朵图图", 7, 59, "2019-01-01", "河北高校"));
            commentController.insert(new CommentBean(null, "可惜我没上过，有机会想去体验一下", "https://img3.doubanio.com/icon/up9097703-1.jpg", "仙女味的可可", 4, 88, "2019-01-01", "新疆师范大学"));
            commentController.insert(new CommentBean(null, "大学就是我们与社会接触的过渡时期，也是人生最美好的时期，所以我们要好好抓住时间，提升自己！", "https://img3.doubanio.com/icon/up28318300-6.jpg", "M鹿M", 10, 183, "2019-01-17", "江南大学"));
            commentController.insert(new CommentBean(null, "如果我当初也看到这样的文章，大学生活中应该会少了不少遗憾", "https://img3.doubanio.com/icon/up4746835-5.jpg", "大胡子", 6, 93, "2019-01-19", "长春理工大学"));
            commentController.insert(new CommentBean(null, "是这样的 一起努力吧", "https://img1.doubanio.com/icon/up4736000-7.jpg", "海未深", 9, 194, "2019-01-08", "安徽工业大学"));
            commentController.insert(new CommentBean(null, "回忆最珍贵 珍惜", "https://img3.doubanio.com/icon/up37427304-3.jpg", "z肤浅失眠中c", 8, 167, "2019-01-23", "中国计量学院"));
            commentController.insert(new CommentBean(null, "大学比真正的社会稍微单纯一点", "https://img3.doubanio.com/icon/up28318300-6.jpg", "M鹿M", 9, 77, "2019-01-18", "深圳大学"));
            commentController.insert(new CommentBean(null, "我觉得好好的去体会一切，好好谈场恋爱，好好修一门课，参加各种社团活动才算不虚度", "https://img1.doubanio.com/icon/up50241755-7.jpg", "糯米糍", 9, 56, "2019-01-05", "贵州大学"));
            commentController.insert(new CommentBean(null, "如果还有大学时光，我想用来提高自己，丰富知识，提高能力，多参加活动，积累资本！", "https://img3.doubanio.com/icon/up4529464-5.jpg", "forest", 4, 82, "2019-01-10", "河南工业大学"));
            commentController.insert(new CommentBean(null, "赞同，大学里无论爱情还是友谊都是最纯真的", "https://img3.doubanio.com/icon/up52111273-1.jpg", "白小纯", 4, 101, "2019-01-26", "复旦大学"));
            commentController.insert(new CommentBean(null, "多读书，充实自己", "https://img3.doubanio.com/icon/up50720395-4.jpg", "柠檬豆豆~", 2, 170, "2019-01-17", "黑龙江大学"));
            commentController.insert(new CommentBean(null, "是的呢，每一段旅程都有它存在的价值，让生活变得具有价值才好。", "https://img3.doubanio.com/icon/up1774878-6.jpg", "米小米", 5, 158, "2019-01-25", "电子科技大学"));
            commentController.insert(new CommentBean(null, "人都是因为没有才会想要", "https://img1.doubanio.com/icon/up50241755-7.jpg", "糯米糍", 8, 96, "2019-01-27", "中南大学"));
            commentController.insert(new CommentBean(null, "大学自己的时间很多 应该找些有趣的事情 有必要的事情做 作者说的蛮细的从家庭环境入手很值得称赞", "https://img3.doubanio.com/icon/up54978308-1.jpg", "poison", 8, 93, "2019-01-09", "西北工业大学"));
            commentController.insert(new CommentBean(null, "上大学，是一个回忆，怀恋", "https://img3.doubanio.com/icon/up30692637-4.jpg", "柯柯欧尼酱", 10, 63, "2019-01-16", "西藏大学"));
            commentController.insert(new CommentBean(null, "1大三狗表示被戳中了膝盖。都说到点子上了但是我就是做不到啊(*꒦ິ⌓꒦ີ)", "https://img3.doubanio.com/icon/up2944588-4.jpg", "Tonn", 10, 143, "2019-01-18", "暨南大学"));
            commentController.insert(new CommentBean(null, "现在正在读大二，跟舍友合伙开打印店，感觉生活充实了不少。", "https://img3.doubanio.com/icon/up3196484-4.jpg", "或许不是你", 6, 68, "2019-01-25", "延安大学"));
            commentController.insert(new CommentBean(null, "距离大学毕业还有两年，要好好珍惜这短暂的时光啊", "https://img3.doubanio.com/icon/up62647662-1.jpg", "啊咧咧💦", 9, 131, "2019-01-14", "北京理工大学"));
            commentController.insert(new CommentBean(null, "是的，多看看书，多经历一些，交真心朋友！", "https://img3.doubanio.com/icon/up4529464-5.jpg", "forest", 13, 54, "2019-01-08", "佳木斯大学"));
            commentController.insert(new CommentBean(null, "是啊，大学的时候想着玩玩玩，吃吃吃，工作了就开始后悔为什么当初没有学点什么。。", "https://img3.doubanio.com/icon/up44895292-1.jpg", "整什么幺蛾子", 13, 86, "2019-01-05", "南京大学"));
            commentController.insert(new CommentBean(null, "真羡慕你啊，好好珍惜", "https://img3.doubanio.com/icon/up4529464-5.jpg", "forest", 5, 91, "2019-01-22", "电子科技大学"));
            commentController.insert(new CommentBean(null, "大学的时间很多，我也努力过，做过一些有意义的事，但是大多荒废了，我会珍惜剩下的时间", "https://img3.doubanio.com/icon/up56262255-1.jpg", "逃离色彩", 7, 59, "2019-01-13", "西藏警官高等"));
            commentController.insert(new CommentBean(null, "这是一个值得珍藏的记忆时光，希望学弟学妹们不要虚度吧", "https://img3.doubanio.com/icon/up1982564-2.jpg", "花开了", 2, 120, "2019-01-19", "华中师范大学"));
            commentController.insert(new CommentBean(null, "大学时光真的很美好 也是我们进入社会的一个过渡期 我们要珍惜 这篇文章写的挺好的", "https://img3.doubanio.com/icon/up44602979-2.jpg", "every", 8, 134, "2019-01-19", "黑龙江大学"));
            commentController.insert(new CommentBean(null, "在大学自己的规划有的时候也是败在了懒上", "https://img3.doubanio.com/icon/up44793620-2.jpg", "olivia", 6, 179, "2019-01-24", "塔里木大学"));
            commentController.insert(new CommentBean(null, "还在大学生活中 生活里还是会很有迷茫 在大学里过度好 是对我们步入社会最好的磨砺", "https://img3.doubanio.com/icon/up54978308-1.jpg", "poison", 9, 60, "2019-01-04", "武汉大学"));
            commentController.insert(new CommentBean(null, "赞同，我也会！", "https://img3.doubanio.com/icon/up4529464-5.jpg", "forest", 13, 200, "2019-01-06", "南开大学"));
            commentController.insert(new CommentBean(null, "大学的时光是非常好的 我们要好好珍惜大学的时光 ", "https://img3.doubanio.com/icon/up41469142-1.jpg", "清独", 11, 51, "2019-01-01", "西藏职业技术"));
            commentController.insert(new CommentBean(null, "大学就像一个炼丹炉 我们在里边不断磨练自己不断成长 才不枉这四年", "https://img3.doubanio.com/icon/up3230318-4.jpg", "FIRE", 7, 108, "2019-01-22", "海南政法学院"));
            commentController.insert(new CommentBean(null, "很羡慕别人的大学生活，那一段时光，是每个人一生当中最美好的时光！", "https://img3.doubanio.com/icon/up3817490-6.jpg", "灼灼桃花", 8, 101, "2019-01-04", "武汉大学"));
            commentController.insert(new CommentBean(null, "想到已经成为老学姐了就一阵心酸(つД`)，特别羡慕生活充实的人。", "https://img3.doubanio.com/icon/up2944588-4.jpg", "Tonn", 11, 30, "2019-01-02", "海南医学院"));
            commentController.insert(new CommentBean(null, "大学中起点定位很重要，虽然不想提阶级，可是只有认清自己，才能定好目标。其次，要多锻炼身体，还有，交际不要太偏社会化，要多学习，充实自己。", "https://img3.doubanio.com/icon/up45908698-1.jpg", "雨婷", 9, 106, "2019-01-01", "福建农林大学"));
            commentController.insert(new CommentBean(null, "是啊 后悔自己当时没好好过这几年", "https://img3.doubanio.com/icon/up150109429-4.jpg", "小白", 11, 24, "2019-01-14", "兰州理工大学"));
            commentController.insert(new CommentBean(null, "大学时光匆匆 珍惜时间享受青春 定", "https://img3.doubanio.com/icon/up3230318-4.jpg", "FIRE", 11, 102, "2019-01-09", "河南科技大学"));
            commentController.insert(new CommentBean(null, "若是在大一那会看到这篇文章的话，或许现在不会是这个样子吧，看完了好想把大学再重新上一遍，每天过的充充实实，而现在只能是珍惜这仅剩下的几个月了。趁这几个月再做一些改变", "https://img3.doubanio.com/icon/up58887521-4.jpg", "枭雄", 11, 73, "2019-01-11", "琼州学院"));
            commentController.insert(new CommentBean(null, "多读书，参加社团，活动，不要让自己的大学过得想一条咸鱼", "https://img3.doubanio.com/icon/up44895292-1.jpg", "整什么幺蛾子", 3, 143, "2019-01-25", "海口经济学院"));
            commentController.insert(new CommentBean(null, "理性看待阶层的差异，加强运动", "https://img3.doubanio.com/icon/up49967715-1.jpg", "samantha", 8, 71, "2019-01-13", "哈尔滨工业大"));
            commentController.insert(new CommentBean(null, "大学时光真的挺短的，不要虚度了，无论什么阶层都好，都要找到自己的目标，多点看书，不要随便逃课，以后才更有准备", "https://img3.doubanio.com/icon/up1841794-3.jpg", "金小手的首饰", 11, 152, "2019-01-24", "海南政法学院"));
            commentController.insert(new CommentBean(null, "对大三的我很有用，真的要更珍惜时间了。", "https://img3.doubanio.com/icon/up56550067-5.jpg", "帅萌小哥哥", 8, 168, "2019-01-27", "长春理工大学"));
            commentController.insert(new CommentBean(null, "最美时光 都在大学", "https://img3.doubanio.com/icon/up37427304-3.jpg", "z肤浅失眠中c", 5, 28, "2019-01-21", "合肥工业大学"));
            commentController.insert(new CommentBean(null, "楼主说得有道理，但我不赞同某些说法。读大学就在于解决第一条，消减差距。如果一开始就自己明确阶级，那对之后的人际关系与心理发展有影响。", "https://img3.doubanio.com/icon/up2583318-1.jpg", "酒窝被偷了", 4, 27, "2019-01-14", "河南农业大学"));
            commentController.insert(new CommentBean(null, "大学就应该充实自己 把该考的证件都考下来 对毕业有好处", "https://img3.doubanio.com/icon/up54978308-1.jpg", "poison", 10, 26, "2019-01-23", "哈尔滨工业大"));
            commentController.insert(new CommentBean(null, "大学不仅学专业知识还有人际交往等等 很有意思", "https://img3.doubanio.com/icon/up3230318-4.jpg", "FIRE", 9, 105, "2019-01-06", "大连大学"));
            commentController.insert(new CommentBean(null, "身为一个即将要毕业的大学生，小编说的这些真的都很对，大学时代美好我想我一辈子也不会忘记我的大学生活", "https://img3.doubanio.com/icon/up2559534-1.jpg", "依如你", 12, 125, "2019-01-01", "长安大学"));
            commentController.insert(new CommentBean(null, "现在大三了才开始后悔没有利用好自己的大学时光，好想重新来过。好好学习，好好锻炼身体，不把太多时间放在不必要的人和事身上，可惜，总是失去了才懂得！", "https://img3.doubanio.com/icon/up4671096-4.jpg", "步履不停", 3, 86, "2019-01-18", "兰州交通大学"));
            commentController.insert(new CommentBean(null, "楼主总结的很好啊，我是属于第一种家境普通的，确实根本没有资本用四年的时间去享受，对于我来说真的只有好好学习专业了，求毕了业能混个温饱吧", "https://img3.doubanio.com/icon/up43244684-2.jpg", "骑猪看夕阳", 11, 54, "2019-01-18", "西南大学"));
            commentController.insert(new CommentBean(null, "大学时光，就是一段让你适应社会的时光！要知道，大学，就是一个社会的雏形，你能在大学时候为以后步入社会做好很多准备！", "https://img3.doubanio.com/icon/up3088922-4.jpg", "灼灼其华", 8, 148, "2019-01-11", "湖南大学"));
            commentController.insert(new CommentBean(null, "一起加油吧，但是有很多时候还是身不由己", "https://img3.doubanio.com/icon/up58887521-4.jpg", "枭雄", 12, 134, "2019-01-22", "东北大学"));
            commentController.insert(new CommentBean(null, "对啊 所以一定要珍惜", "https://img3.doubanio.com/icon/up44602979-2.jpg", "every", 2, 144, "2019-01-13", "同济大学"));
            commentController.insert(new CommentBean(null, "对，好在我们都年轻，还能改变。", "https://img3.doubanio.com/icon/up2583318-1.jpg", "酒窝被偷了", 6, 196, "2019-01-20", "中国医科大学"));
            commentController.insert(new CommentBean(null, "无论是工作还是学习那种时光都不再有了", "https://img3.doubanio.com/icon/up54332974-3.jpg", "一个人的旅行", 3, 106, "2019-01-18", "西华大学"));
            commentController.insert(new CommentBean(null, "好好珍惜 会有不一样的体验的", "https://img3.doubanio.com/icon/up150109429-4.jpg", "小白", 10, 88, "2019-01-25", "西北民族大学"));
            commentController.insert(new CommentBean(null, "有了阶层意识，才会想要去缩小", "https://img3.doubanio.com/icon/up49967715-1.jpg", "samantha", 9, 72, "2019-01-23", "天津理工大学"));
            commentController.insert(new CommentBean(null, "趁我现在还在大学，要好好珍惜自己的大学时光！", "https://img3.doubanio.com/icon/up2859720-4.jpg", "猫巷少女", 12, 99, "2019-01-01", "中国美术学院"));
            commentController.insert(new CommentBean(null, "我和你有一样的感触，不会忘记！", "https://img3.doubanio.com/icon/up4671096-4.jpg", "步履不停", 10, 107, "2019-01-05", "山西财经大学"));
            commentController.insert(new CommentBean(null, "很快呀", "https://img3.doubanio.com/icon/up54332974-3.jpg", "一个人的旅行", 2, 35, "2019-01-08", "甘肃农业大学"));
            commentController.insert(new CommentBean(null, "有定位，有目标才活得清楚", "https://img1.doubanio.com/icon/up3348942-7.jpg", "Bow", 7, 156, "2019-01-01", "内蒙古师范大"));
            commentController.insert(new CommentBean(null, "是呀，珍惜", "https://img3.doubanio.com/icon/up64182744-4.jpg", "烟火女子", 3, 133, "2019-01-21", "山西师范大学"));
            commentController.insert(new CommentBean(null, "其实也是拖延症，很多事情逼到眼前了才去做", "https://img3.doubanio.com/icon/up1841794-3.jpg", "金小手的首饰", 2, 194, "2019-01-18", "西藏藏医学院"));
            commentController.insert(new CommentBean(null, "楼主总结的很好啊，我是属于第一种家境普通的，确实根本没有资本用四年的时间去享受，对于我来说真的只有好好学习专业了，求毕了业能混个温饱吧", "https://img3.doubanio.com/icon/up43244684-2.jpg", "骑猪看夕阳", 11, 109, "2019-01-17", "河北工业大学"));
            commentController.insert(new CommentBean(null, "如果可以，真的想回到大一的时候", "https://img3.doubanio.com/icon/up44895292-1.jpg", "整什么幺蛾子", 6, 69, "2019-01-07", "兰州交通大学"));
            commentController.insert(new CommentBean(null, "大一颓废了一年！！在床上挺尸", "https://img3.doubanio.com/icon/up45743359-2.jpg", "瓜瓜", 4, 57, "2019-01-16", "大连海事大学"));
            commentController.insert(new CommentBean(null, "没有错就是这样，趁着现在做出改变吧", "https://img3.doubanio.com/icon/up58887521-4.jpg", "枭雄", 6, 106, "2019-01-20", "河北师范大学"));
            commentController.insert(new CommentBean(null, "大学生活堪比一个小型社会，林子大了什么鸟都有，对于我们来说也是个磨练的机会。", "https://img3.doubanio.com/icon/up44923003-6.jpg", "大姑娘", 10, 119, "2019-01-01", "哈尔滨理工大"));
            commentController.insert(new CommentBean(null, "说的没错，一眨眼的功夫就度过了大学时光", "https://img3.doubanio.com/icon/up2559534-1.jpg", "依如你", 13, 159, "2019-01-15", "内蒙古农业大"));
            commentController.insert(new CommentBean(null, "大学时光感觉过的很快，一晃2年过去了，接下来一定更加努力，更加珍惜。", "https://img3.doubanio.com/icon/up3550737-3.jpg", "这就是我", 8, 34, "2019-01-19", "安徽理工大学"));
            commentController.insert(new CommentBean(null, "有最美的爱情，有最纯的友谊", "https://img3.doubanio.com/icon/up52111273-1.jpg", "白小纯", 3, 132, "2019-01-24", "四川师范大学"));
            commentController.insert(new CommentBean(null, "赞同", "https://img3.doubanio.com/icon/up41469142-1.jpg", "清独", 4, 183, "2019-01-17", "哈尔滨理工大"));
            commentController.insert(new CommentBean(null, "同感", "https://img3.doubanio.com/icon/up56550067-5.jpg", "帅萌小哥哥", 5, 170, "2019-01-09", "大连理工大学"));
            commentController.insert(new CommentBean(null, "还有3个月我就要告别校园生活了，珍惜这三个月的时光是最重要的", "https://img3.doubanio.com/icon/up53930706-5.jpg", "骑着神马找白马", 12, 63, "2019-01-06", "长春工业大学"));
            commentController.insert(new CommentBean(null, "大学四年其实真的很短，可以学到很多，也可以一无所获，且行且珍惜", "https://img1.doubanio.com/icon/up43226234-19.jpg", "小撒小白", 4, 173, "2019-01-22", "海口经济学院"));
            commentController.insert(new CommentBean(null, "我都有点后悔了 所以现在在最后的半年努力", "https://img3.doubanio.com/icon/up2559534-1.jpg", "依如你", 9, 33, "2019-01-12", "广西大学"));
            commentController.insert(new CommentBean(null, "上大学的那几年没有好好的学习现在后悔莫及", "https://img3.doubanio.com/icon/up164266033-1.jpg", "一缕阳光", 10, 103, "2019-01-06", "东南大学"));
            commentController.insert(new CommentBean(null, "作者总结的很好，回想起自己的大学时光，本着不虚度光阴的心，到头来才发现自己还是有些愧对自己的…", "https://img3.doubanio.com/icon/up1774878-6.jpg", "米小米", 4, 59, "2019-01-06", "中国医科大学"));
            commentController.insert(new CommentBean(null, "我并没有这么认为 消除差距并不应该是我们在大学做的事情 如果大学只挣到了钱 没有把专业课学好 那要毕业证有什么用呢 还不如先去打工 既然要学习 就是来学习知识的 表明阶级也没什么不好 你懂的自己家里的困境 懂得我们与他人的差距 就懂得更好的学习知识 充实自己", "https://img3.doubanio.com/icon/up54978308-1.jpg", "poison", 13, 154, "2019-01-14", "哈尔滨理工大"));
            commentController.insert(new CommentBean(null, "对呀 我哦的要珍惜", "https://img3.doubanio.com/icon/up41469142-1.jpg", "清独", 9, 56, "2019-01-15", "汕头大学"));
            commentController.insert(new CommentBean(null, "加油", "https://img3.doubanio.com/icon/up4746835-5.jpg", "大胡子", 3, 102, "2019-01-09", "福建师范大学"));
            commentController.insert(new CommentBean(null, "嗯，确实，大学时光是真的快乐啊。", "https://img3.doubanio.com/icon/up2583318-1.jpg", "酒窝被偷了", 12, 151, "2019-01-25", "天水师范学院上海交通大学"));
            commentController.insert(new CommentBean(null, "大学是个提升和认清自己的几年 好好珍惜 会有特别的收货的", "https://img3.doubanio.com/icon/up150113708-4.jpg", "稻香", 12, 59, "2019-01-24", "深圳大学"));
            commentController.insert(new CommentBean(null, "我都毕业了，看着幡然醒悟又在惋惜", "https://img1.doubanio.com/icon/up43226234-19.jpg", "小发放白", 13, 140, "2019-01-27", "河南大学"));
            commentController.insert(new CommentBean(null, "我觉得大学时光看似美好，其实如果要有出息的话也没那么轻松啦", "https://img3.doubanio.com/icon/up43244684-2.jpg", "骑猪看夕阳", 7, 26, "2019-01-14", "天津师范大学"));
            commentController.insert(new CommentBean(null, "时间不多更要珍惜 只要过好剩下的大学时间 大学一样不虚度", "https://img3.doubanio.com/icon/up44602979-2.jpg", "every", 9, 178, "2019-01-09", "琼州学院"));
            commentController.insert(new CommentBean(null, "对的！其实在大学如果充分利用好时间可以学到很多", "https://img3.doubanio.com/icon/up45743359-2.jpg", "瓜瓜", 3, 83, "2019-01-05", "哈尔滨工业大"));
            commentController.insert(new CommentBean(null, "共勉+1进入社会也不要忘了丰富自己", "https://img3.doubanio.com/icon/up44895292-1.jpg", "整什么幺蛾子", 5, 106, "2019-01-04", "华东交通大学"));
            commentController.insert(new CommentBean(null, "大学是步入社会的最后一步", "https://img3.doubanio.com/icon/up49967715-1.jpg", "samantha", 8, 165, "2019-01-15", "延边大学"));
            commentController.insert(new CommentBean(null, "扎Zn了老Fe😂😂😂", "https://img3.doubanio.com/icon/up165766458-1.jpg", "Cannocannocan", 4, 128, "2019-01-04", "华东师范大学"));
            commentController.insert(new CommentBean(null, "最后一年还来得及", "https://img1.doubanio.com/icon/up43226234-19.jpg", "小小白", 9, 34, "2019-01-20", "内蒙古工业大"));
            commentController.insert(new CommentBean(null, "说的挺好的，大二狗，准备考研但是现在没什么目标还有点迷茫，干了这碗鸡汤去背单词准备四级啦。", "https://img3.doubanio.com/icon/up78675144-4.jpg", "行歌", 13, 72, "2019-01-10", "北京理工大学"));
            commentController.insert(new CommentBean(null, "我们应该趁现在还在学校学习，多想想未来要做什么，并向自己的目标努力，现在处于大二的我更要珍惜大学的时光", "https://img3.doubanio.com/icon/up4532609-2.jpg", "one！", 4, 199, "2019-01-03", "延边大学"));
            commentController.insert(new CommentBean(null, "努力加油，珍惜大学时光", "https://img3.doubanio.com/icon/up38587215-3.jpg", "明年打老虎", 8, 136, "2019-01-09", "吉林师范大学"));
            commentController.insert(new CommentBean(null, "日子太好混了，四年过去才发现没有好好学到什么", "https://img3.doubanio.com/icon/up154674864-1.jpg", "吕优秀", 3, 150, "2019-01-02", "吉林大学"));
            commentController.insert(new CommentBean(null, "是啊，家境普通就只能靠自己拼搏了", "https://img3.doubanio.com/icon/up1841794-3.jpg", "金小手的首饰", 4, 167, "2019-01-11", "哈尔滨工程大"));
            commentController.insert(new CommentBean(null, "我没有上过大学，对大学还是有种憧憬的。不过听别人说，大学生活好混乱。", "https://img3.doubanio.com/icon/up38852281-6.jpg", "安筱冉", 8, 141, "2019-01-15", "长春工业大学"));
            commentController.insert(new CommentBean(null, "保持一个好心态 在大学里丰富自己的内心世界 ", "https://img3.doubanio.com/icon/up3615494-2.jpg", "积攒一身酷", 6, 103, "2019-01-23", "福建农林大学"));
            commentController.insert(new CommentBean(null, "很容易就颓废了，一定要坚持，不要随波逐流，要追寻自己的梦想", "https://img3.doubanio.com/icon/up3550737-3.jpg", "这就是我", 2, 84, "2019-01-20", "中国医科大学"));
            commentController.insert(new CommentBean(null, "是呀，珍惜这最美好的时光", "https://img3.doubanio.com/icon/up2469970-3.jpg", "西贝卡路", 10, 153, "2019-01-07", "延边大学"));
            commentController.insert(new CommentBean(null, "现在都有这种感觉了，抓住大学时间的尾巴～", "https://img3.doubanio.com/icon/up4671096-4.jpg", "步履不停", 12, 112, "2019-01-24", "天津工业大学"));
            commentController.insert(new CommentBean(null, "加一_(:з」∠)_在宿舍呆的时间最久了", "https://img3.doubanio.com/icon/up78675144-4.jpg", "行歌", 9, 80, "2019-01-15", "海南师范大学"));
            commentController.insert(new CommentBean(null, "同感啊！感觉自己白白浪费了三年…", "https://img3.doubanio.com/icon/up1774878-6.jpg", "米小米", 10, 65, "2019-01-14", "中国科学技术"));
            commentController.insert(new CommentBean(null, "继续加油哦 哈哈", "https://img3.doubanio.com/icon/up54332974-3.jpg", "一个人的旅行", 2, 162, "2019-01-26", "天津师范大学"));
            commentController.insert(new CommentBean(null, "可是人总要过去了才懂得珍惜", "https://img3.doubanio.com/icon/up49967715-1.jpg", "samantha", 9, 168, "2019-01-26", "内蒙古民族大"));
            commentController.insert(new CommentBean(null, "都是看个人的，无论什么大学都是有好有坏，所以自己要有底线", "https://img3.doubanio.com/icon/up1841794-3.jpg", "金小手的首饰", 10, 90, "2019-01-16", "华东理工大学"));
            commentController.insert(new CommentBean(null, "对于正处于大三的我，大学都过完一半了，才知道自己想要干什么，其实大学真的是一定要想好，你考大学是干嘛的，不要虚度了时光", "https://img3.doubanio.com/icon/up52346930-1.jpg", "七月", 8, 36, "2019-01-14", "西华大学"));
            commentController.insert(new CommentBean(null, "说的对 大学就是一个小型社会 我们在大学里会收获很多东西", "https://img3.doubanio.com/icon/up44602979-2.jpg", "every", 8, 110, "2019-01-27", "内蒙古农业大"));
            commentController.insert(new CommentBean(null, "努力吧，趁还有时间。", "https://img3.doubanio.com/icon/up56550067-5.jpg", "帅萌小哥哥", 11, 140, "2019-01-15", "吉林高校"));
            commentController.insert(new CommentBean(null, "珍惜 眼前 享受生活吧 大学最美的时光", "https://img3.doubanio.com/icon/up164265934-1.jpg", "纷纷飘天下", 12, 172, "2019-01-27", "南华大学"));
            commentController.insert(new CommentBean(null, "想想自己就过了三年的咸鱼🐠心口疼", "https://img3.doubanio.com/icon/up44923003-6.jpg", "大姑娘", 6, 127, "2019-01-27", "内蒙古师范大"));
            commentController.insert(new CommentBean(null, "对，大学时光一辈子最美好的记忆！", "https://img3.doubanio.com/icon/up2859720-4.jpg", "猫巷少女", 8, 142, "2019-01-21", "同济大学"));
        }
    }

    private void initt() {
        if (zhuboBeans.size() == 0) {
//            zhuboController.insert(new ZhuboBean("1 ","吉林省", "延边", "安琪MoMo", "你知道我在等你嘛。。。", "103982400", "https://i4.cdn.xiongmaoxingyan.com/2f7edb88bde620280eb9bd2de365e0b4_w960_h960.jpeg", "购物", "20", "文艺少女", "Shape of my heart", "熊猫直播", "白羊座", "1786000"));
            zhuboController.insert(new ZhuboBean(null, "5", "吉林省", "延边", "兔牙不兔牙", "迟到了", "145834202", "https://i1.cdn.xiongmaoxingyan.com/12c5ac8c3cca9301150e53b3a399d543_w960_h960.jpeg", "吃喝拉睡", 20, "安静", "Scarborough fair", "斗鱼直播", "白羊座", 178740, "高颜值", "科比"));
            zhuboController.insert(new ZhuboBean(null, "6", "湖南省", "长沙", "鱼骨头是个新主播", "主播离你100米", "158650964", "https://i2.cdn.xiongmaoxingyan.com/67e0517af447d978f60b0e598c4abcdc_w960_h960.jpeg", "电影", 20, "喜欢简单", "Seasons in the sun", "斗鱼直播", "狮子座", 1876700, "高颜值", "科比"));
            zhuboController.insert(new ZhuboBean(null, "7", "川省", "成都", "小丸砸啊", "1", "128896478", "https://i0.cdn.xiongmaoxingyan.com/a4e5178890b63ef062316134ea414155_w960_h960.jpeg", "听歌", 24, "厚道", "Larger than life", "斗鱼直播", "白羊座", 96780, "高颜值", "科比"));
            zhuboController.insert(new ZhuboBean(null, "8", "川省", "成都", "小人物哥呀", "年度现场瞅瞅", "80275156", "https://image.xingyan.panda.tv/469281ef99a2a662317b29bf220fcfd9.jpeg", "听歌", 27, "大叔控", "All rise", "斗鱼直播", "白羊座", 134343, "高颜值", "科比"));
            zhuboController.insert(new ZhuboBean(null, "9", "重庆市", "重庆", "雨妹酱吖", "你吃火锅我吃火锅底料", "94319888", "https://i1.cdn.xiongmaoxingyan.com/9f950818cd12f13e5e0cdde0f7f0c797_w960_h960.jpeg", "煮饭", 23, "宅", "hero", "斗鱼直播", "狮子座", 187600, "好才艺", "科比"));
            zhuboController.insert(new ZhuboBean(null, "10", "安徽省", "芜湖", "晓晓芬", "", "154084172", "https://i4.cdn.xiongmaoxingyan.com/bc2a8950fce43c7194c7c63bbb542c49_w960_h960.jpeg", "逛街", 22, "厚道", "Shape of my heart", "熊猫直播", "白羊座", 137800, "好才艺", "科比"));
            zhuboController.insert(new ZhuboBean(null, "11", "山东省", "济宁", "朵朵有毒", "没人疼的小白菜", "153855938", "https://i4.cdn.xiongmaoxingyan.com/29d7322c97c6465d67a2a6a888c84cae_w960_h960.jpeg", "购物", 22, "吃货", "Bye bye bye", "熊猫直播", "双子座", 13783, "好才艺", "科比"));
            zhuboController.insert(new ZhuboBean(null, "12", "江西省", "抚州", "小诗敏mua", "Time is a thief ", "157415692", "https://i2.cdn.xiongmaoxingyan.com/e7cc47c5201f89beb6596027b2d4a900_w960_h960.jpeg", "参加公益", 22, "讲义气", "Without you", "熊猫直播", "狮子座", 1378378, "好才艺", "科比"));
            zhuboController.insert(new ZhuboBean(null, "13", "河北省", "秦皇岛", "颖墨_心颖不离", "新人第二天请多关照", "99310580", "https://i4.cdn.xiongmaoxingyan.com/a524ef63df1ec363fa16744ab617963a_w960_h960.jpeg", "热爱化妆", 22, "长发及腰", "Here i am", "熊猫直播", "白羊座", 37830, "好才艺", "科比"));
            zhuboController.insert(new ZhuboBean(null, "14", "黑龙江省", "大庆", "是寿齐丫", "尽力讨好每一个人！", "135752686", "https://image.xingyan.panda.tv/a85a4cc58292e93ca0a08bcfde189aae_w960_h960.jpeg", "爱追剧", 22, "双重人格", "The day you went away", "熊猫直播", "狮子座", 178377, "搞笑达人", "科比"));
            zhuboController.insert(new ZhuboBean(null, "15", "云南省", "昆明", "雅ViVi", "跪求守护！", "110156056", "https://i.h2.pdim.gs/7640e486e747d44552203d5cd59ba895.jpeg", "热爱化妆", 25, "理想主义", "Only love", "熊猫直播", "狮子座", 15872, "搞笑达人", "科比"));
            zhuboController.insert(new ZhuboBean(null, "16", "辽宁省", "沈阳", "兔子长大了_", "甭管什么东西 盘他", "155272882", "https://i2.cdn.xiongmaoxingyan.com/b55d01f4ba7af5191148ee4f14f56c71_w960_h960.jpeg", "购物", 25, "吃货", "Thank you", "熊猫直播", "金牛座", 1353430, "搞笑达人", "科比"));
            zhuboController.insert(new ZhuboBean(null, "17", "福建省", "厦门", "喵璐琪", "ψ(｀∇´)ψ", "121136952", "https://i2.cdn.xiongmaoxingyan.com/0b8e0881e1f56a3aefceb5b06f710984_w960_h960.jpeg", "热爱化妆", 27, "厚道", "my love", "熊猫直播", "处女座", 34530, "搞笑达人", "科比"));
            zhuboController.insert(new ZhuboBean(null, "18", "新疆维吾尔自治区", "新疆", "甜菜妹儿", "一眼见你，万物不及", "151621210", "https://i4.cdn.xiongmaoxingyan.com/c795cf0641145a66ad1d563dea16e7f4_w960_h960.jpeg", "购物", 28, "理想主义", "God is a girl", "熊猫直播", "狮子座", 453600, "搞笑达人", "科比"));
            zhuboController.insert(new ZhuboBean(null, "19", "辽宁省", "沈阳", "东gg_", "元气满满", "157551194", "https://i4.cdn.xiongmaoxingyan.com/29c9e93ea0b1fa9f8a071a9c62b38186_w960_h960.jpeg", "打游戏", 30, "安静", "I want it that way", "熊猫直播", "狮子座", 18760, "搞笑达人", "科比"));
            zhuboController.insert(new ZhuboBean(null, "20", "辽宁省", "沈阳", "宠着阿木木呀", "别谈诗和远方，说你爱我就对了", "151268056", "https://i2.cdn.xiongmaoxingyan.com/d03f52a87753c6060ca3130d39b54a67_w960_h960.jpeg", "爱追剧", 25, "双重人格", "Shape of my heart", "斗鱼直播", "狮子座", 13783780, "搞笑达人", "科比"));
            zhuboController.insert(new ZhuboBean(null, "21", "安徽省", "六安", "星辰杨超越", "新人需要陪伴", "95953906", "https://i4.cdn.xiongmaoxingyan.com/064204e5c311cf15ec7ae9909efaaa9d_w960_h960.jpeg", "逛街", 22, "宅", "Yesterday once more", "熊猫直播", "处女座", 17837, "搞笑达人", "科比"));
            zhuboController.insert(new ZhuboBean(null, "22", "重庆市", "重庆", "一朵可爱的花儿i", "回收二手大哥", "152700602", "https://i3.cdn.xiongmaoxingyan.com/ef75b9420feff3cb243e1cb3720f7281_w960_h960.jpeg", "运动", 22, "喜欢简单", "my love", "熊猫直播", "处女座", 13783783, "搞笑达人", "科比"));
            zhuboController.insert(new ZhuboBean(null, "23", "重庆市", "重庆", "小小乔x", "帮忙占占日榜嘛", "113903330", "https://image.xingyan.panda.tv/d797268c66d0a5bb2e65e7c8d6c20f31_w960_h960.jpeg", "爱追剧", 25, "叫我逗逼", "Cry on my shoulder", "斗鱼直播", "处女座", 163783, "搞笑达人", "科比"));
            zhuboController.insert(new ZhuboBean(null, "24", "黑龙江省", "绥化", "小臭臭长大了_", "凉凉主播求升级", "157687474", "https://i4.cdn.xiongmaoxingyan.com/e2bf8512f54cca1b6508ddd32f3051d6_w960_h960.jpeg", "画画", 25, "叫我逗逼", "Seasons in the sun", "斗鱼直播", "狮子座", 378378, "搞笑达人", "科比"));
            zhuboController.insert(new ZhuboBean(null, "25", "辽宁省", "沈阳", "你的Viki小可爱_", "今天满两个月啦 谢谢大家一路走来的支", "156037646", "https://i1.cdn.xiongmaoxingyan.com/c199919d380f32510d0c122080fa1766_w960_h960.jpeg", "K歌", 19, "安静", "We will rock you", "熊猫直播", "狮子座", 387343, "搞笑达人", "科比"));
            zhuboController.insert(new ZhuboBean(null, "26", "福建省", "厦门", "是你的小脑斧呀", "想要住进你心里", "156584670", "https://i4.cdn.xiongmaoxingyan.com/f0367bc26fd476a05a6f6de51081d26f_w960_h960.jpeg", "热爱化妆", 18, "靠谱", "Hotel california", "斗鱼直播", "双子座", 1635400, "搞笑达人", "科比"));
            zhuboController.insert(new ZhuboBean(null, "27", "福建省", "厦门", "软软是暴力范_", "有没有人来守护我~", "86739180", "https://i3.cdn.xiongmaoxingyan.com/360b931bd428f660b2a4d5bc20385d0e_w960_h960.jpeg", "逛街", 22, "萌萌哒", "Right here waiting", "斗鱼直播", "双子座", 13540, "搞笑达人", "科比"));
            zhuboController.insert(new ZhuboBean(null, "28", "湖南省", "长沙", "六一团子", "怎样的标题才可以吸引到你", "158407572", "https://i1.cdn.xiongmaoxingyan.com/e9c3dcd8eaaf7767a276cc23ad44cafb_w960_h960.jpeg", "逛街", 26, "强迫症", "Cry on my shoulder", "斗鱼直播", "狮子座", 1634530, "搞笑达人", "科比"));
            zhuboController.insert(new ZhuboBean(null, "29", "山东省", "淄博", "小北爱喝冰阔落", "小北距离你0.01km", "156195610", "https://i2.cdn.xiongmaoxingyan.com/173b90cd68a29528bc58b8f0f6a9d480_w960_h960.jpeg", "参加公益", 25, "靠谱", ".Lonely", "斗鱼直播", "双子座", 16000, "搞笑达人", "科比"));
            zhuboController.insert(new ZhuboBean(null, "30", "陕西省", "西安", "小刘很饿", "新人主播等一个守护", "103997770", "https://i.h2.pdim.gs/81b4b4cda2893befa5a59583c8c35afa_w960_h960.jpeg", "运动", 22, "文艺少女", "my love", "斗鱼直播", "狮子座", 95000, "搞笑达人", "科比"));

            zhuboController.insert(new ZhuboBean(null, "31", "陕西省", "西安", "米粒儿小姑姑", "想把我唱给你听", "74413938", "https://image.xingyan.panda.tv/6d4b97f2b9b3642ac541fe9b372526be_w960_h960.jpeg", "购物", 25, "厚道", "beautiful", "熊猫直播", "狮子座", 107570, "搞笑达人", "科比"));
            zhuboController.insert(new ZhuboBean(null, "32", "天津市", "天津", "微风by", "嘿，兄弟！", "99017184", "https://i1.cdn.xiongmaoxingyan.com/9a5bc6683b67d91dfd2f7fec1fc82aaa_w960_h960.jpeg", "运动", 25, "叫我逗逼", "hero", "斗鱼直播", "狮子座", 1345300, "搞笑达人", "科比"));
            zhuboController.insert(new ZhuboBean(null, "33", "川省", "德阳", "blingirl", "这个冬天我们温暖你啊", "156153490", "https://i4.cdn.xiongmaoxingyan.com/aecbbcd6c9972918ee6c815af89414e7_w960_h960.jpeg", "运动", 25, "靠谱", "You make me wanna", "熊猫直播", "狮子座", 68730, "搞笑达人", "科比"));
            zhuboController.insert(new ZhuboBean(null, "34", "浙江省", "宁波", "可可SuKei", "主播哪里人", "144297450", "https://i1.cdn.xiongmaoxingyan.com/1f74ca675d77e98423f32543d670f29c_w960_h960.jpeg", "画画", 25, "萌萌哒", "One love", "斗鱼直播", "狮子座", 634530, "搞笑达人", "科比"));
            zhuboController.insert(new ZhuboBean(null, "35", "福建省", "泉州", "刘公子Akk", "后来", "146749274", "https://i0.cdn.xiongmaoxingyan.com/4901800ee66151d04ae0603c221d4f79_w960_h960.jpeg", "听歌", 22, "文艺少女", "I want it that way", "熊猫直播", "狮子座", 63453, "搞笑达人", "科比"));
            zhuboController.insert(new ZhuboBean(null, "36", "福建省", "厦门", "一可梨", "600W拜托了", "94391560", "https://i4.cdn.xiongmaoxingyan.com/d8bde9f4a75087d6dccaa951a5e1bd8a_w960_h960.jpeg", "购物", 25, "喜欢简单", "Bye bye bye", "斗鱼直播", "狮子座", 45300, "搞笑达人", "科比"));
            zhuboController.insert(new ZhuboBean(null, "38", "吉林省", "延边", "是李晶吖", "众筹升级～", "151949708", "https://i0.cdn.xiongmaoxingyan.com/c93170af4a867f1366ff207a39a782e5_w960_h960.jpeg", "旅游", 22, "厚道", "We will rock you", "斗鱼直播", "狮子座", 87570, "搞笑达人", "科比"));
            zhuboController.insert(new ZhuboBean(null, "39", "吉林省", "延边", "予笙1209", "小哥哥进来玩会儿呗", "142803368", "https://i3.cdn.xiongmaoxingyan.com/61d2bd6ac03d3dbcc02d0c26cc026564_w960_h960.jpeg", "运动", 28, "吃货", "Baby one more time", "斗鱼直播", "狮子座", 373380, "搞笑达人", "科比"));
            zhuboController.insert(new ZhuboBean(null, "40", "黑龙江省", "哈尔滨", "超酷的小猴子", "收了这只野猴子", "140794200", "https://i3.cdn.xiongmaoxingyan.com/d2c4a7c2afaaf35d1f2fa9f06e1931aa_w960_h960.jpeg", "电影", 23, "叫我逗逼", "Yesterday once more", "斗鱼直播", "狮子座", 378300, "搞笑达人", "科比"));
            zhuboController.insert(new ZhuboBean(null, "41", "新疆维吾尔自治区", "乌鲁木齐", "王魔王豆豆子", "嗯", "156963204", "https://i4.cdn.xiongmaoxingyan.com/7253c4f72c01f57f50848403d9ae89db_w960_h960.jpeg", "旅游", 28, "安静", "My love", "熊猫直播", "金牛座", 8720, "搞笑达人", "科比"));
            zhuboController.insert(new ZhuboBean(null, "42", "河北省", "沧州", "747小雪最酷", "你好呀", "134047334", "https://image.xingyan.panda.tv/7783d6929ea16d64aa8f9214f49c6342_w960_h960.jpeg", "K歌", 21, "厚道", "Numb", "斗鱼直播", "狮子座", 277287, "搞笑达人", "科比"));
            zhuboController.insert(new ZhuboBean(null, "43", "新疆维吾尔自治区", "乌鲁木齐", "网瘾少女晶", "没睡意就", "123905436", "https://image.xingyan.panda.tv/1f6e4ac82c99e512fb1e548dc5006abf_w960_h960.jpeg", "打游戏", 18, "长发及腰", "Complicated", "斗鱼直播", "狮子座", 63780, "搞笑达人", "科比"));
            zhuboController.insert(new ZhuboBean(null, "44", "新疆维吾尔自治区", "乌鲁木齐", "Vincy_", "", "137614588", "https://image.xingyan.panda.tv/d811330d6eb44c3c3937d6fd8039db99_w960_h960.jpeg", "爱追剧", 19, "喜欢简单", "Shape of my heart", "斗鱼直播", "金牛座", 575000, "搞笑达人", "科比"));
            zhuboController.insert(new ZhuboBean(null, "45", "吉林省", "平", "依闹a", "新来的95阿姨", "158442514", "https://i2.cdn.xiongmaoxingyan.com/1fcf4569a7077497d19c5089d9e50738_w960_h960.jpeg", "打游戏", 18, "厚道", "Far away from home", "斗鱼直播", "射手座", 888340, "搞笑达人", "科比"));
            zhuboController.insert(new ZhuboBean(null, "46", "吉林省", "平", "金鱼YOYO", "", "138228300", "https://image.xingyan.panda.tv/c12a5a2025f1dd5ad03bad10f6238e23_w960_h960.jpeg", "逛街", 26, "喜欢简单", "Without you", "熊猫直播", "狮子座", 535600, "搞笑达人", "科比"));
            zhuboController.insert(new ZhuboBean(null, "47", "辽宁省", "铁岭", "Su苏悦的老公", "抽奖。抽奖。抽奖，记得要关注，关注，", "147417482", "https://i2.cdn.xiongmaoxingyan.com/320ae18aeef7edd0fb27f6001c4350f4_w960_h960.jpeg", "K歌", 25, "热血", "God is a girl", "熊猫直播", "魔蝎座", 76000, "搞笑达人", "科比"));
            zhuboController.insert(new ZhuboBean(null, "48", "山西省", "忻州", "焦大可", "好久不见", "141154062", "https://image.xingyan.panda.tv/ed2c02b3fa86e84708d1ab1b38a95c9c_w960_h960.jpeg", "电影", 25, "理想主义", "Thank you", "熊猫直播", "狮子座", 56000, "搞笑达人", "科比"));
            zhuboController.insert(new ZhuboBean(null, "49", "安徽省", "宣城", "欣宝啊啊啊", "第一天直播", "158446044", "https://i0.cdn.xiongmaoxingyan.com/4f1262f1ffdaf813afe44341b5bdf2eb_w960_h960.jpeg", "运动", 26, "萌萌哒", "Bye bye bye", "熊猫直播", "狮子座", 1453453, "搞笑达人", "科比"));
            zhuboController.insert(new ZhuboBean(null, "50", "辽宁省", "铁岭", "衣吖吖", "新手上路，求守护", "159038288", "https://i.h2.pdim.gs/a13950d6ffff8c637c951cbde151b37c.jpeg", "购物", 25, "理想主义", "Moonlight shadow", "熊猫直播", "魔蝎座", 134340, "搞笑达人", "科比"));
            zhuboController.insert(new ZhuboBean(null, "51", "山西省", "忻州", "米闹闹吖", "初次见面，多多指教", "154830184", "https://i2.cdn.xiongmaoxingyan.com/176036ef436ef99b7d578a987ad99731_w960_h960.jpeg", "热爱化妆", 22, "敢爱敢恨", "hero", "斗鱼直播", "狮子座", 142000, "搞笑达人", "科比"));
            zhuboController.insert(new ZhuboBean(null, "52", "辽宁省", "沈阳", "洛Ordinary", "哈利路亚", "158038902", "https://i0.cdn.xiongmaoxingyan.com/97d1cc1ad14fdfe1fe78b2c7c1eeec84_w960_h960.jpeg", "煮饭", 18, "热血", "Moonlight shadow", "斗鱼直播", "魔蝎座", 376000, "搞笑达人", "科比"));

            zhuboController.insert(new ZhuboBean(null, "a", "云南省", "保山", "_黄喜喜_", "要开心鸭", "156723202", "https://i3.cdn.xiongmaoxingyan.com/f1cb3bb01a5f0c2a6f992d874edcfd48_w960_h960.jpeg", "画画", 24, "理想主义", "The day you went away", "花椒直播", "摩羯座", 367537, "搞笑达人", "詹姆斯"));
            zhuboController.insert(new ZhuboBean(null, "a", "川省", "成都", "WX火锅少女团", "深入了解一波", "127743234", "https://image.xingyan.panda.tv/c1097e0ce8672f73b325ac51f7aae6bd_w960_h960.jpeg", "热爱化妆", 21, "喜欢简单", "Dying in the sun", "花椒直播", "双子座", 794826, "好才艺", "詹姆斯"));
            zhuboController.insert(new ZhuboBean(null, "a", "江苏省", "无锡", "是鹿子er", "新众筹升级", "151795196", "https://i1.cdn.xiongmaoxingyan.com/cbc75ef8285d9eede3a0fc53cf4d4ae2_w960_h960.jpeg", "打游戏", 21, "双重人格", "The day you went away", "花椒直播", "处女座", 170425, "好才艺", "詹姆斯"));
            zhuboController.insert(new ZhuboBean(null, "a", "上海市", "上海", "花儿对妮儿笑", "愿一切安好", "136169410", "https://i2.cdn.xiongmaoxingyan.com/48387f87073bbc69339e18855a29972e_w960_h960.jpeg", "爱追剧", 18, "厚道", "hero", "花椒直播", "狮子座", 344485, "好才艺", "詹姆斯"));
            zhuboController.insert(new ZhuboBean(null, "a", "辽宁省", "阜新", "酒窝兔宝宝", "等一个人", "135217296", "https://i3.cdn.xiongmaoxingyan.com/fcedc088b404325abb091fae24ce0194_w960_h960.jpeg", "购物", 20, "宅", "My heart will go on", "花椒直播", "狮子座", 996138, "好才艺", "詹姆斯"));
            zhuboController.insert(new ZhuboBean(null, "a", "川省", "德阳", "blingirl", "君若不补刀，万古长如夜。", "156153490", "https://i4.cdn.xiongmaoxingyan.com/aecbbcd6c9972918ee6c815af89414e7_w960_h960.jpeg", "打游戏", 24, "靠谱", "Take me to your heart", "花椒直播", "双子座", 355841, "高颜值", "詹姆斯"));
            zhuboController.insert(new ZhuboBean(null, "a", "重庆市", "重庆", "重庆火锅少女团", "今天有两个新人哦。珍的不进来吗", "148514318", "https://i0.cdn.xiongmaoxingyan.com/fb1c417e65511b74bdaa53d9ab918d6d_w960_h960.jpeg", "电影", 22, "双重人格", "take me to you heart", "花椒直播", "处女座", 285898, "高颜值", "詹姆斯"));
            zhuboController.insert(new ZhuboBean(null, "a", "湖南省", "岳阳", "陈潇潇i", "来呀，造作呀~", "84582418", "https://i0.cdn.xiongmaoxingyan.com/646e65655576ddab516d41468bdced03_w960_h960.jpeg", "听歌", 24, "萌萌哒", "Dying in the sun", "花椒直播", "双鱼座", 541844, "搞笑达人", "詹姆斯"));
            zhuboController.insert(new ZhuboBean(null, "a", "山东省", "青岛", "新主播赵甜甜", "入刺的井猜", "156847852", "https://i.h2.pdim.gs/ace2015d8aca01796d94f984dcf30953_w960_h960.jpeg", "煮饭", 21, "文艺少女", "when i believe", "花椒直播", "处女座", 297209, "高颜值", "詹姆斯"));
            zhuboController.insert(new ZhuboBean(null, "a", "浙江省", "台州", "一禅妹妹", "想升级", "92961036", "https://i1.cdn.xiongmaoxingyan.com/7da976092ce9c7b2a213c628598760af_w960_h960.jpeg", "吃喝拉睡", 23, "厚道", ".You are not alone", "花椒直播", "水瓶座", 376804, "好才艺", "詹姆斯"));
            zhuboController.insert(new ZhuboBean(null, "a", "川省", "成都", "A_Jing", "音魂不散", "121443962", "https://i4.cdn.xiongmaoxingyan.com/08e6b6a00647e1e90c29022370ca8d5e_w960_h960.jpeg", "旅游", 24, "热血", "Complicated", "花椒直播", "处女座", 295027, "好才艺", "詹姆斯"));
            zhuboController.insert(new ZhuboBean(null, "a", "吉林省", "延边", "Aoe火火", "今天也是一个没人喜欢的小可爱", "147419178", "https://i0.cdn.xiongmaoxingyan.com/cfa6a2b1a5800085276cde1539775edd_w960_h960.jpeg", "逛街", 26, "大叔控", "One love", "花椒直播", "白羊座", 420360, "高颜值", "詹姆斯"));
            zhuboController.insert(new ZhuboBean(null, "a", "浙江省", "杭州", "我叫幼瑾", "缘来是你", "117910152", "https://i1.cdn.xiongmaoxingyan.com/e57ee79b77148c931317d10ccadce969_w960_h960.jpeg", "购物", 25, "喜欢简单", "One love", "花椒直播", "白羊座", 418434, "好才艺", "詹姆斯"));
            zhuboController.insert(new ZhuboBean(null, "a", "浙江省", "杭州", "初见suy", "她的声音会上瘾", "153133322", "https://i0.cdn.xiongmaoxingyan.com/5f5dc4f2f7475eb4b044dfff122db710_w960_h960.jpeg", "逛街", 19, "靠谱", "when i believe", "花椒直播", "狮子座", 636033, "搞笑达人", "詹姆斯"));
            zhuboController.insert(new ZhuboBean(null, "a", "吉林省", "延边", "七七是翻译官", "与你相遇 好幸运", "124129894", "https://i4.cdn.xiongmaoxingyan.com/aab6be264c9ecd72557077c3e96f7435_w960_h960.jpeg", "画画", 22, "讲义气", "You make me wanna", "花椒直播", "天蝎座", 312471, "高颜值", "詹姆斯"));
            zhuboController.insert(new ZhuboBean(null, "a", "上海市", "上海", "小島Cherry", "别动，我来动", "126892882", "https://i3.cdn.xiongmaoxingyan.com/83d225b55b5b0efb22943398fcba0085_w960_h960.jpeg", "热爱化妆", 23, "理想主义", "Shape of my heart", "花椒直播", "天蝎座", 844773, "高颜值", "詹姆斯"));
            zhuboController.insert(new ZhuboBean(null, "a", "吉林省", "延边", "伊伊甜甜的", "新主播了解一下", "158012498", "https://i0.cdn.xiongmaoxingyan.com/8ae0ca7d4a249a40dde24d94421b2a9b_w960_h960.jpeg", "吃喝拉睡", 21, "理想主义", "Complicated", "花椒直播", "摩羯座", 24480, "高颜值", "詹姆斯"));
            zhuboController.insert(new ZhuboBean(null, "a", "福建省", "厦门", "DJ玖儿", "你的DJ小宝贝", "147419264", "https://i2.cdn.xiongmaoxingyan.com/9989c7dd44dcf7360313f94d2fc036c7_w960_h960.jpeg", "电影", 18, "大叔控", "Only love", "花椒直播", "巨蟹座", 494357, "好才艺", "詹姆斯"));
            zhuboController.insert(new ZhuboBean(null, "a", "吉林省", "延边", "景楽", "求守护鸭", "150513778", "https://i.h2.pdim.gs/1d41667ec62ac079a529a43a94d95cfd_w960_h960.jpeg", "参加公益", 25, "强迫症", "come over baby", "花椒直播", "水瓶座", 39635, "搞笑达人", "詹姆斯"));


            zhuboController.insert(new ZhuboBean(null, "kkk", "湖南省", "长沙", "慕儿Meow", "这个主播很勤快", "156932404", "https://i1.cdn.xiongmaoxingyan.com/7198102e346d99f58a1648ba81064057_w960_h960.jpeg", "参加公益", 27, "厚道", "Never had a dream come true", "企鹅电竞", "狮子座", 613037, "高颜值", "詹姆斯"));
            zhuboController.insert(new ZhuboBean(null, "kkk", "吉林省", "延边", "积木Mum", "不一样的人间烟火", "107484114", "https://i0.cdn.xiongmaoxingyan.com/74f5091040f22c55ca1392963a255c22_w960_h960.jpeg", "电影", 27, "喜欢简单", "She", "企鹅电竞", "摩羯座", 384069, "高颜值", "詹姆斯"));
            zhuboController.insert(new ZhuboBean(null, "kkk", "川省", "成都", "伊伊甜甜的", "新主播了解一下", "158012498", "https://i0.cdn.xiongmaoxingyan.com/8ae0ca7d4a249a40dde24d94421b2a9b_w960_h960.jpeg", "购物", 27, "安静", "My heart will go on", "企鹅电竞", "双子座", 39492, "高颜值", "詹姆斯"));
            zhuboController.insert(new ZhuboBean(null, "kkk", "重庆市", "重庆", "_鬼岛_", "勒是雾都！", "90987422", "https://i.h2.pdim.gs/a835d34ea9636210df923ee4478fe2d2_w960_h960.jpeg", "听歌", 18, "长发及腰", "Without you", "企鹅电竞", "天秤座", 174966, "高颜值", "詹姆斯"));
            zhuboController.insert(new ZhuboBean(null, "kkk", "广东省", "深圳", "倩兒", "新主播", "66646608", "https://i0.cdn.xiongmaoxingyan.com/d5512bc2551e4c032cd4140a75b2aade_w960_h960.jpeg", "旅游", 24, "喜欢简单", "Never had a dream come true", "企鹅电竞", "双子座", 892372, "搞笑达人", "詹姆斯"));
            zhuboController.insert(new ZhuboBean(null, "kkk", "湖南省", "岳阳", "歌手落", "熊猫最强音", "39552310", "https://i2.cdn.xiongmaoxingyan.com/a563c86d7a82ca40f41820523751502b_w960_h960.jpeg", "K歌", 24, "萌萌哒", "The day you went away", "企鹅电竞", "狮子座", 516817, "搞笑达人", "詹姆斯"));
            zhuboController.insert(new ZhuboBean(null, "kkk", "吉林省", "延边", "是李晶吖", "自闭主播", "151949708", "https://i0.cdn.xiongmaoxingyan.com/c93170af4a867f1366ff207a39a782e5_w960_h960.jpeg", "逛街", 24, "萌萌哒", "Far away from home", "企鹅电竞", "射手座", 478626, "高颜值", "詹姆斯"));
            zhuboController.insert(new ZhuboBean(null, "kkk", "川省", "成都", "Barbara_Rcc", "新主播 请多多关照", "100345526", "https://i1.cdn.xiongmaoxingyan.com/d86af08f25ee04a181ee532158329c07_w960_h960.jpeg", "画画", 21, "双重人格", "When you believe", "企鹅电竞", "水瓶座", 448547, "高颜值", "詹姆斯"));
            zhuboController.insert(new ZhuboBean(null, "kkk", "川省", "成都", "柬埔寨绝情小公主", "好嗨呦！", "106542806", "https://i4.cdn.xiongmaoxingyan.com/8e34fb581e5d4e4d4305eb6c809f07bf_w960_h960.jpeg", "逛街", 26, "宅", "Scarborough fair", "企鹅电竞", "处女座", 120639, "高颜值", "詹姆斯"));
            zhuboController.insert(new ZhuboBean(null, "kkk", "川省", "成都", "叮当___", "天上的小女孩来啦", "156152024", "https://i2.cdn.xiongmaoxingyan.com/7e7a01323db927d5d440a03d5a529a71_w960_h960.jpeg", "参加公益", 22, "吃货", "Baby one more time", "企鹅电竞", "双子座", 646001, "高颜值", "詹姆斯"));
            zhuboController.insert(new ZhuboBean(null, "kkk", "安徽省", "芜湖", "晚爷丶Shadow", "网恋吗？坐牢的那种", "156898604", "https://i0.cdn.xiongmaoxingyan.com/d67c27f02f54d77cf4646eb6efe0ec4c_w960_h960.jpeg", "画画", 26, "长发及腰", "The day you went away", "企鹅电竞", "天蝎座", 813635, "高颜值", "詹姆斯"));
            zhuboController.insert(new ZhuboBean(null, "kkk", "江西省", "景德镇", "粤语歌手_安妮", "升级 冲鸭", "156898608", "https://i2.cdn.xiongmaoxingyan.com/5003156f9950a62f54856c0b06ef38f0_w960_h960.jpeg", "购物", 20, "萌萌哒", "Baby one more time", "企鹅电竞", "金牛座", 646775, "好才艺", "詹姆斯"));
            zhuboController.insert(new ZhuboBean(null, "kkk", "湖南省", "长沙", "ki茶茶", "转角遇到你", "158404790", "https://i.h2.pdim.gs/1e33561f66bd74d01c2862ceccecc208.jpeg", "打游戏", 23, "文艺少女", "Thank you", "企鹅电竞", "狮子座", 753247, "好才艺", "詹姆斯"));
            zhuboController.insert(new ZhuboBean(null, "kkk", "吉林省", "延边", "阿丽莎Alice", "本人比封面好看&nbsp;诚招守护", "152882436", "https://i3.cdn.xiongmaoxingyan.com/b71cf51eaef9e289e94caa138ea25980_w960_h960.jpeg", "电影", 26, "萌萌哒", "beautiful", "企鹅电竞", "白羊座", 262146, "搞笑达人", "詹姆斯"));
            zhuboController.insert(new ZhuboBean(null, "kkk", "辽宁省", "大连", "属于瑶瑶吖", "等一个久伴", "108427390", "https://i1.cdn.xiongmaoxingyan.com/f7ad785ce9370b0ddd030ac7bc41231b_w960_h960.jpeg", "打游戏", 27, "靠谱", "Take me to your heart", "企鹅电竞", "摩羯座", 644724, "搞笑达人", "詹姆斯"));
            zhuboController.insert(new ZhuboBean(null, "kkk", "陕西省", "西安", "小刘很饿", "新人主播等一个守护", "103997770", "https://i.h2.pdim.gs/81b4b4cda2893befa5a59583c8c35afa_w960_h960.jpeg", "K歌", 24, "宅", "My love", "企鹅电竞", "白羊座", 177264, "好才艺", "詹姆斯"));
            zhuboController.insert(new ZhuboBean(null, "kkk", "江苏省", "南通", "徐姑娘i", "这是一个孩子叭", "118680828", "https://image.xingyan.panda.tv/ff7455c1ac6e8217c68152d58cae2267_w960_h960.jpeg", "购物", 23, "敢爱敢恨", "Without you", "企鹅电竞", "金牛座", 279161, "搞笑达人", "詹姆斯"));


            zhuboController.insert(new ZhuboBean(null, "k", "湖南省", "长沙", "PUNCH_kimsamuel", "歌手", "354579081", "https://alcdn.img.xiaoka.tv/20180809/4f8/aac/0/4f8aac24c06bbf90fa5366647e999fc2.jpg@1e_1c_0o_0l_160h_160w_100q_1pr.jpg", "旅游", 19, "长发及腰", "My love", "抱抱直播", "金牛座", 356280, "好才艺", "安东尼"));
            zhuboController.insert(new ZhuboBean(null, "k", "湖南省", "长沙", "黄致列HCY", "歌手", "27604697", "https://alcdn.img.xiaoka.tv/20171222/5a3/f99/0/5a3f9921793228c65096149a1fb97563.jpg@1e_1c_0o_0l_160h_160w_100q_1pr.jpg", "打游戏", 27, "长发及腰", "beautiful", "抱抱直播", "狮子座", 950980, "好才艺", "安东尼"));
            zhuboController.insert(new ZhuboBean(null, "k", "湖南省", "长沙", "曹煜辰cyc", "演员", "214083573", "https://alcdn.img.xiaoka.tv/20170301/efe/21c/0/efe21cdcb490e4df045794163f2b8070.jpg@1e_1c_0o_0l_160h_160w_100q_1pr.jpg", "运动", 25, "长发及腰", "My heart will go on", "抱抱直播", "天秤座", 628953, "高颜值", "安东尼"));
            zhuboController.insert(new ZhuboBean(null, "k", "湖南省", "长沙", "张樟同学", "艺人", "30829002", "https://alcdn.img.xiaoka.tv/20181203/58c/564/30829002/58c564ac6e1a57c9e116526509381b54.jpg@1e_1c_0o_0l_160h_160w_100q_1pr.jpg", "热爱化妆", 19, "叫我逗逼", "Hotel california", "抱抱直播", "双鱼座", 789509, "好才艺", "安东尼"));
            zhuboController.insert(new ZhuboBean(null, "k", "广东省", "深圳", "石佳鹏STYLE", "艺人", "28397989", "https://alcdn.img.xiaoka.tv/20180810/6cc/f6a/28397989/6ccf6aab6e60ad459e877873b467b348.jpg@1e_1c_0o_0l_160h_160w_100q_1pr.jpg", "参加公益", 23, "宅", "Bye bye bye", "抱抱直播", "射手座", 436735, "好才艺", "安东尼"));
            zhuboController.insert(new ZhuboBean(null, "k", "广东省", "深圳", "金美儿MIA", "歌手", "320870795", "https://alcdn.img.xiaoka.tv/20180920/b3c/cd0/320870795/b3ccd06f14dfcb4e669c068c3f68f682.jpg@1e_1c_0o_0l_160h_160w_100q_1pr.jpg", "电影", 27, "热血", "You make me wanna", "抱抱直播", "金牛座", 44700, "搞笑达人", "安东尼"));
            zhuboController.insert(new ZhuboBean(null, "k", "江苏省", "南通", "吴优", "演员", "1434875", "https://alcdn.img.xiaoka.tv/20160627/8fd/334/1434875/8fd3344c1ac8552cf8954210c63d6cd3.jpg@1e_1c_0o_0l_160h_160w_100q_1pr.jpg", "听歌", 24, "敢爱敢恨", "come over baby", "抱抱直播", "处女座", 226567, "高颜值", "安东尼"));
            zhuboController.insert(new ZhuboBean(null, "k", "广东省", "深圳", "丁当Della", "明星", "11644393", "https://alcdn.img.xiaoka.tv/20160531/c03/3af/0/c033afed4c7fe51b3b006192816b779a.jpg@1e_1c_0o_0l_160h_160w_100q_1pr.jpg", "煮饭", 23, "理想主义", "Cry on my shoulder", "抱抱直播", "天秤座", 145818, "好才艺", "安东尼"));
            zhuboController.insert(new ZhuboBean(null, "k", "上海市", "上海", "主持王不凡", "主持人", "48551", "https://alcdn.img.xiaoka.tv/20181211/6dd/526/48551/6dd5262fa117b953cca370e8f6c845da.jpg@1e_1c_0o_0l_160h_160w_100q_1pr.jpg", "吃喝拉睡", 27, "大叔控", "I could be the one", "抱抱直播", "巨蟹座", 57399, "搞笑达人", "安东尼"));
            zhuboController.insert(new ZhuboBean(null, "k", "江苏省", "南通", "黄一琳", "演员", "121158", "https://alcdn.img.xiaoka.tv/20160828/5a2/d68/121158/5a2d68762416322ef465f92dc9435495.jpg@1e_1c_0o_0l_160h_160w_100q_1pr.jpg", "购物", 18, "萌萌哒", "i still believe", "抱抱直播", "巨蟹座", 671682, "好才艺", "安东尼"));
            zhuboController.insert(new ZhuboBean(null, "k", "上海市", "上海", "周锐Zee", "艺人", "112910097", "https://alcdn.img.xiaoka.tv/20180530/eb7/c37/112910097/eb7c377bcdc7fba402c155de20d9172f.jpg@1e_1c_0o_0l_160h_160w_100q_1pr.jpg", "听歌", 18, "大叔控", "my love", "抱抱直播", "水瓶座", 866703, "搞笑达人", "安东尼"));
            zhuboController.insert(new ZhuboBean(null, "k", "上海市", "上海", "林玮婕", "主持人", "28625182", "https://alcdn.img.xiaoka.tv/20160813/dec/44e/28625182/dec44e7331b2a5498b9cdd900563ed48.jpg@1e_1c_0o_0l_160h_160w_100q_1pr.jpg", "旅游", 19, "文艺少女", "beautiful", "抱抱直播", "巨蟹座", 691942, "好才艺", "安东尼"));
            zhuboController.insert(new ZhuboBean(null, "k", "江苏省", "南通", "演员马丽", "明星", "37577675", "https://alcdn.img.xiaoka.tv/20160613/8b7/ea5/37577675/8b7ea5d65c44d4492d1a7964ce19f36b.jpg@1e_1c_0o_0l_160h_160w_100q_1pr.jpg", "运动", 18, "喜欢简单", "I could be the one", "抱抱直播", "白羊座", 447026, "好才艺", "安东尼"));
            zhuboController.insert(new ZhuboBean(null, "k", "吉林省", "延边", "刘钧", "演员", "74801725", "https://alcdn.img.xiaoka.tv/20180112/46c/85e/74801725/46c85e959e2c678459541c8cd54fa0e9.jpg@1e_1c_0o_0l_160h_160w_100q_1pr.jpg", "打游戏", 27, "强迫症", "I want it that way", "抱抱直播", "摩羯座", 483140, "好才艺", "安东尼"));
            zhuboController.insert(new ZhuboBean(null, "k", "吉林省", "延边", "张晓谦ZHaNG", "演员", "29732811", "https://alcdn.img.xiaoka.tv/20181023/4ea/285/0/4ea28575637933d26c69de443279a61b.jpg@1e_1c_0o_0l_160h_160w_100q_1pr.jpg", "K歌", 26, "厚道", "Just one last dance", "抱抱直播", "巨蟹座", 57100, "搞笑达人", "安东尼"));
            zhuboController.insert(new ZhuboBean(null, "k", "广东省", "深圳", "演员刘琳", "演员", "373423933", "https://alcdn.img.xiaoka.tv/20190108/1d0/54c/0/1d054ca2185865090372868e9cf7f9d8.jpg@1e_1c_0o_0l_160h_160w_100q_1pr.jpg", "逛街", 18, "靠谱", "Complicated", "抱抱直播", "天蝎座", 921557, "高颜值", "安东尼"));
            zhuboController.insert(new ZhuboBean(null, "k", "广东省", "深圳", "Lee权哲", "艺人", "233055186", "https://alcdn.img.xiaoka.tv/20181204/aa2/8dc/0/aa28dc4e7c107becda693c7ce10ef5b7.jpg@1e_1c_0o_0l_160h_160w_100q_1pr.jpg", "打游戏", 25, "大叔控", "All rise", "抱抱直播", "白羊座", 998260, "高颜值", "安东尼"));
            zhuboController.insert(new ZhuboBean(null, "k", "上海市", "上海", "张樟同学", "艺人", "30829002", "https://alcdn.img.xiaoka.tv/20181203/58c/564/30829002/58c564ac6e1a57c9e116526509381b54.jpg@1e_1c_0o_0l_160h_160w_100q_1pr.jpg", "煮饭", 27, "宅", "Moonlight shadow", "抱抱直播", "双子座", 521254, "好才艺", "安东尼"));
            zhuboController.insert(new ZhuboBean(null, "k", "上海市", "上海", "罗正_LZ", "歌手", "293624827", "https://alcdn.img.xiaoka.tv/20171209/220/8ff/0/2208ffa693a8855ef030be8d07444a03.jpg@1e_1c_0o_0l_160h_160w_100q_1pr.jpg", "购物", 22, "热血", "I could be the one", "抱抱直播", "射手座", 86022, "高颜值", "安东尼"));
            zhuboController.insert(new ZhuboBean(null, "k", "上海市", "上海", "娄艺潇Loura", "演员", "23362822", "https://alcdn.img.xiaoka.tv/20180815/79b/e74/23362822/79be74ade5b7ca2c70026e96d3107ddc.jpg@1e_1c_0o_0l_160h_160w_100q_1pr.jpg", "运动", 20, "理想主义", "You raise me up", "抱抱直播", "处女座", 656016, "好才艺", "安东尼"));

            zhuboController.insert(new ZhuboBean(null, "k", "江西省", "景德镇", "孔垂楠Korn", "演员", "1305999", "https://alcdn.img.xiaoka.tv/20180919/75a/f16/1305999/75af16cfd5cec67d44e081810499cf9c.jpg@1e_1c_0o_0l_160h_160w_100q_1pr.jpg", "爱追剧", 21, "靠谱", "Hotel california", "一直播", "天蝎座", 958304, "好才艺", "安东尼"));
            zhuboController.insert(new ZhuboBean(null, "k", "江西省", "景德镇", "张韶涵", "歌手", "44901753", "https://alcdn.img.xiaoka.tv/20190117/3e6/e88/0/3e6e889dc29fb69dc13460f8afca1e27.png@1e_1c_0o_0l_160h_160w_100q_1pr.jpg", "爱追剧", 24, "长发及腰", "Only love", "一直播", "摩羯座", 549334, "好才艺", "安东尼"));
            zhuboController.insert(new ZhuboBean(null, "k", "浙江省", "杭州", "THEO—朱正廷", "艺人", "33633681", "https://alcdn.img.xiaoka.tv/20181108/8f4/b02/33633681/8f4b02e59d08d75ebdd4dcc1c8e3e551.jpg@1e_1c_0o_0l_160h_160w_100q_1pr.jpg", "爱追剧", 18, "喜欢简单", "I want it that way", "一直播", "白羊座", 71366, "高颜值", "安东尼"));
            zhuboController.insert(new ZhuboBean(null, "k", "江西省", "景德镇", "王洛勇", "演员", "222969682", "https://alcdn.img.xiaoka.tv/20181204/579/636/0/579636089cd302c63326da38911d8185.jpg@1e_1c_0o_0l_160h_160w_100q_1pr.jpg", "煮饭", 26, "热血", "Baby one more time", "一直播", "射手座", 599110, "搞笑达人", "安东尼"));
            zhuboController.insert(new ZhuboBean(null, "k", "浙江省", "杭州", "演员刘岳", "演员", "133425887", "https://alcdn.img.xiaoka.tv/20181208/054/bac/0/054bac5c07cee73728bfc5431de29397.jpg@1e_1c_0o_0l_160h_160w_100q_1pr.jpg", "听歌", 19, "热血", "Better man", "一直播", "金牛座", 42952, "高颜值", "安东尼"));
            zhuboController.insert(new ZhuboBean(null, "k", "山东省", "日照", "陈鹏", "达人", "208818", "https://alcdn.img.xiaoka.tv/20161107/da4/834/208818/da4834913f1687911a5129e67e072369.jpg@1e_1c_0o_0l_160h_160w_100q_1pr.jpg", "运动", 20, "理想主义", "take me to you heart", "一直播", "巨蟹座", 125858, "高颜值", "安东尼"));
            zhuboController.insert(new ZhuboBean(null, "k", "安徽省", "芜湖", "AJ李艾瑾", "演员", "52321160", "https://alcdn.img.xiaoka.tv/20181130/a2a/a23/52321160/a2aa230ced3ffdc0e810822748a3af1e.jpg@1e_1c_0o_0l_160h_160w_100q_1pr.jpg", "逛街", 27, "双重人格", "Baby one more time", "一直播", "天蝎座", 476107, "高颜值", "安东尼"));
            zhuboController.insert(new ZhuboBean(null, "k", "安徽省", "芜湖", "官鴻Kuan", "演员", "51371589", "https://alcdn.img.xiaoka.tv/20181203/eda/eeb/0/edaeeb5364c2531bd9733b970080abb2.jpg@1e_1c_0o_0l_160h_160w_100q_1pr.jpg", "听歌", 24, "双重人格", "I swear", "一直播", "白羊座", 688101, "好才艺", "安东尼"));
            zhuboController.insert(new ZhuboBean(null, "k", "新疆维吾尔自治区", "新疆", "MIC赵泳鑫Steelo", "歌手", "12537934", "https://alcdn.img.xiaoka.tv/20161031/420/ad9/12537934/420ad97054a67600c0515926d688893c.jpg@1e_1c_0o_0l_160h_160w_100q_1pr.jpg", "运动", 19, "长发及腰", "when i believe", "一直播", "白羊座", 118773, "好才艺", "安东尼"));
            zhuboController.insert(new ZhuboBean(null, "k", "新疆维吾尔自治区", "新疆", "_杨昊铭_", "演员", "33133620", "https://alcdn.img.xiaoka.tv/20181030/0fe/98d/0/0fe98d22508645c617f4e943cd86c78c.jpg@1e_1c_0o_0l_160h_160w_100q_1pr.jpg", "购物", 26, "强迫症", "Seasons in the sun", "一直播", "天蝎座", 330156, "高颜值", "安东尼"));
            zhuboController.insert(new ZhuboBean(null, "k", "上海市", "上海", "杨小渔渔", "明星", "2428438", "https://alcdn.img.xiaoka.tv/20171001/a0e/16c/2428438/a0e16cb95489cf094dafb5e176434c85.jpg@1e_1c_0o_0l_160h_160w_100q_1pr.jpg", "打游戏", 25, "萌萌哒", "You raise me up", "一直播", "金牛座", 231474, "好才艺", "安东尼"));
            zhuboController.insert(new ZhuboBean(null, "k", "吉林省", "延边", "韩宇531", "艺人", "47196894", "https://alcdn.img.xiaoka.tv/20180810/172/51a/47196894/17251abf7198d2e5e27321b2011e1a57.jpg@1e_1c_0o_0l_160h_160w_100q_1pr.jpg", "打游戏", 19, "萌萌哒", "She", "一直播", "天蝎座", 911753, "好才艺", "安东尼"));
            zhuboController.insert(new ZhuboBean(null, "k", "安徽省", "芜湖", "王梓薇啊", "演员", "28146589", "https://alcdn.img.xiaoka.tv/20181219/17f/0ee/28146589/17f0ee2a2550cf877d4b7ff424ac7ace.jpg@1e_1c_0o_0l_160h_160w_100q_1pr.jpg", "热爱化妆", 20, "靠谱", "Complicated", "一直播", "射手座", 962505, "高颜值", "安东尼"));
            zhuboController.insert(new ZhuboBean(null, "k", "湖北省", "咸宁", "莫小奇_Monica", "演员", "43075927", "https://alcdn.img.xiaoka.tv/20170511/27c/977/0/27c9779b21da94fe9802c51438707e87.jpg@1e_1c_0o_0l_160h_160w_100q_1pr.jpg", "画画", 23, "理想主义", "Yesterday once more", "一直播", "双子座", 188337, "高颜值", "安东尼"));
            zhuboController.insert(new ZhuboBean(null, "k", "吉林省", "延边", "魏天浩", "演员", "1180646", "https://alcdn.img.xiaoka.tv/20161007/fe4/e58/1180646/fe4e582696a75ea8c4636839a07a7cc4.jpg@1e_1c_0o_0l_160h_160w_100q_1pr.jpg", "参加公益", 27, "厚道", "Without you", "一直播", "狮子座", 596777, "好才艺", "安东尼"));
            zhuboController.insert(new ZhuboBean(null, "k", "吉林省", "延边", "高露", "演员", "36650322", "https://alcdn.img.xiaoka.tv/20160617/427/14e/36650322/42714e84982b8e0adee8e1368678868d.jpg@1e_1c_0o_0l_160h_160w_100q_1pr.jpg", "画画", 23, "厚道", "hero", "一直播", "狮子座", 295385, "高颜值", "安东尼"));
            zhuboController.insert(new ZhuboBean(null, "k", "安徽省", "芜湖", "胡兵", "明星", "6662933", "https://alcdn.img.xiaoka.tv/20171128/6d0/0ae/6662933/6d00aeb46d89abf8b932bcb507bf76f2.jpg@1e_1c_0o_0l_160h_160w_100q_1pr.jpg", "画画", 27, "热血", "I want it that way", "一直播", "天秤座", 987728, "好才艺", "安东尼"));
            zhuboController.insert(new ZhuboBean(null, "k", "江苏省", "南通", "钱正昊", "歌手", "37239916", "https://alcdn.img.xiaoka.tv/20180827/f67/7ef/0/f677ef60e93bd0d986aaa700a0875ec7.png@1e_1c_0o_0l_160h_160w_100q_1pr.jpg", "画画", 22, "理想主义", "All rise", "一直播", "巨蟹座", 877662, "高颜值", "安东尼"));
            zhuboController.insert(new ZhuboBean(null, "k", "江苏省", "南通", "蒋申", "歌手", "2247502", "https://alcdn.img.xiaoka.tv/20190102/3b7/060/0/3b70605c8119ae1a59d7ca464a1106aa.png@1e_1c_0o_0l_160h_160w_100q_1pr.jpg", "旅游", 27, "靠谱", "The day you went away", "一直播", "水瓶座", 413487, "好才艺", "安东尼"));
            zhuboController.insert(new ZhuboBean(null, "k", "安徽省", "芜湖", "梁靖康Leon", "演员", "63844520", "https://alcdn.img.xiaoka.tv/20181110/de1/7be/0/de17be322ab7a7c7f4ebdabbe2f6b8f6.jpg@1e_1c_0o_0l_160h_160w_100q_1pr.jpg", "画画", 20, "萌萌哒", "pretty girl", "一直播", "天秤座", 87188, "好才艺", "安东尼"));
            zhuboController.insert(new ZhuboBean(null, "k", "江苏省", "南通", "杨美娜MiNa", "歌手", "48532", "https://alcdn.img.xiaoka.tv/20190102/602/11e/48532/60211e719609eaca19fc3700a52dc580.jpg@1e_1c_0o_0l_160h_160w_100q_1pr.jpg", "运动", 27, "大叔控", "Seasons in the sun", "一直播", "天蝎座", 968881, "好才艺", "安东尼"));
            zhuboController.insert(new ZhuboBean(null, "k", "安徽省", "芜湖", "袁福福", "演员", "247990", "https://alcdn.img.xiaoka.tv/20170111/c63/149/247990/c63149f2274a1fa47e011e049652985e.jpg@1e_1c_0o_0l_160h_160w_100q_1pr.jpg", "K歌", 27, "理想主义", "I want it that way", "一直播", "天蝎座", 502460, "搞笑达人", "安东尼"));
            zhuboController.insert(new ZhuboBean(null, "k", "江苏省", "南通", "朴有天_Official", "艺人", "330171024", "https://alcdn.img.xiaoka.tv/20180413/ff6/34c/330171024/ff634c4c72860917b897d285a69ee53c.jpg@1e_1c_0o_0l_160h_160w_100q_1pr.jpg", "爱追剧", 26, "大叔控", "You raise me up", "一直播", "白羊座", 894650, "高颜值", "安东尼"));
            zhuboController.insert(new ZhuboBean(null, "k", "广东省", "深圳", "MIC王一浩Phibian", "艺人", "87472332", "https://alcdn.img.xiaoka.tv/20180531/6f6/df8/87472332/6f6df8dd3d65df87aff6bb9defc03657.jpg@1e_1c_0o_0l_160h_160w_100q_1pr.jpg", "爱追剧", 19, "长发及腰", "pretty girl", "一直播", "天秤座", 439891, "好才艺", "安东尼"));
            zhuboController.insert(new ZhuboBean(null, "k", "广东省", "深圳", "张俪", "明星", "37189426", "https://alcdn.img.xiaoka.tv/20160608/116/0d2/37189426/1160d2fcbdb53fd49c90c60447c4e578.jpg@1e_1c_0o_0l_160h_160w_100q_1pr.jpg", "逛街", 24, "强迫症", "when i believe", "一直播", "天蝎座", 246469, "搞笑达人", "安东尼"));
            zhuboController.insert(new ZhuboBean(null, "k", "福建省", "厦门", "李梦露", "女神", "186815071", "https://alcdn.img.xiaoka.tv/20181217/aea/c31/186815071/aeac31cd9e3ec20da6aaa45e7b1b3cc8.jpg@1e_1c_0o_0l_160h_160w_100q_1pr.jpg", "购物", 18, "强迫症", "Only love", "一直播", "巨蟹座", 706532, "搞笑达人", "安东尼"));
            zhuboController.insert(new ZhuboBean(null, "k", "福建省", "厦门", "秦俊杰", "演员", "33171012", "https://alcdn.img.xiaoka.tv/20170823/0c8/7c5/33171012/0c87c536bbb8c113ffae6ab33f9cc094.jpg@1e_1c_0o_0l_160h_160w_100q_1pr.jpg", "旅游", 25, "宅", "Baby one more time", "一直播", "金牛座", 192171, "好才艺", "安东尼"));
            zhuboController.insert(new ZhuboBean(null, "k", "福建省", "厦门", "戴向宇DAI", "演员", "39514758", "https://alcdn.img.xiaoka.tv/20160714/adb/11f/39514758/adb11f0ecbd9b3f720566f81c37360b3.jpg@1e_1c_0o_0l_160h_160w_100q_1pr.jpg", "听歌", 21, "热血", ".Lonely", "一直播", "水瓶座", 851954, "好才艺", "安东尼"));
            zhuboController.insert(new ZhuboBean(null, "k", "福建省", "厦门", "肖涵HAN", "艺人", "51471012", "https://alcdn.img.xiaoka.tv/20160921/8db/b03/51471012/8dbb03cccfacc0b0c31d041400a74f57.jpg@1e_1c_0o_0l_160h_160w_100q_1pr.jpg", "电影", 22, "强迫症", "I swear", "一直播", "金牛座", 658588, "高颜值", "安东尼"));
            zhuboController.insert(new ZhuboBean(null, "kkkk", "吉林省", "延边", "小可馨呀", "升级升级", "152579692", "https://i3.cdn.xiongmaoxingyan.com/d5d513b9807a3e33f931fc702cdae6ff_w960_h960.jpeg", "煮饭", 26, "靠谱", "Just one last dance", "映客直播", "天蝎座", 554266, "高颜值", "杜兰特"));
            zhuboController.insert(new ZhuboBean(null, "kkkk", "重庆市", "重庆", "歪歪妹er_", "想要被你甜宠哦", "158469062", "https://i0.cdn.xiongmaoxingyan.com/7f913cbc3e628b2c9274730a51d9c071_w960_h960.jpeg", "画画", 21, "长发及腰", "You make me wanna", "映客直播", "双鱼座", 501246, "好才艺", "杜兰特"));
            zhuboController.insert(new ZhuboBean(null, "kkkk", "辽宁省", "大连", "小油鹅", "心里有片海   眼里有束光", "157549226", "https://i4.cdn.xiongmaoxingyan.com/7ce8f537cf407882bb370095153372ff_w960_h960.jpeg", "购物", 23, "萌萌哒", "take me to you heart", "映客直播", "摩羯座", 916579, "搞笑达人", "杜兰特"));
            zhuboController.insert(new ZhuboBean(null, "kkkk", "黑龙江省", "绥化", "小臭臭长大了_", "凉凉主播求升级", "157687474", "https://i4.cdn.xiongmaoxingyan.com/e2bf8512f54cca1b6508ddd32f3051d6_w960_h960.jpeg", "运动", 25, "理想主义", ".Lonely", "映客直播", "处女座", 839498, "好才艺", "杜兰特"));
            zhuboController.insert(new ZhuboBean(null, "kkkk", "江苏省", "南京", "黑姨", "新人唱歌主播 求守护 哈哈", "158454064", "https://i3.cdn.xiongmaoxingyan.com/832a5fd23702e5819c6f1013446967ab_w960_h960.jpeg", "热爱化妆", 27, "厚道", "One love", "映客直播", "双子座", 875514, "高颜值", "杜兰特"));
            zhuboController.insert(new ZhuboBean(null, "kkkk", "辽宁省", "大连", "万能的小啊豫", "啊豫在这里l", "150486536", "https://i0.cdn.xiongmaoxingyan.com/7a9b955de9382572318ca670e7a94617_w960_h960.jpeg", "参加公益", 25, "敢爱敢恨", "In the end", "映客直播", "巨蟹座", 11171, "好才艺", "杜兰特"));
            zhuboController.insert(new ZhuboBean(null, "kkkk", "吉林省", "延边", "小小珑儿", "众筹十万好吗", "150255808", "https://i2.cdn.xiongmaoxingyan.com/8fa1d7c8cd1a0488f909abd326918a04_w960_h960.jpeg", "旅游", 19, "靠谱", "You raise me up", "映客直播", "水瓶座", 605674, "搞笑达人", "杜兰特"));
            zhuboController.insert(new ZhuboBean(null, "kkkk", "辽宁省", "沈阳", "Mua__小轻甜", "莫名我就喜欢你", "138450702", "https://i0.cdn.xiongmaoxingyan.com/16c24b69171da17f712024331c62d523_w960_h960.jpeg", "画画", 25, "讲义气", "Anyone of us", "映客直播", "天秤座", 240417, "好才艺", "杜兰特"));
            zhuboController.insert(new ZhuboBean(null, "kkkk", "黑龙江省", "绥化", "only鑫鑫呀", "1", "158605208", "https://i4.cdn.xiongmaoxingyan.com/b5a79fc7326db0351c6b5e26f8979933_w960_h960.jpeg", "热爱化妆", 20, "大叔控", "Shape of my heart", "映客直播", "天秤座", 528241, "好才艺", "杜兰特"));
            zhuboController.insert(new ZhuboBean(null, "kkkk", "山东省", "日照", "三角pluto", "唱歌爽 一直唱歌一直爽", "157930366", "https://i2.cdn.xiongmaoxingyan.com/2baf216ceb3ae305e1d89cf48ad7a54c_w960_h960.jpeg", "听歌", 24, "大叔控", "I want it that way", "映客直播", "摩羯座", 583838, "好才艺", "杜兰特"));
            zhuboController.insert(new ZhuboBean(null, "kkkk", "山东省", "日照", "郭尔佳佳布鲁根", "面瘫小姐姐", "141202176", "https://i2.cdn.xiongmaoxingyan.com/ec637655e00c553fceda1d26e44c71ae_w960_h960.jpeg", "电影", 18, "大叔控", "Larger than life", "映客直播", "双子座", 204438, "高颜值", "杜兰特"));
            zhuboController.insert(new ZhuboBean(null, "kkkk", "辽宁省", "辽阳", "sandy诺宝", "新主播，求关注", "158398728", "https://i0.cdn.xiongmaoxingyan.com/0dc8a08d116613968dbd789096399f9c_w960_h960.jpeg", "煮饭", 26, "敢爱敢恨", "Hotel california", "映客直播", "巨蟹座", 182432, "搞笑达人", "杜兰特"));
            zhuboController.insert(new ZhuboBean(null, "kkkk", "湖北省", "武汉", "M我不是小可爱", "请注意！您的小可爱已上线", "152197862", "https://i4.cdn.xiongmaoxingyan.com/9424af54c2081e67cf7fdac27a923299_w960_h960.jpeg", "打游戏", 18, "理想主义", "Anyone of us", "映客直播", "处女座", 84943, "好才艺", "杜兰特"));
            zhuboController.insert(new ZhuboBean(null, "kkkk", "湖南省", "长沙", "橙子丨游戏狂魔", "通宵主播了解一下", "157936474", "https://i0.cdn.xiongmaoxingyan.com/efcbaa67db27470f49e59b2fc82ddb5d_w960_h960.jpeg", "热爱化妆", 25, "宅", "Just one last dance", "映客直播", "双鱼座", 178982, "搞笑达人", "杜兰特"));
            zhuboController.insert(new ZhuboBean(null, "kkkk", "福建省", "宁德", "林婠婠", "你是有趣的灵魂吗", "159132916", "https://i.h2.pdim.gs/8f10ecd7cb32eab9b45af23c78f28380.jpeg", "旅游", 26, "文艺少女", "Better man", "映客直播", "双鱼座", 134967, "高颜值", "杜兰特"));
            zhuboController.insert(new ZhuboBean(null, "kkkk", "江西省", "南昌", "一树茶", "可爱又迷人的反派角色", "157706936", "https://i0.cdn.xiongmaoxingyan.com/f90d623c1abb01451dfe278775d8c983_w960_h960.jpeg", "煮饭", 25, "萌萌哒", "beautiful", "映客直播", "双鱼座", 29860, "好才艺", "杜兰特"));
            zhuboController.insert(new ZhuboBean(null, "kkkk", "湖南省", "长沙", "苏夹心", "你的大宝贝", "151916716", "https://i1.cdn.xiongmaoxingyan.com/cf420621f6fc9d2ee2fbdcbb9bbe12e0_w960_h960.jpeg", "电影", 22, "叫我逗逼", "The day you went away", "映客直播", "金牛座", 40757, "高颜值", "杜兰特"));
            zhuboController.insert(new ZhuboBean(null, "kkkk", "广东省", "深圳", "萌七七_", "今天也来看我鸭", "157636140", "https://i.h2.pdim.gs/7df28e83a5dbe8c0a7119cad31514546_w960_h960.jpeg", "运动", 24, "大叔控", "Here i am", "映客直播", "金牛座", 227705, "好才艺", "杜兰特"));
            zhuboController.insert(new ZhuboBean(null, "kkkk", "广东省", "深圳", "冉冉老师", "这么逗比有灵魂的老师你不来？", "158669018", "https://i4.cdn.xiongmaoxingyan.com/357b359188c3fb90849f7143e9fd3098_w960_h960.jpeg", "参加公益", 19, "叫我逗逼", "Larger than life", "映客直播", "天秤座", 936102, "好才艺", "杜兰特"));
            zhuboController.insert(new ZhuboBean(null, "kkkk", "广东省", "广州", "熙敏baby", "一约定领取女朋友", "157773616", "https://i4.cdn.xiongmaoxingyan.com/220b88e9102097efe058e7a7e9b9cd17_w960_h960.jpeg", "参加公益", 19, "双重人格", ".Lonely", "映客直播", "摩羯座", 492086, "高颜值", "杜兰特"));
            zhuboController.insert(new ZhuboBean(null, "kkkk", "江苏省", "南京", "小U米", "做你的猫", "157497886", "https://i1.cdn.xiongmaoxingyan.com/34741d5a1669f6750a5630b9c39169c6_w960_h960.jpeg", "打游戏", 27, "讲义气", "Baby one more time", "映客直播", "巨蟹座", 974979, "高颜值", "杜兰特"));
            zhuboController.insert(new ZhuboBean(null, "kkkk", "辽宁省", "抚顺", "甄家小少爷", "嘎舞", "158268622", "https://i0.cdn.xiongmaoxingyan.com/e7948bbb66d32ee1833172ea5dc2ecad_w960_h960.jpeg", "运动", 23, "靠谱", "when i believe", "映客直播", "水瓶座", 154908, "高颜值", "杜兰特"));
            zhuboController.insert(new ZhuboBean(null, "kkkk", "新疆维吾尔自治区", "新疆", "你的踏雪求守护", "踏雪想升级呀", "157271840", "https://i4.cdn.xiongmaoxingyan.com/b7f50683d086a770f4398d4eb13bd5d7_w960_h960.jpeg", "打游戏", 20, "讲义气", "Yesterday once more", "映客直播", "双鱼座", 734515, "高颜值", "杜兰特"));
            zhuboController.insert(new ZhuboBean(null, "kkkk", "湖南省", "长沙", "瑶仙儿", "么么哒", "154603342", "https://i1.cdn.xiongmaoxingyan.com/d5730153f81dfec378c6cc313026e6f0_w960_h960.jpeg", "打游戏", 25, "文艺少女", "She", "映客直播", "水瓶座", 953057, "高颜值", "杜兰特"));
            zhuboController.insert(new ZhuboBean(null, "kkkk", "湖北省", "咸宁", "年华小仓鼠", "有趣的是灵魂～", "157822028", "https://i2.cdn.xiongmaoxingyan.com/f708a1024fd7b3768835b71490b80aec_w960_h960.jpeg", "运动", 25, "安静", "I want it that way", "映客直播", "金牛座", 683162, "高颜值", "杜兰特"));
            zhuboController.insert(new ZhuboBean(null, "kkkk", "辽宁省", "沈阳", "请求发射明轩h", "轩弟就在自己屋坐等大哥来！", "158743676", "https://i4.cdn.xiongmaoxingyan.com/f0a04cec53561c563dd8690b6241b882_w960_h960.jpeg", "画画", 24, "讲义气", "Complicated", "映客直播", "双鱼座", 848421, "好才艺", "杜兰特"));
            zhuboController.insert(new ZhuboBean(null, "kkkk", "山东省", "济宁", "城南第一吹", "来看我直播啦！！！！！", "157792708", "https://i4.cdn.xiongmaoxingyan.com/12eaf967f0933b29fe58563c6fc44c1f_w960_h960.jpeg", "电影", 25, "热血", "One love", "映客直播", "巨蟹座", 154765, "搞笑达人", "杜兰特"));
            zhuboController.insert(new ZhuboBean(null, "kkkk", "山东省", "日照", "云公子吖", "主播养成计", "158609716", "https://i4.cdn.xiongmaoxingyan.com/96a2f369f0884f9f06266f4a753607ce_w960_h960.jpeg", "爱追剧", 22, "敢爱敢恨", "Take me to your heart", "映客直播", "双鱼座", 616531, "高颜值", "杜兰特"));


            zhuboController.insert(new ZhuboBean(null, "kkkk", "新疆维吾尔自治区", "新疆", "小五子麦芽糖", "月底冲刺啊~~~过任务", "135266286", "https://i4.cdn.xiongmaoxingyan.com/e1e4a251e549cdfebbe167141071533d_w338_h190.jpeg", "听歌", 20, "萌萌哒", "Shape of my heart", "火山小视频", "天蝎座", 990126, "高颜值", "史蒂夫"));
            zhuboController.insert(new ZhuboBean(null, "kkkk", "新疆维吾尔自治区", "新疆", "小葱豆腐ing", "新人尬舞主播了解一下", "154825064", "https://i2.cdn.xiongmaoxingyan.com/3bcc3f0b422a9e456abc93cebbd2f4b1_w338_h190.jpeg", "电影", 26, "敢爱敢恨", "Cry on my shoulder", "火山小视频", "天秤座", 152097, "好才艺", "史蒂夫"));
            zhuboController.insert(new ZhuboBean(null, "kkkk", "山东省", "济宁", "仙女菲m", "小仙女，我想。。。", "114611828", "https://i4.cdn.xiongmaoxingyan.com/302f928c3f123053a646ff85c8b2e077_w338_h190.jpeg", "吃喝拉睡", 18, "文艺少女", "The day you went away", "火山小视频", "双鱼座", 365711, "搞笑达人", "史蒂夫"));
            zhuboController.insert(new ZhuboBean(null, "kkkk", "山东省", "济宁", "菇七七啊", "吃饭吗", "127633980", "https://image.xingyan.panda.tv/cbfee5b937b9f37ea4b2aa8938047098_w338_h190.jpeg", "K歌", 26, "文艺少女", "Yesterday once more", "火山小视频", "处女座", 856685, "高颜值", "史蒂夫"));
            zhuboController.insert(new ZhuboBean(null, "kkkk", "山东省", "济宁", "BABE优拉", "小可爱求守护 整点跳舞", "151800292", "https://i2.cdn.xiongmaoxingyan.com/d189cc143427137b07f37928fe6a9e21_w338_h190.jpeg", "热爱化妆", 20, "靠谱", "I could be the one", "火山小视频", "双鱼座", 16965, "好才艺", "史蒂夫"));
            zhuboController.insert(new ZhuboBean(null, "kkkk", "湖北省", "咸宁", "小小小奶琦", "肉感主播上线了！！！", "130753700", "https://i2.cdn.xiongmaoxingyan.com/284216d0b3348b3afe272931d550da40_w338_h190.jpeg", "打游戏", 24, "强迫症", "I want it that way", "火山小视频", "白羊座", 322842, "好才艺", "史蒂夫"));
            zhuboController.insert(new ZhuboBean(null, "kkkk", "湖北省", "咸宁", "艾雅琳", "热舞新人", "135704252", "https://i1.cdn.xiongmaoxingyan.com/6d7b0a68e6d05ee96694dc3ba8774bd5_w338_h190.jpeg", "听歌", 27, "萌萌哒", "You raise me up", "火山小视频", "金牛座", 724959, "搞笑达人", "史蒂夫"));
            zhuboController.insert(new ZhuboBean(null, "kkkk", "湖南省", "长沙", "N念念", "36H大兄弟了解一下", "3973374", "https://i1.cdn.xiongmaoxingyan.com/0739ec078e5a1205ec50c19197c79242_w338_h190.jpeg", "吃喝拉睡", 20, "喜欢简单", "Cry on my shoulder", "火山小视频", "水瓶座", 59746, "高颜值", "史蒂夫"));
            zhuboController.insert(new ZhuboBean(null, "kkkk", "湖南省", "长沙", "優優de毒藥", "帝王蟹领取~上海腿模小姐姐", "49142180", "https://i0.cdn.xiongmaoxingyan.com/25cfe6bebff96ea3fd4a3e9c42267f94_w338_h190.jpeg", "爱追剧", 22, "叫我逗逼", "I swear", "火山小视频", "狮子座", 649940, "高颜值", "史蒂夫"));
            zhuboController.insert(new ZhuboBean(null, "kkkk", "湖北省", "咸宁", "美Mira", "晚上好，直播了~", "137775556", "https://i2.cdn.xiongmaoxingyan.com/afc9044b17eb731b81190b0bdb8dac37_w338_h190.jpeg", "旅游", 27, "敢爱敢恨", "Only love", "火山小视频", "天蝎座", 536290, "好才艺", "史蒂夫"));
            zhuboController.insert(new ZhuboBean(null, "kkkk", "江苏省", "南京", "百变小八月", "可否  保护我", "132654198", "https://i0.cdn.xiongmaoxingyan.com/daa6e1d9694d6b24ddd841d25e9b94bb_w338_h190.jpeg", "购物", 23, "靠谱", "In the end", "火山小视频", "金牛座", 265126, "高颜值", "史蒂夫"));
            zhuboController.insert(new ZhuboBean(null, "kkkk", "江苏省", "南京", "大娇1", "快春节了随遇直播吧", "151867852", "https://i4.cdn.xiongmaoxingyan.com/fcb09e8be7cb470f9ec2fe66a35a0e3d_w338_h190.jpeg", "爱追剧", 18, "宅", "The day you went away", "火山小视频", "白羊座", 928425, "好才艺", "史蒂夫"));
            zhuboController.insert(new ZhuboBean(null, "kkkk", "江苏省", "南京", "小喵n", "很幸运遇见你们", "137055980", "https://i1.cdn.xiongmaoxingyan.com/f187f67199b306a72bb88fefd69e1f97_w338_h190.jpeg", "打游戏", 18, "喜欢简单", "You raise me up", "火山小视频", "双子座", 868100, "好才艺", "史蒂夫"));
            zhuboController.insert(new ZhuboBean(null, "kkkk", "天津市", "天津", "大长腿美女组合", "热舞美女游戏pk美女", "157634330", "http://image.huajiao.com/a9af21d53d62da9a897df775dc731da7-320_320.jpg", "煮饭", 21, "大叔控", "hero", "火山小视频", "白羊座", 364361, "高颜值", "史蒂夫"));
            zhuboController.insert(new ZhuboBean(null, "kkkk", "天津市", "天津", "XM栗子lee", "(跳舞)感谢你的承诺，承蒙厚爱~", "152184810", "http://image.huajiao.com/d89ed0ee41a03e48173f645d1a3db3b8-320_320.jpg", "听歌", 20, "双重人格", "Shape of my heart", "火山小视频", "双子座", 849672, "好才艺", "史蒂夫"));
            zhuboController.insert(new ZhuboBean(null, "kkkk", "天津市", "天津", "黑涩0", "80.90经典老歌新人求关注", "84918638", "https://i4.cdn.xiongmaoxingyan.com/b5b675901ef87ec9628e9b1d019a9386_w338_h190.jpeg", "电影", 19, "理想主义", "Scarborough fair", "火山小视频", "狮子座", 541206, "搞笑达人", "史蒂夫"));
            zhuboController.insert(new ZhuboBean(null, "kkkk", "江苏省", "南京", "念念想你了", "新舞蹈主播上线啦", "158503306", "https://i1.cdn.xiongmaoxingyan.com/228bd126ccc8c7fd9695c9f51496a273_w338_h190.jpeg", "参加公益", 27, "讲义气", "Dying in the sun", "火山小视频", "处女座", 704416, "高颜值", "史蒂夫"));
            zhuboController.insert(new ZhuboBean(null, "kkkk", "湖北省", "咸宁", "阿尤233", "了解一哈", "153991360", "https://i1.cdn.xiongmaoxingyan.com/5db94587dd74c460502757b6f84b9043_w338_h190.jpeg", "听歌", 23, "宅", "My heart will go on", "火山小视频", "天秤座", 646389, "高颜值", "史蒂夫"));
            zhuboController.insert(new ZhuboBean(null, "kkkk", "湖北省", "咸宁", "许胤遥吖丶", "你的对A湖南一米五袜控女友", "127296586", "https://i4.cdn.xiongmaoxingyan.com/8ece205bfc1d1c992f7368facf9212a0_w338_h190.jpeg", "热爱化妆", 23, "萌萌哒", "Scarborough fair", "火山小视频", "天蝎座", 806459, "好才艺", "史蒂夫"));
            zhuboController.insert(new ZhuboBean(null, "kkkk", "江苏省", "南京", "亚玲H", "新人直播多多关照谢谢！！", "156918198", "https://i0.cdn.xiongmaoxingyan.com/1ad35a3b14ceeded2413e03873f0f165_w338_h190.jpeg", "画画", 18, "喜欢简单", "take me to you heart", "火山小视频", "处女座", 855146, "好才艺", "史蒂夫"));
            zhuboController.insert(new ZhuboBean(null, "kkkk", "湖南省", "长沙", "王六一Oops", "如果拥抱遥不可及，让我用声音温暖你", "94068160", "https://i0.cdn.xiongmaoxingyan.com/5731df6697400900915100a357eb4c6a_w338_h190.jpeg", "购物", 24, "讲义气", "My love", "快手短视频", "水瓶座", 932837, "搞笑达人", "史蒂夫"));
            zhuboController.insert(new ZhuboBean(null, "kkkk", "江苏省", "南京", "苏小九啊", "别开枪，让我先打你", "3354116", "https://i.h2.pdim.gs/a400cb6ef87b4fbe88e039f0a71ae85e_w338_h190.jpeg", "K歌", 24, "吃货", "I want it that way", "快手短视频", "巨蟹座", 840608, "好才艺", "史蒂夫"));
            zhuboController.insert(new ZhuboBean(null, "kkkk", "湖北省", "咸宁", "旺仔灬baby", "人美歌甜 冰雪聪明的小可爱", "157677606", "https://i1.cdn.xiongmaoxingyan.com/c72fd4d3c14222721c34efdf1e34f2b8_w338_h190.jpeg", "K歌", 18, "萌萌哒", "Better man", "快手短视频", "金牛座", 119260, "好才艺", "史蒂夫"));
            zhuboController.insert(new ZhuboBean(null, "kkkk", "江苏省", "南京", "顾小冉g", "会跳舞的小改改", "153629566", "https://i2.cdn.xiongmaoxingyan.com/710eed4e43c830b3e2bc08094909dede_w338_h190.jpeg", "旅游", 27, "安静", "Never had a dream come true", "快手短视频", "天秤座", 185385, "高颜值", "史蒂夫"));
            zhuboController.insert(new ZhuboBean(null, "kkkk", "湖北省", "咸宁", "TT灵魂", "抽奖抽抽抽", "4440954", "http://image.huajiao.com/739edeebcdc24fe62485ed77edd58d5e-320_320.jpg", "画画", 26, "双重人格", "All rise", "映客直播", "天秤座", 628883, "搞笑达人", "史蒂夫"));
            zhuboController.insert(new ZhuboBean(null, "kkkk", "湖北省", "咸宁", "川岛蕙子", "还记得我们初次见面的样子吗~~", "155592324", "https://i4.cdn.xiongmaoxingyan.com/e57f571b70ace5032607ee77174a9769_w338_h190.jpeg", "画画", 23, "讲义气", "In the end", "快手短视频", "白羊座", 162614, "好才艺", "史蒂夫"));
            zhuboController.insert(new ZhuboBean(null, "kkkk", "湖北省", "咸宁", "超级无敌可爱橘", "难忘的是当初的自己。", "29387862", "https://i2.cdn.xiongmaoxingyan.com/8e3a874c8f224daf24b7eb57afbf4c5e_w338_h190.jpeg", "电影", 23, "文艺少女", "God is a girl", "快手短视频", "射手座", 836844, "好才艺", "史蒂夫"));
            zhuboController.insert(new ZhuboBean(null, "kkkk", "湖北省", "咸宁", "Lin梵", "感谢陪我的时光", "138710896", "https://i.h2.pdim.gs/529d1d681d9248b24e64e611e8a2e1b6_w338_h190.jpeg", "爱追剧", 27, "理想主义", "My heart will go on", "快手短视频", "金牛座", 597216, "搞笑达人", "史蒂夫"));
            zhuboController.insert(new ZhuboBean(null, "kkkk", "湖北省", "咸宁", "Monoi的小王国", "随机~~~~~~", "98884336", "https://i.h2.pdim.gs/4008b25a4a0a85a0b65563ed3d34255e_w338_h190.jpeg", "打游戏", 21, "吃货", "Never had a dream come true", "快手短视频", "双子座", 632418, "高颜值", "史蒂夫"));
            zhuboController.insert(new ZhuboBean(null, "kkkk", "江苏省", "南京", "美爷m", "送帝王蟹内容很舒服", "33465900", "https://i3.cdn.xiongmaoxingyan.com/bb5deb492df96a76fd265cc567be8e16_w338_h190.jpeg", "购物", 23, "大叔控", "beautiful", "映客直播", "狮子座", 170796, "高颜值", "史蒂夫"));
            zhuboController.insert(new ZhuboBean(null, "kkkk", "江苏省", "南京", "Xx摩卡", "众筹渡劫。。。。。。。", "152939774", "https://i1.cdn.xiongmaoxingyan.com/57729df628436ba626b981d5a290d0fd_w338_h190.jpeg", "电影", 26, "文艺少女", "Larger than life", "快手短视频", "金牛座", 827035, "搞笑达人", "史蒂夫"));
            zhuboController.insert(new ZhuboBean(null, "kkkk", "陕西省", "西安", "牛牛灬真好", "整点跳舞  ……", "133292340", "http://image.huajiao.com/56c269ac97c97729b5cd373a52dc4482-320_320.jpg", "K歌", 21, "文艺少女", "All rise", "映客直播", "双鱼座", 841220, "好才艺", "史蒂夫"));
            zhuboController.insert(new ZhuboBean(null, "kkkk", "陕西省", "西安", "丹丹呀i", "新人热舞主播", "157235804", "http://image.huajiao.com/d61dda4f4c3556d3b93da0322b5d0065-320_320.jpg", "听歌", 22, "长发及腰", "Never had a dream come true", "快手短视频", "处女座", 407099, "好才艺", "史蒂夫"));
            zhuboController.insert(new ZhuboBean(null, "kkkk", "陕西省", "西安", "小侑侑", "木得灵魂的侑侑", "156511124", "https://i3.cdn.xiongmaoxingyan.com/c83d7e51de207eb1cb2019357f173418_w338_h190.jpeg", "爱追剧", 23, "双重人格", "Here i am", "快手短视频", "天秤座", 572936, "好才艺", "史蒂夫"));
            zhuboController.insert(new ZhuboBean(null, "kkkk", "广东省", "广州", "Tt大宝", "大宝好哇塞的！！！！！", "95597684", "https://i2.cdn.xiongmaoxingyan.com/b9149e3754ea65354f06c84d91335a30_w338_h190.jpeg", "逛街", 19, "吃货", "Cry on my shoulder", "快手短视频", "水瓶座", 630045, "好才艺", "史蒂夫"));
            zhuboController.insert(new ZhuboBean(null, "kkkk", "陕西省", "西安", "若芸__涵", "宝宝们众筹升级啦", "150064252", "https://i3.cdn.xiongmaoxingyan.com/229dbda7e6d57d57641c697280b66925_w338_h190.jpeg", "吃喝拉睡", 18, "靠谱", "Baby one more time", "快手短视频", "水瓶座", 814740, "好才艺", "史蒂夫"));
            zhuboController.insert(new ZhuboBean(null, "kkkk", "陕西省", "西安", "啊芳小主播", "勿忘初心", "157130084", "https://i4.cdn.xiongmaoxingyan.com/dc964209df5bf9d1ec8a8f8dfe474412_w338_h190.jpeg", "画画", 23, "热血", "Only love", "快手短视频", "处女座", 294858, "搞笑达人", "史蒂夫"));
            zhuboController.insert(new ZhuboBean(null, "kkkk", "陕西省", "西安", "牙酱呀", "三有主播了解一下", "156621552", "https://i.h2.pdim.gs/d1551f8cbb4e44723f7ee43815bc8519_w338_h190.jpeg", "画画", 27, "厚道", "Anyone of us", "快手短视频", "天蝎座", 865069, "高颜值", "史蒂夫"));
            zhuboController.insert(new ZhuboBean(null, "kkkk", "陕西省", "西安", "你躲躲很哇塞", "梵小躲~~大艺术家····", "134384660", "https://i1.cdn.xiongmaoxingyan.com/d823d6540c786051d221144e77d56684_w338_h190.jpeg", "爱追剧", 25, "文艺少女", "Here i am", "映客直播", "双子座", 966504, "搞笑达人", "史蒂夫"));
            zhuboController.insert(new ZhuboBean(null, "kkkk", "陕西省", "西安", "林喵喵呀", "膝盖发炎，今天是尬聊主播", "105145848", "https://i0.cdn.xiongmaoxingyan.com/e6854c4ffb456e09fc3e92073243a62a_w338_h190.jpeg", "画画", 27, "双重人格", "Cry on my shoulder", "快手短视频", "巨蟹座", 881131, "高颜值", "史蒂夫"));
            zhuboController.insert(new ZhuboBean(null, "kkkk", "广东省", "广州", "小熙妍吖", "简单的陪伴最长远，懂你的人最温暖~", "151267940", "https://i4.cdn.xiongmaoxingyan.com/ee0185dc5d95331d804ffceb30ed5970_w338_h190.jpeg", "购物", 27, "双重人格", "pretty girl", "快手短视频", "狮子座", 268040, "高颜值", "史蒂夫"));
            zhuboController.insert(new ZhuboBean(null, "kkkk", "广东省", "广州", "XM双双", "你是我坚持下去的动力！", "151589696", "http://image.huajiao.com/0c897370fbc2802b02015aad34cc4d28-320_320.jpg", "打游戏", 24, "安静", "Bye bye bye", "映客直播", "双鱼座", 220697, "好才艺", "史蒂夫"));
            zhuboController.insert(new ZhuboBean(null, "kkkk", "陕西省", "西安", "麻辣姐灬", "新主播，求订阅，谢谢各位小哥哥", "157609520", "https://i0.cdn.xiongmaoxingyan.com/1bbd84ee09df63c2fb653c7cb4272ee8_w338_h190.jpeg", "画画", 27, "叫我逗逼", "I swear", "快手短视频", "白羊座", 423149, "高颜值", "史蒂夫"));
            zhuboController.insert(new ZhuboBean(null, "kkkk", "江苏省", "南京", "Lin悠悠", "#即刻电音#熊猫蹦迪选手", "88768466", "https://i3.cdn.xiongmaoxingyan.com/2a873b9eb10784a250187cd5fa0b3ce9_w338_h190.jpeg", "爱追剧", 27, "长发及腰", "Scarborough fair", "快手短视频", "处女座", 660512, "高颜值", "史蒂夫"));
            zhuboController.insert(new ZhuboBean(null, "kkkk", "广东省", "广州", "一个小小依", "快过年了还不来带我回家吗", "146967472", "https://i1.cdn.xiongmaoxingyan.com/03f97e558ac80fe66b1c8fca3598d71f_w338_h190.jpeg", "电影", 22, "双重人格", "Only love", "快手短视频", "天蝎座", 212311, "高颜值", "史蒂夫"));
            zhuboController.insert(new ZhuboBean(null, "kkkk", "湖南省", "长沙", "荔枝小欧尼", "唱歌新人求真爱卡日榜鸭！！！", "31910032", "https://i1.cdn.xiongmaoxingyan.com/b024ca1b6c4b04131b3cfe45b42b425b_w338_h190.jpeg", "逛街", 25, "敢爱敢恨", "take me to you heart", "虎牙直播", "白羊座", 872684, "高颜值", "史蒂夫"));
            zhuboController.insert(new ZhuboBean(null, "kkkk", "广东省", "广州", "小药药呀", "有人宠才显得出众", "154735952", "https://i3.cdn.xiongmaoxingyan.com/fb4b304f577bd6298aaba4f8a91f1e74_w338_h190.jpeg", "电影", 20, "安静", "I want it that way", "映客直播", "天蝎座", 152499, "高颜值", "史蒂夫"));
            zhuboController.insert(new ZhuboBean(null, "kkkk", "陕西省", "西安", "小语菲", "啦啦啦", "152035732", "https://i1.cdn.xiongmaoxingyan.com/c7e77eb44777ff49c70193f908861672_w338_h190.jpeg", "运动", 18, "叫我逗逼", "All rise", "映客直播", "天蝎座", 122728, "搞笑达人", "史蒂夫"));
            zhuboController.insert(new ZhuboBean(null, "kkkk", "陕西省", "西安", "我是婷大吖", "宝贝们，来啦！~~~", "154077588", "https://i2.cdn.xiongmaoxingyan.com/a6dadc3c3e9a2a26eabb1d377dcbca38_w338_h190.jpeg", "吃喝拉睡", 26, "文艺少女", "Without you", "虎牙直播", "天秤座", 606448, "高颜值", "史蒂夫"));
            zhuboController.insert(new ZhuboBean(null, "kkkk", "陕西省", "西安", "瑶然月", "撒娇女人最好命~", "134006868", "https://i1.cdn.xiongmaoxingyan.com/c8bc51db105a77161bc73f2fc1b3ff5a_w338_h190.jpeg", "听歌", 22, "安静", "Anyone of us", "虎牙直播", "金牛座", 196014, "搞笑达人", "史蒂夫"));
            zhuboController.insert(new ZhuboBean(null, "kkkk", "广东省", "广州", "园园萧", "我知道远方有诗句，也知道没有你", "154195538", "https://i3.cdn.xiongmaoxingyan.com/3e8e2b3e8a4448afae22d5d645ea953c_w338_h190.jpeg", "电影", 20, "长发及腰", "Shape of my heart", "映客直播", "水瓶座", 334008, "高颜值", "史蒂夫"));
            zhuboController.insert(new ZhuboBean(null, "kkkk", "广东省", "广州", "芯儿大长腿", "36E美腿女王要渡劫", "156891782", "https://i.h2.pdim.gs/eab84173fa80104a42fe26f755ee667e_w338_h190.jpeg", "逛街", 20, "强迫症", "Moonlight shadow", "虎牙直播", "处女座", 982185, "高颜值", "史蒂夫"));
            zhuboController.insert(new ZhuboBean(null, "kkkk", "广东省", "广州", "大橙子拉拉", "重庆小姐姐，龙虾领走", "153835824", "http://image.huajiao.com/23b9f663b331c6a97e543eb07fc30289-320_320.jpg", "参加公益", 26, "理想主义", "hero", "虎牙直播", "处女座", 104398, "好才艺", "史蒂夫"));
            zhuboController.insert(new ZhuboBean(null, "kkkk", "陕西省", "西安", "小乔666_yov", "这个主播38E", "157014384", "https://i3.cdn.xiongmaoxingyan.com/7bbfd0abf7f2b917b1850fc0346560a0_w338_h190.jpeg", "逛街", 20, "长发及腰", "I swear", "虎牙直播", "巨蟹座", 321603, "搞笑达人", "史蒂夫"));
            zhuboController.insert(new ZhuboBean(null, "kkkk", "川省", "成都", "皮皮佳LI", "聊天么我很乖的", "155279780", "https://i1.cdn.xiongmaoxingyan.com/208c475a3b4728a3c3ca6a6dc6e36029_w338_h190.jpeg", "打游戏", 19, "喜欢简单", "Only love", "虎牙直播", "处女座", 961525, "高颜值", "史蒂夫"));
            zhuboController.insert(new ZhuboBean(null, "kkkk", "陕西省", "西安", "OvO一只小曼曼", "韩国小学生", "152969466", "https://i3.cdn.xiongmaoxingyan.com/5614a5974eb186c9c57e2f171511653f_w338_h190.jpeg", "煮饭", 20, "萌萌哒", "I could be the one", "虎牙直播", "天蝎座", 719432, "高颜值", "史蒂夫"));
            zhuboController.insert(new ZhuboBean(null, "kkkk", "川省", "成都", "kiko妹妹", "新人求守护求关注mua", "158351838", "http://image.huajiao.com/b4456e0ffce671f44949ecf51974e07b-320_320.jpg", "吃喝拉睡", 21, "喜欢简单", "Thank you", "虎牙直播", "金牛座", 970476, "高颜值", "史蒂夫"));
            zhuboController.insert(new ZhuboBean(null, "kkkk", "陕西省", "西安", "Crystal顾熙", "千山万水总是情让我升级行不行", "156311668", "https://i2.cdn.xiongmaoxingyan.com/ea3f187df1299e6538b305e10f0cb734_w338_h190.jpeg", "运动", 23, "长发及腰", "Scarborough fair", "虎牙直播", "双子座", 389773, "好才艺", "史蒂夫"));
            zhuboController.insert(new ZhuboBean(null, "kkkk", "陕西省", "西安", "毛毛虫晕晕哒", "毛毛虫晕晕哒，跳舞新主播求关注", "154369676", "https://i2.cdn.xiongmaoxingyan.com/9b35f533204d0f57d92ddaf1cae73e95_w338_h190.jpeg", "热爱化妆", 25, "讲义气", "Only love", "虎牙直播", "天秤座", 245552, "高颜值", "史蒂夫"));
            zhuboController.insert(new ZhuboBean(null, "kkkk", "陕西省", "西安", "panda小初恋", "想做你的小公主只吃糖来不吃苦", "159153424", "http://image.huajiao.com/5424d3cb79c333669e7e7929dbc69006-320_320.jpg", "电影", 23, "长发及腰", "Seasons in the sun", "虎牙直播", "金牛座", 35769, "搞笑达人", "史蒂夫"));
            zhuboController.insert(new ZhuboBean(null, "kkkk", "云南省", "昆明", "教主Baby", "能唱能跳能撩", "157720544", "https://i3.cdn.xiongmaoxingyan.com/32369525d7eebda3a530c7c2c010d0c3_w338_h190.jpeg", "热爱化妆", 21, "敢爱敢恨", "i still believe", "虎牙直播", "射手座", 570362, "高颜值", "史蒂夫"));
            zhuboController.insert(new ZhuboBean(null, "kkkk", "川省", "成都", "沫abcd", "多肉的 新主播", "157684648", "http://image.huajiao.com/65c7f90396efc5a32ead79baec7bbcf5-320_320.jpg", "旅游", 21, "文艺少女", ".You are not alone", "虎牙直播", "处女座", 486449, "好才艺", "史蒂夫"));
            zhuboController.insert(new ZhuboBean(null, "kkkk", "云南省", "昆明", "国际尚雅大大", "在等你。반갑습니다", "118675228", "http://image.huajiao.com/9af9595978984b2cc0b23aec30b7ed97-320_320.jpg", "电影", 23, "靠谱", "Numb", "映客直播", "摩羯座", 48662, "好才艺", "史蒂夫"));
            zhuboController.insert(new ZhuboBean(null, "kkkk", "川省", "成都", "安吉丽娜朱妮", "小草莓渴望爱情", "158453474", "http://image.huajiao.com/2016824b398110c95fc0a8a1c14c77d0-320_320.jpg", "爱追剧", 25, "宅", "take me to you heart", "虎牙直播", "处女座", 184911, "高颜值", "史蒂夫"));
            zhuboController.insert(new ZhuboBean(null, "kkkk", "浙江省", "杭州", "秋水伊人雪", "新人求订阅~~主播很白哦~~~", "158455966", "http://image.huajiao.com/0ef1358b2d03002739805760feea6f79-320_320.jpg", "热爱化妆", 19, "宅", "Take me to your heart", "虎牙直播", "射手座", 178535, "搞笑达人", "史蒂夫"));
            zhuboController.insert(new ZhuboBean(null, "kkkk", "川省", "成都", "阿珂babe", "灵魂歌手了解一下", "154505932", "https://i1.cdn.xiongmaoxingyan.com/77af05ec52545f3790fc0c672eefabff_w338_h190.jpeg", "K歌", 18, "文艺少女", "Hotel california", "虎牙直播", "摩羯座", 896068, "好才艺", "史蒂夫"));
            zhuboController.insert(new ZhuboBean(null, "kkkk", "浙江省", "杭州", "萌小小66", "陪伴是最长情的告白", "158445980", "https://i0.cdn.xiongmaoxingyan.com/f24e502963a210efb146b0703810ecdd_w338_h190.jpeg", "旅游", 21, "理想主义", "Thank you", "虎牙直播", "射手座", 308582, "搞笑达人", "史蒂夫"));
            zhuboController.insert(new ZhuboBean(null, "kkkk", "浙江省", "杭州", "兔伢伢", "新主播求订阅", "154182198", "https://i1.cdn.xiongmaoxingyan.com/8fbfd082419aca6698ad77bc98bb6086_w338_h190.jpeg", "热爱化妆", 26, "理想主义", "Seasons in the sun", "虎牙直播", "天蝎座", 419633, "搞笑达人", "史蒂夫"));
            zhuboController.insert(new ZhuboBean(null, "kkkk", "川省", "成都", "柒点儿阿", "每天都在夹缝中生存", "59203654", "http://image.huajiao.com/2373afa69278747c1ee42bd632255632-320_320.jpg", "购物", 24, "靠谱", "Complicated", "虎牙直播", "狮子座", 227056, "搞笑达人", "史蒂夫"));


        }

    }
}