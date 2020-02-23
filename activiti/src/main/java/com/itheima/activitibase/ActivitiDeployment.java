package com.itheima.activitibase;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;

import java.io.InputStream;
import java.util.zip.ZipInputStream;

/**
 * @Author: chenlj
 * @CreateTime: 2020-02-20 13:25
 * @Description: 自定义流程的的部署
 *   流程定义的部署
 *   activiti表有哪些？
 *   act_re_deployment  部署信息
 *   act_re_procdef     流程定义的一些信息
 *   act_ge_bytearray   流程定义的bpmn文件及png文件
 */
public class ActivitiDeployment {

    // 如果执行报错,install一下(可能会加载不到资源)
    public static void main(String[] args) {
        //1. 创建ProcessEngine对象    条件：1.activiti配置文件名称：activiti.cfg.xml   2.bean的id="processEngineConfiguration"
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        //2. 得到RepositoryService实例
        RepositoryService repositoryService = processEngine.getRepositoryService();
        //3. 进行部署
        Deployment deployment = repositoryService.createDeployment().addClasspathResource("diagram/study.bpmn")
                .addClasspathResource("diagram/study.png")
                .name("学习流程")
                .deploy();
        //4. 输出部署的一些信息
        System.out.println(deployment.getName());
        System.out.println(deployment.getId());
    }


    //流程定义部署  流程制作出来后要上传到服务器 zip文件更便于上传
    public static void mainZip(String[] args) {
        //1.创建ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        //2.得到RepositoryService实例
        RepositoryService repositoryService = processEngine.getRepositoryService();

        //3.转化出ZipInputStream流对象
        InputStream is = ActivitiDeployment.class.getClassLoader().getResourceAsStream("diagram/holidayBPMN.zip");

        //将 inputstream流转化为ZipInputStream流
        ZipInputStream zipInputStream = new ZipInputStream(is);

        //3.进行部署
        Deployment deployment = repositoryService.createDeployment()
                .addZipInputStream(zipInputStream)
                .name("请假申请单流程")
                .deploy();

        //4.输出部署的一些信息
        System.out.println(deployment.getName());
        System.out.println(deployment.getId());
    }

}
