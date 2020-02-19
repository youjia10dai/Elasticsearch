package com.itheima.test;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.junit.Test;

/**
 * @Author: chenlj
 * @CreateTime: 2020-02-19 14:10
 * @Description: 第一步,测试25表生成
 */
public class ActivitiTest {

    /**
     * 都使用默认值的方式,推荐使用这个
     * 创建所需要的25张表
     */
    @Test
    public void testGenTable1() {
        //条件：1.activiti配置文件名称：activiti.cfg.xml   2.bean的id="processEngineConfiguration"
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        System.out.println(processEngine);

        // HistoryService historyService = processEngine.getHistoryService();
    }

    /**
     * 需要进行参数的配置(不推荐)
     * 创建所需要的25张表
     */
    @Test
    public void testGenTable2() {
        //1.创建ProcessEngineConfiguration对象  第一个参数:配置文件名称  第二个参数是processEngineConfiguration的bean的id
        ProcessEngineConfiguration configuration = ProcessEngineConfiguration
                .createProcessEngineConfigurationFromResource("activiti.cfg.xml");
        //2.创建ProcesEngine对象
        ProcessEngine processEngine = configuration.buildProcessEngine();

        //3.输出processEngine对象
        System.out.println(processEngine);

    }
}
