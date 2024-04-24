package com.example.day5cw3.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.day5cw3.model.dharshiniLanguage;
import com.example.day5cw3.repository.dharshiniLanguageRepo;

@Service
public class ChaturyaLanguageService {
    private dharshiniLanguageRepo languageRepo;
    public ChaturyaLanguageService(dharshiniLanguageRepo languageRepo)
    {
        this.languageRepo=languageRepo;
    }
    public boolean saveLanguage(dharshiniLanguage language)
    {
        try
        {
            languageRepo.save(language);

        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public List<dharshiniLanguage> getLanguages()
    {
        return languageRepo.findAll();
    }
    public boolean updateLanguage(int id,dharshiniLanguage language)
    {
        if(getLanguageById(id)==null)
        {
            return false;
        }
        try{
            languageRepo.save(language);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public boolean deleteLanguage(int id)
    {
        if(getLanguageById(id)==null)
        {
            return false;
        }
        languageRepo.deleteById(id);
        return true;
        
    }
    public dharshiniLanguage getLanguageById(int id)
    {
        return languageRepo.findById(id).orElse(null);
    }

}
