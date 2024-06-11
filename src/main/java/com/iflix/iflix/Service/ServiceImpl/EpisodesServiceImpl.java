package com.iflix.iflix.Service.ServiceImpl;

import com.iflix.iflix.DAO.EpisodesRepository;
import com.iflix.iflix.DAO.MoviesRepository;
import com.iflix.iflix.DTO.Request.EpisodesRequest;
import com.iflix.iflix.DTO.Response.EpisodesResponse;
import com.iflix.iflix.Entities.Episodes;
import com.iflix.iflix.Entities.Movies;
import com.iflix.iflix.Mapper.EpisodesMapper;
import com.iflix.iflix.Service.EpisodesService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Service
public class EpisodesServiceImpl implements EpisodesService {
    @Autowired
    private MoviesRepository moviesRepository;

    @Autowired
    private EpisodesRepository episodesRepository;

    @Autowired
    private EpisodesMapper episodesMapper;

    @Override
    public EpisodesResponse getById(String id) {
        EpisodesResponse e = episodesMapper.toEpisodeResponse(episodesRepository.findById(id).get());
        return episodesMapper.toEpisodeResponse(episodesRepository.findById(id).get());
    }

    @Override
    public Page<EpisodesResponse> getEpisodes(String movieId, Pageable pageable) {
        return episodesRepository.findAllByMovie_Id(movieId,pageable).map(episodesMapper::toEpisodeResponse);
    }

    @Override
    public Page<EpisodesResponse> getEpisodesContains(int episodeNumber, Pageable pageable) {
        return episodesRepository.findAllByEpisodeNumber(episodeNumber, pageable).map(episodesMapper::toEpisodeResponse);
    }

    @Override
    public EpisodesResponse addEpisode(EpisodesRequest request) {
        Episodes episode = episodesMapper.toEpisode(request);

        Movies movie = moviesRepository.findById(request.getMovie().getId()).get();
        LocalDateTime localDateTime = LocalDateTime.of(LocalDate.now(), LocalTime.now());
        // Chuyển đổi LocalDateTime sang Timestamp
        Timestamp timestamp = Timestamp.valueOf(localDateTime);
        movie.setModifiedTime(timestamp);
        episode.setMovie(movie);

        return episodesMapper.toEpisodeResponse(episodesRepository.save(episode));
    }

    @Override
    @Transactional
    public EpisodesResponse updateEpisode(String episodeId, EpisodesRequest request) {
        Episodes episode = episodesRepository.findById(episodeId).get();
        episodesMapper.updateEpisode(episode, request);

        Movies movie = moviesRepository.findById(request.getMovie().getId()).get();
        LocalDateTime localDateTime = LocalDateTime.of(LocalDate.now(), LocalTime.now());
        // Chuyển đổi LocalDateTime sang Timestamp
        Timestamp timestamp = Timestamp.valueOf(localDateTime);
        movie.setModifiedTime(timestamp);
        episode.setMovie(movie);

        return episodesMapper.toEpisodeResponse(episodesRepository.saveAndFlush(episode));
    }

    @Override
    @Transactional
    public void deleteEpisode(String episodeId) {
        episodesRepository.deleteById(episodeId);
    }
}
