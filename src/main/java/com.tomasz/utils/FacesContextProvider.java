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

}
