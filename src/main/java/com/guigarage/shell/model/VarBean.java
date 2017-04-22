package com.guigarage.shell.model;

import com.canoo.dolphin.mapping.DolphinBean;
import com.canoo.dolphin.mapping.Property;

@DolphinBean
public class VarBean {

    private Property<String> name;

    private Property<String> content;

    private Property<String> type;

    public Property<String> getName() {
        return name;
    }

    public Property<String> getContent() {
        return content;
    }

    public Property<String> getType() {
        return type;
    }
}
