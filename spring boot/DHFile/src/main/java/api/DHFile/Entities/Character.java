package api.DHFile.Entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
@Entity
@Table(name="CHARA")
@Data
@Builder
@AllArgsConstructor
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
    @ManyToOne
    @JoinColumn(name="NATIONALITY_ID")
    private Country nationality;
    @ManyToOne
    @JoinColumn(name="USER_ID")
    private User user;
    public Character(){
        this.statistic=new Statistic();
    }
    public Character( String lastname, String firstname, int age,String ppImgLink,Country nationality,User user) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.age = age;
        this.ppImgLink=ppImgLink;
        this.nationality=nationality;
    }

    

}
