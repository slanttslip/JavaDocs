package ro.teamnet.zth.appl.controller;

import ro.teamnet.zth.api.annotations.MyController;
import ro.teamnet.zth.api.annotations.MyRequestMethod;

/**
 * Created by Adrian.Calancea on 7/14/16.
 */
@MyController(urlPath = "/jobs")
public class JobController {
    @MyRequestMethod(urlPath = "/all")
    public String getAlljobs(){
        return "All Jobs";
    }
    @MyRequestMethod(urlPath = "/1")
    public  String getOneJob(){
        return "One Random Job";
    }
}
