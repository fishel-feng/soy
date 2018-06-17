package com.fx.soy.entity;

import android.os.Parcel;
import android.os.Parcelable;

import org.litepal.crud.DataSupport;

/**
 * Created by fx on 2017/3/8.
 */

public class Soy extends DataSupport implements Parcelable {

    private Long id;

    private String place;

    // 代
    private String generation;

    // 行
    private String line;

    // 资源号
    private String name;

    // 播种期
    private String seedDate;

    // 出苗期
    private String emergeDate;

    // 出苗率
    private String emergeRate;

    // 花色
    private String flowerColor;

    // 叶形
    private String leafShape;

    // 茸毛色
    private String hairColor;

    // 夹皮色
    private String hullsColor;

    // 结荚习性
    private String podHabit;

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

    // 霜霉病
    private String downyMildew;

    // 灰斑病
    private String grayLeafSpot;

    // 菌核病
    private String sclerotiniaSclerotiorum;

    // 病毒
    private String viruses;

    // 线虫病
    private String nematodeDisease;

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

    public Soy() {
    }

    public Soy(Long id, String place, String generation, String line, String name, String seedDate, String emergeDate, String emergeRate, String flowerColor, String leafShape, String hairColor, String hullsColor, String podHabit, String plantHeight, String podHeight, String stemNumber, String effectiveBranch, String effectivePodNumberOfOne, String lodgingDate, String lodgingDegree, String lodgingRate, String bacterialSpotDiseases, String downyMildew, String grayLeafSpot, String sclerotiniaSclerotiorum, String viruses, String nematodeDisease, String areaLength, String ridgeDistance, String collectArea, String collectName, String collectDate, String collectTime) {
        this.id = id;
        this.place = place;
        this.generation = generation;
        this.line = line;
        this.name = name;
        this.seedDate = seedDate;
        this.emergeDate = emergeDate;
        this.emergeRate = emergeRate;
        this.flowerColor = flowerColor;
        this.leafShape = leafShape;
        this.hairColor = hairColor;
        this.hullsColor = hullsColor;
        this.podHabit = podHabit;
        this.plantHeight = plantHeight;
        this.podHeight = podHeight;
        this.stemNumber = stemNumber;
        this.effectiveBranch = effectiveBranch;
        this.effectivePodNumberOfOne = effectivePodNumberOfOne;
        this.lodgingDate = lodgingDate;
        this.lodgingDegree = lodgingDegree;
        this.lodgingRate = lodgingRate;
        this.bacterialSpotDiseases = bacterialSpotDiseases;
        this.downyMildew = downyMildew;
        this.grayLeafSpot = grayLeafSpot;
        this.sclerotiniaSclerotiorum = sclerotiniaSclerotiorum;
        this.viruses = viruses;
        this.nematodeDisease = nematodeDisease;
        this.areaLength = areaLength;
        this.ridgeDistance = ridgeDistance;
        this.collectArea = collectArea;
        this.collectName = collectName;
        this.collectDate = collectDate;
        this.collectTime = collectTime;
    }

    protected Soy(Parcel in) {
        id=in.readLong();
        place = in.readString();
        generation = in.readString();
        line = in.readString();
        name = in.readString();
        seedDate = in.readString();
        emergeDate = in.readString();
        emergeRate = in.readString();
        flowerColor = in.readString();
        leafShape = in.readString();
        hairColor = in.readString();
        hullsColor = in.readString();
        podHabit = in.readString();
        plantHeight = in.readString();
        podHeight = in.readString();
        stemNumber = in.readString();
        effectiveBranch = in.readString();
        effectivePodNumberOfOne = in.readString();
        lodgingDate = in.readString();
        lodgingDegree = in.readString();
        lodgingRate = in.readString();
        bacterialSpotDiseases = in.readString();
        downyMildew = in.readString();
        grayLeafSpot = in.readString();
        sclerotiniaSclerotiorum = in.readString();
        viruses = in.readString();
        nematodeDisease = in.readString();
        areaLength = in.readString();
        ridgeDistance = in.readString();
        collectArea = in.readString();
        collectName = in.readString();
        collectDate = in.readString();
        collectTime = in.readString();
    }

    public static final Creator<Soy> CREATOR = new Creator<Soy>() {
        @Override
        public Soy createFromParcel(Parcel in) {
            return new Soy(in);
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

    public String getDownyMildew() {
        return downyMildew;
    }

    public void setDownyMildew(String downyMildew) {
        this.downyMildew = downyMildew;
    }

    public String getGrayLeafSpot() {
        return grayLeafSpot;
    }

    public void setGrayLeafSpot(String grayLeafSpot) {
        this.grayLeafSpot = grayLeafSpot;
    }

    public String getSclerotiniaSclerotiorum() {
        return sclerotiniaSclerotiorum;
    }

    public void setSclerotiniaSclerotiorum(String sclerotiniaSclerotiorum) {
        this.sclerotiniaSclerotiorum = sclerotiniaSclerotiorum;
    }

    public String getViruses() {
        return viruses;
    }

    public void setViruses(String viruses) {
        this.viruses = viruses;
    }

    public String getNematodeDisease() {
        return nematodeDisease;
    }

    public void setNematodeDisease(String nematodeDisease) {
        this.nematodeDisease = nematodeDisease;
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

    public static Creator<Soy> getCREATOR() {
        return CREATOR;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(place);
        dest.writeString(generation);
        dest.writeString(line);
        dest.writeString(name);
        dest.writeString(seedDate);
        dest.writeString(emergeDate);
        dest.writeString(emergeRate);
        dest.writeString(flowerColor);
        dest.writeString(leafShape);
        dest.writeString(hairColor);
        dest.writeString(hullsColor);
        dest.writeString(podHabit);
        dest.writeString(plantHeight);
        dest.writeString(podHeight);
        dest.writeString(stemNumber);
        dest.writeString(effectiveBranch);
        dest.writeString(effectivePodNumberOfOne);
        dest.writeString(lodgingDate);
        dest.writeString(lodgingDegree);
        dest.writeString(lodgingRate);
        dest.writeString(bacterialSpotDiseases);
        dest.writeString(downyMildew);
        dest.writeString(grayLeafSpot);
        dest.writeString(sclerotiniaSclerotiorum);
        dest.writeString(viruses);
        dest.writeString(nematodeDisease);
        dest.writeString(areaLength);
        dest.writeString(ridgeDistance);
        dest.writeString(collectArea);
        dest.writeString(collectName);
        dest.writeString(collectDate);
        dest.writeString(collectTime);
    }
}
