package com.guigarage.shell.service;

import com.canoo.dolphin.server.spring.ClientScoped;
import jdk.jshell.JShell;
import jdk.jshell.SnippetEvent;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@ClientScoped
@Service
public class ShellService {

    private JShell shell;

    @PostConstruct
    public void init() {
        shell = JShell.builder().build();
    }

    public List<SnippetEvent> eval(String command) {
        return shell.eval(command);
    }
}
