/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.hib.mod250.stocks;

import java.util.ArrayList;
import java.util.List;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;

/**
 *
 * @author Anders
 */
public class StockTestGenerator {
    
    /*
        1. All changed
        2. 2 changes
        3. No change
        4. No change
        5. 2 changes
        6. No change
        7. No change
        8. No change
        9. All changed
        10. No change
        11. No change
        12. 1 change
        13. No change
        14. No change
        15. All changed
        16. 2 changes
        17. No change
        18. 2 changes
        19. No change
        20. All changed
    */
    private final List<Stock> data;
    
    public StockTestGenerator() {
        data = new ArrayList<>();
        Stock base;
        
        // 0
        base = new Stock();
        base.setChange(1.37);
        base.setChangePercent(3.47);
        base.setDayHigh(1000);
        base.setDayLow(500);
        base.setName("TESTSTOCK");
        base.setPrice(100);
        base.setTime("2015-11-12T15:06:15+0000");
        base.setType("nisse");
        base.setVolume(2985824);
        base.setYearHigh(5000);
        base.setYearLow(100);
        base.setSymbol("T");
        data.add(base);
        
        // 0
        base = new Stock();
        base.setChange(1.37);
        base.setChangePercent(3.47);
        base.setDayHigh(1000);
        base.setDayLow(500);
        base.setName("TESTSTOCK");
        base.setPrice(100);
        base.setTime("2015-11-12T15:06:15+0000");
        base.setType("nisse");
        base.setVolume(2985824);
        base.setYearHigh(5000);
        base.setYearLow(100);
        base.setSymbol("T");
        data.add(base);
        
        // 1
        base = new Stock();
        base.setChange(2.5);
        base.setChangePercent(3.47);
        base.setDayHigh(1000);
        base.setDayLow(500);
        base.setName("TESTSTOCK");
        base.setPrice(100);
        base.setTime("2015-11-12T15:06:15+0000");
        base.setType("nisse");
        base.setVolume(2985824);
        base.setYearHigh(5000);
        base.setYearLow(100);
        base.setSymbol("T");
        data.add(base);
        
        // 2
        base = new Stock();
        base.setChange(3.2);
        base.setChangePercent(3.8);
        base.setDayHigh(1000);
        base.setDayLow(500);
        base.setName("TESTSTOCK");
        base.setPrice(100);
        base.setTime("2015-11-12T15:06:15+0000");
        base.setType("nisse");
        base.setVolume(2985824);
        base.setYearHigh(5000);
        base.setYearLow(100);
        base.setSymbol("T");
        data.add(base);
        
        // 3
        base = new Stock();
        base.setChange(4.2);
        base.setChangePercent(5.6);
        base.setDayHigh(4856);
        base.setDayLow(500);
        base.setName("TESTSTOCK");
        base.setPrice(100);
        base.setTime("2015-11-12T15:06:15+0000");
        base.setType("nisse");
        base.setVolume(2985824);
        base.setYearHigh(5000);
        base.setYearLow(100);
        base.setSymbol("T");
        data.add(base);
        
        // 4
        base = new Stock();
        base.setChange(5.3);
        base.setChangePercent(5.0);
        base.setDayHigh(1234);
        base.setDayLow(123);
        base.setName("TESTSTOCK");
        base.setPrice(100);
        base.setTime("2015-11-12T15:06:15+0000");
        base.setType("nisse");
        base.setVolume(2985824);
        base.setYearHigh(5000);
        base.setYearLow(100);
        base.setSymbol("T");
        data.add(base);
        
        // 5
        base = new Stock();
        base.setChange(7.1);
        base.setChangePercent(6.0);
        base.setDayHigh(7485);
        base.setDayLow(888);
        base.setName("NUMBA FIVE");
        base.setPrice(100);
        base.setTime("2015-11-12T15:06:15+0000");
        base.setType("nisse");
        base.setVolume(2985824);
        base.setYearHigh(5000);
        base.setYearLow(100);
        base.setSymbol("T");
        data.add(base);
        
        // 6
        base = new Stock();
        base.setChange(6.5);
        base.setChangePercent(4.2);
        base.setDayHigh(6384);
        base.setDayLow(736);
        base.setName("NUMBA SEEKS");
        base.setPrice(600);
        base.setTime("2015-11-12T15:06:15+0000");
        base.setType("nisse");
        base.setVolume(2985824);
        base.setYearHigh(5000);
        base.setYearLow(100);
        base.setSymbol("T");
        data.add(base);
        
        // 7
        base = new Stock();
        base.setChange(3.2);
        base.setChangePercent(5.2);
        base.setDayHigh(2734);
        base.setDayLow(312);
        base.setName("NUMBA SIBEN");
        base.setPrice(700);
        base.setTime("2015-11-12T15:09:15+0000");
        base.setType("nisse");
        base.setVolume(2985824);
        base.setYearHigh(5000);
        base.setYearLow(100);
        base.setSymbol("T");
        data.add(base);
        
        // 8
        base = new Stock();
        base.setChange(9.1);
        base.setChangePercent(7.2);
        base.setDayHigh(3956);
        base.setDayLow(934);
        base.setName("NUMBA ÅTTE");
        base.setPrice(800);
        base.setTime("2015-11-12T15:10:15+0000");
        base.setType("otto");
        base.setVolume(2985824);
        base.setYearHigh(5000);
        base.setYearLow(100);
        base.setSymbol("T");
        data.add(base);
        
        // 9
        base = new Stock();
        base.setChange(4.3);
        base.setChangePercent(1.2);
        base.setDayHigh(8596);
        base.setDayLow(1000);
        base.setName("NUMBA NAIN");
        base.setPrice(900);
        base.setTime("2015-11-12T15:30:15+0000");
        base.setType("NINNI");
        base.setVolume(485756);
        base.setYearHigh(5000);
        base.setYearLow(100);
        base.setSymbol("T");
        data.add(base);
        
        // 10
        base = new Stock();
        base.setChange(10.2);
        base.setChangePercent(7.4);
        base.setDayHigh(2938);
        base.setDayLow(1123);
        base.setName("NUMBA TI");
        base.setPrice(1000);
        base.setTime("2015-11-12T15:30:31+0000");
        base.setType("TONN");
        base.setVolume(38495);
        base.setYearHigh(12834);
        base.setYearLow(100);
        base.setSymbol("T");
        data.add(base);
        
        // 11
        base = new Stock();
        base.setChange(7.6);
        base.setChangePercent(9.3);
        base.setDayHigh(5463);
        base.setDayLow(2102);
        base.setName("NUMBA RIVER");
        base.setPrice(3845);
        base.setTime("2015-11-12T20:30:31+0000");
        base.setType("RIVER");
        base.setVolume(74859);
        base.setYearHigh(27384);
        base.setYearLow(2000);
        base.setSymbol("T");
        data.add(base);
    }
    
    public String getData(int index) {
        JsonArrayBuilder ab = Json.createArrayBuilder();
        int x = index % data.size();
        for (int i = 0; i < 1000; i++) { 
            data.get(x).setSymbol("" + i);
            
            ab = ab.add(data.get(x).generateJson());
        }

        return Json.createObjectBuilder().add("resources", ab).build().toString();
    }
    
//    public StockTestGenerator() {
//        data = new ArrayList<>();
//        Stock base;
//        
//        // 1
//        base = new Stock();
//        base.setChange(1.37);
//        base.setChangePercent(3.47);
//        base.setDayHigh(1000);
//        base.setDayLow(500);
//        base.setName("TESTSTOCK");
//        base.setPrice(100);
//        base.setTime("2015-11-12T15:06:15+0000");
//        base.setType("nisse");
//        base.setVolume(2985824);
//        base.setYearHigh(5000);
//        base.setYearLow(100);
//        base.setSymbol("T");
//        data.add(base);
//        
//        // 2
//        base = new Stock();
//        base.setChange(2.5);
//        base.setChangePercent(6.7);
//        base.setDayHigh(1000);
//        base.setDayLow(500);
//        base.setName("TESTSTOCK");
//        base.setPrice(100);
//        base.setTime("2015-11-12T15:06:15+0000");
//        base.setType("nisse");
//        base.setVolume(2985824);
//        base.setYearHigh(5000);
//        base.setYearLow(100);
//        base.setSymbol("T");
//        data.add(base);
//        
//        // 3
//        base = new Stock();
//        base.setChange(2.5);
//        base.setChangePercent(6.7);
//        base.setDayHigh(1000);
//        base.setDayLow(500);
//        base.setName("TESTSTOCK");
//        base.setPrice(100);
//        base.setTime("2015-11-12T15:06:15+0000");
//        base.setType("nisse");
//        base.setVolume(2985824);
//        base.setYearHigh(5000);
//        base.setYearLow(100);
//        base.setSymbol("T");
//        data.add(base);
//        
//        // 4
//        base = new Stock();
//        base.setChange(2.5);
//        base.setChangePercent(6.7);
//        base.setDayHigh(1000);
//        base.setDayLow(500);
//        base.setName("TESTSTOCK");
//        base.setPrice(100);
//        base.setTime("2015-11-12T15:06:15+0000");
//        base.setType("nisse");
//        base.setVolume(2985824);
//        base.setYearHigh(5000);
//        base.setYearLow(100);
//        base.setSymbol("T");
//        data.add(base);
//        
//        // 5
//        base = new Stock();
//        base.setChange(3.1);
//        base.setChangePercent(8);
//        base.setDayHigh(1000);
//        base.setDayLow(500);
//        base.setName("TESTSTOCK");
//        base.setPrice(100);
//        base.setTime("2015-11-12T15:06:15+0000");
//        base.setType("nisse");
//        base.setVolume(2985824);
//        base.setYearHigh(5000);
//        base.setYearLow(100);
//        base.setSymbol("T");
//        data.add(base);      
//        
//        // 6
//        base = new Stock();
//        base.setChange(3.1);
//        base.setChangePercent(8);
//        base.setDayHigh(1000);
//        base.setDayLow(500);
//        base.setName("TESTSTOCK");
//        base.setPrice(100);
//        base.setTime("2015-11-12T15:06:15+0000");
//        base.setType("nisse");
//        base.setVolume(2985824);
//        base.setYearHigh(5000);
//        base.setYearLow(100);
//        base.setSymbol("T");
//        data.add(base);  
//        
//        // 7
//        base = new Stock();
//        base.setChange(3.1);
//        base.setChangePercent(8);
//        base.setDayHigh(1000);
//        base.setDayLow(500);
//        base.setName("TESTSTOCK");
//        base.setPrice(100);
//        base.setTime("2015-11-12T15:06:15+0000");
//        base.setType("nisse");
//        base.setVolume(2985824);
//        base.setYearHigh(5000);
//        base.setYearLow(100);
//        base.setSymbol("T");
//        data.add(base);  
//        
//        // 8
//        base = new Stock();
//        base.setChange(3.1);
//        base.setChangePercent(8);
//        base.setDayHigh(1000);
//        base.setDayLow(500);
//        base.setName("TESTSTOCK");
//        base.setPrice(100);
//        base.setTime("2015-11-12T15:06:15+0000");
//        base.setType("nisse");
//        base.setVolume(2985824);
//        base.setYearHigh(5000);
//        base.setYearLow(100);
//        base.setSymbol("T");
//        data.add(base);  
//        
//        // 9
//        base = new Stock();
//        base.setChange(2.245);
//        base.setChangePercent(4.463);
//        base.setDayHigh(462);
//        base.setDayLow(464);
//        base.setName("TESTSTOCK2");
//        base.setPrice(246);
//        base.setTime("2015-11-12T15:07:15+0000");
//        base.setType("hest");
//        base.setVolume(47458);
//        base.setYearHigh(4677);
//        base.setYearLow(1570);
//        base.setSymbol("T");
//        data.add(base);  
//        
//        // 10
//        base = new Stock();
//        base.setChange(2.245);
//        base.setChangePercent(4.463);
//        base.setDayHigh(462);
//        base.setDayLow(464);
//        base.setName("TESTSTOCK2");
//        base.setPrice(246);
//        base.setTime("2015-11-12T15:07:15+0000");
//        base.setType("hest");
//        base.setVolume(47458);
//        base.setYearHigh(4677);
//        base.setYearLow(1570);
//        base.setSymbol("T");
//        data.add(base); 
//        
//        // 11
//        base = new Stock();
//        base.setChange(2.245);
//        base.setChangePercent(4.463);
//        base.setDayHigh(462);
//        base.setDayLow(464);
//        base.setName("TESTSTOCK2");
//        base.setPrice(246);
//        base.setTime("2015-11-12T15:07:15+0000");
//        base.setType("hest");
//        base.setVolume(47458);
//        base.setYearHigh(4677);
//        base.setYearLow(1570);
//        base.setSymbol("T");
//        data.add(base); 
//        
//        // 12
//        base = new Stock();
//        base.setChange(2.245);
//        base.setChangePercent(4.463);
//        base.setDayHigh(462);
//        base.setDayLow(464);
//        base.setName("TESTSTOCK2");
//        base.setPrice(24624);
//        base.setTime("2015-11-12T15:07:15+0000");
//        base.setType("hest");
//        base.setVolume(47458);
//        base.setYearHigh(4677);
//        base.setYearLow(1570);
//        base.setSymbol("T");
//        data.add(base); 
//        
//        // 13
//        base = new Stock();
//        base.setChange(2.245);
//        base.setChangePercent(4.463);
//        base.setDayHigh(462);
//        base.setDayLow(464);
//        base.setName("TESTSTOCK2");
//        base.setPrice(24624);
//        base.setTime("2015-11-12T15:07:15+0000");
//        base.setType("hest");
//        base.setVolume(47458);
//        base.setYearHigh(4677);
//        base.setYearLow(1570);
//        base.setSymbol("T");
//        data.add(base); 
//        
//        // 14
//        base = new Stock();
//        base.setChange(2.245);
//        base.setChangePercent(4.463);
//        base.setDayHigh(462);
//        base.setDayLow(464);
//        base.setName("TESTSTOCK2");
//        base.setPrice(24624);
//        base.setTime("2015-11-12T15:07:15+0000");
//        base.setType("hest");
//        base.setVolume(47458);
//        base.setYearHigh(4677);
//        base.setYearLow(1570);
//        base.setSymbol("T");
//        data.add(base); 
//        
//        // 15
//        base = new Stock();
//        base.setChange(2.46);
//        base.setChangePercent(5.463);
//        base.setDayHigh(437);
//        base.setDayLow(478);
//        base.setName("TESTSTOCK3");
//        base.setPrice(333);
//        base.setTime("2015-11-12T15:07:19+0000");
//        base.setType("test");
//        base.setVolume(2852);
//        base.setYearHigh(29);
//        base.setYearLow(13);
//        base.setSymbol("T");
//        data.add(base); 
//        
//        // 16
//        base = new Stock();
//        base.setChange(8.4);
//        base.setChangePercent(13.2);
//        base.setDayHigh(437);
//        base.setDayLow(478);
//        base.setName("TESTSTOCK3");
//        base.setPrice(333);
//        base.setTime("2015-11-12T15:07:19+0000");
//        base.setType("test");
//        base.setVolume(2852);
//        base.setYearHigh(29);
//        base.setYearLow(13);
//        base.setSymbol("T");
//        data.add(base); 
//        
//        // 17
//        base = new Stock();
//        base.setChange(8.4);
//        base.setChangePercent(13.2);
//        base.setDayHigh(437);
//        base.setDayLow(478);
//        base.setName("TESTSTOCK3");
//        base.setPrice(333);
//        base.setTime("2015-11-12T15:07:19+0000");
//        base.setType("test");
//        base.setVolume(2852);
//        base.setYearHigh(29);
//        base.setYearLow(13);
//        base.setSymbol("T");
//        data.add(base); 
//        
//        // 18
//        base = new Stock();
//        base.setChange(3.1);
//        base.setChangePercent(8);
//        base.setDayHigh(437);
//        base.setDayLow(478);
//        base.setName("TESTSTOCK3");
//        base.setPrice(333);
//        base.setTime("2015-11-12T15:07:19+0000");
//        base.setType("test");
//        base.setVolume(2852);
//        base.setYearHigh(29);
//        base.setYearLow(13);
//        base.setSymbol("T");
//        data.add(base); 
//        
//        // 19
//        base = new Stock();
//        base.setChange(3.1);
//        base.setChangePercent(8);
//        base.setDayHigh(437);
//        base.setDayLow(478);
//        base.setName("TESTSTOCK3");
//        base.setPrice(333);
//        base.setTime("2015-11-12T15:07:19+0000");
//        base.setType("test");
//        base.setVolume(2852);
//        base.setYearHigh(29);
//        base.setYearLow(13);
//        base.setSymbol("T");
//        data.add(base); 
//        
//        // 20
//        base = new Stock();
//        base.setChange(7.436);
//        base.setChangePercent(8.436);
//        base.setDayHigh(45);
//        base.setDayLow(23);
//        base.setName("TESTSTOCK4");
//        base.setPrice(235);
//        base.setTime("2015-11-12T15:07:25+0000");
//        base.setType("fest");
//        base.setVolume(425);
//        base.setYearHigh(78);
//        base.setYearLow(23);
//        base.setSymbol("T");
//        data.add(base); 
//    }
}
