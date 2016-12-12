/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.entities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Blob;



/**
 *
 * @author 2107803
 */
public class Image {
    private byte[] img;
    private String name;

    public Image(byte[] img, String name){
        this.img=img;
        this.name=name;
    }
    
    @Override
    public String toString() {
        return "Image{" + "img=" + img + ", name=" + name + '}';
    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}