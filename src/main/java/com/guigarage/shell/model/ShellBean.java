package com.guigarage.shell.model;

import com.canoo.dolphin.collections.ObservableList;
import com.canoo.dolphin.mapping.DolphinBean;
import com.canoo.dolphin.mapping.Property;

@DolphinBean
public class ShellBean {

    private Property<String> commandline;

    private ObservableList<VarBean> variables;

    public Property<String> getCommandline() {
        return commandline;
    }

    public ObservableList<VarBean> getVariables() {
        return variables;
    }
}
