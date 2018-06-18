package com.fx.soy.entity;

import android.os.Parcel;
import android.os.Parcelable;

import org.litepal.crud.DataSupport;

/**
 * Created by fx on 2017/3/8.
 */

public class Soy extends DataSupport implements Parcelable {

    private Long id;

    // 地点
    private String place;

    // 代
    private String generation;

    // 行
    private String line;

    // 株
    private String strain;

    // 父本
    private String maleParent;

    // 母本
    private String femaleParent;

    // 资源号
    private String name;

    // 播种期
    private String seedDate;

    // 分枝期
    private String branchDate;

    // 开花期
    private String floweringDate;

    // 结荚期
    private String poddingDate;

    // 成熟期
    private String matureDate;

    // 出苗期
    private String emergeDate;

    // 出苗率
    private String emergeRate;

    // 花色
    private String flowerColor;

    // 叶色
    private String leafColor;

    // 叶形
    private String leafShape;

    // 茸毛色
    private String hairColor;

    // 夹皮色
    private String hullsColor;

    // 结荚习性
    private String podHabit;

    // 百粒重
    private String hundredGrainWeight;

    // 株高
    private String plantHeight;

    // 底荚高
    private String podHeight;

    // 主茎节数
    private String stemNumber;

    // 有效分枝
    private String effectiveBranch;

    // 单株有效荚数
    private String effectivePodNumberOfOne;

    // 倒伏日期
    private String lodgingDate;

    // 倒伏程度
    private String lodgingDegree;

    // 倒伏率
    private String lodgingRate;

    // 细菌性斑点病
    private String bacterialSpotDiseases;

    // 细菌性斑点病发病日期
    private String bacterialSpotDiseasesDate;

    // 霜霉病
    private String downyMildew;

    // 霜霉病发病日期
    private String downyMildewDate;

    // 灰斑病
    private String grayLeafSpot;

    // 灰斑病发病日期
    private String grayLeafSpotDate;

    // 菌核病
    private String sclerotiniaSclerotiorum;

    // 菌核病发病日期
    private String sclerotiniaSclerotiorumDate;

    // 病毒
    private String viruses;

    // 病毒发病日期
    private String virusesDate;

    // 线虫病
    private String nematodeDisease;

    // 线虫病发病日期
    private String nematodeDiseaseDate;

    // 大豆蚜虫抗性
    private String aphidResistance;

    // 大豆食心虫抗性
    private String esophagealResistance;

    // 一粒荚数
    private String onePodNumber;

    // 二粒荚数
    private String twoPodNumber;

    // 三粒荚数
    private String threePodNumber;

    // 四粒荚数
    private String fourPodNumber;

    // 总荚数
    private String totalPodNumber;

    // 缺区长度
    private String areaLength;

    // 垄距
    private String ridgeDistance;

    // 采集地块
    private String collectArea;

    // 采集人姓名
    private String collectName;

    // 采集日期
    private String collectDate;

    // 采集时间
    private String collectTime;

    // 田间鉴评
    private String evaluate;

    // 备注
    private String remark;

    public Soy() {
    }

    public Soy(Long id, String place, String generation, String line, String strain, String maleParent, String femaleParent, String name, String seedDate, String branchDate, String floweringDate, String poddingDate, String matureDate, String emergeDate, String emergeRate, String flowerColor, String leafColor, String leafShape, String hairColor, String hullsColor, String podHabit, String hundredGrainWeight, String plantHeight, String podHeight, String stemNumber, String effectiveBranch, String effectivePodNumberOfOne, String lodgingDate, String lodgingDegree, String lodgingRate, String bacterialSpotDiseases, String bacterialSpotDiseasesDate, String downyMildew, String downyMildewDate, String grayLeafSpot, String grayLeafSpotDate, String sclerotiniaSclerotiorum, String sclerotiniaSclerotiorumDate, String viruses, String virusesDate, String nematodeDisease, String nematodeDiseaseDate, String aphidResistance, String esophagealResistance, String onePodNumber, String twoPodNumber, String threePodNumber, String fourPodNumber, String totalPodNumber, String areaLength, String ridgeDistance, String collectArea, String collectName, String collectDate, String collectTime, String evaluate, String remark) {
        this.id = id;
        this.place = place;
        this.generation = generation;
        this.line = line;
        this.strain = strain;
        this.maleParent = maleParent;
        this.femaleParent = femaleParent;
        this.name = name;
        this.seedDate = seedDate;
        this.branchDate = branchDate;
        this.floweringDate = floweringDate;
        this.poddingDate = poddingDate;
        this.matureDate = matureDate;
        this.emergeDate = emergeDate;
        this.emergeRate = emergeRate;
        this.flowerColor = flowerColor;
        this.leafColor = leafColor;
        this.leafShape = leafShape;
        this.hairColor = hairColor;
        this.hullsColor = hullsColor;
        this.podHabit = podHabit;
        this.hundredGrainWeight = hundredGrainWeight;
        this.plantHeight = plantHeight;
        this.podHeight = podHeight;
        this.stemNumber = stemNumber;
        this.effectiveBranch = effectiveBranch;
        this.effectivePodNumberOfOne = effectivePodNumberOfOne;
        this.lodgingDate = lodgingDate;
        this.lodgingDegree = lodgingDegree;
        this.lodgingRate = lodgingRate;
        this.bacterialSpotDiseases = bacterialSpotDiseases;
        this.bacterialSpotDiseasesDate = bacterialSpotDiseasesDate;
        this.downyMildew = downyMildew;
        this.downyMildewDate = downyMildewDate;
        this.grayLeafSpot = grayLeafSpot;
        this.grayLeafSpotDate = grayLeafSpotDate;
        this.sclerotiniaSclerotiorum = sclerotiniaSclerotiorum;
        this.sclerotiniaSclerotiorumDate = sclerotiniaSclerotiorumDate;
        this.viruses = viruses;
        this.virusesDate = virusesDate;
        this.nematodeDisease = nematodeDisease;
        this.nematodeDiseaseDate = nematodeDiseaseDate;
        this.aphidResistance = aphidResistance;
        this.esophagealResistance = esophagealResistance;
        this.onePodNumber = onePodNumber;
        this.twoPodNumber = twoPodNumber;
        this.threePodNumber = threePodNumber;
        this.fourPodNumber = fourPodNumber;
        this.totalPodNumber = totalPodNumber;
        this.areaLength = areaLength;
        this.ridgeDistance = ridgeDistance;
        this.collectArea = collectArea;
        this.collectName = collectName;
        this.collectDate = collectDate;
        this.collectTime = collectTime;
        this.evaluate = evaluate;
        this.remark = remark;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.id);
        dest.writeString(this.place);
        dest.writeString(this.generation);
        dest.writeString(this.line);
        dest.writeString(this.strain);
        dest.writeString(this.maleParent);
        dest.writeString(this.femaleParent);
        dest.writeString(this.name);
        dest.writeString(this.seedDate);
        dest.writeString(this.branchDate);
        dest.writeString(this.floweringDate);
        dest.writeString(this.poddingDate);
        dest.writeString(this.matureDate);
        dest.writeString(this.emergeDate);
        dest.writeString(this.emergeRate);
        dest.writeString(this.flowerColor);
        dest.writeString(this.leafColor);
        dest.writeString(this.leafShape);
        dest.writeString(this.hairColor);
        dest.writeString(this.hullsColor);
        dest.writeString(this.podHabit);
        dest.writeString(this.hundredGrainWeight);
        dest.writeString(this.plantHeight);
        dest.writeString(this.podHeight);
        dest.writeString(this.stemNumber);
        dest.writeString(this.effectiveBranch);
        dest.writeString(this.effectivePodNumberOfOne);
        dest.writeString(this.lodgingDate);
        dest.writeString(this.lodgingDegree);
        dest.writeString(this.lodgingRate);
        dest.writeString(this.bacterialSpotDiseases);
        dest.writeString(this.bacterialSpotDiseasesDate);
        dest.writeString(this.downyMildew);
        dest.writeString(this.downyMildewDate);
        dest.writeString(this.grayLeafSpot);
        dest.writeString(this.grayLeafSpotDate);
        dest.writeString(this.sclerotiniaSclerotiorum);
        dest.writeString(this.sclerotiniaSclerotiorumDate);
        dest.writeString(this.viruses);
        dest.writeString(this.virusesDate);
        dest.writeString(this.nematodeDisease);
        dest.writeString(this.nematodeDiseaseDate);
        dest.writeString(this.aphidResistance);
        dest.writeString(this.esophagealResistance);
        dest.writeString(this.onePodNumber);
        dest.writeString(this.twoPodNumber);
        dest.writeString(this.threePodNumber);
        dest.writeString(this.fourPodNumber);
        dest.writeString(this.totalPodNumber);
        dest.writeString(this.areaLength);
        dest.writeString(this.ridgeDistance);
        dest.writeString(this.collectArea);
        dest.writeString(this.collectName);
        dest.writeString(this.collectDate);
        dest.writeString(this.collectTime);
        dest.writeString(this.evaluate);
        dest.writeString(this.remark);
    }

    protected Soy(Parcel in) {
        this.id = (Long) in.readValue(Long.class.getClassLoader());
        this.place = in.readString();
        this.generation = in.readString();
        this.line = in.readString();
        this.strain = in.readString();
        this.maleParent = in.readString();
        this.femaleParent = in.readString();
        this.name = in.readString();
        this.seedDate = in.readString();
        this.branchDate = in.readString();
        this.floweringDate = in.readString();
        this.poddingDate = in.readString();
        this.matureDate = in.readString();
        this.emergeDate = in.readString();
        this.emergeRate = in.readString();
        this.flowerColor = in.readString();
        this.leafColor = in.readString();
        this.leafShape = in.readString();
        this.hairColor = in.readString();
        this.hullsColor = in.readString();
        this.podHabit = in.readString();
        this.hundredGrainWeight = in.readString();
        this.plantHeight = in.readString();
        this.podHeight = in.readString();
        this.stemNumber = in.readString();
        this.effectiveBranch = in.readString();
        this.effectivePodNumberOfOne = in.readString();
        this.lodgingDate = in.readString();
        this.lodgingDegree = in.readString();
        this.lodgingRate = in.readString();
        this.bacterialSpotDiseases = in.readString();
        this.bacterialSpotDiseasesDate = in.readString();
        this.downyMildew = in.readString();
        this.downyMildewDate = in.readString();
        this.grayLeafSpot = in.readString();
        this.grayLeafSpotDate = in.readString();
        this.sclerotiniaSclerotiorum = in.readString();
        this.sclerotiniaSclerotiorumDate = in.readString();
        this.viruses = in.readString();
        this.virusesDate = in.readString();
        this.nematodeDisease = in.readString();
        this.nematodeDiseaseDate = in.readString();
        this.aphidResistance = in.readString();
        this.esophagealResistance = in.readString();
        this.onePodNumber = in.readString();
        this.twoPodNumber = in.readString();
        this.threePodNumber = in.readString();
        this.fourPodNumber = in.readString();
        this.totalPodNumber = in.readString();
        this.areaLength = in.readString();
        this.ridgeDistance = in.readString();
        this.collectArea = in.readString();
        this.collectName = in.readString();
        this.collectDate = in.readString();
        this.collectTime = in.readString();
        this.evaluate = in.readString();
        this.remark = in.readString();
    }

    public static final Creator<Soy> CREATOR = new Creator<Soy>() {
        @Override
        public Soy createFromParcel(Parcel source) {
            return new Soy(source);
        }

        @Override
        public Soy[] newArray(int size) {
            return new Soy[size];
        }
    };

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getGeneration() {
        return generation;
    }

    public void setGeneration(String generation) {
        this.generation = generation;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getStrain() {
        return strain;
    }

    public void setStrain(String strain) {
        this.strain = strain;
    }

    public String getMaleParent() {
        return maleParent;
    }

    public void setMaleParent(String maleParent) {
        this.maleParent = maleParent;
    }

    public String getFemaleParent() {
        return femaleParent;
    }

    public void setFemaleParent(String femaleParent) {
        this.femaleParent = femaleParent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSeedDate() {
        return seedDate;
    }

    public void setSeedDate(String seedDate) {
        this.seedDate = seedDate;
    }

    public String getBranchDate() {
        return branchDate;
    }

    public void setBranchDate(String branchDate) {
        this.branchDate = branchDate;
    }

    public String getFloweringDate() {
        return floweringDate;
    }

    public void setFloweringDate(String floweringDate) {
        this.floweringDate = floweringDate;
    }

    public String getPoddingDate() {
        return poddingDate;
    }

    public void setPoddingDate(String poddingDate) {
        this.poddingDate = poddingDate;
    }

    public String getMatureDate() {
        return matureDate;
    }

    public void setMatureDate(String matureDate) {
        this.matureDate = matureDate;
    }

    public String getEmergeDate() {
        return emergeDate;
    }

    public void setEmergeDate(String emergeDate) {
        this.emergeDate = emergeDate;
    }

    public String getEmergeRate() {
        return emergeRate;
    }

    public void setEmergeRate(String emergeRate) {
        this.emergeRate = emergeRate;
    }

    public String getFlowerColor() {
        return flowerColor;
    }

    public void setFlowerColor(String flowerColor) {
        this.flowerColor = flowerColor;
    }

    public String getLeafColor() {
        return leafColor;
    }

    public void setLeafColor(String leafColor) {
        this.leafColor = leafColor;
    }

    public String getLeafShape() {
        return leafShape;
    }

    public void setLeafShape(String leafShape) {
        this.leafShape = leafShape;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public String getHullsColor() {
        return hullsColor;
    }

    public void setHullsColor(String hullsColor) {
        this.hullsColor = hullsColor;
    }

    public String getPodHabit() {
        return podHabit;
    }

    public void setPodHabit(String podHabit) {
        this.podHabit = podHabit;
    }

    public String getHundredGrainWeight() {
        return hundredGrainWeight;
    }

    public void setHundredGrainWeight(String hundredGrainWeight) {
        this.hundredGrainWeight = hundredGrainWeight;
    }

    public String getPlantHeight() {
        return plantHeight;
    }

    public void setPlantHeight(String plantHeight) {
        this.plantHeight = plantHeight;
    }

    public String getPodHeight() {
        return podHeight;
    }

    public void setPodHeight(String podHeight) {
        this.podHeight = podHeight;
    }

    public String getStemNumber() {
        return stemNumber;
    }

    public void setStemNumber(String stemNumber) {
        this.stemNumber = stemNumber;
    }

    public String getEffectiveBranch() {
        return effectiveBranch;
    }

    public void setEffectiveBranch(String effectiveBranch) {
        this.effectiveBranch = effectiveBranch;
    }

    public String getEffectivePodNumberOfOne() {
        return effectivePodNumberOfOne;
    }

    public void setEffectivePodNumberOfOne(String effectivePodNumberOfOne) {
        this.effectivePodNumberOfOne = effectivePodNumberOfOne;
    }

    public String getLodgingDate() {
        return lodgingDate;
    }

    public void setLodgingDate(String lodgingDate) {
        this.lodgingDate = lodgingDate;
    }

    public String getLodgingDegree() {
        return lodgingDegree;
    }

    public void setLodgingDegree(String lodgingDegree) {
        this.lodgingDegree = lodgingDegree;
    }

    public String getLodgingRate() {
        return lodgingRate;
    }

    public void setLodgingRate(String lodgingRate) {
        this.lodgingRate = lodgingRate;
    }

    public String getBacterialSpotDiseases() {
        return bacterialSpotDiseases;
    }

    public void setBacterialSpotDiseases(String bacterialSpotDiseases) {
        this.bacterialSpotDiseases = bacterialSpotDiseases;
    }

    public String getBacterialSpotDiseasesDate() {
        return bacterialSpotDiseasesDate;
    }

    public void setBacterialSpotDiseasesDate(String bacterialSpotDiseasesDate) {
        this.bacterialSpotDiseasesDate = bacterialSpotDiseasesDate;
    }

    public String getDownyMildew() {
        return downyMildew;
    }

    public void setDownyMildew(String downyMildew) {
        this.downyMildew = downyMildew;
    }

    public String getDownyMildewDate() {
        return downyMildewDate;
    }

    public void setDownyMildewDate(String downyMildewDate) {
        this.downyMildewDate = downyMildewDate;
    }

    public String getGrayLeafSpot() {
        return grayLeafSpot;
    }

    public void setGrayLeafSpot(String grayLeafSpot) {
        this.grayLeafSpot = grayLeafSpot;
    }

    public String getGrayLeafSpotDate() {
        return grayLeafSpotDate;
    }

    public void setGrayLeafSpotDate(String grayLeafSpotDate) {
        this.grayLeafSpotDate = grayLeafSpotDate;
    }

    public String getSclerotiniaSclerotiorum() {
        return sclerotiniaSclerotiorum;
    }

    public void setSclerotiniaSclerotiorum(String sclerotiniaSclerotiorum) {
        this.sclerotiniaSclerotiorum = sclerotiniaSclerotiorum;
    }

    public String getSclerotiniaSclerotiorumDate() {
        return sclerotiniaSclerotiorumDate;
    }

    public void setSclerotiniaSclerotiorumDate(String sclerotiniaSclerotiorumDate) {
        this.sclerotiniaSclerotiorumDate = sclerotiniaSclerotiorumDate;
    }

    public String getViruses() {
        return viruses;
    }

    public void setViruses(String viruses) {
        this.viruses = viruses;
    }

    public String getVirusesDate() {
        return virusesDate;
    }

    public void setVirusesDate(String virusesDate) {
        this.virusesDate = virusesDate;
    }

    public String getNematodeDisease() {
        return nematodeDisease;
    }

    public void setNematodeDisease(String nematodeDisease) {
        this.nematodeDisease = nematodeDisease;
    }

    public String getNematodeDiseaseDate() {
        return nematodeDiseaseDate;
    }

    public void setNematodeDiseaseDate(String nematodeDiseaseDate) {
        this.nematodeDiseaseDate = nematodeDiseaseDate;
    }

    public String getAphidResistance() {
        return aphidResistance;
    }

    public void setAphidResistance(String aphidResistance) {
        this.aphidResistance = aphidResistance;
    }

    public String getEsophagealResistance() {
        return esophagealResistance;
    }

    public void setEsophagealResistance(String esophagealResistance) {
        this.esophagealResistance = esophagealResistance;
    }

    public String getOnePodNumber() {
        return onePodNumber;
    }

    public void setOnePodNumber(String onePodNumber) {
        this.onePodNumber = onePodNumber;
    }

    public String getTwoPodNumber() {
        return twoPodNumber;
    }

    public void setTwoPodNumber(String twoPodNumber) {
        this.twoPodNumber = twoPodNumber;
    }

    public String getThreePodNumber() {
        return threePodNumber;
    }

    public void setThreePodNumber(String threePodNumber) {
        this.threePodNumber = threePodNumber;
    }

    public String getFourPodNumber() {
        return fourPodNumber;
    }

    public void setFourPodNumber(String fourPodNumber) {
        this.fourPodNumber = fourPodNumber;
    }

    public String getTotalPodNumber() {
        return totalPodNumber;
    }

    public void setTotalPodNumber(String totalPodNumber) {
        this.totalPodNumber = totalPodNumber;
    }

    public String getAreaLength() {
        return areaLength;
    }

    public void setAreaLength(String areaLength) {
        this.areaLength = areaLength;
    }

    public String getRidgeDistance() {
        return ridgeDistance;
    }

    public void setRidgeDistance(String ridgeDistance) {
        this.ridgeDistance = ridgeDistance;
    }

    public String getCollectArea() {
        return collectArea;
    }

    public void setCollectArea(String collectArea) {
        this.collectArea = collectArea;
    }

    public String getCollectName() {
        return collectName;
    }

    public void setCollectName(String collectName) {
        this.collectName = collectName;
    }

    public String getCollectDate() {
        return collectDate;
    }

    public void setCollectDate(String collectDate) {
        this.collectDate = collectDate;
    }

    public String getCollectTime() {
        return collectTime;
    }

    public void setCollectTime(String collectTime) {
        this.collectTime = collectTime;
    }

    public String getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(String evaluate) {
        this.evaluate = evaluate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
