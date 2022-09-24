/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package managedBean;

import entity.Propertyimagemaster;
import entity.Propertymaster;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import sessionBean.propertyRentalSessionBeanLocal;

/**
 *
 * @author Admin
 */
@Named(value = "propertyImageBean")
@ApplicationScoped
public class propertyImageManagedBean {

    @EJB
    private propertyRentalSessionBeanLocal propertyRentalSessionBean;

    /**
     * Creates a new instance of propertyImageManagedBean
     */
    public propertyImageManagedBean() {
    }
    
    int propertyImageIDPK, propertyIDFK;
    String grfile;
    Part file, filelist;
    List<Propertymaster> propertyList;
    Propertyimagemaster propertyImage = new Propertyimagemaster();

    @PostConstruct
    public void init() {
        propertyList = propertyRentalSessionBean.showProperty();
        propertyImageIDPK = 0;
    }
    
    public int getPropertyImageIDPK() {
        return propertyImageIDPK;
    }

    public void setPropertyImageIDPK(int propertyImageIDPK) {
        this.propertyImageIDPK = propertyImageIDPK;
    }

    public int getPropertyIDFK() {
        return propertyIDFK;
    }

    public void setPropertyIDFK(int propertyIDFK) {
        this.propertyIDFK = propertyIDFK;
    }

    public String getGrfile() {
        return grfile;
    }

    public void setGrfile(String grfile) {
        this.grfile = grfile;
    }

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }
    
    public void addPropertyFK(int id){
        propertyIDFK=id;
    }

    public List<Propertymaster> getPropertyList() {
        return propertyList;
    }

    public void setPropertyList(List<Propertymaster> propertyList) {
        this.propertyList = propertyList;
    }
    
    public List<Propertymaster> show_propertyList()
    {
        try {
            return propertyRentalSessionBean.showProperty();
        } catch (Exception e) {
            return null;
        }
    }

    public Part getFilelist() {
        return filelist;
    }

    public void setFilelist(Part filelist) {
        this.filelist = filelist;
    }
    
    public List<Propertyimagemaster> show_propertyImageList()
    {
        try {
            return propertyRentalSessionBean.findByPropertyimg(propertyIDFK);
        } catch (Exception e) {
            return null;
        }
    }
    
    public List<Propertyimagemaster> show_propertyImages(int propertyIDPK)
    {
        try {
            return propertyRentalSessionBean.findByPropertyimg(propertyIDPK);
        } catch (Exception e) {
            return null;
        }
    }
    
    public static Collection<Part> getAllParts(Part part) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        return request.getParts().stream().filter(p -> part.getName().equals(p.getName())).collect(Collectors.toList());
    }
    
    public String insertPropertyImage_click() {
        try {
            for (Part part : getAllParts(filelist)) {
                InputStream input = part.getInputStream();
            String path = "D:\\SEM_8_PROJECT\\Project\\propertyRental\\propertyRental-war\\web\\uploads";
            Random random = new Random();
            StringBuilder sb = new StringBuilder();
            
            sb.append(random.nextInt(9) + 1);
            for (int i = 0; i < 11; i++) {
                sb.append(random.nextInt(10));
            }
            String temp = sb.toString();
            
            grfile = "IMG_" + temp + part.getSubmittedFileName();
            Files.copy(input, new File(path, grfile).toPath());
                System.out.println("managedBean.propertyImageManagedBean.insertPropertyImage_click()"+ propertyIDFK);
            propertyImage.setPropertyImageIDPK(0);
            Propertymaster property = propertyRentalSessionBean.searchProperty(propertyIDFK);
            propertyImage.setPropertyImage(grfile);
            propertyImage.setPropertyIDFK(property);
            propertyImage.setIsActive(Short.valueOf("1"));
            propertyRentalSessionBean.insertPropertyImage(propertyImage);
//            clear();
//            
            }
            return "/admin/propertyImage.xhtml?faces-redirect=true";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public String updatePropertyImage_click() {
        try {
            if (file != null) {
                InputStream input = file.getInputStream();
                String path = "D:\\SEM_8_PROJECT\\Project\\propertyRental\\propertyRental-war\\web\\uploads";
                Random random = new Random();
                StringBuilder sb = new StringBuilder();
                
                sb.append(random.nextInt(9) + 1);
                for (int i = 0; i < 11; i++) {
                    sb.append(random.nextInt(10));
                }
                String temp = sb.toString();
                
                grfile = "IMG_" + temp + file.getSubmittedFileName();
                Files.copy(input, new File(path, grfile).toPath());
            }
            
            
            propertyImage.setPropertyImageIDPK(propertyImageIDPK);
            Propertymaster property = propertyRentalSessionBean.searchProperty(propertyIDFK);
            propertyImage.setPropertyImage(grfile);
            propertyImage.setPropertyIDFK(property);
            propertyRentalSessionBean.updatePropertyImage(propertyImage);
            clear();
            return "/admin/showPropertyImage.xhtml?faces-redirect=true";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public String deletePropertyImage_click(int propertyImageIDPK) {
        try {
            propertyRentalSessionBean.deletePropertyImage(propertyImageIDPK);
            return "/admin/propertyImage.xhtml?faces-redirect=true";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public String searchPropertyImage_click(int id) {
        try {
            propertyImage = propertyRentalSessionBean.searchPropertyImage(id);
            propertyImageIDPK = propertyImage.getPropertyImageIDPK();
            grfile = propertyImage.getPropertyImage();
            propertyIDFK = propertyImage.getPropertyIDFK().getPropertyIDPK();
            return "/admin/propertyImage.xhtml?faces-redirect=true";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public void clear(){
//        propertyImageIDPK = 0;
//        propertyIDFK = 0;
        grfile = "";
    }
}
