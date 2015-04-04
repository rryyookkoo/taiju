package taiju.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import taiju.domain.Taiju;
import taiju.form.TaijuForm;
import taiju.repository.TaijuRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TaijuService {
    @Autowired
    private TaijuRepository taijuRepository;

    public List<Taiju> findAll(){
        List<Taiju> list = new ArrayList<Taiju>();
        for(Taiju taiju : taijuRepository.findAll()){
            list.add(taiju);
        }
        return list;
    }

    public void save(TaijuForm taijuForm){
        Taiju taiju = new Taiju();
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
            Date date = format.parse(taijuForm.getRecordedAt());
            taiju.setRecordedAt(date.getTime());
//            taiju.setRecordedAt(new SimpleDateFormat().parse(taijuForm.getRecordedAt()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        taiju.setWeight(Integer.parseInt(taijuForm.getWeight()));
        taijuRepository.save(taiju);
    }
}
