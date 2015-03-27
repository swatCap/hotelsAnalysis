/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yasearcher;

/**
 *
 * @author margarita
 */
public class YaItem {

    private int position;
    private String url;
    private String domain;
    private String title;
    private String description = "";
    private String passages = "";

    /**
     * Constructor
     * @param url url of current item
     */
    public YaItem(final String url) {
        this.url = url;
    }

    /* Тут набор getter-ов для приватных полей класса... */

    public void setPosition(final int position) {
        this.position = position;
    }

    public String getUrl() {
        return url;
    }
    
    public void setDomain(final String domain) {
        this.domain = domain;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public void addPassage(final String passage) {
        passages += passage;
    }

    @Override
    public String toString() {
        return "YaItem{" +
            "position=" + position +
            ", url='" + url + '\'' +
            ", domain='" + domain + '\'' +
            ", title='" + title + '\'' +
            ", description='" + description + '\'' +
            ", passages='" + passages + '\'' +
            '}';
    }
}