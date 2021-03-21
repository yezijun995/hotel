package edu.fdzc.hotel.web.controller.hotel;

import edu.fdzc.hotel.common.core.domain.AjaxResult;
import edu.fdzc.hotel.wineshop.domain.HotelWineshop;
import edu.fdzc.hotel.wineshop.service.IHotelWineshopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yezj
 * @date 2021/3/17 23:06
 */
@RestController
@RequestMapping("/api/hotel/wineshop")
public class WineshopController {

    @Autowired
    private IHotelWineshopService hotelWineshopService;

    @GetMapping("/list")
    public AjaxResult list(HotelWineshop hotelWineshop) {
        List<HotelWineshop> list = hotelWineshopService.selectHotelWineshopList(hotelWineshop);
        return AjaxResult.success(list);
    }

    @GetMapping(value = "/{hotelId}")
    public AjaxResult getInfo(@PathVariable("hotelId") Long hotelId) {
        return AjaxResult.success(hotelWineshopService.selectHotelWineshopById(hotelId));
    }
}
