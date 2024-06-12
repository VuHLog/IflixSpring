package com.iflix.iflix.DAO;

import com.iflix.iflix.Entities.Countries;
import com.iflix.iflix.Entities.Rates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RatesRepository extends JpaRepository<Rates, String> {

    @Query(value = "select rate from rates where user_id = :userId and movie_id =:movieId",nativeQuery = true)
    Rates findByUserIdAndMovieId(@Param("userId")String userId,@Param("movieId") String movieId);

    @Query(value = "select avg(rate) from rates where movie_id = :movieId",nativeQuery = true)
    long avgRateByMovie_Id(String movieId);


}