package com.phimtho.phimtho.Service.ServiceImpl;

import com.phimtho.phimtho.DAO.MoviesRepository;
import com.phimtho.phimtho.Entities.Movies;
import com.phimtho.phimtho.Service.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MoviesServiceImpl implements MoviesService {
    @Autowired
    private MoviesRepository moviesRepository;


    @Override
    public Movies findById(int id) {
        return moviesRepository.findById(id).get();
    }

    @Override
    public Movies addActor(Movies movie) {
        return moviesRepository.save(movie);
    }

    @Override
    public Movies updateActor(Movies movie) {
        return moviesRepository.saveAndFlush(movie);
    }

    @Override
    public void deleteBook(Movies movie) {
        moviesRepository.delete(movie);
    }

    @Override
    public Page<Movies> findMovies(Pageable pageable) {
        return moviesRepository.findAll(pageable);
    }
}
