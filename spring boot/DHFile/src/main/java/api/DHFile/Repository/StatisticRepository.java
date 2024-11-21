package api.DHFile.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import api.DHFile.Entities.Statistic;
public interface StatisticRepository extends JpaRepository<Statistic,Integer>{
    
}
