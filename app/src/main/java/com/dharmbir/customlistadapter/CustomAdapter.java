package com.dharmbir.customlistadapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by choudhary on 27/02/17.
 */

public class CustomAdapter extends BaseAdapter {

    Activity activity;
    List<UserM> users;
    LayoutInflater inflater;

    public CustomAdapter(Activity activity, List<UserM> users) {
        this.activity   = activity;
        this.users      = users;
        this.inflater   = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;

        if (convertView == null){

            convertView = inflater.inflate(R.layout.list_item, parent, false);

            holder = new ViewHolder();

            holder.tvUserName    = (TextView) convertView.findViewById(R.id.tv_user_name);
            holder.tvDescription = (TextView) convertView.findViewById(R.id.tv_description);

            holder.ivUserProfile = (ImageView) convertView.findViewById(R.id.iv_usr_profile);

            convertView.setTag(holder);
        }else
            holder = (ViewHolder)convertView.getTag();

        UserM user = users.get(position);

        holder.tvUserName.setText(user.getName());
        holder.tvDescription.setText(user.getDescription());

        Picasso.with(activity)
                .load(user.getImage())
                .into(holder.ivUserProfile);

        return convertView;
    }

    public class ViewHolder{

        TextView tvUserName;
        TextView tvDescription;

        ImageView ivUserProfile;

    }
}
