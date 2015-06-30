package com.ninja_squad.geektic.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import com.ninja_squad.geektic.control.GeekCtrl;

import javax.transaction.Transactional;

import static org.springframework.web.bind.annotation.RequestMethod.*;
import entity.Geek;


@RestController
@Transactional
@RequestMapping("/api/geek")
public class GeekService {
	
	@Autowired
	GeekCtrl gctrl;
    @RequestMapping(method = GET)
    public List<Geek> getGeeks() {
        return gctrl.getGeeks();
    }
}