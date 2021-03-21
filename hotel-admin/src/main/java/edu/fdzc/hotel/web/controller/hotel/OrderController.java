package edu.fdzc.hotel.web.controller.hotel;

import edu.fdzc.hotel.common.constant.HttpStatus;
import edu.fdzc.hotel.common.core.domain.AjaxResult;
import edu.fdzc.hotel.common.core.domain.entity.SysAccount;
import edu.fdzc.hotel.common.core.domain.entity.SysUser;
import edu.fdzc.hotel.common.utils.SecurityUtils;
import edu.fdzc.hotel.system.service.ISysAccountService;
import edu.fdzc.hotel.system.service.ISysUserService;
import edu.fdzc.hotel.wineshop.domain.HotelOrders;
import edu.fdzc.hotel.wineshop.domain.vo.PayOrdersVO;
import edu.fdzc.hotel.wineshop.service.IHotelOrdersService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * @author yezj
 * @date 2021/3/20 20:25
 */
@RestController
@RequestMapping("/api/hotel/order")
public class OrderController {

    @Resource
    private IHotelOrdersService hotelOrdersService;

    @Resource
    private ISysAccountService accountService;

    @Resource
    private ISysUserService userService;

    @PostMapping(value = "/add")
    public AjaxResult addOrder(@RequestBody HotelOrders hotelOrders) {
        return toAjax(hotelOrdersService.insertHotelOrders(hotelOrders));
    }

    @GetMapping(value = "/{userId}")
    public AjaxResult getAllOrderByUser(@PathVariable("userId") Long userId) {
        if (Objects.isNull(userId)) {
            return AjaxResult.error(HttpStatus.BAD_REQUEST, "参数为空");
        }
        List<HotelOrders> allByUser = hotelOrdersService.getAllOrderByUser(userId);
        return AjaxResult.success(allByUser);
    }

    @GetMapping(value = "/order/{orderId}")
    public AjaxResult getOrderByOrderId(@PathVariable("orderId") Long orderId) {
        if (Objects.isNull(orderId)) {
            return AjaxResult.error(HttpStatus.BAD_REQUEST, "参数为空");
        }
        HotelOrders hotelOrders = hotelOrdersService.selectHotelOrdersById(orderId);
        return AjaxResult.success(hotelOrders);
    }

    /**
     * 订单付款
     *
     * @return
     */
    @PostMapping(value = "/pay")
    public AjaxResult payOrder(@RequestBody @Validated PayOrdersVO payOrdersVO) {
        SysAccount account = accountService.selectAccountByAccountName(payOrdersVO.getUsername());
        if (Objects.nonNull(account)) {
            if (!SecurityUtils.matchesPassword(payOrdersVO.getPassword(), account.getPassword())) {
                return AjaxResult.error(HttpStatus.ERROR, "密码错误");
            }
        }
        SysUser user = userService.selectUserByUserName(payOrdersVO.getUsername());
        if (!SecurityUtils.matchesPassword(payOrdersVO.getPassword(), user.getPassword())) {
            return AjaxResult.error(HttpStatus.ERROR, "密码错误");
        }
        if (Objects.equals(hotelOrdersService.payOrder(payOrdersVO.getOrderId()), 1)) {
            return AjaxResult.success();
        }
        return AjaxResult.error("支付失败");
    }

    @DeleteMapping(value = "/cancel/{orderId}")
    public AjaxResult cancelOrder(@PathVariable("orderId") Long orderId) {
        if (Objects.equals(hotelOrdersService.cancelOrder(orderId), 1)) {
            return AjaxResult.success();
        }
        return AjaxResult.error("取消失败");
    }

    /**
     * 响应返回结果
     *
     * @param rows 影响行数
     * @return 操作结果
     */
    protected AjaxResult toAjax(int rows) {
        return rows > 0 ? AjaxResult.success() : AjaxResult.error();
    }
}
