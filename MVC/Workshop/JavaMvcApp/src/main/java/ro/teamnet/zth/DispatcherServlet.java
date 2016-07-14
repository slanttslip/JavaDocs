package ro.teamnet.zth;

import ro.teamnet.zth.api.annotations.MyController;
import ro.teamnet.zth.api.annotations.MyRequestMethod;
import ro.teamnet.zth.fmk.AnnotationScanUtils;
import ro.teamnet.zth.fmk.MethodAttributes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;


/**
 * Created by Adrian.Calancea on 7/14/16.
 */
public class DispatcherServlet extends HttpServlet {
    //registru
    HashMap<String,MethodAttributes> allowedMethods=new HashMap<>();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        dispatchReply("POST", req, resp);
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        dispatchReply("GET", req, resp);
    }

    public void dispatchReply(String identificator, HttpServletRequest req, HttpServletResponse resp) {
        Object result = null;
        try {

            result = dispatch(req, resp);
        } catch (Exception e) {
            sendExeptipn(e, req, resp);
        }

        try {
            reply(result, req, resp);
        } catch (IOException e) {
            sendExeptipn(e, req, resp);
        }
    }

    public Object dispatch(HttpServletRequest req, HttpServletResponse resp) {

        String path = req.getPathInfo();
       /* if (path.startsWith("/employees")) {
            EmployeeController employeeController = new EmployeeController();
            return employeeController.getAllEmployees();
        }
        else if (path.startsWith("/departments")) {
            DepartmentController departmentController = new DepartmentController();
            return departmentController.getAllDepartments();
        }
*/
       MethodAttributes methodAttributes= allowedMethods.get(path);
        if(methodAttributes ==null)
        return "Imi pare rau, dar ceva nu este ok";

        String controllername=methodAttributes.getControllerClass();
        try {
            Class<?> controllerclass = Class.forName(controllername);

                Object controlllerInstance=controllerclass.newInstance();

                    Method method=controllerclass.getMethod(methodAttributes.getMethodName());

                        Object result=method.invoke(controlllerInstance);
            return  result;
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }

                catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
             catch (InstantiationException e) {
                e.printStackTrace();}
             catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return  null;

    }

    public void sendExeptipn(Exception e, HttpServletRequest req, HttpServletResponse res) {

    }

    public void reply(Object obj, HttpServletRequest req, HttpServletResponse resp) throws IOException {

        PrintWriter printWriter = resp.getWriter();
        printWriter.printf(obj.toString());

        // resp.getWriter().write(di);

    }

    @Override
    public void init() throws ServletException {
        try {
            /**
             * Cautare clase din pachet
             */
            Iterable<Class> controllers = AnnotationScanUtils.getClasses("ro.teamnet.zth.appl.controller");
            for (Class controller : controllers) {
                if (controller.isAnnotationPresent(MyController.class)){
                    MyController myCtrlAnnotation = (MyController) controller.getAnnotation(MyController.class);

                    //am luat cheia pt hashMap
                    String controllerUrlPath = myCtrlAnnotation.urlPath();
                    Method[] controllerMethods =  controller.getMethods();

                    //acum cautam valoare, verificand daca este prezenta annotarea MyRequestMethod pe met respectiva
                    for (Method controllerMethod : controllerMethods){
                        if (controllerMethod.isAnnotationPresent(MyRequestMethod.class)){
                            MyRequestMethod myRequestMethod = controllerMethod.getAnnotation(MyRequestMethod.class);

                            String methodUrlPath = myRequestMethod.urlPath();

                            //construiesc cheia pt hashMap
                            String urlPath = controllerUrlPath + methodUrlPath;

                            //creeem valoare pt hashMap
                            MethodAttributes methodAttributes=new MethodAttributes();
                            methodAttributes.setControllerClass(controller.getName());
                            methodAttributes.setMethodName(myRequestMethod.methodType());
                            methodAttributes.setMethodName(controllerMethod.getName());
                            allowedMethods.put(urlPath,methodAttributes);
                        }
                    }

                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
