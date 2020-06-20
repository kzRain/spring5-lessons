package kz.cf.spring5.lesson3.service;

import kz.cf.spring5.lesson3.view.SingerSummary;

import java.util.List;

public interface SingerSummaryService {
    List<SingerSummary> findAll();
}
