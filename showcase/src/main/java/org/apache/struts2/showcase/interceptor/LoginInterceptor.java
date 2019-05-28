package org.apache.struts2.showcase.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.opensymphony.xwork2.interceptor.ValidationAware;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.showcase.dao.LoginDao;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

public class LoginInterceptor implements Interceptor {

    public final static String USER_HANDLE = "user_session_handle";
    public final static String LOGIN_ATTEMPT = "user_login_attempt";

    @Autowired
    private LoginDao loginDao;

    @Override
    public void destroy() {

    }

    @Override
    public void init() {

    }

    public static boolean isLoggedIn(HttpSession session) {
        return session.getAttribute(USER_HANDLE) != null;
    }

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        final ActionContext context = actionInvocation.getInvocationContext();
        HttpServletRequest request = (HttpServletRequest) context.get(ServletActionContext.HTTP_REQUEST);
        Map sessionMap = context.getSession();
        String queryString = request.getQueryString();
        sessionMap.put("savedUrl", request.getRequestURI() + (queryString == null ? "" : ("?" + queryString)));
        try {
            Object user = sessionMap.get(USER_HANDLE);
            if (user == null) {
                String loginAttempt = request.getParameter(LOGIN_ATTEMPT);
                if (!StringUtils.isBlank(loginAttempt)) {
                    if (processLoginAttempt(request, sessionMap)) {
                        return actionInvocation.invoke();
                    } else {
                        Object action = actionInvocation.getAction();

                        if (action instanceof ValidationAware) {
                            ((ValidationAware) action).addActionError("Incorrect credentials");
                        }
                    }
                }
                return requestLogin(request);
            } else {
                return actionInvocation.invoke();
            }
        } catch (Exception exception) {
            return requestLogin(request);
        }
    }

    private String requestLogin(HttpServletRequest request) {
        request.setAttribute("pageTitle", "Please Login");
        return "login";
    }

    public boolean processLoginAttempt(HttpServletRequest request, Map session) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Object user = loginDao.getByUsernameAndPassword(username, password);

        if (user == null) {
            return false;
        } else {
            session.put(USER_HANDLE, user);
            request.getSession(true).setAttribute(USER_HANDLE, user);
            return true;
        }
    }
}
