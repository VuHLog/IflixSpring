package com.iflix.iflix.DTO.Response;

import com.iflix.iflix.Entities.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EpisodesResponse {
    private String id;

    private String slug;

    private String link;

    private int episodeNumber;

    private String linkServer;

    private Movies movie;
}
