package com.fx.soy.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.fx.soy.R;
import com.fx.soy.entity.Soy;
import com.fx.soy.helper.DBHelper;

import java.util.List;

/**
 * Created by fx on 2017/3/9.
 */

public class ItemAdapter extends ArrayAdapter<Soy> {

    private int resourceId;

    List<Soy> mList;

    public ItemAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Soy> objects) {
        super(context, resource, objects);
        resourceId=resource;
        mList=objects;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable final View convertView, @NonNull final ViewGroup parent) {
        final Soy soy =getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView==null){
            view=LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
            viewHolder=new ViewHolder();
            viewHolder.date= (TextView) view.findViewById(R.id.show_date);
            viewHolder.name= (TextView) view.findViewById(R.id.show_name);
            viewHolder.delete= (Button) view.findViewById(R.id.bt_delete);
            view.setTag(viewHolder);
        }else {
            view=convertView;
            viewHolder= (ViewHolder) view.getTag();
        }
        viewHolder.date.setText(soy.getCollectDate()+" "+ soy.getCollectTime());
        viewHolder.name.setText(soy.getCollectName());
        viewHolder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper.delete(soy);
                mList.remove(soy);
                notifyDataSetChanged();
            }
        });
        return view;
    }

    class ViewHolder{
        TextView date;
        TextView name;
        Button delete;
    }
}
