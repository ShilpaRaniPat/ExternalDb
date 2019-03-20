package com.stackroute.ExternalDb.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class Items implements Serializable {


//    @JsonUnwrapped

    private  Owner owner;
    private int  score;
    private String link;
    private boolean is_answered;
    private String title;
    private long question_id;
    private List<String> tags;

}
