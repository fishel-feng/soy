package com.fx.soy.activity;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.fx.soy.R;
import com.fx.soy.entity.Soy;
import com.fx.soy.helper.DBHelper;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class AddActivity extends AppCompatActivity implements View.OnClickListener, TextWatcher {

    private EditText mPlace;
    private EditText mGeneration;
    private EditText mLine;
    private EditText mStrain;
    private EditText mMaleParent;
    private EditText mFemaleParent;
    private EditText mName;
    private Button mSeedDate;
    private Button mBranchDate;
    private Button mFloweringDate;
    private Button mPoddingDate;
    private Button mMatureDate;
    private Button mEmergeDate;
    private Spinner mEmergeRate;
    private Spinner mFlowerColor;
    private Spinner mLeafColor;
    private Spinner mLeafShape;
    private Spinner mHairColor;
    private Spinner mHullsColor;
    private Spinner mPodHabit;
    private Spinner mHundredGrainWeight;
    private EditText mPlantHeight;
    private EditText mPodHeight;
    private EditText mStemNumber;
    private EditText mEffectiveBranch;
    private EditText mEffectivePodNumberOfOne;
    private Button mLodgingDate;
    private Spinner mLodgingDegree;
    private EditText mLodgingRate;
    private Spinner mBacterialSpotDiseases;
    private Button mBacterialSpotDiseasesDate;
    private Spinner mDownyMildew;
    private Button mDownyMildewDate;
    private Spinner mGrayLeafSpot;
    private Button mGrayLeafSpotDate;
    private Spinner mSclerotiniaSclerotiorum;
    private Button mSclerotiniaSclerotiorumDate;
    private Spinner mViruses;
    private Button mVirusesDate;
    private Spinner mNematodeDisease;
    private Button mNematodeDiseaseDate;
    private Spinner mAphidResistance;
    private Spinner mEsophagealResistance;
    private EditText mOnePodNumber;
    private EditText mTwoPodNumber;
    private EditText mThreePodNumber;
    private EditText mFourPodNumber;
    private TextView mTotalPodNumber;
    private EditText mAreaLength;
    private EditText mRidgeDistance;
    private EditText mCollectArea;
    private EditText mCollectName;
    private Button mCollectDate;
    private Button mCollectTime;
    private EditText mEvaluate;
    private EditText mRemark;
    private Button mDefault;
    private Button mSubmit;

    private Button mPhoto;

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
        mPlace = (EditText) findViewById(R.id.et_place);
        mGeneration = (EditText) findViewById(R.id.et_generation);
        mLine = (EditText) findViewById(R.id.et_line);
        mStrain = (EditText) findViewById(R.id.et_strain);
        mMaleParent = (EditText) findViewById(R.id.et_male_parent);
        mFemaleParent = (EditText) findViewById(R.id.et_female_parent);
        mName = (EditText) findViewById(R.id.et_name);
        mSeedDate = (Button) findViewById(R.id.btn_seed_date);
        mBranchDate = (Button) findViewById(R.id.btn_branch_date);
        mFloweringDate = (Button) findViewById(R.id.btn_flowering_date);
        mPoddingDate = (Button) findViewById(R.id.btn_podding_date);
        mMatureDate = (Button) findViewById(R.id.btn_mature_date);
        mEmergeDate = (Button) findViewById(R.id.btn_emerge_date);
        mEmergeRate = (Spinner) findViewById(R.id.sp_emerge_rate);
        mFlowerColor = (Spinner) findViewById(R.id.sp_flower_color);
        mLeafColor = (Spinner) findViewById(R.id.sp_leaf_color);
        mLeafShape = (Spinner) findViewById(R.id.sp_leaf_shape);
        mHairColor = (Spinner) findViewById(R.id.sp_hair_color);
        mHullsColor = (Spinner) findViewById(R.id.sp_hulls_color);
        mPodHabit = (Spinner) findViewById(R.id.sp_pod_habit);
        mHundredGrainWeight = (Spinner) findViewById(R.id.sp_hundred_grain_weight);
        mPlantHeight = (EditText) findViewById(R.id.et_plant_height);
        mPodHeight = (EditText) findViewById(R.id.et_pod_height);
        mStemNumber = (EditText) findViewById(R.id.et_stem_number);
        mEffectiveBranch = (EditText) findViewById(R.id.et_effective_branch);
        mEffectivePodNumberOfOne = (EditText) findViewById(R.id.et_effective_pod_number_of_one);
        mLodgingDate = (Button) findViewById(R.id.btn_lodging_date);
        mLodgingDegree = (Spinner) findViewById(R.id.sp_lodging_degree);
        mLodgingRate = (EditText) findViewById(R.id.et_lodging_rate);
        mBacterialSpotDiseases = (Spinner) findViewById(R.id.sp_bacterial_spot_diseases);
        mBacterialSpotDiseasesDate = (Button) findViewById(R.id.btn_bacterial_spot_diseases_date);
        mDownyMildew = (Spinner) findViewById(R.id.sp_downy_mildew);
        mDownyMildewDate = (Button) findViewById(R.id.btn_downy_mildew_date);
        mGrayLeafSpot = (Spinner) findViewById(R.id.sp_gray_leaf_spot);
        mGrayLeafSpotDate = (Button) findViewById(R.id.btn_gray_leaf_spot_date);
        mSclerotiniaSclerotiorum = (Spinner) findViewById(R.id.sp_sclerotinia_sclerotiorum);
        mSclerotiniaSclerotiorumDate = (Button) findViewById(R.id.btn_sclerotinia_sclerotiorum_date);
        mViruses = (Spinner) findViewById(R.id.sp_viruses);
        mVirusesDate = (Button) findViewById(R.id.btn_viruses_date);
        mNematodeDisease = (Spinner) findViewById(R.id.sp_nematode_disease);
        mNematodeDiseaseDate = (Button) findViewById(R.id.btn_nematode_disease_date);
        mAphidResistance = (Spinner) findViewById(R.id.sp_aphid_resistance);
        mEsophagealResistance = (Spinner) findViewById(R.id.sp_esophageal_resistance);
        mOnePodNumber = (EditText) findViewById(R.id.et_one_pod_number);
        mTwoPodNumber = (EditText) findViewById(R.id.et_two_pod_number);
        mThreePodNumber = (EditText) findViewById(R.id.et_three_pod_number);
        mFourPodNumber = (EditText) findViewById(R.id.et_four_pod_number);
        mTotalPodNumber = (TextView) findViewById(R.id.tv_total_pod_number);
        mAreaLength = (EditText) findViewById(R.id.et_area_length);
        mRidgeDistance = (EditText) findViewById(R.id.et_ridge_distance);
        mCollectArea = (EditText) findViewById(R.id.et_collect_area);
        mCollectName = (EditText) findViewById(R.id.et_collect_name);
        mCollectDate = (Button) findViewById(R.id.btn_collect_date);
        mCollectTime = (Button) findViewById(R.id.btn_collect_time);
        mEvaluate = (EditText) findViewById(R.id.et_evaluate);
        mRemark = (EditText) findViewById(R.id.et_remark);

        mDefault = (Button) findViewById(R.id.btn_default);
        mSubmit = (Button) findViewById(R.id.btn_submit);

        mPhoto = (Button) findViewById(R.id.btn_photo);
    }

    private void initData() {
        if (mHolder.mPlace != null) {
            mPlace.setText(mHolder.mPlace.trim());
        } else {
            mPlace.setText("");
        }
        if (mHolder.mGeneration != null) {
            mGeneration.setText(mHolder.mGeneration.trim());
        } else {
            mGeneration.setText("");
        }
        mLine.setText("");
        mName.setText("");
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
        mStrain.setText("");
//        mMaleParent.setText("");
//        mFemaleParent.setText("");
        mBranchDate.setText("");
        mFloweringDate.setText("");
        mPoddingDate.setText("");
        mMatureDate.setText("");
        mLeafColor.setSelection(0);
        mHundredGrainWeight.setSelection(0);
        mBacterialSpotDiseasesDate.setText("");
        mDownyMildewDate.setText("");
        mGrayLeafSpotDate.setText("");
        mSclerotiniaSclerotiorumDate.setText("");
        mVirusesDate.setText("");
        mNematodeDiseaseDate.setText("");
        mAphidResistance.setSelection(0);
        mEsophagealResistance.setSelection(0);
        mOnePodNumber.setText("");
        mTwoPodNumber.setText("");
        mThreePodNumber.setText("");
        mFourPodNumber.setText("");
        mTotalPodNumber.setText("0");
        mEvaluate.setText("");
        mRemark.setText("");
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
        if (mHolder.mRidgeDistance != null) {
            mRidgeDistance.setText(mHolder.mRidgeDistance.trim());
        } else {
            mRidgeDistance.setText("");
        }
        if (mHolder.mCollectArea != null) {
            mCollectArea.setText(mHolder.mCollectArea.trim());
        } else {
            mCollectArea.setText("");
        }
        if (mHolder.mCollectName != null) {
            mCollectName.setText(mHolder.mCollectName.trim());
        } else {
            mCollectName.setText("");
        }
        if (mHolder.mCollectDate != null) {
            mCollectDate.setText(mHolder.mCollectDate);
        } else {
            mCollectDate.setText("未选择");
        }
        if (mHolder.mCollectTime != null) {
            mCollectTime.setText(mHolder.mCollectTime);
        } else {
            mCollectTime.setText("未选择");
        }
    }

    private void initEvents() {
        mSeedDate.setOnClickListener(this);
        mBranchDate.setOnClickListener(this);
        mFloweringDate.setOnClickListener(this);
        mPoddingDate.setOnClickListener(this);
        mMatureDate.setOnClickListener(this);
        mEmergeDate.setOnClickListener(this);
        mLodgingDate.setOnClickListener(this);
        mBacterialSpotDiseasesDate.setOnClickListener(this);
        mDownyMildewDate.setOnClickListener(this);
        mGrayLeafSpotDate.setOnClickListener(this);
        mSclerotiniaSclerotiorumDate.setOnClickListener(this);
        mVirusesDate.setOnClickListener(this);
        mNematodeDiseaseDate.setOnClickListener(this);
        mCollectDate.setOnClickListener(this);
        mCollectTime.setOnClickListener(this);

        mOnePodNumber.addTextChangedListener(this);
        mTwoPodNumber.addTextChangedListener(this);
        mThreePodNumber.addTextChangedListener(this);
        mFourPodNumber.addTextChangedListener(this);

        mDefault.setOnClickListener(this);
        mSubmit.setOnClickListener(this);

        mPhoto.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_seed_date:
                showAlert("选择播种日期", mSeedDate);
                break;
            case R.id.btn_branch_date:
                showAlert("选择分枝日期", mBranchDate);
                break;
            case R.id.btn_flowering_date:
                showAlert("选择开花日期", mFloweringDate);
                break;
            case R.id.btn_podding_date:
                showAlert("选择结荚日期", mPoddingDate);
                break;
            case R.id.btn_mature_date:
                showAlert("选择成熟日期", mMatureDate);
                break;
            case R.id.btn_emerge_date:
                showAlert("选择出苗日期", mEmergeDate);
                break;
            case R.id.btn_lodging_date:
                showAlert("选择倒伏日期", mLodgingDate);
                break;
            case R.id.btn_bacterial_spot_diseases_date:
                showAlert("细菌性斑点病发病日期", mBacterialSpotDiseasesDate);
                break;
            case R.id.btn_downy_mildew_date:
                showAlert("霜霉病发病日期", mDownyMildewDate);
                break;
            case R.id.btn_gray_leaf_spot_date:
                showAlert("灰斑病发病日期", mGrayLeafSpotDate);
                break;
            case R.id.btn_sclerotinia_sclerotiorum_date:
                showAlert("菌核病发病日期", mSclerotiniaSclerotiorumDate);
                break;
            case R.id.btn_viruses_date:
                showAlert("病毒发病日期", mVirusesDate);
                break;
            case R.id.btn_nematode_disease_date:
                showAlert("线虫病发病日期", mNematodeDiseaseDate);
                break;
            case R.id.btn_collect_date:
                showAlert("选择采集日期", mCollectDate);
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
                mSoy.setPlace(String.valueOf(mPlace.getText()));
                mSoy.setGeneration(String.valueOf(mGeneration.getText()));
                mSoy.setLine(String.valueOf(mLine.getText()));
                mSoy.setStrain(String.valueOf(mStrain.getText()));
                mSoy.setMaleParent(String.valueOf(mMaleParent.getText()));
                mSoy.setFemaleParent(String.valueOf(mFemaleParent.getText()));
                mSoy.setName(String.valueOf(mName.getText()));
                mSoy.setSeedDate(String.valueOf(mSeedDate.getText()));
                mSoy.setBranchDate(String.valueOf(mBranchDate.getText()));
                mSoy.setFloweringDate(String.valueOf(mFloweringDate.getText()));
                mSoy.setPoddingDate(String.valueOf(mPoddingDate.getText()));
                mSoy.setMatureDate(String.valueOf(mMatureDate.getText()));
                mSoy.setEmergeDate(String.valueOf(mEmergeDate.getText()));
                mSoy.setEmergeRate(String.valueOf(mEmergeRate.getSelectedItem()));
                mSoy.setFlowerColor(String.valueOf(mLeafShape.getSelectedItem()));
                mSoy.setLeafColor(String.valueOf(mLeafColor.getSelectedItem()));
                mSoy.setLeafShape(String.valueOf(mLeafShape.getSelectedItem()));
                mSoy.setHairColor(String.valueOf(mHairColor.getSelectedItem()));
                mSoy.setHullsColor(String.valueOf(mHullsColor.getSelectedItem()));
                mSoy.setPodHabit(String.valueOf(mPodHabit.getSelectedItem()));
                mSoy.setHundredGrainWeight(String.valueOf(mHundredGrainWeight.getSelectedItem()));
                mSoy.setPlantHeight(String.valueOf(mPlantHeight.getText()));
                mSoy.setPodHeight(String.valueOf(mPodHeight.getText()));
                mSoy.setStemNumber(String.valueOf(mStemNumber.getText()));
                mSoy.setEffectiveBranch(String.valueOf(mEffectiveBranch.getText()));
                mSoy.setEffectivePodNumberOfOne(String.valueOf(mEffectivePodNumberOfOne.getText()));
                mSoy.setLodgingDate(String.valueOf(mLodgingDate.getText()));
                mSoy.setLodgingDegree(String.valueOf(mLodgingDegree.getSelectedItem()));
                mSoy.setLodgingRate(String.valueOf(mLodgingRate.getText()));
                mSoy.setBacterialSpotDiseases(String.valueOf(mBacterialSpotDiseases.getSelectedItem()));
                mSoy.setBacterialSpotDiseasesDate(String.valueOf(mBacterialSpotDiseasesDate.getText()));
                mSoy.setDownyMildew(String.valueOf(mDownyMildew.getSelectedItem()));
                mSoy.setDownyMildewDate(String.valueOf(mDownyMildewDate.getText()));
                mSoy.setGrayLeafSpot(String.valueOf(mGrayLeafSpot.getSelectedItem()));
                mSoy.setGrayLeafSpotDate(String.valueOf(mGrayLeafSpotDate.getText()));
                mSoy.setSclerotiniaSclerotiorum(String.valueOf(mSclerotiniaSclerotiorum.getSelectedItem()));
                mSoy.setSclerotiniaSclerotiorumDate(String.valueOf(mSclerotiniaSclerotiorumDate.getText()));
                mSoy.setViruses(String.valueOf(mViruses.getSelectedItem()));
                mSoy.setVirusesDate(String.valueOf(mVirusesDate.getText()));
                mSoy.setNematodeDisease(String.valueOf(mNematodeDisease.getSelectedItem()));
                mSoy.setNematodeDiseaseDate(String.valueOf(mNematodeDiseaseDate.getText()));
                mSoy.setAphidResistance(String.valueOf(mAphidResistance.getSelectedItem()));
                mSoy.setEsophagealResistance(String.valueOf(mEsophagealResistance.getSelectedItem()));
                mSoy.setOnePodNumber(String.valueOf(mOnePodNumber.getText()));
                mSoy.setTwoPodNumber(String.valueOf(mTwoPodNumber.getText()));
                mSoy.setThreePodNumber(String.valueOf(mThreePodNumber.getText()));
                mSoy.setFourPodNumber(String.valueOf(mFourPodNumber.getText()));
                mSoy.setTotalPodNumber(String.valueOf(mTotalPodNumber.getText()));
                mSoy.setAreaLength(String.valueOf(mAreaLength.getText()));
                mSoy.setRidgeDistance(String.valueOf(mRidgeDistance.getText()));
                mSoy.setCollectArea(String.valueOf(mCollectArea.getText()));
                mSoy.setCollectName(String.valueOf(mCollectName.getText()));
                mSoy.setCollectDate(String.valueOf(mCollectDate.getText()));
                mSoy.setCollectTime(String.valueOf(mCollectTime.getText()));
                mSoy.setEvaluate(String.valueOf(mEvaluate.getText()));
                mSoy.setRemark(String.valueOf(mRemark.getText()));
                if ("".equals(mSoy.getGeneration().trim())) {
                    Toast.makeText(this, "代不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                if ("".equals(mSoy.getLine().trim())) {
                    Toast.makeText(this, "行不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                if ("".equals(mSoy.getName().trim())) {
                    Toast.makeText(this, "资源号不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
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
            case R.id.btn_photo:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    requestPermissions(new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);
                }
                String generation = String.valueOf(mGeneration.getText()).trim();
                String line = String.valueOf(mLine.getText()).trim();
                String name = String.valueOf(mName.getText()).trim();
                if ("".equals(generation)) {
                    Toast.makeText(this, "代不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                if ("".equals(line)) {
                    Toast.makeText(this, "行不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                if ("".equals(name)) {
                    Toast.makeText(this, "资源号不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                String datetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
                String filename = generation + "代" + line + "行" + name + " " + datetime;
                String mFilePath = this.getExternalFilesDir("images").getPath() + "/" + filename + ".png";
                Uri mUri;
                if (Build.VERSION.SDK_INT >= 24) {
                    mUri = FileProvider.getUriForFile(this, "com.fx.images", new File(mFilePath));
                } else {
                    mUri = Uri.fromFile(new File(mFilePath));
                }
                Intent openCameraIntent = new Intent("android.media.action.IMAGE_CAPTURE");
                openCameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, mUri);
                startActivity(openCameraIntent);
                break;
            default:
                break;
        }
    }

    private void showAlert(String text, final Button target) {
        AlertDialog.Builder builder = new AlertDialog.Builder(AddActivity.this);
        LayoutInflater inflater = LayoutInflater.from(AddActivity.this);
        View viewDialog = inflater.inflate(R.layout.date, null);
        final DatePicker datePicker = (DatePicker) viewDialog.findViewById(R.id.datePicker);
        builder.setView(viewDialog);
        builder.setTitle(text);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String date = datePicker.getYear() + "-" + (datePicker.getMonth() + 1) + "-" + datePicker.getDayOfMonth();
                target.setText(date);
            }
        });
        builder.setNegativeButton("取消", null);
        builder.create().show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
                mHolder.mPlace = data.getStringExtra("place");
                mHolder.mGeneration = data.getStringExtra("generation");
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
                mPlace.setText(mHolder.mPlace);
                mGeneration.setText(mHolder.mGeneration);
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

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {
        int num = Integer.parseInt(String.valueOf(mTotalPodNumber.getText())) + Integer.parseInt(String.valueOf(editable));
        mTotalPodNumber.setText(String.valueOf(num));
    }

    class DefaultHolder {
        String mPlace;
        String mGeneration;
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
