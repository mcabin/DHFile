package api.DHFile.Entities;

import jakarta.persistence.*;

@Entity @Table(name = "COUNTRY")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "COUNTRY_NAME")
    private String countryName;
    @Column(name = "FLAG_EMOJI")
    private String flagEmoji;
    @Column(name = "flagImgLink")
    private String flagImgLink;
    @Column(name = "COAT_OF_ARMS")
    private String coatOfArmsLink;
    public int getId() {
        return id;
    }

    
    public Country() {
    }


    public Country(String countryName, String flagEmoji, String flagImgLink, String coatOfArmsLink) {
        this.countryName = countryName;
        this.flagEmoji = flagEmoji;
        this.flagImgLink = flagImgLink;
        this.coatOfArmsLink = coatOfArmsLink;
    }


    public void setId(int id) {
        this.id = id;
    }
    public String getCountryName() {
        return countryName;
    }
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
    public String getFlagEmoji() {
        return flagEmoji;
    }
    public void setFlagEmoji(String flagEmoji) {
        this.flagEmoji = flagEmoji;
    }
    public String getFlagImgLink() {
        return flagImgLink;
    }
    public void setFlagImgLink(String flagImgLink) {
        this.flagImgLink = flagImgLink;
    }
    public String getCoatOfArmsLink() {
        return coatOfArmsLink;
    }
    public void setCoatOfArmsLink(String coatOfArmsLink) {
        this.coatOfArmsLink = coatOfArmsLink;
    }
    
}
