package taiju.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import taiju.domain.Taiju;
import taiju.repository.TaijuRepository;

import java.util.ArrayList;
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
}
