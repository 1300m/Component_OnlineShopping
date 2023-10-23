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
public class ShoppingcartTable {
    public static List<Shoppingcart> findAllShoppingcart() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("OnlineShoppingPU");
        EntityManager em = emf.createEntityManager();
        List<Shoppingcart> cartList = null;
        try {
            cartList = (List<Shoppingcart>) em.createNamedQuery("Shoppingcart.findAll").getResultList();         
        } catch (Exception e) {
            throw new RuntimeException(e);
            
        }
        finally {
            em.close();
            emf.close();
        }
        return cartList;
    }
    
    public static Shoppingcart findShoppingcartById(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("OnlineShoppingPU");
        EntityManager em = emf.createEntityManager();
        Shoppingcart cart = null;
        try {
            cart = em.find(Shoppingcart.class, id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally {
            em.close();
            //emf.close();
        }
        return cart;
    }
    
    public static int updateShoppingcart(Shoppingcart cart) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("OnlineShoppingPU");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Shoppingcart target = em.find(Shoppingcart.class, cart.getId());
            if (target == null) {
                return 0;
            }
            target.setQuantity(cart.getQuantity());
            target.setProducts(cart.getProducts());
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
    
    public static int removeShoppingcart(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("OnlineShoppingPU");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Shoppingcart target = em.find(Shoppingcart.class, id);
            if (target == null) {
                em.getTransaction().commit();
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
    
    public static int removeAllShoppingcart() {
        List<Shoppingcart> cartList = findAllShoppingcart();
        if(cartList != null) {
            for(Shoppingcart cart : cartList) {
                removeShoppingcart(cart.getId());
            }
            return 1;
        }
        return 0;
    }
    
    public static int insertShoppingcart(Shoppingcart cart) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("OnlineShoppingPU");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Shoppingcart target = em.find(Shoppingcart.class, cart.getId());
            if (target != null) {
                return 0;
            }
            em.persist(cart);
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
