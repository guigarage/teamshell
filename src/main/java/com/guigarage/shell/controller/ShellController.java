package com.guigarage.shell.controller;

import com.canoo.dolphin.BeanManager;
import com.canoo.dolphin.server.DolphinAction;
import com.canoo.dolphin.server.DolphinController;
import com.canoo.dolphin.server.DolphinModel;
import com.guigarage.shell.model.ShellBean;
import com.guigarage.shell.model.VarBean;
import com.guigarage.shell.service.ShellService;
import jdk.jshell.SnippetEvent;
import jdk.jshell.VarSnippet;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@DolphinController("ShellController")
public class ShellController {

    @DolphinModel
    private ShellBean model;

    @Autowired
    private BeanManager beanManager;

    @Autowired
    private ShellService shellService;

    @DolphinAction("eval")
    public void eval() {
        List<SnippetEvent> events = shellService.eval(model.getCommandline());
        for(SnippetEvent e : events) {
            if(e.snippet() instanceof VarSnippet) {
                VarBean varBean = beanManager.create(VarBean.class);
                varBean.setName(((VarSnippet) e.snippet()).name());
                varBean.setContent(e.value());
                varBean.setType(((VarSnippet) e.snippet()).typeName());
                model.getVariables().add(varBean);
            }
        }
    }


}
