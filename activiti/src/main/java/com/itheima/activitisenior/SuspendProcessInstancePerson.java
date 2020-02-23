package com.itheima.activitisenior;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;

/**
 *  单个流程实例挂起与激活
 *
 *
 */
public class SuspendProcessInstancePerson {


    public static void main(String[] args) {
        //1.得到ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        //2.得到RuntimeService
        RuntimeService runtimeService = processEngine.getRuntimeService();

        //3.查询流程实例对象
        ProcessInstance processInstance = runtimeService.createProcessInstanceQuery()
                .processInstanceId("27501").singleResult();

        //4.得到当前流程定义的实例是否都为暂停状态
        boolean suspended = processInstance.isSuspended();
        // processInstanceId 流程实例
        String processInstanceId = processInstance.getId();
        //5.判断
        if(suspended){
            //说明是暂停，就可以激活操作
            runtimeService.activateProcessInstanceById(processInstanceId);
            System.out.println("流程："+processInstanceId+"激活");
        }else{
            runtimeService.suspendProcessInstanceById(processInstanceId);
            System.out.println("流程定义："+processInstanceId+"挂起");
        }

    }
}
