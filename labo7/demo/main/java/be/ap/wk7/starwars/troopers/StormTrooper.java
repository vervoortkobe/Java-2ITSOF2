package be.ap.wk7.starwars.troopers;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tblStormtrooper")
public class StormTrooper implements Comparable<StormTrooper> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "kolom_id")
    private Integer id;

    @Column(name = "kolom_name")
    private String name;

    @Column(name = "kolom_rank")
    @Enumerated
    private Rank rank;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "squad_id")
    private Squad squad;

    public StormTrooper() {

    }

    public StormTrooper(String name, Rank rank) {
        this.name = name;
        this.rank = rank;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "StormTrooper{" +
                "name='" + name + '\'' +
                ", rank=" + rank +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StormTrooper trooper = (StormTrooper) o;
        return Objects.equals(name, trooper.name) && rank == trooper.rank;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, rank);
    }

    @Override
    public int compareTo(StormTrooper o) {
        if (this.rank == Rank.SERGEANT && o.rank == Rank.TROOPER) {
            return -1;
        } else if(this.rank == Rank.TROOPER && o.rank == Rank.SERGEANT) {
            return 1;
        } else {
            return 0;
        }
    }
}
