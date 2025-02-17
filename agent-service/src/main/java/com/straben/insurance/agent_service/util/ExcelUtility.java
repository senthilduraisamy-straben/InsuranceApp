package com.straben.insurance.agent_service.util;

import com.straben.insurance.agent_service.entity.Policy;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelUtility {
    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    static String SHEET = "data";
    public static boolean hasExcelFormat(MultipartFile file) {
        if (!TYPE.equals(file.getContentType())) {
            return false;
        }
        return true;
    }
    public static List<Policy> getPolicyDataFromExcel(InputStream inputStream){
        List<Policy> policies = new ArrayList<>();
        DataFormatter formatter = new DataFormatter();
        try{
            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet sheet = workbook.getSheet(SHEET);
            int rowIndx=0;
            for(Row row : sheet){
                if(rowIndx==0){
                    rowIndx++;
                    continue;
                }
                Iterator<Cell> cellIterator=row.iterator();
                int cellIndx=0;
                Policy policy=new Policy();
                while(cellIterator.hasNext()){
                    Cell cell=cellIterator.next();
                    switch (cellIndx){
                        case 0 -> policy.setPolicyNo((int) cell.getNumericCellValue());
                        case 1 -> policy.setName(cell.getStringCellValue());
                        case 2 -> policy.setContact(cell.getStringCellValue());
                        default -> {

                        }
                    }
                    cellIndx++;
                }
                policies.add(policy);
            }
         workbook.close();
            return policies;
        }catch(IOException e){

            throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
        }

    }
}
