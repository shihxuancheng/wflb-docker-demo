package com.wanhai.apps;

import org.zkoss.bind.annotation.Command;
import org.zkoss.zk.ui.util.Clients;

public class TestVM {
    private String version = "1.0.0";


    @Command("execute")
    public void sayHello(){
        Clients.showNotification("Hello World!!!");
    }

    public String getVersion() {
        return version;
    }
}
