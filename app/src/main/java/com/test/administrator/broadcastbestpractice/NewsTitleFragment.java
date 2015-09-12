package com.test.administrator.broadcastbestpractice;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/8/17.
 */
public class NewsTitleFragment extends Fragment implements AdapterView.OnItemClickListener{
    private ListView newsTitleListView;
    private List<News> newsList;
    private NewsAdapter adapter;
    private boolean isTwoPane;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        newsList=getNews();//初始化新闻数据
        adapter=new NewsAdapter(activity,R.layout.news_item,newsList);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.news_title_frag,container,false);
        newsTitleListView=(ListView)view.findViewById(R.id.news_title_list_view);
        newsTitleListView.setAdapter(adapter);
        newsTitleListView.setOnItemClickListener(this);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(getActivity().findViewById(R.id.news_content_layout)!=null){
            isTwoPane=true;//可以找到news_content_layout布局时，为双页模式

        }
        else {
            isTwoPane=false;//找不到news_content_layout布局时，为单页模式
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        News news=newsList.get(position);
        if(isTwoPane){
            //如果是双页模式，则刷新NewsContentFragment中的内容
            NewsContentFragment newsContentFragment=(NewsContentFragment)getFragmentManager()
                    .findFragmentById(R.id.news_content_fragment);
            newsContentFragment.refresh(news.getTitle(),news.getContent(),news.getImageId());
        }else {
            //如果是单页模式，则直接启动NewsContentActivity
            NewsContentActivity.actionStart(getActivity(),news.getTitle(),news.getContent(),news.getImageId());
        }
    }
    private List<News> getNews(){
        List<News> newsList=new ArrayList<>();
        News news1=new News();
        news1.setTitle("The Zero & First Day");
        news1.setContent("   第0天：我们经过了曼谷，跨越了印度洋，飞往印度。（不得不说泰航的航班质量真不错，" +
                "吃的好，服务态度更好） " +
                "    7月22日，这是我们来到印度VIT大学的第一天，要说感想，只有“累”这一个字了。话说回来，从凌晨左" +
                "右抵达印度到现在，按照国内时间计算的话，从飞机起飞手机关机到现在，我已经失联接近24小时了……" +
                "希望能尽快将网络开通，恢复通信。希望中国大使馆的电话还没有被寻人启示打爆，爸妈应该没有在关注最近的航班失事的消息吧……\n" +
                "    现在，谈谈初到印度的感想吧。就天气方面，因为VIT大学位于印度Chennai，是一座沿海城市，所以" +
                "当晚的感受就是风大而潮湿。当时我还挺庆幸的，居然还挺凉快。然而今天我就明白了，我想多了。" +
                "通俗点说，就是紫外线很强，据未证实的情报，在日光下2个小时以上就可能被晒伤。出门请务必做好防晒措施。\n" +
                "    再说说印度人的办事效率吧，今天一天，感觉我们除了把项目费用交了以外什么事也没有解决。14:30赶到教室办理ID卡，" +
                "结果神奇的工作人员在静静的坐到16:00后，告诉我们他们17:00左右就要下班了，只能办理10个人了。没错，" +
                "就是你不找他办事他就可以整个下午什么事都不干。多么机智的工作方式啊！\n" +
                "    在印度的第一天，最后总结一句话：“我要回家〒▽〒”\n");
        news1.setImageId(R.mipmap.day1);
        newsList.add(news1);
        News news2=new News();
        news2.setTitle("The Second Day");
        news2.setContent("");
        news2.setImageId(R.mipmap.ic_launcher);
        newsList.add(news2);
        News news3=new News();
        news3.setTitle("The Thrid Day");
        newsList.add(news3);
        News news4=new News();
        news4.setTitle("Day:7.26");
        newsList.add(news4);
        News news5=new News();
        news5.setTitle("Day:7.27");
        newsList.add(news5);
        News news6=new News();
        news6.setTitle("Day:7.28");
        newsList.add(news6);
        News news7=new News();
        news7.setTitle("Day:7.29");
        newsList.add(news7);
        News news8=new News();
        news8.setTitle("Day:7.30");
        newsList.add(news8);

        News news9=new News();
        news9.setTitle("Day:7.31");
        newsList.add(news9);
        News news10=new News();
        news10.setTitle("Day:8.1");
        newsList.add(news10);
        News news11=new News();
        news11.setTitle("Day:8.2");
        newsList.add(news11);
        News news12=new News();
        news12.setTitle("Day:8.3");
        newsList.add(news12);
        News news13=new News();
        news13.setTitle("Day:8.4");
        newsList.add(news13);
        return newsList;
    }
}
