package com.example.chapter3.homework;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.LinkedList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MsgFragment extends Fragment {


    public MsgFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_msg, container, false);
        LinkedList mdata = new LinkedList<MsgClass>();
        mdata.add(new MsgClass("陌生人消息","yaya: 转发[直播]：七舅老爷", "1 min 前",R.mipmap.session_stranger));
        mdata.add(new MsgClass("系统消息","账号登陆提醒", "2 min 前",R.mipmap.session_system_notice));
        mdata.add(new MsgClass("抖音小助手","# 收下我的双下巴祝福", "3 min 前",R.mipmap.session_robot));
        mdata.add(new MsgClass("nono","转发[视频]", "4 min 前",R.mipmap.h));
        mdata.add(new MsgClass("yoyo","在吗？接下快递", "5 min 前",R.mipmap.icon_girl));
        mdata.add(new MsgClass("拉拉","我是拉拉，我们开始聊天吧", "7 min 前",R.mipmap.g));
        mdata.add(new MsgClass("df","有时间吗", "10 min 前",R.mipmap.a));
        mdata.add(new MsgClass("shannel","[Hi]", "1 天 前",R.mipmap.b));

        ListView listView = view.findViewById(R.id.listview);
        listView.setAdapter(new ListViewAdapter(mdata,getContext()));
        return view;
    }

    public static class ListViewAdapter extends BaseAdapter {

        private LinkedList<MsgClass> mData;
        private Context mContext;

        public ListViewAdapter(LinkedList<MsgClass> mData, Context mContext) {
            this.mData = mData;
            this.mContext = mContext;
        }

        @Override
        public int getCount() {
            return mData.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.msg_list_item,parent,false);
            ImageView img = (ImageView) convertView.findViewById(R.id.img);
            TextView msg = (TextView) convertView.findViewById(R.id.message);
            TextView time = (TextView) convertView.findViewById(R.id.time);
            TextView title = (TextView) convertView.findViewById(R.id.title);
            img.setImageResource(mData.get(position).getImg());
            msg.setText(mData.get(position).getMessage());
            time.setText(mData.get(position).getTime());
            title.setText(mData.get(position).getTitle());
            return convertView;
        }
    }

}
