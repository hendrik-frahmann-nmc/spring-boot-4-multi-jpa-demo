package org.example.second;

import org.springframework.stereotype.Service;

@Service
public class SecondService {

    private final SecondRepository secondRepository;

    public SecondService(SecondRepository secondRepository) {
        this.secondRepository = secondRepository;
    }

}
