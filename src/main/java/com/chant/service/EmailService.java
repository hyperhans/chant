package com.chant.service;

import com.chant.data.entity.Email;
import com.chant.repositories.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class EmailService {

    private EmailRepository repo;

    @Autowired
    public EmailService(EmailRepository repo) {
        this.repo = repo;
    }

    @Transactional
    public Email createNewEntity(Email em) {
        Email savedEm = repo.save(em);
        return savedEm;
    }

    @Transactional
    public Email findEntity(Long id) {
        return repo.findOne(id);
    }
}
