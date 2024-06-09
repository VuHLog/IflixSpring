package com.iflix.iflix.Service;

import com.iflix.iflix.DTO.Request.EpisodesRequest;
import com.iflix.iflix.DTO.Response.EpisodesResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EpisodesService {
    public Page<EpisodesResponse> getEpisodes(String movieId, Pageable pageable);

    public Page<EpisodesResponse> getEpisodesContains(int episodeNumber,Pageable pageable);
    public EpisodesResponse getById(String id);

    public EpisodesResponse addEpisode(EpisodesRequest request);

    public EpisodesResponse updateEpisode(String EpisodeId, EpisodesRequest request);

    public void deleteEpisode(String EpisodeId);
}
