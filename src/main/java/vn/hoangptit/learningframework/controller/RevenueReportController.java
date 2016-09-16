package vn.hoangptit.learningframework.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * author Hoangptit
 * Date 9/12/2016
 */
@Controller
public class RevenueReportController extends AbstractController {

    @Override
    @RequestMapping(value = "exportFile", method = RequestMethod.GET)
    protected ModelAndView handleRequestInternal(HttpServletRequest request,
                                                 HttpServletResponse response) throws Exception {
        String output =
                request.getParameter("output");
        //dummy data
        Map<String, String> revenueData = new HashMap<String, String>();
        revenueData.put("1/20/2010", "$100,000");
        revenueData.put("1/21/2010", "$200,000");
        revenueData.put("1/22/2010", "$300,000");
        revenueData.put("1/23/2010", "$400,000");
        revenueData.put("1/24/2010", "$500,000");

        if (output == null || "".equals(output)) {
            //return normal view
            return new ModelAndView("RevenueSummary", "revenueData", revenueData);

        } else if ("PDF".equals(output.toUpperCase())) {
            //return excel view
            return new ModelAndView("PdfRevenueSummary", "revenueData", revenueData);

        } else if ("EXCEL".equals(output.toUpperCase())) {
            //return excel view
            return new ModelAndView("ExcelRevenueSummary", "revenueData", revenueData);

        } else {
            //return normal view
            return new ModelAndView("RevenueSummary", "revenueData", revenueData);

        }
    }
}
