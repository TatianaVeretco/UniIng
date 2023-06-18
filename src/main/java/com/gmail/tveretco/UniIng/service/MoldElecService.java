package com.gmail.tveretco.UniIng.service;

import com.gmail.tveretco.UniIng.model.Remont;
import lombok.AllArgsConstructor;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class MoldElecService {
    private FileReadService fileReadService;

    public List<Remont> remontList=new ArrayList<>();



    public void init() throws IOException, InvalidFormatException {


        Map<Integer, Map<Integer, List<String>>> mapMap = fileReadService.init("C:\\demo\\Input Date.xls");
        Map<Integer, List<String>> integerListMap = mapMap.get(1);

        for (Integer i : integerListMap.keySet()) {
            if(i<10 || i>56) continue;
            extracted(integerListMap, i);
        }

    }

    private void extracted(Map<Integer, List<String>> integerListMap, Integer i) {
        List<String> strings = integerListMap.get(i);
        Remont remont = new Remont();
        remont.setNameSE(strings.get(1));
        for(int j=2;j<13;j++){
            String tmp=strings.get(j);
            if(tmp.contains("Op")) remont.setOr1(j-1);
            if(!tmp.contains("Ор") && tmp.contains("О")) remont.setO(j-1);
            if(tmp.contains("Т1")) remont.setT1(j-1);
            if(tmp.contains("Т2")) remont.setT2(j-1);
            if(tmp.contains("Т") && !tmp.contains("Т1") && !tmp.contains("Т2")) remont.setT(j-1);
            if(tmp.contains("К")) remont.setK(j-1);
            if(tmp.contains("И")) remont.setI(j-1);
            if(tmp.contains("P")) remont.setP(j-1);
            if(tmp.contains("К тр")) remont.setKtr(j-1);
        }
        remont.setGroupSE(strings.get(13));
        remontList.add(remont);

//        Particle particle = particleRepository.findFirstByParticle(getStringValue(strings, 0))
//                .orElse(null);
//
//        extracted(strings, getIntValue(strings.get(1)), particle);
    }

  ////////
}
