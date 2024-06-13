package com.iflix.iflix.DAO.Specification;

import com.iflix.iflix.Entities.Movies;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import org.springframework.data.jpa.domain.Specification;

public class MoviesSpecifications {

    public static Specification<Movies> hasNameLike(String name) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.like(root.get("name"), "%" + name + "%");
    }

    public static Specification<Movies> hasGenre(String genre) {
        return (root, query, criteriaBuilder) -> {
            Join<Object, Object> join = root.join("movie_genres", JoinType.INNER)
                    .join("genre", JoinType.INNER);
            return criteriaBuilder.equal(join.get("name"), genre);
        };
    }

    public static Specification<Movies> hasCountry(String country) {
        return (root, query, criteriaBuilder) -> {
            Join<Object, Object> join = root.join("country", JoinType.INNER);
            return criteriaBuilder.equal(join.get("name"), country);
        };
    }

    public static Specification<Movies> hasCategory(String category) {
        return (root, query, criteriaBuilder) -> {
            Join<Object, Object> join = root.join("categories", JoinType.INNER);
            return criteriaBuilder.equal(join.get("name"), category);
        };
    }

    public static Specification<Movies> hasReleaseYear(int releaseYear) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("releaseYear"), releaseYear);
    }


}
