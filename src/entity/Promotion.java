/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author ASUS
 */
public class Promotion {
     public String id;
    public String name;
    public String promotionType;
    public String promotionDesc;

    public Promotion() {
    }
    
    
    public Promotion(String id,String name,String promotionType, String promotionDesc){
        this.id = id;
        this.name = name;
        this.promotionType = promotionType;
        this.promotionDesc = promotionDesc;
        
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPromotionType() {
        return promotionType;
    }

    public void setPromotionType(String promotionType) {
        this.promotionType = promotionType;
    }

    public String getPromotionDesc() {
        return promotionDesc;
    }

    public void setPromotionDesc(String promotionDesc) {
        this.promotionDesc = promotionDesc;
    }
    
    
}
