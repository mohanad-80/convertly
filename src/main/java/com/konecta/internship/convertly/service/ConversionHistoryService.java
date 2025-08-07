package com.konecta.internship.convertly.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.konecta.internship.convertly.model.ConversionRecord;

@Service
public class ConversionHistoryService {
    private final List<ConversionRecord> history = new ArrayList<>();

    public void addRecord(ConversionRecord record) {
        history.add(record);
    }

    public List<ConversionRecord> getHistory() {
        return history;
    }

    public void clearHistory() {
        history.clear();
    }
}

