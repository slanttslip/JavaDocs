package ro.teamnet.zth.appl.controller;

import ro.teamnet.zth.api.annotations.MyController;
import ro.teamnet.zth.api.annotations.MyRequestMethod;

/**
 * Created by Adrian.Calancea on 7/14/16.
 */
@MyController(urlPath = "/locations")
public class LocationController {
@MyRequestMethod(urlPath ="/all" )
    public String getAllLocation(){return "All Locations";}

    @MyRequestMethod(urlPath = "/1")
   public String getOneLocation(){
        return "One random Location";
    }

}
