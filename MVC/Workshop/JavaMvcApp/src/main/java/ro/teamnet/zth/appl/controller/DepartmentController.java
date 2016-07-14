package ro.teamnet.zth.appl.controller;

import ro.teamnet.zth.api.annotations.MyController;
import ro.teamnet.zth.api.annotations.MyRequestMethod;

/**
 * Created by Adrian.Calancea on 7/14/16.
 */
@MyController(urlPath="/departments")
public class DepartmentController {

    @MyRequestMethod(urlPath = "/all")
    public String getAllDepartments() {
        return "allDepartments";
    }

    @MyRequestMethod(urlPath = "/1")
    public String getOneDepartment() {
        return "oneRandomDepartment";
    }

}
