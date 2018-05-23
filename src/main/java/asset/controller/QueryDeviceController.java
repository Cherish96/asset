package asset.controller;

import asset.pojo.DeviceForm;
import asset.service.IDeviceService;
import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: QuincySu
 * @Date: 2018/4/29
 */
@Controller
@RequestMapping("/asset")
public class QueryDeviceController {
    private static Logger logger = Logger.getLogger(QueryDeviceController.class);
    @Autowired
    private IDeviceService deviceService;

    private DeviceForm deviceForm=new DeviceForm();
    private List<DeviceForm> deviceFormList=new ArrayList<>();

    @RequestMapping(value = "/queryDeviceList.form", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public @ResponseBody
    Object queryDeviceList(HttpServletRequest request, HttpServletResponse response){
        String useStatus = request.getParameter("useStatus1").trim();
        if (useStatus.equals("101")) {
            deviceFormList = deviceService.getDeviceList1();
            // System.out.println(deviceFormList.get(1).toString());
            //        if (useStatus.equals("101")) {
        } else {
            deviceFormList = deviceService.getDeviceLists(useStatus);
            //System.out.println(deviceFormList.get(1).toString());

        }
        return JSON.toJSONString(deviceFormList);
        //把对象转换为相应字符串
    }
}
