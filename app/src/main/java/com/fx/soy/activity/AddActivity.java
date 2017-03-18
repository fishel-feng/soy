package com.fx.soy.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import com.fx.soy.R;
import com.fx.soy.entity.Soy;
import com.fx.soy.helper.DBHelper;

import java.util.ArrayList;


public class AddActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mSeedDate;
    private Button mEmergeDate;
    private Spinner mEmergeRate;
    private Spinner mFlowerColor;
    private Spinner mLeafShape;
    private Spinner mHairColor;
    private Spinner mHullsColor;
    private Spinner mPodHabit;
    private EditText mPlantHeight;
    private EditText mPodHeight;
    private EditText mStemNumber;
    private EditText mEffectiveBranch;
    private EditText mEffectivePodNumberOfOne;
    private Button mLodgingDate;
    private Spinner mLodgingDegree;
    private EditText mLodgingRate;
    private Spinner mBacterialSpotDiseases;
    private Spinner mDownyMildew;
    private Spinner mGrayLeafSpot;
    private Spinner mSclerotiniaSclerotiorum;
    private Spinner mViruses;
    private Spinner mNematodeDisease;
    private EditText mAreaLength;
    private EditText mRidgeDistance;
    private EditText mCollectArea;
    private EditText mCollectName;
    private Button mCollectDate;
    private Button mCollectTime;

    private Button mDefault;
    private Button mSubmit;

    private ArrayList<Soy> mSoyList = new ArrayList<>();

    DefaultHolder mHolder = new DefaultHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        initEvents();
    }

    private void initView() {
        mSeedDate = (Button) findViewById(R.id.btn_seed_date);
        mEmergeDate = (Button) findViewById(R.id.btn_emerge_date);
        mEmergeRate = (Spinner) findViewById(R.id.sp_emerge_rate);
        mFlowerColor = (Spinner) findViewById(R.id.sp_flower_color);
        mLeafShape = (Spinner) findViewById(R.id.sp_leaf_shape);
        mHairColor = (Spinner) findViewById(R.id.sp_hair_color);
        mHullsColor = (Spinner) findViewById(R.id.sp_hulls_color);
        mPodHabit = (Spinner) findViewById(R.id.sp_pod_habit);
        mPlantHeight = (EditText) findViewById(R.id.et_plant_height);
        mPodHeight = (EditText) findViewById(R.id.et_pod_height);
        mStemNumber = (EditText) findViewById(R.id.et_stem_number);
        mEffectiveBranch = (EditText) findViewById(R.id.et_effective_branch);
        mEffectivePodNumberOfOne = (EditText) findViewById(R.id.et_effective_pod_number_of_one);
        mLodgingDate = (Button) findViewById(R.id.btn_lodging_date);
        mLodgingDegree = (Spinner) findViewById(R.id.sp_lodging_degree);
        mLodgingRate = (EditText) findViewById(R.id.et_lodging_rate);
        mBacterialSpotDiseases = (Spinner) findViewById(R.id.sp_bacterial_spot_diseases);
        mDownyMildew = (Spinner) findViewById(R.id.sp_downy_mildew);
        mGrayLeafSpot = (Spinner) findViewById(R.id.sp_gray_leaf_spot);
        mSclerotiniaSclerotiorum = (Spinner) findViewById(R.id.sp_sclerotinia_sclerotiorum);
        mViruses = (Spinner) findViewById(R.id.sp_viruses);
        mNematodeDisease = (Spinner) findViewById(R.id.sp_nematode_disease);
        mAreaLength = (EditText) findViewById(R.id.et_area_length);
        mRidgeDistance = (EditText) findViewById(R.id.et_ridge_distance);
        mCollectArea = (EditText) findViewById(R.id.et_collect_area);
        mCollectName = (EditText) findViewById(R.id.et_collect_name);
        mCollectDate = (Button) findViewById(R.id.btn_collect_date);
        mCollectTime = (Button) findViewById(R.id.btn_collect_time);

        mDefault = (Button) findViewById(R.id.btn_default);
        mSubmit = (Button) findViewById(R.id.btn_submit);
    }

    private void initData() {
        if (mHolder.mSeedDate != null) {
            mSeedDate.setText(mHolder.mSeedDate);
        } else {
            mSeedDate.setText("未选择");
        }
        if (mHolder.mEmergeDate != null) {
            mEmergeDate.setText(mHolder.mEmergeDate);
        } else {
            mEmergeDate.setText("未选择");
        }
        mEmergeRate.setSelection(mHolder.mEmergeRate);
        mFlowerColor.setSelection(mHolder.mFlowerColor);
        mLeafShape.setSelection(mHolder.mLeafShape);
        mHairColor.setSelection(mHolder.mHairColor);
        mHullsColor.setSelection(mHolder.mHullsColor);
        mPodHabit.setSelection(mHolder.mPodHabit);
        mPlantHeight.setText("");
        mPodHeight.setText("");
        mStemNumber.setText("");
        mEffectiveBranch.setText("");
        mEffectivePodNumberOfOne.setText("");
        mLodgingDate.setText("未选择");
        mLodgingDegree.setSelection(0);
        mLodgingRate.setText("");
        mBacterialSpotDiseases.setSelection(0);
        mDownyMildew.setSelection(0);
        mGrayLeafSpot.setSelection(0);
        mSclerotiniaSclerotiorum.setSelection(0);
        mViruses.setSelection(0);
        mNematodeDisease.setSelection(0);
        mAreaLength.setText("");
        if (mHolder.mRidgeDistance!=null){
            mRidgeDistance.setText(mHolder.mRidgeDistance.trim());
        }else {
            mRidgeDistance.setText("");
        }
        if (mHolder.mCollectArea!=null){
            mCollectArea.setText(mHolder.mCollectArea.trim());
        }else {
            mCollectArea.setText("");
        }
        if (mHolder.mCollectName!=null){
            mCollectName.setText(mHolder.mCollectName.trim());
        }else {
            mCollectName.setText("");
        }
        if (mHolder.mCollectDate!=null){
            mCollectDate.setText(mHolder.mCollectDate);
        }else {
            mCollectDate.setText("未选择");
        }
        if (mHolder.mCollectTime!=null){
            mCollectTime.setText(mHolder.mCollectTime);
        }else {
            mCollectTime.setText("未选择");
        }
    }

    private void initEvents() {
        mSeedDate.setOnClickListener(this);
        mEmergeDate.setOnClickListener(this);
        mLodgingDate.setOnClickListener(this);
        mCollectDate.setOnClickListener(this);
        mCollectTime.setOnClickListener(this);

        mDefault.setOnClickListener(this);
        mSubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_seed_date:
                AlertDialog.Builder builder = new AlertDialog.Builder(AddActivity.this);
                LayoutInflater inflater = LayoutInflater.from(AddActivity.this);
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
            case R.id.btn_emerge_date:
                AlertDialog.Builder builder1 = new AlertDialog.Builder(AddActivity.this);
                LayoutInflater inflater1 = LayoutInflater.from(AddActivity.this);
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
            case R.id.btn_lodging_date:
                AlertDialog.Builder builder2 = new AlertDialog.Builder(AddActivity.this);
                LayoutInflater inflater2 = LayoutInflater.from(AddActivity.this);
                View viewDialog2 = inflater2.inflate(R.layout.date, null);
                final DatePicker datePicker2 = (DatePicker) viewDialog2.findViewById(R.id.datePicker);
                builder2.setView(viewDialog2);
                builder2.setTitle("选择倒伏日期");
                builder2.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String date = datePicker2.getYear() + "-" + (datePicker2.getMonth() + 1) + "-" + datePicker2.getDayOfMonth();
                        mLodgingDate.setText(date);
                    }
                });
                builder2.setNegativeButton("取消", null);
                builder2.create().show();
                break;
            case R.id.btn_collect_date:
                AlertDialog.Builder builder3 = new AlertDialog.Builder(AddActivity.this);
                LayoutInflater inflater3 = LayoutInflater.from(AddActivity.this);
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
            case R.id.btn_collect_time:
                AlertDialog.Builder builder4 = new AlertDialog.Builder(AddActivity.this);
                LayoutInflater inflater4 = LayoutInflater.from(AddActivity.this);
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
            case R.id.btn_submit:
                Soy mSoy = new Soy();
                mSoy.setSeedDate(String.valueOf(mSeedDate.getText()));
                mSoy.setEmergeDate(String.valueOf(mEmergeDate.getText()));
                mSoy.setEmergeRate(String.valueOf(mEmergeRate.getSelectedItem()));
                mSoy.setFlowerColor(String.valueOf(mLeafShape.getSelectedItem()));
                mSoy.setLeafShape(String.valueOf(mLeafShape.getSelectedItem()));
                mSoy.setHairColor(String.valueOf(mHairColor.getSelectedItem()));
                mSoy.setHullsColor(String.valueOf(mHullsColor.getSelectedItem()));
                mSoy.setPodHabit(String.valueOf(mPodHabit.getSelectedItem()));
                mSoy.setPlantHeight(String.valueOf(mPlantHeight.getText()));
                mSoy.setPodHeight(String.valueOf(mPodHeight.getText()));
                mSoy.setStemNumber(String.valueOf(mStemNumber.getText()));
                mSoy.setEffectiveBranch(String.valueOf(mEffectiveBranch.getText()));
                mSoy.setEffectivePodNumberOfOne(String.valueOf(mEffectivePodNumberOfOne.getText()));
                mSoy.setLodgingDate(String.valueOf(mLodgingDate.getText()));
                mSoy.setLodgingDegree(String.valueOf(mLodgingDegree.getSelectedItem()));
                mSoy.setLodgingRate(String.valueOf(mLodgingRate.getText()));
                mSoy.setBacterialSpotDiseases(String.valueOf(mBacterialSpotDiseases.getSelectedItem()));
                mSoy.setDownyMildew(String.valueOf(mDownyMildew.getSelectedItem()));
                mSoy.setGrayLeafSpot(String.valueOf(mGrayLeafSpot.getSelectedItem()));
                mSoy.setSclerotiniaSclerotiorum(String.valueOf(mSclerotiniaSclerotiorum.getSelectedItem()));
                mSoy.setViruses(String.valueOf(mViruses.getSelectedItem()));
                mSoy.setNematodeDisease(String.valueOf(mNematodeDisease.getSelectedItem()));
                mSoy.setAreaLength(String.valueOf(mAreaLength.getText()));
                mSoy.setRidgeDistance(String.valueOf(mRidgeDistance.getText()));
                mSoy.setCollectArea(String.valueOf(mCollectArea.getText()));
                mSoy.setCollectName(String.valueOf(mCollectName.getText()));
                mSoy.setCollectDate(String.valueOf(mCollectDate.getText()));
                mSoy.setCollectTime(String.valueOf(mCollectTime.getText()));
                if ("".equals(mSoy.getCollectName().trim()) || mSoy.getCollectName() == null || "未选择".equals(mSoy.getCollectDate()) || "未选择".equals(mSoy.getCollectTime())) {
                    Toast.makeText(this, "采集人姓名和采集日期时间不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                DBHelper.save(mSoy);
                mSoyList.add(mSoy);
                Toast.makeText(this, "保存成功", Toast.LENGTH_SHORT).show();
                initData();
                break;
            case R.id.btn_default:
                startActivityForResult(new Intent(this, DefaultValueActivity.class), 0);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
                mHolder.mSeedDate = data.getStringExtra("seedDate");
                mHolder.mEmergeDate = data.getStringExtra("emergeDate");
                mHolder.mEmergeRate = data.getIntExtra("emergeRate", 0);
                mHolder.mFlowerColor = data.getIntExtra("flowerColor", 0);
                mHolder.mLeafShape = data.getIntExtra("leafShape", 0);
                mHolder.mHairColor = data.getIntExtra("hairColor", 0);
                mHolder.mHullsColor = data.getIntExtra("hullsColor", 0);
                mHolder.mPodHabit = data.getIntExtra("podHabit", 0);
                mHolder.mRidgeDistance = data.getStringExtra("ridgeDistance");
                mHolder.mCollectArea = data.getStringExtra("collectArea");
                mHolder.mCollectName = data.getStringExtra("collectName");
                mHolder.mCollectDate = data.getStringExtra("collectDate");
                mHolder.mCollectTime = data.getStringExtra("collectTime");
                mSeedDate.setText(mHolder.mSeedDate);
                mEmergeDate.setText(mHolder.mEmergeDate);
                mEmergeRate.setSelection(mHolder.mEmergeRate);
                mFlowerColor.setSelection(mHolder.mFlowerColor);
                mLeafShape.setSelection(mHolder.mLeafShape);
                mHairColor.setSelection(mHolder.mHairColor);
                mHullsColor.setSelection(mHolder.mHullsColor);
                mPodHabit.setSelection(mHolder.mPodHabit);
                mRidgeDistance.setText(mHolder.mRidgeDistance);
                mCollectArea.setText(mHolder.mCollectArea);
                mCollectName.setText(mHolder.mCollectName);
                mCollectDate.setText(mHolder.mCollectDate);
                mCollectTime.setText(mHolder.mCollectTime);
            }
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            Intent intent = new Intent();
            intent.putParcelableArrayListExtra("soyList", mSoyList);
            setResult(RESULT_OK, intent);
            finish();
            return true;
        }
        return false;
    }

    class DefaultHolder {
        String mSeedDate;
        String mEmergeDate;
        int mEmergeRate;
        int mFlowerColor;
        int mLeafShape;
        int mHairColor;
        int mHullsColor;
        int mPodHabit;
        String mRidgeDistance;
        String mCollectArea;
        String mCollectName;
        String mCollectDate;
        String mCollectTime;
    }
}
