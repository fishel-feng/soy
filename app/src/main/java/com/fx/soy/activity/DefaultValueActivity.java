package com.fx.soy.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;

import com.fx.soy.R;

public class DefaultValueActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mPlace;
    private EditText mGeneration;
    private Button mSeedDate;
    private Button mEmergeDate;
    private Spinner mEmergeRate;
    private Spinner mFlowerColor;
    private Spinner mLeafShape;
    private Spinner mHairColor;
    private Spinner mHullsColor;
    private Spinner mPodHabit;
    private EditText mRidgeDistance;
    private EditText mCollectArea;
    private EditText mCollectName;
    private Button mCollectDate;
    private Button mCollectTime;

    private Button mSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_default_value);
        initView();
        initData();
        initEvents();
    }

    private void initView() {
        mPlace = (EditText) findViewById(R.id.et_place_default);
        mGeneration = (EditText) findViewById(R.id.et_generation_default);
        mSeedDate = (Button) findViewById(R.id.btn_seed_date_default);
        mEmergeDate = (Button) findViewById(R.id.btn_emerge_date_default);
        mEmergeRate = (Spinner) findViewById(R.id.sp_emerge_rate_default);
        mFlowerColor = (Spinner) findViewById(R.id.sp_flower_color_default);
        mLeafShape = (Spinner) findViewById(R.id.sp_leaf_shape_default);
        mHairColor = (Spinner) findViewById(R.id.sp_hair_color_default);
        mHullsColor = (Spinner) findViewById(R.id.sp_hulls_color_default);
        mPodHabit = (Spinner) findViewById(R.id.sp_pod_habit_default);
        mRidgeDistance = (EditText) findViewById(R.id.et_ridge_distance_default);
        mCollectArea = (EditText) findViewById(R.id.et_collect_area_default);
        mCollectName = (EditText) findViewById(R.id.et_collect_name_default);
        mCollectDate = (Button) findViewById(R.id.btn_collect_date_default);
        mCollectTime = (Button) findViewById(R.id.btn_collect_time_default);

        mSubmit = (Button) findViewById(R.id.btn_submit_default);
    }

    private void initData() {
        mPlace.setText("");
        mGeneration.setText("");
        mSeedDate.setText("未选择");
        mEmergeDate.setText("未选择");
        mEmergeRate.setSelection(0);
        mFlowerColor.setSelection(0);
        mLeafShape.setSelection(0);
        mHairColor.setSelection(0);
        mHullsColor.setSelection(0);
        mPodHabit.setSelection(0);
        mRidgeDistance.setText("");
        mCollectArea.setText("");
        mCollectName.setText("");
        mCollectDate.setText("未选择");
        mCollectTime.setText("未选择");
    }

    private void initEvents() {
        mSeedDate.setOnClickListener(this);
        mEmergeDate.setOnClickListener(this);
        mCollectDate.setOnClickListener(this);
        mCollectTime.setOnClickListener(this);

        mSubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_seed_date_default:
                AlertDialog.Builder builder = new AlertDialog.Builder(DefaultValueActivity.this);
                LayoutInflater inflater = LayoutInflater.from(DefaultValueActivity.this);
                View viewDialog = inflater.inflate(R.layout.date, null);
                final DatePicker datePicker = (DatePicker) viewDialog.findViewById(R.id.datePicker);
                builder.setView(viewDialog);
                builder.setTitle("选择播种日期");
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String date = datePicker.getYear() + "-" + (datePicker.getMonth() + 1) + "-" + datePicker.getDayOfMonth();
                        mSeedDate.setText(date);
                    }
                });
                builder.setNegativeButton("取消", null);
                builder.create().show();
                break;
            case R.id.btn_emerge_date_default:
                AlertDialog.Builder builder1 = new AlertDialog.Builder(DefaultValueActivity.this);
                LayoutInflater inflater1 = LayoutInflater.from(DefaultValueActivity.this);
                View viewDialog1 = inflater1.inflate(R.layout.date, null);
                final DatePicker datePicker1 = (DatePicker) viewDialog1.findViewById(R.id.datePicker);
                builder1.setView(viewDialog1);
                builder1.setTitle("选择出苗日期");
                builder1.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String date = datePicker1.getYear() + "-" + (datePicker1.getMonth() + 1) + "-" + datePicker1.getDayOfMonth();
                        mEmergeDate.setText(date);
                    }
                });
                builder1.setNegativeButton("取消", null);
                builder1.create().show();
                break;
            case R.id.btn_collect_date_default:
                AlertDialog.Builder builder3 = new AlertDialog.Builder(DefaultValueActivity.this);
                LayoutInflater inflater3 = LayoutInflater.from(DefaultValueActivity.this);
                View viewDialog3 = inflater3.inflate(R.layout.date, null);
                final DatePicker datePicker3 = (DatePicker) viewDialog3.findViewById(R.id.datePicker);
                builder3.setView(viewDialog3);
                builder3.setTitle("选择采集日期");
                builder3.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String date = datePicker3.getYear() + "-" + (datePicker3.getMonth() + 1) + "-" + datePicker3.getDayOfMonth();
                        mCollectDate.setText(date);
                    }
                });
                builder3.setNegativeButton("取消", null);
                builder3.create().show();
                break;
            case R.id.btn_collect_time_default:
                AlertDialog.Builder builder4 = new AlertDialog.Builder(DefaultValueActivity.this);
                LayoutInflater inflater4 = LayoutInflater.from(DefaultValueActivity.this);
                View viewDialog4 = inflater4.inflate(R.layout.time, null);
                final TimePicker timePicker = (TimePicker) viewDialog4.findViewById(R.id.timePicker);
                timePicker.setIs24HourView(true);
                builder4.setView(viewDialog4);
                builder4.setTitle("选择采集时间");
                builder4.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String time = timePicker.getCurrentHour() + ":" + timePicker.getCurrentMinute();
                        mCollectTime.setText(time);
                    }
                });
                builder4.setNegativeButton("取消", null);
                builder4.create().show();
                break;
            case R.id.btn_submit_default:
                String place = String.valueOf(mPlace.getText());
                String generation = String.valueOf(mGeneration.getText());
                String seedDate= String.valueOf(mSeedDate.getText());
                String emergeDate= String.valueOf(mEmergeDate.getText());
                int emergeRate=mEmergeRate.getSelectedItemPosition();
                int flowerColor=mFlowerColor.getSelectedItemPosition();
                int leafShape=mLeafShape.getSelectedItemPosition();
                int hairColor=mHairColor.getSelectedItemPosition();
                int hullsColor=mHullsColor.getSelectedItemPosition();
                int podHabit=mPodHabit.getSelectedItemPosition();
                String ridgeDistance= String.valueOf(mRidgeDistance.getText());
                String collectArea= String.valueOf(mCollectArea.getText());
                String collectName= String.valueOf(mCollectName.getText());
                String collectDate= String.valueOf(mCollectDate.getText());
                String collectTime= (String) mCollectTime.getText();
                Intent intent=new Intent();
                intent.putExtra("place", place);
                intent.putExtra("generation", generation);
                intent.putExtra("seedDate",seedDate);
                intent.putExtra("emergeDate",emergeDate);
                intent.putExtra("emergeRate",emergeRate);
                intent.putExtra("flowerColor",flowerColor);
                intent.putExtra("leafShape",leafShape);
                intent.putExtra("hairColor",hairColor);
                intent.putExtra("hullsColor",hullsColor);
                intent.putExtra("podHabit",podHabit);
                intent.putExtra("ridgeDistance",ridgeDistance);
                intent.putExtra("collectArea",collectArea);
                intent.putExtra("collectName",collectName);
                intent.putExtra("collectDate",collectDate);
                intent.putExtra("collectTime",collectTime);
                setResult(RESULT_OK, intent);
                finish();
                break;
            default:
                break;
        }
    }
}
