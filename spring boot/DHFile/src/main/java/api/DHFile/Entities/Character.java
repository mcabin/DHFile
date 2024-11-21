package api.DHFile.Entities;
import jakarta.persistence.*;
@Entity
@Table(name="CHARA")
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String lastname;
    private String firstname;
    private int age;
    @Column(name = "PP_IMG_LINK")
    private String ppImgLink;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "STATISTIC_ID")
    private Statistic statistic;
    @OneToOne
    @JoinColumn(name="NATIONALITY_ID")
    private Country nationality;

    public Character(){
        this.statistic=new Statistic();
    }
    public Character( String lastname, String firstname, int age,String ppImgLink,Country nationality) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.age = age;
        this.ppImgLink=ppImgLink;
        this.nationality=nationality;
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public Statistic getStatistic() {
        return statistic;
    }
    public void setStatistic(Statistic statistic) {
        this.statistic = statistic;
    }
    public String getPpImgLink() {
        return ppImgLink;
    }
    public void setPpImgLink(String ppImgLink) {
        this.ppImgLink = ppImgLink;
    }
    public Country getNationality() {
        return nationality;
    }
    public void setNationality(Country nationality) {
        this.nationality = nationality;
    }
    

}
