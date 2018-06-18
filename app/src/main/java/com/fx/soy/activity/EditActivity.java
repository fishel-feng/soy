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
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.fx.soy.R;
import com.fx.soy.entity.Soy;
import com.fx.soy.helper.DBHelper;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EditActivity extends AppCompatActivity implements View.OnClickListener, TextWatcher {

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
    private Button mEmergeRate;
    private Button mFlowerColor;
    private Button mLeafColor;
    private Button mLeafShape;
    private Button mHairColor;
    private Button mHullsColor;
    private Button mPodHabit;
    private Button mHundredGrainWeight;
    private EditText mPlantHeight;
    private EditText mPodHeight;
    private EditText mStemNumber;
    private EditText mEffectiveBranch;
    private EditText mEffectivePodNumberOfOne;
    private Button mLodgingDate;
    private Button mLodgingDegree;
    private EditText mLodgingRate;
    private Button mBacterialSpotDiseases;
    private Button mBacterialSpotDiseasesDate;
    private Button mDownyMildew;
    private Button mDownyMildewDate;
    private Button mGrayLeafSpot;
    private Button mGrayLeafSpotDate;
    private Button mSclerotiniaSclerotiorum;
    private Button mSclerotiniaSclerotiorumDate;
    private Button mViruses;
    private Button mVirusesDate;
    private Button mNematodeDisease;
    private Button mNematodeDiseaseDate;
    private Button mAphidResistance;
    private Button mEsophagealResistance;
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

    private Button mSubmit;

    private Button mPhoto;

    private Soy mSoy;

    private Soy soyForUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        initView();
        initData();
        initEvents();
    }

    private void initView() {
        mPlace = (EditText) findViewById(R.id.et_place_edit);
        mGeneration = (EditText) findViewById(R.id.et_generation_edit);
        mLine = (EditText) findViewById(R.id.et_line_edit);
        mStrain = (EditText) findViewById(R.id.et_strain_edit);
        mMaleParent = (EditText) findViewById(R.id.et_male_parent_edit);
        mFemaleParent = (EditText) findViewById(R.id.et_female_parent_edit);
        mName = (EditText) findViewById(R.id.et_name_edit);
        mSeedDate = (Button) findViewById(R.id.btn_seed_date_edit);
        mBranchDate = (Button) findViewById(R.id.btn_branch_date_edit);
        mFloweringDate = (Button) findViewById(R.id.btn_flowering_date_edit);
        mPoddingDate = (Button) findViewById(R.id.btn_podding_date_edit);
        mMatureDate = (Button) findViewById(R.id.btn_mature_date_edit);
        mEmergeDate = (Button) findViewById(R.id.btn_emerge_date_edit);
        mEmergeRate = (Button) findViewById(R.id.btn_emerge_rate_edit);
        mFlowerColor = (Button) findViewById(R.id.btn_flower_color_edit);
        mLeafColor = (Button) findViewById(R.id.btn_leaf_color_edit);
        mLeafShape = (Button) findViewById(R.id.btn_leaf_shape_edit);
        mHairColor = (Button) findViewById(R.id.btn_hair_color_edit);
        mHullsColor = (Button) findViewById(R.id.btn_hulls_color_edit);
        mPodHabit = (Button) findViewById(R.id.btn_pod_habit_edit);
        mHundredGrainWeight = (Button) findViewById(R.id.btn_hundred_grain_weight_edit);
        mPlantHeight = (EditText) findViewById(R.id.et_plant_height_edit);
        mPodHeight = (EditText) findViewById(R.id.et_pod_height_edit);
        mStemNumber = (EditText) findViewById(R.id.et_stem_number_edit);
        mEffectiveBranch = (EditText) findViewById(R.id.et_effective_branch_edit);
        mEffectivePodNumberOfOne = (EditText) findViewById(R.id.et_effective_pod_number_of_one_edit);
        mLodgingDate = (Button) findViewById(R.id.btn_lodging_date_edit);
        mLodgingDegree = (Button) findViewById(R.id.btn_lodging_degree_edit);
        mLodgingRate = (EditText) findViewById(R.id.et_lodging_rate_edit);
        mBacterialSpotDiseases = (Button) findViewById(R.id.btn_bacterial_spot_diseases_edit);
        mBacterialSpotDiseasesDate = (Button) findViewById(R.id.btn_bacterial_spot_diseases_date_edit);
        mDownyMildew = (Button) findViewById(R.id.btn_downy_mildew_edit);
        mDownyMildewDate = (Button) findViewById(R.id.btn_downy_mildew_date_edit);
        mGrayLeafSpot = (Button) findViewById(R.id.btn_gray_leaf_spot_edit);
        mGrayLeafSpotDate = (Button) findViewById(R.id.btn_gray_leaf_spot_date_edit);
        mSclerotiniaSclerotiorum = (Button) findViewById(R.id.btn_sclerotinia_sclerotiorum_edit);
        mSclerotiniaSclerotiorumDate = (Button) findViewById(R.id.btn_sclerotinia_sclerotiorum_date_edit);
        mViruses = (Button) findViewById(R.id.btn_viruses_edit);
        mVirusesDate = (Button) findViewById(R.id.btn_viruses_date_edit);
        mNematodeDisease = (Button) findViewById(R.id.btn_nematode_disease_edit);
        mNematodeDiseaseDate = (Button) findViewById(R.id.btn_nematode_disease_date_edit);
        mAphidResistance = (Button) findViewById(R.id.btn_aphid_resistance_edit);
        mEsophagealResistance = (Button) findViewById(R.id.btn_esophageal_resistance_edit);
        mOnePodNumber = (EditText) findViewById(R.id.et_one_pod_number_edit);
        mTwoPodNumber = (EditText) findViewById(R.id.et_two_pod_number_edit);
        mThreePodNumber = (EditText) findViewById(R.id.et_three_pod_number_edit);
        mFourPodNumber = (EditText) findViewById(R.id.et_four_pod_number_edit);
        mTotalPodNumber = (TextView) findViewById(R.id.tv_total_pod_number_edit);
        mAreaLength = (EditText) findViewById(R.id.et_area_length_edit);
        mRidgeDistance = (EditText) findViewById(R.id.et_ridge_distance_edit);
        mCollectArea = (EditText) findViewById(R.id.et_collect_area_edit);
        mCollectName = (EditText) findViewById(R.id.et_collect_name_edit);
        mCollectDate = (Button) findViewById(R.id.btn_collect_date_edit);
        mCollectTime = (Button) findViewById(R.id.btn_collect_time_edit);
        mEvaluate = (EditText) findViewById(R.id.et_evaluate_edit);
        mRemark = (EditText) findViewById(R.id.et_remark_edit);

        mSubmit = (Button) findViewById(R.id.btn_submit_edit);

        mPhoto = (Button) findViewById(R.id.btn_photo_edit);
    }

    private void initData() {
        Intent intent = getIntent();
        mSoy = intent.getParcelableExtra("mSoy");
        mPlace.setText(mSoy.getPlace());
        mGeneration.setText(mSoy.getGeneration());
        mLine.setText(mSoy.getLine());
        mStrain.setText(mSoy.getStrain());
        mMaleParent.setText(mSoy.getMaleParent());
        mFemaleParent.setText(mSoy.getFemaleParent());
        mName.setText(mSoy.getName());
        mSeedDate.setText(mSoy.getSeedDate());
        mBranchDate.setText(mSoy.getBranchDate());
        mFloweringDate.setText(mSoy.getFloweringDate());
        mPoddingDate.setText(mSoy.getPoddingDate());
        mMatureDate.setText(mSoy.getMatureDate());
        mEmergeDate.setText(mSoy.getEmergeDate());
        mEmergeRate.setText(mSoy.getEmergeRate());
        mFlowerColor.setText(mSoy.getFlowerColor());
        mLeafColor.setText(mSoy.getLeafColor());
        mLeafShape.setText(mSoy.getLeafShape());
        mHairColor.setText(mSoy.getHairColor());
        mHullsColor.setText(mSoy.getHullsColor());
        mPodHabit.setText(mSoy.getPodHabit());
        mHundredGrainWeight.setText(mSoy.getHundredGrainWeight());
        mPlantHeight.setText(mSoy.getPlantHeight());
        mPodHeight.setText(mSoy.getPodHeight());
        mStemNumber.setText(mSoy.getStemNumber());
        mEffectiveBranch.setText(mSoy.getEffectiveBranch());
        mEffectivePodNumberOfOne.setText(mSoy.getEffectivePodNumberOfOne());
        mLodgingDate.setText(mSoy.getLodgingDate());
        mLodgingDegree.setText(mSoy.getLodgingDegree());
        mLodgingRate.setText(mSoy.getLodgingRate());
        mBacterialSpotDiseases.setText(mSoy.getBacterialSpotDiseases());
        mBacterialSpotDiseasesDate.setText(mSoy.getBacterialSpotDiseasesDate());
        mDownyMildew.setText(mSoy.getDownyMildew());
        mDownyMildewDate.setText(mSoy.getDownyMildewDate());
        mGrayLeafSpot.setText(mSoy.getGrayLeafSpot());
        mGrayLeafSpotDate.setText(mSoy.getGrayLeafSpotDate());
        mSclerotiniaSclerotiorum.setText(mSoy.getSclerotiniaSclerotiorum());
        mSclerotiniaSclerotiorumDate.setText(mSoy.getSclerotiniaSclerotiorumDate());
        mViruses.setText(mSoy.getViruses());
        mVirusesDate.setText(mSoy.getVirusesDate());
        mNematodeDisease.setText(mSoy.getNematodeDisease());
        mNematodeDiseaseDate.setText(mSoy.getNematodeDiseaseDate());
        mAphidResistance.setText(mSoy.getAphidResistance());
        mEsophagealResistance.setText(mSoy.getEsophagealResistance());
        mOnePodNumber.setText(mSoy.getOnePodNumber());
        mTwoPodNumber.setText(mSoy.getTwoPodNumber());
        mThreePodNumber.setText(mSoy.getThreePodNumber());
        mFourPodNumber.setText(mSoy.getFourPodNumber());
        mTotalPodNumber.setText(mSoy.getTotalPodNumber());
        mAreaLength.setText(mSoy.getAreaLength());
        mRidgeDistance.setText(mSoy.getRidgeDistance());
        mCollectArea.setText(mSoy.getCollectArea());
        mCollectName.setText(mSoy.getCollectName());
        mCollectDate.setText(mSoy.getCollectDate());
        mCollectTime.setText(mSoy.getCollectTime());
        mEvaluate.setText(mSoy.getEvaluate());
        mRemark.setText(mSoy.getRemark());
    }

    private void initEvents() {
        mSeedDate.setOnClickListener(this);
        mBranchDate.setOnClickListener(this);
        mFloweringDate.setOnClickListener(this);
        mPoddingDate.setOnClickListener(this);
        mMatureDate.setOnClickListener(this);
        mEmergeDate.setOnClickListener(this);
        mEmergeRate.setOnClickListener(this);
        mFlowerColor.setOnClickListener(this);
        mLeafColor.setOnClickListener(this);
        mLeafShape.setOnClickListener(this);
        mHairColor.setOnClickListener(this);
        mHullsColor.setOnClickListener(this);
        mPodHabit.setOnClickListener(this);
        mHundredGrainWeight.setOnClickListener(this);
        mLodgingDate.setOnClickListener(this);
        mLodgingDegree.setOnClickListener(this);
        mBacterialSpotDiseases.setOnClickListener(this);
        mBacterialSpotDiseasesDate.setOnClickListener(this);
        mDownyMildew.setOnClickListener(this);
        mDownyMildewDate.setOnClickListener(this);
        mGrayLeafSpot.setOnClickListener(this);
        mGrayLeafSpotDate.setOnClickListener(this);
        mSclerotiniaSclerotiorum.setOnClickListener(this);
        mSclerotiniaSclerotiorumDate.setOnClickListener(this);
        mViruses.setOnClickListener(this);
        mVirusesDate.setOnClickListener(this);
        mNematodeDisease.setOnClickListener(this);
        mNematodeDiseaseDate.setOnClickListener(this);
        mAphidResistance.setOnClickListener(this);
        mEsophagealResistance.setOnClickListener(this);
        mCollectDate.setOnClickListener(this);
        mCollectTime.setOnClickListener(this);

        mOnePodNumber.addTextChangedListener(this);
        mTwoPodNumber.addTextChangedListener(this);
        mThreePodNumber.addTextChangedListener(this);
        mFourPodNumber.addTextChangedListener(this);

        mSubmit.setOnClickListener(this);

        mPhoto.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_seed_date_edit:
                showDateAlert("", mSeedDate);
                break;
            case R.id.btn_branch_date_edit:
                showDateAlert("", mBranchDate);
                break;
            case R.id.btn_flowering_date_edit:
                showDateAlert("", mFloweringDate);
                break;
            case R.id.btn_podding_date_edit:
                showDateAlert("", mPoddingDate);
                break;
            case R.id.btn_mature_date_edit:
                showDateAlert("", mMatureDate);
                break;
            case R.id.btn_emerge_date_edit:
                showDateAlert("", mEmergeDate);
                break;
            case R.id.btn_emerge_rate_edit:
                showCheck(R.array.emergeRate, mEmergeRate);
                break;
            case R.id.btn_flower_color_edit:
                showCheck(R.array.flowerColor, mFlowerColor);
                break;
            case R.id.btn_leaf_color_edit:
                showCheck(R.array.leafColor, mLeafColor);
                break;
            case R.id.btn_leaf_shape_edit:
                showCheck(R.array.leafShape, mLeafShape);
                break;
            case R.id.btn_hair_color_edit:
                showCheck(R.array.hairColor, mHairColor);
                break;
            case R.id.btn_hulls_color_edit:
                showCheck(R.array.hullsColor, mHullsColor);
                break;
            case R.id.btn_pod_habit_edit:
                showCheck(R.array.podHabit, mPodHabit);
                break;
            case R.id.btn_hundred_grain_weight_edit:
                showCheck(R.array.hundredGrainWeight, mHundredGrainWeight);
                break;
            case R.id.btn_lodging_date_edit:
                showDateAlert("", mLodgingDate);
                break;
            case R.id.btn_lodging_degree_edit:
                showCheck(R.array.level5, mLodgingDegree);
                break;
            case R.id.btn_bacterial_spot_diseases_edit:
                showCheck(R.array.level4, mBacterialSpotDiseases);
                break;
            case R.id.btn_bacterial_spot_diseases_date:
                showDateAlert("", mBacterialSpotDiseasesDate);
                break;
            case R.id.btn_downy_mildew_edit:
                showCheck(R.array.level4, mDownyMildew);
                break;
            case R.id.btn_downy_mildew_date_edit:
                showDateAlert("", mDownyMildewDate);
                break;
            case R.id.btn_gray_leaf_spot_edit:
                showCheck(R.array.level4, mGrayLeafSpot);
                break;
            case R.id.btn_gray_leaf_spot_date_edit:
                showDateAlert("", mGrayLeafSpotDate);
                break;
            case R.id.btn_sclerotinia_sclerotiorum_edit:
                showCheck(R.array.level5, mSclerotiniaSclerotiorum);
                break;
            case R.id.btn_sclerotinia_sclerotiorum_date_edit:
                showDateAlert("", mSclerotiniaSclerotiorumDate);
                break;
            case R.id.btn_viruses_edit:
                showCheck(R.array.level6, mViruses);
                break;
            case R.id.btn_viruses_date_edit:
                showDateAlert("", mVirusesDate);
                break;
            case R.id.btn_nematode_disease_edit:
                showCheck(R.array.level6, mNematodeDisease);
                break;
            case R.id.btn_nematode_disease_date_edit:
                showDateAlert("", mNematodeDiseaseDate);
                break;
            case R.id.btn_aphid_resistance_edit:
                showCheck(R.array.resistance, mAphidResistance);
                break;
            case R.id.btn_esophageal_resistance_edit:
                showCheck(R.array.resistance, mEsophagealResistance);
                break;
            case R.id.btn_collect_date_edit:
                showDateAlert("", mCollectDate);
                break;
            case R.id.btn_collect_time_edit:
                AlertDialog.Builder builder4 = new AlertDialog.Builder(EditActivity.this);
                LayoutInflater inflater4 = LayoutInflater.from(EditActivity.this);
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
            case R.id.btn_submit_edit:
                soyForUpdate = new Soy();
                soyForUpdate.setPlace(String.valueOf(mPlace.getText()));
                soyForUpdate.setGeneration(String.valueOf(mGeneration.getText()));
                soyForUpdate.setLine(String.valueOf(mLine.getText()));
                soyForUpdate.setStrain(String.valueOf(mStrain.getText()));
                soyForUpdate.setMaleParent(String.valueOf(mMaleParent.getText()));
                soyForUpdate.setFemaleParent(String.valueOf(mFemaleParent.getText()));
                soyForUpdate.setName(String.valueOf(mName.getText()));
                soyForUpdate.setSeedDate(String.valueOf(mSeedDate.getText()));
                soyForUpdate.setBranchDate(String.valueOf(mBranchDate.getText()));
                soyForUpdate.setFloweringDate(String.valueOf(mFloweringDate.getText()));
                soyForUpdate.setPoddingDate(String.valueOf(mPoddingDate.getText()));
                soyForUpdate.setMatureDate(String.valueOf(mMatureDate.getText()));
                soyForUpdate.setEmergeDate(String.valueOf(mEmergeDate.getText()));
                soyForUpdate.setEmergeRate(String.valueOf(mEmergeRate.getText()));
                soyForUpdate.setFlowerColor(String.valueOf(mFlowerColor.getText()));
                soyForUpdate.setLeafColor(String.valueOf(mLeafColor.getText()));
                soyForUpdate.setLeafShape(String.valueOf(mLeafShape.getText()));
                soyForUpdate.setHairColor(String.valueOf(mHairColor.getText()));
                soyForUpdate.setHullsColor(String.valueOf(mHullsColor.getText()));
                soyForUpdate.setPodHabit(String.valueOf(mPodHabit.getText()));
                soyForUpdate.setHundredGrainWeight(String.valueOf(mHundredGrainWeight.getText()));
                soyForUpdate.setPlantHeight(String.valueOf(mPlantHeight.getText()));
                soyForUpdate.setPodHeight(String.valueOf(mPodHeight.getText()));
                soyForUpdate.setStemNumber(String.valueOf(mStemNumber.getText()));
                soyForUpdate.setEffectiveBranch(String.valueOf(mEffectiveBranch.getText()));
                soyForUpdate.setEffectivePodNumberOfOne(String.valueOf(mEffectivePodNumberOfOne.getText()));
                soyForUpdate.setLodgingDate(String.valueOf(mLodgingDate.getText()));
                soyForUpdate.setLodgingDegree(String.valueOf(mLodgingDegree.getText()));
                soyForUpdate.setLodgingRate(String.valueOf(mLodgingRate.getText()));
                soyForUpdate.setBacterialSpotDiseases(String.valueOf(mBacterialSpotDiseases.getText()));
                soyForUpdate.setBacterialSpotDiseasesDate(String.valueOf(mBacterialSpotDiseasesDate.getText()));
                soyForUpdate.setDownyMildew(String.valueOf(mDownyMildew.getText()));
                soyForUpdate.setDownyMildewDate(String.valueOf(mDownyMildewDate.getText()));
                soyForUpdate.setGrayLeafSpot(String.valueOf(mGrayLeafSpot.getText()));
                soyForUpdate.setGrayLeafSpotDate(String.valueOf(mGrayLeafSpotDate.getText()));
                soyForUpdate.setSclerotiniaSclerotiorum(String.valueOf(mSclerotiniaSclerotiorum.getText()));
                soyForUpdate.setSclerotiniaSclerotiorumDate(String.valueOf(mSclerotiniaSclerotiorumDate.getText()));
                soyForUpdate.setViruses(String.valueOf(mViruses.getText()));
                soyForUpdate.setVirusesDate(String.valueOf(mVirusesDate.getText()));
                soyForUpdate.setNematodeDisease(String.valueOf(mNematodeDisease.getText()));
                soyForUpdate.setNematodeDiseaseDate(String.valueOf(mNematodeDiseaseDate.getText()));
                soyForUpdate.setAphidResistance(String.valueOf(mAphidResistance.getText()));
                soyForUpdate.setEsophagealResistance(String.valueOf(mEsophagealResistance.getText()));
                soyForUpdate.setOnePodNumber(String.valueOf(mOnePodNumber.getText()));
                soyForUpdate.setTwoPodNumber(String.valueOf(mTwoPodNumber.getText()));
                soyForUpdate.setThreePodNumber(String.valueOf(mThreePodNumber.getText()));
                soyForUpdate.setFourPodNumber(String.valueOf(mFourPodNumber.getText()));
                soyForUpdate.setTotalPodNumber(String.valueOf(mTotalPodNumber.getText()));
                soyForUpdate.setAreaLength(String.valueOf(mAreaLength.getText()));
                soyForUpdate.setRidgeDistance(String.valueOf(mRidgeDistance.getText()));
                soyForUpdate.setCollectArea(String.valueOf(mCollectArea.getText()));
                soyForUpdate.setCollectName(String.valueOf(mCollectName.getText()));
                soyForUpdate.setCollectDate(String.valueOf(mCollectDate.getText()));
                soyForUpdate.setCollectTime(String.valueOf(mCollectTime.getText()));
                soyForUpdate.setEvaluate(String.valueOf(mEvaluate.getText()));
                soyForUpdate.setRemark(String.valueOf(mRemark.getText()));
                if ("".equals(soyForUpdate.getGeneration().trim())) {
                    Toast.makeText(this, "代不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                if ("".equals(soyForUpdate.getLine().trim())) {
                    Toast.makeText(this, "行不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                if ("".equals(soyForUpdate.getName().trim())) {
                    Toast.makeText(this, "资源号不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                if ("".equals(soyForUpdate.getCollectName().trim()) || soyForUpdate.getCollectName() == null || "未选择".equals(soyForUpdate.getCollectDate()) || "未选择".equals(soyForUpdate.getCollectTime())) {
                    Toast.makeText(this, "采集人姓名和采集日期时间不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                DBHelper.update(soyForUpdate, mSoy.getId());
                soyForUpdate.setId(mSoy.getId());
                Toast.makeText(this, "更新数据成功", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                intent.putExtra("newSoy", soyForUpdate);
                setResult(RESULT_OK, intent);
                finish();
                break;
            case R.id.btn_photo_edit:
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

    private void showCheck(int res, final Button target) {
        AlertDialog.Builder builder5 = new AlertDialog.Builder(this);
        builder5.setSingleChoiceItems(res, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ListView lw = ((AlertDialog) dialog).getListView();
                Object checkedItem = lw.getAdapter().getItem(which);
                dialog.dismiss();
                target.setText((String) checkedItem);
            }
        });
        AlertDialog dialog5 = builder5.create();
        dialog5.show();
    }

    private void showDateAlert(String text, final Button target) {
        AlertDialog.Builder builder = new AlertDialog.Builder(EditActivity.this);
        LayoutInflater inflater = LayoutInflater.from(EditActivity.this);
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
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            Intent intent = new Intent();
            intent.putExtra("newSoy", soyForUpdate);
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
}
