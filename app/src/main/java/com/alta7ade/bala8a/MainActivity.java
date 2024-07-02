package com.alta7ade.bala8a;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


import java.io.IOException;
import java.io.InputStream;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    CardView i2;
    Mydatabase sqldb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setNavigationBarColor(getResources().getColor(R.color.secondaire));
        System.setProperty("org.apache.poi.javax.xml.stream.XMLInputFactory", "com.fasterxml.aalto.stax.InputFactoryImpl");
        System.setProperty("org.apache.poi.javax.xml.stream.XMLOutputFactory", "com.fasterxml.aalto.stax.OutputFactoryImpl");
        System.setProperty("org.apache.poi.javax.xml.stream.XMLEventFactory", "com.fasterxml.aalto.stax.EventFactoryImpl");
        i2=findViewById(R.id.logo_image);

        Animation a1= AnimationUtils.loadAnimation(this, R.anim.logo);
        a1.setDuration(2000);
        i2.setAnimation(a1);
        sqldb=new Mydatabase(MainActivity.this);
        sqldb.deleteallquestions();

        if((sqldb.getquestionscount())==0) {
            sqldb.deleteallquestions();
            readExcelFromAssets(this, "questions.xls");
        }
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent =new Intent (MainActivity.this,owner_info.class);
                startActivity(intent);
                finish();
            }
        },3000);
    }

    public void readExcelFromAssets(final Context context, final String fileName) {
        try {

            AssetManager assetManager = context.getAssets();

            InputStream inputStream = assetManager.open(fileName);

            Workbook workbook= WorkbookFactory.create(inputStream);

            Sheet sheet = workbook.getSheetAt(0);
            // Starting from the second row (index 1) to skip the header row
            for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
                Row row = sheet.getRow(rowIndex);

                // Read data from each column
                String question = row.getCell(1).getCellType()== CellType.STRING? row.getCell(1).getStringCellValue():row.getCell(1).getNumericCellValue()+"";
                String rightAnswer = row.getCell(2).getCellType()== CellType.STRING? row.getCell(2).getStringCellValue():row.getCell(2).getNumericCellValue()+"";
                String false1 =row.getCell(3).getCellType()== CellType.STRING? row.getCell(3).getStringCellValue():row.getCell(3).getNumericCellValue()+"";
                String false2 =row.getCell(4).getCellType()== CellType.STRING? row.getCell(4).getStringCellValue():row.getCell(4).getNumericCellValue()+"";
                String false3 = row.getCell(5).getCellType()== CellType.STRING? row.getCell(5).getStringCellValue():row.getCell(5).getNumericCellValue()+"";
                String lesson = row.getCell(6).getCellType()== CellType.STRING? row.getCell(6).getStringCellValue():row.getCell(6).getNumericCellValue()+"";
                String category =row.getCell(7).getCellType()== CellType.STRING? row.getCell(7).getStringCellValue():row.getCell(7).getNumericCellValue()+"";

                // Assuming sqldb.insertquestionform() is a method that correctly inserts into your database
                sqldb.insertquestionform(new questionform(false1, false2, false3, lesson, question, rightAnswer, category));
            }

            workbook.close();
            inputStream.close();
            Log.d("ExcelReader", "Data inserted successfully!");

        } catch (IOException e) {
            e.printStackTrace();
            Log.e("ExcelReader",  ""+e);
            // Show toast on UI thread
            new Handler(context.getMainLooper()).post(() -> Toast.makeText(context, "Error reading Excel file: " + e.getMessage(), Toast.LENGTH_SHORT).show());

        }
    }
}
