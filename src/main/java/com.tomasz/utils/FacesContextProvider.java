package com.tomasz.utils;

import java.util.Map;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 * @author Tomek on 17.04.2016.
 */
public class FacesContextProvider {

    public static FacesContext getFacesContext() {
        return FacesContext.getCurrentInstance();
    }

    public static ExternalContext getExternalContext() {
        return FacesContext.getCurrentInstance().getExternalContext();
    }

    public static Map<String, Object> getSessionAttributes() {
        return FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
    }

    public static Map<String, Object> getApplicationAttributes() {
        return FacesContext.getCurrentInstance().getExternalContext().getApplicationMap();
    }

    public static Map<String, Object> getRequestAttributes() {
        return FacesContext.getCurrentInstance().getExternalContext().getRequestMap();
    }

    public static void putSessionParameter(String name, Object object) {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(name, object);
    }

    public static void removeSessionParameter(String name) {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove(name);
    }

    public static Object getSessionParameter(String name) {
        return FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(name);
    }

    public static boolean isSessionContainsKey(String name) {
        return FacesContext.getCurrentInstance().getExternalContext().getSessionMap().containsKey(name);
    }

    public static boolean isSessionContainsValue(Object object) {
        return FacesContext.getCurrentInstance().getExternalContext().getSessionMap().containsValue(object);
    }

}
