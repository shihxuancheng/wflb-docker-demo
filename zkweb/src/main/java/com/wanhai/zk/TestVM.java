package com.wanhai.zk;

import org.zkoss.Version;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.util.Clients;

import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.net.InetAddress;

/**
 * Created by shihxuancheng on 2017/12/6.
 */
public class TestVM implements Serializable {
    @Init
    public void init() {
    }

    @AfterCompose
    public void afterCompose() {
    }

    public String getServerIP() {
//        HttpServletRequest request = (HttpServletRequest)Executions.getCurrent().getNativeRequest();
        try {
//            return Executions.getCurrent().getLocalAddr();
            return InetAddress.getLocalHost().getHostAddress();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getHostName() {
        try {
//            return Executions.getCurrent().getServerName();
            return InetAddress.getLocalHost().getCanonicalHostName();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getSessionId() {
        return ((HttpSession) Executions.getCurrent().getSession().getNativeSession()).getId();
    }

    public String getGuestName() {
        return String.valueOf(Sessions.getCurrent().getAttribute("user"));
    }

    public void setGuestName(String guestName) {
        Sessions.getCurrent(true).setAttribute("user",guestName);
    }

    @Command("test")
    public void onTest() {
        try {
            StringBuilder strMsg = new StringBuilder();
            strMsg.append("Requset handled by: ")
                    .append(InetAddress.getLocalHost().getCanonicalHostName() + "/" + InetAddress.getLocalHost().getHostAddress())
                    .append("\n")
                    .append("SessionId: ")
                    .append(((HttpSession) Executions.getCurrent().getSession().getNativeSession()).getId());
            Clients.showNotification(strMsg.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
