package cn.nlsde.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * Created by zwj on 2017/2/16.
 */
@Controller
public class TemplateController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("index2/")
    public String index2() {
        return "index2";
    }

    @RequestMapping("/showAccuracy")
    public String showAll2d(
            @RequestParam("datasource") String datasource,
            @RequestParam(value = "type", required = false, defaultValue = "CL") String type) {
        if (datasource.equals("newsgroup")) {
            return "accuracy-" + datasource;
        }
        return String.format("accuracy-%s-%s", datasource, type);
    }

    @RequestMapping("/showdataset")
    public String showAll2d() {
        return "showdataset";
    }

    @RequestMapping("/show2d")
    public String show2d(@RequestParam("dataset") String dataset,
                         @RequestParam(name = "a_cat", required = false) String a_cat,
                         @RequestParam(name = "n_cat", required = false) String n_cat,
                         @RequestParam(value = "compareMethod", required = false) String compareMethod,
                         Map<String, Object> map) {
        map.put("dataset", dataset);
        map.put("datatype", dataset.equals("newsgroup") ? n_cat : a_cat);
        boolean d3 = (compareMethod != null && compareMethod.length() > 1);
        if (d3) {
            map.put("compareMethod", compareMethod);
        }
        return !d3 ? "showAll2d" : "showCompare2d";
    }

    @RequestMapping("/show3d")
    public String show3d(@RequestParam("dataset") String dataset,
                         @RequestParam(name = "a_cat", required = false) String a_cat,
                         @RequestParam(name = "n_cat", required = false) String n_cat,
                         @RequestParam("compareMethod") String method,
                         Map<String, Object> map) {
        map.put("dataset", dataset);
        map.put("datatype", dataset.equals("newsgroup") ? n_cat : a_cat);
        map.put("method", method);
        return "show3d";
    }
}
