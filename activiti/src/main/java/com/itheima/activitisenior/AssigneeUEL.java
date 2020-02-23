package com.itheima.activitisenior;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;

import java.util.HashMap;
import java.util.Map;

/**
 *  启动流程实例，动态设置assignee
 */
public class AssigneeUEL {


    public static void main(String[] args) {
        //1.得到ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        //2.得到RuntimeService对象
        RuntimeService runtimeService = processEngine.getRuntimeService();

       //3.设置assignee的取值   用户可以在界面上设置流程的执行人
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("student","student");
        map.put("teacher","teacher");

        //4.启动流程实例，同时还要设置流程定义的assignee的值
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("study", map);

        //5.输出
        System.out.println(processEngine.getName());

    }
}
