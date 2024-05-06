package com.iflix.iflix.Service.ServiceImpl;

import com.iflix.iflix.DAO.MoviesRepository;
import com.iflix.iflix.Entities.Movies;
import com.iflix.iflix.Service.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MoviesServiceImpl implements MoviesService {
    @Autowired
    private MoviesRepository moviesRepository;


    @Override
    public Movies getById(String id) {
        return moviesRepository.findById(id).get();
    }

    @Override
    public Movies addMovie(Movies movie) {
        return moviesRepository.save(movie);
    }

    @Override
    public Movies updateMovie(Movies movie) {
        return moviesRepository.saveAndFlush(movie);
    }

    @Override
    public void deleteMovie(Movies movie) {
        moviesRepository.delete(movie);
    }

    @Override
    public Page<Movies> findMovies(Pageable pageable) {
        return moviesRepository.findAll(pageable);
    }
}
