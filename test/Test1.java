/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.xml.sax.SAXException;
import yasearchtypes.HotelInfo;
import yasearchtypes.Result;

/**
 *
 * @author margarita
 */
public class Test1 {
    
    public Test1() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
    public void hello() {
        
        String user = "queen-margo95";
        String key = "03.168511801:b7e7d5c0b8f54ca18ae7cf2f9895e166";
        String query = "Ghazala Gardens 4* Шарм-эль-Шейх";
        
        Result result = new Result(user, key);
        result.setHotels(null);
        List<HotelInfo> al = result.getContent();
    
    }
}
