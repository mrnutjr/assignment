package com.assignment.assignmenttest.webclient.model;

import lombok.Data;

import java.util.List;

@Data
public class RandomUserClientResponse {
    private List<ResultModel> results;
}
