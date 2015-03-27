/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yasearchtypes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.xml.sax.SAXException;
import yasearcher.YaSearcher;

/**
 *
 * @author margarita
 */
public class Result {
    private final String user;
    private final String key;
    private List<HotelsQuery> hotels = new ArrayList<HotelsQuery>();
    private List<HotelInfo> content = new ArrayList();
    private final int timeout = 1000000;
    
    private void fillContent() {
        Document document;
        for (HotelsQuery hq: hotels) {
            try {
                String[] sites = YaSearcher.search(user, key, hq.generateQuery());
                for (int i = 0; i < 5; ++i) {
                    if (sites[i] != null) {
                        document = Jsoup.connect(sites[i]).timeout(timeout).get();
                        
                        HotelInfo hi = new HotelInfo();
                        hi.setName(hq.getName());
                        
                        switch (i) {
                            
                            case 0 :
                                hi.setSource("booking");
                                hi.setInfo(document.select("div[id=summary]").text());
                                break;
                                
                            case 1 :
                                hi.setSource("turpravda");
                                hi.setInfo(document.select("td[id=det_anc]").text());
                                break;
                                
                            case 2 :
                                hi.setSource("tripadvisor");
                                hi.setInfo(document.text());
                                break;
                                
                            case 3 :
                                hi.setSource("tophotels");
                                hi.setInfo(document.select("div[class=hotel-profile-full-info]").text());
                                break;
                                
                            case 4 :
                                hi.setSource("tury");
                                hi.setInfo(document.text());
                                break;
                        }
                        
                        content.add(hi);
                    }
                }
            } catch (IOException | SAXException ex) {
                Logger.getLogger(Result.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public List<HotelInfo> getContent() {
        if  (content == null) {
            fillContent();
        }
        return content;
    }

    public Result(String user, String key) {
        this.user = user;
        this.key = key;
    }

    public void setHotels(List<HotelsQuery> hotels) {
        this.hotels = hotels;
    }
    
    
}
