package com.iflix.iflix.DTO.Request;

import com.iflix.iflix.Entities.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EpisodesRequest {
    private String link;

    private String slug;

    private int episodeNumber;

    private String linkServer;

    private Movies movie;
}
