package kz.cf.spring.lesson3.service;

import kz.cf.spring.lesson3.view.SingerSummary;

import java.util.List;

public interface SingerSummaryService {
    List<SingerSummary> findAll();
}
