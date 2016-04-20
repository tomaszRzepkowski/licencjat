package com.tomasz.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

import static org.richfaces.resource.optimizer.vfs.VFSType.file;

/**
 * @author Tomek on 18.04.2016.
 */
public class FileUtils {

    /**
     * Download file.
     */
    public static void downloadFile() throws IOException {
        File file = new File("C:\\github\\test.txt");
        prepareDownloadFile(file);
    }

    public static void downloadFile(String path) throws IOException
    {
        File file = new File(path);
        prepareDownloadFile(file);
    }

    public static void downloadFile(byte[] bytes) throws IOException
    {
        File file = new File("C:\\github\\test.txt");
        InputStream fis = new FileInputStream(file);
        int offset = 0;
        int numRead = 0;
        while ((offset < bytes.length) && ((numRead = fis.read(bytes, offset, bytes.length - offset)) >= 0))
        {
            offset += numRead;
        }
        fis.close();
        HttpServletResponse response =
                (HttpServletResponse) FacesContext.getCurrentInstance()
                        .getExternalContext().getResponse();

        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment;filename=test.txt");
        response.getOutputStream().write(bytes);
        response.getOutputStream().flush();
        response.getOutputStream().close();
        FacesContext.getCurrentInstance().responseComplete();
    }

    private static void prepareDownloadFile(File file) throws IOException {
        InputStream fis = new FileInputStream(file);
        byte[] buf = new byte[1024];
        int offset = 0;
        int numRead = 0;
        while ((offset < buf.length) && ((numRead = fis.read(buf, offset, buf.length - offset)) >= 0))
        {
            offset += numRead;
        }
        fis.close();
        HttpServletResponse response =
                (HttpServletResponse) FacesContext.getCurrentInstance()
                        .getExternalContext().getResponse();

        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment;filename=test.txt");
        response.getOutputStream().write(buf);
        response.getOutputStream().flush();
        response.getOutputStream().close();
        FacesContext.getCurrentInstance().responseComplete();
    }
}
