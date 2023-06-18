package com.gmail.tveretco.UniIng.service;

import lombok.AllArgsConstructor;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class FileReadService {



    public Map<Integer, Map<Integer, List<String>>> init(final String fileLocation) throws IOException {
        Workbook workbook = getSheets(fileLocation);
        int numberOfSheets = workbook.getNumberOfSheets();
        Map<Integer, Map<Integer, List<String>>> resultDate = new HashMap<>();

        for (int j = 0; j < numberOfSheets; j++) {
            Map<Integer, List<String>> data = getIntegerListMap(workbook, j);
            resultDate.put(j, data);
        }
        return resultDate;
    }

    private Workbook getSheets(final String fileLocation) throws IOException {
        FileInputStream file = new FileInputStream(fileLocation);
        return new HSSFWorkbook(file);
    }

    private Map<Integer, List<String>> getIntegerListMap(Workbook workbook, int j) {
        Sheet sheet = workbook.getSheetAt(j);
        Map<Integer, List<String>> data = new HashMap<>();
        extracted(sheet, data);
        return data;
    }

    private void extracted(Sheet sheet, Map<Integer, List<String>> data) {
        int i = 0;
        for (Row row : sheet) {
            data.put(i, new ArrayList<String>());
            for (Cell cell : row) {
                switch (cell.getCellType()) {
                    case STRING:
                        data.get(i).add(cell.getStringCellValue());
                        break;
                    case NUMERIC:
                        data.get(i).add(String.valueOf((cell.getNumericCellValue())));
                        break;
                    default:
                        data.get(i).add(" ");
                }
            }
            i++;
        }
    }
}