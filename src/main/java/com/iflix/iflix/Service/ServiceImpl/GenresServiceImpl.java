package com.iflix.iflix.Service.ServiceImpl;

import com.iflix.iflix.DAO.GenresRepository;
import com.iflix.iflix.DTO.Request.GenresRequest;
import com.iflix.iflix.DTO.Response.GenresResponse;
import com.iflix.iflix.Entities.Genres;
import com.iflix.iflix.Mapper.GenresMapper;
import com.iflix.iflix.Service.GenresService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class GenresServiceImpl implements GenresService {

    @Autowired
    private GenresRepository genresRepository;

    @Autowired
    private GenresMapper genresMapper;

    @Override
    public GenresResponse getById(String id) {
        return genresMapper.toGenresResponse(genresRepository.findById(id).get());
    }

    @Override
    public GenresResponse addGenres(GenresRequest request) {
        Genres genres = genresMapper.toGenres(request);

        return genresMapper.toGenresResponse(genresRepository.save(genres));
    }

    @Override
    public Page<GenresResponse> getGenres(Pageable pageable) {
        return genresRepository.findAll(pageable).map(genresMapper::toGenresResponse);
    }

    @Override
    public Page<GenresResponse> getGenresContains(String s, Pageable pageable) {
        return genresRepository.findByNameContainsIgnoreCase(s, pageable).map(genresMapper::toGenresResponse);
    }

    @Override
    @Transactional
    public GenresResponse updateGenres(String genresId, GenresRequest request) {
        Genres genres = genresRepository.findById(genresId).get();
        genresMapper.updateGenres(genres, request);

        return genresMapper.toGenresResponse(genresRepository.saveAndFlush(genres));
    }

    @Override
    public void deleteGenres(String genresId) {
        genresRepository.deleteById(genresId);
    }
}
