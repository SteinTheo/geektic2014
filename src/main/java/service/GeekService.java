package service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

import static org.springframework.web.bind.annotation.RequestMethod.*;
import entity.Geek;
import control.GeekCtrl;


@RestController
@Transactional
@RequestMapping("/api/geek")
public class GeekService {
    @RequestMapping(method = GET)
    public List<Geek> getGeeks() {
        return GeekCtrl.getGeeks();
    }
}