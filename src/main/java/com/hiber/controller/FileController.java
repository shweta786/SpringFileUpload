/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hiber.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author SHWETA
 */
@Controller
public class FileController {

    @RequestMapping(value = "savefile", method = RequestMethod.POST)
    public ModelAndView saveimage(@RequestParam CommonsMultipartFile file,
            HttpSession session) throws Exception {

        //ServletContext context = session.getServletContext();
        String path = "C:/Users/SHWETA/Documents";
        String filename = file.getOriginalFilename();
        try {
        byte[] bytes = file.getBytes();
        BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(
                new File(path + File.separator + filename)));
        stream.write(bytes);
        stream.flush();
        stream.close();
        return new ModelAndView("index","filesuccess","File successfully saved!");
        } catch(FileNotFoundException ex) {
            return new ModelAndView("index","filesuccess","File cannot be empty");
        }
    }
}
