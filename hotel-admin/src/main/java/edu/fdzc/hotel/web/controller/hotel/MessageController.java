package edu.fdzc.hotel.web.controller.hotel;

import edu.fdzc.hotel.common.core.domain.AjaxResult;
import edu.fdzc.hotel.wineshop.domain.HotelMessage;
import edu.fdzc.hotel.wineshop.service.IHotelMessageService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author yezj
 * @date 2021/5/2 3:07
 */
@RestController
@RequestMapping("/api/hotel/message")
public class MessageController {

    @Resource
    private IHotelMessageService hotelMessageService;

    @GetMapping("/info/{hotelId}")
    public AjaxResult info(@PathVariable("hotelId") Long hotelId)
    {
        return AjaxResult.success(hotelMessageService.selectHotelMessageInfo(hotelId));
    }

    @PostMapping
    public AjaxResult add(@RequestBody HotelMessage hotelMessage)
    {
        return toAjax(hotelMessageService.insertHotelMessage(hotelMessage));
    }

    /**
     * 响应返回结果
     *
     * @param rows 影响行数
     * @return 操作结果
     */
    protected AjaxResult toAjax(int rows)
    {
        return rows > 0 ? AjaxResult.success() : AjaxResult.error();
    }
}
