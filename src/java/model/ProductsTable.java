/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author jiapat
 */
public class ProductsTable {
    public static List<Products> findAllProducts() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("OnlineShoppingPU");
        EntityManager em = emf.createEntityManager();
        List<Products> productsList = null;
        try {
            productsList = (List<Products>) em.createNamedQuery("Products.findAll").getResultList();         
        } catch (Exception e) {
            throw new RuntimeException(e);
            
        }
        finally {
            em.close();
            emf.close();
        }
        return productsList;
    }
    
    public static Products findProductsById(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("OnlineShoppingPU");
        EntityManager em = emf.createEntityManager();
        Products products = null;
        try {
            products = em.find(Products.class, id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally {
            em.close();
            //emf.close();
        }
        return products;
    }
    
    public static int updateProducts(Products products) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("OnlineShoppingPU");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Products target = em.find(Products.class, products.getId());
            if (target == null) {
                return 0;
            }
            target.setMovie(products.getMovie());
            target.setRating(products.getRating());
            target.setYearcreate(products.getYearcreate());
            target.setPrice(products.getPrice());
            target.setShoppingcartId(products.getShoppingcartId());
            em.persist(target);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            
        }
        finally {
            em.close();
            emf.close();
        }
        return 1;
    }
    
    public static int removeProducts(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("OnlineShoppingPU");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Products target = em.find(Products.class, id);
            if (target == null) {
                return 0;
            }
            em.remove(target);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            
        }
        finally {
            em.close();
            emf.close();
        }
        return 1;
    }
    
    public static int insertProducts(Products products) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("OnlineShoppingPU");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Products target = em.find(Products.class, products.getId());
            if (target != null) {
                return 0;
            }
            em.persist(products);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            
        }
        finally {
            em.close();
            emf.close();
        }
        return 1;
    }
}
