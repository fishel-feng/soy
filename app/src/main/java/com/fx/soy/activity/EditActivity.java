package com.fx.soy.activity;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.fx.soy.R;
import com.fx.soy.entity.Soy;
import com.fx.soy.helper.DBHelper;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EditActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mGeneration;
    private EditText mLine;
    private EditText mName;
    private Button mSeedDate;
    private Button mEmergeDate;
    private Button mEmergeRate;
    private Button mFlowerColor;
    private Button mLeafShape;
    private Button mHairColor;
    private Button mHullsColor;
    private Button mPodHabit;
    private EditText mPlantHeight;
    private EditText mPodHeight;
    private EditText mStemNumber;
    private EditText mEffectiveBranch;
    private EditText mEffectivePodNumberOfOne;
    private Button mLodgingDate;
    private Button mLodgingDegree;
    private EditText mLodgingRate;
    private Button mBacterialSpotDiseases;
    private Button mDownyMildew;
    private Button mGrayLeafSpot;
    private Button mSclerotiniaSclerotiorum;
    private Button mViruses;
    private Button mNematodeDisease;
    private EditText mAreaLength;
    private EditText mRidgeDistance;
    private EditText mCollectArea;
    private EditText mCollectName;
    private Button mCollectDate;
    private Button mCollectTime;

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
        mGeneration = (EditText) findViewById(R.id.et_generation_edit);
        mLine = (EditText) findViewById(R.id.et_line_edit);
        mName = (EditText) findViewById(R.id.et_name_edit);
        mSeedDate = (Button) findViewById(R.id.btn_seed_date_edit);
        mEmergeDate = (Button) findViewById(R.id.btn_emerge_date_edit);
        mEmergeRate = (Button) findViewById(R.id.btn_emerge_rate_edit);
        mFlowerColor = (Button) findViewById(R.id.btn_flower_color_edit);
        mLeafShape = (Button) findViewById(R.id.btn_leaf_shape_edit);
        mHairColor = (Button) findViewById(R.id.btn_hair_color_edit);
        mHullsColor = (Button) findViewById(R.id.btn_hulls_color_edit);
        mPodHabit = (Button) findViewById(R.id.btn_pod_habit_edit);
        mPlantHeight = (EditText) findViewById(R.id.et_plant_height_edit);
        mPodHeight = (EditText) findViewById(R.id.et_pod_height_edit);
        mStemNumber = (EditText) findViewById(R.id.et_stem_number_edit);
        mEffectiveBranch = (EditText) findViewById(R.id.et_effective_branch_edit);
        mEffectivePodNumberOfOne = (EditText) findViewById(R.id.et_effective_pod_number_of_one_edit);
        mLodgingDate = (Button) findViewById(R.id.btn_lodging_date_edit);
        mLodgingDegree = (Button) findViewById(R.id.btn_lodging_degree_edit);
        mLodgingRate = (EditText) findViewById(R.id.et_lodging_rate_edit);
        mBacterialSpotDiseases = (Button) findViewById(R.id.btn_bacterial_spot_diseases_edit);
        mDownyMildew = (Button) findViewById(R.id.btn_downy_mildew_edit);
        mGrayLeafSpot = (Button) findViewById(R.id.btn_gray_leaf_spot_edit);
        mSclerotiniaSclerotiorum = (Button) findViewById(R.id.btn_sclerotinia_sclerotiorum_edit);
        mViruses = (Button) findViewById(R.id.btn_viruses_edit);
        mNematodeDisease = (Button) findViewById(R.id.btn_nematode_disease_edit);
        mAreaLength = (EditText) findViewById(R.id.et_area_length_edit);
        mRidgeDistance = (EditText) findViewById(R.id.et_ridge_distance_edit);
        mCollectArea = (EditText) findViewById(R.id.et_collect_area_edit);
        mCollectName = (EditText) findViewById(R.id.et_collect_name_edit);
        mCollectDate = (Button) findViewById(R.id.btn_collect_date_edit);
        mCollectTime = (Button) findViewById(R.id.btn_collect_time_edit);

        mSubmit = (Button) findViewById(R.id.btn_submit_edit);

        mPhoto = (Button) findViewById(R.id.btn_photo_edit);
    }

    private void initData() {
        Intent intent = getIntent();
        mSoy = intent.getParcelableExtra("mSoy");
        mGeneration.setText(mSoy.getGeneration());
        mLine.setText(mSoy.getLine());
        mName.setText(mSoy.getName());
        mSeedDate.setText(mSoy.getSeedDate());
        mEmergeDate.setText(mSoy.getEmergeDate());
        mEmergeRate.setText(mSoy.getEmergeRate());
        mFlowerColor.setText(mSoy.getFlowerColor());
        mLeafShape.setText(mSoy.getLeafShape());
        mHairColor.setText(mSoy.getHairColor());
        mHullsColor.setText(mSoy.getHullsColor());
        mPodHabit.setText(mSoy.getPodHabit());
        mPlantHeight.setText(mSoy.getPlantHeight());
        mPodHeight.setText(mSoy.getPodHeight());
        mStemNumber.setText(mSoy.getStemNumber());
        mEffectiveBranch.setText(mSoy.getEffectiveBranch());
        mEffectivePodNumberOfOne.setText(mSoy.getEffectivePodNumberOfOne());
        mLodgingDate.setText(mSoy.getLodgingDate());
        mLodgingDegree.setText(mSoy.getLodgingDegree());
        mLodgingRate.setText(mSoy.getLodgingRate());
        mBacterialSpotDiseases.setText(mSoy.getBacterialSpotDiseases());
        mDownyMildew.setText(mSoy.getDownyMildew());
        mGrayLeafSpot.setText(mSoy.getGrayLeafSpot());
        mSclerotiniaSclerotiorum.setText(mSoy.getSclerotiniaSclerotiorum());
        mViruses.setText(mSoy.getViruses());
        mNematodeDisease.setText(mSoy.getNematodeDisease());
        mAreaLength.setText(mSoy.getAreaLength());
        mRidgeDistance.setText(mSoy.getRidgeDistance());
        mCollectArea.setText(mSoy.getCollectArea());
        mCollectName.setText(mSoy.getCollectName());
        mCollectDate.setText(mSoy.getCollectDate());
        mCollectTime.setText(mSoy.getCollectTime());
    }

    private void initEvents() {
        mSeedDate.setOnClickListener(this);
        mEmergeDate.setOnClickListener(this);
        mEmergeRate.setOnClickListener(this);
        mFlowerColor.setOnClickListener(this);
        mLeafShape.setOnClickListener(this);
        mHairColor.setOnClickListener(this);
        mHullsColor.setOnClickListener(this);
        mPodHabit.setOnClickListener(this);
        mLodgingDate.setOnClickListener(this);
        mLodgingDegree.setOnClickListener(this);
        mBacterialSpotDiseases.setOnClickListener(this);
        mDownyMildew.setOnClickListener(this);
        mGrayLeafSpot.setOnClickListener(this);
        mSclerotiniaSclerotiorum.setOnClickListener(this);
        mViruses.setOnClickListener(this);
        mNematodeDisease.setOnClickListener(this);
        mCollectDate.setOnClickListener(this);
        mCollectTime.setOnClickListener(this);

        mSubmit.setOnClickListener(this);

        mPhoto.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_seed_date_edit:
                AlertDialog.Builder builder = new AlertDialog.Builder(EditActivity.this);
                LayoutInflater inflater = LayoutInflater.from(EditActivity.this);
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
            case R.id.btn_emerge_date_edit:
                AlertDialog.Builder builder1 = new AlertDialog.Builder(EditActivity.this);
                LayoutInflater inflater1 = LayoutInflater.from(EditActivity.this);
                View viewDialog1 = inflater1.inflate(R.layout.date, null);
                final DatePicker datePicker1 = (DatePicker) viewDialog1.findViewById(R.id.datePicker);
                builder1.setView(viewDialog1);
                builder1.setTitle("选择播种日期");
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
            case R.id.btn_emerge_rate_edit:
                AlertDialog.Builder builder5 = new AlertDialog.Builder(this);
                builder5.setSingleChoiceItems(R.array.emergeRate, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ListView lw = ((AlertDialog) dialog).getListView();
                        Object checkedItem = lw.getAdapter().getItem(which);
                        dialog.dismiss();
                        mEmergeRate.setText((String) checkedItem);
                    }
                });
                AlertDialog dialog5 = builder5.create();
                dialog5.show();
                break;
            case R.id.btn_flower_color_edit:
                AlertDialog.Builder builder6 = new AlertDialog.Builder(this);
                builder6.setSingleChoiceItems(R.array.flowerColor, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ListView lw = ((AlertDialog) dialog).getListView();
                        Object checkedItem = lw.getAdapter().getItem(which);
                        dialog.dismiss();
                        mFlowerColor.setText((String) checkedItem);
                    }
                });
                AlertDialog dialog6 = builder6.create();
                dialog6.show();
                break;
            case R.id.btn_leaf_shape_edit:
                AlertDialog.Builder builder7 = new AlertDialog.Builder(this);
                builder7.setSingleChoiceItems(R.array.leafShape, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ListView lw = ((AlertDialog) dialog).getListView();
                        Object checkedItem = lw.getAdapter().getItem(which);
                        dialog.dismiss();
                        mLeafShape.setText((String) checkedItem);
                    }
                });
                AlertDialog dialog7 = builder7.create();
                dialog7.show();
                break;
            case R.id.btn_hair_color_edit:
                AlertDialog.Builder builder8 = new AlertDialog.Builder(this);
                builder8.setSingleChoiceItems(R.array.hairColor, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ListView lw = ((AlertDialog) dialog).getListView();
                        Object checkedItem = lw.getAdapter().getItem(which);
                        dialog.dismiss();
                        mHairColor.setText((String) checkedItem);
                    }
                });
                AlertDialog dialog8 = builder8.create();
                dialog8.show();
                break;
            case R.id.btn_hulls_color_edit:
                AlertDialog.Builder builder9 = new AlertDialog.Builder(this);
                builder9.setSingleChoiceItems(R.array.hullsColor, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ListView lw = ((AlertDialog) dialog).getListView();
                        Object checkedItem = lw.getAdapter().getItem(which);
                        dialog.dismiss();
                        mHullsColor.setText((String) checkedItem);
                    }
                });
                AlertDialog dialog9 = builder9.create();
                dialog9.show();
                break;
            case R.id.btn_pod_habit_edit:
                AlertDialog.Builder builder10 = new AlertDialog.Builder(this);
                builder10.setSingleChoiceItems(R.array.podHabit, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ListView lw = ((AlertDialog) dialog).getListView();
                        Object checkedItem = lw.getAdapter().getItem(which);
                        dialog.dismiss();
                        mPodHabit.setText((String) checkedItem);
                    }
                });
                AlertDialog dialog10 = builder10.create();
                dialog10.show();
                break;
            case R.id.btn_lodging_date_edit:
                AlertDialog.Builder builder2 = new AlertDialog.Builder(EditActivity.this);
                LayoutInflater inflater2 = LayoutInflater.from(EditActivity.this);
                View viewDialog2 = inflater2.inflate(R.layout.date, null);
                final DatePicker datePicker2 = (DatePicker) viewDialog2.findViewById(R.id.datePicker);
                builder2.setView(viewDialog2);
                builder2.setTitle("选择播种日期");
                builder2.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String date = datePicker2.getYear() + "-" + (datePicker2.getMonth() + 2) + "-" + datePicker2.getDayOfMonth();
                        mLodgingDate.setText(date);
                    }
                });
                builder2.setNegativeButton("取消", null);
                builder2.create().show();
                break;
            case R.id.btn_lodging_degree_edit:
                AlertDialog.Builder builder11 = new AlertDialog.Builder(this);
                builder11.setSingleChoiceItems(R.array.level5, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ListView lw = ((AlertDialog) dialog).getListView();
                        Object checkedItem = lw.getAdapter().getItem(which);
                        dialog.dismiss();
                        mLodgingDegree.setText((String) checkedItem);
                    }
                });
                AlertDialog dialog11 = builder11.create();
                dialog11.show();
                break;
            case R.id.btn_bacterial_spot_diseases_edit:
                AlertDialog.Builder builder12 = new AlertDialog.Builder(this);
                builder12.setSingleChoiceItems(R.array.level4, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ListView lw = ((AlertDialog) dialog).getListView();
                        Object checkedItem = lw.getAdapter().getItem(which);
                        dialog.dismiss();
                        mBacterialSpotDiseases.setText((String) checkedItem);
                    }
                });
                AlertDialog dialog12 = builder12.create();
                dialog12.show();
                break;
            case R.id.btn_downy_mildew_edit:
                AlertDialog.Builder builder13 = new AlertDialog.Builder(this);
                builder13.setSingleChoiceItems(R.array.level4, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ListView lw = ((AlertDialog) dialog).getListView();
                        Object checkedItem = lw.getAdapter().getItem(which);
                        dialog.dismiss();
                        mDownyMildew.setText((String) checkedItem);
                    }
                });
                AlertDialog dialog13 = builder13.create();
                dialog13.show();
                break;
            case R.id.btn_gray_leaf_spot_edit:
                AlertDialog.Builder builder14 = new AlertDialog.Builder(this);
                builder14.setSingleChoiceItems(R.array.level4, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ListView lw = ((AlertDialog) dialog).getListView();
                        Object checkedItem = lw.getAdapter().getItem(which);
                        dialog.dismiss();
                        mGrayLeafSpot.setText((String) checkedItem);
                    }
                });
                AlertDialog dialog14 = builder14.create();
                dialog14.show();
                break;
            case R.id.btn_sclerotinia_sclerotiorum_edit:
                AlertDialog.Builder builder15 = new AlertDialog.Builder(this);
                builder15.setSingleChoiceItems(R.array.level5, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ListView lw = ((AlertDialog) dialog).getListView();
                        Object checkedItem = lw.getAdapter().getItem(which);
                        dialog.dismiss();
                        mSclerotiniaSclerotiorum.setText((String) checkedItem);
                    }
                });
                AlertDialog dialog15 = builder15.create();
                dialog15.show();
                break;
            case R.id.btn_viruses_edit:
                AlertDialog.Builder builder16 = new AlertDialog.Builder(this);
                builder16.setSingleChoiceItems(R.array.level6, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ListView lw = ((AlertDialog) dialog).getListView();
                        Object checkedItem = lw.getAdapter().getItem(which);
                        dialog.dismiss();
                        mViruses.setText((String) checkedItem);
                    }
                });
                AlertDialog dialog16 = builder16.create();
                dialog16.show();
                break;
            case R.id.btn_nematode_disease_edit:
                AlertDialog.Builder builder17 = new AlertDialog.Builder(this);
                builder17.setSingleChoiceItems(R.array.level6, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ListView lw = ((AlertDialog) dialog).getListView();
                        Object checkedItem = lw.getAdapter().getItem(which);
                        dialog.dismiss();
                        mNematodeDisease.setText((String) checkedItem);
                    }
                });
                AlertDialog dialog17 = builder17.create();
                dialog17.show();
                break;
            case R.id.btn_collect_date_edit:
                AlertDialog.Builder builder3 = new AlertDialog.Builder(EditActivity.this);
                LayoutInflater inflater3 = LayoutInflater.from(EditActivity.this);
                View viewDialog3 = inflater3.inflate(R.layout.date, null);
                final DatePicker datePicker3 = (DatePicker) viewDialog3.findViewById(R.id.datePicker);
                builder3.setView(viewDialog3);
                builder3.setTitle("选择播种日期");
                builder3.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String date = datePicker3.getYear() + "-" + (datePicker3.getMonth() + 3) + "-" + datePicker3.getDayOfMonth();
                        mCollectDate.setText(date);
                    }
                });
                builder3.setNegativeButton("取消", null);
                builder3.create().show();
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
                soyForUpdate.setGeneration(String.valueOf(mGeneration.getText()));
                soyForUpdate.setLine(String.valueOf(mLine.getText()));
                soyForUpdate.setName(String.valueOf(mName.getText()));
                soyForUpdate.setSeedDate(String.valueOf(mSeedDate.getText()));
                soyForUpdate.setEmergeDate(String.valueOf(mEmergeDate.getText()));
                soyForUpdate.setEmergeRate(String.valueOf(mEmergeRate.getText()));
                soyForUpdate.setFlowerColor(String.valueOf(mFlowerColor.getText()));
                soyForUpdate.setLeafShape(String.valueOf(mLeafShape.getText()));
                soyForUpdate.setHairColor(String.valueOf(mHairColor.getText()));
                soyForUpdate.setHullsColor(String.valueOf(mHullsColor.getText()));
                soyForUpdate.setPodHabit(String.valueOf(mPodHabit.getText()));
                soyForUpdate.setPlantHeight(String.valueOf(mPlantHeight.getText()));
                soyForUpdate.setPodHeight(String.valueOf(mPodHeight.getText()));
                soyForUpdate.setStemNumber(String.valueOf(mStemNumber.getText()));
                soyForUpdate.setEffectiveBranch(String.valueOf(mEffectiveBranch.getText()));
                soyForUpdate.setEffectivePodNumberOfOne(String.valueOf(mEffectivePodNumberOfOne.getText()));
                soyForUpdate.setLodgingDate(String.valueOf(mLodgingDate.getText()));
                soyForUpdate.setLodgingDegree(String.valueOf(mLodgingDegree.getText()));
                soyForUpdate.setLodgingRate(String.valueOf(mLodgingRate.getText()));
                soyForUpdate.setBacterialSpotDiseases(String.valueOf(mBacterialSpotDiseases.getText()));
                soyForUpdate.setDownyMildew(String.valueOf(mDownyMildew.getText()));
                soyForUpdate.setGrayLeafSpot(String.valueOf(mGrayLeafSpot.getText()));
                soyForUpdate.setSclerotiniaSclerotiorum(String.valueOf(mSclerotiniaSclerotiorum.getText()));
                soyForUpdate.setViruses(String.valueOf(mViruses.getText()));
                soyForUpdate.setNematodeDisease(String.valueOf(mNematodeDisease.getText()));
                soyForUpdate.setAreaLength(String.valueOf(mAreaLength.getText()));
                soyForUpdate.setRidgeDistance(String.valueOf(mRidgeDistance.getText()));
                soyForUpdate.setCollectArea(String.valueOf(mCollectArea.getText()));
                soyForUpdate.setCollectName(String.valueOf(mCollectName.getText()));
                soyForUpdate.setCollectDate(String.valueOf(mCollectDate.getText()));
                soyForUpdate.setCollectTime(String.valueOf(mCollectTime.getText()));
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
                String dir = Environment.getExternalStorageDirectory().getPath() + "/Android/data/com.fx.save/images/";
                File file = new File(dir);
                if (!file.exists()) {
                    file.mkdirs();
                }
                String datetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
                String filename = generation + "代" + line + "行" + name + " " + datetime;
                String mFilePath = this.getExternalFilesDir("images").getPath() + "/" + filename + ".png";
                Intent openCameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                Uri mUri = Uri.fromFile(new File(mFilePath));
                openCameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, mUri);
                startActivity(openCameraIntent);
                break;
            default:
                break;
        }
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
}
