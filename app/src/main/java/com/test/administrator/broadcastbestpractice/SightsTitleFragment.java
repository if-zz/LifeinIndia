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
 * Created by Administrator on 2015/8/25.
 */
public class SightsTitleFragment extends Fragment implements AdapterView.OnItemClickListener{
    private ListView sightsTitleListView;
    private List<News> sightsList;
    private NewsAdapter adapter;
    private boolean isTwoPane;
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        sightsList=getNews();//初始化新闻数据
        adapter=new NewsAdapter(activity,R.layout.news_item,sightsList);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.news_title_frag,container,false);
        sightsTitleListView=(ListView)view.findViewById(R.id.news_title_list_view);
        sightsTitleListView.setAdapter(adapter);
        sightsTitleListView.setOnItemClickListener(this);
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
        News news=sightsList.get(position);
        if(isTwoPane){
            //如果是双页模式，则刷新NewsContentFragment中的内容
            SightsContentFragment sightsContentFragment=(SightsContentFragment)getFragmentManager()
                    .findFragmentById(R.id.sights_content_fragment);
            sightsContentFragment.refresh(news.getTitle(),news.getContent(),news.getImageId());
        }else {
            //如果是单页模式，则直接启动NewsContentActivity
            NewsContentActivity.actionStart(getActivity(),news.getTitle(),news.getContent(),news.getImageId());
        }
    }
    private List<News> getNews(){
        List<News> sightsList=new ArrayList<>();
        News news1=new News();
        news1.setTitle("印度“金三角”");
        news1.setContent("   每个人都有想去印度的一大堆理由，这个地图像母牛的乳房的土地喂养出一个大国，有喜马拉雅山挡住北方的寒流，有印度洋暖流温柔的包裹，这是一个色彩鲜艳、历史复杂的国家。而德里、阿格拉、斋浦尔被称之为印度旅游的“金三角”，盖因这三地凝结了印度古老的历史人文的精华所在。" +
                "“金三角”因这3个城市构成的一个三角形而得名，3个城市各自代表印度的3个重要时期：印度现首都——德里，也是印度在英国殖民地时期的首都；阿格拉是印度16、17世纪时莫卧儿王朝的定都城市；斋浦尔则是印度教经典建筑的代表。");
        news1.setImageId(R.mipmap.sight1);
        sightsList.add(news1);
        News news2=new News();
        news2.setTitle("斋普尔”");
        news2.setContent("");
        news2.setImageId(R.mipmap.ic_launcher);
        sightsList.add(news2);
        News news3=new News();
        news3.setTitle("阿格拉");
        sightsList.add(news3);
        News news4=new News();
        news4.setTitle("新德里");
        sightsList.add(news4);
        News news5=new News();
        news5.setTitle("安伯堡");
        sightsList.add(news5);
        News news6=new News();
        news6.setTitle("城市宫殿");
        sightsList.add(news6);
        News news7=new News();
        news7.setTitle("姜塔曼塔天文台");
        sightsList.add(news7);
        News news8=new News();
        news8.setTitle("古德卜高塔");
        sightsList.add(news8);
        News news9=new News();
        news9.setTitle("巴哈伊寺庙");
        sightsList.add(news9);
        News news10=new News();
        news10.setTitle("杰尔宫殿");
        sightsList.add(news10);
        News news11=new News();
        news11.setTitle("泰姬陵");
        sightsList.add(news11);
        return sightsList;
    }
}
