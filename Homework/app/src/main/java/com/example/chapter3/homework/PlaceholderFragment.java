package com.example.chapter3.homework;


import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

import java.util.LinkedList;

public class PlaceholderFragment extends Fragment {

    private ListView listView;
    private LottieAnimationView animationView;
    LinkedList contacts = new LinkedList<ContactClass>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO ex3-3: 修改 fragment_placeholder，添加 loading 控件和列表视图控件

        View view = inflater.inflate(R.layout.fragment_placeholder, container, false);
        listView = view.findViewById(R.id.listview);
//        listView.setVisibility(View.INVISIBLE);
        animationView = view.findViewById(R.id.animation_view);
        animationView.playAnimation();


        contacts.add(new ContactClass("yoyo","HAPPY",R.mipmap.g));
        contacts.add(new ContactClass("木木","牙疼",R.mipmap.h));
        contacts.add(new ContactClass("tina","....",R.mipmap.i));
        contacts.add(new ContactClass("bit","coding...",R.mipmap.j));
        contacts.add(new ContactClass("cs","come on",R.mipmap.k));
        contacts.add(new ContactClass("小新","有趣的灵魂百里挑一",R.mipmap.p));
        contacts.add(new ContactClass("rain","喜欢(❤ ω ❤)下雨天",R.mipmap.m));
        contacts.add(new ContactClass("嗷嗷嗷","😄",R.mipmap.n));


//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent = new Intent(PlaceholderFragment.this, Jump2.class);
//                intent.putExtra("position", String.valueOf(position));
//                Intent intent = null;
//                try {
//                    intent = new Intent(ListViewActivity.this, Class.forName("com.ss.android.ugc.chapter1.MainActivity"));
//                } catch (ClassNotFoundException e) {
//                    e.printStackTrace();
//                }
//                startActivity(intent);
//        });

        return view;
    }

    public static class ListViewAdapter extends BaseAdapter {

        private LinkedList<ContactClass> contacts;
        private Context mContext;

        public ListViewAdapter(LinkedList<ContactClass> contacts, Context mContext) {
            this.contacts = contacts;
            this.mContext = mContext;
        }

        @Override
        public int getCount() {
            return contacts.size();
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
            convertView = LayoutInflater.from(mContext).inflate(R.layout.contact_list_item,parent,false);
            ImageView img = (ImageView) convertView.findViewById(R.id.img);
            TextView name = (TextView) convertView.findViewById(R.id.name);
            TextView signature = (TextView) convertView.findViewById(R.id.signature);
            img.setImageResource(contacts.get(position).getImg());
            name.setText(contacts.get(position).getName());
            signature.setText(contacts.get(position).getSignature());
            return convertView;
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getView().postDelayed(new Runnable() {
            @Override
            public void run() {
                // 这里会在 5s 后执行
                // TODO ex3-4：实现动画，将 lottie 控件淡出，列表数据淡入
                listView.setAdapter(new ListViewAdapter(contacts,getContext()));
                ObjectAnimator alphaAnimationView = ObjectAnimator.ofFloat(animationView,
                        "alpha",1.0f,0.0f
                );
                alphaAnimationView.setDuration(400);
                ObjectAnimator alphaListView = ObjectAnimator.ofFloat(listView,
                        "alpha",0.0f,1.0f
                );
                alphaListView.setDuration(400);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(alphaAnimationView,alphaListView);
                animatorSet.start();
            }
        }, 5000);
    }
}
