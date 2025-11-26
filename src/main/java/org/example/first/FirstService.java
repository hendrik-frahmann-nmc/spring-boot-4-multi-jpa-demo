package org.example.first;

import org.springframework.stereotype.Service;

@Service
public class FirstService {

    private final FirstRepository firstRepository;

    public FirstService(FirstRepository firstRepository) {
        this.firstRepository = firstRepository;
    }

}
