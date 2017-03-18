package com.fx.soy.util;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.widget.Toast;

import com.fx.soy.entity.Soy;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import jxl.Workbook;
import jxl.format.Colour;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/**
 * Created by fx on 2017/3/11.
 */

public class ExcelUtil {

    //内存地址
    public static String root = Environment.getExternalStorageDirectory()
            .getPath();

    public static void writeExcel(Context context, List<Soy> soyList,
                                  String fileName) throws Exception {
        if (!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED) && getAvailableStorage() > 1000000) {
            Toast.makeText(context, "SD卡不可用", Toast.LENGTH_LONG).show();
            return;
        }
        String[] title = {"播种期", "出苗期", "出苗率", "花色", "叶形", "茸毛色", "夹皮色", "结荚习性", "株高", "底荚高", "主茎节数", "有效分支", "单株有效荚数", "倒伏日期", "倒伏程度", "倒伏率", "细菌性斑点病", "霜霉病", "灰斑病", "菌核病", "病毒", "线虫病", "缺区长度", "垄距", "采集地块", "采集人姓名", "采集日期", "采集时间"};
        File file;
        File dir = new File(context.getExternalFilesDir(null).getPath());
        String datetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        file = new File(dir, fileName + datetime + ".xls");
        if (!dir.exists()) {
            dir.mkdirs();
        }
        // 创建Excel工作表
        WritableWorkbook wwb;
        OutputStream os = new FileOutputStream(file);
        wwb = Workbook.createWorkbook(os);
        // 添加第一个工作表并设置第一个Sheet的名字
        WritableSheet sheet = wwb.createSheet("大豆数据", 0);
        Label label;
        for (int i = 0; i < title.length; i++) {
            // Label(x,y,z) 代表单元格的第x+1列，第y+1行, 内容z
            // 在Label对象的子对象中指明单元格的位置和内容
            label = new Label(i, 0, title[i], getHeader());
            // 将定义好的单元格添加到工作表中
            sheet.addCell(label);
        }

        for (int i = 0; i < soyList.size(); i++) {
            Soy soy = soyList.get(i);

            Label seedDate = new Label(0, i + 1, soy.getSeedDate());
            Label emergeDate = new Label(1, i + 1, soy.getEmergeDate());
            Label emergeRate = new Label(2, i + 1, soy.getEmergeRate());
            Label flowerColor = new Label(3, i + 1, soy.getFlowerColor());
            Label leafShape = new Label(4, i + 1, soy.getLeafShape());
            Label hairColor = new Label(5, i + 1, soy.getHairColor());
            Label hullsColor = new Label(6, i + 1, soy.getHullsColor());
            Label podHabit = new Label(7, i + 1, soy.getPodHabit());
            Label plantHeight = new Label(8, i + 1, soy.getPlantHeight());
            Label podHeight = new Label(9, i + 1, soy.getPodHeight());
            Label stemNumber = new Label(10, i + 1, soy.getStemNumber());
            Label effectiveBranch = new Label(11, i + 1, soy.getEffectiveBranch());
            Label effectivePodNumberOfOne = new Label(12, i + 1, soy.getEffectivePodNumberOfOne());
            Label lodgingDate = new Label(13, i + 1, soy.getLodgingDate());
            Label lodgingDegree = new Label(14, i + 1, soy.getLodgingDegree());
            Label lodgingRate = new Label(15, i + 1, soy.getLodgingRate());
            Label bacterialSpotDiseases = new Label(16, i + 1, soy.getBacterialSpotDiseases());
            Label downyMildew = new Label(17, i + 1, soy.getDownyMildew());
            Label grayLeafSpot = new Label(18, i + 1, soy.getGrayLeafSpot());
            Label sclerotiniaSclerotiorum = new Label(19, i + 1, soy.getSclerotiniaSclerotiorum());
            Label viruses = new Label(20, i + 1, soy.getViruses());
            Label nematodeDisease = new Label(21, i + 1, soy.getNematodeDisease());
            Label areaLength = new Label(22, i + 1, soy.getAreaLength());
            Label ridgeDistance = new Label(23, i + 1, soy.getRidgeDistance());
            Label collectArea = new Label(24, i + 1, soy.getCollectArea());
            Label collectName = new Label(25, i + 1, soy.getCollectName());
            Label collectDate = new Label(26, i + 1, soy.getCollectDate());
            Label collectTime = new Label(27, i + 1, soy.getCollectTime());

            sheet.addCell(seedDate);
            sheet.addCell(emergeDate);
            sheet.addCell(emergeRate);
            sheet.addCell(flowerColor);
            sheet.addCell(leafShape);
            sheet.addCell(hairColor);
            sheet.addCell(hullsColor);
            sheet.addCell(podHabit);
            sheet.addCell(plantHeight);
            sheet.addCell(podHeight);
            sheet.addCell(stemNumber);
            sheet.addCell(effectiveBranch);
            sheet.addCell(effectivePodNumberOfOne);
            sheet.addCell(lodgingDate);
            sheet.addCell(lodgingDegree);
            sheet.addCell(lodgingRate);
            sheet.addCell(bacterialSpotDiseases);
            sheet.addCell(downyMildew);
            sheet.addCell(grayLeafSpot);
            sheet.addCell(sclerotiniaSclerotiorum);
            sheet.addCell(viruses);
            sheet.addCell(nematodeDisease);
            sheet.addCell(areaLength);
            sheet.addCell(ridgeDistance);
            sheet.addCell(collectArea);
            sheet.addCell(collectName);
            sheet.addCell(collectDate);
            sheet.addCell(collectTime);
            Toast.makeText(context, "导出数据成功", Toast.LENGTH_LONG).show();

        }
        // 写入数据
        wwb.write();
        // 关闭文件
        wwb.close();
    }

    public static WritableCellFormat getHeader() {
        WritableFont font = new WritableFont(WritableFont.TIMES, 10,
                WritableFont.BOLD);// 定义字体
        try {
            font.setColour(Colour.BLUE);// 蓝色字体
        } catch (WriteException e1) {
            e1.printStackTrace();
        }
        WritableCellFormat format = new WritableCellFormat(font);
        try {
            format.setAlignment(jxl.format.Alignment.CENTRE);// 左右居中
            format.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);// 上下居中
            // format.setBorder(Border.ALL, BorderLineStyle.THIN,
            // Colour.BLACK);// 黑色边框
            // format.setBackground(Colour.YELLOW);// 黄色背景
        } catch (WriteException e) {
            e.printStackTrace();
        }
        return format;
    }

    /**
     * 获取SD可用容量
     */
    private static long getAvailableStorage() {

        StatFs statFs = new StatFs(root);
        long blockSize = statFs.getBlockSize();
        long availableBlocks = statFs.getAvailableBlocks();
        long availableSize = blockSize * availableBlocks;
        // Formatter.formatFileSize(context, availableSize);
        return availableSize;
    }
}
