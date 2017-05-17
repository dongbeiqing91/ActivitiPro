package com.clic.controller;

import org.activiti.engine.FormService;
import org.activiti.engine.HistoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by DBQ on 2017/1/16.
 */
@Component
public class test123 {

    @Autowired
    RuntimeService runtimeService;

    @Autowired
    TaskService taskService;

    @Autowired
    HistoryService historyService;

    @Autowired
    FormService formService;

    public void test(){
        runtimeService.createProcessInstanceQuery().processDefinitionId("").list();
        historyService.createHistoricTaskInstanceQuery().taskAssignee("").finished().list();


        String parentTaskId = taskService.createTaskQuery().singleResult().getParentTaskId();
        formService.getTaskFormData(parentTaskId).getFormProperties();

        ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processDefinitionId("").singleResult();


        taskService.createTaskQuery().singleResult().getCreateTime();


        historyService.createHistoricProcessInstanceQuery().unfinished().singleResult().getDurationInMillis();


    }
}
