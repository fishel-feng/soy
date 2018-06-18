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
        List<Soy> soyList = DataSupport.select("id", "place", "generation", "line",
                "strain", "maleParent", "femaleParent", "name", "seedDate", "branchDate", "floweringDate",
                "poddingDate", "matureDate", "emergeDate", "emergeRate", "flowerColor", "leafColor", "leafShape",
                "hairColor", "hullsColor", "podHabit", "hundredGrainWeight", "plantHeight", "podHeight", "stemNumber",
                "effectiveBranch", "effectivePodNumberOfOne", "lodgingDate", "lodgingDegree",
                "lodgingRate", "bacterialSpotDiseases", "bacterialSpotDiseasesDate", "downyMildew", "downyMildewDate",
                "grayLeafSpot", "grayLeafSpotDate", "sclerotiniaSclerotiorum", "sclerotiniaSclerotiorumDate",
                "viruses", "virusesDate", "nematodeDisease", "nematodeDiseaseDate", "aphidResistance",
                "esophagealResistance", "onePodNumber", "twoPodNumber", "threePodNumber", "fourPodNumber",
                "totalPodNumber", "areaLength", "ridgeDistance", "collectArea", "collectName",
                "collectDate", "collectTime", "evaluate", "remark")
                .order("id")
                .find(Soy.class);
        return soyList;
    }

    public static void delete(Soy soy) {
        soy.delete();
    }

    public static void update(Soy soy, long id) {
        soy.update(id);
    }

    public static Long findLastId() {
        Soy soy = DataSupport.select("id").findLast(Soy.class);
        return soy.getId();
    }
}