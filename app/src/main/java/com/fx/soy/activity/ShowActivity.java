package com.fx.soy.activity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.fx.soy.R;
import com.fx.soy.adapter.ItemAdapter;
import com.fx.soy.entity.Soy;
import com.fx.soy.helper.DBHelper;
import com.fx.soy.util.ExcelUtil;

import org.litepal.tablemanager.Connector;

import java.util.ArrayList;
import java.util.List;

import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class ShowActivity extends AppCompatActivity {

    private TextView mAdd;

    private List<Soy> mSoyList = new ArrayList<>();

    private Button mOut;

    private ItemAdapter adapter;

    private Soy newSoy;

    private Soy temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        Connector.getDatabase();
        initSoy();
        adapter = new ItemAdapter(ShowActivity.this, R.layout.item, mSoyList);
        ListView listView = (ListView) findViewById(R.id.lv_show);
        listView.setAdapter(adapter);
        mAdd = (TextView) findViewById(R.id.tv_add);
        mAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(ShowActivity.this, AddActivity.class), 1);
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ShowActivity.this, EditActivity.class);
                intent.putExtra("mSoy", mSoyList.get(position));
                intent.putExtra("id", mSoyList.get(position).getId());
                startActivityForResult(intent, 5);
                temp=mSoyList.get(position);
                mSoyList.remove(mSoyList.get(position));
            }
        });
        mOut = (Button) findViewById(R.id.bt_out);
        mOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(ShowActivity.this, WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(ShowActivity.this, new String[]{WRITE_EXTERNAL_STORAGE}, 1);
                } else {
                    try {
                        ExcelUtil.writeExcel(ShowActivity.this, mSoyList, "大豆数据");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                ArrayList<Soy> soyList = data.getParcelableArrayListExtra("soyList");
                for (com.fx.soy.entity.Soy soy : soyList) {
                    mSoyList.add(soy);
                }
                adapter.notifyDataSetChanged();
            }
        }
        if (requestCode == 5) {
            if (resultCode == RESULT_OK) {
                newSoy=data.getParcelableExtra("newSoy");
                if (newSoy!=null){
                    mSoyList.add(newSoy);
                    adapter.notifyDataSetChanged();
                    newSoy=null;
                }else {
                    mSoyList.add(temp);
                    adapter.notifyDataSetChanged();
                }
            }
        }
    }

    private void initSoy() {
        List<Soy> soyList = DBHelper.queryAll();
        if (soyList != null) {
            mSoyList = soyList;
        }
        mSoyList = soyList;
    }
}
