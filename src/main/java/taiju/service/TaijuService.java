package taiju.service;

import org.springframework.stereotype.Service;
import taiju.domain.Taiju;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaijuService {
    public List<Taiju> findAll(){
        List<Taiju> list = new ArrayList<Taiju>();
        list.add(new Taiju(2,52));
        list.add(new Taiju(3,53));
        list.add(new Taiju(4,54));
        list.add(new Taiju(5,5));
        list.add(new Taiju(6,56));
        list.add(new Taiju(7,58));
        list.add(new Taiju(20150403,50));
        return list;
    }
}
