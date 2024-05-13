package vn.devpro.ntd_project.controller.backend;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.devpro.ntd_project.controller.BaseController;
import vn.devpro.ntd_project.dto.DuntoConstants;
import vn.devpro.ntd_project.model.SaleOrder;
import vn.devpro.ntd_project.service.SaleOrderService;



@Controller
public class AdminOrderController extends BaseController implements DuntoConstants {

    @Autowired
    private SaleOrderService saleOrderService;

    @RequestMapping(value = "/admin/order-list", method = RequestMethod.GET)
    public String orderList(final Model model) throws IOException {

//        int status = 2;
//        if (!StringUtils.isEmpty(request.getParameter("status"))) {
//            status = Integer.parseInt(request.getParameter("status"));
//        }
//
//        String beginDate = null;
//        String endDate = null;
//        if (!StringUtils.isEmpty(request.getParameter("beginDate")) &&
//                !StringUtils.isEmpty(request.getParameter("endDate"))) {
//            beginDate = request.getParameter("beginDate");
//            endDate = request.getParameter("endDate");
//        }
//
//        SearchModel saleOrderSearch = new SearchModel();
//        saleOrderSearch.setStatus(status);
//        saleOrderSearch.setKeyword(request.getParameter("keyword"));
//        saleOrderSearch.setBeginDate(beginDate);
//        saleOrderSearch.setEndDate(endDate);
//
//        //Phan trang
//        saleOrderSearch.setSizeOfPage(SIZE_OF_PAGE);
//        saleOrderSearch.setTotalItems(saleOrderService.findAll().size());
//        int currentPage = 1;
//        if (!StringUtils.isEmpty(request.getParameter("page"))) {
//            currentPage = Integer.parseInt(request.getParameter("page"));
//        }
//        saleOrderSearch.setCurrentPage(currentPage);
//        //Het phan trang

        
        List<SaleOrder> sale_orders = saleOrderService.findAll();
//        //List<SaleOrder> saleOrders = saleOrderService.search(saleOrderSearch);
//
//        BigDecimal totalSales = BigDecimal.ZERO;
//        for (SaleOrder saleOrder : saleOrders) {
//            totalSales = totalSales.add(saleOrder.getTotal());
//        }
//
        model.addAttribute("sale_orders", sale_orders);
//        model.addAttribute("totalSales", totalSales);
//        model.addAttribute("saleOrderSearch", saleOrderSearch);

        return "backend/order-list";
    }
}

