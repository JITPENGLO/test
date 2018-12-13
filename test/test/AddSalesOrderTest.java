/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import test.orderList;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class AddSalesOrderTest {
        String ID1 = "OR0001";
    
    public AddSalesOrderTest() {
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of OrderListt method, of class AddSalesOrder.
     */
    @Test
    public void testOrderListt() {
        System.out.println("OrderListt");
        AddSalesOrder instance = new AddSalesOrder();
        orderList order = new orderList("OR0001", "Hello", "12/12/2018", "2:00 PM", 5, 23.5);
        //ArrayList expResult = null;
        ArrayList<orderList> result = instance.OrderListt();
        result.add(order);
        assertEquals(ID1, result.get(0).id);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of StoreTable method, of class AddSalesOrder.
     */
    @Test
    public void testStoreTable() {
        System.out.println("StoreTable");
        AddSalesOrder instance = new AddSalesOrder();
        instance.StoreTable();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class AddSalesOrder.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        AddSalesOrder.main(args);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
