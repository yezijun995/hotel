package edu.fdzc.hotel.web.controller.hotel;

import edu.fdzc.hotel.common.constant.HttpStatus;
import edu.fdzc.hotel.common.core.domain.AjaxResult;
import edu.fdzc.hotel.wineshop.domain.HotelRoomType;
import edu.fdzc.hotel.wineshop.service.IHotelRoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

/**
 * @author yezj
 * @date 2021/3/20 17:43
 */
@RestController
@RequestMapping("/api/hotel/roomType")
public class RoomTypeController {

    @Autowired
    private IHotelRoomTypeService hotelRoomTypeService;

    @GetMapping("/subscribe/hotel/{hotelId}")
    public AjaxResult getBookableRoomTypeByHotelId(@PathVariable("hotelId") Long hotelId) {
        if (Objects.isNull(hotelId)) {
            return AjaxResult.error(HttpStatus.BAD_REQUEST, "参数为空");
        }
        List<HotelRoomType> list = hotelRoomTypeService.getBookableRoomTypeByHotelId(hotelId);
        return AjaxResult.success(list);
    }

    @GetMapping("/{typeId}")
    public AjaxResult getRoomTypeById(@PathVariable("typeId") Long typeId){
        if (Objects.isNull(typeId)) {
            return AjaxResult.error(HttpStatus.BAD_REQUEST, "参数为空");
        }
        HotelRoomType hotelRoomType = hotelRoomTypeService.selectHotelRoomTypeById(typeId);
        return AjaxResult.success(hotelRoomType);
    }
}
