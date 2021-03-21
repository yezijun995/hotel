package edu.fdzc.hotel.web.controller.hotel;

import edu.fdzc.hotel.wineshop.service.IHotelRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yezj
 * @date 2021/3/20 17:00
 */
@RestController
@RequestMapping("/api/hotel/room")
public class RoomController {

    @Autowired
    private IHotelRoomService hotelRoomService;
}
