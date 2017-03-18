package com.fx.soy.helper;

import com.fx.soy.entity.Soy;

import org.litepal.crud.DataSupport;

import java.util.List;

/**
 * Created by fx on 2017/3/10.
 */

public class DBHelper {
    public static void save(Soy soy) {
        soy.save();
    }

    public static List<Soy> queryAll() {
        List<Soy> soyList = DataSupport.select("id","seedDate","emergeDate","emergeRate","flowerColor","leafShape","hairColor","hullsColor","podHabit","plantHeight","podHeight","stemNumber","effectiveBranch","effectivePodNumberOfOne","lodgingDate","lodgingDegree","lodgingRate","bacterialSpotDiseases","downyMildew","grayLeafSpot","sclerotiniaSclerotiorum","viruses","nematodeDisease","areaLength","ridgeDistance","collectArea","collectName","collectDate","collectTime")
                .order("id")
                .find(Soy.class);
        return soyList;
    }

    public static void delete(Soy soy) {
        soy.delete();
    }

    public static void update(Soy soy,long id){
        soy.update(id);
    }

    public static Long findLastId(){
        Soy soy=DataSupport.select("id").findLast(Soy.class);
        return soy.getId();
    }
}
